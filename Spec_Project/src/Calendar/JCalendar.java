package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Search_DB.Search_Driver;
 
/**
 * This class creates the panel that runs the calendar. 
 * 
 * @author Matthew Reilly DATE: 3/23/2016
 *
 * 
 */

public class JCalendar{
 
	/*Instance Variables*/
	
    private static final int DAYS_IN_WEEK = 7;
 
    private int startOfWeek;
 
    private Border blackLineBorder;
 
    private Calendar calendar;
    private Calendar selectedDate;
 
    private DayPanel[] dayPanel;
 
    private JLabel monthLabel;
 
    private JPanel panel;
 
 
    private Locale locale;
 
    private SimpleDateFormat dateFormat;
 
    private String dateString;
 /*Constructor for the JCalendar class */
    public JCalendar() {
        this.calendar = Calendar.getInstance();
        this.locale = Locale.getDefault();
        this.startOfWeek = Calendar.SUNDAY;
        this.dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        //gets the current day of the year and the time
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
 
        this.dateString = "";
        this.selectedDate = null;
    }
    //gets the start of the week
    public void setStartOfWeek(int startOfWeek) {
        this.startOfWeek = startOfWeek;
    }
    //sets the current calendar time
    public void setCalendar(Calendar calendar) {
        this.calendar = (Calendar) calendar.clone();
 
        this.calendar.set(Calendar.HOUR_OF_DAY, 0);
        this.calendar.set(Calendar.MINUTE, 0);
        this.calendar.set(Calendar.SECOND, 0);
        this.calendar.set(Calendar.MILLISECOND, 0);
    }
 
