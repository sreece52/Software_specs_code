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
import java.text.SimpleDateFormat;

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

public class EditNotes extends JFrame {
	private JTextField textField;
	static EditNotes frame;
	int row;
	private JTextArea txtrNmn;
	private JScrollPane scrollPane;
	private String notes;

	/**
	 * Create the frame.
	 * @param string 
	 * @param fromAddJob 
	 */
	public EditNotes(String string) {
		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());
		
		setTitle("Edit Notes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		setBounds(100, 100, 515, 619);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnSaveEditNotes = new JButton("Save Notes");
		btnSaveEditNotes.addMouseListener(new MouseAdapter() {


			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss")
                        .format(new java.util.Date()) + 
                        ": EditNotes -> Clicked save");
				
				notes = txtrNmn.getText();
				
				dispose();		
			}

			
		});
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		txtrNmn = new JTextArea();
		txtrNmn.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrNmn.setText(string);

		scrollPane.setViewportView(txtrNmn);
		btnSaveEditNotes.setForeground(Color.white);
		btnSaveEditNotes.setBackground(new Color(0, 102, 206));
		btnSaveEditNotes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnSaveEditNotes = new GridBagConstraints();
		gbc_btnSaveEditNotes.gridx = 0;
		gbc_btnSaveEditNotes.gridy = 1;
		getContentPane().add(btnSaveEditNotes, gbc_btnSaveEditNotes);

		
	}
	/**
	 * Launch the application.
	 */
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
