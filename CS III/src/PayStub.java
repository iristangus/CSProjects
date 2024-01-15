// Iris T
// CS 3 Summer 1522-1523
// Java Graphics Quiz
// Calculates the pay from a week of work
// PayStub
// 7/26/22

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class PayStub extends JFrame implements ActionListener{

	// Components
	private JLabel payrate;
	private JTextField tpayrate;
	private JLabel hours;
	private JLabel pay;
	private JLabel mon;
	private JTextField monh;
	private JTextField monp;
	private JLabel tue;
	private JTextField tueh;
	private JTextField tuep;
	private JLabel wed;
	private JTextField wedh;
	private JTextField wedp;
	private JLabel thur;
	private JTextField thurh;
	private JTextField thurp;
	private JLabel fri;
	private JTextField frih;
	private JTextField frip;
	private JLabel overall;
	private JTextField toverall;
	private JPanel buttonPanel;
	private JButton cal;
	private JFrame frame;
	private JLabel blank;
	
	/*
	 * Constructor to initialize components
	 */
	public PayStub() {
		
		frame = new JFrame();
		
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(8, 3, 20, 20);
		panel.setLayout(layout);
		
		payrate = new JLabel("Payrate:");
		panel.add(payrate);
		
		tpayrate = new JTextField();
		tpayrate.setPreferredSize(new Dimension(200, 20));
		panel.add(tpayrate);
		
		blank = new JLabel("");
		panel.add(blank);
		
		blank = new JLabel("");
		panel.add(blank);
		
		hours = new JLabel("Hours");
		panel.add(hours);
		
		pay = new JLabel("Pay");
		panel.add(pay);
				
		mon = new JLabel("Monday");
		panel.add(mon);
		
		monh = new JTextField();
		panel.add(monh);
		
		monp = new JTextField();
		panel.add(monp);
		
		tue = new JLabel("Tuesday");
		panel.add(tue);
		
		tueh = new JTextField();
		panel.add(tueh);
		
		tuep = new JTextField();
		panel.add(tuep);
		
		wed = new JLabel("Wednesday");
		panel.add(wed);
		
		wedh = new JTextField();
		panel.add(wedh);
		
		wedp = new JTextField();
		panel.add(wedp);
		
		thur = new JLabel("Thursday");
		panel.add(thur);
		
		thurh = new JTextField();
		panel.add(thurh);
		
		thurp = new JTextField();
		panel.add(thurp);
		
		fri = new JLabel("Friday");
		panel.add(fri);
		
		frih = new JTextField();
		panel.add(frih);
		
		frip = new JTextField();
		panel.add(frip);
		
		overall = new JLabel("Overall Pay");
		panel.add(overall);
		
		blank = new JLabel("");
		panel.add(blank);
		
		toverall = new JTextField();
		panel.add(toverall);
		
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,30,30));
		frame.setTitle("PayStub");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel, BorderLayout.NORTH);
		
		buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		
		cal = new JButton("Calculate");
		cal.addActionListener(this);
		buttonPanel.add(cal);
		
		frame.add(buttonPanel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	/*
	 * When the user clicks Calculate, displays pay
	 * 
	 * @param e	user action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cal) {
			
			double rate = Double.parseDouble(tpayrate.getText());
			
			double monhours = Double.parseDouble(monh.getText());
			double monpay = monhours * rate;
			monp.setText(String.valueOf(monpay));
			
			double tuehours = Double.parseDouble(tueh.getText());
			double tuepay = tuehours * rate;
			tuep.setText(String.valueOf(tuepay));
			
			double wedhours = Double.parseDouble(wedh.getText());
			double wedpay = wedhours * rate;
			wedp.setText(String.valueOf(wedpay));
			
			double thurhours = Double.parseDouble(thurh.getText());
			double thurpay = thurhours * rate;
			thurp.setText(String.valueOf(thurpay));
			
			double frihours = Double.parseDouble(frih.getText());
			double fripay = frihours * rate;
			frip.setText(String.valueOf(fripay));
			
			double overallpay = monpay + tuepay + wedpay + thurpay + fripay;
			toverall.setText(String.valueOf(overallpay));
		}
		
	}
	
	/*
	 * Creates an object to run the program
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		new PayStub();
	}

}
