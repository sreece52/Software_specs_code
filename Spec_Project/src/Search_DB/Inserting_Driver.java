package Search_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * This class is used to insert new jobs
 * 
 * @author Shawn Reece
 * @since 2/28/2016
 */
public class Inserting_Driver {
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
	public Inserting_Driver() {

	}

	/**
	 * This is the constructor used to assign variables and start the database
	 * insertion
	 * 
	 * @param q
	 *            is the value enter to be searched for, of type string
	 * @param s
	 *            is the column we want to search through, of type string
	 * @throws SQLException 
	 */
	public Inserting_Driver(Jobs job) throws SQLException {
		this.job = job;
		/*
		 * the next 3 lines hold the credentials needed to access the db
		 */
		dbUserName = "admin";
		dbPassword = "password";
		dataBaseURL = "jdbc:h2:" + System.getProperty("user.dir") + "/newDB";
		System.out.println(dataBaseURL);
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
		insert();
	}

	/**
	 * This method will create the sql statement to insert the new job into the
	 * db
	 * @throws SQLException 
	 */
	public void insert() throws SQLException {
		try {
			statement = conn.createStatement();
			System.out.println(job.getImages());
			String insertStatement = String.format(
					"insert into jobs (job_name,fname,lname,street,city,state,zip_code,"
							+ "phone_num,materials,date,hours,starttime,endtime,notes,pdfs,images,startam,endam) "
							+ "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');",
					job.getJob_name(), job.getFname(), job.getLname(), job.getStreet(), job.getCity(), job.getState(),
					job.getZip_code(), job.getPhone_number(), job.getMaterials(), job.getDate(), job.getHours(),
					job.getStartTime(), job.getEndTime(), job.getNotes(), job.getPDFs(), job.getImages(),
					job.isStartTimeAm(), job.isEndTimeAm());
			statement.execute(insertStatement);
			JOptionPane.showMessageDialog(null, "The record has been added to the database", "Inserting", 1);

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
