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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

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
	JFormattedTextField priceField;
	JButton submitBTN1;
	JLabel homeLbl2;
	ImageIcon img;
	
   public GUI() {
	   
	    frame = new JFrame();
	   
	   //sideMenu Buttons
	   JButton button = new JButton("Exit");
	   button.addActionListener(this);
	   
	   //lPanel sideMenu settings
	   lPanel = new JPanel();
	   lPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	   lPanel.setBackground(Color.GRAY);
	   lPanel.setPreferredSize(new Dimension(250,250));
	   JLabel title = new JLabel("Bookstore Data Manager App");
	   JLabel icon = new JLabel();
	   img= new ImageIcon(getClass().getResource("miniCow.jpg"));
	   icon= new JLabel(img);
	   lPanel.add(title);
	   lPanel.add(icon);
	   lPanel.add(button);
	   frame.add(lPanel, BorderLayout.WEST);
	   
	   //Home Panel
	   homePnl = new JPanel();
	   homePnl.setBackground(Color.BLACK);
	   JLabel homeLbl = new JLabel("Home");
	   img= new ImageIcon(getClass().getResource("miniCow.jpg"));
	   homeLbl2= new JLabel(img);
	   homePnl.add(homeLbl);
	   homePnl.add(homeLbl2);
	   
	   //Create Panel
	   createPnl = new JPanel();
	   createPnl.setLayout((LayoutManager) new BoxLayout(createPnl, BoxLayout.Y_AXIS));
	   JPanel textEntryPNL = new JPanel(); 
	   JPanel labelPNL = new JPanel();
	   JPanel formPNL = new JPanel(); 
	   createPnl.setBackground(Color.GREEN);
	   JLabel createLbl = new JLabel("Add new book");
	   createLbl.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

	   createPnl.add(createLbl);
	   
	   //labelPnl 
	   labelPNL.setBorder(BorderFactory.createEmptyBorder(0, 30, 40, 30));
	   labelPNL.setLayout((LayoutManager) new BoxLayout(labelPNL, BoxLayout.Y_AXIS));
	   JLabel lbl1 = new JLabel("title");
	   JLabel lbl2 = new JLabel("author");
	   JLabel lbl3 = new JLabel("descr");
	   JLabel lbl4= new JLabel("price");
	   labelPNL.add(lbl1);
	   labelPNL.add(Box.createRigidArea(new Dimension(0, 5)));
	   labelPNL.add(lbl2);
	   labelPNL.add(Box.createRigidArea(new Dimension(0, 5)));
	   labelPNL.add(lbl3);
	   labelPNL.add(Box.createRigidArea(new Dimension(0, 5)));
	   labelPNL.add(lbl4);
	   labelPNL.add(Box.createRigidArea(new Dimension(0, 5)));
	   formPNL.add(labelPNL);
	   	   
	   //textEntryPNL form
	   textEntryPNL.setLayout((LayoutManager) new BoxLayout(textEntryPNL, BoxLayout.Y_AXIS));
	   textEntryPNL.setBorder(BorderFactory.createEmptyBorder(10, 30, 40, 30));
	   textField =new JTextField(20);
	   textField.addActionListener(this);
	   textEntryPNL.add(textField);
	   textEntryPNL.add(Box.createRigidArea(new Dimension(0, 5)));
	   authorField =new JTextField(20);
	   authorField.addActionListener(this);
	   textEntryPNL.add(authorField);
	   textEntryPNL.add(Box.createRigidArea(new Dimension(0, 5)));
       textEntryPNL.setSize(10,10);
	   descrField =new JTextField(20);
	   descrField.addActionListener(this);
	   descrField.setLocation(0,50);
	   priceField =new JFormattedTextField(new DecimalFormat("#.0"));
	   priceField.addActionListener(this);
	   textEntryPNL.add(descrField);
	   textEntryPNL.add(Box.createRigidArea(new Dimension(0, 5)));
	   textEntryPNL.add(priceField);
	   textEntryPNL.add(Box.createRigidArea(new Dimension(0, 5)));
	   submitBTN1 = new JButton("Submit");
	   submitBTN1.addActionListener(this);
	   textEntryPNL.add(submitBTN1);
	   formPNL.add(textEntryPNL);
	   
	   createPnl.add(formPNL);

	   
	   //Update Panel
	   updatePnl = new JPanel();
	   updatePnl.setBackground(Color.BLUE);
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
	   frame.setSize(1000,500);
	   frame.setVisible(true);
	   
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new GUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
	    if(source.equals(submitBTN1)){
	       if(textField.getText().trim().isEmpty()||authorField.getText().trim().isEmpty()||
	    		   descrField.getText().trim().isEmpty()||priceField.getText().trim().isEmpty()) {
	    	 //custom title, error icon
	    	   JOptionPane.showMessageDialog(frame,
	    	       "Please fill out all text boxes.",
	    	       "Inane error",
	    	       JOptionPane.ERROR_MESSAGE);
	       }else {
	    	   DataConnect data = new DataConnect();
	    	   BigDecimal A= new BigDecimal(priceField.getText());
	           data.addData(textField.getText(),authorField.getText(),descrField.getText(),A
	            		);
	       }
	 	   
	    }
	    else{
	    	frame.dispose();
	    }
	}
	
	

}
