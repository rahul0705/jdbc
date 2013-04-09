package gui;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

@SuppressWarnings("serial")
public class loginFrame extends JFrame {
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frame = new loginFrame();
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
	public loginFrame(final Connection conn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 230);
		contentPane = new JPanel();
		setContentPane(contentPane);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 150, 150, 30};
		gridBagLayout.rowHeights = new int[]{43, 43, 43, 43};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);

		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblUserId = new GridBagConstraints();
		gbc_lblUserId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUserId.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserId.gridx = 1;
		gbc_lblUserId.gridy = 0;
		add(lblUserId, gbc_lblUserId);

		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.gridx = 2;
		gbc_txtUsername.gridy = 0;
		add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 1;
		add(lblPassword, gbc_lblPassword);

		pwdPassword = new JPasswordField();
		pwdPassword.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 5);
		gbc_pwdPassword.gridx = 2;
		gbc_pwdPassword.gridy = 1;
		add(pwdPassword, gbc_pwdPassword);

		JRadioButton rdbtnFaculty = new JRadioButton("Faculty");
		rdbtnFaculty.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnFaculty);
		GridBagConstraints gbc_rdbtnFaculty = new GridBagConstraints();
		gbc_rdbtnFaculty.fill = GridBagConstraints.BOTH;
		gbc_rdbtnFaculty.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFaculty.gridx = 1;
		gbc_rdbtnFaculty.gridy = 2;
		add(rdbtnFaculty, gbc_rdbtnFaculty);

		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnStudent);
		GridBagConstraints gbc_rdbtnStudent = new GridBagConstraints();
		gbc_rdbtnStudent.fill = GridBagConstraints.BOTH;
		gbc_rdbtnStudent.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnStudent.gridx = 2;
		gbc_rdbtnStudent.gridy = 2;
		add(rdbtnStudent, gbc_rdbtnStudent);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement stat = conn.createStatement();
					String username = txtUsername.getText();
					char[] password = pwdPassword.getPassword();
					System.out.println(username);
					System.out.println(password);
					String table = "";
					for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
						AbstractButton button = buttons.nextElement();
						if (button.isSelected()) {
							if(button.getText().equals("Student"))
								table = "STUDENTS";
							else if(button.getText().equals("Faculty"))
								table = "FACULTY";
						}
					}
					String query = "select PASSWORD, NAME" +
							"from " + table +
							"where USERNAME='" + username + "'";
					ResultSet rs = stat.executeQuery(query);
					while (rs.next()) {
						String checkPass = rs.getString("PASSWORD");
						String name = rs.getString("NAME");
						if(checkPass.equals(password)){
							dispose();
							toolsFrame frame = new toolsFrame(conn, name);
							frame.setVisible(true);
						}
					}
					JOptionPane.showMessageDialog(loginFrame.this, "Username/Password incorrect");
					txtUsername.setText("");
					pwdPassword.setText("");
					buttonGroup.clearSelection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					while(e != null){
						e.printStackTrace();
						e = e.getNextException();
					}
				}
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 3;
		add(btnOk, gbc_btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 3;
		add(btnCancel, gbc_btnCancel);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtUsername, pwdPassword, rdbtnFaculty, rdbtnStudent, btnOk, btnCancel}));
	}

}
