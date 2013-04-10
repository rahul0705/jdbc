package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class createClassFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtClassid;
	private JTextField txtClassname;
	private JTextField txtSemester;
	private JTextField txtYear;
	private JTextField txtMeetsat;
	private JTextField txtRoom;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createClassFram frame = new createClassFram();
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
	public createClassFrame(final Connection conn, final int fid) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblClassId = new JLabel("Class ID");
		GridBagConstraints gbc_lblClassId = new GridBagConstraints();
		gbc_lblClassId.insets = new Insets(0, 0, 5, 5);
		gbc_lblClassId.gridx = 0;
		gbc_lblClassId.gridy = 0;
		contentPane.add(lblClassId, gbc_lblClassId);
		
		txtClassid = new JTextField();
		GridBagConstraints gbc_txtClassid = new GridBagConstraints();
		gbc_txtClassid.insets = new Insets(0, 0, 5, 0);
		gbc_txtClassid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClassid.gridx = 1;
		gbc_txtClassid.gridy = 0;
		contentPane.add(txtClassid, gbc_txtClassid);
		txtClassid.setColumns(10);
		
		JLabel lblClassName = new JLabel("Class Name");
		GridBagConstraints gbc_lblClassName = new GridBagConstraints();
		gbc_lblClassName.insets = new Insets(0, 0, 5, 5);
		gbc_lblClassName.gridx = 0;
		gbc_lblClassName.gridy = 1;
		contentPane.add(lblClassName, gbc_lblClassName);
		
		txtClassname = new JTextField();
		GridBagConstraints gbc_txtClassname = new GridBagConstraints();
		gbc_txtClassname.insets = new Insets(0, 0, 5, 0);
		gbc_txtClassname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClassname.gridx = 1;
		gbc_txtClassname.gridy = 1;
		contentPane.add(txtClassname, gbc_txtClassname);
		txtClassname.setColumns(10);
		
		JLabel lblSemester = new JLabel("Semester");
		GridBagConstraints gbc_lblSemester = new GridBagConstraints();
		gbc_lblSemester.insets = new Insets(0, 0, 5, 5);
		gbc_lblSemester.gridx = 0;
		gbc_lblSemester.gridy = 2;
		contentPane.add(lblSemester, gbc_lblSemester);
		
		txtSemester = new JTextField();
		GridBagConstraints gbc_txtSemester = new GridBagConstraints();
		gbc_txtSemester.insets = new Insets(0, 0, 5, 0);
		gbc_txtSemester.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSemester.gridx = 1;
		gbc_txtSemester.gridy = 2;
		contentPane.add(txtSemester, gbc_txtSemester);
		txtSemester.setColumns(10);
		
		JLabel lblYear = new JLabel("Year");
		GridBagConstraints gbc_lblYear = new GridBagConstraints();
		gbc_lblYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblYear.gridx = 0;
		gbc_lblYear.gridy = 3;
		contentPane.add(lblYear, gbc_lblYear);
		
		txtYear = new JTextField();
		GridBagConstraints gbc_txtYear = new GridBagConstraints();
		gbc_txtYear.insets = new Insets(0, 0, 5, 0);
		gbc_txtYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYear.gridx = 1;
		gbc_txtYear.gridy = 3;
		contentPane.add(txtYear, gbc_txtYear);
		txtYear.setColumns(10);
		
		JLabel lblMeetsAt = new JLabel("Meets At");
		GridBagConstraints gbc_lblMeetsAt = new GridBagConstraints();
		gbc_lblMeetsAt.insets = new Insets(0, 0, 5, 5);
		gbc_lblMeetsAt.gridx = 0;
		gbc_lblMeetsAt.gridy = 4;
		contentPane.add(lblMeetsAt, gbc_lblMeetsAt);
		
		txtMeetsat = new JTextField();
		GridBagConstraints gbc_txtMeetsat = new GridBagConstraints();
		gbc_txtMeetsat.insets = new Insets(0, 0, 5, 0);
		gbc_txtMeetsat.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMeetsat.gridx = 1;
		gbc_txtMeetsat.gridy = 4;
		contentPane.add(txtMeetsat, gbc_txtMeetsat);
		txtMeetsat.setColumns(10);
		
		JLabel lblRoom = new JLabel("Room");
		GridBagConstraints gbc_lblRoom = new GridBagConstraints();
		gbc_lblRoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoom.gridx = 0;
		gbc_lblRoom.gridy = 5;
		contentPane.add(lblRoom, gbc_lblRoom);
		
		txtRoom = new JTextField();
		GridBagConstraints gbc_txtRoom = new GridBagConstraints();
		gbc_txtRoom.insets = new Insets(0, 0, 5, 0);
		gbc_txtRoom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRoom.gridx = 1;
		gbc_txtRoom.gridy = 5;
		contentPane.add(txtRoom, gbc_txtRoom);
		txtRoom.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				String cid = txtClassid.getText();
				String name = "'" + txtClassname.getText() + "'";
				String semester = "'" + txtSemester.getText() + "'";
				String year = txtYear.getText();
				String meetsAt = "to_date('" + txtMeetsat.getText() + "','HH:MI')";
				String room = "'" + txtRoom.getText() + "'";
				String query = "INSERT INTO CLASS VALUES (" + cid + ", "+ name + ", "+ semester + ", "+ year + ", "+ meetsAt + ", "+ room + ", " + fid + ")";
				System.out.println(query);
				try{
					Statement stat = conn.createStatement();
					stat.execute(query);
				}catch(SQLException e){
					JOptionPane.showMessageDialog(createClassFrame.this, "Failure");
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(createClassFrame.this, "Success");
				dispose();
			}
		});
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.gridx = 1;
		gbc_btnCreate.gridy = 6;
		contentPane.add(btnCreate, gbc_btnCreate);
	}

}
