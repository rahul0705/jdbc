package backend;

import gui.loginFrame;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class proj3 {
	private static int NumberOfRecords;
	private static int NumberOfDb;
	
	public static void main(String args[]){
		NumberOfRecords = 500;
		NumberOfDb = 5;
		
		Connection conn = null;
		try {
			conn = getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createStudentsTable(conn);
		createFacultyTable(conn);
		
		loginFrame l = new loginFrame(conn);
		l.setVisible(true);
	}
	
	private static void createStudentsTable(Connection conn){
		try {
			Statement stat = conn.createStatement();
			String drop = "DROP TABLE STUDENTS";
			stat.execute(drop);
			String create = "CREATE TABLE STUDENTS (sid INT, name VARCHAR(100), username VARCHAR(20), password VARCHAR(20))";
			stat.execute(create);
			BufferedReader in = new BufferedReader(new FileReader("Input/Students.data"));
			String str;
			while((str = in.readLine()) != null){
				if(str.startsWith("#"))
					continue;
				stat.execute("INSERT INTO STUDENTS VALUES (" + str + ")");
			}
			in.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			while(e != null){
				e.printStackTrace();
				e = e.getNextException();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void createFacultyTable(Connection conn){
		try {
			Statement stat = conn.createStatement();
			String drop = "DROP TABLE FACULTY";
			stat.execute(drop);
			String create = "CREATE TABLE FACULTY (fid INT, name VARCHAR(100), username VARCHAR(20), password VARCHAR(20))";
			stat.execute(create);
			BufferedReader in = new BufferedReader(new FileReader("Input/Faculty.data"));
			String str;
			while((str = in.readLine()) != null){
				if(str.startsWith("#"))
					continue;
				stat.execute("INSERT INTO FACULTY VALUES (" + str + ")");
			}
			in.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			while(e != null){
				e.printStackTrace();
				e = e.getNextException();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException, IOException{
		Properties props = new Properties();
		FileInputStream in = new FileInputStream("Input/jdbc.properties");
		props.load(in);
		in.close();
		
		//System.setProperty("oracle.net.tns_admin","/p/oracle10g/network/admin");
		//connection = DriverManager.getConnection("jdbc:oracle:thin:@csora","gbrinzea","W24ZK4aw");
		
		String drivers = props.getProperty("connection.driver_class");
		if(drivers != null)
			System.setProperty("jdbc.drivers", drivers);
		String url="jdbc:oracle:thin:@csora";
		String username="rmohanda";
		String password="AKmVy2dn";
		return DriverManager.getConnection(url, username, password);
			
	}
}