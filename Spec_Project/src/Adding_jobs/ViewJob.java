package Adding_jobs;

import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Search_DB.Jobs;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.JRadioButton;

/**
 * This class creates the window View Job
 * 
 * @author Julia Roscher DATE: 3/23/2016
 *
 */

@SuppressWarnings({ "serial" })
public class ViewJob extends JFrame {
	private JTextField fname_text;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField lname_text;
	private JLabel lblPhoneNumber;
	private JTextField phone_number;
	private JLabel lblMaterials;
	private JLabel lblHours;
	private JLabel lblNotes;
	private JTextArea notes;
	private JButton btnViewNotesIn;
	private JLabel lblPdf;
	private JTextField pdf;
	private JButton btnAddPdf;
	private JLabel lblImages;
	private JTextField images;
	private JButton btnAddImage;
	private JButton btnSave;
	private JButton btnCancel;
	static ViewJob frame;
	String filename;
	private JScrollPane scrollPane;
	private JTextArea materials_text;
	private JSpinner hours;
	private JLabel lblStartTime;
	private JLabel lblEndTime;
	private JLabel lblDate_1;
	private JLabel lblStreetName;
	private JLabel lblCity;
	private JTextField txtCity;
	private JTextField streetname_text;
	private JLabel lblState;
	private JTextField state_text;
	private JLabel lblZip;
	private JTextField zip_text;
	private JButton btnImportInformationFrom;
	private JTextField date;
	private Choice startTime;
	private Choice endTime;
	private JRadioButton rdbtnAm_start;
	private JRadioButton rdbtnPm_start;
	private JRadioButton rdbtnAm_end;
	private JRadioButton rdbtnPm_end;
	private JLabel lblJobName;
	private JTextField job_text;
	static int row;
	private Jobs jobs;

	private JButton btnViewPdf;
	private JButton btnViewImage;
	@SuppressWarnings("unused")
	private String pdf_text;

