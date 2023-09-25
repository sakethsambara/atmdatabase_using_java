package atmdatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class failure2 extends JFrame{
	static Statement stmt;
	public failure2 () {
		JFrame f = new JFrame();
		setTitle ("ATM Michine");
	    setSize(1300, 960);
	    setLocationRelativeTo(null);
	    
	    JLabel background=new JLabel(new ImageIcon("C:/Users/wwwpr/Downloads/atmpic2.jpg"));
	    add(background);
		
		JLabel l1 = new JLabel ("Transaction Unsucsessful");
		l1.setBounds(130, 120, 900, 100);
	    l1.setFont(new Font("calibri", Font.BOLD, 70));
	    
	    JLabel l2 = new JLabel ("Invalid PIN Number");
	    l2.setBounds (120, 280, 900, 100);
	    l2.setFont(new Font("calibri", Font.BOLD, 80));
	    
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
	    
	    JButton b1 = new JButton ("EXIT");
		b1.setBounds(330, 450, 360, 60);
	    b1.setFont(new Font("calibri", Font.BOLD, 50));

		b1.addActionListener(new ActionListener () {
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
	    
	    background.add(l1);
	    background.add(l2);
	    background.add(b1);
	    setVisible (true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main (String[] args) {
		new failure2();
	}
}
