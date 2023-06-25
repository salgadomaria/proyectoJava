package Vistas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import DAO.ProMatDAO;
import DAO.PropuestaDAO;
import modelos.Propuesta;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class crearPropuesta extends JPanel {
	private JTextField txtorigen;
	private JTextField txtautor;
	private JTextField txtfecha;
	private JTextField txtdesc;
	private JTextField txtmotiv;
	private JTextField txttitulo;
	private JTextField txtcateg;
	private JTextField txtnumP;

	/**
	 * Create the panel.
	 */
	public crearPropuesta() {
		
			
		setLayout(null);
		
		txtorigen = new JTextField();
		txtorigen.setText("Origen");
		txtorigen.setToolTipText("");
		txtorigen.setBounds(29, 34, 86, 20);
		add(txtorigen);
		txtorigen.setColumns(10);
		
		txtautor = new JTextField();
		txtautor.setText("Autor");
		txtautor.setBounds(29, 74, 86, 20);
		add(txtautor);
		txtautor.setColumns(10);
		
		txtfecha = new JTextField();
		txtfecha.setText("Fecha");
		txtfecha.setBounds(29, 125, 86, 20);
		add(txtfecha);
		txtfecha.setColumns(10);
		
		txtdesc = new JTextField();
		txtdesc.setText("Descripci\u00F3n");
		txtdesc.setBounds(29, 175, 86, 20);
		add(txtdesc);
		txtdesc.setColumns(10);
		
		txtmotiv = new JTextField();
		txtmotiv.setText("Motivaci\u00F3n");
		txtmotiv.setBounds(274, 34, 86, 20);
		add(txtmotiv);
		txtmotiv.setColumns(10);
		
		txttitulo = new JTextField();
		txttitulo.setText("T\u00EDtulo");
		txttitulo.setBounds(274, 74, 86, 20);
		add(txttitulo);
		txttitulo.setColumns(10);
		
		txtcateg = new JTextField();
		txtcateg.setText("Categor\u00EDa");
		txtcateg.setBounds(274, 125, 86, 20);
		add(txtcateg);
		txtcateg.setColumns(10);
		
		txtnumP = new JTextField();
		txtnumP.setText("N\u00FAmero de Propuesta");
		txtnumP.setBounds(274, 175, 86, 20);
		add(txtnumP);
		txtnumP.setColumns(10);
		
			
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ventanas");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new panelMenu());
				marco.validate();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Propuestas");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Materiales");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Jornadas");
		mnNewMenu.add(mntmNewMenuItem_3);
		
	
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Propuesta m=new Propuesta(txtorigen.getText(),txtautor.getText(),txtfecha.getText(),txtdesc.getText(),txtmotiv.getText(),txttitulo.getText(),"Pendiente",Integer.valueOf(txtcateg.getText()),Integer.valueOf(txtnumP.getText()));
				PropuestaDAO n=new PropuestaDAO();
				n.añadir(m);				
			}
		});
		btnNewButton.setBounds(117, 238, 149, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Propuesta m=new Propuesta(txtorigen.getText(),txtautor.getText(),txtfecha.getText(),txtdesc.getText(),txtmotiv.getText(),txttitulo.getText(),"Pendiente",Integer.valueOf(txtcateg.getText()),Integer.valueOf(txtnumP.getText()));
				PropuestaDAO n=new PropuestaDAO();
				n.actualizar(m, m.getNumPropuesta());	
			}
		});
		btnNewButton_1.setBounds(148, 204, 89, 23);
		add(btnNewButton_1);

	}
	

}