    //set the locale to english
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    public void setDateFormat(String simpleDateFormat) {
        this.dateFormat = new SimpleDateFormat(simpleDateFormat);
    }
    //method to create the calendar panel
    public void createPanel() {
        blackLineBorder = BorderFactory.createLineBorder(Color.BLACK);
        
        panel = new JPanel();
        panel.setBorder(blackLineBorder);
        panel.setLayout(new BorderLayout());
 
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
 
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(blackLineBorder);
 
        Font smallFont = buttonPanel.getFont().deriveFont(10.0F);
        //sets the year back one year
        JButton yearBackButton = new JButton("<<");
        Color lightpurple = new Color(255, 220, 255);
		yearBackButton.setBackground(lightpurple);
        yearBackButton.setFont(smallFont);
        yearBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                calendar.add(Calendar.YEAR, -1);
                updatePartControl();
                System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
                        .format(new java.util.Date()) + 
                        ": JCalendar -> User selected to go back a year");
            }
        });
        buttonPanel.add(yearBackButton);
        //sets the month back by one
        JButton monthBackButton = new JButton("<");
        Color purple = new Color(255, 200, 255);
		monthBackButton.setBackground(purple);
        monthBackButton.setFont(smallFont);
        monthBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                calendar.add(Calendar.MONTH, -1);
                updatePartControl();
                System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
                        .format(new java.util.Date()) + 
                        ": JCalendar -> User selected to go back a month");
            }
        });
        buttonPanel.add(monthBackButton);
        //sets the month forward by one month
        JButton monthForwardButton = new JButton(">");
		monthForwardButton.setBackground(purple);
        monthForwardButton.setFont(smallFont);
        monthForwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                calendar.add(Calendar.MONTH, 1);
                updatePartControl();
                System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
                        .format(new java.util.Date()) + 
                        ": JCalendar -> User selected to go forward a month");
            }
        });
        buttonPanel.add(monthForwardButton);
        //sets the year forward by one year
        JButton yearForwardButton = new JButton(">>");
		yearForwardButton.setBackground(lightpurple);
        yearForwardButton.setFont(smallFont);
        yearForwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                calendar.add(Calendar.YEAR, 1);
                updatePartControl();
                System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
                        .format(new java.util.Date()) + 
                        ": JCalendar -> User selected to go forward a year");
            }
        });
        buttonPanel.add(yearForwardButton);
 
        monthBackButton.setPreferredSize(yearBackButton.getPreferredSize());
        monthForwardButton.setPreferredSize(yearForwardButton.getPreferredSize());
 
        topPanel.add(buttonPanel, BorderLayout.NORTH);
 
        JPanel monthPanel = new JPanel();
        monthPanel.setBackground(Color.WHITE);
        monthPanel.setBorder(blackLineBorder);
 
        monthLabel = new JLabel(getDisplayMonthYear());
        monthPanel.add(monthLabel);
 
        topPanel.add(monthPanel, BorderLayout.SOUTH);
 
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(createDayGrid(), BorderLayout.CENTER);
        
        
    }
    //panel to have the day grid on
    private JPanel createDayGrid() {
        JPanel panel = new JPanel();
        panel.setBorder(blackLineBorder);
        panel.setLayout(new GridLayout(0, DAYS_IN_WEEK));
        //gets the days of the week in a string array
        String[] daysOfWeek = getDaysOfWeek();
        for (int i = 0; i < daysOfWeek.length; i++) {
            JPanel weekdayPanel = new JPanel();
            weekdayPanel.setBackground(Color.WHITE);//set the days into the panel with white background
            weekdayPanel.setBorder(blackLineBorder);
 
            String s = daysOfWeek[i].substring(0, 1);//gets first letter of the day
            JLabel weekdayLabel = new JLabel(s);
            weekdayPanel.add(weekdayLabel);
 
            panel.add(weekdayPanel);
        }
        //gets the days for panel
        JCalendarDay[] days = getDays();
        dayPanel = new DayPanel[days.length];
        for (int i = 0; i < days.length; i++) {
            dayPanel[i] = new DayPanel();
            dayPanel[i].setJCalendarDay(days[i]);
            dayPanel[i].createPartControl();
            panel.add(dayPanel[i]);
        }
 
        return panel;
    }
    //update when the month or year is changed
    private void updatePartControl() {
        monthLabel.setText(getDisplayMonthYear());
 
        JCalendarDay[] days = getDays();
        for (int i = 0; i < days.length; i++) {
            dayPanel[i].setJCalendarDay(days[i]);
            dayPanel[i].updatePartControl();
        }
    }
    //gets the days of the week to get the displayed name
    private String[] getDaysOfWeek() {
        String[] daysOfWeek = new String[DAYS_IN_WEEK];
        Calendar temp = (Calendar) calendar.clone();
 
        for (int i = 0; i < daysOfWeek.length; i++) {
            temp.set(Calendar.DAY_OF_WEEK, (i + startOfWeek) % DAYS_IN_WEEK);
            String s = temp.getDisplayName(Calendar.DAY_OF_WEEK,
                    Calendar.SHORT_FORMAT, locale);
            daysOfWeek[i] = s;
        }
 
        return daysOfWeek;
    }
    //method to set the current day background and the selected day background
    private JCalendarDay[] getDays() {
        JCalendarDay[] days = new JCalendarDay[DAYS_IN_WEEK * 6];
        Calendar today = Calendar.getInstance(locale);
        Calendar temp = (Calendar) calendar.clone();
        temp.set(Calendar.DAY_OF_MONTH, 1);
        getFirstDate(temp);
 
        int currentMonth = calendar.get(Calendar.MONTH);
 
        for (int i = 0; i < days.length; i++) {
            int month = temp.get(Calendar.MONTH);
            if (month == currentMonth) {
                Color color = Color.WHITE;
                if (isToday(temp, today)) {
                    color = Color.YELLOW;
                }
                if (isToday(temp, selectedDate)) {
                    color = Color.GREEN;
                }
                int day = temp.get(Calendar.DAY_OF_MONTH);
                days[i] = new JCalendarDay(day, color);
            } else {
                days[i] = new JCalendarDay(0, Color.WHITE);
            }
 
            temp.add(Calendar.DAY_OF_MONTH, 1);
        }
 
        return days;
    }
    //sets true or false based upon if a day is the current day
    private boolean isToday(Calendar c1, Calendar c2) {
        if ((c1 == null) || (c2 == null)) {
            return false;
        }
 
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
 
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
 
        return (day1 == day2) && (month1 == month2) && (year1 == year2);
    }
    //gets the first date of the week
    private void getFirstDate(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) % DAYS_IN_WEEK;
        int amount = 0;
        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            int j = (i + startOfWeek) % DAYS_IN_WEEK;
            if (j == dayOfWeek) {
                break;
            }
            amount--;
        }
        calendar.add(Calendar.DAY_OF_MONTH, amount);
    }
    //displays the current month being looked at
    private String getDisplayMonthYear() {
        int year = calendar.get(Calendar.YEAR);
        String s = calendar.getDisplayName(Calendar.MONTH,
                Calendar.LONG_FORMAT, locale);
        return s + " " + year;
    }
 
    public JPanel getPanel() {
        return panel;
    }
 

    public String getFormattedSelectedDate() {
        return dateString;
    }

    public Calendar getSelectedDate() {
        return selectedDate;
    }
    //class to listen to the mouse clicking on certain classes
    private class DayMouseListener extends MouseAdapter {
 
        @Override
        public void mousePressed(MouseEvent event) {
            DayPanel panel = (DayPanel) event.getSource();
            if (true) {
                JLabel label = panel.getDayLabel();
                String s = label.getText().trim();
 
                if (!s.equals("")) {
                    getSelectedDate(s);
                }
            }
            System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
                    .format(new java.util.Date()) + 
                    ": JCalendar -> User clicked his mouse");
        }
        //sets the selected day
        private void getSelectedDate(String s) {
            selectedDate = Calendar.getInstance();
            selectedDate.set(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH), Integer.valueOf(s), 0, 0, 0);
            dateString = dateFormat.format(selectedDate.getTime());
            updatePartControl();
        }
 
    }
    //panel with all the parts on it
    private class DayPanel extends JPanel {
 
		private static final long serialVersionUID = 1L;
		private JCalendarDay jcalendarDay;
        private JLabel dayLabel;
        private boolean hasJob = false;
 
        public void setJCalendarDay(JCalendarDay jcalendarDay) {
            this.jcalendarDay = jcalendarDay;
        }
 
        public void createPartControl() {
            addMouseListener(new DayMouseListener());
            setBackground(jcalendarDay.getColor());
            setBorder(blackLineBorder);
 
            dayLabel = new JLabel(getDay());
            dayLabel.setForeground(Color.BLUE);
            add(dayLabel);
            
            /*Call update to check each day for jobs*/
            updatePartControl();
        }
 
        public void updatePartControl() {
        	/*Check if there is a job for the day and set flag accordingly*/
        	hasJob = false; //reset flag for month changes
        	if(!getDay().equals(" ")){
	            String s = String.format("%d-%02d-%02d", 	//build date using
						calendar.get(Calendar.YEAR), 		//info for each day
						calendar.get(Calendar.MONTH)+1,
						Integer.parseInt(getDay()));
	            Search_Driver driver = new Search_Driver(s, "Date");
	            System.out.println(driver.getResults().size());
	            /*No results = empty results arraylist*/
	            if(!driver.getResults().isEmpty()){
	            	hasJob = true;
	            }
        	}
        	
            setBackground(jcalendarDay.getColor());
            dayLabel.setText(getDay());
            repaint();
        }
 
        private String getDay() {
            String s = " ";
            if (jcalendarDay.getDay() > 0) {
                s = Integer.toString(jcalendarDay.getDay());
            }
            return s;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            /*Draw marker on the days that have jobs*/
            if(hasJob){
			    g.fillOval(this.getWidth()/2-this.getWidth()/16, 
			    		this.getHeight()/2, this.getWidth()/8, this.getHeight()/5);
            }
            
        }
        public JLabel getDayLabel() {
            return dayLabel;
        }
 
    }
 
    private class JCalendarDay {
    	
        private final int day;
 
        private final Color color;
 
        public JCalendarDay(int day, Color color) {
            this.day = day;
            this.color = color;
        }
 
        public int getDay() {
            return day;
        }
 
        public Color getColor() {
            return color;
        }
 
    }
 
}