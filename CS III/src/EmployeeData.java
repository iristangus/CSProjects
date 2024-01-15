// Iris T
// CS 3 Summer 2022-2023
// Employee Data
// Displays employees' data
// EmployeeData
// 7/25/22

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class EmployeeData extends JFrame implements ActionListener{
	
	// Components
	private Container c;
	private JLabel title;
	private JLabel id;
	private JTextField tid;
	private JLabel first;
	private JTextField tfirst;
	private JLabel last;
	private JTextField tlast;
	private JLabel dep;
	private JTextField tdep;
	private JLabel sal;
	private JTextField tsal;
	private JButton display;
	private JButton sort;
	private JTextArea tout;
	private String employees = "";
	private PriorityQueue<String> employeesSort = new PriorityQueue<String>();
	
	/*
	 * Constructor to initialize components
	 */
	public EmployeeData() {
		
		setTitle("Employee Information");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);
		
		title = new JLabel("Employee Information");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		c.add(title);
		
		id = new JLabel("Employee ID");
		id.setFont(new Font("Arial", Font.PLAIN, 20));
		id.setSize(200, 20);
		id.setLocation(50, 100);
		c.add(id);

		tid = new JTextField();
		tid.setFont(new Font("Arial", Font.PLAIN, 15));
		tid.setSize(190, 20);
		tid.setLocation(250, 100);
		c.add(tid);
		
		first = new JLabel("First Name");
		first.setFont(new Font("Arial", Font.PLAIN, 20));
		first.setSize(200, 20);
		first.setLocation(50, 140);
		c.add(first);

		tfirst = new JTextField();
		tfirst.setFont(new Font("Arial", Font.PLAIN, 15));
		tfirst.setSize(190, 20);
		tfirst.setLocation(250, 140);
		c.add(tfirst);
		
		last = new JLabel("Last Name");
		last.setFont(new Font("Arial", Font.PLAIN, 20));
		last.setSize(200, 20);
		last.setLocation(50, 180);
		c.add(last);

		tlast = new JTextField();
		tlast.setFont(new Font("Arial", Font.PLAIN, 15));
		tlast.setSize(190, 20);
		tlast.setLocation(250, 180);
		c.add(tlast);
		
		dep = new JLabel("Department");
		dep.setFont(new Font("Arial", Font.PLAIN, 20));
		dep.setSize(200, 20);
		dep.setLocation(50, 220);
		c.add(dep);

		tdep = new JTextField();
		tdep.setFont(new Font("Arial", Font.PLAIN, 15));
		tdep.setSize(190, 20);
		tdep.setLocation(250, 220);
		c.add(tdep);
		
		sal = new JLabel("Salary");
		sal.setFont(new Font("Arial", Font.PLAIN, 20));
		sal.setSize(200, 20);
		sal.setLocation(50, 260);
		c.add(sal);

		tsal = new JTextField();
		tsal.setFont(new Font("Arial", Font.PLAIN, 15));
		tsal.setSize(190, 20);
		tsal.setLocation(250, 260);
		c.add(tsal);
		
		display = new JButton("Display");
		display.setFont(new Font("Arial", Font.PLAIN, 15));
		display.setSize(190, 20);
		display.setLocation(150, 300);
		display.addActionListener(this);
		c.add(display);
		
		sort = new JButton("Sort");
		sort.setFont(new Font("Arial", Font.PLAIN, 15));
		sort.setSize(190, 20);
		sort.setLocation(150, 340);
		sort.addActionListener(this);
		c.add(sort);
		
		tout = new JTextArea();
		tout.setFont(new Font("Arial", Font.PLAIN, 15));
		tout.setSize(300, 350);
		tout.setLocation(500, 100);
		tout.setLineWrap(true);
		tout.setEditable(false);
		c.add(tout);
		
		setVisible(true);
	}

	/*
	 * Gets user's action and carries it out
	 * 
	 * @param e	user action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Displays employee
		if (e.getSource() == display) {
			tout.setText("");
			String line = tlast.getText() + ", " + tfirst.getText() + " " + tid.getText() + "\n";
			employees += line;
			employeesSort.add(line);
			tout.setText(employees);
			
		} else if(e.getSource() == sort) {
			// Sorts employees using a PriorityQueue
			tout.setText("");
			String line = "";
			PriorityQueue<String> copy = employeesSort;
			while (!copy.isEmpty()) {
				String str = copy.remove();
				line += str;
			}
			for (String str : employeesSort) {
				copy.add(str);
			}
			tout.setText(line);
		}
	}
	
	/*
	 * Creates a new object to run the program
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		new EmployeeData();
	}

}
