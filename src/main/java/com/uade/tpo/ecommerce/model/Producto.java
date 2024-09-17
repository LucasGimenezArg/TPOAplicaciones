package com.uade.tpo.ecommerce.model;

import java.util.ArrayList;

import com.uade.tpo.ecommerce.dto.ProductoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	@Column(nullable = false, unique = true)
	private int stock;
	@Column(nullable = false, unique = true)
	private double precio;
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;
	private String informacion;
	private ArrayList<String> direccionImagenes;

	public Producto() {
	}

	public Producto(Long id, String descripcion, int stock, double precio, Categoria categoria, String informacion,
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

	public ProductoDto toDto() {
		return new ProductoDto(this.id, this.descripcion, this.stock, this.precio, this.categoria, this.informacion,
				this.direccionImagenes);
	}
}
