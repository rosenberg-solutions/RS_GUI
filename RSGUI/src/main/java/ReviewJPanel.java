package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewJPanel extends JFrame {

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    private boolean done;
    static private JPanel p;
    private JButton submit;

    JPanel getJPanel() {
        setLayout(null);
        setBounds(100, 100, 800, 800);
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(100, 700, 200, 200);

        submit = new JButton("Submit");
        submit.setBounds(100,100,100,50);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDone(true);
            }
        });

        p.add(submit);

        return p;

    }



}
