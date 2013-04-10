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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class assignToClassFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudentid;
	private JTextField txtClassid;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					assignToClassFrame frame = new assignToClassFrame();
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
	public assignToClassFrame(final Connection conn, final int fid) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 296, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblStudentId = new JLabel("Student ID");
		GridBagConstraints gbc_lblStudentId = new GridBagConstraints();
		gbc_lblStudentId.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudentId.gridx = 0;
		gbc_lblStudentId.gridy = 0;
		contentPane.add(lblStudentId, gbc_lblStudentId);
		
		txtStudentid = new JTextField();
		GridBagConstraints gbc_txtStudentid = new GridBagConstraints();
		gbc_txtStudentid.insets = new Insets(0, 0, 5, 0);
		gbc_txtStudentid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStudentid.gridx = 1;
		gbc_txtStudentid.gridy = 0;
		contentPane.add(txtStudentid, gbc_txtStudentid);
		txtStudentid.setColumns(10);
		
		JLabel lblClassId = new JLabel("Class ID");
		GridBagConstraints gbc_lblClassId = new GridBagConstraints();
		gbc_lblClassId.insets = new Insets(0, 0, 5, 5);
		gbc_lblClassId.gridx = 0;
		gbc_lblClassId.gridy = 1;
		contentPane.add(lblClassId, gbc_lblClassId);
		
		txtClassid = new JTextField();
		GridBagConstraints gbc_txtClassid = new GridBagConstraints();
		gbc_txtClassid.insets = new Insets(0, 0, 5, 0);
		gbc_txtClassid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClassid.gridx = 1;
		gbc_txtClassid.gridy = 1;
		contentPane.add(txtClassid, gbc_txtClassid);
		txtClassid.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = txtClassid.getText() + ", " + txtStudentid.getText();
				try {
					Statement stat = conn.createStatement();
					String query = "select FID" +
							" from CLASS" +
							" where CID=" + txtClassid.getText();
					ResultSet rs = stat.executeQuery(query);
					boolean canEdit = false;
					while(rs.next()){
						if(fid == rs.getInt("FID"))
							canEdit = true;
					}
					if(canEdit){
						stat.execute("INSERT INTO Enrolled VALUES (" + str + ")");
						JOptionPane.showMessageDialog(assignToClassFrame.this, "Success");
					}
					else
						JOptionPane.showMessageDialog(assignToClassFrame.this, "You are not the instructor for this class");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				dispose();
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 2;
		contentPane.add(btnAdd, gbc_btnAdd);
	}

}
