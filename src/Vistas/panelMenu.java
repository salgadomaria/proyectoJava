package Vistas;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelMenu() {
		setBackground(new Color(224, 255, 255));
		setForeground(Color.WHITE);
		setLayout(null);
		
		JButton btn_pro = new JButton("Gestionar Propuestas");
		btn_pro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = 
						(JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new Propuestas());
				marco.validate();
			}
		});
		btn_pro.setBounds(138, 104, 149, 23);
		add(btn_pro);
		
		JButton btnNewButton_2 = new JButton("Gestionar Materiales");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = 
						(JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new gestionarMateriales());
				marco.validate();
			}
		});
		btnNewButton_2.setBounds(139, 155, 148, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Gestionar Jornadas");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = 
						(JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new gestionarJornadas());
				marco.validate();
			}
		});
		btnNewButton_3.setBounds(139, 203, 148, 23);
		add(btnNewButton_3);

	}
}
