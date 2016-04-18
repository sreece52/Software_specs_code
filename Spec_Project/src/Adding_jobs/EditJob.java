package Adding_jobs;

import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;

import Search_DB.Editing_Driver;
import Search_DB.ImportJob;
import Search_DB.Jobs;
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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.JRadioButton;

/**
 * This class creates the window EditJob
 * 
 * @author Julia Roscher DATE: 3/23/2016
 *
 */

@SuppressWarnings("serial")
public class EditJob extends JFrame {
	private EditNotes note;
	private JTextField fname_txt;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField lname_txt;
	private JLabel lblPhoneNumber;
	private JTextField phone_txt;
	private JLabel lblMaterials;
	private JLabel lblHours;
	private JLabel lblNotes;
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
	private JButton btnOpenPdf;
	private JButton btnOpenImage;
	private String pdf;
	private String image;
	private ImportJob importedJob;
	private EditJob edit = this;
	private Jobs job;
	private boolean isEdited = false;
	private String workId;

	/**
	 * Frame Created
	 * 
	 * Methods must be called by constructor
	 * 
	 * @param editedJob
	 * 
	 */
	public EditJob(Jobs editedJob) {
		this.editedJob = editedJob;
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setTitle("Edit Job");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

		setBounds(100, 100, 779, 739);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 76, 25, 130, 36, 90, 130, 80, 130, 61, 0 };
		gridBagLayout.rowHeights = new int[] { 31, 0, 0, 31, 31, 31, 29, 20, 31, 0, 56, 29, 29, 29, 29, 56, 35, 29, 35,
				29, 35, 32, 49, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());
		this.setVisible(true);
		NameSection();
		AddressSection();
		MaterialsAndNotesSection();
		DateAndTimeSection();
		PdfAndImagesSection();
		CancelSaveSection();
		IdAndImportSelction();

	}

	public EditJob(Jobs editedJob, String workId) {
		this.workId = workId;
		this.editedJob = editedJob;
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setTitle("Edit Job");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

		setBounds(100, 100, 779, 739);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 76, 25, 130, 36, 90, 130, 80, 130, 61, 0 };
		gridBagLayout.rowHeights = new int[] { 31, 0, 0, 31, 31, 31, 29, 20, 31, 0, 56, 29, 29, 29, 29, 56, 35, 29, 35,
				29, 35, 32, 49, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());
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
		btnImportInformationFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnImportInformationFrom = new GridBagConstraints();
		gbc_btnImportInformationFrom.gridwidth = 5;
		gbc_btnImportInformationFrom.insets = new Insets(0, 0, 5, 5);
		gbc_btnImportInformationFrom.gridx = 2;
		gbc_btnImportInformationFrom.gridy = 2;
		getContentPane().add(btnImportInformationFrom, gbc_btnImportInformationFrom);

		btnOpenImage = new JButton("Open Image");
		btnOpenImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": EditJob -> clicked open image");
				try {
					File file = new File(image);
					Desktop.getDesktop().open(file);
				} catch (Exception e1) {
					System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
							+ ": EditJob -> Excpetion stacktrace");
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "File was not found. Make sure file is on the computer",
							"File not Found", 2);
				}
			}
		});
		btnOpenImage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnOpenImage = new GridBagConstraints();
		gbc_btnOpenImage.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpenImage.gridx = 5;
		gbc_btnOpenImage.gridy = 19;
		getContentPane().add(btnOpenImage, gbc_btnOpenImage);

		// Cancel Button and Actionlistener
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.red);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridwidth = 2;
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.anchor = GridBagConstraints.SOUTH;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 21;
		getContentPane().add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				return;
			}
		});

		// Save button and actionlistener
		btnSave = new JButton("Save");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(new Color(0, 102, 206));
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": EditJob -> clicked save adding record to database..");
				String notes;
				if (note == null) {
					notes = "";
				} else {
					notes = note.getNotes();
				}

				/* Temporary calendar for validation purposes */
				Calendar temp = Calendar.getInstance();

				System.out.println("save button pressed");
				if (date_txt.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
					/* Prevent user from entering invalid months */
					if (Integer.parseInt(date_txt.getText().substring(5, 7)) <= temp.getActualMaximum(Calendar.MONTH)) {
						temp.set(Calendar.MONTH, Integer.parseInt(date_txt.getText().substring(5, 7)));

						/* Determine num of days in month */
						int maxMonthDays = temp.getActualMaximum(Calendar.DAY_OF_MONTH);
						if (Integer.parseInt(date_txt.getText().substring(8)) <= maxMonthDays) {
							int reply = JOptionPane.showConfirmDialog(null,
									"Are you sure you want to edit this record? This cannot be undone.", "Confirm Edit",
									JOptionPane.YES_NO_OPTION);
							if (reply == JOptionPane.YES_OPTION) {

								Jobs newJob = new Jobs(editedJob.getWork_Id(), job_name_txt.getText(),
										fname_txt.getText(), lname_txt.getText(), street_txt.getText(),
										city_txt.getText(), state_txt.getText(), zip_txt.getText(), phone_txt.getText(),
										materials_txt.getText(), date_txt.getText(),
										hours_spinner.getValue().toString(), startTime_txt.getSelectedItem(),
										end_txt.getSelectedItem(), notes, pdf_txt.getText(), images_txt.getText(),
										rdbtnAmStart.isSelected(), rdbtnAmEnd.isSelected());

								/* Checks for invalid leap years */
								boolean exceptionThrown = false;
								try {
									new Editing_Driver(newJob);
								} catch (SQLException sqle) {
									JOptionPane.showMessageDialog(null, "Invalid Date", "Leap Year", 2);
									exceptionThrown = true;
								}
								if (!exceptionThrown) {
									isEdited = true;
									dispose();
								}
							}
						} else { // Day incorrect
							JOptionPane.showMessageDialog(null, "Day of month must exist", "Incorrect Day Format", 2);
						}
					} else { // Month incorrect
						JOptionPane.showMessageDialog(null, "Month must be 01 - 12", "Incorrect Month Format", 2);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Date does not match required format YYYY-MM-DD",
							"Invalid Format", 1);
				}
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
				// logging action
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": EditJob -> clicked importing job");
				importedJob = new ImportJob(edit);
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
		pdf_txt.setText(job.getPDFs());
		images_txt.setText(job.getImages());
		materials_txt.setText(job.getMaterials());
		date_txt.setText(job.getDate());
		hours_spinner.setValue(new Double(Double.parseDouble(job.getHours())));
		for (int i = 0; i < 48; i++) {
			if (startTime_txt.getItem(i).equals(job.getStartTime()))
				startTime_txt.select(i);
		}
		for (int i = 0; i < 48; i++) {
			if (end_txt.getItem(i).equals(job.getStartTime()))
				end_txt.select(i);
		}
		if (job.isStartTimeAm()) {
			rdbtnAmStart.setSelected(true);
		} else {
			rdbtnPmStart.setSelected(true);
		}

		if (job.isEndTimeAm()) {
			rdbtnAmEnd.setSelected(true);
		} else {
			rdbtnPmEnd.setSelected(true);
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
		job_name_txt.setText(editedJob.getJob_name());

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
		fname_txt.setText(editedJob.getFname());

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
		lname_txt.setText(editedJob.getLname());

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
		street_txt.setText(editedJob.getStreet());

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
		city_txt.setText(editedJob.getCity());

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
		gbc_state_txt.anchor = GridBagConstraints.NORTH;
		gbc_state_txt.insets = new Insets(0, 0, 5, 5);
		gbc_state_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_state_txt.gridx = 5;
		gbc_state_txt.gridy = 7;
		getContentPane().add(state_txt, gbc_state_txt);
		state_txt.setColumns(10);
		state_txt.setText(editedJob.getState());

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
		zip_txt.setText(editedJob.getZip_code());

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
		materials_txt.setFont(new Font("Monospaced", Font.PLAIN, 14));
		materials_txt.setLineWrap(true);
		materials_txt.setText(editedJob.getMaterials());
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
		date_txt.setText(editedJob.getDate());

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
		hours_spinner.setValue(new Double(Double.parseDouble(editedJob.getHours())));

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
		rdbtnAmStart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnAmStart = new GridBagConstraints();
		gbc_rdbtnAmStart.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAmStart.gridx = 4;
		gbc_rdbtnAmStart.gridy = 13;
		getContentPane().add(rdbtnAmStart, gbc_rdbtnAmStart);

		rdbtnPmStart = new JRadioButton("P.M.");
		rdbtnPmStart.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEndTime = new GridBagConstraints();
		gbc_lblEndTime.anchor = GridBagConstraints.EAST;
		gbc_lblEndTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndTime.gridwidth = 2;
		gbc_lblEndTime.gridx = 0;
		gbc_lblEndTime.gridy = 14;
		getContentPane().add(lblEndTime, gbc_lblEndTime);

		// EndTime JRadioButtons
		rdbtnAmEnd = new JRadioButton("A.M.");
		rdbtnAmEnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnAmEnd = new GridBagConstraints();
		gbc_rdbtnAmEnd.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAmEnd.gridx = 4;
		gbc_rdbtnAmEnd.gridy = 14;
		getContentPane().add(rdbtnAmEnd, gbc_rdbtnAmEnd);

		rdbtnPmEnd = new JRadioButton("P.M.");
		rdbtnPmEnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
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

		// button for Add notes and action listener
		btnViewNotesIn = new JButton("Edit Notes in New Window");
		btnViewNotesIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewNotesIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// logging event
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": EditJob -> clicked view notes");
				// opens the Edit Notes window
				note = new EditNotes(editedJob.getNotes());
				note.setVisible(true);

			}
		});
		GridBagConstraints gbc_btnViewNotesIn = new GridBagConstraints();
		gbc_btnViewNotesIn.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewNotesIn.gridwidth = 3;
		gbc_btnViewNotesIn.gridx = 2;
		gbc_btnViewNotesIn.gridy = 15;
		getContentPane().add(btnViewNotesIn, gbc_btnViewNotesIn);

		lblPdf = new JLabel("PDF:");
		lblPdf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPdf = new GridBagConstraints();
		gbc_lblPdf.anchor = GridBagConstraints.EAST;
		gbc_lblPdf.insets = new Insets(0, 0, 5, 5);
		gbc_lblPdf.gridwidth = 2;
		gbc_lblPdf.gridx = 0;
		gbc_lblPdf.gridy = 16;
		getContentPane().add(lblPdf, gbc_lblPdf);

		// PDF JTextField that displays the saved PDF
		pdf_txt = new JTextField();
		pdf_txt.setEditable(false);
		pdf_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pdf_txt.setText("No PDFs Added");
		GridBagConstraints gbc_pdf_txt = new GridBagConstraints();
		gbc_pdf_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_pdf_txt.insets = new Insets(0, 0, 5, 0);
		gbc_pdf_txt.gridwidth = 7;
		gbc_pdf_txt.gridx = 2;
		gbc_pdf_txt.gridy = 16;
		getContentPane().add(pdf_txt, gbc_pdf_txt);
		pdf_txt.setColumns(10);
		pdf_txt.setText(editedJob.getPDFs());

		// "Add PDF" button and action listener
		btnAddPdf = new JButton("Add PDF");
		btnAddPdf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAddPdf = new GridBagConstraints();
		gbc_btnAddPdf.anchor = GridBagConstraints.EAST;
		gbc_btnAddPdf.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddPdf.gridwidth = 2;
		gbc_btnAddPdf.gridx = 2;
		gbc_btnAddPdf.gridy = 17;
		getContentPane().add(btnAddPdf, gbc_btnAddPdf);

		btnAddPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// logging event
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": EditJob -> clicked add pdf");

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

				// logging event
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": EditJob -> clicker open pdf");

				try {
					File file = new File(pdf);
					Desktop.getDesktop().open(file);
				} catch (Exception e) {
					System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
							+ ": EditJob -> exception stack track:");
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "File was not found. Make sure file is on the computer",
							"File not Found", 2);
				}
			}
		});
		btnOpenPdf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnOpenPdf = new GridBagConstraints();
		gbc_btnOpenPdf.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpenPdf.gridx = 5;
		gbc_btnOpenPdf.gridy = 17;
		getContentPane().add(btnOpenPdf, gbc_btnOpenPdf);

		lblImages = new JLabel("Images:");
		lblImages.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblImages = new GridBagConstraints();
		gbc_lblImages.anchor = GridBagConstraints.EAST;
		gbc_lblImages.insets = new Insets(0, 0, 5, 5);
		gbc_lblImages.gridwidth = 2;
		gbc_lblImages.gridx = 0;
		gbc_lblImages.gridy = 18;
		getContentPane().add(lblImages, gbc_lblImages);

		// Images JTextField
		images_txt = new JTextField();
		images_txt.setEditable(false);
		images_txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		images_txt.setText("No Images Added");
		GridBagConstraints gbc_images_txt = new GridBagConstraints();
		gbc_images_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_images_txt.insets = new Insets(0, 0, 5, 0);
		gbc_images_txt.gridwidth = 7;
		gbc_images_txt.gridx = 2;
		gbc_images_txt.gridy = 18;
		getContentPane().add(images_txt, gbc_images_txt);
		images_txt.setColumns(10);
		images_txt.setText(editedJob.getImages());

	}

	/**
	 * This method sets up the Jbuttons and acitonlisteners for Cancel and Save
	 * 
	 * Needs to be setup so values are only saved when "Save" is pressed
	 * 
	 */
	public void CancelSaveSection() {

		// "Add Image" button and actionlistener
		btnAddImage = new JButton("Add Image");
		btnAddImage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAddImage = new GridBagConstraints();
		gbc_btnAddImage.anchor = GridBagConstraints.EAST;
		gbc_btnAddImage.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddImage.gridwidth = 2;
		gbc_btnAddImage.gridx = 2;
		gbc_btnAddImage.gridy = 19;
		getContentPane().add(btnAddImage, gbc_btnAddImage);

		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// logging event
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": EditJob -> Clicked add Image");

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

	public void clear() {
		job_name_txt.setText("");
		fname_txt.setText("");
		lname_txt.setText("");
		street_txt.setText("");
		city_txt.setText("");
		state_txt.setText("");
		zip_txt.setText("");
		phone_txt.setText("");
		street_txt.setText("");
		city_txt.setText("");
		state_txt.setText("");
		zip_txt.setText("");
		phone_txt.setText("");
		materials_txt.setText("");
		// notes_txt.setText("");
		pdf_txt.setText("");
		images_txt.setText("");
		end_txt.select(0);
		hours_spinner.setValue(0);
		startTime_txt.select(0);
	}

	public boolean isEdited() {
		return isEdited;
	}

	public void setEdited(boolean isEdited) {
		this.isEdited = isEdited;
	}

	public EditNotes getNote() {
		return note;
	}

	public void setNote(EditNotes note) {
		this.note = note;
	}

	public JTextField getFname_txt() {
		return fname_txt;
	}

	public void setFname_txt(JTextField fname_txt) {
		this.fname_txt = fname_txt;
	}

	public JLabel getLblFirstName() {
		return lblFirstName;
	}

	public void setLblFirstName(JLabel lblFirstName) {
		this.lblFirstName = lblFirstName;
	}

	public JLabel getLblLastName() {
		return lblLastName;
	}

	public void setLblLastName(JLabel lblLastName) {
		this.lblLastName = lblLastName;
	}

	public JTextField getLname_txt() {
		return lname_txt;
	}

	public void setLname_txt(JTextField lname_txt) {
		this.lname_txt = lname_txt;
	}

	public JLabel getLblPhoneNumber() {
		return lblPhoneNumber;
	}

	public void setLblPhoneNumber(JLabel lblPhoneNumber) {
		this.lblPhoneNumber = lblPhoneNumber;
	}

	public JTextField getPhone_txt() {
		return phone_txt;
	}

	public void setPhone_txt(JTextField phone_txt) {
		this.phone_txt = phone_txt;
	}

	public JLabel getLblMaterials() {
		return lblMaterials;
	}

	public void setLblMaterials(JLabel lblMaterials) {
		this.lblMaterials = lblMaterials;
	}

	public JLabel getLblHours() {
		return lblHours;
	}

	public void setLblHours(JLabel lblHours) {
		this.lblHours = lblHours;
	}

	public JLabel getLblNotes() {
		return lblNotes;
	}

	public void setLblNotes(JLabel lblNotes) {
		this.lblNotes = lblNotes;
	}

	public JButton getBtnViewNotesIn() {
		return btnViewNotesIn;
	}

	public void setBtnViewNotesIn(JButton btnViewNotesIn) {
		this.btnViewNotesIn = btnViewNotesIn;
	}

	public JLabel getLblPdf() {
		return lblPdf;
	}

	public void setLblPdf(JLabel lblPdf) {
		this.lblPdf = lblPdf;
	}

	public JTextField getPdf_txt() {
		return pdf_txt;
	}

	public void setPdf_txt(JTextField pdf_txt) {
		this.pdf_txt = pdf_txt;
	}

	public JButton getBtnAddPdf() {
		return btnAddPdf;
	}

	public void setBtnAddPdf(JButton btnAddPdf) {
		this.btnAddPdf = btnAddPdf;
	}

	public JLabel getLblImages() {
		return lblImages;
	}

	public void setLblImages(JLabel lblImages) {
		this.lblImages = lblImages;
	}

	public JTextField getImages_txt() {
		return images_txt;
	}

	public void setImages_txt(JTextField images_txt) {
		this.images_txt = images_txt;
	}

	public JButton getBtnAddImage() {
		return btnAddImage;
	}

	public void setBtnAddImage(JButton btnAddImage) {
		this.btnAddImage = btnAddImage;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public static EditJob getFrame() {
		return frame;
	}

	public static void setFrame(EditJob frame) {
		EditJob.frame = frame;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTextArea getMaterials_txt() {
		return materials_txt;
	}

	public void setMaterials_txt(JTextArea materials_txt) {
		this.materials_txt = materials_txt;
	}

	public JSpinner getHours_spinner() {
		return hours_spinner;
	}

	public void setHours_spinner(JSpinner hours_spinner) {
		this.hours_spinner = hours_spinner;
	}

	public JLabel getLblStartTime() {
		return lblStartTime;
	}

	public void setLblStartTime(JLabel lblStartTime) {
		this.lblStartTime = lblStartTime;
	}

	public JLabel getLblEndTime() {
		return lblEndTime;
	}

	public void setLblEndTime(JLabel lblEndTime) {
		this.lblEndTime = lblEndTime;
	}

	public JLabel getLblDate_1() {
		return lblDate_1;
	}

	public void setLblDate_1(JLabel lblDate_1) {
		this.lblDate_1 = lblDate_1;
	}

	public JLabel getLblStreetName() {
		return lblStreetName;
	}

	public void setLblStreetName(JLabel lblStreetName) {
		this.lblStreetName = lblStreetName;
	}

	public JLabel getLblCity() {
		return lblCity;
	}

	public void setLblCity(JLabel lblCity) {
		this.lblCity = lblCity;
	}

	public JTextField getCity_txt() {
		return city_txt;
	}

	public void setCity_txt(JTextField city_txt) {
		this.city_txt = city_txt;
	}

	public JTextField getStreet_txt() {
		return street_txt;
	}

	public void setStreet_txt(JTextField street_txt) {
		this.street_txt = street_txt;
	}

	public JLabel getLblState() {
		return lblState;
	}

	public void setLblState(JLabel lblState) {
		this.lblState = lblState;
	}

	public JTextField getState_txt() {
		return state_txt;
	}

	public void setState_txt(JTextField state_txt) {
		this.state_txt = state_txt;
	}

	public JLabel getLblZip() {
		return lblZip;
	}

	public void setLblZip(JLabel lblZip) {
		this.lblZip = lblZip;
	}

	public JTextField getZip_txt() {
		return zip_txt;
	}

	public void setZip_txt(JTextField zip_txt) {
		this.zip_txt = zip_txt;
	}

	public JButton getBtnImportInformationFrom() {
		return btnImportInformationFrom;
	}

	public void setBtnImportInformationFrom(JButton btnImportInformationFrom) {
		this.btnImportInformationFrom = btnImportInformationFrom;
	}

	public JTextField getDate_txt() {
		return date_txt;
	}

	public void setDate_txt(JTextField date_txt) {
		this.date_txt = date_txt;
	}

	public Choice getStartTime_txt() {
		return startTime_txt;
	}

	public void setStartTime_txt(Choice startTime_txt) {
		this.startTime_txt = startTime_txt;
	}

	public Choice getEnd_txt() {
		return end_txt;
	}

	public void setEnd_txt(Choice end_txt) {
		this.end_txt = end_txt;
	}

	public JRadioButton getRdbtnAmStart() {
		return rdbtnAmStart;
	}

	public void setRdbtnAmStart(JRadioButton rdbtnAmStart) {
		this.rdbtnAmStart = rdbtnAmStart;
	}

	public JRadioButton getRdbtnPmStart() {
		return rdbtnPmStart;
	}

	public void setRdbtnPmStart(JRadioButton rdbtnPmStart) {
		this.rdbtnPmStart = rdbtnPmStart;
	}

	public JRadioButton getRdbtnAmEnd() {
		return rdbtnAmEnd;
	}

	public void setRdbtnAmEnd(JRadioButton rdbtnAmEnd) {
		this.rdbtnAmEnd = rdbtnAmEnd;
	}

	public JRadioButton getRdbtnPmEnd() {
		return rdbtnPmEnd;
	}

	public void setRdbtnPmEnd(JRadioButton rdbtnPmEnd) {
		this.rdbtnPmEnd = rdbtnPmEnd;
	}

	public JLabel getLblJobName() {
		return lblJobName;
	}

	public void setLblJobName(JLabel lblJobName) {
		this.lblJobName = lblJobName;
	}

	public JTextField getJob_name_txt() {
		return job_name_txt;
	}

	public void setJob_name_txt(JTextField job_name_txt) {
		this.job_name_txt = job_name_txt;
	}

	public Jobs getEditedJob() {
		return editedJob;
	}

	public void setEditedJob(Jobs editedJob) {
		this.editedJob = editedJob;
	}

	public JButton getBtnOpenPdf() {
		return btnOpenPdf;
	}

	public void setBtnOpenPdf(JButton btnOpenPdf) {
		this.btnOpenPdf = btnOpenPdf;
	}

	public JButton getBtnOpenImage() {
		return btnOpenImage;
	}

	public void setBtnOpenImage(JButton btnOpenImage) {
		this.btnOpenImage = btnOpenImage;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ImportJob getImportedJob() {
		return importedJob;
	}

	public void setImportedJob(ImportJob importedJob) {
		this.importedJob = importedJob;
	}

	public EditJob getEdit() {
		return edit;
	}

	public void setEdit(EditJob edit) {
		this.edit = edit;
	}

	public Jobs getJob() {
		return job;
	}

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}
}
