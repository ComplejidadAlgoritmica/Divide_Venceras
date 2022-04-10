package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.edu.unbosque.controller.Controller;

public class VentanaK extends JFrame{
	
	private JTextField[] entradas = new JTextField[2];
	private JLabel[] textos = new JLabel[2];
	private JButton[] botonM = new JButton[2];
	private JTextArea resultado;
	private JCheckBox activarK;
	
	public VentanaK() {
		setTitle("Multiplicacion Karatsuba");
		setSize(609, 400);
		getContentPane().setLayout(null);
		initComponent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		//setVisible(true);
	}
	
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

	public JTextField[] getEntradas() {
		return entradas;
	}

	public void setEntradas(JTextField[] entradas) {
		this.entradas = entradas;
	}

	public JTextArea getResultado() {
		return resultado;
	}

	public void setResultado(JTextArea resultado) {
		this.resultado = resultado;
	}

	public JButton[] getBotonM() {
		return botonM;
	}

	public void setBotonM(JButton[] botonM) {
		this.botonM = botonM;
	}

	public JCheckBox getActivarK() {
		return activarK;
	}

	public void setActivarK(JCheckBox activarK) {
		this.activarK = activarK;
	}
}
