package co.edu.unbosque.view;

import javax.swing.JOptionPane;
/**
 * Clase que crea objetos de todas las clases del paquete co.edu.unbosque.view
 * @author Santiago Flórez
 * @author Jorge Garcia
 *
 */
public class Vista{
	/**
	 * Instancia a la clase Menu
	 */
	private Menu menu;
	/**
	 * Instancia a la clase VentanaK
	 */
	private VentanaK ventK;
	/**
	 * Instancia a la clase VentanaM
	 */
	private VentanaM ventM;
	
	/**
	 * Metodo que muestra un mensaje al encontrar un error
	 * @param mensaje Mensaje del error
	 */
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	/**
	 * Constructor de la clase donde se inicializan los objetos
	 */
	public Vista() {
		menu = new Menu();
		ventK = new VentanaK();
		ventM = new VentanaM();
	}
	
	/**
	 * Metdodo getter del objeto Menu
	 * @return El objeto
	 */
	public Menu getMenu() {
		return menu;
	}
	/**
	 * Metdodo getter del objeto VentanaK
	 * @return El objeto
	 */
	public VentanaK getVentK() {
		return ventK;
	}
	/**
	 * Metdodo getter del objeto VentanaM
	 * @return El objeto
	 */
	public VentanaM getVentM() {
		return ventM;
	}	
}
