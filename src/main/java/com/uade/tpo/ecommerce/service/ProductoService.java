package com.uade.tpo.ecommerce.service;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.tpo.ecommerce.dto.ProductoDto;
import com.uade.tpo.ecommerce.dto.AltaProductoDto;
import com.uade.tpo.ecommerce.dto.ListaProductosDto;
import com.uade.tpo.ecommerce.model.Categoria;
import com.uade.tpo.ecommerce.model.Producto;
import com.uade.tpo.ecommerce.repository.CategoriaRepository;
import com.uade.tpo.ecommerce.repository.ProductoRepository;

@Service
public class ProductoService {
	private int MAX_DESC_LENGTH = 20;
	private int MAX_INFO_LENGTH = 100;
	
	private final ProductoRepository productoRepository;
	private final CategoriaRepository categoriaRepository;
	
	@Autowired
    public ProductoService(ProductoRepository productRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productRepository;
        this.categoriaRepository = categoriaRepository;
    }
	
	public ListaProductosDto getProductsList() throws Exception{
			List<Producto> productos = productoRepository.findAll();
			return new ListaProductosDto(productos);
	}

	public ListaProductosDto getProductsListFilterCategory(Long categoriaId) throws Exception{
		Optional<Categoria> cat = categoriaRepository.findById(categoriaId);
		if(!cat.isPresent()) {
			throw new RuntimeException("No existe categoria con el ID:" + categoriaId);
		}

		List<Producto> productos = productoRepository.findByCategoria(cat.get());
		return new ListaProductosDto(productos);
	}
	
	public ProductoDto getProductById(Long id) throws Exception{
		Producto producto = productoRepository.findById(id).orElseThrow(() -> new Exception("Error buscando producto por id"));
		return producto.toDto();
	}

	@Transactional
	public ProductoDto addProduct(AltaProductoDto productoAlta) {
		if(productoAlta.getDescripcion().length() > MAX_DESC_LENGTH) {
			throw new RuntimeException("La descripcion del producto no puede contener mas de " + MAX_DESC_LENGTH + " caracteres");
		}
		if(productoAlta.getInformacion().length() > MAX_INFO_LENGTH) {
			throw new RuntimeException("La informacion del producto no puede contener mas de " + MAX_INFO_LENGTH + " caracteres");
		}
		
		Producto producto = productoAlta.toEntity();
		Optional<Categoria> cat = categoriaRepository.findById(productoAlta.getCategoriaId());
		
		if(!cat.isPresent()) {
			throw new RuntimeException("No existe categoria con el ID:" + productoAlta.getCategoriaId());
		}
		
		producto.setCategoria(cat.get());
		productoRepository.save(producto);  
		return producto.toDto();
	}

	public Categoria addCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
}
