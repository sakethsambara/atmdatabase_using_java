package atmdatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class failure1 extends JFrame {
	public failure1 () {
		JFrame f = new JFrame();
	    setSize(1300, 960);
	    setTitle ("ATM Michine");
	    setLocationRelativeTo(null);
	    
	    JLabel background=new JLabel(new ImageIcon("C:/Users/wwwpr/Downloads/atmpic2.jpg"));
	    add(background);
		
		JLabel l1 = new JLabel ("Unidentified Card");
	    l1.setBounds(230, 120, 900, 100);
	    l1.setFont(new Font("calibri", Font.BOLD, 80));
	    
	    JLabel l2= new JLabel ("Please Try Again");
	    l2.setBounds(230, 280, 900, 100);
	    l2.setFont(new Font("calibri", Font.BOLD, 80));
	    
	    JButton b = new JButton ("Home");
	    b.setBounds(330, 450, 250, 60);
	    b.setFont(new Font("calibri", Font.BOLD, 40));
	    
	    b.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		Homepage hp = new Homepage ();
	    		hp.setVisible(true);
	    		dispose ();
	    	}
	    });
	    
	    background.add(l1);
	    background.add(l2);
	    background.add(b);
	    setVisible (true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main (String[] args) {
		new failure1();
	}

}
