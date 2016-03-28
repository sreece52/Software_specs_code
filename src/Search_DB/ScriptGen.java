package Search_DB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ScriptGen {

	public static void main(String[] args) {
		String[] fnames = { "Hiram", "Collette", "Hugo", "Kandis", "Lenita", "Santo", "Eura", "Twanna", "Hye", "Irena",
				"Blake", "Cara", "Loida", "Aida", "Paola", "Leana", "Emil", "Thomas", "Tyson", "Antony" };
		String[] lnames = { "Santibanez", "Bulmer", "Halliday", "Piro", "Glazer", "Horstman", "Officer", "Chittum",
				"Brockington", "Cordes", "Slee", "Hernandes", "Lucious", "Gans", "Fears", "Danford", "Earnest",
				"Bartley", "Langlinais", "Raulston" };
		String[] streets = { "Lexington Court", "Overlook Circle", "East Street", "Cherry Street", "Linden Avenue",
				"1st Avenue", "Arch Street", "Madison Street", "Court Street", "Pennsylvania Avenue", "Queen Street",
				"Route 4", "Crescent Street", "8th Avenue", "Lincoln Avenue", "Glenwood Drive", "Orchard Avenue",
				"Green Street", "Cedar Street", "Roberts Road" };
		String[] cities = { "Raleigh", "Las Vegas", "Indianapolis", "Philadelphia", "Newark", "Scottsdale", "Riverside",
				"Denver", "Las Vegas", "Baton Rouge", "Buffalo", "Birmingham", "Seattle", "Los Angeles", "Raleigh",
				"Las Vegas", "Indianapolis", "Philadelphia", "Newark", "Scottsdale" };
		String[] states = { "Washington", "Kentucky", "South Dakota", "Oregon", "South Carolina", "New York",
				"Delaware", "Idaho", "New Hampshire", "Alaska", "Illinois", "Vermont", "Colorado", "Hawaii", "Iowa",
				"Ohio", "Washington", "Kentucky", "South Dakota", "Oregon" };
		String[] zip_codes = { "27804", "29406", "30680", "34990", "08854", "30721", "22030", "39503", "07047", "78023",
				"28655", "11414", "11530", "89523", "60619", "27804", "29406", "30680", "34990", "08854" };
		String[] dates = { "01/02/2015", "02/01/2015", "03/21/2016", "07/04/2015", "12/14/2015", "02/07/2016",
				"07/04/2015", "10/8/2015", "6/19/2015", "10/10/2015", "9/11/2015", "4/20/2016", "4/13/2016", "1/4/2016",
				"5/15/2015", "4/28/2016", "2/17/2015", "1/18/2016", "6/9/2016", "2/20/2015" };
		String[] phone_numbers = { "337-789-6542", "773-269-1252", "785-698-1660", "446-228-9444", "973-323-0259",
				"152-253-1815", "151-493-0446", "724-848-7580", "176-12-5588", "918-563-2370", "475-189-1432",
				"281-992-0305", "705-484-9450", "375-562-6777", "378-567-9707", "689-220-2070", "818-199-6670",
				"193-595-8057", "967-346-3841", "937-901-6001" };
		String entry = "insert into jobs (job_id,fname,lname,street,city,state,"
				+ "zip_code,date,phone_number) values ('%d','%s','%s','%s','%s'," + "'%s','%s','%s');";

		System.out.println("Beginning script generation.");
		try (FileWriter output = new FileWriter(new File("createtable.sql"))) {
			for (int i = 0; i < 1000; i++) {
				int random = (int) Math.floor(Math.random() * 20);
				System.out.println(random);
				String insertStatement = String.format(
						"insert into jobs(fname,lname,street,city,state,zip_code,"
								+ "phone_num,date) "
								+ "values('%s','%s','%s','%s','%s','%s','%s','%s');",
						fnames[random], lnames[random], streets[random], cities[random], states[random],
						zip_codes[random], phone_numbers[random], dates[random]);
				output.write(insertStatement);
				output.write(System.lineSeparator());

			}
		} catch (IOException e) {
			System.out.println("Error: Failed to open file output");
			e.printStackTrace();
		}
		System.out.println("Script generation complete. Exiting.");
	}

}
