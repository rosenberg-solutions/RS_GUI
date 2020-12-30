package main.java;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WriteJPanel extends JFrame {
    static private JPanel p;
    static private JButton save;
    static private JLabel output_directory, dt1, bladeWrite, latticeWrite, infCoeffWrite, CPWrite, indVelWrite,elemVelWrite;
    static private JTextField output_directoryField, dt1Field, bladeWriteField, latticeWriteField, infCoeffWriteField, CPWriteField, indVelWriteField,elemVelWriteField;
    static private JSONObject write;
    static private String[] trueFalse = new String[]{"True","False"};
    static private JComboBox<String> bladewriteBox, latticeWriteBox,infCoeffWriteBox,CPWriteBox,indVelWriteBox,elemVelWriteBox;
    public static JSONObject getWriteObject() {
        return writeObject;
    }

    public static void setWriteObject(JSONObject writeObject) {
        WriteJPanel.writeObject = writeObject;
    }

    static private JSONObject writeObject;
    JPanel getJPanel(){

        setBounds(100,100, 800,800 );
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(400,400,200,200);

        //output_directory
        output_directory = new JLabel("Output_Directory");
        output_directory.setBounds(200,100,200,50);
        output_directoryField = new JTextField(15);
        output_directoryField.setBounds(350, 100, 200,30);
        //bladeWrite
        bladeWrite = new JLabel("bladeWrite");
        bladeWrite.setBounds(200,150,100,50);
        bladewriteBox= new JComboBox<String>(trueFalse);
        bladewriteBox.setBounds(350,150, 100,30);

        // latticeWrite
        latticeWrite = new JLabel("LatticeWrite");
        latticeWrite.setBounds(200,200, 100,50);
        latticeWriteBox= new JComboBox<String>(trueFalse);
        latticeWriteBox.setBounds(350,200, 100,30);

        //dt1
        dt1 = new JLabel("dt");
        dt1.setBounds(200,250,100,50);
        dt1Field = new JTextField(15);
        dt1Field.setBounds(350,250,100,30);


        //infCoeffWrite
        infCoeffWrite = new JLabel("infCoeffWrite");
        infCoeffWrite.setBounds(200,300,150,30);
        infCoeffWriteBox= new JComboBox<String>(trueFalse);
        infCoeffWriteBox.setBounds(350,300, 100,30);

        //CPWrite
        CPWrite = new JLabel("CP_WRite ");
        CPWrite.setBounds(200,350,100,30);
        CPWriteBox= new JComboBox<String>(trueFalse);
        CPWriteBox.setBounds(350,350, 100,30);

        //indVelWrite
        indVelWrite  = new JLabel("IndVelWrite ");
        indVelWrite.setBounds(200,400,100,30);
        indVelWriteBox= new JComboBox<String>(trueFalse);
        indVelWriteBox.setBounds(350,400, 100,30);

        //elemVelWrite
        elemVelWrite  = new JLabel("IndVelWrite ");
        elemVelWrite.setBounds(200,450,100,30);
        elemVelWriteBox= new JComboBox<String>(trueFalse);
        elemVelWriteBox.setBounds(350,450, 100,30);

        //Save button
         save = new JButton("Save");
         save.setBounds(500,600,100,30);
         save.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 //creating JSON objects from user input
                 write = new JSONObject();
                 writeObject = new JSONObject();
                 write.put("output_directory",output_directoryField.getText());
                 write.put("dt", dt1Field.getText());
                 write.put("bladeWrite",bladewriteBox.getSelectedItem());
                 write.put("latticeWrite",latticeWriteBox.getSelectedItem());
                 write.put("infCoeffWrite",infCoeffWriteBox.getSelectedItem());
                 write.put("indVelWrite",indVelWriteBox.getSelectedItem());
                 write.put("elemVelWrite",elemVelWriteBox.getSelectedItem());

                writeObject.put("write",write);
                System.out.println(writeObject);



             }
         });


        p.add(output_directory);
        p.add(output_directoryField);
        p.add(bladeWrite);
        p.add(bladewriteBox);
        p.add(latticeWrite);
        p.add(latticeWriteBox);
        p.add(dt1);
        p.add(dt1Field);
        p.add(infCoeffWrite);
        p.add(infCoeffWriteBox);
        p.add(CPWrite);
        p.add(CPWriteBox);
        p.add(indVelWrite);
        p.add(indVelWriteBox);
        p.add(elemVelWrite);
        p.add(elemVelWriteBox);
        p.add(save);

        return  p;
    }


}
