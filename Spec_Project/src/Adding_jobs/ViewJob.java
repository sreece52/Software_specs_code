package Adding_jobs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import java.awt.Choice;
import javax.swing.JRadioButton;

/**
 * This class creates the window View Job
 * 
 * @author Julia Roscher DATE: 3/23/2016
 *
 */

public class ViewJob extends JFrame implements MouseListener{
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblWorkId;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField textField_2;
	private JLabel lblPhoneNumber;
	private JTextField textField_5;
	private JLabel lblMaterials;
	private JLabel lblHours;
	private JLabel lblNotes;
	private JTextArea txtrPreviewOfNotes;
	private JButton btnViewNotesIn;
	private JLabel lblPdf;
	private JTextField txtListTheFile;
	private JButton btnAddPdf;
	private JLabel lblImages;
	private JTextField txtPreview;
	private JButton btnAddImage;
	private JButton btnSave;
	private JButton btnCancel;
	static ViewJob frame;
	String filename;
	private JScrollPane scrollPane;
	private JTextArea txtrDsafdsa;
	private JSpinner spinner;
	private JLabel lblStartTime;
	private JLabel lblEndTime;
	private JLabel lblDate_1;
	private JLabel lblStreetName;
	private JLabel lblCity;
	private JTextField txtCity;
	private JTextField textField_3;
	private JLabel lblState;
	private JTextField textField_4;
	private JLabel lblZip;
	private JTextField textField_6;
	private JButton btnImportInformationFrom;
	private JTextField txtMmddyyyy;
	private Choice choice;
	private Choice choice_1;
	private JRadioButton rdbtnAm;
	private JRadioButton rdbtnPm;
	private JRadioButton rdbtnAm_1;
	private JRadioButton rdbtnPm_1;
	private JLabel lblJobName;
	private JTextField textField_7;
	static int row;



