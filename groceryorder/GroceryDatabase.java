package groceryorder;
import java.sql.*;

public class GroceryDatabase {
	private static final String url = "jdbc:mysql://localhost:3306/delivery_app";
	private static final String uname = "root";
	private static final String pass = "password";
	
	int groceryCount = 0;
	
	String query = "";
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst; 
	
	public GroceryDatabase() throws Exception{		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, uname, pass);		
	}
	
	public void getFullData() throws Exception{
		query = "select * from GROCERY";
		st = con.createStatement();
		rs = st.executeQuery(query);

		while(rs.next()){
			System.out.println(rs.getInt(1) + ". " + rs.getString(2) + " - Rs." + rs.getInt(3));
		}
		st.close();
//		con.close();
	}
	
	public boolean checkAvailable(int selectedId) throws Exception{
		System.out.println("FIrst line");
		query = "select count(*) from GROCERY";
		System.out.println("Second line");
		st = con.createStatement();
		System.out.println("third line");
		rs = st.executeQuery(query);
		System.out.println("FOurth line 0000");
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
