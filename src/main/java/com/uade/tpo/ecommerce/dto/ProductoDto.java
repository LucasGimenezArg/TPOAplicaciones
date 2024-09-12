package com.uade.tpo.ecommerce.dto;

import java.util.ArrayList;

import com.uade.tpo.ecommerce.model.Categoria;
import com.uade.tpo.ecommerce.model.Producto;

public class ProductoDto {
	private Long id;
	private String descripcion;
	private int stock;
	private double precio;
	private Categoria categoria;
	private String informacion;
	private ArrayList<String> direccionImagenes;
	
	public ProductoDto(Long id, String descripcion, int stock, double precio, Categoria categoria, String informacion,
			ArrayList<String> direccionImagenes) {
		this.id = id;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.categoria = categoria;
		this.informacion = informacion;
		this.direccionImagenes = direccionImagenes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public ArrayList<String> getDireccionImagenes() {
		return direccionImagenes;
	}

	public void setDireccionImagenes(ArrayList<String> direccionImagenes) {
		this.direccionImagenes = direccionImagenes;
	}
	
	public Producto toEntity() {
		return new Producto(this.id, this.descripcion, this.stock, this.precio, this.categoria, this.informacion, this.direccionImagenes);
	}
}
