package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modifyEvaluationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEvaluationid;
	private JTextField txtClassid;
	private JTextField txtType;
	private JTextField txtWeight;
	private JTextField txtDeadline;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyEvaluationFrame frame = new ModifyEvaluationFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Modify the frame.
	 */
	public modifyEvaluationFrame(final Connection conn, final int fid) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEvaluationId = new JLabel("Evaluation ID");
		GridBagConstraints gbc_lblEvaluationId = new GridBagConstraints();
		gbc_lblEvaluationId.insets = new Insets(0, 0, 5, 5);
		gbc_lblEvaluationId.gridx = 0;
		gbc_lblEvaluationId.gridy = 0;
		contentPane.add(lblEvaluationId, gbc_lblEvaluationId);
		
		txtEvaluationid = new JTextField();
		GridBagConstraints gbc_txtEvaluationid = new GridBagConstraints();
		gbc_txtEvaluationid.insets = new Insets(0, 0, 5, 0);
		gbc_txtEvaluationid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEvaluationid.gridx = 1;
		gbc_txtEvaluationid.gridy = 0;
		contentPane.add(txtEvaluationid, gbc_txtEvaluationid);
		txtEvaluationid.setColumns(10);
		
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
		
		JLabel lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 2;
		contentPane.add(lblType, gbc_lblType);
		
		txtType = new JTextField();
		GridBagConstraints gbc_txtType = new GridBagConstraints();
		gbc_txtType.insets = new Insets(0, 0, 5, 0);
		gbc_txtType.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtType.gridx = 1;
		gbc_txtType.gridy = 2;
		contentPane.add(txtType, gbc_txtType);
		txtType.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight");
		GridBagConstraints gbc_lblWeight = new GridBagConstraints();
		gbc_lblWeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeight.gridx = 0;
		gbc_lblWeight.gridy = 3;
		contentPane.add(lblWeight, gbc_lblWeight);
		
		txtWeight = new JTextField();
		GridBagConstraints gbc_txtWeight = new GridBagConstraints();
		gbc_txtWeight.insets = new Insets(0, 0, 5, 0);
		gbc_txtWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWeight.gridx = 1;
		gbc_txtWeight.gridy = 3;
		contentPane.add(txtWeight, gbc_txtWeight);
		txtWeight.setColumns(10);
		
		JLabel lblDeadline = new JLabel("Deadline");
		GridBagConstraints gbc_lblDeadline = new GridBagConstraints();
		gbc_lblDeadline.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeadline.gridx = 0;
		gbc_lblDeadline.gridy = 4;
		contentPane.add(lblDeadline, gbc_lblDeadline);
		
		txtDeadline = new JTextField();
		GridBagConstraints gbc_txtDeadline = new GridBagConstraints();
		gbc_txtDeadline.insets = new Insets(0, 0, 5, 0);
		gbc_txtDeadline.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDeadline.gridx = 1;
		gbc_txtDeadline.gridy = 4;
		contentPane.add(txtDeadline, gbc_txtDeadline);
		txtDeadline.setColumns(10);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				String eid = txtEvaluationid.getText();
				String cid = txtClassid.getText();
				String type = "'" + txtType.getText() + "'";
				String weight = txtWeight.getText();
				String deadline = "to_date('" + txtDeadline.getText() + "','MM/DD/YYYY')";
				String query = "UPDATE EVALUATION SET CID=" + cid + ", TYPE=" + type + ", WEIGHT=" + weight + ", DEADLINE=" + deadline + "where EID=" + eid;
				try{
					Statement stat = conn.createStatement();
					stat.executeUpdate(query);
				}catch(SQLException e){
					JOptionPane.showMessageDialog(modifyEvaluationFrame.this, "Failure");
					e.printStackTrace();
				}
				dispose();
			}
		});
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.gridx = 1;
		gbc_btnModify.gridy = 5;
		contentPane.add(btnModify, gbc_btnModify);
	}

}
