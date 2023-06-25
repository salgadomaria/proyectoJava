package modelos;

import java.awt.geom.Rectangle2D.Float;
import java.util.ArrayList;

public class Jornadas {
	
	public Jornadas(String referente,String objetivo, String titulo,boolean prioridad, int numJor) {
		this.referente=referente;
		this.objetivo=objetivo;
		this.titulo=titulo;
		this.prioridad=prioridad;
		this.numJor=numJor;
	}
	
	private ArrayList<Materiales> mate=new ArrayList<Materiales>();
	private String referente;
	private String objetivo;
	private String titulo;
	private int numJor;
	
	public int getNumJor() {
		return numJor;
	}

	public void setNumJor(int numJor) {
		this.numJor = numJor;
	}

	private boolean prioridad=priori();
			
	public boolean priori() {
		float aux=0;
		for(Materiales x: mate) {
			if(x.isPrioritario()==1)
				aux=aux+1;
		}
		if(aux>=(mate.size()/2f))
		{
			return true;
		}
		else
			return false;
	}

	public ArrayList<Materiales> getMate() {
		return mate;
	}

	public void setMate(ArrayList<Materiales> mate) {
		this.mate = mate;
	}

	public String getReferente() {
		return referente;
	}

	public void setReferente(String referente) {
		this.referente = referente;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isPrioridad() {
		return prioridad;
	}

	public void setPrioridad(boolean prioridad) {
		this.prioridad = prioridad;
	}
}
