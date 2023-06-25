package modelos;

public class MaterialesIntitucionales extends Materiales{
	private String procedencia; 
	private int prioritario;
	
	public void setProcedencia(String pro) {
		procedencia=pro;
	}
	public String getProcedencia() {
		return procedencia;
	}
	
	public void setPrioridad(int pri) {
		prioritario=pri;
	}
	public int getPrioridad() {
		return prioritario;
	}
	
}