	/**
	 * Frame Created
	 * 
	 * Since the purpose of this class is to view the selected job's information, all the fields are set to uneditable
	 * 
	 */
	public ViewJob() {
		
		
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 24));
		setTitle("View Job");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 870, 911);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{127, 25, 130, 36, 90, 130, 80, 130, 61, 0};
		gridBagLayout.rowHeights = new int[]{31, 0, 0, 31, 31, 31, 29, 20, 31, 0, 56, 29, 29, 29, 29, 56, 35, 29, 35, 29, 35, 32, 49, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		NameSection();
		AddressSection();
		MaterialsAndNotesSection();
		DateAndTimeSection();
		PdfAndImagesSection();
		BackEditSection();
		IdAndImportSelction();
		
		
	}
	
	/**
	 * This method sets up the JLables, Jtextfields, and Jbutton for Work ID and Import Information Button
	 * 
	 * Work ID is currently editable
	 * 
	 * Import Information Button does not have an action listener
	 * 
	 */	
	public void IdAndImportSelction(){

		lblWorkId = new JLabel("Work ID:");
		lblWorkId.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWorkId.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblWorkId = new GridBagConstraints();
		gbc_lblWorkId.anchor = GridBagConstraints.EAST;
		gbc_lblWorkId.insets = new Insets(0, 0, 5, 5);
		gbc_lblWorkId.gridwidth = 2;
		gbc_lblWorkId.gridx = 0;
		gbc_lblWorkId.gridy = 0;
		getContentPane().add(lblWorkId, gbc_lblWorkId);
		
		//Work ID JtextField
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.EAST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 2;
		gbc_textField.fill = 2;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		getContentPane().add(textField, gbc_textField);
		
		//Import button
		btnImportInformationFrom = new JButton("Import Information from Existing Job");
		btnImportInformationFrom.setEnabled(false);
		btnImportInformationFrom.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_btnImportInformationFrom = new GridBagConstraints();
		gbc_btnImportInformationFrom.gridwidth = 5;
		gbc_btnImportInformationFrom.insets = new Insets(0, 0, 5, 5);
		gbc_btnImportInformationFrom.gridx = 2;
		gbc_btnImportInformationFrom.gridy = 2;
		getContentPane().add(btnImportInformationFrom, gbc_btnImportInformationFrom);
		
	}
	
	/**
	 * This method sets up the Jlabels and Jtextfields for Job Name, First Name, and Last Name
	 * 
	 */
	public void NameSection(){
		
		lblJobName = new JLabel("Job Name:");
		lblJobName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblJobName = new GridBagConstraints();
		gbc_lblJobName.anchor = GridBagConstraints.EAST;
		gbc_lblJobName.gridwidth = 2;
		gbc_lblJobName.insets = new Insets(0, 0, 5, 5);
		gbc_lblJobName.gridx = 0;
		gbc_lblJobName.gridy = 1;
		getContentPane().add(lblJobName, gbc_lblJobName);
		
		//job name textfield
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridwidth = 6;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 1;
		getContentPane().add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridwidth = 2;
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 3;
		getContentPane().add(lblFirstName, gbc_lblFirstName);
		
		//first name textfield
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridwidth = 6;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.EAST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridwidth = 2;
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 4;
		getContentPane().add(lblLastName, gbc_lblLastName);
		
		//last name textfield
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridwidth = 6;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 4;
		getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(30);
		
	}
	
	/**
	 * This method sets up the Jlabels and Jtextfields for street name, city, state, zip, phone number
	 * 
	 */
	public void AddressSection(){

		lblStreetName = new JLabel("Street Name:");
		lblStreetName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblStreetName = new GridBagConstraints();
		gbc_lblStreetName.anchor = GridBagConstraints.EAST;
		gbc_lblStreetName.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreetName.gridwidth = 2;
		gbc_lblStreetName.gridx = 0;
		gbc_lblStreetName.gridy = 6;
		getContentPane().add(lblStreetName, gbc_lblStreetName);
		
		//street name textfield
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 6;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 6;
		getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 1;
		gbc_lblCity.gridy = 7;
		getContentPane().add(lblCity, gbc_lblCity);
		
		//city textfield
		txtCity = new JTextField();
		txtCity.setEditable(false);
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_txtCity = new GridBagConstraints();
		gbc_txtCity.gridwidth = 2;
		gbc_txtCity.insets = new Insets(0, 0, 5, 5);
		gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCity.gridx = 2;
		gbc_txtCity.gridy = 7;
		getContentPane().add(txtCity, gbc_txtCity);
		txtCity.setColumns(10);
		
		lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.anchor = GridBagConstraints.EAST;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 4;
		gbc_lblState.gridy = 7;
		getContentPane().add(lblState, gbc_lblState);
		
		//state textfield
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 5;
		gbc_textField_4.gridy = 7;
		getContentPane().add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		lblZip = new JLabel("Zip:");
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblZip = new GridBagConstraints();
		gbc_lblZip.anchor = GridBagConstraints.EAST;
		gbc_lblZip.insets = new Insets(0, 0, 5, 5);
		gbc_lblZip.gridx = 6;
		gbc_lblZip.gridy = 7;
		getContentPane().add(lblZip, gbc_lblZip);
		
		//zip textfield
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 7;
		gbc_textField_6.gridy = 7;
		getContentPane().add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridwidth = 2;
		gbc_lblPhoneNumber.gridx = 0;
		gbc_lblPhoneNumber.gridy = 8;
		getContentPane().add(lblPhoneNumber, gbc_lblPhoneNumber);
		
		//phone number textfield
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridwidth = 4;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 8;
		getContentPane().add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
	}
	
	/**
	 * This method sets up the Jlabels, JScroolPane, and Jtextfields for materials and 
	 * 
	 * "Add Notes" button has an action listener which opens a second window
	 * 
	 */
	public void MaterialsAndNotesSection(){
		
		lblMaterials = new JLabel("Materials:");
		lblMaterials.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblMaterials = new GridBagConstraints();
		gbc_lblMaterials.anchor = GridBagConstraints.EAST;
		gbc_lblMaterials.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaterials.gridwidth = 2;
		gbc_lblMaterials.gridx = 0;
		gbc_lblMaterials.gridy = 10;
		getContentPane().add(lblMaterials, gbc_lblMaterials);
		
		//Materials JScrollPane
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 10;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		//Materials Textfield
		txtrDsafdsa = new JTextArea();
		txtrDsafdsa.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtrDsafdsa.setEditable(false);
		txtrDsafdsa.setLineWrap(true);
		txtrDsafdsa.setText("Materials go Here");
		scrollPane.setViewportView(txtrDsafdsa);
		
		lblNotes = new JLabel("Notes:");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNotes = new GridBagConstraints();
		gbc_lblNotes.anchor = GridBagConstraints.EAST;
		gbc_lblNotes.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotes.gridwidth = 2;
		gbc_lblNotes.gridx = 0;
		gbc_lblNotes.gridy = 15;
		getContentPane().add(lblNotes, gbc_lblNotes);
		
		//Notes Scroll bar and textfield
		txtrPreviewOfNotes = new JTextArea();
		txtrPreviewOfNotes.setLineWrap(true);
		txtrPreviewOfNotes.setColumns(1);
		txtrPreviewOfNotes.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtrPreviewOfNotes.setText("Preview of Notes Starts Here");
		txtrPreviewOfNotes.setEditable(false);
		GridBagConstraints gbc_txtrPreviewOfNotes = new GridBagConstraints();
		gbc_txtrPreviewOfNotes.fill = GridBagConstraints.BOTH;
		gbc_txtrPreviewOfNotes.insets = new Insets(0, 0, 5, 0);
		gbc_txtrPreviewOfNotes.gridwidth = 7;
		gbc_txtrPreviewOfNotes.gridx = 2;
		gbc_txtrPreviewOfNotes.gridy = 15;
		getContentPane().add(txtrPreviewOfNotes, gbc_txtrPreviewOfNotes);
		
		//button for View notes and action listener
		btnViewNotesIn = new JButton("View Notes in New Window");
		btnViewNotesIn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnViewNotesIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//opens the View Notes window
				ViewNotes editjob = new ViewNotes();
				editjob.setVisible(true);
				
			}
		});
		GridBagConstraints gbc_btnViewNotesIn = new GridBagConstraints();
		gbc_btnViewNotesIn.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewNotesIn.gridwidth = 3;
		gbc_btnViewNotesIn.gridx = 4;
		gbc_btnViewNotesIn.gridy = 16;
		getContentPane().add(btnViewNotesIn, gbc_btnViewNotesIn);
	}
	
	/**
	 * This method sets up the Jlabels, Jtextfields, JSpinner, Choice, and JRadioButton for Date, Hours, Start Time, End Time
	 * 
	 * The choices for Start Time and End Time increment by 15 minutes 
	 * 
	 * The JSpinner for Hours is incremented by .25 hrs
	 * 
	 * The JRadioButtons can only be selected one at a time
	 * 
	 */	
	public void DateAndTimeSection(){

		lblDate_1 = new JLabel("Date:");
		lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblDate_1 = new GridBagConstraints();
		gbc_lblDate_1.anchor = GridBagConstraints.EAST;
		gbc_lblDate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate_1.gridwidth = 2;
		gbc_lblDate_1.gridx = 0;
		gbc_lblDate_1.gridy = 11;
		getContentPane().add(lblDate_1, gbc_lblDate_1);
		
		//Date text field
		txtMmddyyyy = new JTextField();
		txtMmddyyyy.setEditable(false);
		txtMmddyyyy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMmddyyyy.setText("mm/dd/yyyy");
		GridBagConstraints gbc_txtMmddyyyy = new GridBagConstraints();
		gbc_txtMmddyyyy.insets = new Insets(0, 0, 5, 5);
		gbc_txtMmddyyyy.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMmddyyyy.gridx = 2;
		gbc_txtMmddyyyy.gridy = 11;
		getContentPane().add(txtMmddyyyy, gbc_txtMmddyyyy);
		txtMmddyyyy.setColumns(10);
		
		lblHours = new JLabel("Hours:");
		lblHours.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblHours = new GridBagConstraints();
		gbc_lblHours.anchor = GridBagConstraints.EAST;
		gbc_lblHours.insets = new Insets(0, 0, 5, 5);
		gbc_lblHours.gridwidth = 2;
		gbc_lblHours.gridx = 0;
		gbc_lblHours.gridy = 12;
		getContentPane().add(lblHours, gbc_lblHours);
		
		//Hours SpinnerModel, set up by .25 hours increments
		SpinnerModel model = new SpinnerNumberModel( //sets up the hours spinner to increment by .25
				0, //initial value
				0, //min
				150, //max
				.25 //step
				);
		spinner = new JSpinner(model);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setEnabled(false);
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.anchor = GridBagConstraints.WEST;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 12;
		getContentPane().add(spinner, gbc_spinner);
		
		lblStartTime = new JLabel("Start Time:");
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblStartTime = new GridBagConstraints();
		gbc_lblStartTime.anchor = GridBagConstraints.EAST;
		gbc_lblStartTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartTime.gridwidth = 2;
		gbc_lblStartTime.gridx = 0;
		gbc_lblStartTime.gridy = 13;
		getContentPane().add(lblStartTime, gbc_lblStartTime);
		
		//Start Time choice selection. Increments by 15 minutes
		choice = new Choice();
		choice.setEnabled(false);
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice.insets = new Insets(0, 0, 5, 5);
		gbc_choice.gridx = 2;
		gbc_choice.gridy = 13;
		
		int startHour = 12;
		for(int i = 0; i < 12; i ++){
			int startMinute = 0;
			if(startHour > 12){
				startHour = 1;
			}
			for(int j = 0; j < 4; j++){
				if(startMinute == 0){ //This is so 1:00 displays with two zeros instead of one
					choice.add(startHour + " : " + startMinute + startMinute);
					startMinute = startMinute + 15; 
				}else{ //if it is not at the top of the hour it displays the below
				choice.add(startHour + " : " + startMinute);
				startMinute = startMinute + 15; 
				}
			}
			startHour++;		
		}
		getContentPane().add(choice, gbc_choice);
		
		//Start Time JRadioButtons
		rdbtnAm = new JRadioButton("A.M.");
		rdbtnAm.setEnabled(false);
		rdbtnAm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_rdbtnAm = new GridBagConstraints();
		gbc_rdbtnAm.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAm.gridx = 4;
		gbc_rdbtnAm.gridy = 13;
		getContentPane().add(rdbtnAm, gbc_rdbtnAm);
		
		rdbtnPm = new JRadioButton("P.M.");
		rdbtnPm.setEnabled(false);
		rdbtnPm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_rdbtnPm = new GridBagConstraints();
		gbc_rdbtnPm.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPm.gridx = 5;
		gbc_rdbtnPm.gridy = 13;
		getContentPane().add(rdbtnPm, gbc_rdbtnPm);
		
		//JRadioButtons are added to a group so only one can be selected at a time
		ButtonGroup groupStartTime = new ButtonGroup();
		groupStartTime.add(rdbtnPm);
		groupStartTime.add(rdbtnAm);
		
		lblEndTime = new JLabel("End Time:");
		lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblEndTime = new GridBagConstraints();
		gbc_lblEndTime.anchor = GridBagConstraints.EAST;
		gbc_lblEndTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndTime.gridwidth = 2;
		gbc_lblEndTime.gridx = 0;
		gbc_lblEndTime.gridy = 14;
		getContentPane().add(lblEndTime, gbc_lblEndTime);
		
		//EndTime JRadioButtons
		rdbtnAm_1 = new JRadioButton("A.M.");
		rdbtnAm_1.setEnabled(false);
		rdbtnAm_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_rdbtnAm_1 = new GridBagConstraints();
		gbc_rdbtnAm_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAm_1.gridx = 4;
		gbc_rdbtnAm_1.gridy = 14;
		getContentPane().add(rdbtnAm_1, gbc_rdbtnAm_1);
		
		rdbtnPm_1 = new JRadioButton("P.M.");
		rdbtnPm_1.setEnabled(false);
		rdbtnPm_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_rdbtnPm_1 = new GridBagConstraints();
		gbc_rdbtnPm_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPm_1.gridx = 5;
		gbc_rdbtnPm_1.gridy = 14;
		getContentPane().add(rdbtnPm_1, gbc_rdbtnPm_1);
		
		//JRadioButtons are added to a group so only one can be selected at a time
				ButtonGroup groupEndTime = new ButtonGroup();
				groupEndTime.add(rdbtnPm_1);
				groupEndTime.add(rdbtnAm_1);
		
		//End Time choices. Displayed by 15 minute increments
		choice_1 = new Choice();
		choice_1.setEnabled(false);
		GridBagConstraints gbc_choice_1 = new GridBagConstraints();
		gbc_choice_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice_1.insets = new Insets(0, 0, 5, 5);
		gbc_choice_1.gridx = 2;
		gbc_choice_1.gridy = 14;
	
		int endHour = 12;
		for(int i = 0; i < 12; i ++){
			int endMinute = 0;
			if(endHour > 12){
				endHour = 1;
			}
			for(int j = 0; j < 4; j++){
				if(endMinute == 0){ //This is so 1:00 displays with two zeros instead of one
					choice_1.add(endHour + " : " + endMinute + endMinute);
					endMinute = endMinute + 15; 
				}else{ //if it is not at the top of the hour it displays the below
				choice_1.add(endHour + " : " + endMinute);
				endMinute = endMinute + 15; 
				}
			}
			endHour++;		
		}		
		getContentPane().add(choice_1, gbc_choice_1);
			
	}
	
	/**
	 * This method sets up the Jlabels, Jtextfields, actionlisteners, and buttons for PDF and Images
	 * 
	 * "Add PDF" and "Add Image" open a FileDialog when selected
	 * 
	 */	
	public void PdfAndImagesSection(){

		lblPdf = new JLabel("PDF:");
		lblPdf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblPdf = new GridBagConstraints();
		gbc_lblPdf.anchor = GridBagConstraints.EAST;
		gbc_lblPdf.insets = new Insets(0, 0, 5, 5);
		gbc_lblPdf.gridwidth = 2;
		gbc_lblPdf.gridx = 0;
		gbc_lblPdf.gridy = 17;
		getContentPane().add(lblPdf, gbc_lblPdf);
		
		//PDF JTextField that displays the saved PDF
		txtListTheFile = new JTextField();
		txtListTheFile.setEditable(false);
		txtListTheFile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtListTheFile.setText("List the file names of the added PDF's");
		GridBagConstraints gbc_txtListTheFile = new GridBagConstraints();
		gbc_txtListTheFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtListTheFile.insets = new Insets(0, 0, 5, 0);
		gbc_txtListTheFile.gridwidth = 7;
		gbc_txtListTheFile.gridx = 2;
		gbc_txtListTheFile.gridy = 17;
		getContentPane().add(txtListTheFile, gbc_txtListTheFile);
		txtListTheFile.setColumns(10);
		
		//"Add PDF" button and action listener
		btnAddPdf = new JButton("Add PDF");
		btnAddPdf.setEnabled(false);
		btnAddPdf.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_btnAddPdf = new GridBagConstraints();
		gbc_btnAddPdf.anchor = GridBagConstraints.EAST;
		gbc_btnAddPdf.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddPdf.gridwidth = 2;
		gbc_btnAddPdf.gridx = 2;
		gbc_btnAddPdf.gridy = 18;
		getContentPane().add(btnAddPdf, gbc_btnAddPdf);
		
		btnAddPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add PDF button pressed");

				FileDialog fd = new FileDialog(frame, "Choose a file", FileDialog.LOAD);
				fd.setDirectory("C:\\");
				fd.setFile("*.pdf");
				fd.setVisible(true);
				filename = fd.getFile();
				if (filename == null)
				  System.out.println("You cancelled the choice");
				else{
				  System.out.println("You chose " + filename);
				  
				}
				if(filename != null){
					System.out.println(filename);
					txtListTheFile.setText(filename);	
					
				}
			}
		});
		
		lblImages = new JLabel("Images:");
		lblImages.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblImages = new GridBagConstraints();
		gbc_lblImages.anchor = GridBagConstraints.EAST;
		gbc_lblImages.insets = new Insets(0, 0, 5, 5);
		gbc_lblImages.gridwidth = 2;
		gbc_lblImages.gridx = 0;
		gbc_lblImages.gridy = 19;
		getContentPane().add(lblImages, gbc_lblImages);
		
		//Images JTextField
		txtPreview = new JTextField();
		txtPreview.setEditable(false);
		txtPreview.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPreview.setText("Preview Images or File Name of picture");
		GridBagConstraints gbc_txtPreview = new GridBagConstraints();
		gbc_txtPreview.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPreview.insets = new Insets(0, 0, 5, 0);
		gbc_txtPreview.gridwidth = 7;
		gbc_txtPreview.gridx = 2;
		gbc_txtPreview.gridy = 19;
		getContentPane().add(txtPreview, gbc_txtPreview);
		txtPreview.setColumns(10);
		
		//"Add Image" button and actionlistener
		btnAddImage = new JButton("Add Image");
		btnAddImage.setEnabled(false);
		btnAddImage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_btnAddImage = new GridBagConstraints();
		gbc_btnAddImage.anchor = GridBagConstraints.EAST;
		gbc_btnAddImage.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddImage.gridwidth = 2;
		gbc_btnAddImage.gridx = 2;
		gbc_btnAddImage.gridy = 20;
		getContentPane().add(btnAddImage, gbc_btnAddImage);
		
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add Image button pressed");

				FileDialog fd = new FileDialog(frame, "Choose an Image", FileDialog.LOAD);
				fd.setDirectory("C:\\");
				fd.setFile("*.jpg");
				fd.setVisible(true);
				filename = fd.getFile();
				if (filename == null)
				  System.out.println("You cancelled the choice");
				else{
				  System.out.println("You chose " + filename);
				  
				}
				if(filename != null){
					System.out.println(filename);
					txtPreview.setText(filename);
					
				}
			}
		});
		
	}
	
	/**
	 * This method sets up the Jbuttons and acitonlisteners for Back and Edit
	 * 
	 */	
	public void BackEditSection(){

		//Back Button and Actionlistener
		btnCancel = new JButton("Back");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.gridwidth = 2;
		gbc_btnCancel.anchor = GridBagConstraints.SOUTH;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 22;
		getContentPane().add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Test editjob = new Test();
				editjob.setVisible(true);
				dispose();
			}
		});
		
		//edit button and actionlistener
		btnSave = new JButton("Edit");
		btnSave.setForeground(Color.BLUE);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 33));
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("save button pressed");
				
				//EditJob editjob = new EditJob();
				//editjob.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.gridwidth = 3;
		gbc_btnSave.anchor = GridBagConstraints.SOUTH;
		gbc_btnSave.gridx = 7;
		gbc_btnSave.gridy = 22;
		getContentPane().add(btnSave, gbc_btnSave);		
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewJob();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
	
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
