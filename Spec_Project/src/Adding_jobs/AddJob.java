package Adding_jobs;

import java.awt.EventQueue;
import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Search_DB.ImportJob;
import Search_DB.Inserting_Driver;
import Search_DB.Jobs;
import Search_DB.Search_GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Choice;
import javax.swing.JRadioButton;

/**
 * This class creates the window Add Job
 * 
 * @author Julia Roscher DATE: 3/23/2016
 *
 * @Update Cleaned up the imports and mouse Listner. Noticed it was needed so I
 *         removed it. added to the add job events to load info to database -
 *         Shawn
 */

@SuppressWarnings("serial")
public class AddJob extends JFrame {
	private JTextField fname_txt;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField lname_txt;
	private JLabel lblPhoneNumber;
	private JTextField phone_txt;
	private JLabel lblMaterials;
	private JLabel lblHours;
	private JLabel lblNotes;
	private JTextArea notes_txt;
	private JButton btnViewNotesIn;
	private JLabel lblPdf;
	private JTextField pdf_file_txt;
	private JButton btnAddPdf;
	private JLabel lblImages;
	private JTextField image_txt;
	private JButton btnAddImage;
	private JButton btnSave;
	private JButton btnCancel;
	static AddJob frame;
	String filename;
	private JScrollPane scrollPane;
	private JTextArea materials_txt;
	private JSpinner hours_spinner;
	private JLabel lblStartTime;
	private JLabel lblEndTime;
	private JLabel lblDate_1;
	private JLabel lblStreetName;
	private JLabel lblCity;
	private JTextField city_txt;
	private JTextField street_txt;
	private JLabel lblState;
	private JTextField state_txt;
	private JLabel lblZip;
	private JTextField zip_txt;
	private JButton btnImportInformationFrom;
	private JTextField date_txt;
	private Choice start_txt;
	private Choice end_txt;
	private JRadioButton rdbtnAm_start;
	private JRadioButton rdbtnPm_start;
	private JRadioButton rdbtnAm_end;
	private JRadioButton rdbtnPm_end;
	private JLabel lblJobName;
	private JTextField job_name_txt;
	private String query;
	private String search;
	private AddJob added = this;
	private ImportJob importedJob;
	private Jobs job;
	private boolean newJobAdd = false;

	// varibles needed to create a job object

	/**
	 * Frame Created
	 * 
	 * @wbp.parser.constructor
	 */
<<<<<<< HEAD
	public AddJob() {

		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 24));
