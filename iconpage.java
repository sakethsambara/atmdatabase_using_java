package atmdatabase;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class iconpage extends JFrame {
	
iconpage(){
		
		JFrame f = new JFrame();
		setTitle ("ATM Michine");
	    setSize(800, 700);
	    setLocationRelativeTo(null);
	    
	    JButton l = new JButton ("Click here to Enter CARD");
	    l.setBounds(150, 100, 600, 60);
	    l.setFont(new Font("calibri", Font.BOLD, 40));
	    
	    Icon icon = new ImageIcon("C:/Users/wwwpr/Downloads/atmpic4.jpg");
	    JButton b = new JButton (icon);
	    b.setBounds(200, 200, 500, 500);
	    add(l);
	    add(b);
	    
	    b.addActionListener(new ActionListener () {
	    	public void actionPerformed (ActionEvent e) {
	    		Homepage hp = new Homepage ();
	    		hp.setVisible(true);
	    		dispose ();
	    	}
	    });
	 
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main (String[] args) {
		new iconpage();
	}

}
