package co.edu.unbosque.controller;

import java.math.BigInteger;

import co.edu.unbosque.model.Karatsuba;
import co.edu.unbosque.model.Matriz;
import co.edu.unbosque.view.Vista;
/**
 * 
 * @author Santiago Flórez
 * @author Jorge Garcia
 * Esta clase se encarga del control de la aplicacion y que acciones se deben
 * realizar al ejecutar el proyecto.
 *
 */
public class Controller {
	
	/**
	 * Instacia a la clase Karatsuba
	 */
	private static Karatsuba k;
	/**
	 * Instacia a la clase Matriz
	 */
	private static Matriz m;
	/**
	 * Instacia a la clase Vista
	 */
	private static Vista v;

	/**
	 * Controlador de la clase que se encarga de inicializar las instancias de las demas clases de
	 * los paquetes del proyecto.
	 */
	public Controller() {
		k = new Karatsuba();
		v = new Vista();
		m = new Matriz();
		v.getMenu();
	}
	
	/**
	 * Metodo que se usa como ActionListener para el menu del proyecto.
	 * @param click String que hace referencia a que boton se le dio click.
	 */
	public static void menuListenerMK(String click) {
		if (click.equals("MK")) {
			v.getMenu().setVisible(false);
			v.getVentK().setVisible(true);
		} else if (click.equals("MM")) {
			v.getMenu().setVisible(false);
			v.getVentM().setVisible(true);
		} else {
			System.exit(0);
		}

	}

	/**
	 * Metodo que se usa como ActionListener del boton de la interfaz del metodo Karatsuba
	 */
	public static void multiplicar() {
		if (v.getVentK().getActivarK().isSelected()) {
			try {
				String num1 = v.getVentK().getEntradas()[0].getText();
				String num2 = v.getVentK().getEntradas()[1].getText();
				if (num1.equals("") || num2.equals("")) {
					v.getVentK().getResultado().setText("Debes llenar los campos anteriores");
				} else {
					v.getVentK().getResultado().setText(num1 + " * " + num2 + "\n\n"
							+ k.karatsubaBi(new BigInteger(num1), new BigInteger(num2), "K"));
				}
			} catch (NumberFormatException e) {
				v.getVentK().getResultado().setText("Debes llenar los campos anteriores con SOLO NUMEROS");
			}
		} else {
			try {
				String num1 = v.getVentK().getEntradas()[0].getText();
				String num2 = v.getVentK().getEntradas()[1].getText();
				if (num1.equals("") || num2.equals("")) {
					v.getVentK().getResultado().setText("Debes llenar los campos anteriores");
				} else {
					v.getVentK().getResultado().setText(num1 + " * " + num2 + "\n\n"
							+ k.karatsubaBi(new BigInteger(num1), new BigInteger(num2), "N"));
				}
			} catch (NumberFormatException e) {
				v.getVentK().getResultado().setText("Debes llenar los campos anteriores con SOLO NUMEROS");
			}
		}
	}
	
	/**
	 * Metodo que se usa como ActionListener del boton de la interfaz de la multiplicacion de matrices
	 */
	public static void multiMatriz() {
		if (v.getVentM().getD_v().isSelected()) {
			try {

				int tam = 2;
				int cont = 0;
				int[][] matriz1 = new int[tam][tam];
				int[][] matriz2 = new int[tam][tam];

				for (int i = 0; i < tam; i++) {
					for (int j = 0; j < tam; j++) {
						int datosM1 = Integer.parseInt(v.getVentM().getMatriz1()[cont].getText());
						matriz1[i][j] = datosM1;
						cont++;
					}
					System.out.println("");
				}
				cont = 0;
				for (int i = 0; i < tam; i++) {
					for (int j = 0; j < tam; j++) {
						int datosM2 = Integer.parseInt(v.getVentM().getMatriz2()[cont].getText());
						matriz2[i][j] = datosM2;
						cont++;
					}
				}

				int[][] resul = m.multiply(matriz1, matriz2);

				cont = 0;
				for (int i = 0; i < resul.length; i++) {
					for (int j = 0; j < resul.length; j++) {
						String datosM2 = String.valueOf(resul[i][j]);
						v.getVentM().getMatrizR()[cont].setText(datosM2);
						cont++;
					}
				}
			} catch (NumberFormatException e) {
				v.mostrarMensaje("Solo deber ingresar NUMEROS a la matriz");
			}
		} else {
			try {

				int tam = 2;
				int cont = 0;
				int[][] matriz1 = new int[tam][tam];
				int[][] matriz2 = new int[tam][tam];

				for (int i = 0; i < tam; i++) {
					for (int j = 0; j < tam; j++) {
						int datosM1 = Integer.parseInt(v.getVentM().getMatriz1()[cont].getText());
						matriz1[i][j] = datosM1;
						cont++;
					}
				}
				cont = 0;
				for (int i = 0; i < tam; i++) {
					for (int j = 0; j < tam; j++) {
						int datosM2 = Integer.parseInt(v.getVentM().getMatriz2()[cont].getText());
						matriz2[i][j] = datosM2;
						cont++;
					}
				}

				int[][] resul = m.multiplicacionNormal(matriz1, matriz2);

				
				cont = 0;
				for (int i = 0; i < resul.length; i++) {
					for (int j = 0; j < resul.length; j++) {
						String datosM2 = String.valueOf(resul[i][j]);
						v.getVentM().getMatrizR()[cont].setText(datosM2);
						cont++;
					}
				}
			} catch (NumberFormatException e) {
				v.mostrarMensaje("Solo deber ingresar NUMEROS a la matriz");
			}
		}
	}
	
	/**
	 * Metodo que se usa como ActionListener del boton de regreso a la ventana principal
	 * @param click String que hace referencia a la ventana donde se le dio click al boton regresar
	 */
	public static void regresar(String click) {
		if (click.equals("MK")) {
			v.getVentK().getEntradas()[0].setText("");
			v.getVentK().getEntradas()[1].setText("");
			v.getVentK().getResultado().setText("");
			v.getVentK().getActivarK().setSelected(false);
			v.getVentK().setVisible(false);
			v.getMenu().setVisible(true);
		} else if (click.equals("MM")) {
			for (int i = 0; i < v.getVentM().getMatriz1().length; i++) {
				v.getVentM().getMatriz1()[i].setText("");
			}

			for (int i = 0; i < v.getVentM().getMatriz2().length; i++) {
				v.getVentM().getMatriz2()[i].setText("");
			}
			for (int i = 0; i < v.getVentM().getMatrizR().length; i++) {
				v.getVentM().getMatrizR()[i].setText("");
			}
			v.getVentM().getD_v().setSelected(false);
			v.getVentM().setVisible(false);
			v.getMenu().setVisible(true);
		}

	}
}
