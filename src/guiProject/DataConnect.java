package guiProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;



public class DataConnect {
    String url="jdbc:mysql:///bookStore";
    String user = "root";
    String password="password";
    
    
    //Display table data
	public DefaultTableModel getData() {
		
		DefaultTableModel dm = new DefaultTableModel();
		String sql = "Select * from books";
		
		try {
			//get connection to db
			Connection con = DriverManager.getConnection(url, user, password);
			
			//set column names for table
			dm.addColumn("Id");
			dm.addColumn("Title");
			dm.addColumn("Author");
			dm.addColumn("Description");
			dm.addColumn("Price");
			
			//Prepare statement
			Statement s = con.prepareStatement(sql);
			ResultSet rs = s.executeQuery(sql);
			
			//loop through data
			while(rs.next()) {
				String Id = rs.getString(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String descr = rs.getString(4);
				String price = rs.getString(5);
				
				dm.addRow(new String[] {Id, title, author, descr, price});
			} return dm;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return dm;
	}

}
