/**
 * My JPanel Class will implement the GUI and allow user
 * to input user information
 */

import org.json.JSONObject;

import javax.swing.*;

import javax.swing.JFrame;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileWriter;
import java.io.IOException;

public class HomeJPanel extends JFrame  implements ActionListener{


    static private JPanel p;
    static private JButton saveButton;
    static private JLabel nameLabel, versionLabel;
    static private JTextField nameField;
    static private JComboBox<String> versionCombobox;
    static private String[] versionString = new String[]{ "0.0.1","0.0.2", "0.0.3 "};


     JPanel getJPanel(){
        setLayout(null);
        setBounds(100,100, 800,800 );
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(100,700,200,200);



        nameLabel = new JLabel(" File Name");
        nameLabel.setBounds(100, 190, 100,50);
        nameField = new JTextField(15);
        nameField.setBounds(200,200,200,30);


        versionLabel = new JLabel("GAVLL Version");
        versionLabel.setBounds(100, 240,100,50);
        versionCombobox = new JComboBox<String>(versionString);
        versionCombobox.setBounds(200,250, 200,25);


         saveButton = new JButton("save");
         saveButton.setBounds(450,240,50,50);
         saveButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 JSONObject filetype = new JSONObject();
                 filetype.put("name",nameField.getText());
                 filetype.put("version",versionCombobox.getSelectedItem());
                 try {
                     FileWriter file = new FileWriter(nameField.getName() + ".JSON");
                     file.write(filetype.toString());
                     System.out.print(filetype);
                     file.flush();
                 }catch(IOException e1 ){
                        e1.printStackTrace();
                        System.out.print(" error in creating file");
                 }
             }
         });


        p.add(nameLabel);
        p.add(nameField);
        p.add(versionLabel);
        p.add(versionCombobox);
        p.add(saveButton);
        p.add(versionLabel);
        return  p;
   }


    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
