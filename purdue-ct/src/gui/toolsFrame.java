package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class toolsFrame extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					toolsFrame frame = new toolsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public toolsFrame(Connection conn, String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		setContentPane(contentPane);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Welcome " + name);
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.gridx = 0;
		gbc_lblWelcome.gridy = 0;
		add(lblWelcome, gbc_lblWelcome);
		
		JButton btnMyMessages = new JButton("My Messages");
		GridBagConstraints gbc_btnMyMessages = new GridBagConstraints();
		gbc_btnMyMessages.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMyMessages.insets = new Insets(0, 0, 5, 0);
		gbc_btnMyMessages.gridx = 0;
		gbc_btnMyMessages.gridy = 1;
		add(btnMyMessages, gbc_btnMyMessages);
		
		JButton btnCalendarOfEvaluations = new JButton("Calendar of Evaluations");
		GridBagConstraints gbc_btnCalendarOfEvaluations = new GridBagConstraints();
		gbc_btnCalendarOfEvaluations.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCalendarOfEvaluations.insets = new Insets(0, 0, 5, 0);
		gbc_btnCalendarOfEvaluations.gridx = 0;
		gbc_btnCalendarOfEvaluations.gridy = 2;
		add(btnCalendarOfEvaluations, gbc_btnCalendarOfEvaluations);
		
		JButton btnMyClasses = new JButton("My Classes");
		GridBagConstraints gbc_btnMyClasses = new GridBagConstraints();
		gbc_btnMyClasses.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMyClasses.insets = new Insets(0, 0, 5, 0);
		gbc_btnMyClasses.gridx = 0;
		gbc_btnMyClasses.gridy = 3;
		add(btnMyClasses, gbc_btnMyClasses);
		
		JButton btnMyGrades = new JButton("My Grades");
		GridBagConstraints gbc_btnMyGrades = new GridBagConstraints();
		gbc_btnMyGrades.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMyGrades.gridx = 0;
		gbc_btnMyGrades.gridy = 4;
		add(btnMyGrades, gbc_btnMyGrades);
	}

}