=======
	public AddJob(String query, String search) {
		this.query = query;
		this.search = search;
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setTitle("Add Job");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 779, 739);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 82, 25, 130, 36, 90, 130, 80, 130, 61, 0 };
		gridBagLayout.rowHeights = new int[] { 31, 0, 0, 31, 31, 31, 29, 20, 31, 0, 56, 29, 29, 29, 29, 56, 35, 29, 35,
				29, 35, 32, 49, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		
		getContentPane().setLayout(gridBagLayout);
		this.setVisible(true);
		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());

		NameSection();
		AddressSection();
		MaterialsAndNotesSection();
		DateAndTimeSection();
		PdfAndImagesSection();
		CancelSaveSection();
		IdAndImportSelction();

	}

	public AddJob(Jobs job, String query, String search) {
		this.query = query;
		this.search = search;
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
>>>>>>> refs/remotes/origin/master
		setTitle("Add Job");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 972, 945);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 127, 25, 130, 36, 90, 130, 80, 130, 61, 0 };
		gridBagLayout.rowHeights = new int[] { 31, 0, 0, 31, 31, 31, 29, 20, 31, 0, 56, 29, 29, 29, 29, 56, 35, 29, 35,
				29, 35, 32, 49, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		
		JScrollPane scroll = new JScrollPane();
		getContentPane().add(scroll);
		
		getContentPane().setLayout(gridBagLayout);
		this.setVisible(true);
		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());

		JScrollPane scroller = new JScrollPane(this);
		this.getContentPane().add(scroller,  this);
		
		NameSection();
		AddressSection();
		MaterialsAndNotesSection();
		DateAndTimeSection();
		PdfAndImagesSection();
		CancelSaveSection();
		IdAndImportSelction();

	}

	/**
	 * This method sets up the JLables, Jtextfields, and Jbutton for Work ID and
	 * Import Information Button
	 * 
	 * Work ID is currently editable
	 * 
	 * Import Information Button does not have an action listener
	 * 
	 */
	public void IdAndImportSelction() {
	
		

		// Import button
		btnImportInformationFrom = new JButton("Import Information from Existing Job");
		btnImportInformationFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnImportInformationFrom = new GridBagConstraints();
		gbc_btnImportInformationFrom.gridwidth = 5;
		gbc_btnImportInformationFrom.insets = new Insets(0, 0, 5, 5);
		gbc_btnImportInformationFrom.gridx = 2;
		gbc_btnImportInformationFrom.gridy = 2;
		getContentPane().add(btnImportInformationFrom, gbc_btnImportInformationFrom);
						
								// Cancel Button and Actionlistener
								btnCancel = new JButton("Cancel");
								btnCancel.setForeground(Color.WHITE);
								btnCancel.setBackground(Color.red);
								btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
								GridBagConstraints gbc_btnCancel = new GridBagConstraints();
								gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
								gbc_btnCancel.gridwidth = 2;
								gbc_btnCancel.anchor = GridBagConstraints.SOUTH;
								gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
								gbc_btnCancel.gridx = 3;
								gbc_btnCancel.gridy = 21;
								getContentPane().add(btnCancel, gbc_btnCancel);
								btnCancel.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										new Search_GUI(query, search);
										dispose();
									}
								});
						
								// Save button and actionlistener
								btnSave = new JButton("Save");
								btnSave.setForeground(Color.WHITE);
								btnSave.setBackground(new Color(0,102,206));
								btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
								
										btnSave.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
								
												Jobs newJob = new Jobs(null, job_name_txt.getText(), fname_txt.getText(), lname_txt.getText(),
														street_txt.getText(), city_txt.getText(), state_txt.getText(), zip_txt.getText(),
														phone_txt.getText(), materials_txt.getText(), date_txt.getText(),
														hours_spinner.getValue().toString(), start_txt.getSelectedItem(), end_txt.getSelectedItem(),
														notes_txt.getText(), pdf_file_txt.getText(), image_txt.getText(), rdbtnAm_start.isSelected(),
														rdbtnAm_end.isSelected());
												System.out.println("save button pressed");
												// disposes the current window
												new Inserting_Driver(newJob);
												dispose();
												new Search_GUI(query, search);
											}
										});
										GridBagConstraints gbc_btnSave = new GridBagConstraints();
										gbc_btnSave.insets = new Insets(0, 0, 5, 5);
										gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
										gbc_btnSave.anchor = GridBagConstraints.SOUTH;
										gbc_btnSave.gridx = 5;
										gbc_btnSave.gridy = 21;
										getContentPane().add(btnSave, gbc_btnSave);
		btnImportInformationFrom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				importedJob = new ImportJob(added);
			}
		});
	}

	public void setJob(Jobs jobs) {
		this.job = jobs;
		setDocText();
		repaint();
		revalidate();
	}

	private void setDocText() {
		job_name_txt.setText(job.getJob_name());
		fname_txt.setText(job.getFname());
		lname_txt.setText(job.getLname());
		street_txt.setText(job.getStreet());
		state_txt.setText(job.getState());
		city_txt.setText(job.getCity());
		zip_txt.setText(job.getZip_code());
		phone_txt.setText(job.getPhone_number());
		pdf_file_txt.setText(job.getPDFs());
		image_txt.setText(job.getImages());
		materials_txt.setText(job.getMaterials());
		date_txt.setText(job.getDate());
		hours_spinner.setValue(new Double(Double.parseDouble(job.getHours())));
		for (int i = 0; i < 48; i++) {
			if (start_txt.getItem(i).equals(job.getStartTime()))
				start_txt.select(i);
		}
		for (int i = 0; i < 48; i++) {
			if (end_txt.getItem(i).equals(job.getStartTime()))
				end_txt.select(i);
		}
		if (job.isStartTimeAm()) {
			rdbtnAm_start.setSelected(true);
		} else {
			rdbtnPm_start.setSelected(true);
		}

		if (job.isEndTimeAm()) {
			rdbtnAm_end.setSelected(true);
		} else {
			rdbtnPm_end.setSelected(true);
		}

	}

	/**
	 * This method sets up the Jlabels and Jtextfields for Job Name, First Name,
	 * and Last Name
	 * 
	 */
	public void NameSection() {

		lblJobName = new JLabel("Job Name:");
		lblJobName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblJobName = new GridBagConstraints();
		gbc_lblJobName.anchor = GridBagConstraints.EAST;
		gbc_lblJobName.gridwidth = 2;
		gbc_lblJobName.insets = new Insets(0, 0, 5, 5);
		gbc_lblJobName.gridx = 0;
		gbc_lblJobName.gridy = 1;
		getContentPane().add(lblJobName, gbc_lblJobName);

		// job name textfield
		job_name_txt = new JTextField();
		job_name_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_job_name_txt = new GridBagConstraints();
		gbc_job_name_txt.gridwidth = 7;
		gbc_job_name_txt.insets = new Insets(0, 0, 5, 0);
		gbc_job_name_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_job_name_txt.gridx = 2;
		gbc_job_name_txt.gridy = 1;
		getContentPane().add(job_name_txt, gbc_job_name_txt);
		job_name_txt.setColumns(10);

		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridwidth = 2;
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 3;
		getContentPane().add(lblFirstName, gbc_lblFirstName);

		// first name textfield
		fname_txt = new JTextField();
		fname_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_fname_txt = new GridBagConstraints();
		gbc_fname_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_fname_txt.insets = new Insets(0, 0, 5, 0);
		gbc_fname_txt.gridwidth = 7;
		gbc_fname_txt.gridx = 2;
		gbc_fname_txt.gridy = 3;
		getContentPane().add(fname_txt, gbc_fname_txt);
		fname_txt.setColumns(10);

		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.EAST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridwidth = 2;
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 4;
		getContentPane().add(lblLastName, gbc_lblLastName);

		// last name textfield
		lname_txt = new JTextField();
		lname_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lname_txt = new GridBagConstraints();
		gbc_lname_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_lname_txt.insets = new Insets(0, 0, 5, 0);
		gbc_lname_txt.gridwidth = 7;
		gbc_lname_txt.gridx = 2;
		gbc_lname_txt.gridy = 4;
		getContentPane().add(lname_txt, gbc_lname_txt);
		lname_txt.setColumns(30);

	}

	/**
	 * This method sets up the Jlabels and Jtextfields for street name, city,
	 * state, zip, phone number
	 * 
	 */
	public void AddressSection() {

		lblStreetName = new JLabel("Street Name:");
		lblStreetName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStreetName = new GridBagConstraints();
		gbc_lblStreetName.anchor = GridBagConstraints.EAST;
		gbc_lblStreetName.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreetName.gridwidth = 2;
		gbc_lblStreetName.gridx = 0;
		gbc_lblStreetName.gridy = 6;
		getContentPane().add(lblStreetName, gbc_lblStreetName);

		// street name textfield
		street_txt = new JTextField();
		street_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_street_txt = new GridBagConstraints();
		gbc_street_txt.gridwidth = 7;
		gbc_street_txt.insets = new Insets(0, 0, 5, 0);
		gbc_street_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_street_txt.gridx = 2;
		gbc_street_txt.gridy = 6;
		getContentPane().add(street_txt, gbc_street_txt);
		street_txt.setColumns(10);

		lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 1;
		gbc_lblCity.gridy = 7;
		getContentPane().add(lblCity, gbc_lblCity);

		// city textfield
		city_txt = new JTextField();
		city_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_city_txt = new GridBagConstraints();
		gbc_city_txt.gridwidth = 2;
		gbc_city_txt.insets = new Insets(0, 0, 5, 5);
		gbc_city_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_city_txt.gridx = 2;
		gbc_city_txt.gridy = 7;
		getContentPane().add(city_txt, gbc_city_txt);
		city_txt.setColumns(10);

		lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.anchor = GridBagConstraints.EAST;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 4;
		gbc_lblState.gridy = 7;
		getContentPane().add(lblState, gbc_lblState);

		// state textfield
		state_txt = new JTextField();
		state_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_state_txt = new GridBagConstraints();
		gbc_state_txt.insets = new Insets(0, 0, 5, 5);
		gbc_state_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_state_txt.gridx = 5;
		gbc_state_txt.gridy = 7;
		getContentPane().add(state_txt, gbc_state_txt);
		state_txt.setColumns(10);

		lblZip = new JLabel("Zip:");
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblZip = new GridBagConstraints();
		gbc_lblZip.anchor = GridBagConstraints.EAST;
		gbc_lblZip.insets = new Insets(0, 0, 5, 5);
		gbc_lblZip.gridx = 6;
		gbc_lblZip.gridy = 7;
		getContentPane().add(lblZip, gbc_lblZip);

		// zip textfield
		zip_txt = new JTextField();
		zip_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_zip_txt = new GridBagConstraints();
		gbc_zip_txt.gridwidth = 2;
		gbc_zip_txt.insets = new Insets(0, 0, 5, 0);
		gbc_zip_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_zip_txt.gridx = 7;
		gbc_zip_txt.gridy = 7;
		getContentPane().add(zip_txt, gbc_zip_txt);
		zip_txt.setColumns(10);

		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridwidth = 2;
		gbc_lblPhoneNumber.gridx = 0;
		gbc_lblPhoneNumber.gridy = 8;
		getContentPane().add(lblPhoneNumber, gbc_lblPhoneNumber);

		// phone number textfield
		phone_txt = new JTextField();
		phone_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_phone_txt = new GridBagConstraints();
		gbc_phone_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_phone_txt.insets = new Insets(0, 0, 5, 5);
		gbc_phone_txt.gridwidth = 4;
		gbc_phone_txt.gridx = 2;
		gbc_phone_txt.gridy = 8;
		getContentPane().add(phone_txt, gbc_phone_txt);
		phone_txt.setColumns(10);
	}

	/**
	 * This method sets up the Jlabels, JScroolPane, and Jtextfields for
	 * materials and notes
	 * 
	 * "Add Notes" button has an action listener which opens a second window
	 * 
	 */
	public void MaterialsAndNotesSection() {

		lblMaterials = new JLabel("Materials:");
		lblMaterials.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMaterials = new GridBagConstraints();
		gbc_lblMaterials.anchor = GridBagConstraints.EAST;
		gbc_lblMaterials.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaterials.gridwidth = 2;
		gbc_lblMaterials.gridx = 0;
		gbc_lblMaterials.gridy = 10;
		getContentPane().add(lblMaterials, gbc_lblMaterials);

		// Materials JScrollPane
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 10;
		getContentPane().add(scrollPane, gbc_scrollPane);

		// Materials Textfield
		materials_txt = new JTextArea();
		materials_txt.setFont(new Font("Monospaced", Font.PLAIN, 12));
		materials_txt.setLineWrap(true);
		materials_txt.setText("Materials go Here");
		scrollPane.setViewportView(materials_txt);

		lblNotes = new JLabel("Notes:");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNotes = new GridBagConstraints();
		gbc_lblNotes.anchor = GridBagConstraints.EAST;
		gbc_lblNotes.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotes.gridwidth = 2;
		gbc_lblNotes.gridx = 0;
		gbc_lblNotes.gridy = 15;
		getContentPane().add(lblNotes, gbc_lblNotes);

		// Notes Scroll bar and textfield
		notes_txt = new JTextArea();
		notes_txt.setLineWrap(true);
		notes_txt.setColumns(1);
		notes_txt.setFont(new Font("Monospaced", Font.PLAIN, 12));
		notes_txt.setText("Preview of Notes Starts Here");
		GridBagConstraints gbc_notes_txt = new GridBagConstraints();
		gbc_notes_txt.fill = GridBagConstraints.BOTH;
		gbc_notes_txt.insets = new Insets(0, 0, 5, 0);
		gbc_notes_txt.gridwidth = 7;
		gbc_notes_txt.gridx = 2;
		gbc_notes_txt.gridy = 15;
		getContentPane().add(notes_txt, gbc_notes_txt);

		// button for Add notes and action listener
		btnViewNotesIn = new JButton("Add Notes in New Window");
		btnViewNotesIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewNotesIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// opens the Add Notes window
				AddNotes note = new AddNotes();
				note.setVisible(true);

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
	 * This method sets up the Jlabels, Jtextfields, JSpinner, Choice, and
	 * JRadioButton for Date, Hours, Start Time, End Time
	 * 
	 * The choices for Start Time and End Time increment by 15 minutes
	 * 
	 * The JSpinner for Hours is incremented by .25 hrs
	 * 
	 * The JRadioButtons can only be selected one at a time
	 * 
	 */
	public void DateAndTimeSection() {

		lblDate_1 = new JLabel("Date:");
		lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDate_1 = new GridBagConstraints();
		gbc_lblDate_1.anchor = GridBagConstraints.EAST;
		gbc_lblDate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate_1.gridwidth = 2;
		gbc_lblDate_1.gridx = 0;
		gbc_lblDate_1.gridy = 11;
		getContentPane().add(lblDate_1, gbc_lblDate_1);

		// Date text field
		date_txt = new JTextField();
		date_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		date_txt.setText("yyyy-mm-dd");
		GridBagConstraints gbc_date_txt = new GridBagConstraints();
		gbc_date_txt.insets = new Insets(0, 0, 5, 5);
		gbc_date_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_date_txt.gridx = 2;
		gbc_date_txt.gridy = 11;
		getContentPane().add(date_txt, gbc_date_txt);
		date_txt.setColumns(10);

		lblHours = new JLabel("Hours:");
		lblHours.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblHours = new GridBagConstraints();
		gbc_lblHours.anchor = GridBagConstraints.EAST;
		gbc_lblHours.insets = new Insets(0, 0, 5, 5);
		gbc_lblHours.gridwidth = 2;
		gbc_lblHours.gridx = 0;
		gbc_lblHours.gridy = 12;
		getContentPane().add(lblHours, gbc_lblHours);

		// Hours SpinnerModel, set up by .25 hours increments
		SpinnerModel model = new SpinnerNumberModel( // sets up the hours
														// spinner to increment
														// by .25
				0, // initial value
				0, // min
				150, // max
				.25 // step
		);
		hours_spinner = new JSpinner(model);
		hours_spinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_hours_spinner = new GridBagConstraints();
		gbc_hours_spinner.anchor = GridBagConstraints.WEST;
		gbc_hours_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_hours_spinner.gridx = 2;
		gbc_hours_spinner.gridy = 12;
		getContentPane().add(hours_spinner, gbc_hours_spinner);

		lblStartTime = new JLabel("Start Time:");
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStartTime = new GridBagConstraints();
		gbc_lblStartTime.anchor = GridBagConstraints.EAST;
		gbc_lblStartTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartTime.gridwidth = 2;
		gbc_lblStartTime.gridx = 0;
		gbc_lblStartTime.gridy = 13;
		getContentPane().add(lblStartTime, gbc_lblStartTime);

		// Start Time choice selection. Increments by 15 minutes
		start_txt = new Choice();
		GridBagConstraints gbc_start_txt = new GridBagConstraints();
		gbc_start_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_start_txt.insets = new Insets(0, 0, 5, 5);
		gbc_start_txt.gridx = 2;
		gbc_start_txt.gridy = 13;

		int startHour = 12;
		for (int i = 0; i < 12; i++) {
			int startMinute = 0;
			if (startHour > 12) {
				startHour = 1;
			}
			for (int j = 0; j < 4; j++) {
				if (startMinute == 0) { // This is so 1:00 displays with two
										// zeros instead of one
					start_txt.add(startHour + " : " + startMinute + startMinute);
					startMinute = startMinute + 15;
				} else { // if it is not at the top of the hour it displays the
							// below
					start_txt.add(startHour + " : " + startMinute);
					startMinute = startMinute + 15;
				}
			}
			startHour++;
		}
		getContentPane().add(start_txt, gbc_start_txt);

		// Start Time JRadioButtons
		rdbtnAm_start = new JRadioButton("A.M.");
		rdbtnAm_start.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnAm_start = new GridBagConstraints();
		gbc_rdbtnAm_start.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAm_start.gridx = 4;
		gbc_rdbtnAm_start.gridy = 13;
		getContentPane().add(rdbtnAm_start, gbc_rdbtnAm_start);
		rdbtnAm_start.setSelected(true);

		rdbtnPm_start = new JRadioButton("P.M.");
		rdbtnPm_start.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnPm_start = new GridBagConstraints();
		gbc_rdbtnPm_start.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPm_start.gridx = 5;
		gbc_rdbtnPm_start.gridy = 13;
		getContentPane().add(rdbtnPm_start, gbc_rdbtnPm_start);

		// JRadioButtons are added to a group so only one can be selected at a
		// time
		ButtonGroup groupStartTime = new ButtonGroup();
		groupStartTime.add(rdbtnPm_start);
		groupStartTime.add(rdbtnAm_start);

		lblEndTime = new JLabel("End Time:");
		lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEndTime = new GridBagConstraints();
		gbc_lblEndTime.anchor = GridBagConstraints.EAST;
		gbc_lblEndTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndTime.gridwidth = 2;
		gbc_lblEndTime.gridx = 0;
		gbc_lblEndTime.gridy = 14;
		getContentPane().add(lblEndTime, gbc_lblEndTime);

		// EndTime JRadioButtons
		rdbtnAm_end = new JRadioButton("A.M.");
		rdbtnAm_end.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnAm_end = new GridBagConstraints();
		gbc_rdbtnAm_end.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAm_end.gridx = 4;
		gbc_rdbtnAm_end.gridy = 14;
		getContentPane().add(rdbtnAm_end, gbc_rdbtnAm_end);
		rdbtnAm_end.setSelected(true);

		rdbtnPm_end = new JRadioButton("P.M.");
		rdbtnPm_end.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnPm_end = new GridBagConstraints();
		gbc_rdbtnPm_end.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPm_end.gridx = 5;
		gbc_rdbtnPm_end.gridy = 14;
		getContentPane().add(rdbtnPm_end, gbc_rdbtnPm_end);

		// JRadioButtons are added to a group so only one can be selected at a
		// time
		ButtonGroup groupEndTime = new ButtonGroup();
		groupEndTime.add(rdbtnPm_end);
		groupEndTime.add(rdbtnAm_end);

		// End Time choices. Displayed by 15 minute increments
		end_txt = new Choice();
		GridBagConstraints gbc_end_txt = new GridBagConstraints();
		gbc_end_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_end_txt.insets = new Insets(0, 0, 5, 5);
		gbc_end_txt.gridx = 2;
		gbc_end_txt.gridy = 14;

		int endHour = 12;
		for (int i = 0; i < 12; i++) {
			int endMinute = 0;
			if (endHour > 12) {
				endHour = 1;
			}
			for (int j = 0; j < 4; j++) {
				if (endMinute == 0) { // This is so 1:00 displays with two zeros
										// instead of one
					end_txt.add(endHour + " : " + endMinute + endMinute);
					endMinute = endMinute + 15;
				} else { // if it is not at the top of the hour it displays the
							// below
					end_txt.add(endHour + " : " + endMinute);
					endMinute = endMinute + 15;
				}
			}
			endHour++;
		}
		getContentPane().add(end_txt, gbc_end_txt);

	}

	/**
	 * This method sets up the Jlabels, Jtextfields, actionlisteners, and
	 * buttons for PDF and Images
	 * 
	 * "Add PDF" and "Add Image" open a FileDialog when selected
	 * 
	 */
	public void PdfAndImagesSection() {

		lblPdf = new JLabel("PDF:");
		lblPdf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPdf = new GridBagConstraints();
		gbc_lblPdf.anchor = GridBagConstraints.EAST;
		gbc_lblPdf.insets = new Insets(0, 0, 5, 5);
		gbc_lblPdf.gridwidth = 2;
		gbc_lblPdf.gridx = 0;
		gbc_lblPdf.gridy = 17;
		getContentPane().add(lblPdf, gbc_lblPdf);

		// PDF JTextField that displays the saved PDF
		pdf_file_txt = new JTextField();
		pdf_file_txt.setEditable(false);
		pdf_file_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pdf_file_txt.setText("No PDFs Added");
		GridBagConstraints gbc_pdf_file_txt = new GridBagConstraints();
		gbc_pdf_file_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_pdf_file_txt.insets = new Insets(0, 0, 5, 0);
		gbc_pdf_file_txt.gridwidth = 7;
		gbc_pdf_file_txt.gridx = 2;
		gbc_pdf_file_txt.gridy = 17;
		getContentPane().add(pdf_file_txt, gbc_pdf_file_txt);
		pdf_file_txt.setColumns(10);

		// "Add PDF" button and action listener
		btnAddPdf = new JButton("Add PDF");
		btnAddPdf.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
				filename = fd.getDirectory() + fd.getFile();
				if (filename == null)
					System.out.println("You cancelled the choice");
				else {
					System.out.println("You chose " + filename);

				}
				if (filename != null) {
					System.out.println(filename);
					pdf_file_txt.setText(filename);

				}
			}
		});

		lblImages = new JLabel("Images:");
		lblImages.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblImages = new GridBagConstraints();
		gbc_lblImages.anchor = GridBagConstraints.EAST;
		gbc_lblImages.insets = new Insets(0, 0, 5, 5);
		gbc_lblImages.gridwidth = 2;
		gbc_lblImages.gridx = 0;
		gbc_lblImages.gridy = 19;
		getContentPane().add(lblImages, gbc_lblImages);

		// Images JTextField
		image_txt = new JTextField();
		image_txt.setEditable(false);
		image_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		image_txt.setText("No Images Added");
		GridBagConstraints gbc_image_txt = new GridBagConstraints();
		gbc_image_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_image_txt.insets = new Insets(0, 0, 5, 0);
		gbc_image_txt.gridwidth = 7;
		gbc_image_txt.gridx = 2;
		gbc_image_txt.gridy = 19;
		getContentPane().add(image_txt, gbc_image_txt);
		image_txt.setColumns(10);

		// "Add Image" button and actionlistener
		btnAddImage = new JButton("Add Image");
		btnAddImage.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
				filename = fd.getDirectory() + fd.getFile();
				if (filename == null)
					System.out.println("You cancelled the choice");
				else {
					System.out.println("You chose " + filename);

				}
				if (filename != null) {
					System.out.println(filename);
					image_txt.setText(filename);

				}
			}
		});

	}

	/**
	 * This method sets up the Jbuttons and acitonlisteners for Cancel and Save
	 * 
	 * Needs to be setup so values are only saved when "Save" is pressed
	 * 
	 */
	public void CancelSaveSection() {
<<<<<<< HEAD

		// Cancel Button and Actionlistener
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.RED);
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
				dispose();
			}
		});

		// Save button and actionlistener
		btnSave = new JButton("Save");
		btnSave.setForeground(Color.BLUE);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 33));

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Jobs newJob = new Jobs(null, job_name_txt.getText(), fname_txt.getText(), lname_txt.getText(),
						street_txt.getText(), city_txt.getText(), state_txt.getText(), zip_txt.getText(),
						phone_txt.getText(), materials_txt.getText(), date_txt.getText(),
						hours_spinner.getValue().toString(), start_txt.getSelectedItem(), end_txt.getSelectedItem(),
						notes_txt.getText(), pdf_file_txt.getText(), image_txt.getText(), rdbtnAm_start.isSelected(),
						rdbtnAm_end.isSelected());
				System.out.println("save button pressed");
				// disposes the current window
				new Inserting_Driver(newJob);
				newJobAdd = true;
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
=======
>>>>>>> refs/remotes/origin/master
	}

	public boolean isNewJobAdd() {
		return newJobAdd;
	}

	public void setNewJobAdd(boolean newJobAdd) {
		this.newJobAdd = newJobAdd;
	}
}
