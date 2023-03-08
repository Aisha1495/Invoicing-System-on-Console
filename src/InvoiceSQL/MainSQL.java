package InvoiceSQL;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

	public class MainSQL {

		public static void main(String[] args) {
			
			String url = "jdbc:sqlserver://localhost:1433;" +
					 "databaseName=invoice;" +
					 "encrypt=true;" + "trustServerCertificate=true";
					 Scanner scanner = new Scanner(System.in);
					 System.out.println("enter user");
					 String user = scanner.nextLine();
					 System.out.println("enter pass");
					 String pass = scanner.nextLine();
					
					 if (user.equals(user) && pass.equals(pass)) {}else {
					 System.out.println("worng username and password ");
					 }
					 
					 Connection con = null;
					 System.out.println("System is in prograss:");
					 
					 try {
					 // create a new table
					 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
					 DriverManager.registerDriver(driver);
					 con = DriverManager.getConnection(url, user, pass);
					 Statement st = con.createStatement();
					 
					 
					// setting menu
					 
					 setting1 sett = new setting1();
					 sett.setShopName("Market");
					 sett.setTelNum(20522550);
					 sett.setFaxNo(20522554);
					 sett.setEmail("Market@gmail.com");
					 sett.setWebsite("Market.com.om");
					 
					 
					 
					 
					 String sql1="CREATE TABLE setting (" 
							 + "shopName text not null,"
							 +"TelNum INTEGER not null,"
							 +"faxNo INTEGER not null,"
							 + "Email text not null, "
							 +"Website text not null"
							 + ");";
					 
			st.execute(sql1);
					 String sql = "INSERT INTO setting (shopName, TelNum,faxNo ,Email,Website)"+
							 "VALUES ("+"'"+sett.getShopName()+"','"+sett.getTelNum()+"','"+sett.getFaxNo()+"','"+sett.getEmail()+"','"+sett.getWebsite()+ "')";
					  st.execute(sql);
					 
					// String sql = "INSERT INTO "
					
		
					 
					 
				        con.close();
					 } catch (Exception ex) {
					 System.err.println(ex);
					 }
					 	 
		}

	}
