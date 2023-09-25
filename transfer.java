package atmdatabase;
import javax.swing.*;

import atmmachine.balance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class transfer extends JFrame {
	static Statement stmt; 
	public transfer (){
		JFrame f = new JFrame();
		setTitle ("ATM Michine");
	    setSize(1300, 960);
	    setLocationRelativeTo(null);
	    
	    JLabel background=new JLabel(new ImageIcon("C:/Users/wwwpr/Downloads/atmpic2.jpg"));
	    add(background);
		
		JLabel l1 = new JLabel ("Enter the Amount to Transfer : ");
	    l1.setBounds(70, 70, 700, 55);
	    l1.setFont(new Font("calibri", Font.BOLD, 50));
	    
	    final JTextField tf1 = new JTextField ();
	    tf1.setBounds(760, 70, 200, 50);
	    tf1.setBackground (Color.LIGHT_GRAY);
	    tf1.setFont(new Font("calibri", Font.BOLD, 45));
	    
	    JLabel l2 = new JLabel ("Enter Your PIN Number");
	    l2.setBounds(210, 170, 600, 60);
	    l2.setFont(new Font("calibri", Font.BOLD, 50));
	    
	    final JTextField tf2 = new JTextField ();
	    tf2.setBounds(270, 260, 340, 45);
	    tf2.setBackground (Color.LIGHT_GRAY);
	    tf2.setFont(new Font("calibri", Font.BOLD, 40));
	    
	    JLabel l3 = new JLabel ("Enter the ACCOUNT NUMBER of the recipient : ");
	    l3.setBounds(50, 350, 800, 50);
	    l3.setFont(new Font("calibri", Font.BOLD, 39));
	    
	    final JTextField tf3 = new JTextField ();
	    tf3.setBounds(270, 470, 340, 55);
	    tf3.setBackground (Color.LIGHT_GRAY);
	    tf3.setFont(new Font("calibri", Font.BOLD, 30));
	    
	    JButton b1 = new JButton ("TRANSFER");
	    b1.setBounds(300, 600, 280, 60);
	    b1.setFont(new Font("calibri", Font.BOLD, 50));
	    
	    b1.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		
	    		String amount;
	    		amount = tf1.getText();
	    		
	    		String pno;
	    		pno = tf2.getText();
	    		
	    		String recipient;
	    		recipient = tf3.getText();
	    		
	    		try {
	    			
	    			String db_url = "jdbc:oracle:thin:@localhost:1521:XE";
	    			Class.forName("oracle.jdbc.driver.OracleDriver");
	    			Connection con = DriverManager.getConnection(db_url, "pradeep","asdfgh");
	    			stmt = con.createStatement();
	    			
	    			ResultSet rs1 = stmt.executeQuery("select cardno from tempcard");
	    			rs1.next();
	    			String cno = rs1.getString("cardno");
	    			
	    			ResultSet rs2 = stmt.executeQuery("select balance from accountdetails where card_no = "+cno);
	    			rs2.next();
	    			String bal = rs2.getString ("balance");
	    			
	    			ResultSet rs4 = stmt.executeQuery("select balance from accountdetails where card_no = "+recipient);
	    			rs4.next();
	    			String bal1 = rs4.getString ("balance");
	    			
	    			ResultSet rs3 = stmt.executeQuery("select cardno from carddetails");
	    			int count = 0;
	    			while(rs3.next()) {
	    				String cno1 = rs3.getString("cardno");
	    				if (recipient.equals(cno1)) {
	    					count = 1;
	    				}
	    			}
	    			
	    			int i = Integer.parseInt(bal);
	    			int k = Integer.parseInt(bal1);
	    			int j = Integer.parseInt(amount);
	    			int newbal = i - j;
	    			int newbal1 = k + j;
	    			
	    			ResultSet rs = stmt.executeQuery("select pin_no from accountdetails where card_no = "+cno);
	    			int flag = 0;
	    			rs.next();
	    			String pno1 = rs.getString("pin_no");
	    			
	    			if (newbal < 0) {
	    				failure3 f3 = new failure3();
	    				f3.setVisible(true);
	    				con.close();
	    				stmt.close();
	    			}
	    			
	    			else if (count == 0) {
	    				failure4 f4 = new failure4();
	    				f4.setVisible(true);
	    				con.close();
	    				stmt.close();
	    			}

    				
	    			else if ((pno.equals(pno1)) && (count == 1)) {
	    				flag = 1;
	    				String cno2 = "update accountdetails set balance = \'"+newbal+"\'where card_no = " +cno;
	    				stmt.executeUpdate(cno2);
	    				String str = "update accountdetails set balance = \'"+newbal1+"\'where card_no = " +recipient;
	    				stmt.executeUpdate(str);
	    				sucsess3 s3 = new sucsess3 ();
	    				s3.setVisible(true);
	    			}
	    			else if (flag == 0) {
	    				failure2 f2 = new failure2();
	    				f2.setVisible(true);
	    				con.close();
	    				stmt.close();
	    			}
	    			else {
	    				System.out.println (".");
	    			}
	    		}
	    		catch(Exception a)
				{
					System.out.println(a);
				}

	    		dispose ();
	    	}
	    });
	    
	    JButton b2 = new JButton ("BALANCE ENQUIRY");
	    b2.setBounds(850, 600, 400, 50);
	    b2.setFont(new Font("calibri", Font.BOLD, 40));
	    b2.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		balance bal = new balance ();
	    		bal.setVisible(true);
	    		dispose ();
	    	}
	    });
	    
	    JButton b3 = new JButton ("MAIN MENU");
	    b3.setBounds(850, 700, 400, 50);
	    b3.setFont(new Font("calibri", Font.BOLD, 40));
	    b3.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		options op = new options ();
	    		op.setVisible(true);
	    		dispose ();
	    	}
	    });
	    
	    background.add(l1);
	    background.add(tf1);
	    background.add(l2);
	    background.add(tf2);
	    background.add(l3);
	    background.add(tf3);
	    background.add(b1);
	    background.add(b2);
	    background.add(b3);
	    setVisible (true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main (String[] args) {
		new transfer ();
	}
}
