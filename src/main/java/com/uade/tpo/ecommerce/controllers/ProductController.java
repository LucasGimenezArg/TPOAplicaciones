package com.uade.tpo.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.ecommerce.dto.ProductDto;
import com.uade.tpo.ecommerce.dto.ProductListDto;
import com.uade.tpo.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/producto")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/list") ResponseEntity<ProductListDto> getProductList() throws Exception{
		
		ProductListDto listaProductos = productService.getProductsList();
		
		return ResponseEntity.ok(listaProductos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) throws Exception {

		ProductDto product = productService.getProductById(id);
		return ResponseEntity.ok(product);

	}
	
	@PostMapping("/add")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        ProductDto newProduct = productService.addProduct(productDto);
        return ResponseEntity.ok(newProduct);
    }
}
