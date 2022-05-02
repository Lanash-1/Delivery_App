package app;
import java.sql.*;

public class Database {
	String url = "jdbc:mysql://localhost:3306/delivery_app";
	String uname = "root";
	String pass = "password";
	String query = "";
	Connection con;
	Statement st;
	ResultSet rs;
	Database() throws Exception{		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, uname, pass);
		System.out.println("cons area");
	}
	void getFullData() throws Exception{
		// process to come
		query = "select * from GROCERY";
		st = con.createStatement();
		rs = st.executeQuery(query);

		while(rs.next()){
			System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getInt(3));
		}
		st.close();
		con.close();
	}	
}