package co.edu.unbosque.controller;

import java.math.BigInteger;

import co.edu.unbosque.model.Karatsuba;
import co.edu.unbosque.view.Vista;

public class Controller {

	private static Karatsuba k;
	private static Vista v;

	public Controller() {
		k = new Karatsuba();
		v = new Vista();
		v.getMenu();
		//funcionar();
	}

//	public void funcionar() {
//		boolean bandera = true;
//		while(bandera) {
//			String menu = v.leerDatos("DIVIDE Y VENCERAS\n¿Qué desea hacer?\n1) Multiplicacion haciendo uso del metodo Karatsuba\n2) Multiplicar matriz\n3) Salir");
//			switch (menu) {
//			case "1": {
//				try {
//					String numero1 = v.leerDatos("Ingrese primer numnero para multiplicar");
//					String numero2 = v.leerDatos("Ingrese segundo numnero para multiplicar");
//					v.mostrarMensaje("El valor de multiplicar: "+ numero1 + " * " + numero2 + "\n" +k.karatsubaBi(new BigInteger(numero1),
//							new BigInteger(numero2)));
//				}catch (NumberFormatException e) {
//					v.mostrarMensaje("Debes ingresar solo numeros");
//				}catch (NullPointerException e) {
//					v.mostrarMensaje("Debes ingresar numeros, no dejes campos vacios");
//				}
//				break;
//			}
//			case "2":{
//				v.mostrarMensaje("GG");
//				break;
//			}
//			case "3":{
//				v.mostrarMensaje("Gracias por usar el programa. Que estes bien :)");
//				bandera = false;
//				break;
//			}
//			default:
//				v.mostrarMensaje("Debe seleccionar una opcion del menu que este entre 1 a 3");
//			}
//		}		
//	}
	
	public static void menuListenerMK() {
		v.getMenu().setVisible(false);
		v.getVentK().setVisible(true);
	}
	
	public static void multiplicar() {
		if(v.getVentK().getActivarK().isSelected()) {
			try {
				String num1 = v.getVentK().getEntradas()[0].getText();
				String num2 = v.getVentK().getEntradas()[1].getText();
				if(num1.equals("") || num2.equals("")) {
					v.getVentK().getResultado().setText("Debes llenar los campos anteriores");
				}else {
					v.getVentK().getResultado().setText(num1 + " * " + num2 +"\n\n"+k.karatsubaBi(new BigInteger(num1), new BigInteger(num2), "K"));
				}
			}catch (NumberFormatException e) {
				v.getVentK().getResultado().setText("Debes llenar los campos anteriores con SOLO NUMEROS");
			}
		}else {
			try {
				String num1 = v.getVentK().getEntradas()[0].getText();
				String num2 = v.getVentK().getEntradas()[1].getText();
				if(num1.equals("") || num2.equals("")) {
					v.getVentK().getResultado().setText("Debes llenar los campos anteriores");
				}else {
					v.getVentK().getResultado().setText(num1 + " * " + num2 +"\n\n"+k.karatsubaBi(new BigInteger(num1), new BigInteger(num2), "N"));
				}
			}catch (NumberFormatException e) {
				v.getVentK().getResultado().setText("Debes llenar los campos anteriores con SOLO NUMEROS");
			}
		}
	}
	
	public static void regresar() {
		v.getVentK().getEntradas()[0].setText("");
		v.getVentK().getEntradas()[1].setText("");
		v.getVentK().getResultado().setText("");
		v.getVentK().setVisible(false);
		v.getMenu().setVisible(true);
	}
}
