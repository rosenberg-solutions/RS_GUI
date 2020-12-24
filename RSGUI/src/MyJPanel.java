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

public class MyJPanel extends JFrame {

    private JFrame f;
    private JPanel p;
    private JTabbedPane t;


    /**
     * Constructor initializes panel
     */
    MyJPanel(){

        setTitle("Rosenberg Solutions ");
        setLayout(null);
        setBounds(100,100, 800,800 );
        p = new JPanel();
        add(p);

        p.setBounds(400,400,200,200);
        setVisible(true);

    };


}
