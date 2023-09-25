package atmdatabase;
import javax.swing.*;

import atmmachine.balance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class options extends JFrame {
	static Statement stmt;
	public options(){
		JFrame f = new JFrame();
		setTitle ("ATM Michine");
	    setSize(1300, 960);
	    setLocationRelativeTo(null);
	    
	    JLabel background=new JLabel(new ImageIcon("C:/Users/wwwpr/Downloads/atmpic2.jpg"));
	    add(background);
	    
		JButton b1,b2,b3,b4,b5;
		
		try {
			String db_url = "jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(db_url, "pradeep","asdfgh");
			stmt = con.createStatement();
			ResultSet rs6 = stmt.executeQuery("select cardno from tempcard");
			rs6.next();
			String cno = rs6.getString("cardno");
			ResultSet rs7 = stmt.executeQuery("select holdername from carddetails where cardno = "+cno);
			rs7.next();
			String name = rs7.getString ("holdername");
			JLabel lab = new JLabel();
			lab.setBounds(250, 20, 400, 50);
			lab.setFont(new Font("calibri", Font.BOLD, 50));
			lab.setText(name);
			background.add(lab);
	    }
	    
	    catch(Exception a)
		{
			System.out.println(a);
		}
		
		JLabel l1 = new JLabel("WELCOME : ");
	    l1.setBounds(20,20,250,50);
	    l1.setFont(new Font("calibri", Font.BOLD, 40));
	    
		b1 = new JButton ("BALANCE ENQUIRY");
		b1.setBounds(150, 150, 550, 70);
	    b1.setFont(new Font("calibri", Font.BOLD, 50));
	    
	    b2 = new JButton ("DEPOSIT MONEY");
		b2.setBounds(150, 300, 550, 70);
	    b2.setFont(new Font("calibri", Font.BOLD, 50));
	    
	    b3 = new JButton ("WITHDRAW MONEY");
		b3.setBounds(150, 450, 550, 70);
	    b3.setFont(new Font("calibri", Font.BOLD, 50));
	    
	    b4 = new JButton ("TRANSFER MONEY");
		b4.setBounds(150, 600, 550, 70);
	    b4.setFont(new Font("calibri", Font.BOLD,50));
	    
	    b5 = new JButton ("EXIT");
		b5.setBounds(950, 700, 300, 70);
	    b5.setFont(new Font("calibri", Font.BOLD, 50));
	    
	    b1.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		balance bal = new balance ();
	    		bal.setVisible(true);
	    		dispose ();
	    	}
	    });
	    
	    b2.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		deposit dep = new deposit ();
	    		dep.setVisible(true);
	    		dispose ();
	    	}
	    });
	    
	    b3.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		withdraw wd = new withdraw ();
	    		wd.setVisible(true);
	    		dispose ();
	    	}
	    });
	    
	    b4.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		transfer tr = new transfer ();
	    		tr.setVisible(true);
	    		dispose ();
	    	}
	    });
	    
	    b5.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		String str = "truncate table tempcard";
    			try {
					stmt.executeUpdate(str);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
    			Homepage hp = new Homepage ();
    			hp.setVisible(true);
    			dispose();
	    	}
	    });
	    
	    background.add(b1);
	    background.add(b2);
	    background.add(b3);
	    background.add(b4);
	    background.add(b5);
	    background.add(l1);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main (String[] args) {
		new options();
	}
}
