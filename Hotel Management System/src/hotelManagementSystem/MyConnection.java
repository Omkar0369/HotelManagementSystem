package hotelManagementSystem;

import java.sql.*;

public class MyConnection {
	Connection c;
	Statement s;
	
	public MyConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql:///projecthms","root","Sangeeta@123");
			s=c.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

