package atmdatabase;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Homepage extends JFrame {
	static Statement stmt;
	public Homepage(){
		JFrame f = new JFrame();
		setTitle ("ATM Michine");
	    setSize(1300, 960);
	    setLocationRelativeTo(null);
	    
	    JLabel background=new JLabel(new ImageIcon("C:/Users/wwwpr/Downloads/atmpic2.jpg"));
	    add(background);
	    
	    JButton b = new JButton ("ENTER");
	    b.setBounds(370, 500, 250, 60);
	    b.setFont(new Font("calibri", Font.BOLD, 50));
	    
	    JLabel l1 = new JLabel("Enter The CARD NUMBER");
	    l1.setBounds(170,150,900,80);
	    l1.setFont(new Font("calibri"  , Font.BOLD, 68));
	    
	    final JTextField tf1 = new JTextField ();
	    tf1.setBounds(250, 350, 500, 80);
	    tf1.setBackground (Color.LIGHT_GRAY);
	    tf1.setFont(new Font("calibri", Font.BOLD, 50));
	    
	    b.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		String cno;
	    		cno = tf1.getText();
	    		try {
	    			String db_url = "jdbc:oracle:thin:@localhost:1521:XE";
	    			Class.forName("oracle.jdbc.driver.OracleDriver");
	    			Connection con = DriverManager.getConnection(db_url, "pradeep","asdfgh");
	    			stmt = con.createStatement();
	    			ResultSet rs = stmt.executeQuery("select cardno from carddetails");
	    			int flag = 0;
	    			while(rs.next()) {
	    				String cno1 = rs.getString("cardno");
	    				if (cno.equals(cno1)) {
	    					flag = 1;
	    					options op = new options ();
	    		    		op.setVisible(true);
	    				}
	    			}
	    			if (flag == 0) {
	    				failure1 f1 = new failure1();
	    				f1.setVisible(true);
	    				con.close();
	    				stmt.close();
	    			}
	    			String cno2 = "insert into tempcard values (\'"+tf1.getText()+"\')";
	    			stmt.executeUpdate(cno2);
	    		}
	    		catch(Exception a)
				{
					System.out.println(a);
				}

	    		dispose ();
	    	}
	    });
	    
	    background.add(b);
	    background.add(l1);
	    background.add(tf1);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main (String[] args) {
		new Homepage();
	}

}
