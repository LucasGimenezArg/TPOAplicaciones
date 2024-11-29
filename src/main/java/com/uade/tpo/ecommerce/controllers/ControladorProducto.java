package com.uade.tpo.ecommerce.controllers;

import com.uade.tpo.ecommerce.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uade.tpo.ecommerce.dto.ProductoDto;
import com.uade.tpo.ecommerce.dto.AltaProductoDto;
import com.uade.tpo.ecommerce.dto.ListaProductosDto;
import com.uade.tpo.ecommerce.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ControladorProducto {

	private final ProductoService productoService;

	@Autowired
	public ControladorProducto(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping("/list") ResponseEntity<ListaProductosDto> getProductList() throws Exception{
		
		ListaProductosDto listaProductos = productoService.getProductsList();
		
		return ResponseEntity.ok(listaProductos);
	}

	@GetMapping("/list/{categoria}") ResponseEntity<ListaProductosDto> getProductsListFilterCategory(@PathVariable Long categoria) throws Exception{

		ListaProductosDto listaProductos = productoService.getProductsListFilterCategory(categoria);

		return ResponseEntity.ok(listaProductos);
	}

	@GetMapping("/destacados") ResponseEntity<ListaProductosDto> getProductsTopTen() throws Exception{

		ListaProductosDto listaProductos = productoService.getProductsTopTen();

		return ResponseEntity.ok(listaProductos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductoDto> getProduct(@PathVariable Long id) throws Exception {

		ProductoDto producto = productoService.getProductById(id);
		return ResponseEntity.ok(producto);

	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody AltaProductoDto productoAlta) {
		try {
			ProductoDto nuevoProducto = productoService.addProduct(productoAlta);
		    return ResponseEntity.ok(nuevoProducto);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
    }

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody AltaProductoDto productoAlta){
		try{
			ProductoDto producto = productoService.updateProduct(id, productoAlta);
			return ResponseEntity.ok(producto);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id){
		try{
			productoService.deleteProduct(id);
			return ResponseEntity.ok("OK");
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> listCategorias() throws Exception{
		return ResponseEntity.ok(productoService.getCategorias());
	}

	@PostMapping("/categoria/add")
	public ResponseEntity<?> addCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.ok(productoService.addCategoria(categoria));
	}
}
