package groceryorder;
import java.sql.*;

public class GroceryTable {
	private static final String URL = "jdbc:mysql://localhost:3306/delivery_app";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	
	int groceryCount = 0;
	
	String query = "";
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst; 
	
	public GroceryTable() throws Exception{		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);		
	}
	
	public void getFullData() throws Exception{
		query = "select * from GROCERY";
		st = con.createStatement();
		rs = st.executeQuery(query);

		while(rs.next()){
			System.out.println(rs.getInt(1) + ". " + rs.getString(2) + " - Rs." + rs.getInt(3));
		}
		st.close();
	}
	
	public boolean checkAvailable(int selectedId) throws Exception{
		query = "select count(*) from GROCERY";
		st = con.createStatement();
		rs = st.executeQuery(query);
		rs.next();
		groceryCount = rs.getInt(1);
		if(groceryCount < selectedId || selectedId < 1) {
			System.out.println("Select a valid item");
			return false;
		}
		return true;
	}

	public Grocery getSelectedGrocery(int selectedId) throws Exception{
		query = "Select grocery_name, grocery_price from grocery where id = ?";
		pst = con.prepareStatement(query);
		pst.setInt(1, selectedId);
		rs = pst.executeQuery();
		rs.next();
		Grocery grocery = new Grocery();
		grocery.productId = selectedId;
		grocery.productName = rs.getString(1);
		grocery.productPrice = rs.getInt(2);
		return grocery;
	}
	
	
}
