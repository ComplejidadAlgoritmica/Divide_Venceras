package co.edu.unbosque.controller;

import java.math.BigInteger;

import co.edu.unbosque.model.Karatsuba;
import co.edu.unbosque.view.Vista;

public class Controller {

	private Karatsuba k;
	private Vista v;

	public Controller() {
		k = new Karatsuba();
		v = new Vista();
		funcionar();
	}

	public void funcionar() {
		boolean bandera = true;
		while(bandera) {
			String menu = v.leerDatos("DIVIDE Y VENCERAS\n¿Qué desea hacer?\n1) Multiplicacion haciendo uso del metodo Karatsuba\n2) Multiplicar matriz\n3) Salir");
			switch (menu) {
			case "1": {
				try {
					String numero1 = v.leerDatos("Ingrese primer numnero para multiplicar");
					String numero2 = v.leerDatos("Ingrese segundo numnero para multiplicar");
					v.mostrarMensaje("El valor de multiplicar: "+ numero1 + " * " + numero2 + "\n" +k.karatsubaBi(new BigInteger(numero1),
							new BigInteger(numero2)));
				}catch (NumberFormatException e) {
					v.mostrarMensaje("Debes ingresar solo numeros");
				}catch (NullPointerException e) {
					v.mostrarMensaje("Debes ingresar numeros, no dejes campos vacios");
				}
				break;
			}
			case "2":{
				v.mostrarMensaje("GG");
				break;
			}
			case "3":{
				v.mostrarMensaje("Gracias por usar el programa. Que estes bien :)");
				bandera = false;
				break;
			}
			default:
				v.mostrarMensaje("Debe seleccionar una opcion del menu que este entre 1 a 3");
			}
		}		
	}
}
