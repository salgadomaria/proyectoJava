package Vistas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import DAO.MaterialDAO;
import DAO.ProMatDAO;
import DAO.PropuestaDAO;
import modelos.Materiales;
import modelos.MaterialesIntitucionales;
import modelos.MaterialesPropuesta;
import modelos.Propuesta;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JList;

public class crearMaterial extends JPanel {
	private JTextField txtTit;
	private JTextField txtDes;
	private JTextField txtCat;
	private JTextField txtRef;
	private JTextField txtFue;
	private JTextField txtEnl;
	private JRadioButton Insti;
	private JTextField txtNum;
	private JButton Crear;
	private JButton Modificar;

	/**
	 * Create the panel.
	 */
	public crearMaterial() {
		setLayout(null);
				
		txtTit = new JTextField();
		txtTit.setText("Titulo");
		txtTit.setBounds(24, 11, 86, 20);
		add(txtTit);
		txtTit.setColumns(10);
		
		txtDes = new JTextField();
		txtDes.setText("Descripci\u00F3n");
		txtDes.setBounds(24, 56, 86, 20);
		add(txtDes);
		txtDes.setColumns(10);
		
		txtCat = new JTextField();
		txtCat.setText("Categor\u00EDa");
		txtCat.setBounds(24, 103, 86, 20);
		add(txtCat);
		txtCat.setColumns(10);
		
		JRadioButton Priori = new JRadioButton("Prioritario");
		Priori.setEnabled(false);
		Priori.setBounds(311, 68, 109, 23);
		add(Priori);
		
		txtRef = new JTextField();
		txtRef.setEnabled(false);
		txtRef.setBounds(321, 103, 86, 20);
		add(txtRef);
		txtRef.setColumns(10);
		
		txtFue = new JTextField();
		txtFue.setText("Fuente");
		txtFue.setBounds(129, 11, 86, 20);
		add(txtFue);
		txtFue.setColumns(10);
		
		txtEnl = new JTextField();
		txtEnl.setText("Enlace");
		txtEnl.setBounds(129, 56, 86, 20);
		add(txtEnl);
		txtEnl.setColumns(10);
		
		Insti = new JRadioButton("Institucional");
		Insti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Insti.isSelected()) {
					Priori.setEnabled(true);
					txtRef.setEnabled(true);	}
				else {
					txtRef.setText("");
					Priori.setSelected(false);
					Priori.setEnabled(false);
					txtRef.setEnabled(false);
				}
			}
		});
		
		
		Insti.setBounds(311, 22, 109, 23);
		add(Insti);
		
		txtNum = new JTextField();
		txtNum.setText("Num Material");
		txtNum.setBounds(129, 103, 86, 20);
		add(txtNum);
		txtNum.setColumns(10);
		
		Crear = new JButton("Crear");
		Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterialDAO a = new MaterialDAO();
				
			    if(Insti.isSelected()) {
			    	MaterialesIntitucionales b = new MaterialesIntitucionales();
					b.setTitulo(txtTit.getText());
					b.setCategoria(Integer.valueOf(txtCat.getText()));
					b.setFuente(txtFue.getText());
					b.setEnlace(txtEnl.getText());
					b.setNumMaterial(Integer.valueOf(txtNum.getText()));
				    b.setDescripcion(txtDes.getText());
				    if(Priori.isSelected())
				    	b.setPrioritario(1);
				    else b.setPrioritario(0);			    	
			    	b.setProcedencia(txtRef.getText());
			    	a.añadirint(b);
			    }
			    else {
			    	MaterialesPropuesta b=new MaterialesPropuesta();
			    	b.setTitulo(txtTit.getText());
					b.setCategoria(Integer.valueOf(txtCat.getText()));
					b.setFuente(txtFue.getText());
					b.setEnlace(txtEnl.getText());
					b.setNumMaterial(Integer.valueOf(txtNum.getText()));
				    b.setDescripcion(txtDes.getText());
			    	b.setPrioritario(b.esPrioritario());
			    	a.añadir(b);
			    }
			    
			    
			}
		});
		Crear.setBounds(51, 194, 89, 23);
		add(Crear);
		
		
		Modificar = new JButton("Modificar");
		Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterialesIntitucionales b = new MaterialesIntitucionales();
				MaterialesPropuesta a= new MaterialesPropuesta();
				MaterialDAO n=new MaterialDAO();
				if(Insti.isSelected())
				{
					b.setTitulo(txtTit.getText());
					b.setCategoria(Integer.valueOf(txtCat.getText()));
					b.setFuente(txtFue.getText());
					b.setEnlace(txtEnl.getText());
					b.setNumMaterial(Integer.valueOf(txtNum.getText()));
				    b.setDescripcion(txtDes.getText());
				    if(Priori.isSelected())
				    	b.setPrioritario(1);
				    else b.setPrioritario(0);			    	
			    	b.setProcedencia(txtRef.getText());
					n.actualizarint(b, b.getNumMaterial());
				}
				else
				{
					ProMatDAO x = new ProMatDAO();
					a.setTitulo(txtTit.getText());
					a.setCategoria(Integer.valueOf(txtCat.getText()));
					a.setFuente(txtFue.getText());
					a.setEnlace(txtEnl.getText());
					a.setNumMaterial(Integer.valueOf(txtNum.getText()));
					a.setDescripcion(txtDes.getText());
					a.setPrioritario(a.esPrioritario());
					n.actualizar(a,Integer.valueOf(txtNum.getText() ));
				}
			}
		});
		Modificar.setBounds(174, 194, 89, 23);
		add(Modificar);
		
	}
}
