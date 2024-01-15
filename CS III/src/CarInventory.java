// Iris T
// CS 3 Summer 2022-2023
// CarInventoryQuiz
// Given a vehicle id, displays the information and picture of a car
// CarInventory
// 7/27/22

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class CarInventory extends JFrame implements ActionListener{
	
	// ArrayList of car objects
	private static ArrayList<Car> carArrayList = new ArrayList<Car>();
	// Car that corresponds to the vehicle id
	private Car selectedCar;
	// Dimensions of the car image
	private int imageDimensions = 200;
	
	// Components
	private JFrame frame;
	private JPanel panel;
	private JLabel title;
	private JLabel id;
	private JTextField tid;
	private JLabel make;
	private JTextField tmake;
	private JLabel model;
	private JTextField tmodel;
	private JLabel year;
	private JTextField tyear;
	private JLabel price;
	private JTextField tprice;
	private JButton search;
	private JTextField idinput;
	private JPanel carPanel;
	private JLabel car;
	private JButton show;

	/*
	 * Constructor that initializes components
	 */
	public CarInventory() {
		
		frame = new JFrame();
		frame.setTitle("Car Inventory");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		title = new JLabel("Car Inventory", SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.PLAIN, 30));
				
		panel = new JPanel();
		GridLayout gridlayout = new GridLayout(6, 2, 30, 10);
		panel.setLayout(gridlayout);
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		id = new JLabel("Vehicle ID");
		panel.add(id);
		
		tid = new JTextField();
		tid.setPreferredSize(new Dimension(100, 20));
		panel.add(tid);
		
		make = new JLabel("Make");
		panel.add(make);
		
		tmake = new JTextField();
		panel.add(tmake);
		
		model = new JLabel("Model");
		panel.add(model);
		
		tmodel = new JTextField();
		panel.add(tmodel);
		
		year = new JLabel("Year");
		panel.add(year);
		
		tyear = new JTextField();
		panel.add(tyear);
		
		price = new JLabel("Price");
		panel.add(price);
		
		tprice = new JTextField();
		panel.add(tprice);
		
		search = new JButton("Search");
		search.addActionListener(this);
		panel.add(search);
		
		idinput = new JTextField();
		panel.add(idinput);
		
		carPanel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(carPanel, BoxLayout.Y_AXIS);
		carPanel.setLayout(boxlayout);
	    
		car = new JLabel(transformImg(new ImageIcon("blank.jpg")));
		car.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		carPanel.add(car);
		
		show = new JButton("Show Picture");
		show.addActionListener(this);
		carPanel.add(show);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.WEST);
		frame.add(carPanel, BorderLayout.EAST);
		frame.pack();
		frame.setVisible(true);
	}
	
	/*
	 * Converts an image to a consistent size
	 * 
	 * @param icon	original ImageIcon
	 * @return transformed ImageIcon
	 */
	public ImageIcon transformImg(ImageIcon icon) {
	    Image image = icon.getImage();
	    Image newimg = image.getScaledInstance(imageDimensions, imageDimensions,  java.awt.Image.SCALE_SMOOTH);
	    return new ImageIcon(newimg);
	}
	
	/*
	 * Carries out user action
	 * Search - displays information of the car with that vehicle id
	 * Show Picture - displays image of the car
	 * 
	 * @param e	user action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == search) {
			
			String userid = idinput.getText();
			
			// Goes through carArrayList and finds the car with the same vehicle id
			for (int i = 0; i < carArrayList.size(); i++) {
				Car c = carArrayList.get(i);
				if (c.getid().equals(userid)) {
					selectedCar = c;
					tid.setText(c.getid());
					tmake.setText(c.getmake());
					tmodel.setText(c.getmodel());
					tyear.setText(c.getyear());
					tprice.setText(c.getprice());
				}
			}
		}
		
		// Displays transformed image
		if (e.getSource() == show) {
			car.setIcon(transformImg(new ImageIcon(selectedCar.getid() + ".jpg")));
		}
		
	}
	
	/*
	 * Scans CarData.txt to create some Car objects with that info
	 * Creates a new CarInventory object to run the GUI
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("CarData.txt"));
			
			while(scan.hasNext()) {
				
				String scanid = scan.next();
				String scanmake = scan.next();
				String scanmodel = scan.next();
				String scanyear = scan.next();
				String scanprice = scan.next();
				
				carArrayList.add(new Car(scanid, scanmake, scanmodel, scanyear, scanprice));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
		
		new CarInventory();
	}

}
