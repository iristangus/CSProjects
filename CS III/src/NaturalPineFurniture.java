// Iris T
// CS 3 Summer 1522-1523
// Java Graphics Quiz
// Creates a pay report for a Natural Pine Furniture employee
// NaturalPineFurniture
// 7/26/22

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class NaturalPineFurniture extends JFrame implements ActionListener{

	// Final instance variables
	private final double FED_WITHHOLD = 0.18;
	private final double STATE_WITHHOLD = 0.045;
	private final double HOSPITAL = 25.65;
	private final double UNION = 7.85;
	
	// Components
	private JLabel employee;
	private JTextField temployee;
	private JLabel hourwork;
	private JTextField thourwork;
	private JLabel hourwage;
	private JTextField thourwage;
	private JLabel grosspay;
	private JTextField tgrosspay;
	private JLabel deductions;
	private JLabel federal;
	private JTextField tfederal;
	private JLabel state;
	private JTextField tstate;
	private JLabel hospital;
	private JTextField thospital;
	private JLabel uniondues;
	private JTextField tuniondues;
	private JLabel total;
	private JTextField ttotal;
	private JLabel netpay;
	private JTextField tnetpay;
	private JLabel blank;
	private JLabel hyphens;
	private JButton cal;
	private JFrame frame;
	private JPanel panel;
	
	/*
	 * Constructor that initializes components
	 */
	public NaturalPineFurniture() {
		
		frame = new JFrame();
		panel = new JPanel(new GridLayout(13, 2, 60, 10));
		
		employee = new JLabel("Employee");
		panel.add(employee);
		
		temployee = new JTextField();
		temployee.setPreferredSize(new Dimension(200, 20));
		panel.add(temployee);
		
		hourwork = new JLabel("Hours Worked");
		panel.add(hourwork);
		
		thourwork = new JTextField();
		panel.add(thourwork);
		
		hourwage = new JLabel("Hourly Wage");
		panel.add(hourwage);
		
		thourwage = new JTextField();
		panel.add(thourwage);
		
		grosspay = new JLabel("Gross Pay");
		panel.add(grosspay);
		
		tgrosspay = new JTextField();
		panel.add(tgrosspay);
		
		deductions = new JLabel("Deductions:");
		panel.add(deductions);
		
		blank = new JLabel("");
		panel.add(blank);
		
		federal = new JLabel("Federal Withholding");
		panel.add(federal);
		
		tfederal = new JTextField();
		panel.add(tfederal);
		
		state = new JLabel("State Withholding");
		panel.add(state);
		
		tstate = new JTextField();
		panel.add(tstate);
		
		hospital = new JLabel("Hospitalization");
		panel.add(hospital);
		
		thospital = new JTextField();
		panel.add(thospital);
		
		uniondues = new JLabel("Union Dues");
		panel.add(uniondues);
		
		tuniondues = new JTextField();
		panel.add(tuniondues);
		
		blank = new JLabel("");
		panel.add(blank);
		
		hyphens = new JLabel("--------");
		panel.add(hyphens);
		
		total = new JLabel("Total Deductions");
		panel.add(total);
		
		ttotal = new JTextField();
		panel.add(ttotal);
		
		netpay = new JLabel("Net Pay");
		panel.add(netpay);
		
		tnetpay = new JTextField();
		panel.add(tnetpay);
		
		blank = new JLabel("");
		panel.add(blank);
		
		cal = new JButton("Calculate");
		cal.addActionListener(this);
		panel.add(cal);
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 20));
		frame.setTitle("Natural Pine Furniture");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	/*
	 * Displays the pay report when Calculate is clicked
	 * 
	 * @param e	user action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == cal) {
			
			String employeeName = temployee.getText();
			
			double hoursWorked = Double.parseDouble(thourwork.getText());
			double hourlyWage = Double.parseDouble(thourwage.getText());
			
			double grossPay = hoursWorked * hourlyWage;
			tgrosspay.setText(String.valueOf(grossPay));
			
			double federalWithholding = grossPay * FED_WITHHOLD;
			tfederal.setText(String.valueOf(federalWithholding));
			
			double stateWithholding = grossPay * STATE_WITHHOLD;
			tstate.setText(String.valueOf(stateWithholding));
			
			thospital.setText(String.valueOf(HOSPITAL));
			tuniondues.setText(String.valueOf(UNION));
			
			double totalD = federalWithholding + stateWithholding + HOSPITAL + UNION;
			ttotal.setText(String.valueOf(totalD));
			
			double netPay = grossPay - totalD;
			tnetpay.setText(String.valueOf(netPay));
		}
		
	}
	
	/*
	 * Creates an object to run the program
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		new NaturalPineFurniture();
	}
	
	

}
