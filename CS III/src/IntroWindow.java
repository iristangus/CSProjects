// This will be the intro page

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class IntroWindow extends JFrame implements ActionListener {

  // Components
  private JFrame frame;
  private JPanel introPanel;
  private JPanel languagePanel;
//  private JPanel profileButtonPanel;
  private JLabel name;
  private JLabel greeting;
  private JLabel select;
  private JButton english;
  private JButton spanish;
//  private JButton french;
//  private JButton profileButton;
  
  // Colors used in the UI
  private Color light = new Color(235, 230, 235);
  private Color lavender = new Color(188, 186, 234);
  private Color dark = new Color(30, 15, 65);
  
  /*
   * Constructor that initializes components
   */
  public IntroWindow(){

	// New frame
	frame = new JFrame();
    frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH); // full screen
    frame.getContentPane().setBackground(light); // light background color
    frame.setForeground(dark); // dark text color
  
    // Panel to hold the JLabels
    introPanel = new JPanel();
    BoxLayout introboxlayout = new BoxLayout(introPanel, BoxLayout.Y_AXIS); // goes along the y axis
    introPanel.setLayout(introboxlayout);
    introPanel.setBackground(light); // light bg color
    introPanel.setBorder(BorderFactory.createEmptyBorder(100, 30, 30, 30)); // border between other panels

    // Name text
    name = new JLabel("Language Chatbot");
    name.setForeground(dark); // text color
    name.setFont(new Font("Century Gothic", Font.PLAIN, 80)); // font
    name.setAlignmentX(Component.CENTER_ALIGNMENT); // aligned center
    introPanel.add(name);

    // Greeting text
    greeting = new JLabel("Welcome!");
    greeting.setForeground(dark); // text color
    greeting.setFont(new Font("Century Gothic", Font.PLAIN, 40)); // font
    greeting.setAlignmentX(Component.CENTER_ALIGNMENT); // aligned center
    greeting.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // vertical border between other jlabels
    introPanel.add(greeting);

    // Text to select a language
    select = new JLabel("Select a language:");
    select.setForeground(dark); // text color
    select.setFont(new Font("Century Gothic", Font.PLAIN, 40)); // font
    select.setAlignmentX(Component.CENTER_ALIGNMENT); // aligned center
    introPanel.add(select);
    
    // Panel for the language buttons
    languagePanel = new JPanel();
    GridLayout gridlayout = new GridLayout(1, 3, 80, 20); // 3 x 1 grid w/ spacing
    languagePanel.setLayout(gridlayout);
    languagePanel.setBorder(BorderFactory.createEmptyBorder(30, 160, 110, 160)); // border between jpanels
    languagePanel.setBackground(light); // bg color
    languagePanel.setAlignmentX(Component.CENTER_ALIGNMENT); // aligned to center
    
    // English button
    english = new JButton("English");
    english.setPreferredSize(new Dimension(200, 200)); // size for all jbuttons
    english.setFont(new Font("Century Gothic", Font.PLAIN, 40)); // font
    english.setBackground(lavender); // button color
    english.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // border, looks raised
    english.addActionListener(this); // clicks have action
    languagePanel.add(english);
    
    // Spanish Button
    spanish = new JButton("Spanish");
    spanish.setFont(new Font("Century Gothic", Font.PLAIN, 40)); // font
    spanish.setBackground(lavender); // button color
    spanish.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // border, looks raised
    spanish.addActionListener(this); // clicks have action
    languagePanel.add(spanish);
    
//    // French Button
//    french = new JButton("French");
//    french.setFont(new Font("Century Gothic", Font.PLAIN, 40)); // font
//    french.setBackground(lavender); // button color
//    french.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // border, looks raised
//    french.addActionListener(this); // clicks have action
//    languagePanel.add(french);
      
//    // Panel containing the profile button
//    profileButtonPanel = new JPanel();
//    profileButtonPanel.setLayout(new BorderLayout());
//    profileButtonPanel.setBackground(light);
//    profileButtonPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
//    profileButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//    
//    // Gets ImageIcon for the profile button
//    // Converts it to the right size
//    ImageIcon icon = new ImageIcon("ProfileIcon.jpg");
//    Image image = icon.getImage(); // transform it 
//    Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly 
//    icon = new ImageIcon(newimg);  // transform it back
//    
//    // Profile Button
//    profileButton = new JButton(icon);
//    profileButton.setPreferredSize(new Dimension(50, 50)); // size
//    profileButton.setBorder(BorderFactory.createEmptyBorder()); // border around it
//    profileButton.addActionListener(this); // clicks have action
//    profileButton.setBackground(frame.getBackground()); // blends in with bg
//    profileButtonPanel.add(profileButton, BorderLayout.EAST); // aligned to right
    
    // Adds all components to the frame
    frame.setTitle("Language Chatbot"); // window title
	frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // can close
	frame.setResizable(false); // can't resize
    frame.add(introPanel); // adds jlabel panels
    frame.add(languagePanel, BorderLayout.SOUTH); // adds buttons to the bottom
//    frame.add(profileButtonPanel, BorderLayout.NORTH); // adds profile button to the top
    frame.setVisible(true); // frame is visible
  }

  /*
   * Runs the different languages when buttons are pressed
   * 
   * @param e	user action
   */
  @Override
  public void actionPerformed(ActionEvent e){
    
	if (e.getSource() == english) {
		// Run english chat
	} else if (e.getSource() == spanish) {
		// Run spanish chat
	} 
//	else if (e.getSource() == french) {
//		// Run french chat
//	}
  }
  
  /*
   * Creates a new IntroWindow
   * 
   * @param args	console input
   */
  public static void main(String[] args) {
    new IntroWindow();
  }
}