package guiProject;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class DataConnect {
    String url="jdbc:mysql:///bookStore";
    String user = "root";
    String password="password";
    
    
    //Display table data
	public DefaultTableModel getData() {
		
		DefaultTableModel dm = new DefaultTableModel();
		String sql = "Select * from books";
		//JCheckBox checkbox=new JCheckBox();
		try {
			//get connection to db
			Connection con = DriverManager.getConnection(url, user, password);
			
			//set column names for table
			dm.addColumn("Id");
			dm.addColumn("Title");
			dm.addColumn("Author");
			dm.addColumn("Description");
			dm.addColumn("Price");
			dm.addColumn("Select");
			
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
	
	//Create new data
		public void addData(String input, String input2, String input3,BigDecimal input4) {
			
			String sql ="INSERT into books (title, author, descr, price) values(?,?,?,?)";
			
			try {
				//get connection to database
				Connection con = DriverManager.getConnection(url, user, password);
				//Prepare statement
				PreparedStatement pst = con.prepareStatement(sql);
				
				pst.setString(1,input);
				pst.setString(2,input2);
				pst.setString(3,input3);
				pst.setBigDecimal(4,input4);
				pst.executeUpdate();
				System.out.println("new entry added");
				
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			System.out.println(input+ input2 +input3 +input4);
		}

}
