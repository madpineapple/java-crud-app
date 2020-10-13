package guiProject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class GUI implements ActionListener {

	int count = 0;
	JFrame frame;
	JPanel lPanel;
	JPanel createPnl;
	JPanel homePnl;
	JPanel updatePnl;
	JPanel deletePnl;
	JPanel displayPnl;
	JTextField textField;
	JTextField authorField;
	JTextField descrField;
	JTextField priceField;
	
	
   public GUI() {
	   
	    frame = new JFrame();
	   
	   //sideMenu Buttons
	   JButton button = new JButton("Exit");
	   button.addActionListener(this);
	   
	   //lPanel sideMenu settings
	   lPanel = new JPanel();
	   lPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	   lPanel.setBackground(Color.GRAY);
	   lPanel.setPreferredSize(new Dimension(150,150));
	   //lPanel.add(picLabel);
	   
	   lPanel.add(button);
	   frame.add(lPanel, BorderLayout.WEST);
	   
	   //Home Panel
	   homePnl = new JPanel();
	   homePnl.setBackground(Color.BLACK);
	   JLabel homeLbl = new JLabel("Home");
	   homePnl.add(homeLbl);
	   
	   //Create Panel
	   createPnl = new JPanel();
	   createPnl.setBackground(Color.GREEN);
	   createPnl.setLayout(new FlowLayout());
	   JLabel createLbl = new JLabel("Add new book");
	   createPnl.add(createLbl);
	   textField =new JTextField(20);
	   textField.addActionListener(this);
	   authorField =new JTextField(20);
	   authorField.addActionListener(this);
	   descrField =new JTextField(20);
	   descrField.addActionListener(this);
	   priceField =new JTextField(20);
	   priceField.addActionListener(this);
	   createPnl.add(textField);
	   createPnl.add(authorField);
	   createPnl.add(descrField);
	   createPnl.add(priceField);
	   
	   //Update Panel
	   updatePnl = new JPanel();
	   createPnl.setBackground(Color.BLUE);
	   JLabel updateLbl = new JLabel("Update");
	   updatePnl.add(updateLbl);
	   
	  //Delete Panel
	   deletePnl = new JPanel();
	   deletePnl.setBackground(Color.RED);
	   JLabel deleteLbl = new JLabel("Delete");
	   deletePnl.add(deleteLbl);
	   
	   //Display Panel
	   displayPnl = new JPanel();
	   DataConnect data = new DataConnect();
	   JTable table = new JTable(data.getData());
	   table.setPreferredScrollableViewportSize(new Dimension(500, 100));
	   table.setFillsViewportHeight(true);
	   JScrollPane scrollPane = new JScrollPane(table);
	   displayPnl.add(scrollPane);
	   
	   
	   //Tabs
	   JTabbedPane tp = new JTabbedPane();
	   tp.add("Home", homePnl);
	   tp.add("Create",createPnl);
	   tp.add("Update",updatePnl);
	   tp.add("Delete",deletePnl);
	   tp.add("Display",displayPnl);
	   frame.add(tp);
	   
	   //frame settings
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setTitle("Hello GUI");
	   frame.setSize(500,500);
	   frame.setVisible(true);
	   
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new GUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Functions f = new Functions();
		JOptionPane.showMessageDialog(frame,f.x);
	}
	
	

}
