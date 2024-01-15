// Iris T
// CS 3 Summer 2022-2023
// Area Perimeter
// Creates a GUI that calculates the area and perimeter of a rectangle
// AreaAndPerimeter
// 7/25/22

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AreaAndPerimeter extends JFrame implements ActionListener{
	
	// Components
	private Container c;
	private double lengthVal;
	private double widthVal;
	private JLabel length;
	private JTextField tlength;
	private JLabel width;
	private JTextField twidth;
	private JLabel area;
	private JTextField tarea;
	private JLabel perimeter;
	private JTextField tperimeter;
	private JButton cal;
	private JButton reset;
	
	/*
	 * Constructor to initialize components
	 */
	public AreaAndPerimeter() {
		
		setTitle("Area and Perimeter of a Rectangle");
		setBounds(50, 100, 510, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		c = getContentPane();
		c.setLayout(null);
		
		length = new JLabel("Enter the length: ");
		length.setFont(new Font("Arial", Font.PLAIN, 20));
		length.setSize(300, 20);
		length.setLocation(50, 50);
		c.add(length);

		tlength = new JTextField();
		tlength.setFont(new Font("Arial", Font.PLAIN, 15));
		tlength.setSize(190, 20);
		tlength.setLocation(250, 50);
		c.add(tlength);
		
		width = new JLabel("Enter the width: ");
		width.setFont(new Font("Arial", Font.PLAIN, 20));
		width.setSize(300, 20);
		width.setLocation(50, 100);
		c.add(width);

		twidth = new JTextField();
		twidth.setFont(new Font("Arial", Font.PLAIN, 15));
		twidth.setSize(190, 20);
		twidth.setLocation(250, 100);
		c.add(twidth);
		
		area = new JLabel("Area: ");
		area.setFont(new Font("Arial", Font.PLAIN, 20));
		area.setSize(300, 20);
		area.setLocation(50, 150);
		c.add(area);

		tarea = new JTextField();
		tarea.setFont(new Font("Arial", Font.PLAIN, 15));
		tarea.setSize(190, 20);
		tarea.setLocation(250, 150);
		c.add(tarea);
		
		perimeter = new JLabel("Perimeter: ");
		perimeter.setFont(new Font("Arial", Font.PLAIN, 20));
		perimeter.setSize(300, 20);
		perimeter.setLocation(50, 200);
		c.add(perimeter);

		tperimeter = new JTextField();
		tperimeter.setFont(new Font("Arial", Font.PLAIN, 15));
		tperimeter.setSize(190, 20);
		tperimeter.setLocation(250, 200);
		c.add(tperimeter);
		
		cal = new JButton("Calculate");
		cal.setFont(new Font("Arial", Font.PLAIN, 15));
		cal.setSize(100, 20);
		cal.setLocation(50, 250);
		cal.addActionListener(this);
		c.add(cal);
		
		reset = new JButton("Reset");
		reset.setFont(new Font("Arial", Font.PLAIN, 15));
		reset.setSize(100, 20);
		reset.setLocation(250, 250);
		reset.addActionListener(this);
		c.add(reset);
		
		setVisible(true);
	}

	@Override
	/*
	 * Gets the user's actions and carries them out
	 * 
	 * @param e	action of the user
	 */
	public void actionPerformed(ActionEvent e) {
		// If calculate is pressed, calculates and displayes area/perimeter
		if (e.getSource() == cal) {
			lengthVal = Double.parseDouble(tlength.getText());
			widthVal = Double.parseDouble(twidth.getText());
			
			double areaVal = lengthVal * widthVal;
			double perimeterVal = 2 * (lengthVal + widthVal);
			
			tarea.setText(String.valueOf(areaVal));
			tperimeter.setText(String.valueOf(perimeterVal));
			
		} else if(e.getSource() == reset) {
			// If reset is pressed, makes all text fields blank
			tlength.setText("");
			twidth.setText("");
			tarea.setText("");
			tperimeter.setText("");
		}
		
	}
	
	/*
	 * Creates a new object to run everything
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) throws Exception{
		new AreaAndPerimeter();
	}

}
