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
	
	public static void main(String args[]){
		
		Connection conn = null;
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		createStudentsTable(conn);
		createFacultyTable(conn);
		createClassTable(conn);
		createEnrolledTable(conn);
		createEvaluationTable(conn);
		
		loginFrame l = new loginFrame(conn);
		l.setVisible(true);
	}
	
	private static void createStudentsTable(Connection conn){
		try {
			Statement stat = conn.createStatement();
			String drop = "DROP TABLE STUDENTS";
			stat.execute(drop);
			String create = "CREATE TABLE STUDENTS (sid INT, name VARCHAR(30), username VARCHAR(20), password VARCHAR(20))";
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
			while(e != null){
				e.printStackTrace();
				e = e.getNextException();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void createFacultyTable(Connection conn){
		try {
			Statement stat = conn.createStatement();
			String drop = "DROP TABLE FACULTY";
			stat.execute(drop);
			String create = "CREATE TABLE FACULTY (fid INT, name VARCHAR(30), username VARCHAR(20), password VARCHAR(20))";
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
			while(e != null){
				e.printStackTrace();
				e = e.getNextException();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void createClassTable(Connection conn){
		try {
			Statement stat = conn.createStatement();
			String drop = "DROP TABLE CLASS";
			stat.execute(drop);
			String create = "CREATE TABLE CLASS (cid INT, name VARCHAR(30), semester VARCHAR(20), year INT, meets_at DATE, room VARCHAR(20), fid INT)";
			stat.execute(create);
			BufferedReader in = new BufferedReader(new FileReader("Input/Class.data"));
			String str;
			while((str = in.readLine()) != null){
				if(str.startsWith("#"))
					continue;
				stat.execute("INSERT INTO CLASS VALUES (" + str + ")");
			}
			in.close();
		} catch (SQLException e) {
			while(e != null){
				e.printStackTrace();
				e = e.getNextException();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void createEvaluationTable(Connection conn){
		try {
			Statement stat = conn.createStatement();
			String drop = "DROP TABLE EVALUATION";
			stat.execute(drop);
			String create = "CREATE TABLE EVALUATION (eid INT, cid INT, type VARCHAR(30), weight INT, deadline DATE, sid INT, grade CHAR)";
			stat.execute(create);
			BufferedReader in = new BufferedReader(new FileReader("Input/Evaluation.data"));
			String str;
			while((str = in.readLine()) != null){
				if(str.startsWith("#"))
					continue;
				stat.execute("INSERT INTO EVALUATION VALUES (" + str + ")");
			}
			in.close();
		} catch (SQLException e) {
			while(e != null){
				e.printStackTrace();
				e = e.getNextException();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void createEnrolledTable(Connection conn){
		try {
			Statement stat = conn.createStatement();
			String drop = "DROP TABLE Enrolled";
			stat.execute(drop);
			String create = "CREATE TABLE Enrolled (cid INT, sid INT)";
			stat.execute(create);
			BufferedReader in = new BufferedReader(new FileReader("Input/Enrolled.data"));
			String str;
			while((str = in.readLine()) != null){
				if(str.startsWith("#"))
					continue;
				stat.execute("INSERT INTO Enrolled VALUES (" + str + ")");
			}
			in.close();
		} catch (SQLException e) {
			while(e != null){
				e.printStackTrace();
				e = e.getNextException();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException, IOException{
		Properties props = new Properties();
		FileInputStream in = new FileInputStream("Input/jdbc.properties");
		props.load(in);
		in.close();
		
		String drivers = props.getProperty("connection.driver_class");
		if(drivers != null)
			System.setProperty("jdbc.drivers", drivers);
		String url="jdbc:oracle:thin:@claros.cs.purdue.edu:1524:strep";
		String username="rmohanda";
		String password="AKmVy2dn";
		return DriverManager.getConnection(url, username, password);
			
	}
}