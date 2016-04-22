package MainScreen;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Calendar.JCalendarDialog;
import Search_DB.Search_GUI;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

/**
 * Builds the home screen.
 * @author josh
 */
@SuppressWarnings("serial")
public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		/*Set constraints for window*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());
		contentPane.setLayout(null);
		
		/*Panel to hold navigation buttons*/
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(103, 61, 83, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*Button opens calendar*/
		JButton calendarButton = new JButton(new ImageIcon(((new ImageIcon(
	            "calendarIcon.png").getImage()
	            .getScaledInstance(64, 50,
	                    java.awt.Image.SCALE_SMOOTH)))));
		calendarButton.setBounds(10, 11, 64, 54);
		Color lightpurple = new Color(255, 220, 255);
		calendarButton.setBackground(lightpurple);
	
		panel.add(calendarButton);
		calendarButton.setFont(new Font("Dialog", Font.BOLD, 14));
		calendarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCalendarDialog dialog = new JCalendarDialog();
				dialog.setDialogTitle("HandyMan Calendar");
				dialog.createDialog();
				if(dialog.getReturnCode() == JCalendarDialog.OK_PRESSED)
					dialog.dispose();
			
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
	                    .format(new java.util.Date()) + 
	                    ": MainScreen -> Clicked Calendar Button/Open calendar");
			}
			
		});
		
		/*Subsection for search parameters*/
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 153, 269, 96);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		final JTextField searchField = new JTextField("Search");
		searchField.setBounds(10, 33, 110, 25);
		panel_1.add(searchField);
		searchField.setFont(new Font("Dialog", Font.PLAIN, 14));
		final JComboBox<String> searchFilters = new JComboBox<String>();
		searchFilters.setBounds(135, 33, 124, 25);
		panel_1.add(searchFilters);
		searchFilters.setFont(new Font("Dialog", Font.BOLD, 14));
		
		/*Subsection for search and exit buttons*/
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 265, 269, 47);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		/*Set up search button*/
		JButton searchButton = new JButton("Search");
		Color green = new Color(150, 255, 150);
		searchButton.setBackground(green);
		searchButton.setBounds(10, 11, 110, 27);
		panel_2.add(searchButton);
		searchButton.setFont(new Font("Dialog", Font.BOLD, 14));
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new Search_GUI(searchField.getText(), searchFilters.getSelectedItem().toString());
				
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
	                    .format(new java.util.Date()) + 
	                    ": MainScreen -> clicked search button/goes to search results based on input");
			}
		});
		
		/*Set up exit button*/
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(140, 11, 124, 27);
		Color red = new Color(255, 110, 110);
		btnExit.setBackground(red);
		panel_2.add(btnExit);
		btnExit.setFont(new Font("Dialog", Font.BOLD, 14));
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0); //0 denotes normal exit
				
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
	                    .format(new java.util.Date()) + 
	                    ": MainScreen -> Exit program/program closes");
			}
		});
		
		
		/*Window title*/
		JLabel lblHandymanScheduler = new JLabel("Handyman Scheduler");
		lblHandymanScheduler.setForeground(new Color(0, 139, 139));
		lblHandymanScheduler.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHandymanScheduler.setBounds(46, 16, 200, 28);
		contentPane.add(lblHandymanScheduler);
		
		/*Combobox to hold search filters*/
		searchFilters.addItem("First Name");
		searchFilters.addItem("Last Name");
		searchFilters.addItem("Date");
		searchFilters.addItem("Address");
		searchFilters.addItem("Show All");
		searchField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent arg0) {
				searchField.setText("");
				
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
	                    .format(new java.util.Date()) + 
	                    ": MainScreen -> Clicked combobox options/shows options");
			}
			public void focusLost(FocusEvent arg0) {
				//do nothing
			}
		});
		
	}
	
	/**
	 * Retrieves image for use as program icon.
	 * @return image to be used
	 */
	public static Image getImage() {
		Image image = null;
		try {
			File pic = new File("Handyman Scheduler Logo 1.png");
			image = ImageIO.read(pic).getScaledInstance(20, -20, 0);
		} catch (IOException e) {
			
			
		System.out.println((new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date()) + ": MainScren -> Icon didnt load"));
		e.printStackTrace();
		}
		return image;
	}
}
