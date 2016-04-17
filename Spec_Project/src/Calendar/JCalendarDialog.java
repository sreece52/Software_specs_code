package Calendar;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;

import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Search_DB.Search_GUI;

public class JCalendarDialog extends JFrame {

	public static final int OK_PRESSED = 1;
	public static final int CANCEL_PRESSED = 2;

	private int returnCode;
	private int startOfWeek;
	private Calendar calendar;
	private Calendar selectedDate;
	private JCalendar jcalendar;
	private JDialog dialog;
	private JFrame frame;
	private Locale locale;
	private String dateString;
	private String dialogTitle;
	private String simpleDateFormat;

	public JCalendarDialog() {
		this.locale = Locale.getDefault();
		this.calendar = Calendar.getInstance();
		this.dialogTitle = "Date Selector";
		this.simpleDateFormat = "YYYY-MM-DD";
		this.startOfWeek = Calendar.SUNDAY;
		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());
	}

	public void setStartOfWeek(int startOfWeek) {
		this.startOfWeek = startOfWeek;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = (Calendar) calendar.clone();
	}

	public void setDialogTitle(String dialogTitle) {
		this.dialogTitle = dialogTitle;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void setSimpleDateFormat(String simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}

	public void createDialog() {
		dialog = new JDialog(frame);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setTitle(dialogTitle);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		jcalendar = new JCalendar();
		jcalendar.setCalendar(calendar);
		jcalendar.setDateFormat(simpleDateFormat);
		jcalendar.setLocale(locale);
		jcalendar.setStartOfWeek(startOfWeek);
		jcalendar.createPanel();

		mainPanel.add(jcalendar.getPanel(), BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new OKButtonActionListener());
		buttonPanel.add(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new CancelButtonActionListener());
		buttonPanel.add(cancelButton);

		okButton.setPreferredSize(cancelButton.getPreferredSize());

		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		dialog.add(mainPanel);

		dialog.setSize(new Dimension(700, 550));
		dialog.setLocationRelativeTo(frame);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.setVisible(true);
	}

	public int getReturnCode() {
		return returnCode;
	}

	public String getFormattedSelectedDate() {
		return dateString;
	}

	public Calendar getSelectedDate() {
		return selectedDate;
	}

	private class CancelButtonActionListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			returnCode = CANCEL_PRESSED;
			dialog.dispose();
		}
	}

	private class OKButtonActionListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			/* Build query date */
			String s = String.format("%d-%02d-%02d", 
					jcalendar.getSelectedDate().get(Calendar.YEAR),
					jcalendar.getSelectedDate().get(Calendar.MONTH) + 1,
					jcalendar.getSelectedDate().get(Calendar.DAY_OF_MONTH));

			System.out.println(s.trim());

			/* Create results window, and move it to front */
			Search_GUI gui = new Search_GUI(s, "Date");
			gui.toFront();
			gui.requestFocus();
			gui.setAlwaysOnTop(true); // prevent mainscreen from being on top
			gui.addFocusListener(new FocusListener() {

				public void focusGained(FocusEvent arg0) {
					// do nothing
				}

				public void focusLost(FocusEvent arg0) {
					/* Allow window to be sent to back when focus lost */
					gui.setAlwaysOnTop(false);

				}
			});

			returnCode = OK_PRESSED;
			dialog.dispose();
		}
	}
}