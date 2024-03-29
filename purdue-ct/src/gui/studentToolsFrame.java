package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class studentToolsFrame extends JFrame {
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
	public studentToolsFrame(final Connection conn, String name, final int sid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 225);
		contentPane = new JPanel();
		setContentPane(contentPane);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.insets = new Insets(0, 0, 5, 0);
		gbc_separator_3.gridx = 0;
		gbc_separator_3.gridy = 0;
		contentPane.add(separator_3, gbc_separator_3);

		JLabel lblWelcome = new JLabel("Welcome " + name);
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.gridx = 0;
		gbc_lblWelcome.gridy = 1;
		getContentPane().add(lblWelcome, gbc_lblWelcome);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		contentPane.add(separator, gbc_separator);

		JButton btnCalendarOfEvaluations = new JButton("Calendar of Evaluations");
		btnCalendarOfEvaluations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				try {
					Statement stat = conn.createStatement();
					String query = "select CID, TYPE, WEIGHT, DEADLINE" + 
							" from EVALUATION" +
							" where SID=" + sid;
					ResultSet rs = stat.executeQuery(query);
					ArrayList<String[]> data = new ArrayList<String[]>();
					String[] cols = {"Class Name", "Type", "Weight", "DEADLINE"};
					while (rs.next()) {
						String[] subData = {"" + rs.getInt("CID"), rs.getString("TYPE"),
								"" + rs.getInt("WEIGHT"), "" + rs.getDate("DEADLINE")};
						data.add(subData);
					}
					String[][] temp = new String[data.size()][4];
					for(int i = 0; i < data.size(); i++){
						query = "select NAME" +
								" from CLASS" +
								" where CID=" + data.get(i)[0];
						rs = stat.executeQuery(query);
						while(rs.next()){
							data.get(i)[0] = rs.getString("NAME");
						}
						temp[i] = data.get(i);
					}
					tableFrame frame = new tableFrame(temp, cols);
					frame.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnCalendarOfEvaluations = new GridBagConstraints();
		gbc_btnCalendarOfEvaluations.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCalendarOfEvaluations.insets = new Insets(0, 0, 5, 0);
		gbc_btnCalendarOfEvaluations.gridx = 0;
		gbc_btnCalendarOfEvaluations.gridy = 3;
		getContentPane().add(btnCalendarOfEvaluations, gbc_btnCalendarOfEvaluations);

		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 4;
		contentPane.add(separator_1, gbc_separator_1);

		JButton btnMyClasses = new JButton("My Classes");
		btnMyClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement stat = conn.createStatement();
					String query = "select CID" + 
							" from ENROLLED" +
							" where SID=" + sid;
					ResultSet rs = stat.executeQuery(query);
					query = "select NAME, SEMESTER, MEETS_AT, YEAR, ROOM, FID"+
							" from CLASS";
					int count = 0;
					while (rs.next()) {
						if(count != 0){
							query += " OR";
							query += " CID=" + rs.getInt("CID");
							continue;
						}
						query += " where CID=" + rs.getInt("CID");
						count++;
					}
					rs = stat.executeQuery(query);
					ArrayList<String[]> data = new ArrayList<String[]>();
					String[] cols = {"Class Name", "Semester", "Meets At", "Year", "Room", "Professor"};
					while (rs.next()) {
						String[] subData = {rs.getString("NAME"), rs.getString("SEMESTER"),
								rs.getTime("MEETS_AT").toString().substring(0, 5), "" + rs.getInt("YEAR"),
								rs.getString("ROOM"), "" + rs.getInt("FID")};
						data.add(subData);
					}
					String[][] temp = new String[data.size()][6];
					for(int i = 0; i < data.size(); i++){
						query = "select NAME" +
								" from FACULTY" +
								" where FID=" + data.get(i)[5];
						rs = stat.executeQuery(query);
						while(rs.next()){
							data.get(i)[5] = rs.getString("NAME");
						}
						temp[i] = data.get(i);
					}
					tableFrame frame = new tableFrame(temp, cols);
					frame.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnMyClasses = new GridBagConstraints();
		gbc_btnMyClasses.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMyClasses.insets = new Insets(0, 0, 5, 0);
		gbc_btnMyClasses.gridx = 0;
		gbc_btnMyClasses.gridy = 5;
		getContentPane().add(btnMyClasses, gbc_btnMyClasses);

		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.insets = new Insets(0, 0, 5, 0);
		gbc_separator_2.gridx = 0;
		gbc_separator_2.gridy = 6;
		contentPane.add(separator_2, gbc_separator_2);

		JButton btnMyGrades = new JButton("My Grades");
		btnMyGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement stat = conn.createStatement();
					String query = "select CID, TYPE, WEIGHT, GRADE" + 
							" from EVALUATION" +
							" where SID=" + sid;
					ResultSet rs = stat.executeQuery(query);
					ArrayList<String[]> data = new ArrayList<String[]>();
					ArrayList<Integer> classes = new ArrayList<Integer>();
					String[] cols = {"Class Name", "Type", "Weight", "Grade"};
					while (rs.next()) {
						String[] subData = {"" + rs.getInt("CID"), rs.getString("TYPE"),
								"" + rs.getInt("WEIGHT"), "" + rs.getInt("GRADE"),};
						if(!classes.contains(rs.getInt("CID")))
							classes.add(rs.getInt("CID"));
						data.add(subData);
					}
					String[][] temp = new String[data.size()+classes.size()][4];
					HashMap<Integer, Double> finalScores = new HashMap<Integer, Double>();
					for(int i = 0; i < data.size(); i++){
						query = "select NAME" +
								" from CLASS" +
								" where CID=" + data.get(i)[0];
						int classNum = Integer.parseInt(data.get(i)[0]);
						double weight = (double) Integer.parseInt(data.get(i)[2]);
						double score = (double) Integer.parseInt(data.get(i)[3]);
						if(finalScores.containsKey(classNum)){
							double oldScore = finalScores.remove(classNum);
							finalScores.put(classNum, oldScore + (score * (weight / 100)));
						}else{
							finalScores.put(classNum, score * (weight / 100));
						}
						rs = stat.executeQuery(query);
						temp[i] = data.get(i);
						while(rs.next()){
							temp[i][0] = rs.getString("NAME");
						}
					}
					int i = 0;
					for (Integer key : finalScores.keySet()) {
						query = "select NAME" +
								" from CLASS" +
								" where CID=" + key;
						rs = stat.executeQuery(query);
						temp[i] = data.get(i);
						while(rs.next()){
							temp[data.size() + i][0] = rs.getString("NAME");
						}
					    temp[data.size() + i][1] = "Current Grade";
					    temp[data.size() + i][2] = "100";
					    temp[data.size() + i][3] = finalScores.get(key).toString();
					    i++;
					}
					tableFrame frame = new tableFrame(temp, cols);
					frame.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnMyGrades = new GridBagConstraints();
		gbc_btnMyGrades.insets = new Insets(0, 0, 5, 0);
		gbc_btnMyGrades.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMyGrades.gridx = 0;
		gbc_btnMyGrades.gridy = 7;
		getContentPane().add(btnMyGrades, gbc_btnMyGrades);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(studentToolsFrame.this, "Logout Successful");
				loginFrame frame = new loginFrame(conn);
				frame.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogout.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogout.gridx = 0;
		gbc_btnLogout.gridy = 8;
		contentPane.add(btnLogout, gbc_btnLogout);
		
		JSeparator separator_4 = new JSeparator();
		GridBagConstraints gbc_separator_4 = new GridBagConstraints();
		gbc_separator_4.gridx = 0;
		gbc_separator_4.gridy = 9;
		contentPane.add(separator_4, gbc_separator_4);
	}

}
