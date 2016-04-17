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
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

/**
 * 
 * @author josh
 * @TODO Ask client for full name search compatibility some comment
 */
public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application. New commit
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
		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());
		
		
		
		//Image image = getImage();
		
		/*Button disposes current frame and creates Calendar frame*/
		contentPane.setLayout(null);
		
		/*Constraints and setup for search field*/
		
		/*Combo box to contain search filters*/
		
		/*Button to initiate search*/
		
		/*Button to close program*/
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(97, 11, 83, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton calendarButton = new JButton(new ImageIcon(((new ImageIcon(
	            "calendarIcon.png").getImage()
	            .getScaledInstance(64, 50,
	                    java.awt.Image.SCALE_SMOOTH)))));
		calendarButton.setBounds(10, 11, 64, 54);
		panel.add(calendarButton);
		calendarButton.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 98, 269, 96);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 205, 269, 47);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(10, 11, 110, 27);
		panel_2.add(searchButton);
		searchButton.setFont(new Font("Dialog", Font.BOLD, 14));
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(140, 11, 124, 27);
		panel_2.add(btnExit);
		btnExit.setFont(new Font("Dialog", Font.BOLD, 14));
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0); //0 denotes normal exit
			}
		});
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new Search_GUI(searchField.getText(), searchFilters.getSelectedItem().toString());
			}
		});
		searchFilters.addItem("First Name");
		searchFilters.addItem("Last Name");
		searchFilters.addItem("Date");
		searchFilters.addItem("Address");
		searchFilters.addItem("Show All");
		searchField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent arg0) {
				searchField.setText("");
			}
			public void focusLost(FocusEvent arg0) {
				//do nothing
			}
		});
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
