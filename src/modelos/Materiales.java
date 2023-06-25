package modelos;

import java.util.ArrayList;

public class Materiales {

	private int numMaterial;
	public int getNumMaterial() {
		return numMaterial;
	}
	public void setNumMaterial(int numMaterial) {
		this.numMaterial = numMaterial;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFuente() {
		return fuente;
	}
	public void setFuente(String fuente) {
		this.fuente = fuente;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	private String titulo;
	private int categoria;
	private String descripcion;
	private String fuente;
	private String enlace;
	private int prioritario;
	public int getCategoria() {
		return categoria;
	}
	public int isPrioritario() {
		return prioritario;
	}
	public void setPrioritario(int prioritario) {
		this.prioritario = prioritario;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
}
