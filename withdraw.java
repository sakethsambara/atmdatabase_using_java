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
public class withdraw extends JFrame{
	static Statement stmt;
	public withdraw () {
		JFrame f = new JFrame();
		setTitle ("ATM Michine");
	    setSize(1300, 960);
	    setLocationRelativeTo(null);
	    
	    JLabel background=new JLabel(new ImageIcon("C:/Users/wwwpr/Downloads/atmpic2.jpg"));
	    add(background);
		
		JLabel l1 = new JLabel ("Enter the Amount to Withdraw");
		l1.setBounds(130, 60, 950, 80);
		l1.setFont(new Font("calibri", Font.BOLD, 70));
	    
	    final JTextField tf1 = new JTextField ();
	    tf1.setBounds(400, 180, 300, 60);
	    tf1.setBackground (Color.LIGHT_GRAY);
	    tf1.setFont(new Font("calibri", Font.BOLD, 30));
	    
	    JLabel l2 = new JLabel ("Enter Your PIN Number");
	    l2.setBounds(180, 330, 600, 80);
	    l2.setFont(new Font("calibri", Font.BOLD, 60));
	    
	    final JTextField tf2 = new JTextField ();
	    tf2.setBounds(290, 460, 320, 60);
	    tf2.setBackground (Color.LIGHT_GRAY);
	    tf2.setFont(new Font("calibri", Font.BOLD, 50));
	    
	    JButton b1 = new JButton ("WITHDRAW");
	    b1.setBounds(330, 600, 250, 70);
	    b1.setFont(new Font("calibri", Font.BOLD, 40));
	    
	    b1.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		
	    		String amount;
	    		amount = tf1.getText();
	    		
	    		String pno;
	    		pno = tf2.getText();
	    		
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
	    			
	    			int i = Integer.parseInt(bal);
	    			int j = Integer.parseInt(amount);
	    			int newbal = i - j;
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
    				
	    			else if (pno.equals(pno1)) {
	    				flag = 1;
	    				String cno2 = "update accountdetails set balance = \'"+newbal+"\'where card_no = " +cno;
	    				stmt.executeUpdate(cno2);
	    				sucsess1 s1 = new sucsess1 ();
	    				s1.setVisible(true);
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
	    background.add(b1);
	    background.add(b2);
	    background.add(b3);
	    setVisible (true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main (String[] args) {
		new withdraw ();
	}

}
