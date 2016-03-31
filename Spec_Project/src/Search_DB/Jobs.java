package Search_DB;

/**
 * This class creates the job objects to be used in Search_Driver.class Handles
 * assigning, setting, getting, and printing the job object
 * 
 * @author Shawn Reece DATE: 2/9/2016
 * 
 * @Update 3/26/2016 added new variables to constructor and getters-and-setters
 *         for them. Work id can't not be changed any more. No longer needed to
 *         make a job DB auto increments the PK - Shawn
 *
 */
public class Jobs {
	private String work_Id;
	private String job_name;
	private String fname;
	private String lname;
	private String street;
	private String city;
	private String state;
	private String zip_code;
	private String phone_number;
	private String materials;
	private String date;
	private String hours;
	private String startTime;
	private boolean startTimeAm;
	private String endTime;
	private boolean endTimeAm;
	private String notes;
	private String PDFs;
	private String images;
	private int testInt;

	/**
	 * This is the constructor that assigns all the fields values all the
	 * parameters are type string
	 * 
	 * @param work_id
	 *            String
	 * @param job_name
	 *            String
	 * @param fname
	 *            String
	 * @param lname
	 *            String
	 * @param street
	 *            String
	 * @param city
	 *            String
	 * @param state
	 *            String
	 * @param zip_code
	 *            String
	 * @param phone_num
	 *            String
	 * @param materials
	 *            String
	 * @param date
	 *            String
	 * @param hours
	 *            String
	 * @param startTime
	 *            String
	 * @param endTime
	 *            String
	 * @param notes
	 *            String
	 * @param PDFs
	 *            String
	 * @param images
	 *            String
	 */
	public Jobs(String work_id, String job_name, String fname, String lname, String street, String city, String state,
			String zip_code, String phone_num, String materials, String date, String hours, String startTime,
			String endTime,String notes, String PDFs, String images,boolean startTimeAm,boolean endTimeAm) {
		this.work_Id = work_id;
		this.job_name = job_name;
		this.fname = fname;
		this.lname = lname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
		this.phone_number = phone_num;
		this.materials = materials;
		this.date = date;
		this.hours = hours;
		this.startTime = startTime;
		this.startTimeAm = startTimeAm;
		this.endTime = endTime;
		this.endTimeAm = endTimeAm; 
		this.notes = notes;
		this.PDFs = PDFs;
		this.images = images;
		
	}

	public boolean isStartTimeAm() {
		return startTimeAm;
	}

	public void setStartTimeAm(boolean startTimeAm) {
		this.startTimeAm = startTimeAm;
	}

	public boolean isEndTimeAm() {
		return endTimeAm;
	}

	public void setEndTimeAm(boolean endTimeAm) {
		this.endTimeAm = endTimeAm;
	}

	/**
	 * This method overrides the toString method in the JDK and formats the job
	 * result
	 * 
	 * @return The job in a string
	 */
	public String toString() {
		return work_Id + " " + fname + " " + lname + " " + date + " " + street + " " + city + " " + state + " "
				+ phone_number + " " + zip_code;
	}

	/*
	 * The getter and setter methods for all the fields
	 */
	public String getWork_Id() {
		return work_Id;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPDFs() {
		return PDFs;
	}

	public void setPDFs(String pDFs) {
		PDFs = pDFs;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
}
