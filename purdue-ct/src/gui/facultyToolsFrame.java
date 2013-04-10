package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JSeparator;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("serial")
public class facultyToolsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					facultyToolsFrame frame = new facultyToolsFrame();
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
	public facultyToolsFrame(final Connection conn, String name, final int fid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 0;
		contentPane.add(separator, gbc_separator);
		
		JLabel lblWelcome = new JLabel("Welcome");
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.gridx = 0;
		gbc_lblWelcome.gridy = 1;
		contentPane.add(lblWelcome, gbc_lblWelcome);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 2;
		contentPane.add(separator_1, gbc_separator_1);
		
		JButton btnCreateClass = new JButton("Create Class");
		btnCreateClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createClassFrame frame = new createClassFrame(conn, fid);
				frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCreateClass = new GridBagConstraints();
		gbc_btnCreateClass.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateClass.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateClass.gridx = 0;
		gbc_btnCreateClass.gridy = 3;
		contentPane.add(btnCreateClass, gbc_btnCreateClass);
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.insets = new Insets(0, 0, 5, 0);
		gbc_separator_2.gridx = 0;
		gbc_separator_2.gridy = 4;
		contentPane.add(separator_2, gbc_separator_2);
		
		JButton btnModifyClass = new JButton("Modify Class");
		GridBagConstraints gbc_btnModifyClass = new GridBagConstraints();
		gbc_btnModifyClass.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifyClass.insets = new Insets(0, 0, 5, 0);
		gbc_btnModifyClass.gridx = 0;
		gbc_btnModifyClass.gridy = 5;
		contentPane.add(btnModifyClass, gbc_btnModifyClass);
		
		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.insets = new Insets(0, 0, 5, 0);
		gbc_separator_3.gridx = 0;
		gbc_separator_3.gridy = 6;
		contentPane.add(separator_3, gbc_separator_3);
		
		JButton btnAssignToClass = new JButton("Assign to Class");
		btnAssignToClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				assignToClassFrame frame = new assignToClassFrame(conn, fid);
				frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAssignToClass = new GridBagConstraints();
		gbc_btnAssignToClass.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAssignToClass.insets = new Insets(0, 0, 5, 0);
		gbc_btnAssignToClass.gridx = 0;
		gbc_btnAssignToClass.gridy = 7;
		contentPane.add(btnAssignToClass, gbc_btnAssignToClass);
		
		JSeparator separator_4 = new JSeparator();
		GridBagConstraints gbc_separator_4 = new GridBagConstraints();
		gbc_separator_4.insets = new Insets(0, 0, 5, 0);
		gbc_separator_4.gridx = 0;
		gbc_separator_4.gridy = 8;
		contentPane.add(separator_4, gbc_separator_4);
		
		JButton btnCreateEvaluation = new JButton("Create Evaluation");
		GridBagConstraints gbc_btnCreateEvaluation = new GridBagConstraints();
		gbc_btnCreateEvaluation.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateEvaluation.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateEvaluation.gridx = 0;
		gbc_btnCreateEvaluation.gridy = 9;
		contentPane.add(btnCreateEvaluation, gbc_btnCreateEvaluation);
		
		JSeparator separator_5 = new JSeparator();
		GridBagConstraints gbc_separator_5 = new GridBagConstraints();
		gbc_separator_5.insets = new Insets(0, 0, 5, 0);
		gbc_separator_5.gridx = 0;
		gbc_separator_5.gridy = 10;
		contentPane.add(separator_5, gbc_separator_5);
		
		JButton btnModifyEvaluation = new JButton("Modify Evaluation");
		GridBagConstraints gbc_btnModifyEvaluation = new GridBagConstraints();
		gbc_btnModifyEvaluation.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifyEvaluation.insets = new Insets(0, 0, 5, 0);
		gbc_btnModifyEvaluation.gridx = 0;
		gbc_btnModifyEvaluation.gridy = 11;
		contentPane.add(btnModifyEvaluation, gbc_btnModifyEvaluation);
		
		JSeparator separator_6 = new JSeparator();
		GridBagConstraints gbc_separator_6 = new GridBagConstraints();
		gbc_separator_6.insets = new Insets(0, 0, 5, 0);
		gbc_separator_6.gridx = 0;
		gbc_separator_6.gridy = 12;
		contentPane.add(separator_6, gbc_separator_6);
		
		JButton btnReportOfClass = new JButton("Report of Class");
		GridBagConstraints gbc_btnReportOfClass = new GridBagConstraints();
		gbc_btnReportOfClass.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReportOfClass.insets = new Insets(0, 0, 5, 0);
		gbc_btnReportOfClass.gridx = 0;
		gbc_btnReportOfClass.gridy = 13;
		contentPane.add(btnReportOfClass, gbc_btnReportOfClass);
		
		JSeparator separator_7 = new JSeparator();
		GridBagConstraints gbc_separator_7 = new GridBagConstraints();
		gbc_separator_7.insets = new Insets(0, 0, 5, 0);
		gbc_separator_7.gridx = 0;
		gbc_separator_7.gridy = 14;
		contentPane.add(separator_7, gbc_separator_7);
		
		JButton btnReportOfStudents = new JButton("Report of Students and Grades");
		btnReportOfStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				try {
					Statement stat = conn.createStatement();
					//#cid, 'name', 'semester', year, meets_at, 'room', fid
					String query = "select CLASS.CID, NAME, SEMESTER, YEAR, MEETS_AT, ROOM, ENROLLED.SID" + 
							" from CLASS, ENROLLED" +
							" where FID=" + fid +
							"AND ENROLLED.CID=CLASS.CID";
					ResultSet rs = stat.executeQuery(query);
					String[] cols = {"Class Name", "Semester", "Year", "Meets at", "Room", "Student Name", "Grade"};
					ArrayList<String[]> data = new ArrayList<String[]>();
					while(rs.next()){
						String[] subData = {rs.getString("NAME"), rs.getString("SEMESTER"),
								"" + rs.getInt("YEAR"), rs.getTime("MEETS_AT").toString().substring(0,5),
								rs.getString("ROOM"), "" + rs.getInt("SID")};
						data.add(subData);
					}
					String[][] temp = new String[data.size()][7];
					for(int i = 0; i < data.size(); i++){
						query = "select NAME" +
								" from STUDENTS" +
								" where SID=" + data.get(i)[5];
						rs = stat.executeQuery(query);
						for(int j = 0; j < data.get(i).length; j++)
							temp[i][j] = data.get(i)[j];
						while(rs.next()){
							temp[i][5] = rs.getString("NAME");
						}
					}
					HashMap<String, Double> finalScores = new HashMap<String, Double>();
					for(int i = 0; i < temp.length; i++){
						String sid = data.get(i)[5];
						query = "select CID, WEIGHT, GRADE" + 
								" from EVALUATION" +
								" where SID=" + sid;
						System.out.println(query);
						rs = stat.executeQuery(query);
						while(rs.next()){
							int classNum = rs.getInt("CID");
							double weight = rs.getInt("WEIGHT");
							double score = rs.getInt("GRADE");
							String lookup = classNum + " " + sid;
							System.out.println(lookup);
							if(finalScores.containsKey(lookup)){
								double oldScore = finalScores.remove(lookup);
								finalScores.put(lookup, oldScore + (score * (weight / 100)));
							}else{
								finalScores.put(lookup, score * (weight / 100));
							}
						}
					}
					for(String key : finalScores.keySet()){
						System.out.println(key + " " + finalScores.get(key));
						String[] keyInfo = key.split(" ");
						query = "select NAME" +
								" from CLASS" +
								" where CID=" + keyInfo[0] + 
								" AND FID=" + fid;
						rs = stat.executeQuery(query);
						String className = "";
						while(rs.next()){
							className = rs.getString("NAME");
						}
						for(int i = 0; i < temp.length; i++){
							if(data.get(i)[0].equals(className) && data.get(i)[5].equals(keyInfo[1])){
								temp[i][6] = finalScores.get(key).toString();
								break;
							}
						}
					}
					tableFrame frame = new tableFrame(temp, cols);
					frame.setVisible(true);
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnReportOfStudents = new GridBagConstraints();
		gbc_btnReportOfStudents.insets = new Insets(0, 0, 5, 0);
		gbc_btnReportOfStudents.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReportOfStudents.gridx = 0;
		gbc_btnReportOfStudents.gridy = 15;
		contentPane.add(btnReportOfStudents, gbc_btnReportOfStudents);
		
		JSeparator separator_9 = new JSeparator();
		GridBagConstraints gbc_separator_9 = new GridBagConstraints();
		gbc_separator_9.insets = new Insets(0, 0, 5, 0);
		gbc_separator_9.gridx = 0;
		gbc_separator_9.gridy = 16;
		contentPane.add(separator_9, gbc_separator_9);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(facultyToolsFrame.this, "Logout Successful");
				loginFrame frame = new loginFrame(conn);
				frame.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogout.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogout.gridx = 0;
		gbc_btnLogout.gridy = 17;
		contentPane.add(btnLogout, gbc_btnLogout);
		
		JSeparator separator_8 = new JSeparator();
		GridBagConstraints gbc_separator_8 = new GridBagConstraints();
		gbc_separator_8.gridx = 0;
		gbc_separator_8.gridy = 18;
		contentPane.add(separator_8, gbc_separator_8);
	}

}
