package co.edu.unbosque.controller;

import java.math.BigInteger;

import co.edu.unbosque.model.Karatsuba;
import co.edu.unbosque.model.Matriz;
import co.edu.unbosque.view.Vista;

public class Controller {

	private static Karatsuba k;
	private static Matriz m;
	private static Vista v;

	public Controller() {
		k = new Karatsuba();
		v = new Vista();
		m = new Matriz();
		v.getMenu();
	}

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
