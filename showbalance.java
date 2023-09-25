package atmdatabase;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
public class showbalance extends JFrame {
	static Statement stmt;
	showbalance(){
		JFrame f = new JFrame();
		setTitle ("ATM Michine");
	    setSize(1300, 960);
	    setLocationRelativeTo(null);
	    
	    JLabel background=new JLabel(new ImageIcon("C:/Users/wwwpr/Downloads/atmpic2.jpg"));
	    add(background);
	    
	    JButton b2 = new JButton ("Main Menu");
	    b2.setBounds(800, 650, 410, 70);
	    b2.setFont(new Font("calibri", Font.BOLD, 50));
	    
	    b2.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		options op = new options ();
	    		op.setVisible(true);
	    		dispose ();
	    	}
	    });
	    
	    JButton b3 = new JButton ("EXIT");
	    b3.setBounds(800, 510, 410, 70);
	    b3.setFont(new Font("calibri", Font.BOLD, 50));
	    
	    b3.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		String cno2 = "truncate table tempcard";
    			try {
					stmt.executeUpdate(cno2);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
    			Homepage hp = new Homepage ();
    			hp.setVisible(true);
    			dispose();
	    	}
	    });
	    
	    try {
			String db_url = "jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(db_url, "pradeep","asdfgh");
			stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery("select cardno from tempcard");
			rs1.next();
			String cno = rs1.getString("cardno");
			//System.out.println (cno);
			ResultSet rs = stmt.executeQuery("select balance from accountdetails where card_no = "+cno);
			rs.next();
			String bal = rs.getString ("balance");
			//System.out.println (bal); 
			JLabel l1 = new JLabel();
			l1.setBounds(350, 350, 500, 100);
			l1.setFont(new Font("calibri", Font.BOLD, 100));
			l1.setText(bal);
			background.add(l1);
	    }
	    
	    catch(Exception a)
		{
			System.out.println(a);
		}

	    JLabel l2 = new JLabel ("Avilable Balance : ");
	    l2.setBounds(150, 180, 700, 100);
	    l2.setFont(new Font("calibri", Font.BOLD, 90));
	    
	    background.add(l2);
	    background.add(b3);
	    background.add(b2);
	    
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static void main (String[] args) {
		new showbalance();
	}

}
