package gui;

import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

public class loginPanel extends JPanel {
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public loginPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 150, 150, 30};
		gridBagLayout.rowHeights = new int[]{10, 43, 43, 43, 43};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblUserId = new GridBagConstraints();
		gbc_lblUserId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUserId.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserId.gridx = 1;
		gbc_lblUserId.gridy = 1;
		add(lblUserId, gbc_lblUserId);
		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.gridx = 2;
		gbc_txtUsername.gridy = 1;
		add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 2;
		add(lblPassword, gbc_lblPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 5);
		gbc_pwdPassword.gridx = 2;
		gbc_pwdPassword.gridy = 2;
		add(pwdPassword, gbc_pwdPassword);
		
		JRadioButton rdbtnFaculty = new JRadioButton("Faculty");
		rdbtnFaculty.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnFaculty);
		GridBagConstraints gbc_rdbtnFaculty = new GridBagConstraints();
		gbc_rdbtnFaculty.fill = GridBagConstraints.BOTH;
		gbc_rdbtnFaculty.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFaculty.gridx = 1;
		gbc_rdbtnFaculty.gridy = 3;
		add(rdbtnFaculty, gbc_rdbtnFaculty);
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnStudent);
		GridBagConstraints gbc_rdbtnStudent = new GridBagConstraints();
		gbc_rdbtnStudent.fill = GridBagConstraints.BOTH;
		gbc_rdbtnStudent.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnStudent.gridx = 2;
		gbc_rdbtnStudent.gridy = 3;
		add(rdbtnStudent, gbc_rdbtnStudent);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				char[] password = pwdPassword.getPassword();
				System.out.println(username);
				System.out.println(password);
				for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
		            AbstractButton button = buttons.nextElement();
		            if (button.isSelected()) {
		                System.out.println(button.getText());
		            }
		        }
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 4;
		add(btnOk, gbc_btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 4;
		add(btnCancel, gbc_btnCancel);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtUsername, pwdPassword, rdbtnFaculty, rdbtnStudent, btnOk, btnCancel}));

	}
}
