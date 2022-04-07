package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class Vista {
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public String leerDatos(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}
}
