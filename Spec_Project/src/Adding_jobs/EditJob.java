package Adding_jobs;

import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import RQuadHeavyIndustriesScheduler.MainScreen;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;

import Search_DB.Editing_Driver;
import Search_DB.Inserting_Driver;
import Search_DB.Jobs;
import Search_DB.Search_GUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.JRadioButton;

/**
 * This class creates the window EditJob
 * 
 * @author Julia Roscher DATE: 3/23/2016
 *
 */

public class EditJob extends JFrame {
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
	private JTextField pdf_txt;
	private JButton btnAddPdf;
	private JLabel lblImages;
	private JTextField images_txt;
	private JButton btnAddImage;
	private JButton btnSave;
	private JButton btnCancel;
	static EditJob frame;
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
	private Choice startTime_txt;
	private Choice end_txt;
	private JRadioButton rdbtnAmStart;
	private JRadioButton rdbtnPmStart;
	private JRadioButton rdbtnAmEnd;
	private JRadioButton rdbtnPmEnd;
	private JLabel lblJobName;
	private JTextField job_name_txt;
	private Jobs editedJob;
	private String query;
	private String search;
	private JButton btnOpenPdf;
	private JButton btnOpenImage;
	private String pdf;
	private String image;

	/**
	 * Frame Created
	 * 
	 * Methods must be called by constructor
	 * 
	 * @param editedJob
	 * 
	 */
	public EditJob(Jobs editedJob, String query, String search) {
		this.editedJob = editedJob;
		this.query = query;
		this.search = search;
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 24));
		setTitle("Edit Job");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

		setBounds(100, 100, 1006, 945);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 127, 25, 130, 36, 90, 130, 80, 130, 61, 0 };
		gridBagLayout.rowHeights = new int[] { 31, 0, 0, 31, 31, 31, 29, 20, 31, 0, 56, 29, 29, 29, 29, 56, 35, 29, 35,
				29, 35, 32, 49, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		this.setVisible(true);
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
		btnImportInformationFrom.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_btnImportInformationFrom = new GridBagConstraints();
		gbc_btnImportInformationFrom.gridwidth = 5;
		gbc_btnImportInformationFrom.insets = new Insets(0, 0, 5, 5);
		gbc_btnImportInformationFrom.gridx = 2;
		gbc_btnImportInformationFrom.gridy = 2;
		getContentPane().add(btnImportInformationFrom, gbc_btnImportInformationFrom);

	}

	/**
	 * This method sets up the Jlabels and Jtextfields for Job Name, First Name,
	 * and Last Name
	 * 
	 */
	public void NameSection() {

		lblJobName = new JLabel("Job Name:");
		lblJobName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblJobName = new GridBagConstraints();
		gbc_lblJobName.anchor = GridBagConstraints.EAST;
		gbc_lblJobName.gridwidth = 2;
		gbc_lblJobName.insets = new Insets(0, 0, 5, 5);
		gbc_lblJobName.gridx = 0;
		gbc_lblJobName.gridy = 1;
		getContentPane().add(lblJobName, gbc_lblJobName);

		// job name textfield
		job_name_txt = new JTextField();
		job_name_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_job_name_txt = new GridBagConstraints();
		gbc_job_name_txt.gridwidth = 6;
		gbc_job_name_txt.insets = new Insets(0, 0, 5, 5);
		gbc_job_name_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_job_name_txt.gridx = 2;
		gbc_job_name_txt.gridy = 1;
		getContentPane().add(job_name_txt, gbc_job_name_txt);
		job_name_txt.setColumns(10);
		job_name_txt.setText(editedJob.getJob_name());

		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridwidth = 2;
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 3;
		getContentPane().add(lblFirstName, gbc_lblFirstName);

		// first name textfield
		fname_txt = new JTextField();
		fname_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_fname_txt = new GridBagConstraints();
		gbc_fname_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_fname_txt.insets = new Insets(0, 0, 5, 5);
		gbc_fname_txt.gridwidth = 6;
		gbc_fname_txt.gridx = 2;
		gbc_fname_txt.gridy = 3;
		getContentPane().add(fname_txt, gbc_fname_txt);
		fname_txt.setColumns(10);
		fname_txt.setText(editedJob.getFname());

		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.EAST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridwidth = 2;
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 4;
		getContentPane().add(lblLastName, gbc_lblLastName);

		// last name textfield
		lname_txt = new JTextField();
		lname_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lname_txt = new GridBagConstraints();
		gbc_lname_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_lname_txt.insets = new Insets(0, 0, 5, 5);
		gbc_lname_txt.gridwidth = 6;
		gbc_lname_txt.gridx = 2;
		gbc_lname_txt.gridy = 4;
		getContentPane().add(lname_txt, gbc_lname_txt);
		lname_txt.setColumns(30);
		lname_txt.setText(editedJob.getLname());

	}

	/**
	 * This method sets up the Jlabels and Jtextfields for street name, city,
	 * state, zip, phone number
	 * 
	 */
	public void AddressSection() {

		lblStreetName = new JLabel("Street Name:");
		lblStreetName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblStreetName = new GridBagConstraints();
		gbc_lblStreetName.anchor = GridBagConstraints.EAST;
		gbc_lblStreetName.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreetName.gridwidth = 2;
		gbc_lblStreetName.gridx = 0;
		gbc_lblStreetName.gridy = 6;
		getContentPane().add(lblStreetName, gbc_lblStreetName);

		// street name textfield
		street_txt = new JTextField();
		street_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_street_txt = new GridBagConstraints();
		gbc_street_txt.gridwidth = 6;
		gbc_street_txt.insets = new Insets(0, 0, 5, 5);
		gbc_street_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_street_txt.gridx = 2;
		gbc_street_txt.gridy = 6;
		getContentPane().add(street_txt, gbc_street_txt);
		street_txt.setColumns(10);
		street_txt.setText(editedJob.getStreet());

		lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 1;
		gbc_lblCity.gridy = 7;
		getContentPane().add(lblCity, gbc_lblCity);

		// city textfield
		city_txt = new JTextField();
		city_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_city_txt = new GridBagConstraints();
		gbc_city_txt.gridwidth = 2;
		gbc_city_txt.insets = new Insets(0, 0, 5, 5);
		gbc_city_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_city_txt.gridx = 2;
		gbc_city_txt.gridy = 7;
		getContentPane().add(city_txt, gbc_city_txt);
		city_txt.setColumns(10);
		city_txt.setText(editedJob.getCity());

		lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.anchor = GridBagConstraints.EAST;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 4;
		gbc_lblState.gridy = 7;
		getContentPane().add(lblState, gbc_lblState);

		// state textfield
		state_txt = new JTextField();
		state_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_state_txt = new GridBagConstraints();
		gbc_state_txt.anchor = GridBagConstraints.NORTH;
		gbc_state_txt.insets = new Insets(0, 0, 5, 5);
		gbc_state_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_state_txt.gridx = 5;
		gbc_state_txt.gridy = 7;
		getContentPane().add(state_txt, gbc_state_txt);
		state_txt.setColumns(10);
		state_txt.setText(editedJob.getState());

		lblZip = new JLabel("Zip:");
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblZip = new GridBagConstraints();
		gbc_lblZip.anchor = GridBagConstraints.EAST;
		gbc_lblZip.insets = new Insets(0, 0, 5, 5);
		gbc_lblZip.gridx = 6;
		gbc_lblZip.gridy = 7;
		getContentPane().add(lblZip, gbc_lblZip);

		// zip textfield
		zip_txt = new JTextField();
		zip_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_zip_txt = new GridBagConstraints();
		gbc_zip_txt.insets = new Insets(0, 0, 5, 5);
		gbc_zip_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_zip_txt.gridx = 7;
		gbc_zip_txt.gridy = 7;
		getContentPane().add(zip_txt, gbc_zip_txt);
		zip_txt.setColumns(10);
		zip_txt.setText(editedJob.getZip_code());

		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridwidth = 2;
		gbc_lblPhoneNumber.gridx = 0;
		gbc_lblPhoneNumber.gridy = 8;
		getContentPane().add(lblPhoneNumber, gbc_lblPhoneNumber);

		// phone number textfield
		phone_txt = new JTextField();
		phone_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_phone_txt = new GridBagConstraints();
		gbc_phone_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_phone_txt.insets = new Insets(0, 0, 5, 5);
		gbc_phone_txt.gridwidth = 4;
		gbc_phone_txt.gridx = 2;
		gbc_phone_txt.gridy = 8;
		getContentPane().add(phone_txt, gbc_phone_txt);
		phone_txt.setColumns(10);
		phone_txt.setText(editedJob.getPhone_number());
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
		lblMaterials.setFont(new Font("Tahoma", Font.PLAIN, 24));
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
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 10;
		getContentPane().add(scrollPane, gbc_scrollPane);

		// Materials Textfield
		materials_txt = new JTextArea();
		materials_txt.setFont(new Font("Monospaced", Font.PLAIN, 14));
		materials_txt.setLineWrap(true);
		materials_txt.setText(editedJob.getMaterials());
		scrollPane.setViewportView(materials_txt);

		lblNotes = new JLabel("Notes:");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 24));
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
		notes_txt.setFont(new Font("Monospaced", Font.PLAIN, 14));
		notes_txt.setText(editedJob.getNotes());
		GridBagConstraints gbc_notes_txt = new GridBagConstraints();
		gbc_notes_txt.fill = GridBagConstraints.BOTH;
		gbc_notes_txt.insets = new Insets(0, 0, 5, 5);
		gbc_notes_txt.gridwidth = 7;
		gbc_notes_txt.gridx = 2;
		gbc_notes_txt.gridy = 15;
		getContentPane().add(notes_txt, gbc_notes_txt);

		// button for Add notes and action listener
		btnViewNotesIn = new JButton("Edit Notes in New Window");
		btnViewNotesIn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnViewNotesIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// opens the Edit Notes window
				EditNotes note = new EditNotes();
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
		lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblDate_1 = new GridBagConstraints();
		gbc_lblDate_1.anchor = GridBagConstraints.EAST;
		gbc_lblDate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate_1.gridwidth = 2;
		gbc_lblDate_1.gridx = 0;
		gbc_lblDate_1.gridy = 11;
		getContentPane().add(lblDate_1, gbc_lblDate_1);

		// Date text field
		date_txt = new JTextField();
		date_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		date_txt.setText("mm/dd/yyyy");
		GridBagConstraints gbc_date_txt = new GridBagConstraints();
		gbc_date_txt.insets = new Insets(0, 0, 5, 5);
		gbc_date_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_date_txt.gridx = 2;
		gbc_date_txt.gridy = 11;
		getContentPane().add(date_txt, gbc_date_txt);
		date_txt.setColumns(10);
		date_txt.setText(editedJob.getDate());

		lblHours = new JLabel("Hours:");
		lblHours.setFont(new Font("Tahoma", Font.PLAIN, 24));
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
		hours_spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_hours_spinner = new GridBagConstraints();
		gbc_hours_spinner.anchor = GridBagConstraints.WEST;
		gbc_hours_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_hours_spinner.gridx = 2;
		gbc_hours_spinner.gridy = 12;
		getContentPane().add(hours_spinner, gbc_hours_spinner);
		hours_spinner.setValue(new Double(Double.parseDouble(editedJob.getHours())));

		lblStartTime = new JLabel("Start Time:");
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblStartTime = new GridBagConstraints();
		gbc_lblStartTime.anchor = GridBagConstraints.EAST;
		gbc_lblStartTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartTime.gridwidth = 2;
		gbc_lblStartTime.gridx = 0;
		gbc_lblStartTime.gridy = 13;
		getContentPane().add(lblStartTime, gbc_lblStartTime);

		// Start Time choice selection. Increments by 15 minutes
		startTime_txt = new Choice();
		GridBagConstraints gbc_startTime_txt = new GridBagConstraints();
		gbc_startTime_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_startTime_txt.insets = new Insets(0, 0, 5, 5);
		gbc_startTime_txt.gridx = 2;
		gbc_startTime_txt.gridy = 13;

		int startHour = 12;
		for (int i = 0; i < 12; i++) {
			int startMinute = 0;
			if (startHour > 12) {
				startHour = 1;
			}
			for (int j = 0; j < 4; j++) {
				if (startMinute == 0) { // This is so 1:00 displays with two
										// zeros instead of one
					startTime_txt.add(startHour + " : " + startMinute + startMinute);
					startMinute = startMinute + 15;
				} else { // if it is not at the top of the hour it displays the
							// below
					startTime_txt.add(startHour + " : " + startMinute);
					startMinute = startMinute + 15;
				}
			}
			startHour++;
		}
		getContentPane().add(startTime_txt, gbc_startTime_txt);

		for (int i = 0; i < 48; i++) {

			if (startTime_txt.getItem(i).equals(editedJob.getStartTime()))
				startTime_txt.select(i);

		}

		// Start Time JRadioButtons
		rdbtnAmStart = new JRadioButton("A.M.");
		rdbtnAmStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_rdbtnAmStart = new GridBagConstraints();
		gbc_rdbtnAmStart.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAmStart.gridx = 4;
		gbc_rdbtnAmStart.gridy = 13;
		getContentPane().add(rdbtnAmStart, gbc_rdbtnAmStart);

		rdbtnPmStart = new JRadioButton("P.M.");
		rdbtnPmStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_rdbtnPmStart = new GridBagConstraints();
		gbc_rdbtnPmStart.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPmStart.gridx = 5;
		gbc_rdbtnPmStart.gridy = 13;
		getContentPane().add(rdbtnPmStart, gbc_rdbtnPmStart);

		if (editedJob.isStartTimeAm()) {
			rdbtnAmStart.setSelected(true);
		} else {
			rdbtnPmStart.setSelected(true);
		}
		// JRadioButtons are added to a group so only one can be selected at a
		// time
		ButtonGroup groupStartTime = new ButtonGroup();
		groupStartTime.add(rdbtnPmStart);
		groupStartTime.add(rdbtnAmStart);

		lblEndTime = new JLabel("End Time:");
		lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblEndTime = new GridBagConstraints();
		gbc_lblEndTime.anchor = GridBagConstraints.EAST;
		gbc_lblEndTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndTime.gridwidth = 2;
		gbc_lblEndTime.gridx = 0;
		gbc_lblEndTime.gridy = 14;
		getContentPane().add(lblEndTime, gbc_lblEndTime);

		// EndTime JRadioButtons
		rdbtnAmEnd = new JRadioButton("A.M.");
		rdbtnAmEnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_rdbtnAmEnd = new GridBagConstraints();
		gbc_rdbtnAmEnd.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAmEnd.gridx = 4;
		gbc_rdbtnAmEnd.gridy = 14;
		getContentPane().add(rdbtnAmEnd, gbc_rdbtnAmEnd);

		rdbtnPmEnd = new JRadioButton("P.M.");
		rdbtnPmEnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_rdbtnPmEnd = new GridBagConstraints();
		gbc_rdbtnPmEnd.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPmEnd.gridx = 5;
		gbc_rdbtnPmEnd.gridy = 14;
		getContentPane().add(rdbtnPmEnd, gbc_rdbtnPmEnd);
		if (editedJob.isEndTimeAm()) {
			rdbtnAmEnd.setSelected(true);
		} else {
			rdbtnPmEnd.setSelected(true);
		}

		// JRadioButtons are added to a group so only one can be selected at a
		// time
		ButtonGroup groupEndTime = new ButtonGroup();
		groupEndTime.add(rdbtnPmEnd);
		groupEndTime.add(rdbtnAmEnd);

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
		for (int i = 0; i < 48; i++) {

			if (end_txt.getItem(i).equals(editedJob.getEndTime()))
				end_txt.select(i);

		}

	}

	/**
	 * This method sets up the Jlabels, Jtextfields, actionlisteners, and
	 * buttons for and Images
	 * 
	 * "Add PDF" and "Add Image" open a FileDialog when selected
	 * 
	 */
	public void PdfAndImagesSection() {

		lblPdf = new JLabel("PDF:");
		lblPdf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblPdf = new GridBagConstraints();
		gbc_lblPdf.anchor = GridBagConstraints.EAST;
		gbc_lblPdf.insets = new Insets(0, 0, 5, 5);
		gbc_lblPdf.gridwidth = 2;
		gbc_lblPdf.gridx = 0;
		gbc_lblPdf.gridy = 17;
		getContentPane().add(lblPdf, gbc_lblPdf);

		// PDF JTextField that displays the saved PDF
		pdf_txt = new JTextField();
		pdf_txt.setEditable(false);
		pdf_txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pdf_txt.setText("No PDFs Added");
		GridBagConstraints gbc_pdf_txt = new GridBagConstraints();
		gbc_pdf_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_pdf_txt.insets = new Insets(0, 0, 5, 5);
		gbc_pdf_txt.gridwidth = 7;
		gbc_pdf_txt.gridx = 2;
		gbc_pdf_txt.gridy = 17;
		getContentPane().add(pdf_txt, gbc_pdf_txt);
		pdf_txt.setColumns(10);
		pdf_txt.setText(editedJob.getPDFs());

		// "Add PDF" button and action listener
		btnAddPdf = new JButton("Add PDF");
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
				filename = fd.getDirectory() + fd.getFile();
				pdf = fd.getDirectory() + fd.getFile();
				if (filename == null)
					System.out.println("You cancelled the choice");
				else {
					System.out.println("You chose " + filename);

				}
				if (filename != null) {
					System.out.println(filename);
					pdf_txt.setText(filename);

				}
			}
		});

		btnOpenPdf = new JButton("Open PDF");
		btnOpenPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					File file = new File(pdf);
					Desktop.getDesktop().open(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "File was not found. Make sure file is on the computer",
							"File not Found", 2);
				}
			}
		});
		btnOpenPdf.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_btnOpenPdf = new GridBagConstraints();
		gbc_btnOpenPdf.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpenPdf.gridx = 5;
		gbc_btnOpenPdf.gridy = 18;
		getContentPane().add(btnOpenPdf, gbc_btnOpenPdf);

		lblImages = new JLabel("Images:");
		lblImages.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblImages = new GridBagConstraints();
		gbc_lblImages.anchor = GridBagConstraints.EAST;
		gbc_lblImages.insets = new Insets(0, 0, 5, 5);
		gbc_lblImages.gridwidth = 2;
		gbc_lblImages.gridx = 0;
		gbc_lblImages.gridy = 19;
		getContentPane().add(lblImages, gbc_lblImages);

		// Images JTextField
		images_txt = new JTextField();
		images_txt.setEditable(false);
		images_txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		images_txt.setText("No Images Added");
		GridBagConstraints gbc_images_txt = new GridBagConstraints();
		gbc_images_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_images_txt.insets = new Insets(0, 0, 5, 5);
		gbc_images_txt.gridwidth = 7;
		gbc_images_txt.gridx = 2;
		gbc_images_txt.gridy = 19;
		getContentPane().add(images_txt, gbc_images_txt);
		images_txt.setColumns(10);
		images_txt.setText(editedJob.getImages());

		// "Add Image" button and actionlistener
		btnAddImage = new JButton("Add Image");
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
				filename = fd.getDirectory() + fd.getFile();
				image = fd.getDirectory() + fd.getFile();
				if (filename == null)
					System.out.println("You cancelled the choice");
				else {
					System.out.println("You chose " + filename);

				}
				if (filename != null) {
					System.out.println(filename);
					images_txt.setText(filename);

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

		btnOpenImage = new JButton("Open Image");
		btnOpenImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File(image);
					Desktop.getDesktop().open(file);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "File was not found. Make sure file is on the computer",
							"File not Found", 2);
				}
			}
		});
		btnOpenImage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_btnOpenImage = new GridBagConstraints();
		gbc_btnOpenImage.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpenImage.gridx = 5;
		gbc_btnOpenImage.gridy = 20;
		getContentPane().add(btnOpenImage, gbc_btnOpenImage);

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

				ViewJob viewjob = new ViewJob();
				viewjob.setVisible(true);
				dispose();
			}
		});

		// Save button and actionlistener
		btnSave = new JButton("Save");
		btnSave.setForeground(Color.BLUE);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 33));

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("save button pressed");

				int reply = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to edit this record? This cannot be undone.", "Confirm Edit",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {

					Jobs newJob = new Jobs(editedJob.getWork_Id(), job_name_txt.getText(), fname_txt.getText(),
							lname_txt.getText(), street_txt.getText(), city_txt.getText(), state_txt.getText(),
							zip_txt.getText(), phone_txt.getText(), materials_txt.getText(), date_txt.getText(),
							hours_spinner.getValue().toString(), startTime_txt.getSelectedItem(),
							end_txt.getSelectedItem(), notes_txt.getText(), pdf_txt.getText(), images_txt.getText(),
							rdbtnAmStart.isSelected(), rdbtnAmEnd.isSelected());

					// disposes the current window
					new Editing_Driver(newJob);
					dispose();
					new Search_GUI(query, search);
				}
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
}
