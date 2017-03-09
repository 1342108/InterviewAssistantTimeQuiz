package JDBC;
import java.sql.*;





public class Driver {

	public static void main(String[] args) {
		
		
		try{
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://134.83.83.25:47000/grp2_interview_assistant", "l2grp2", "l2grp2");
			
			Statement myStmt = myConn.createStatement();
			
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM ANSWERS");
			
			
			while (myRs.next()){
				System.out.println(myRs.getString("answer"));
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
			
		}

	}

}
