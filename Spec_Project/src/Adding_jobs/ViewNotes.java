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
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewNotes extends JFrame implements MouseListener{
	private JTextField textField;
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
		btnCloseNotes.addMouseListener(this);
		
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
		btnCloseNotes.setForeground(Color.white);
		btnCloseNotes.setBackground(Color.black);
		btnCloseNotes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnSaveViewNotes = new GridBagConstraints();
		gbc_btnSaveViewNotes.gridx = 0;
		gbc_btnSaveViewNotes.gridy = 1;
		getContentPane().add(btnCloseNotes, gbc_btnSaveViewNotes);

		
		
	}
	/**
	 * Launch the application.
	 */



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("You pressed SaveNotes");
		
		dispose();
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
	
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
