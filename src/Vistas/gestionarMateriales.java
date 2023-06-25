package Vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import DAO.MaterialDAO;
import DAO.PropuestaDAO;
import modelos.Materiales;
import modelos.Propuesta;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gestionarMateriales extends JPanel {
	private JTextField txtNum;
	private JTable table;
	private ArrayList<Materiales> materials;
	/**
	 * Create the panel.
	 */
	public gestionarMateriales() {
		setLayout(null);
		
		txtNum = new JTextField();
		txtNum.setBounds(149, 43, 86, 20);
		add(txtNum);
		txtNum.setColumns(10);
		
		JButton btnelim = new JButton("Eliminar");
		btnelim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterialDAO f = new MaterialDAO();
				f.borrar(Integer.valueOf(txtNum.getText()));
				JFrame marco = 	(JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new gestionarMateriales());
				marco.validate();
			}
		});
		btnelim.setBounds(23, 42, 89, 23);
		add(btnelim);
		
		JButton btnNewButton_1 = new JButton("Crear - Modificar Materiales");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = 
						(JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new crearMaterial());
				marco.validate();
			}
		});
		btnNewButton_1.setBounds(257, 42, 172, 23);
		add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 130, 578, 159);
		add(scrollPane);
		
		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "Descripcion", "Fuente", "Enlace", "Categoria", "Num. Propuesta"
			}
		);
		table.setModel(dataModel);
		scrollPane.setViewportView(table);
		cargarTabla(dataModel);

	}
	private void cargarTabla(DefaultTableModel dataModel) {
		dataModel.setRowCount(0);
		MaterialDAO eDao = new MaterialDAO();
		materials = eDao.consultaPro();
		for (Materiales e : materials) {
			
				Object[] fila = new Object[] {e.getTitulo(), e.getDescripcion(), e.getFuente(),e.getEnlace(),e.getCategoria(),e.getNumMaterial()};
				dataModel.addRow(fila);
			
		}
	}
}
