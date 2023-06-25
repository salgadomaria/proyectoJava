package modelos;

public class Propuesta {

 public int getCategoria() {
	return categoria;
}

public void setCategoria(int categoria) {
	this.categoria = categoria;
}

 public String getOrigen() {
	return origen;
}

public void setOrigen(String origen) {
	this.origen = origen;
}

public String getAutor() {
	return autor;
}

public void setAutor(String autor) {
	this.autor = autor;
}

public String getFecha() {
	return fecha;
}

public void setFecha(String fecha) {
	this.fecha = fecha;
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

public String getMotivo() {
	return motivo;
}

public void setMotivo(String motivo) {
	this.motivo = motivo;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public String getMotivoCance() {
	return motivoCance;
}

public void setMotivoCance(String motivoCance) {
	this.motivoCance = motivoCance;
}

public int getNumPropuesta() {
	return numPropuesta;
}

public void setNumPropuesta(int numPropuesta) {
	this.numPropuesta = numPropuesta;
}

private String origen;
private int categoria; // ej: acoso escolar - violencia - discriminacion - sexualidad - etc.
private String autor;
 private String fecha; // Formato: AA-MM-DD
 private String titulo;
 private String descripcion;
 private String motivo;
 private String estado="Pendiente";
 private String motivoCance;
 private int numPropuesta;
 
 public Propuesta(String origen,String autor,String fecha,String descripcion,String motivo, String titulo,String estado,int categoria,int numPropuesta){
	 this.origen=origen;
	 this.autor=autor;
	 this.fecha=fecha;
	 this.descripcion=descripcion;
	 this.motivo=motivo;
	 this.titulo = titulo;
	 this.estado=estado;
	 this.categoria=categoria;
	 this.numPropuesta= numPropuesta;
 }

}
