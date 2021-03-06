package Search_DB;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Adding_jobs.AddJob;
import Adding_jobs.EditJob;
import Adding_jobs.ViewJob;
import Calendar.JCalendarDialog;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 * This class builds a JFrame that shows the search results of a given query
 * 
 * @author Shawn Reece Date: 2/9/2016
 */
@SuppressWarnings("serial")
public class Search_GUI extends JFrame {
	private JTable table;
	private JPanel btnPanel;
	private JButton add;
	private JButton edit;
	private JLabel resultsLbl;
	private JButton remove;
	private static Search_Driver driver;
	private JScrollPane contentPane;
	private JButton view;
	String[] columnNames = { "Work ID", "Job Name", "First Name", "Last Name", "Street", "City", "State", "Zip Code",
			"Phone Number", "Date" };
	private String query;
	private String searchType;
	private JPanel panel;
	private JPanel searchPanel;
	private JTextField valueTxt;
	private JButton search;
	private DefaultTableModel model;
	private JPanel refreshPanel;
	private JButton refresh;
	private AddJob newAddJob;
	private EditJob editedJob;

	/**
	 * Create the frame.
	 */
	public Search_GUI(String query, String searchType) {

		// build the window
		super("Search Results");
		setBounds(100, 100, 750, 361);
		this.setVisible(true);
		this.setQuery(query);
		this.setSearchType(searchType);
		this.setLocationRelativeTo(null);
		ImageIcon img = new ImageIcon(Search_GUI.class.getResource("Handyman Scheduler Logo 1.png"));
		this.setIconImage(img.getImage());
		// Object to start the searching
		driver = new Search_Driver(query, searchType);
		this.setResizable(false);

		/* call the methods to add the components to the frame */
		initSearchPanel();
		initRefresh();
		buildTable();
		initButtonPanel();

		// if there are no results prompt the use
		if (driver.getResults().size() == 0) {
			String message = String.format("No results");
			JOptionPane.showMessageDialog(null, message, "No records found", 2);
		}

		// disconnect from db
		driver.closeConn();
	}

	public void initButtonPanel() {

		// Creates a calendar button
		JButton calendarButton = new JButton("Calendar");

		Color lightpurple = new Color(255, 220, 255);
		calendarButton.setBackground(lightpurple);

		calendarButton.addActionListener(new ActionListener() {

			// when the button is clicked it creates a calendar dialog
			public void actionPerformed(ActionEvent e) {
				/* Log action */
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": Search_GUI -> Clicked calendar button");

				JCalendarDialog dialog = new JCalendarDialog();
				dialog.setDialogTitle("HandyMan Calendar");
				// dialog.setLocale(Locale.ENGLISH);
				dialog.createDialog();
				if (dialog.getReturnCode() == JCalendarDialog.OK_PRESSED) {
					dialog.dispose();
					dispose();
				}
				return;
			}
		});

