package com.uade.tpo.ecommerce.dto;

import java.util.ArrayList;

import com.uade.tpo.ecommerce.model.Producto;

public class AltaProductoDto {
	private String descripcion;
	private int stock;
	private double precio;
	private Long categoriaId;
	private String informacion;
	private ArrayList<String> direccionImagenes;
	
	public AltaProductoDto(String descripcion, int stock, double precio, Long categoria, String informacion,
			ArrayList<String> direccionImagenes) {
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.categoriaId = categoria;
		this.informacion = informacion;
		this.direccionImagenes = direccionImagenes;
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

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
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
		return new Producto(null, this.descripcion, this.stock, this.precio, null, this.informacion, this.direccionImagenes);
	}

}
