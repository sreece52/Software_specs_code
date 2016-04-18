package Search_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

/**
 * This class is used to insert new jobs
 * 
 * @author Shawn Reece
 * @since 2/28/2016
 */
public class Editing_Driver {
	private Connection conn;
	private String dataBaseURL;
	private String dbUserName;
	private String dbPassword;
	private Statement statement;
	private Jobs job;


	/**
	 * Default constructor is here to handle accidental Instantiation of this
	 * class
	 */
	public Editing_Driver() {

	}

	/**
	 * This is the constructor used to assign variables and start editing the
	 * database
	 * 
	 * @param q
	 *            is the value enter to be searched for, of type string
	 * @param s
	 *            is the column we want to search through, of type string
	 * @throws SQLException 
	 */
	public Editing_Driver(Jobs job) throws SQLException {
		this.job = job;

		/*
		 * the next 3 lines hold the credentials needed to access the db
		 */
		dbUserName = "admin";
		dbPassword = "password";
		dataBaseURL = "jdbc:h2:" + System.getProperty("user.dir") + "/newDB";

		/*
		 * The following code handle connecting to the db using the above
		 * credentials
		 */
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("Class not found..");
			e1.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(dataBaseURL, dbUserName, dbPassword);
			System.out.println("Connected to data base!");
			System.out.println(dataBaseURL);
		} catch (SQLException e) {
			System.out.println("SQL Exception..");
			e.printStackTrace();
		}
		edit();
	}

	/**
	 * This method will create the sql statement to edit a jobi in the db
	 * @throws SQLException 
	 */
	public void edit() throws SQLException {
		try {
			statement = conn.createStatement();

			String insertStatement = String.format(
					"update jobs set job_name = '%s', fname = '%s', lname = '%s',street = '%s', city = '%s', state = '%s',zip_code = '%s'"
							+ ",phone_num = '%s', materials = '%s', date = '%s', hours = '%s', starttime = '%s',endtime = '%s', notes = '%s', pdfs = '%s', images = '%s', "
							+ "startam = '%s',endam = '%s' " + "where work_id = '%s';",
					job.getJob_name(), job.getFname(), job.getLname(), job.getStreet(), job.getCity(), job.getState(),
					job.getZip_code(), job.getPhone_number(), job.getMaterials(), job.getDate(), job.getHours(),
					job.getStartTime(), job.getEndTime(), job.getNotes(),
					job.getPDFs(), job.getImages(), job.isStartTimeAm(), job.isEndTimeAm(),job.getWork_Id());
			
			/*Log query*/
			System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
					.format(new java.util.Date()) + 
					": Editing_Driver -> Sent query " + insertStatement);
			
			statement.execute(insertStatement);
			JOptionPane.showMessageDialog(null, "The database has been successfully updated", "Edit", 1);
		} catch (NullPointerException npe) {
			System.out.println("Error: Connection to database was not established!");
		}
	}

	/**
	 * This method is used to close the connection to the database
	 */
	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sqlException");
			e.printStackTrace();
		}
	}
}
