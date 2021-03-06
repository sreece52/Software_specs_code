package Search_DB;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import Adding_jobs.AddJob;
import Adding_jobs.EditJob;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;

@SuppressWarnings("serial")
/**
 * This class is designed to import jobs information into the screen
 * 
 * @author Shawn Reece Date: 4/15/2016
 *
 */
public class ImportJob extends JFrame {
	private JTextField value;
	private JButton search;
	private JComboBox<String> querytype;
	private JPanel panel;
	private Search_Driver driver;
	String[] columnNames = { "Job Name", "First Name", "Last Name", "Street", "City", "State", "Zip Code",
			"Phone Number", "Date" };
	private JTable table;
	private JScrollPane contentPane;
	private JPanel searchResultsPanel;
	private JPanel bottom_panel;
	private JButton cancel;
	private JButton submit;
	private EditJob edit;
	private AddJob add;
	private boolean isEdit = true;

	/**
	 * Constructor for the class for an existing job
	 * 
	 * @param edit
	 *            a job we wish to edit is passed here
	 */
	public ImportJob(EditJob edit) {
		this.edit = edit;
		getContentPane().setLayout(null);
		initComponents();
		this.setTitle("Import job information");
		this.setSize(800, 546);
		this.setVisible(true);
		ImageIcon img = new ImageIcon(ImportJob.class.getResource("Handyman Scheduler Logo 1.png"));
		this.setIconImage(img.getImage());
	}

	/**
	 * Constructor for the class for a new job
	 * 
	 * @param add
	 *            the new job we wish to create
	 */
	public ImportJob(AddJob add) {
		this.add = add;
		isEdit = false;
		getContentPane().setLayout(null);
		initComponents();
		this.setTitle("Import job information");
		this.setSize(800, 546);
		this.setVisible(true);
		ImageIcon img = new ImageIcon(ImportJob.class.getResource("Handyman Scheduler Logo 1.png"));
		this.setIconImage(img.getImage());
	}

	/**
	 * this method Puts the frame together
	 */
	private void initComponents() {
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setBounds(10, 11, 764, 41);
		getContentPane().add(ButtonPanel);
		ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		querytype = new JComboBox<String>();
		querytype.addItem("First Name");
		querytype.addItem("Last Name");
		querytype.addItem("Date");
		querytype.addItem("Address");
		querytype.addItem("Show All");
		ButtonPanel.add(querytype);

		value = new JTextField();
		ButtonPanel.add(value);
		value.setColumns(10);

		search = new JButton("Search");
		Color green = new Color(150, 255, 150);
		search.setBackground(green);
		ButtonPanel.add(search);
		search.addActionListener(new ActionListener() {

			/**
			 * Call the search method
			 */
			public void actionPerformed(ActionEvent e) {
				/* Log action */
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": ImportJob -> Clicked search");
				search();
			}
		});

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Choose a result to import", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 65, 764, 385);
		getContentPane().add(panel);
		panel.setLayout(null);

		searchResultsPanel = new JPanel();
		searchResultsPanel.setBounds(10, 21, 744, 353);
		panel.add(searchResultsPanel);
		searchResultsPanel.setLayout(new BorderLayout());

		bottom_panel = new JPanel();
		bottom_panel.setBounds(10, 461, 764, 35);
		getContentPane().add(bottom_panel);
		bottom_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		cancel = new JButton("Cancel");
		Color red = new Color(255, 110, 110);
		cancel.setBackground(red);
		cancel.addActionListener(new ActionListener() {

			/**
			 * if the user hits cancel the frame will be disposed.
			 */
			public void actionPerformed(ActionEvent e) {
				/* Log action */
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": ImportJob -> Clicked cancel");
				dispose();
			}
		});

		submit = new JButton("submit");
		submit.setBackground(green);
		submit.addActionListener(new ActionListener() {

			/**
			 * Submits the selected job back to add or edit job frame
			 */
			public void actionPerformed(ActionEvent e) {
				/* Log action */
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": ImportJob -> Clicked submit");
				if (isEdit) {
					edit.setJob(driver.getResults().get(table.getSelectedRow()));
					dispose();
				} else {
					add.setJob(driver.getResults().get(table.getSelectedRow()));
					dispose();
				}

			}
		});

		bottom_panel.add(submit);
		bottom_panel.add(cancel);
	}

	/**
	 * This method will query the database based off the given values
	 */
	private void search() {
		// removes the previous table if any
		searchResultsPanel.removeAll();
		// gets the selected search filter
		String query = querytype.getSelectedItem().toString().toUpperCase().trim();
		System.out.println(query);

		// Search the database
		driver = new Search_Driver(value.getText(), query);

		// If there are no results tell the user
		if (driver.getResults().size() == 0) {
			JOptionPane.showMessageDialog(null, "No results!", "No Results", 2);
		}

		System.out.println(driver.getResults().size());
		// array to hold the tables data
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

		// builds the table
		table = new JTable(data, columnNames);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(driver.getResults().get(table.getSelectedRow()).toString());
			}
		});
		contentPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		searchResultsPanel.add(contentPane, BorderLayout.CENTER);
		repaint();
		revalidate();
		driver.closeConn();
	}
}
