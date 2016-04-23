package Adding_jobs;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class ViewNotes extends JFrame{
	static ViewNotes frame;
	int row;
	static String noteText;
	static String string;
	
	

	/**
	 * Create the frame.
	 * @param string 
	 */
	public ViewNotes(String string) {
		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());
		
		setTitle("View Notes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		setBounds(100, 100, 515, 619);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnCloseNotes = new JButton("Close Notes");
		
		btnCloseNotes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("You pressed SaveNotes");
				
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
		                .format(new java.util.Date()) + 
		                ": ViewNotes -> Clicked save button to save notes/save notes");
				
				dispose();
				
			
		}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		JTextArea txtrNmn = new JTextArea();
		txtrNmn.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrNmn.setText(string);
		noteText = txtrNmn.getText();
		System.out.println(noteText);
		txtrNmn.setEditable(false);
		scrollPane.setViewportView(txtrNmn);
		btnCloseNotes.setForeground(Color.black);
		Color red = new Color(255, 110, 110);
		btnCloseNotes.setBackground(red);
		btnCloseNotes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnSaveViewNotes = new GridBagConstraints();
		gbc_btnSaveViewNotes.gridx = 0;
		gbc_btnSaveViewNotes.gridy = 1;
		getContentPane().add(btnCloseNotes, gbc_btnSaveViewNotes);

		
		
	}

}
