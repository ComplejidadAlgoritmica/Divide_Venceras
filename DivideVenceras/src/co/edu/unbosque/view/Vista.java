package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class Vista{
	
	private Menu menu;
	private VentanaK ventK;
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public String leerDatos(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}
	
	public Vista() {
		menu = new Menu();
		ventK = new VentanaK();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public VentanaK getVentK() {
		return ventK;
	}

	public void setVentK(VentanaK ventK) {
		this.ventK = ventK;
	}
	
	
}
