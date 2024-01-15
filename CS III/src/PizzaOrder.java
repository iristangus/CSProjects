// Iris T
// CS 3 Summer 1522-1523
// Pizza Order
// Calculates the price of a pizza order
// PizzaOrder
// 7/25/22

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PizzaOrder extends JFrame implements ActionListener {
	
	// Components
	private Container c;
	private JLabel title;
	private JLabel smallP;
	private JLabel mediumP;
	private JLabel largeP;
	private JLabel toppingsP;
	private JPanel sizePanel;
	private ButtonGroup size;
	private TitledBorder sizeBorder;
	private JRadioButton small;
	private JRadioButton medium;
	private JRadioButton large;
	private JPanel toppingsPanel;
	private TitledBorder toppingsBorder;
	private JCheckBox pepperoni;
	private JCheckBox sausage;
	private JCheckBox pineapple;
	private JCheckBox cheese;
	private JCheckBox pepper;
	private JCheckBox olives;
	private JButton cal;
	private JButton exit;
	private JTextArea tout;
	
	/*
	 * Constructor that initializes components
	 */
	public PizzaOrder() {
		
		setTitle("Pizza Order Form");
		setBounds(0, 0, 570, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		c = getContentPane();
		c.setLayout(null);
		
		title = new JLabel("Mama Mia Pizzaria");
		title.setFont(new Font("Arial", Font.BOLD, 50));
		title.setSize(500, 50);
		title.setLocation(50, 20);
		c.add(title);
		
		smallP = new JLabel("Small:        $4.99");
		smallP.setFont(new Font("Arial", Font.BOLD, 15));
		smallP.setSize(300, 15);
		smallP.setLocation(20, 100);
		c.add(smallP);
		
		mediumP = new JLabel("Medium:    $6.99");
		mediumP.setFont(new Font("Arial", Font.BOLD, 15));
		mediumP.setSize(300, 15);
		mediumP.setLocation(20, 130);
		c.add(mediumP);
		
		largeP = new JLabel("Large:       $8.99");
		largeP.setFont(new Font("Arial", Font.BOLD, 15));
		largeP.setSize(300, 15);
		largeP.setLocation(20, 160);
		c.add(largeP);
		
		toppingsP = new JLabel("Toppings:  $0.50 each");
		toppingsP.setFont(new Font("Arial", Font.BOLD, 15));
		toppingsP.setSize(300, 20);
		toppingsP.setLocation(20, 190);;
		c.add(toppingsP);
		
		sizePanel = new JPanel();
		sizePanel.setBounds(190, 80, 160, 240);
		sizeBorder = BorderFactory.createTitledBorder("Sizes");
		sizePanel.setBorder(sizeBorder);
		size = new ButtonGroup();
		
		small = new JRadioButton("Small");
		small.setFont(new Font("Arial", Font.BOLD, 15));
		small.setSize(100, 15);
		small.setLocation(200, 110);
		small.addActionListener(this);
		size.add(small);
		c.add(small);
		
		medium = new JRadioButton("Medium");
		medium.setFont(new Font("Arial", Font.BOLD, 15));
		medium.setSize(100, 15);
		medium.setLocation(200, 140);
		medium.addActionListener(this);
		size.add(medium);
		c.add(medium);
		
		large = new JRadioButton("Large");
		large.setFont(new Font("Arial", Font.BOLD, 15));
		large.setSize(100, 15);
		large.setLocation(200, 170);
		size.add(large);
		c.add(large);
		
		c.add(sizePanel);
		
		toppingsPanel = new JPanel();
		toppingsPanel.setBounds(350, 80, 180, 240);
		toppingsBorder = BorderFactory.createTitledBorder("Toppings");
		toppingsPanel.setBorder(toppingsBorder);
		
		pepperoni = new JCheckBox("Pepperoni");
		pepperoni.setFont(new Font("Arial", Font.BOLD, 15));
		pepperoni.setSize(130, 15);
		pepperoni.setLocation(370, 110);
		pepperoni.addActionListener(this);
		c.add(pepperoni);
		
		sausage = new JCheckBox("Italian Sausage");
		sausage.setFont(new Font("Arial", Font.BOLD, 15));
		sausage.setSize(150, 15);
		sausage.setLocation(370, 140);
		sausage.addActionListener(this);
		c.add(sausage);
		
		pineapple = new JCheckBox("Pineapple");
		pineapple.setFont(new Font("Arial", Font.BOLD, 15));
		pineapple.setSize(130, 15);
		pineapple.setLocation(370, 170);
		pineapple.addActionListener(this);
		c.add(pineapple);
		
		cheese = new JCheckBox("Extra Cheese");
		cheese.setFont(new Font("Arial", Font.BOLD, 15));
		cheese.setSize(130, 15);
		cheese.setLocation(370, 200);
		cheese.addActionListener(this);
		c.add(cheese);
		
		pepper = new JCheckBox("Green Pepper");
		pepper.setFont(new Font("Arial", Font.BOLD, 15));
		pepper.setSize(130, 15);
		pepper.setLocation(370, 230);
		pepper.addActionListener(this);
		c.add(pepper);
		
		olives = new JCheckBox("Olives");
		olives.setFont(new Font("Arial", Font.BOLD, 15));
		olives.setSize(130, 15);
		olives.setLocation(370, 260);
		olives.addActionListener(this);
		c.add(olives);
		
		c.add(toppingsPanel);
		
		cal = new JButton("Calculate");
		cal.setFont(new Font("Arial", Font.BOLD, 15));
		cal.setSize(120, 20);
		cal.setLocation(120, 340);
		cal.addActionListener(this);
		c.add(cal);
		
		exit = new JButton("Exit");
		exit.setFont(new Font("Arial", Font.BOLD, 15));
		exit.setSize(100, 20);
		exit.setLocation(250, 340);
		exit.addActionListener(this);
		c.add(exit);
		
		tout = new JTextArea();
		tout.setFont(new Font("Arial", Font.BOLD, 15));
		tout.setSize(150, 80);
		tout.setLocation(20, 230);
		tout.setLineWrap(true);
		tout.setEditable(false);
		c.add(tout);
		
		setVisible(true);
	}

	/*
	 * If user clicks calculate, calculates and displays price
	 * If user clicks exit, exits the program
	 * 
	 * @param e	user action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		double price = 0;
		int toppings = 0;
		
		int p = 0;
		int s = 0;
		int pi = 0;
		int c = 0;
		int pe = 0;
		int o = 0;

		if (small.isSelected()) {
			price = 4.99;
		} else if(medium.isSelected()) {
			price = 6.99;
		} else if(large.isSelected()) {
			price = 8.99;
		} 
		
		if(pepperoni.isSelected()) {
			p = 1;
		} else {
			p = 0;
		}
		if(sausage.isSelected()) {
			s = 1;
		} else {
			s = 0;
		}
		if(pineapple.isSelected()) {
			pi = 1;
		} else {
			pi = 0;
		}
		if(cheese.isSelected()) {
			c = 1;
		} else {
			c = 0;
		}
		if(pepper.isSelected()) {
			pe = 1;
		} else {
			pe = 0;
		}
		if(olives.isSelected()) {
			o = 1;
		} else {
			o = 0;
		}
		
		toppings = p + s + pi + c + pe + o;
		
		if(e.getSource() == cal) {
			price += toppings * 0.5;
			tout.setText("$" + String.valueOf(price));
		} else if(e.getSource() == exit) {
			System.exit(0);
		}
		
	}
	
	/*
	 * Creates a new object to run the program
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		new PizzaOrder();
	}

}