		/*
		 * this code below handles adding jobs
		 */
		add = new JButton("Add a Job");
		Color lightgreen = new Color(200, 255, 225);
		add.setBackground(lightgreen);
		add.addActionListener(new ActionListener() {
			@Override
			/**
			 * When the user presses save, A add job form is created and enables
			 * the refresh button
			 */
			public void actionPerformed(ActionEvent e) {
				/* Log action */
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": Search_GUI -> Clicked add job");
				newAddJob = new AddJob();
				refresh.setEnabled(true);
				table.setEnabled(false);
				return;
			}
		});

		view = new JButton("View a Job");
		Color yellow = new Color(255, 255, 204);
		view.setBackground(yellow);
		view.addActionListener(new ActionListener() {

			@Override
			/**
			 * When the user presses view job, a view form is created and the
			 * form is populated of the result that was passed in
			 */
			public void actionPerformed(ActionEvent e) {
				/* Log action */
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": Search_GUI -> Clicked view job");
				try {
					if (driver.getResults().size() != 0) {
						String workId = (String) table.getValueAt(table.getSelectedRow(), 0);
						Search_Driver view = new Search_Driver(workId, "WORKID");
						new ViewJob(view.getResults().get(0));
					}
				} catch (Exception table) {
					JOptionPane.showMessageDialog(null, "Please select a value from the table.");
					table.printStackTrace();
				}

				return;
			}
		});

		/*
		 * This code code below handles removing a job
		 */
		remove = new JButton("Remove a Job");
		Color lightred = new Color(255, 204, 204);
		remove.setBackground(lightred);
		remove.addActionListener(new ActionListener() {

			@Override
			/**
			 * When the user presses remove job the program will find the
			 * selected row in the db and remove from the db and update the
			 * table
			 */
			public void actionPerformed(ActionEvent e) {
				/* Log action */
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": Search_GUI -> Clicked remove job");

				try {

					if (driver.getResults().size() != 0) {

						// the row of which the record is in
						int rowNum = table.getSelectedRow();

						// the column of the workid. We are going to use this to
						// find the record to remove
						int column = 0;

						// the workid of of the record at the selected row
						String jobId = table.getValueAt(rowNum, column).toString();

						// asks the user if are sure they want to delete the
						// record
						int reply = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to delete this record? This cannot be undone.", "Remove record",
								JOptionPane.YES_NO_OPTION);

						/*
						 * If yes the removing of the record from the db will be
						 * invoked
						 */
						if (reply == JOptionPane.YES_OPTION) {
							new Removing_Driver(jobId);
							System.out.println(table.getSelectedRow());
							// table.convert... makes sure we grab the right row
							model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
							String numResults = String.format("Number of results: %s", model.getRowCount());
							resultsLbl.setText(numResults);
							repaint();
							revalidate();
							return;
						} else {
							return;
						}

					}

					dispose();

				} catch (Exception table) {
					JOptionPane.showMessageDialog(null, "Please select a value from the table.");
				}
			}
		});

		/*
		 * This code below handles editing jobs
		 */
		edit = new JButton("Edit Job");
		Color lightblue = new Color(210, 255, 255);
		edit.setBackground(lightblue);
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Log action */
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": Search_GUI -> Clicked edit job");
				try {
					if (driver.getResults().size() != 0) {
						int row = table.getSelectedRow();
						int col = 0;
						String value = (String) table.getValueAt(row, col);
						System.out.println(value);
						Search_Driver driver = new Search_Driver(value, "WORKID");
						editedJob = new EditJob(driver.getResults().get(0), value);
						table.setEnabled(false);
						refresh.setEnabled(true);
					}
				} catch (Exception table) {
					JOptionPane.showMessageDialog(null, "Please select a value from the table.");
				}

			}
		});

		// This label holds the number of results
		getContentPane().setLayout(null);
		String numResults = String.format("Number of results: %s", driver.getResults().size());
		resultsLbl = new JLabel(numResults);

		// The button panel to hold all the buttons
		btnPanel = new JPanel();
		btnPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnPanel.setBounds(10, 280, 714, 41);
		btnPanel.add(calendarButton);

		// add buttons to panel and panel to the frame
		btnPanel.add(add);
		btnPanel.add(view);
		btnPanel.add(edit);
		btnPanel.add(remove);
		btnPanel.add(resultsLbl);
		getContentPane().add(btnPanel);
	}

	public void initRefresh() {
		// panel to hold the refresh button
		refreshPanel = new JPanel();
		refreshPanel.setBounds(10, 11, 105, 41);
		getContentPane().add(refreshPanel);
		refreshPanel.setLayout(new BorderLayout(0, 0));

		// button that refreshes the table
		refresh = new JButton("refresh");
		Color green = new Color(150, 255, 150);
		refresh.setBackground(green);
		refresh.setEnabled(false);
		refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Log action */
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": Search_GUI -> Clicked refresh");
				table.setEnabled(true);
				if (newAddJob != null && newAddJob.isNewJobAdd()) {
					Search_Driver newJob = new Search_Driver("", "CURRENTID");
					String workId = newJob.getResults().get(0).getWork_Id();
					String jobName = newJob.getResults().get(0).getJob_name();
					String fname = newJob.getResults().get(0).getFname();
					String lname = newJob.getResults().get(0).getLname();
					String street = newJob.getResults().get(0).getStreet();
					String city = newJob.getResults().get(0).getCity();
					String state = newJob.getResults().get(0).getState();
					String zip = newJob.getResults().get(0).getZip_code();
					String phone = newJob.getResults().get(0).getPhone_number();
					String date = newJob.getResults().get(0).getDate();
					Object[] rowdata = { workId, jobName, fname, lname, street, city, state, zip, phone, date };
					System.out.println(model.getRowCount());
					model.addRow(rowdata);
					String numResults = String.format("Numer of results: %s", model.getRowCount());
					resultsLbl.setText(numResults);
					repaint();
					revalidate();
					newAddJob.setNewJobAdd(false);
					refresh.setEnabled(false);
				} else if (editedJob != null && editedJob.isEdited()) {
					model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
					Search_Driver newJob = new Search_Driver(editedJob.getWorkId(), "WORKID");
					String workId = newJob.getResults().get(0).getWork_Id();
					String jobName = newJob.getResults().get(0).getJob_name();
					String fname = newJob.getResults().get(0).getFname();
					String lname = newJob.getResults().get(0).getLname();
					String street = newJob.getResults().get(0).getStreet();
					String city = newJob.getResults().get(0).getCity();
					String state = newJob.getResults().get(0).getState();
					String zip = newJob.getResults().get(0).getZip_code();
					String phone = newJob.getResults().get(0).getPhone_number();
					String date = newJob.getResults().get(0).getDate();
					Object[] rowdata = { workId, jobName, fname, lname, street, city, state, zip, phone, date };
					System.out.println(model.getRowCount());
					model.addRow(rowdata);
					String numResults = String.format("Numer of results: %s", model.getRowCount());
					resultsLbl.setText(numResults);
					editedJob.setEdited(false);
					repaint();
					revalidate();
					refresh.setEnabled(false);
				} else {
					refresh.setEnabled(false);
					JOptionPane.showMessageDialog(null, "No new updates");
				}

			}
		});

		// adds the button to the refresh panel
		refreshPanel.add(refresh);
	}

	/**
	 * This method builds the table where the results of the search are held
	 */
	public void buildTable() {
		Object[][] data = new Object[driver.getResults().size()][columnNames.length];
		int j = 0;

		// Builds the table's data
		for (int i = 0; i < driver.getResults().size(); i++) {
			data[i][j] = driver.getResults().get(i).getWork_Id();
			data[i][j + 1] = driver.getResults().get(i).getJob_name();
			data[i][j + 2] = driver.getResults().get(i).getFname();
			data[i][j + 3] = driver.getResults().get(i).getLname();
			data[i][j + 4] = driver.getResults().get(i).getStreet();
			data[i][j + 5] = driver.getResults().get(i).getCity();
			data[i][j + 6] = driver.getResults().get(i).getState();
			data[i][j + 7] = driver.getResults().get(i).getZip_code();
			data[i][j + 8] = driver.getResults().get(i).getPhone_number();
			data[i][j + 9] = driver.getResults().get(i).getDate();
		}

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Result table",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 63, 714, 206);
		getContentPane().add(panel);

		model = new DefaultTableModel(data, columnNames);

		// builds the table and configures iy
		table = new JTable(model);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		panel.setLayout(null);
		table.setAutoCreateRowSorter(true);
		table.getTableHeader().setReorderingAllowed(false);

		table.addMouseListener(new MouseAdapter() {

			/**
			 * Lets us know the current row
			 */
			public void mouseClicked(MouseEvent e) {
				System.out.println(table.getSelectedRow());
			}

		});

		// Here I attach the table to a JScrollPane
		contentPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.setBounds(10, 21, 694, 174);
		panel.add(contentPane);

	}

	/**
	 * This builds search panel
	 */
	public void initSearchPanel() {
		// panel to hold the search button
		searchPanel = new JPanel();
		searchPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		searchPanel.setBounds(380, 11, 344, 46);
		getContentPane().add(searchPanel);
		searchPanel.setLayout(null);

		// makes a text field
		valueTxt = new JTextField();
		valueTxt.setBounds(133, 11, 102, 25);
		searchPanel.add(valueTxt);
		valueTxt.setColumns(10);

		// combo box to hold the search filters
		JComboBox<String> searchFilters = new JComboBox<String>();
		searchFilters.addItem("First Name");
		searchFilters.addItem("Last Name");
		searchFilters.addItem("Date");
		searchFilters.addItem("Address");
		searchFilters.addItem("Show All");
		searchFilters.setBounds(10, 13, 113, 20);
		searchPanel.add(searchFilters);

		// search button
		search = new JButton("Search");
		Color green = new Color(150, 255, 150);
		search.setBackground(green);
		search.addActionListener(new ActionListener() {

			@Override
			/**
			 * Searches the db
			 */
			public void actionPerformed(ActionEvent e) {
				/* Log action */
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": Search_GUI -> Clicked search");
				remove(panel);
				driver = new Search_Driver(valueTxt.getText(), searchFilters.getSelectedItem().toString());
				panel.removeAll();
				repaint();
				revalidate();
				buildTable();
				String numResults = String.format("Numer of results: %s", driver.getResults().size());
				resultsLbl.setText(numResults);

				// if there are no results prompt the use
				if (driver.getResults().size() == 0) {
					String message = String.format("No results");
					JOptionPane.showMessageDialog(null, message, "No records found", 2);
				}
			}
		});
		search.setBounds(245, 12, 89, 23);
		searchPanel.add(search);
	}

	public void refreshTable() {

	}

	////////////////////////////// Getters and Setters//////////////////////////

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}
