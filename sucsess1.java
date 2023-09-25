package atmdatabase;
import javax.swing.*;

import atmmachine.balance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class sucsess1 extends JFrame {
	static Statement stmt;
	public sucsess1 () {
		JFrame f = new JFrame();
		setTitle ("ATM Michine");
	    setSize(1300, 960);
	    setLocationRelativeTo(null);
	    
	    JLabel background=new JLabel(new ImageIcon("C:/Users/wwwpr/Downloads/atmpic2.jpg"));
	    add(background);
		
		JLabel l1 = new JLabel ("Transaction Sucsessful");
	    l1.setBounds(130, 120, 900, 100);
	    l1.setFont(new Font("calibri", Font.BOLD, 80));
	    
	    JLabel l2 = new JLabel ("Collect your Cash");
	    l2.setBounds(130, 300, 900, 90);
	    l2.setFont(new Font("calibri", Font.BOLD, 80));
	    
	    JButton b4 = new JButton ("EXIT");
		b4.setBounds(850, 700, 400, 50);
	    b4.setFont(new Font("calibri", Font.BOLD, 40));
	    
	    try {
			String db_url = "jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(db_url, "pradeep","asdfgh");
			stmt = con.createStatement();
	    }
	    
	    catch(Exception a)
		{
			System.out.println(a);
		}

	    b4.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		String string1 = "truncate table tempcard";
    			try {
					stmt.executeUpdate(string1);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
    			Homepage hp = new Homepage ();
    			hp.setVisible(true);
    			dispose();
	    	}
	    });
	    
	    JButton b2 = new JButton ("BALANCE ENQUIRY");
	    b2.setBounds(850, 500, 400, 50);
	    b2.setFont(new Font("calibri", Font.BOLD, 40));
	    b2.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		balance bal = new balance ();
	    		bal.setVisible(true);
	    		dispose ();
	    	}
	    });
	    
	    JButton b3 = new JButton ("MAIN MENU");
	    b3.setBounds(850, 600, 400, 50);
	    b3.setFont(new Font("calibri", Font.BOLD, 40));
	    b3.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		options op = new options ();
	    		op.setVisible(true);
	    		dispose ();
	    	}
	    });
	    
	    background.add(l1);
	    background.add(l2);
	    background.add(b2);
	    background.add(b3);
	    background.add(b4);
		setVisible (true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main (String[] args) {
		new sucsess1();
	}

}
