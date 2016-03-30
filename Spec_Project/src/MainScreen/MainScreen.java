package MainScreen;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Calendar.Calendar;
import Calendar.JCalendar;
import Calendar.JCalendarDialog;
import Search_DB.Search_GUI;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.Image;


/**
 * 
 * @author josh
 * @TODO Ask client for full name search compatibility
 */
public class MainScreen extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		/*Set constraints for window*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		Image image = getImage();
		
		/*Button disposes current frame and creates Calendar frame*/
		JButton calendarButton = new JButton(new ImageIcon(image));
		calendarButton.setFont(new Font("Dialog", Font.BOLD, 14));
		calendarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JCalendarDialog dialog = new JCalendarDialog();
				dialog.setDialogTitle("HandyMan Calendar");
				//dialog.setLocale(Locale.ENGLISH);
				dialog.createDialog();
				if(dialog.getReturnCode() == JCalendarDialog.OK_PRESSED)
					dialog.dispose();
			}
		});
		
		
		/*Layout manager for main screen*/
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, calendarButton, 20, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, calendarButton, 75, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, calendarButton, -220, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, calendarButton, -77, SpringLayout.EAST, contentPane);
		contentPane.setLayout(sl_contentPane);
		contentPane.add(calendarButton);
		
		/*Constraints and setup for search field*/
		final JTextField searchField = new JTextField("Search");
		sl_contentPane.putConstraint(SpringLayout.WEST, searchField, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, searchField, 121, SpringLayout.WEST, contentPane);
		searchField.setFont(new Font("Dialog", Font.PLAIN, 14));
		searchField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent arg0) {
				searchField.setText("");
			}
			public void focusLost(FocusEvent arg0) {
				//do nothing
			}
		});
		contentPane.add(searchField);
		
		/*Combo box to contain search filters*/
		final JComboBox<String> searchFilters = new JComboBox<String>();
		sl_contentPane.putConstraint(SpringLayout.NORTH, searchField, 1, SpringLayout.NORTH, searchFilters);
		sl_contentPane.putConstraint(SpringLayout.NORTH, searchFilters, 52, SpringLayout.SOUTH, calendarButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, searchFilters, -121, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, searchFilters, -10, SpringLayout.EAST, contentPane);
		searchFilters.setFont(new Font("Dialog", Font.BOLD, 14));
		searchFilters.addItem("First Name");
		searchFilters.addItem("Last Name");
		searchFilters.addItem("Date");
		searchFilters.addItem("Address");
		searchFilters.addItem("Show All");
		contentPane.add(searchFilters);
		
		/*Button to initiate search*/
		JButton searchButton = new JButton("Search");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, searchField, -17, SpringLayout.NORTH, searchButton);
		sl_contentPane.putConstraint(SpringLayout.NORTH, searchButton, 161, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, searchButton, 75, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, searchButton, 0, SpringLayout.EAST, calendarButton);
		searchButton.setFont(new Font("Dialog", Font.BOLD, 14));
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new Search_GUI(searchField.getText(), searchFilters.getSelectedItem().toString());
			}
		});
//		contentPane.add(searchButton);
		
		/*Button to close program*/
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Dialog", Font.BOLD, 14));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, searchButton, -34, SpringLayout.NORTH, btnExit);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnExit, 175, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnExit, -10, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnExit, -10, SpringLayout.SOUTH, contentPane);
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0); //0 denotes normal exit
			}
		});
		contentPane.add(btnExit);
	}
	
	public static Image getImage() {
		Image image = null;
		try {
			File pic = new File("Handyman Scheduler Logo 1.png");
			image = ImageIO.read(pic).getScaledInstance(20, -20, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