	/**
	 * Frame Created
	 * 
	 * Since the purpose of this class is to view the selected job's
	 * information, all the fields are set to uneditable
	 * 
	 * @param searchType
	 * @param query
	 * @param jobs
	 * 
	 */
	public ViewJob(Jobs jobs) {
		this.jobs = jobs;

		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setTitle("View Job");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 779, 739);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 83, 25, 130, 36, 90, 130, 80, 130, 61, 0 };
		gridBagLayout.rowHeights = new int[] { 31, 0, 0, 31, 31, 31, 29, 20, 31, 0, 56, 29, 29, 29, 29, 56, 35, 29, 35,
				29, 35, 32, 49, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());
		NameSection();
		AddressSection();
		MaterialsAndNotesSection();
		DateAndTimeSection();
		PdfAndImagesSection();
		BackEditSection();
		IdAndImportSelction();
		this.setVisible(true);

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
		btnImportInformationFrom.setEnabled(false);
		btnImportInformationFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnImportInformationFrom = new GridBagConstraints();
		gbc_btnImportInformationFrom.gridwidth = 5;
		gbc_btnImportInformationFrom.insets = new Insets(0, 0, 5, 5);
		gbc_btnImportInformationFrom.gridx = 2;
		gbc_btnImportInformationFrom.gridy = 2;
		getContentPane().add(btnImportInformationFrom, gbc_btnImportInformationFrom);
		
		btnViewImage = new JButton("View Image");
		btnViewImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String username = System.getProperty("user.name");
					
							File path = null;
							JFileChooser chooser = new JFileChooser();
							
							chooser.setCurrentDirectory(new File("C:\\Users\\" + username + "\\Documents\\PDFS for Handyman\\" + jobs.getJob_name()));
							if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
								path = chooser.getSelectedFile();
							}
							try {
								Desktop.getDesktop().open(path);
							} catch (IOException e1) {
								System.out.println("File not found..");
							}
						
					System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
	                        .format(new java.util.Date()) + 
	                        ": ViewJob -> User clicked on the view PDF button");
				} catch (Exception ev) {
				
				}
			}
		});
		btnViewImage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnViewImage = new GridBagConstraints();
		gbc_btnViewImage.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewImage.gridx = 5;
		gbc_btnViewImage.gridy = 20;
		getContentPane().add(btnViewImage, gbc_btnViewImage);

		// Back Button and Actionlistener
		btnCancel = new JButton("Back");
		btnCancel.setForeground(Color.black);
		Color red = new Color(255, 110, 110);
		btnCancel.setBackground(red);
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
				dispose();
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
                        .format(new java.util.Date()) + 
                        ": ViewJob -> User clicked on the Cancel button");
			}
		});

		// edit button and actionlistener
		btnSave = new JButton("Edit");
		
		Color lightblue = new Color(210, 255, 255);
		btnSave.setBackground(lightblue);
		btnSave.setForeground(Color.black);
				btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("save button pressed");

				EditJob editjob = new EditJob(jobs);
				editjob.setVisible(true);
				dispose();
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
                        .format(new java.util.Date()) + 
                        ": ViewJob -> User clicked on the Save button");
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.anchor = GridBagConstraints.SOUTH;
		gbc_btnSave.gridx = 5;
		gbc_btnSave.gridy = 21;
		getContentPane().add(btnSave, gbc_btnSave);
		/*
		 * call search driver for all records and have user select the job they
		 * wish to import
		 */
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
		job_text = new JTextField();
		job_text.setText(jobs.getJob_name());
		job_text.setEditable(false);
		job_text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_job_text = new GridBagConstraints();
		gbc_job_text.gridwidth = 7;
		gbc_job_text.insets = new Insets(0, 0, 5, 0);
		gbc_job_text.fill = GridBagConstraints.HORIZONTAL;
		gbc_job_text.gridx = 2;
		gbc_job_text.gridy = 1;
		getContentPane().add(job_text, gbc_job_text);
		job_text.setColumns(10);

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
		fname_text = new JTextField();
		fname_text.setText(jobs.getFname());
		fname_text.setEditable(false);
		fname_text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_fname_text = new GridBagConstraints();
		gbc_fname_text.fill = GridBagConstraints.HORIZONTAL;
		gbc_fname_text.insets = new Insets(0, 0, 5, 0);
		gbc_fname_text.gridwidth = 7;
		gbc_fname_text.gridx = 2;
		gbc_fname_text.gridy = 3;
		getContentPane().add(fname_text, gbc_fname_text);
		fname_text.setColumns(10);

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
		lname_text = new JTextField();
		lname_text.setText(jobs.getLname());
		lname_text.setEditable(false);
		lname_text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lname_text = new GridBagConstraints();
		gbc_lname_text.fill = GridBagConstraints.HORIZONTAL;
		gbc_lname_text.insets = new Insets(0, 0, 5, 0);
		gbc_lname_text.gridwidth = 7;
		gbc_lname_text.gridx = 2;
		gbc_lname_text.gridy = 4;
		getContentPane().add(lname_text, gbc_lname_text);
		lname_text.setColumns(30);

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
		streetname_text = new JTextField();
		streetname_text.setText(jobs.getStreet());
		streetname_text.setEditable(false);
		streetname_text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_streetname_text = new GridBagConstraints();
		gbc_streetname_text.gridwidth = 7;
		gbc_streetname_text.insets = new Insets(0, 0, 5, 0);
		gbc_streetname_text.fill = GridBagConstraints.HORIZONTAL;
		gbc_streetname_text.gridx = 2;
		gbc_streetname_text.gridy = 6;
		getContentPane().add(streetname_text, gbc_streetname_text);
		streetname_text.setColumns(10);

		lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 1;
		gbc_lblCity.gridy = 7;
		getContentPane().add(lblCity, gbc_lblCity);

		// city textfield
		txtCity = new JTextField();
		txtCity.setText(jobs.getCity());
		txtCity.setEditable(false);
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txtCity = new GridBagConstraints();
		gbc_txtCity.gridwidth = 2;
		gbc_txtCity.insets = new Insets(0, 0, 5, 5);
		gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCity.gridx = 2;
		gbc_txtCity.gridy = 7;
		getContentPane().add(txtCity, gbc_txtCity);
		txtCity.setColumns(10);

		lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.anchor = GridBagConstraints.EAST;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 4;
		gbc_lblState.gridy = 7;
		getContentPane().add(lblState, gbc_lblState);

		// state textfield
		state_text = new JTextField();
		state_text.setText(jobs.getState());
		state_text.setEditable(false);
		state_text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_state_text = new GridBagConstraints();
		gbc_state_text.insets = new Insets(0, 0, 5, 5);
		gbc_state_text.fill = GridBagConstraints.HORIZONTAL;
		gbc_state_text.gridx = 5;
		gbc_state_text.gridy = 7;
		getContentPane().add(state_text, gbc_state_text);
		state_text.setColumns(10);

		lblZip = new JLabel("Zip:");
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblZip = new GridBagConstraints();
		gbc_lblZip.anchor = GridBagConstraints.EAST;
		gbc_lblZip.insets = new Insets(0, 0, 5, 5);
		gbc_lblZip.gridx = 6;
		gbc_lblZip.gridy = 7;
		getContentPane().add(lblZip, gbc_lblZip);

		// zip textfield
		zip_text = new JTextField();
		zip_text.setText(jobs.getZip_code());
		zip_text.setEditable(false);
		zip_text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_zip_text = new GridBagConstraints();
		gbc_zip_text.gridwidth = 2;
		gbc_zip_text.insets = new Insets(0, 0, 5, 0);
		gbc_zip_text.fill = GridBagConstraints.HORIZONTAL;
		gbc_zip_text.gridx = 7;
		gbc_zip_text.gridy = 7;
		getContentPane().add(zip_text, gbc_zip_text);
		zip_text.setColumns(10);

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
		phone_number = new JTextField();
		phone_number.setText(jobs.getPhone_number());
		phone_number.setEditable(false);
		phone_number.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_phone_number = new GridBagConstraints();
		gbc_phone_number.fill = GridBagConstraints.HORIZONTAL;
		gbc_phone_number.insets = new Insets(0, 0, 5, 5);
		gbc_phone_number.gridwidth = 4;
		gbc_phone_number.gridx = 2;
		gbc_phone_number.gridy = 8;
		getContentPane().add(phone_number, gbc_phone_number);
		phone_number.setColumns(10);
	}

	/**
	 * This method sets up the Jlabels, JScroolPane, and Jtextfields for
	 * materials and
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
		materials_text = new JTextArea();
		materials_text.setFont(new Font("Monospaced", Font.PLAIN, 14));
		materials_text.setEditable(false);
		materials_text.setLineWrap(true);
		materials_text.setText("Materials go Here");
		scrollPane.setViewportView(materials_text);
		materials_text.setText(jobs.getMaterials());

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
		notes = new JTextArea();
		notes.setLineWrap(true);
		notes.setColumns(1);
		notes.setFont(new Font("Monospaced", Font.PLAIN, 14));
		notes.setEditable(false);
		GridBagConstraints gbc_notes = new GridBagConstraints();
		gbc_notes.fill = GridBagConstraints.BOTH;
		gbc_notes.insets = new Insets(0, 0, 5, 0);
		gbc_notes.gridwidth = 7;
		gbc_notes.gridx = 2;
		gbc_notes.gridy = 15;
		getContentPane().add(notes, gbc_notes);
		notes.setText(jobs.getNotes());

		// button for View notes and action listener
		btnViewNotesIn = new JButton("View Notes in New Window");
		btnViewNotesIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewNotesIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// opens the View Notes window
				ViewNotes editjob = new ViewNotes(jobs.getNotes());
				editjob.setVisible(true);
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
                        .format(new java.util.Date()) + 
                        ": ViewJob -> User clicked on the View Notes button");

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
		date = new JTextField();
		date.setEditable(false);
		date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		date.setText("yyyy/mm/dd");
		GridBagConstraints gbc_date = new GridBagConstraints();
		gbc_date.insets = new Insets(0, 0, 5, 5);
		gbc_date.fill = GridBagConstraints.HORIZONTAL;
		gbc_date.gridx = 2;
		gbc_date.gridy = 11;
		getContentPane().add(date, gbc_date);
		date.setColumns(10);
		date.setText(jobs.getDate());

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
		hours = new JSpinner(model);
		hours.setFont(new Font("Tahoma", Font.PLAIN, 12));
		hours.setEnabled(false);
		GridBagConstraints gbc_hours = new GridBagConstraints();
		gbc_hours.anchor = GridBagConstraints.WEST;
		gbc_hours.insets = new Insets(0, 0, 5, 5);
		gbc_hours.gridx = 2;
		gbc_hours.gridy = 12;
		getContentPane().add(hours, gbc_hours);
		hours.setValue(new Double(Double.parseDouble(jobs.getHours())));

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
		startTime = new Choice();
		startTime.setEnabled(false);
		GridBagConstraints gbc_startTime = new GridBagConstraints();
		gbc_startTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_startTime.insets = new Insets(0, 0, 5, 5);
		gbc_startTime.gridx = 2;
		gbc_startTime.gridy = 13;

		int startHour = 12;
		for (int i = 0; i < 12; i++) {
			int startMinute = 0;
			if (startHour > 12) {
				startHour = 1;
			}
			for (int j = 0; j < 4; j++) {
				if (startMinute == 0) { // This is so 1:00 displays with two
										// zeros instead of one
					startTime.add(startHour + " : " + startMinute + startMinute);
					startMinute = startMinute + 15;
				} else { // if it is not at the top of the hour it displays the
							// below
					startTime.add(startHour + " : " + startMinute);
					startMinute = startMinute + 15;
				}
			}
			startHour++;
		}

		for (int i = 0; i < 48; i++) {

			if (startTime.getItem(i).equals(jobs.getStartTime()))
				startTime.select(i);

		}
		getContentPane().add(startTime, gbc_startTime);

		// Start Time JRadioButtons
		rdbtnAm_start = new JRadioButton("A.M.");
		rdbtnAm_start.setEnabled(false);
		rdbtnAm_start.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnAm_start = new GridBagConstraints();
		gbc_rdbtnAm_start.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAm_start.gridx = 4;
		gbc_rdbtnAm_start.gridy = 13;
		getContentPane().add(rdbtnAm_start, gbc_rdbtnAm_start);

		rdbtnPm_start = new JRadioButton("P.M.");
		rdbtnPm_start.setEnabled(false);
		rdbtnPm_start.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnPm_start = new GridBagConstraints();
		gbc_rdbtnPm_start.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPm_start.gridx = 5;
		gbc_rdbtnPm_start.gridy = 13;
		getContentPane().add(rdbtnPm_start, gbc_rdbtnPm_start);

		if (jobs.isStartTimeAm()) {
			rdbtnAm_start.setSelected(true);
		} else {
			rdbtnPm_start.setSelected(true);
		}

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
		rdbtnAm_end.setEnabled(false);
		rdbtnAm_end.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnAm_end = new GridBagConstraints();
		gbc_rdbtnAm_end.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAm_end.gridx = 4;
		gbc_rdbtnAm_end.gridy = 14;
		getContentPane().add(rdbtnAm_end, gbc_rdbtnAm_end);

		rdbtnPm_end = new JRadioButton("P.M.");
		rdbtnPm_end.setEnabled(false);
		rdbtnPm_end.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnPm_end = new GridBagConstraints();
		gbc_rdbtnPm_end.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPm_end.gridx = 5;
		gbc_rdbtnPm_end.gridy = 14;
		getContentPane().add(rdbtnPm_end, gbc_rdbtnPm_end);
		if (jobs.isEndTimeAm()) {
			rdbtnAm_end.setSelected(true);
		} else {
			rdbtnPm_end.setSelected(true);
		}

		// JRadioButtons are added to a group so only one can be selected at a
		// time
		ButtonGroup groupEndTime = new ButtonGroup();
		groupEndTime.add(rdbtnPm_end);
		groupEndTime.add(rdbtnAm_end);

		// End Time choices. Displayed by 15 minute increments
		endTime = new Choice();
		endTime.setEnabled(false);
		GridBagConstraints gbc_endTime = new GridBagConstraints();
		gbc_endTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_endTime.insets = new Insets(0, 0, 5, 5);
		gbc_endTime.gridx = 2;
		gbc_endTime.gridy = 14;

		int endHour = 12;
		for (int i = 0; i < 12; i++) {
			int endMinute = 0;
			if (endHour > 12) {
				endHour = 1;
			}
			for (int j = 0; j < 4; j++) {
				if (endMinute == 0) { // This is so 1:00 displays with two zeros
										// instead of one
					endTime.add(endHour + " : " + endMinute + endMinute);
					endMinute = endMinute + 15;
				} else { // if it is not at the top of the hour it displays the
							// below
					endTime.add(endHour + " : " + endMinute);
					endMinute = endMinute + 15;
				}
			}
			endHour++;
		}
		for (int i = 0; i < 48; i++) {

			if (endTime.getItem(i).equals(jobs.getEndTime()))
				endTime.select(i);

		}
		getContentPane().add(endTime, gbc_endTime);

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
		pdf = new JTextField();
		pdf.setEditable(false);
		pdf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pdf.setText("List the file names of the added PDF's");
		GridBagConstraints gbc_pdf = new GridBagConstraints();
		gbc_pdf.fill = GridBagConstraints.HORIZONTAL;
		gbc_pdf.insets = new Insets(0, 0, 5, 0);
		gbc_pdf.gridwidth = 7;
		gbc_pdf.gridx = 2;
		gbc_pdf.gridy = 17;
		getContentPane().add(pdf, gbc_pdf);
		pdf.setColumns(10);
		pdf.setText(jobs.getPDFs());

		// "Add PDF" button and action listener
		btnAddPdf = new JButton("Add PDF");
		btnAddPdf.setEnabled(false);
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
				pdf_text = fd.getDirectory() + fd.getFile();
				if (filename == null)
					System.out.println("You cancelled the choice");
				else {
					System.out.println("You chose " + filename);

				}
				if (filename != null) {
					System.out.println(filename);
					pdf.setText(filename);

				}
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
                        .format(new java.util.Date()) + 
                        ": ViewJob -> User selected the add PDF button");
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
		images = new JTextField();
		images.setEditable(false);
		images.setFont(new Font("Tahoma", Font.PLAIN, 12));
		images.setText("Preview Images or File Name of picture");
		GridBagConstraints gbc_images = new GridBagConstraints();
		gbc_images.fill = GridBagConstraints.HORIZONTAL;
		gbc_images.insets = new Insets(0, 0, 5, 0);
		gbc_images.gridwidth = 7;
		gbc_images.gridx = 2;
		gbc_images.gridy = 19;
		getContentPane().add(images, gbc_images);
		images.setColumns(10);
		images.setText(jobs.getImages());
		
		
		btnViewPdf = new JButton("View PDF");
		btnViewPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					
					String username = System.getProperty("user.name");
					
						File path = null;
						JFileChooser chooser = new JFileChooser();
							
						chooser.setCurrentDirectory(new File("C:\\Users\\" + username + "\\Documents\\PDFS for Handyman\\" + jobs.getJob_name()));
						if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
							path = chooser.getSelectedFile();
						}
						try {
							Desktop.getDesktop().open(path);
						} catch (IOException e1) {
							System.out.println("File not found..");
						}
						
					System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
	                        .format(new java.util.Date()) + 
	                        ": ViewJob -> User clicked on the view PDF button");
				} catch (Exception e) {
				
				}
			}
		});
		btnViewPdf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnViewPdf1 = new GridBagConstraints();
		gbc_btnViewPdf1.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewPdf1.gridx = 5;
		gbc_btnViewPdf1.gridy = 18;
		getContentPane().add(btnViewPdf, gbc_btnViewPdf1);

		// "Add Image" button and actionlistener
		btnAddImage = new JButton("Add Image");
		btnAddImage.setEnabled(false);
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
				filename = fd.getFile();
				if (filename == null)
					System.out.println("You cancelled the choice");
				else {
					System.out.println("You chose " + filename);

				}
				if (filename != null) {
					System.out.println(filename);
					images.setText(filename);

				}
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
                        .format(new java.util.Date()) + 
                        ": ViewJob -> User clicked on the add Image button");
			}
		});

	}

	/**
	 * This method sets up the Jbuttons and acitonlisteners for Back and Edit
	 * 
	 */
	public void BackEditSection() {
	}
}
