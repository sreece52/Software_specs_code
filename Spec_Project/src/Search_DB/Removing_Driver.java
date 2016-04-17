package Search_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * The class handles removing data from the database
 * 
 * @author Shawn Reece
 * @since 2/28/12
 *
 */
public class Removing_Driver {

	private Connection conn;
	private String dataBaseURL;
	private String dbUserName;
	private String dbPassword;
	private Statement statement;
	private String work_id;

	/**
	 * Default constructor is here to handle accidental Instantiation of this
	 * class
	 */
	public Removing_Driver() {

	}

	/**
	 * This is the constructor used to assign variables and start the removal of
	 * data
	 * 
	 * @param q
	 *            is the value enter to be searched for, of type string
	 * @param s
	 *            is the column we want to search through, of type string
	 */
	public Removing_Driver(String work_id) {
		this.work_id = work_id;
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

		remove();
		
	}

	public void remove() {
		try {
			statement = conn.createStatement();
			String removingStatement = String.format("delete from jobs where work_id = '%s';", work_id);
			statement.execute(removingStatement);
			JOptionPane.showMessageDialog(null, "The entry has been removed from the data base", "Removed", 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
