package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.unbosque.controller.Controller;
/**
 * Clase donde se crea la interfaz de la Ventana de la multiplicacion de dos
 * matrices. Extienede de la interface JFrame para crear los elementos de la
 * interfaz
 * 
 * @author Santiago Flórez
 * @author Jorge Garcia
 *
 */
public class VentanaM extends JFrame{
	/**
	 * Atributo de tipo JTextField para crear las entradas de texto de la primer matriz
	 */
	private JTextField[] matriz1 = new JTextField[4];
	/**
	 * Atributo de tipo JTextField para crear las entradas de texto de la segunda matriz
	 */
	private JTextField[] matriz2 = new JTextField[4];
	/**
	 * Atributo de tipo JTextField para crear las entradas de texto de la matriz resultante
	 */
	private JTextField[] matrizR = new JTextField[4];
	/**
	 * Atributo de tipo JButton para crear los botones
	 */
	private JButton[] botones = new JButton[2];
	/**
	 * Atributo de tipo JCheckBox para crear el check para elegir el metodo a usar
	 */
	private JCheckBox d_v;
	/**
	 * Atributo de tipo JLabel para crear los textos de informacion
	 */
	private JLabel[] textos = new JLabel[3];
	
	/**
	 * Contructor de la clase donde se le dan los parametros a la ventana
	 */
	public VentanaM() {
		setTitle("Multiplicacion Matriz");
		setSize(310, 385);
		getContentPane().setLayout(null);
		initComponent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Metodo que crea cada objeto con sus respectivos valores
	 */
	public void initComponent() {
		matriz1[0] = new JTextField();
		matriz1[0].setBounds(6, 29, 26, 27);
		getContentPane().add(matriz1[0]);
		matriz1[1] = new JTextField();
		matriz1[1].setBounds(32, 29, 26, 27);
		getContentPane().add(matriz1[1]);
		matriz1[2] = new JTextField();
		matriz1[2].setBounds(6, 56, 26, 27);
		getContentPane().add(matriz1[2]);
		matriz1[3] = new JTextField();
		matriz1[3].setBounds(32, 56, 26, 27);
		getContentPane().add(matriz1[3]);
		
		textos[0] = new JLabel("Matriz 1", JLabel.CENTER);
		textos[0].setBounds(16, 117, 59, 21);
		getContentPane().add(textos[0]);
		
		matriz2[0] = new JTextField();
		matriz2[0].setBounds(214, 29, 26, 27);
		getContentPane().add(matriz2[0]);
		matriz2[1] = new JTextField();
		matriz2[1].setBounds(238, 29, 26, 27);
		getContentPane().add(matriz2[1]);
		matriz2[2] = new JTextField();
		matriz2[2].setBounds(214, 56, 26, 27);
		getContentPane().add(matriz2[2]);
		matriz2[3] = new JTextField();
		matriz2[3].setBounds(238, 56, 26, 27);
		getContentPane().add(matriz2[3]);
		
		textos[1] = new JLabel("Matriz 2", JLabel.CENTER);
		textos[1].setBounds(222, 117, 59, 21);
		getContentPane().add(textos[1]);
		
		matrizR[0] = new JTextField();
		matrizR[0].setBounds(116, 148, 26, 27);
		matrizR[0].setEditable(false);
		getContentPane().add(matrizR[0]);
		matrizR[1] = new JTextField();
		matrizR[1].setBounds(142, 148, 26, 27);
		matrizR[1].setEditable(false);
		getContentPane().add(matrizR[1]);
		matrizR[2] = new JTextField();
		matrizR[2].setBounds(116, 175, 26, 27);
		matrizR[2].setEditable(false);
		getContentPane().add(matrizR[2]);
		matrizR[3] = new JTextField();
		matrizR[3].setBounds(142, 175, 26, 27);
		matrizR[3].setEditable(false);
		getContentPane().add(matrizR[3]);
		
		textos[2] = new JLabel("Resultado", JLabel.CENTER);
		textos[2].setBounds(116, 236, 78, 21);
		getContentPane().add(textos[2]);
		
		d_v = new JCheckBox("Divide y Venceras");
		d_v.setBounds(6, 257, 136, 22);
		getContentPane().add(d_v);
		
		botones[0] = new JButton("Multiplicar");
		botones[0].setBounds(100, 279, 110, 27);
		botones[0].addActionListener(e -> Controller.multiMatriz());
		getContentPane().add(botones[0]);
		
		botones[1] = new JButton("Regresar");
		botones[1].addActionListener(e -> Controller.regresar("MM"));
		botones[1].setBounds(100, 315, 115, 27);
		getContentPane().add(botones[1]);
	}

	/**
	 * Getter de los campos de entrada de texto
	 * 
	 * @return un arreglo con cada entrada texto
	 */
	public JTextField[] getMatriz1() {
		return matriz1;
	}

	/**
	 * Getter de los campos de entrada de texto
	 * 
	 * @return un arreglo con cada entrada texto
	 */
	public JTextField[] getMatriz2() {
		return matriz2;
	}

	/**
	 * Getter de los campos de entrada de texto
	 * 
	 * @return un arreglo con cada entrada texto
	 */
	public JTextField[] getMatrizR() {
		return matrizR;
	}

	/**
	 * Getter de los botones
	 * 
	 * @return Un arreglo con cada boton
	 */
	public JButton[] getBotones() {
		return botones;
	}

	/**
	 * Getter del check para saber el estado en el que esta
	 * 
	 * @return El objeto
	 */
	public JCheckBox getD_v() {
		return d_v;
	}
}
