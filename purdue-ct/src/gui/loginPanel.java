package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class loginPanel extends JPanel {
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public loginPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		txtUsername = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, txtUsername, -65, SpringLayout.EAST, this);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, pwdPassword, 0, SpringLayout.WEST, txtUsername);
		springLayout.putConstraint(SpringLayout.EAST, pwdPassword, -65, SpringLayout.EAST, this);
		add(pwdPassword);
		
		JLabel lblUserId = new JLabel("User ID:");
		springLayout.putConstraint(SpringLayout.WEST, lblUserId, 60, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, txtUsername, -6, SpringLayout.NORTH, lblUserId);
		springLayout.putConstraint(SpringLayout.NORTH, lblUserId, 33, SpringLayout.NORTH, this);
		add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password:");
		springLayout.putConstraint(SpringLayout.NORTH, pwdPassword, -6, SpringLayout.NORTH, lblPassword);
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 23, SpringLayout.SOUTH, lblUserId);
		springLayout.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, lblUserId);
		add(lblPassword);
		
		JRadioButton rdbtnFaculty = new JRadioButton("Faculty");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnFaculty, 22, SpringLayout.SOUTH, lblPassword);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnFaculty, 77, SpringLayout.WEST, this);
		buttonGroup.add(rdbtnFaculty);
		add(rdbtnFaculty);
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnStudent, 0, SpringLayout.NORTH, rdbtnFaculty);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnStudent, 20, SpringLayout.EAST, rdbtnFaculty);
		buttonGroup.add(rdbtnStudent);
		add(rdbtnStudent);
		
		JButton btnOk = new JButton("OK");
		springLayout.putConstraint(SpringLayout.NORTH, btnOk, 23, SpringLayout.SOUTH, rdbtnFaculty);
		springLayout.putConstraint(SpringLayout.WEST, btnOk, 60, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnOk, -198, SpringLayout.EAST, this);
		add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, btnOk);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 22, SpringLayout.EAST, btnOk);
		springLayout.putConstraint(SpringLayout.EAST, btnCancel, -76, SpringLayout.EAST, this);
		add(btnCancel);

	}
}
