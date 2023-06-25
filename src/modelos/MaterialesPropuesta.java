package modelos;

import java.util.ArrayList;

public class MaterialesPropuesta extends Materiales{
	private ArrayList<Propuesta> pro=new ArrayList<Propuesta>();
		
	private int prioritario = esPrioritario();
	
	public int esPrioritario() {
		int aux=0;
		for(Propuesta x:pro) {
			if(getCategoria()==x.getCategoria()) {
				aux=aux+1;
			}
		}
		if(aux>=4) {
			return 1;
		}
		else return 0;
	}
}
