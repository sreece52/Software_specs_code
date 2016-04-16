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
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

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

	/**
	 * Create the frame.
	 */
	public Search_GUI(String query, String searchType) {

		// build the window
		super("Search Results");
		setBounds(100, 100, 750, 298);
		this.setVisible(true);
		this.query = query;
		this.searchType = searchType;
		this.setLocationRelativeTo(null);
		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());
		// Object to start the searching
		driver = new Search_Driver(query, searchType);

		System.out.println(driver.getResults().size());
		// Creates the 2D object array of the same size of the table
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

		view = new JButton("View a Job");
		view.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (driver.getResults().size() != 0) {
					new ViewJob(driver.getResults().get(table.getSelectedRow()), query, searchType);
				}
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
				if (driver.getResults().size() != 0) {
					String jobId = driver.getResults().get(table.getSelectedRow()).getWork_Id();
					new Removing_Driver(jobId);
					dispose();
					new Search_GUI(query, searchType);
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
				if (driver.getResults().size() != 0) {
					new EditJob(driver.getResults().get(table.getSelectedRow()), query, searchType);
				}
				dispose();
			}
		});
		getContentPane().setLayout(null);
		String numResults = String.format("Numer of results: %s", driver.getResults().size());
		resultsLbl = new JLabel(numResults);

		btnPanel = new JPanel();
		btnPanel.setBounds(10, 215, 714, 33);
		btnPanel.add(add);
		btnPanel.add(view);
		btnPanel.add(edit);
		btnPanel.add(remove);
		btnPanel.add(resultsLbl);

		getContentPane().add(btnPanel);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Result table",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 714, 196);
		getContentPane().add(panel);

		// builds the table
		table = new JTable(data, columnNames);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(driver.getResults().get(table.getSelectedRow()).toString());

			}
		});
		panel.setLayout(null);

		// Here I attach the table to a JScrollPane
		contentPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.setBounds(10, 25, 694, 160);
		panel.add(contentPane);

		if (driver.getResults().size() == 0) {
			String message = String.format("No results");
			JOptionPane.showMessageDialog(null, message, "No records found", 2);
		}

		// disconnect from db
		driver.closeConn();
	}
}
