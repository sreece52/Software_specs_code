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
public class AddNotes extends JFrame {
	static AddNotes frame;
	int row;
	private JTextArea txtrNmn;
	private JScrollPane scrollPane;
	private String notes;

	/**
	 * Create the frame.
	 * 
	 * @param fromAddJob
	 */
	public AddNotes() {

		ImageIcon img = new ImageIcon("Handyman Scheduler Logo 1.png");
		this.setIconImage(img.getImage());

		setTitle("Add Notes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 515, 619);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JButton btnSaveAddNotes = new JButton("Save Notes");
		btnSaveAddNotes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new java.util.Date())
						+ ": AddNotes -> clicked save.");
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
		txtrNmn.setText("");
		txtrNmn.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrNmn.setLineWrap(true);
		txtrNmn.setWrapStyleWord(true);

		scrollPane.setViewportView(txtrNmn);
		Color green = new Color(150, 255, 150);
		btnSaveAddNotes.setBackground(green);
		btnSaveAddNotes.setForeground(Color.black);
		btnSaveAddNotes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnSaveAddNotes = new GridBagConstraints();
		gbc_btnSaveAddNotes.gridx = 0;
		gbc_btnSaveAddNotes.gridy = 1;
		getContentPane().add(btnSaveAddNotes, gbc_btnSaveAddNotes);

	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
