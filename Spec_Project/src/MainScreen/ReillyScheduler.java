/**
 * Main class for R-Quad Heavy Industry's Handyman Scheduler.
 * Begins program logic by opening main screen.
 */

package MainScreen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReillyScheduler {
	public static FileWriter logger;
	
	public static void main(String[] args){
		File logDir = new File("Logs");
		if(!logDir.exists()){
			logDir.mkdir();
		}
		
		try {
			logger = new FileWriter(new File(logDir + "\\" +
					new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date())) + " Log");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainScreen frame = new MainScreen();
		frame.setVisible(true);
	}
}
