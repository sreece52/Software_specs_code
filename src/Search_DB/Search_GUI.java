package Search_DB;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Adding_jobs.AddJob;
import Adding_jobs.EditJob;

/**
 * @author Shawn Reece Date: 2/9/2016
 */
@SuppressWarnings("serial")
public class Search_GUI extends JFrame {
	private JTable table;
	private JPanel btnPanel;
	private JButton add;
	private JButton edit;
	private JButton remove;
	private static Search_Driver driver;
	private JScrollPane contentPane;
	String[] columnNames = { "work_id", "Job Name", "First Name", "Last Name", "Street", "City", "State", "Zip Code",
			"Phone Number", "Materials", "Date", "Hours", "Start Time", "EndTime", "Notes", "Pdfs", "Images" };

	private String query;
	private String searchType;

	/**
	 * Create the frame.
	 */
	public Search_GUI(String query, String searchType) {

		// build the window
		super("Search Results");
		setBounds(100, 100, 750, 290);
		this.setVisible(true);
		this.query = query;
		this.searchType = searchType;

		// Object to start the searching
		driver = new Search_Driver(query, searchType);

		System.out.println(driver.getResults().size());
		// Creates the 2D object array of the same size of the table
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
			data[i][j + 9] = driver.getResults().get(i).getMaterials();
			data[i][j + 10] = driver.getResults().get(i).getDate();
			data[i][j + 11] = driver.getResults().get(i).getHours();
			data[i][j + 12] = driver.getResults().get(i).getStartTime();
			data[i][j + 13] = driver.getResults().get(i).getEndTime();
			data[i][j + 14] = driver.getResults().get(i).getNotes();
			data[i][j + 15] = driver.getResults().get(i).getPDFs();
			data[i][j + 16] = driver.getResults().get(i).getImages();
		}

		// builds the table
		table = new JTable(data, columnNames);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(table.getSelectedRow());
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
				dispose();
			}
		});

		/*
		 * This code code below handles removing a job
		 */
		remove = new JButton("Remove a Job");
		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String jobId = (String) table.getValueAt(table.getSelectedRow(), 0);
				new Removing_Driver(jobId);
				dispose();
				new Search_GUI(query, searchType);
			}
		});

		/*
		 * This code below handles editing jobs
		 */
		edit = new JButton("Edit Job");
		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String work_id = (String) table.getValueAt(table.getSelectedRow(), 0);
				String job_name = (String) table.getValueAt(table.getSelectedRow(), 1);
				String fname = (String) table.getValueAt(table.getSelectedRow(), 2);
				String lname = (String) table.getValueAt(table.getSelectedRow(), 3);
				String street = (String) table.getValueAt(table.getSelectedRow(), 4);
				String city = (String) table.getValueAt(table.getSelectedRow(), 5);
				String state = (String) table.getValueAt(table.getSelectedRow(), 6);
				String zipCode = (String) table.getValueAt(table.getSelectedRow(), 7);
				String phone_num = (String) table.getValueAt(table.getSelectedRow(), 8);
				String materials = (String) table.getValueAt(table.getSelectedRow(), 9);
				String date = (String) table.getValueAt(table.getSelectedRow(), 10);
				String hours = (String) table.getValueAt(table.getSelectedRow(), 11);
				String startTime = (String) table.getValueAt(table.getSelectedRow(), 12);
				String endTime = (String) table.getValueAt(table.getSelectedRow(), 13);
				String notes = (String) table.getValueAt(table.getSelectedRow(), 14);
				String pdfs = (String) table.getValueAt(table.getSelectedRow(), 15);
				String images = (String) table.getValueAt(table.getSelectedRow(), 16);

				Jobs editedJob = new Jobs(work_id, job_name, fname, lname, street, city, state, zipCode, phone_num,
						materials, date, hours, startTime, endTime, notes, pdfs, images);
				new EditJob(editedJob, query, searchType);
				dispose();
			}
		});

		// Here I attach the table to a JScrollPane
		contentPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		this.add(contentPane);

		btnPanel = new JPanel();
		btnPanel.add(add);
		btnPanel.add(edit);
		btnPanel.add(remove);

		this.add(btnPanel, BorderLayout.SOUTH);

		// disconnect from db
		driver.closeConn();
	}
}
