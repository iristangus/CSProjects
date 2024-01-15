// Iris T
// CS 3 Summer 2022-2023
// Arithmetic Operations
// Creates a GUI for a simple calculator
// ArithmeticOperations
// 7/25/22

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArithmeticOperations extends JFrame implements ActionListener{
	
	// Components
	private Container c;
	private double val1d;
	private double val2d;
	private JLabel val1;
	private JTextField tval1;
	private JLabel val2;
	private JTextField tval2;
	private JLabel result;
	private JTextField tresult;
	private JButton add;
	private JButton sub;
	private JButton mul;
	private JButton mod;
	private JButton pow;
	private JButton clear;
	
	/*
	 * Constructor that initializes components
	 */
	public ArithmeticOperations() {
		
		setTitle("Calculator");
		setBounds(50, 100, 450, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		c = getContentPane();
		c.setLayout(null);
		
		val1 = new JLabel("Enter the value: ");
		val1.setFont(new Font("Arial", Font.PLAIN, 20));
		val1.setSize(300, 20);
		val1.setLocation(50, 50);
		c.add(val1);

		tval1 = new JTextField();
		tval1.setFont(new Font("Arial", Font.PLAIN, 15));
		tval1.setSize(190, 20);
		tval1.setLocation(200, 50);
		c.add(tval1);
		
		val2 = new JLabel("Enter the value: ");
		val2.setFont(new Font("Arial", Font.PLAIN, 20));
		val2.setSize(300, 20);
		val2.setLocation(50, 90);
		c.add(val2);

		tval2 = new JTextField();
		tval2.setFont(new Font("Arial", Font.PLAIN, 15));
		tval2.setSize(190, 20);
		tval2.setLocation(200, 90);
		c.add(tval2);
		
		result = new JLabel("The result is ");
		result.setFont(new Font("Arial", Font.PLAIN, 20));
		result.setSize(300, 20);
		result.setLocation(50, 130);
		c.add(result);

		tresult = new JTextField();
		tresult.setFont(new Font("Arial", Font.PLAIN, 15));
		tresult.setSize(190, 20);
		tresult.setLocation(200, 130);
		c.add(tresult);
		
		add = new JButton("+");
		add.setFont(new Font("Arial", Font.PLAIN, 15));
		add.setSize(130, 20);
		add.setLocation(50, 170);
		add.addActionListener(this);
		c.add(add);
		
		sub = new JButton("-");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setSize(130, 20);
		sub.setLocation(200, 170);
		sub.addActionListener(this);
		c.add(sub);
		
		mul = new JButton("*");
		mul.setFont(new Font("Arial", Font.PLAIN, 15));
		mul.setSize(130, 20);
		mul.setLocation(50, 210);
		mul.addActionListener(this);
		c.add(mul);
		
		mod = new JButton("%");
		mod.setFont(new Font("Arial", Font.PLAIN, 15));
		mod.setSize(130, 20);
		mod.setLocation(200, 210);
		mod.addActionListener(this);
		c.add(mod);
		
		pow = new JButton("^");
		pow.setFont(new Font("Arial", Font.PLAIN, 15));
		pow.setSize(130, 20);
		pow.setLocation(50, 250);
		pow.addActionListener(this);
		c.add(pow);
		
		clear = new JButton("Clear");
		clear.setFont(new Font("Arial", Font.PLAIN, 15));
		clear.setSize(130, 20);
		clear.setLocation(200, 250);
		clear.addActionListener(this);
		c.add(clear);
		
		setVisible(true);
	}

	@Override
	/*
	 * Gets the user's actions and carries them out
	 * 
	 * @param e	user action
	 */
	public void actionPerformed(ActionEvent e) {
		// The values the user input
		val1d = Double.parseDouble(tval1.getText());
		val2d = Double.parseDouble(tval2.getText());
		
		if (e.getSource() == add) {
			tresult.setText(String.valueOf(val1d + val2d));
		} else if (e.getSource() == sub) {
			tresult.setText(String.valueOf(val1d - val2d));
		} else if (e.getSource() == mul) {
			tresult.setText(String.valueOf(val1d * val2d));
		} else if (e.getSource() == mod) {
			tresult.setText(String.valueOf(val1d % val2d));
		} else if (e.getSource() == pow) {
			tresult.setText(String.valueOf(Math.pow(val1d, val2d)));
		} else if (e.getSource() == clear){
			tval1.setText("");
			tval2.setText("");
			tresult.setText("");
		}
		
	}
	
	/*
	 * Creates an object to run everything
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) throws Exception{
		new ArithmeticOperations();
	}

}
