/**
 * My JPanel Class will implement the GUI and allow user
 * to input user information
 */

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.plaf.FontUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeJPanel extends JFrame {

    static private JFrame f;
    static private JPanel p;
    static private JTabbedPane t;
    static private JButton b;


    /**
     * Constructor initializes panel
     */
    HomeJPanel(){

    };

     JPanel getJPanel(){
        setLayout(null);
        setBounds(100,100, 800,800 );
        p = new JPanel();
        b = new JButton("hell0");
        p.add(b);
        p.setBounds(400,400,200,200);
        return  p;
   }


}
