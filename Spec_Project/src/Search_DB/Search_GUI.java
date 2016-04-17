package Search_DB;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
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
	String[] columnNames = { "Job Name", "First Name", "Last Name", "Street", "City", "State", "Zip Code",
			"Phone Number", "Date" };

	private String query;
	private String searchType;
	private JPanel panel;
	private JPanel searchPanel;
	private JTextField valueTxt;
	private JButton search;
	private int selectedRow;
	private DefaultTableModel model;

	/**
	 * Create the frame.
	 */
	public Search_GUI(String query, String searchType) {

		// build the window
		super("Search Results");
		setBounds(100, 100, 750, 361);
		this.setVisible(true);
		this.query = query;
		this.searchType = searchType;
		this.setLocationRelativeTo(null);
		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());
		// Object to start the searching
		driver = new Search_Driver(query, searchType);
		this.setResizable(false);
		initSearchPanel();
		buildtable();
		initButtonPanel();

		if (driver.getResults().size() == 0) {
			String message = String.format("No results");
			JOptionPane.showMessageDialog(null, message, "No records found", 2);
		}

		// disconnect from db
		driver.closeConn();
	}

	public void initButtonPanel() {

		JButton calendarButton = new JButton("Calendar");
		calendarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add Pressed");
				new AddJob(query, searchType);
				
				return;
			}
		});

		view = new JButton("View a Job");
		view.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (driver.getResults().size() != 0) {
						new ViewJob(driver.getResults().get(table.getSelectedRow()), query, query);
					}
				} catch (Exception table) {
					JOptionPane.showMessageDialog(null, "Please select a value from the table.");
				}

				return;
			}
		});

		/*
		 * This code code below handles removing a job
		 */
		remove = new JButton("Remove a Job");
		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					if (driver.getResults().size() != 0) {
						String jobId = driver.getResults().get(table.getSelectedRow()).getWork_Id();
						int reply = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to delete this record? This cannot be undone.", "Remove record",
								JOptionPane.YES_NO_OPTION);
						if (reply == JOptionPane.YES_OPTION) {
							new Removing_Driver(jobId);
							model.removeRow(selectedRow);
							String numResults = String.format("Numer of results: %s", model.getRowCount());
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
		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (driver.getResults().size() != 0) {
						new EditJob(driver.getResults().get(table.getSelectedRow()), query, searchType);
					}
					dispose();
				} catch (Exception table) {
					JOptionPane.showMessageDialog(null, "Please select a value from the table.");
				}

			}
		});

		getContentPane().setLayout(null);
		String numResults = String.format("Numer of results: %s", driver.getResults().size());
		resultsLbl = new JLabel(numResults);

		btnPanel = new JPanel();
		btnPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnPanel.setBounds(10, 280, 714, 41);
		btnPanel.add(calendarButton);
		btnPanel.add(add);
		btnPanel.add(view);
		btnPanel.add(edit);
		btnPanel.add(remove);
		btnPanel.add(resultsLbl);
		getContentPane().add(btnPanel);
	}

	public void buildtable() {
		Object[][] data = new Object[driver.getResults().size()][columnNames.length];
		int j = 0;

		// Builds the table's data
		for (int i = 0; i < driver.getResults().size(); i++) {
			data[i][j] = driver.getResults().get(i).getJob_name();
			data[i][j + 1] = driver.getResults().get(i).getFname();
			data[i][j + 2] = driver.getResults().get(i).getLname();
			data[i][j + 3] = driver.getResults().get(i).getStreet();
			data[i][j + 4] = driver.getResults().get(i).getCity();
			data[i][j + 5] = driver.getResults().get(i).getState();
			data[i][j + 6] = driver.getResults().get(i).getZip_code();
			data[i][j + 7] = driver.getResults().get(i).getPhone_number();
			data[i][j + 8] = driver.getResults().get(i).getDate();
		}

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Result table",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 63, 714, 206);
		getContentPane().add(panel);

		model = new DefaultTableModel(data, columnNames);

		// builds the table
		table = new JTable(model);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(driver.getResults().get(table.getSelectedRow()).toString());

			}
		});
		panel.setLayout(null);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selectedRow = table.getSelectedRow();
				System.out.println(selectedRow);
			}
		});

		// Here I attach the table to a JScrollPane
		contentPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.setBounds(10, 21, 694, 174);
		panel.add(contentPane);

	}

	public void initSearchPanel() {
		searchPanel = new JPanel();
		searchPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		searchPanel.setBounds(380, 11, 344, 46);
		getContentPane().add(searchPanel);
		searchPanel.setLayout(null);

		valueTxt = new JTextField();
		valueTxt.setBounds(133, 11, 102, 25);
		searchPanel.add(valueTxt);
		valueTxt.setColumns(10);

		JComboBox<String> searchFilters = new JComboBox<String>();
		searchFilters.addItem("First Name");
		searchFilters.addItem("Last Name");
		searchFilters.addItem("Date");
		searchFilters.addItem("Address");
		searchFilters.addItem("Show All");
		searchFilters.setBounds(10, 13, 113, 20);
		searchPanel.add(searchFilters);

		search = new JButton("Search");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				remove(panel);
				driver = new Search_Driver(valueTxt.getText(), searchFilters.getSelectedItem().toString());
				panel.removeAll();
				repaint();
				revalidate();
				buildtable();
				String numResults = String.format("Numer of results: %s", driver.getResults().size());
				resultsLbl.setText(numResults);
			}
		});
		search.setBounds(245, 12, 89, 23);
		searchPanel.add(search);
	}

}
