package Vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import DAO.MaterialDAO;
import DAO.ProMatDAO;
import DAO.PropuestaDAO;
import modelos.Materiales;
import modelos.Propuesta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class gestionarPropuestas extends JPanel {
	private JTextField textField;
	private JTable table;
	private ArrayList<Propuesta> propuestas;
	private JButton btnejec;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public gestionarPropuestas(Propuesta x) {
		setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 130, 520, 116);
		add(scrollPane);
		
		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Origen","Autor","fecha", "descripcion", "motivacion", "titulo", "Categoria_id_categoria1", "numero_Propuesta"
			}
		);
		table.setModel(dataModel);
		scrollPane.setViewportView(table);
		cargarTabla(dataModel,x);
		
	
		
		
		
		
		textField = new JTextField();
		textField.setBounds(394, 66, 86, 20);
		add(textField);
		textField.setColumns(10);
		
	
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x.setEstado("Aceptada");
				PropuestaDAO pro=new PropuestaDAO();
				pro.actualizar(x, x.getNumPropuesta());
				ProMatDAO r=new ProMatDAO() ;
				r.añadir(x, Integer.valueOf((String) comboBox.getSelectedItem()));			
			
				
			}
		});
		btnNewButton.setBounds(63, 65, 89, 23);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Rechazada");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x.setEstado("Rechazada");
				x.setMotivoCance(textField.getText());
				PropuestaDAO pro=new PropuestaDAO();
				pro.actualizar(x, x.getNumPropuesta());
			}
		});
		btnNewButton_1.setBounds(295, 65, 89, 23);
		add(btnNewButton_1);
		
		MaterialDAO a=new MaterialDAO();
		String[] p = new String[a.consultaPro().size()];
		for(int i = 0; i < a.consultaPro().size(); i++)
		{
			p[i] = "" + a.consultaPro().get(i).getNumMaterial();
		}
		
		
		comboBox = new JComboBox(p);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setBounds(162, 65, 72, 22);
		add(comboBox);

	}
	
	
	
	private void cargarTabla(DefaultTableModel dataModel, Propuesta e) {
	dataModel.setRowCount(0);
	PropuestaDAO eDao = new PropuestaDAO();
	propuestas = eDao.consultaPro();

			Object[] fila = new Object[] {e.getOrigen(),e.getAutor(),e.getFecha(),e.getDescripcion(),e.getMotivo(),e.getTitulo(),e.getCategoria(),e.getNumPropuesta()};
			dataModel.addRow(fila);		
}

	
}
