package MainScreen;

import java.awt.Color;

import com.thehowtotutorial.splashscreen.JSplash;

public class MySplash {

	public MySplash() {
		try {
			JSplash splash = new JSplash(MySplash.class.getResource("Handyman Scheduler Logo 1.png"), true, true, false,
					"V1", null, Color.darkGray, Color.BLUE);

			splash.splashOn(); // to display
			// call method

			splash.setProgress(20, "Loading"); // displays loading at 20%
			Thread.sleep(1000);
			splash.setProgress(50, "Configuring"); // displays loading at 40%
			Thread.sleep(1000);
			splash.setProgress(75, "Starting App");
			Thread.sleep(1000);
			splash.splashOff();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
