package com.uade.tpo.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.uade.tpo.ecommerce.model.Producto;

public class ListaProductosDto {
	List<Producto> productos = new ArrayList<Producto>();

	public ListaProductosDto(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
}
