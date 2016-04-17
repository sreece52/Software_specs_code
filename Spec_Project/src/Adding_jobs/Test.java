package Adding_jobs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;

public class Test extends JFrame{

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	static Test frame;
	int row;

	/**
	 * Create the frame.
	 */
	public Test() {
		
		setTitle("Date");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setBounds(100, 100, 515, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnAddJob = new JButton("Add Job");
	//	btnAddJob.addMouseListener(this); //MouseListener
		btnAddJob.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAddJob.setForeground(Color.BLACK);
		contentPane.add(btnAddJob, BorderLayout.NORTH);
	
		//loop through each ClientName and ClientTime;
		String ClientTime[] = new String[25];
		String ClientName[] = new String[25];
		int CTN = 5; 
		
		DefaultTableModel dtm = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};;
		table = new JTable();
		
		String[] columnName = {"Scheduled Appointments"};
		String[] data = 
			    {" " + ClientTime[CTN] + " Name: " + ClientName[CTN]}
				;
		
		dtm.setColumnIdentifiers(columnName);
		table.setModel(dtm);
		
		for (int count = 1; count <= CTN; count++) {
	       dtm.addRow(data);
			
		
		}
				
		table.setRowHeight(35);
		//hunter green thick boarder
		table.setBorder(new LineBorder(new Color(0, 80, 0), 5));
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(table, BorderLayout.CENTER);	
	
		
		table.addMouseListener(new MouseAdapter(){
			
			
			 public void mouseClicked(MouseEvent d) {
				
				 
				    if (d.getClickCount() == 2 ) {
				    	
				    	JTable target = (JTable)d.getSource();
				    	row = table.getSelectedRow();				      
				      
				    	System.out.println(row);

					//	ViewJob viewjob = new ViewJob();
						//viewjob.setVisible(true);
						dispose();
				    }
				  }
	});
		
	}
}
