/**
 * Main class for R-Quad Heavy Industry's Handyman Scheduler.
 * Begins program logic by opening main screen.
 */

package MainScreen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

public class ReillyScheduler {
	public static void main(String[] args){
		File logDir = new File("Logs");
		if(!logDir.exists()){
			logDir.mkdir();
		}
		PrintStream out;
		try {
			out = new PrintStream(new File(logDir + "\\" + 
			new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
			.format(new java.util.Date())));
			System.setOut(out);
			System.setErr(out);
		} catch (FileNotFoundException e) {
			System.out.println("Failed to change stdout");
			e.printStackTrace();
		}
		MainScreen frame = new MainScreen();
		frame.setVisible(true);
	}
}
