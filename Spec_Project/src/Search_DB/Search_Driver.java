package Search_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This class handles the search queries the results of the search is stored in
 * an arrayList of type JOBS
 * 
 * @author Shawn Reece DATE: 2/9/2016
 *
 */
public class Search_Driver {
	private Connection conn;
	private String dataBaseURL;
	private String dbUserName;
	private String dbPassword;
	private Statement statement;
	private ArrayList<Jobs> searchResults = new ArrayList<Jobs>();
	private String query;
	private String searchType;
	private ResultSet results;
	private Jobs job;

	/**
	 * Default constructor is here to handle accidental Instantiation of this
	 * class
	 */
	public Search_Driver() {

	}

	/**
	 * This is the constructor used to assign variables and start the database
	 * search
	 * 
	 * @param q
	 *            is the value enter to be searched for, of type string
	 * @param s
	 *            is the column we want to search through, of type string
	 */
	public Search_Driver(String q, String s) {
		query = q;
		searchType = s;

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
		sendQuery(); // after we are connected the db the search begins
	}

	/**
	 * This method functions as relay to move the search to the appropriate SQL
	 * query This is used more for housing keeping. Didn't want all the code in
	 * one method DO NOT CALL THIS METHOD FROM OUTSIDE OF THE CLASS (Matt or
	 * Julia). Its private so that shouldn't happen but you never know with
	 * matt...
	 */
	private void sendQuery() {
		switch (searchType.toUpperCase()) {
		case "FIRST NAME":
			searchFName(query);
			break;

		case "CITY":
			searchCity(query);
			break;

		case "LAST NAME":
			searchLName(query);
			break;

		case "ID":
			searchID(query);
			break;

		case "ADDRESS":
			searchStreet(query);
			break;

		case "ZIPCODE":
			searchZipCode(query);
			break;

		case "STATE":
			searchState(query);
			break;

		case "PHONENUMBER":
			searchPhoneNum(query);
			break;

		case "DATE":
			searchDate(query);
			break;
		
		//Internal use only 
		case "WORKID":
			searchWorkID(query);
			break;
			
		//Internal use only 	
		case "CURRENTID":
			searchCurrentId();
			break;

		default:
			System.out.println("Here");
			showAll();
			break;
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
	/**
	 * this method is for internal use only. User will not be able to search this for the program's screens
	 * @param query2
	 */
	private void searchCurrentId() {
		try {
			statement = conn.createStatement();
			String searchName = "select * from jobs where work_id = (select max(work_id) from jobs);";
			results = statement.executeQuery(searchName);
			while (results.next()) {
				job = new Jobs(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getString(7), results.getString(8),
						results.getString(9), results.getString(10), results.getString(11), results.getString(12),
						results.getString(13), results.getString(14), results.getString(15), results.getString(16),
						results.getString(17), results.getBoolean(18), results.getBoolean(19));

				searchResults.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("Error: Connection to database was not established!");
		}
	}

	/**
	 * this method is for internal use only. User will not be able to search this for the program's screens
	 * @param query
	 */
	private void searchWorkID(String query) {
		try {
			statement = conn.createStatement();
			String searchName = String.format("select * from jobs where work_id = '%s' ;",query);
			results = statement.executeQuery(searchName);
			while (results.next()) {
				job = new Jobs(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getString(7), results.getString(8),
						results.getString(9), results.getString(10), results.getString(11), results.getString(12),
						results.getString(13), results.getString(14), results.getString(15), results.getString(16),
						results.getString(17), results.getBoolean(18), results.getBoolean(19));

				searchResults.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("Error: Connection to database was not established!");
		}
	}
	
	/**
	 * Shows all data in the table
	 */
	public void showAll() {
		try {
			statement = conn.createStatement();
			String searchName = String.format("select * from jobs order by lname;");
			results = statement.executeQuery(searchName);
			while (results.next()) {
				job = new Jobs(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getString(7), results.getString(8),
						results.getString(9), results.getString(10), results.getString(11), results.getString(12),
						results.getString(13), results.getString(14), results.getString(15), results.getString(16),
						results.getString(17), results.getBoolean(18), results.getBoolean(19));

				searchResults.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("Error: Connection to database was not established!");
		}
	}

	/**
	 * This method sends an SQL query to search a particular for an first name
	 * (FNAME)
	 * 
	 * @param query
	 *            the string to be searched in the data base
	 */
	public void searchFName(String query) {
		try {
			statement = conn.createStatement();
			String searchName = String.format("select * from jobs where upper(fname) = '%s' order by lname;",
					query.toUpperCase());
			results = statement.executeQuery(searchName);
			while (results.next()) {
				job = new Jobs(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getString(7), results.getString(8),
						results.getString(9), results.getString(10), results.getString(11), results.getString(12),
						results.getString(13), results.getString(14), results.getString(15), results.getString(16),
						results.getString(17), results.getBoolean(18), results.getBoolean(19));

				searchResults.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method sends an SQL query to search a particular for an last name
	 * (LNAME)
	 * 
	 * @param query
	 *            the string to be searched in the data base
	 */
	public void searchLName(String query) {
		try {
			statement = conn.createStatement();
			String searchName = String.format("select * from jobs where upper(lname) = '%s' order by lname;",
					query.toUpperCase());
			results = statement.executeQuery(searchName);
			while (results.next()) {
				job = new Jobs(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getString(7), results.getString(8),
						results.getString(9), results.getString(10), results.getString(11), results.getString(12),
						results.getString(13), results.getString(14), results.getString(15), results.getString(16),
						results.getString(17), results.getBoolean(18), results.getBoolean(19));

				searchResults.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method sends an SQL query to search a particular for an ID (ID)
	 * 
	 * @param query
	 *            the string to be searched in the data base
	 */
	public void searchID(String query) {
		try {
			statement = conn.createStatement();
			String searchName = String.format("select * from jobs where id = '%s' order by lname;", query);
			results = statement.executeQuery(searchName);
			while (results.next()) {
				job = new Jobs(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getString(7), results.getString(8),
						results.getString(9), results.getString(10), results.getString(11), results.getString(12),
						results.getString(13), results.getString(14), results.getString(15), results.getString(16),
						results.getString(17), results.getBoolean(18), results.getBoolean(19));
				searchResults.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method sends an SQL query to search a particular for a date (DATE)
	 * 
	 * @param query
	 *            the string to be searched in the data base
	 */
	public void searchDate(String query) {
		try {
			statement = conn.createStatement();
			String searchName = String.format("select * from jobs where upper(date) = '%s' order by lname;",
					query.toUpperCase());
			results = statement.executeQuery(searchName);
			while (results.next()) {
				job = new Jobs(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getString(7), results.getString(8),
						results.getString(9), results.getString(10), results.getString(11), results.getString(12),
						results.getString(13), results.getString(14), results.getString(15), results.getString(16),
						results.getString(17), results.getBoolean(18), results.getBoolean(19));

				searchResults.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method sends an SQL query to search a particular for an address
	 * (ADRESS)
	 * 
	 * @param query
	 *            the string to be searched in the data base
	 */
	public void searchStreet(String query) {
		try {
			statement = conn.createStatement();
			String searchName = String.format("select * from jobs where upper(street) = '%s' order by lname;",
					query.toUpperCase());
			results = statement.executeQuery(searchName);
			while (results.next()) {
				job = new Jobs(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getString(7), results.getString(8),
						results.getString(9), results.getString(10), results.getString(11), results.getString(12),
						results.getString(13), results.getString(14), results.getString(15), results.getString(16),
						results.getString(17), results.getBoolean(18), results.getBoolean(19));

				searchResults.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method sends an SQL query to search a particular for a zip_code
	 * (zip_code)
	 * 
	 * @param query
	 *            the string to be searched in the data base
	 */
	public void searchZipCode(String query) {
		try {
			statement = conn.createStatement();
			String searchName = String.format("select * from jobs where zip_code = '%s' order by lname;",
					query.toUpperCase());
			results = statement.executeQuery(searchName);
			while (results.next()) {
				job = new Jobs(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getString(7), results.getString(8),
						results.getString(9), results.getString(10), results.getString(11), results.getString(12),
						results.getString(13), results.getString(14), results.getString(15), results.getString(16),
						results.getString(17), results.getBoolean(18), results.getBoolean(19));

				searchResults.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method sends an SQL query to search a particular for a phone number
	 * (PHONE_NUMBER)
	 * 
	 * @param query
	 *            the string to be searched in the data base
	 */
	public void searchPhoneNum(String query) {
		try {
			statement = conn.createStatement();
			String searchName = String.format("select * from jobs where phone_number = '%s' order by lname;", query);
			results = statement.executeQuery(searchName);
			while (results.next()) {
				job = new Jobs(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getString(7), results.getString(8),
						results.getString(9), results.getString(10), results.getString(11), results.getString(12),
						results.getString(13), results.getString(14), results.getString(15), results.getString(16),
						results.getString(17), results.getBoolean(18), results.getBoolean(19));

				searchResults.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method sends an SQL query to search a particular for a city (CITY)
	 * 
	 * @param query
	 *            the string to be searched in the data base
	 */
	public void searchCity(String query) {
		try {
			statement = conn.createStatement();
			String searchName = String.format("select * from jobs where upper(city) = '%s' order by lname;",
					query.toUpperCase());
			results = statement.executeQuery(searchName);
			while (results.next()) {
				job = new Jobs(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getString(7), results.getString(8),
						results.getString(9), results.getString(10), results.getString(11), results.getString(12),
						results.getString(13), results.getString(14), results.getString(15), results.getString(16),
						results.getString(17), results.getBoolean(18), results.getBoolean(19));

				searchResults.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method sends an SQL query to search a particular for a state (STATE)
	 * 
	 * @param query
	 *            the string to be searched in the data base
	 */
	public void searchState(String query) {
		try {
			statement = conn.createStatement();
			String searchName = String.format("select * from jobs where upper(state) = '%s' order by lname;",
					query.toUpperCase());
			results = statement.executeQuery(searchName);
			while (results.next()) {
				job = new Jobs(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getString(7), results.getString(8),
						results.getString(9), results.getString(10), results.getString(11), results.getString(12),
						results.getString(13), results.getString(14), results.getString(15), results.getString(16),
						results.getString(17), results.getBoolean(18), results.getBoolean(19));

				searchResults.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method returns the job array to be used in other classes
	 * 
	 * @return The job arraylist will all the search results(if any)
	 */
	public ArrayList<Jobs> getResults() {
		return searchResults;
	}
}
