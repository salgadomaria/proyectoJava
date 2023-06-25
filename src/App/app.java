package App;

import javax.swing.JFrame;

import Vistas.panelMenu;


public class app {

	public static void main(String[] args) {
		JFrame marco= new JFrame();
		marco.setBounds(0,0,900,600);
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setContentPane(new panelMenu());
		marco.validate();
		
	}

}
