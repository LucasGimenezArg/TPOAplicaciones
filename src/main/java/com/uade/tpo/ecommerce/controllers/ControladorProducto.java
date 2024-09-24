package com.uade.tpo.ecommerce.controllers;

import com.uade.tpo.ecommerce.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.ecommerce.dto.ProductoDto;
import com.uade.tpo.ecommerce.dto.AltaProductoDto;
import com.uade.tpo.ecommerce.dto.ListaProductosDto;
import com.uade.tpo.ecommerce.service.ProductoService;

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

	@PostMapping("/categoria/add")
	public ResponseEntity<?> addCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.ok(productoService.addCategoria(categoria));
	}


}
