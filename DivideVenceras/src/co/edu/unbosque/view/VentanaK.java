package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.edu.unbosque.controller.Controller;

/**
 * Clase donde se crea la interfaz de la Ventana de la multiplicacion de dos
 * numeros Extienede de la interface JFrame para crear los elementos de la
 * interfaz
 * 
 * @author Santiago Flórez
 * @author Jorge Garcia
 *
 */
public class VentanaK extends JFrame {

	/**
	 * Atributo de tipo JTextField para crear las entradas de texto
	 */
	private JTextField[] entradas = new JTextField[2];
	/**
	 * Atributo de tipo JLabel para crear los textos de informacion
	 */
	private JLabel[] textos = new JLabel[2];
	/**
	 * Atributo de tipo JButton para crear los botones
	 */
	private JButton[] botonM = new JButton[2];
	/**
	 * Atributo de tipo JTextArea para crear el campo donde se muestra el resultado
	 */
	private JTextArea resultado;
	/**
	 * Atributo de tipo JCheckBox para crear el check para elegir el metodo a usar
	 */
	private JCheckBox activarK;

	/**
	 * Contructor de la clase donde se le dan los parametros a la ventana
	 */
	public VentanaK() {
		setTitle("Multiplicacion Karatsuba");
		setSize(609, 400);
		getContentPane().setLayout(null);
		initComponent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		// setVisible(true);
	}

	/**
	 * Metodo que crea cada objeto con sus respectivos valores
	 */
	public void initComponent() {
		textos[0] = new JLabel("Primer Numero", JLabel.CENTER);
		textos[0].setBounds(253, 16, 102, 21);
		getContentPane().add(textos[0]);
		entradas[0] = new JTextField();
		entradas[0].setBounds(28, 37, 552, 27);
		getContentPane().add(entradas[0]);

		textos[1] = new JLabel("Segundo Numero", JLabel.CENTER);
		textos[1].setBounds(239, 76, 131, 21);
		getContentPane().add(textos[1]);
		entradas[1] = new JTextField();
		entradas[1].setBounds(28, 97, 552, 27);
		getContentPane().add(entradas[1]);

		botonM[0] = new JButton("Multiplicar");
		botonM[0].setBounds(257, 146, 94, 27);
		botonM[0].addActionListener(e -> Controller.multiplicar());
		getContentPane().add(botonM[0]);

		botonM[1] = new JButton("Regresar");
		botonM[1].setBounds(465, 312, 115, 27);
		botonM[1].addActionListener(e -> Controller.regresar("MK"));
		getContentPane().add(botonM[1]);

		resultado = new JTextArea();
		resultado.setEditable(false);
		JScrollPane scroll = new JScrollPane(resultado);
		scroll.setBounds(28, 182, 552, 120);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(scroll);

		activarK = new JCheckBox("Karatsuba");
		activarK.setBounds(28, 146, 108, 22);
		getContentPane().add(activarK);
	}

	/**
	 * Getter de los campos de entrada de texto
	 * 
	 * @return un arreglo con cada entrada texto
	 */
	public JTextField[] getEntradas() {
		return entradas;
	}

	/**
	 * Getter del campo de resultado
	 * 
	 * @return El objeto JTextArea
	 */
	public JTextArea getResultado() {
		return resultado;
	}

	/**
	 * Getter de los botones
	 * 
	 * @return Un arreglo con cada boton
	 */
	public JButton[] getBotonM() {
		return botonM;
	}

	/**
	 * Getter del check para saber el estado en el que esta
	 * 
	 * @return El objeto
	 */
	public JCheckBox getActivarK() {
		return activarK;
	}
}
