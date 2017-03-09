package jdbc;

import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		
		try {
			// 1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://134.83.83.25:47000/grp2_interview_assistant", "l2grp2", "l2grp2");
			
			// 2. Create a statement
			Statement myStmt = myConn.createStatement();
			// 3. Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from QUESTIONS");
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("questions"));
		}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}




