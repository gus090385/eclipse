package Practice;

import java.sql.*;


public class DatabasePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Connect to DB
		 * right click on the project:
		 * 1.Build Path-->Configure build Path--> Libraries--> add external JAR
		 * 2.import java.sql.Connection;
		 */
		
		Connection conn = null;
		Statement stat = null;;
		ResultSet rs = null;
		
		/*
		 * loading the driver to my db
		 */
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
		}
		catch(ClassNotFoundException ex) {
			System.out.println("problem in loadin the driver");
			ex.printStackTrace();
		}
		
		/*
		 * connect to my db
		 */
		try {
			String dbName = "Employee.accdb";
			String dbURL= "jdbc:ucanaccess://" + dbName;
			//to stablish the connection we need getConnection method
			conn = DriverManager.getConnection(dbURL);
			//creating variable for my data
			String n = "Jhon";
			double sa = 66000;
			//this method is for retrieve data
			stat = conn.createStatement();
			
			//Insert data from the variable "n"  , format: '"+var+"' -->String ; numeric: "+var+"
			String query = "INSERT INTO EMP (ENAME,Salary)" + "values('"+n+"',"+sa+")";
			
			//execute the before statement
			stat.executeUpdate(query);
			
			//For updating records
			query = "UPDATE EMP SET Salary = 120000 "
					+ "where EName= 'ABC'";
			//execute the before statement
			stat.executeUpdate(query);
			
			//For deleting records
			query = " DELETE FROM EMP where EName = 'Jhon'";
			//execute the before statement
			stat.executeUpdate(query);
			
			
			//Select data from our table
			rs = stat.executeQuery("Select * from Emp");
			int id;
			String name;
			double sal;
			while(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				System.out.println("id " + id + " name " + name + " salary " + sal);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		/*
		 * we need to close the connection
		 */
		
		finally {
			try {
				if(conn!= null)
				{
					rs.close();
					stat.close();
					conn.close();
				}
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
		
		
		
	}

}
