package backend;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class proj3 {
	public static void main(String args[])
	{
		NumberOfRecords=500;
		NumberOfDb=5;
		
		createdb();
		
		System.exit(0);
	}
	
	private static void createdb()
	{
		try
		{
			Connection conn=getConnection();
			Statement stat= conn.createStatement();
			for(int count=1;count<=NumberOfDb;count++)
			{
				String create;
				//String nameofdb="Records_all";
				String nameofdb="Records_"+(count*NumberOfRecords);
				String drop="DROP TABLE "+nameofdb;
				stat.execute(drop);
				create="CREATE TABLE "+nameofdb+" (Age INT, workclass VARCHAR(100), fnlwgt INT, education VARCHAR(100), education_num INT, marital_status VARCHAR(100), occupation VARCHAR(100), relationship VARCHAR(100), race VARCHAR(100), sex VARCHAR(100), capital_gain INT, capital_loss INT, hours_per_week INT, native_country VARCHAR(100), income VARCHAR(100))";
				//System.out.println(create);
				stat.execute(create);
				
				int recordnumber=count*NumberOfRecords;
				int recordcount=0;
				boolean questionmark=false;
				BufferedReader in = new BufferedReader(new FileReader("adult.data"));
				String str;
				String[] small=new String[15];
				while ((str = in.readLine()) != null) 
				{
					char[] temp=new char[str.length()];
					int j=0;
					int k=0;
					for(int i=0;i<str.length();i++)
					{
						if(str.charAt(i)==','||i==str.length()-1)
						{
							small[k]=new String(temp,0,j);
							k++;
							j=0;
							i++;
							temp=new char[str.length()];
						}
						else if(str.charAt(i)==' ')
						{
							continue;
						}
						else if(str.charAt(i)=='?')
						{
							questionmark=true;
							break;
						}
						else
						{
							temp[j]=str.charAt(i);
							j++;
						}
					}
					if(questionmark==true)
					{
						questionmark=false;
						continue;
					}
					String query="";
					for(int i=0;i<k-1;i++)
					{
						query=query+"'";
						query=query+small[i];
						query=query+"'";
						query=query+", ";
					}
					query=query+"'";
					if(k==0) break;
					query=query+small[k-1];
					query=query+"'";
					stat.execute("INSERT INTO "+nameofdb+" VALUES ("+query+")");
					
					recordcount++;
					if(recordcount==recordnumber) break;
				}
				System.out.println(recordcount+" Records have been inserted!");
			}
			stat.close();	
			conn.close();
		}
		catch(SQLException ex)
		{
			while(ex!=null)
			{
				ex.printStackTrace();
				ex=ex.getNextException();
			}
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException, IOException
	{
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
	
	private static int NumberOfRecords;
	private static int NumberOfDb;
}
