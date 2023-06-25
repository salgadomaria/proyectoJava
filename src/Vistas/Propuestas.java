package Vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import DAO.PropuestaDAO;
import modelos.Propuesta;

public class Propuestas extends JPanel {
	private JTextField txtnum;
	private JTable table;
	private ArrayList<Propuesta> propuestas;
	JFrame marco= new JFrame();
	/**
	 * Create the panel.
	 */
	public Propuestas() {
		setLayout(null);
		
		PropuestaDAO aux=new PropuestaDAO();
		
		String[] a = new String[aux.consultaPro().size()];
		for(int i = 0; i<aux.consultaPro().size(); i++)
		{
			a[i] = "" + (aux.consultaPro().get(i).getNumPropuesta());
		}
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PropuestaDAO m=new PropuestaDAO();
				m.borrar(Integer.valueOf(txtnum.getText()));
				JFrame marco = 	(JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new Propuestas());
				marco.validate();
			}
		});
		btnNewButton_2.setBounds(67, 33, 89, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Crear - modificar propuesta");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = 
						(JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new crearPropuesta());
				marco.validate();
			}
		});
		btnNewButton_3.setBounds(360, 33, 189, 23);
		add(btnNewButton_3);
		
		txtnum = new JTextField();
		txtnum.setBounds(220, 34, 86, 20);
		add(txtnum);
		txtnum.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 130, 578, 159);
		add(scrollPane);
		
		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Origen","Autor","fecha", "decripcion", "motivacion", "titulo","estado", "Categoria_id_categoria1", "numero_Propuesta"
			}
		);
		table.setModel(dataModel);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Ver Detalles");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = 
						(JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new gestionarPropuestas(obtenerSeleccionado()));
				marco.validate();
			}
		});
		btnNewButton.setBounds(217, 84, 89, 23);
		add(btnNewButton);
		cargarTabla(dataModel);
		
	}
	private void cargarTabla(DefaultTableModel dataModel) {
		dataModel.setRowCount(0);
		PropuestaDAO eDao = new PropuestaDAO();
		propuestas = eDao.consultaPro();
		for (Propuesta e : propuestas) {
			
				Object[] fila = new Object[] {e.getOrigen(),e.getAutor(),e.getFecha(),e.getDescripcion(),e.getMotivo(),e.getTitulo(),e.getEstado(),e.getCategoria(),e.getNumPropuesta()};
				dataModel.addRow(fila);
			
		}
	}
	
	private Propuesta obtenerSeleccionado() {
		int filaSeleccionada = table.getSelectedRow();
		return propuestas.get(filaSeleccionada);
	}
}
