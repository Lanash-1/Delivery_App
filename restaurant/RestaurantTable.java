package restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RestaurantTable {
	private static final String URL = "jdbc:mysql://localhost:3306/delivery_app";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	
	String query = "";
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	public RestaurantTable() throws Exception{		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);		
	}
	
	public void setRestaurantDetails(String email, String password, String name, String location, String contact) throws Exception {
		query = "insert into restaurant(restaurant_email, restaurant_password, restaurant_name, restaurant_location, restaurant_contact) values('"+email+"','"+password+"','"+name+"','"+location+"','"+contact+"')";
		st = con.createStatement();
		st.executeUpdate(query);
		query = "create table "+name+"(food_id int not null auto_increment, food_name varchar(266) not null, food_price int not null, primary key(food_id))";
		st = con.createStatement();
		st.executeUpdate(query);
	}
	
	public void addFoodItem(String name, String foodName, int foodPrice) throws Exception {
		query = "insert into "+name+"(food_name, food_price) values ('"+foodName+"','"+foodPrice+"')";
		st = con.createStatement();
		st.executeUpdate(query);
	}
	
	public void removeFoodItem(String name, int id) throws Exception{
		query = "delete from "+name+" where food_id = "+id;
		st = con.createStatement();
		st.executeUpdate(query);
	}
	
	public void viewMenu(String name) throws Exception {
		query = "select * from "+name;
		st = con.createStatement();
		rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getInt(1) + ". " + rs.getString(2) + " - Rs." + rs.getInt(3));
		}
	}
	
	public void editMenu(String name, String foodName, int foodPrice, int id) throws Exception{
		query = "update "+name+" set food_name = '" + foodName + "', food_price = "+foodPrice+" where food_id = "+id;
		st = con.createStatement();
		st.executeUpdate(query);
	}
}
