package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import co.edu.unbosque.controller.Controller;

public class Menu extends JFrame{
	
	private JButton[] botones = new JButton[2];
	private JLabel titulo = new JLabel();
	
	public Menu() {
		setTitle("Menu");
		setSize(409, 258);
		getContentPane().setLayout(null);
		initComponent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void initComponent() {
		titulo.setText("Divide y Venceras");
		titulo.setBounds(145, 20, 119, 21);
		getContentPane().add(titulo);
		
		botones[0] = new JButton("Multiplicacion Karatsuba");
		botones[0].setBounds(105, 73, 198, 27);
		botones[0].addActionListener(e -> Controller.menuListenerMK());
		getContentPane().add(botones[0]);
		
		botones[1] = new JButton("Multiplicacion de Matrices");
		botones[1].setBounds(99, 140, 210, 27);
		getContentPane().add(botones[1]);
	}
}
