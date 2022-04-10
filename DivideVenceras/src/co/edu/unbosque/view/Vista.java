package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class Vista{
	
	private Menu menu;
	private VentanaK ventK;
	private VentanaM ventM;
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public Vista() {
		menu = new Menu();
		ventK = new VentanaK();
		ventM = new VentanaM();
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

	public VentanaM getVentM() {
		return ventM;
	}

	public void setVentM(VentanaM ventM) {
		this.ventM = ventM;
	}	
}
