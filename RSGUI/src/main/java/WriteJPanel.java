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

    public static JSONObject getWrite() {
        return write;
    }

    public static void setWrite(JSONObject write) {
        WriteJPanel.write = write;
    }

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

        // True or false Radio Buttons
        JRadioButton trueButton = new JRadioButton("true");
        trueButton.setBounds(350,125,100,100);
        JRadioButton falseButton = new JRadioButton("false");
        falseButton.setBounds(400,125,100,100);

        //creating a button group that only allows one button to be clicked from the group
        ButtonGroup group = new ButtonGroup();
        group.add(trueButton);
        group.add(falseButton);
        p.add(trueButton);
        p.add(falseButton);






        // latticeWrite
        latticeWrite = new JLabel("LatticeWrite");
        latticeWrite.setBounds(200,200, 100,50);
        // True or false Radio Buttons
        JRadioButton trueButton1 = new JRadioButton("true");
        trueButton1.setBounds(350,175,100,100);
        JRadioButton falseButton1 = new JRadioButton("false");
        falseButton1.setBounds(400,175,100,100);
        //creating a button group that only allows one button to be clicked from the group
        ButtonGroup group1 = new ButtonGroup();
        group1.add(trueButton1);
        group1.add(falseButton1);
        p.add(trueButton1);
        p.add(falseButton1);


        //dt1
        dt1 = new JLabel("dt");
        dt1.setBounds(200,250,100,50);
        dt1Field = new JTextField(15);
        dt1Field.setBounds(350,250,100,30);


        //infCoeffWrite
        infCoeffWrite = new JLabel("infCoeffWrite");
        infCoeffWrite.setBounds(200,300,150,30);
        JRadioButton trueButton2 = new JRadioButton("true");
        trueButton2.setBounds(350,275,100,100);
        JRadioButton falseButton2 = new JRadioButton("false");
        falseButton2.setBounds(400,275,100,100);
        ButtonGroup group2 = new ButtonGroup();
        group2.add(trueButton2);
        group2.add(falseButton2);
        p.add(trueButton2);
        p.add(falseButton2);

        //CPWrite
        CPWrite = new JLabel("CP_WRite ");
        CPWrite.setBounds(200,350,100,30);
        JRadioButton trueButton3 = new JRadioButton("true");
        trueButton3.setBounds(350,325,100,100);
        JRadioButton falseButton3 = new JRadioButton("false");
        falseButton3.setBounds(400,325,100,100);
        ButtonGroup group3= new ButtonGroup();
        group3.add(trueButton3);
        group3.add(falseButton3);
        p.add(trueButton3);
        p.add(falseButton3);


        //indVelWrite
        indVelWrite  = new JLabel("IndVelWrite ");
        indVelWrite.setBounds(200,400,100,30);
        JRadioButton trueButton4 = new JRadioButton("true");
        trueButton4.setBounds(350,375,100,100);
        JRadioButton falseButton4 = new JRadioButton("false");
        falseButton4.setBounds(400,375,100,100);
        ButtonGroup group4= new ButtonGroup();
        group4.add(trueButton4);
        group4.add(falseButton4);
        p.add(trueButton4);
        p.add(falseButton4);

        //elemVelWrite
        elemVelWrite  = new JLabel("elemVelWrite ");
        elemVelWrite.setBounds(200,450,100,30);
        JRadioButton trueButton5 = new JRadioButton("true");
        trueButton5.setBounds(350,425,100,100);
        JRadioButton falseButton5 = new JRadioButton("false");
        falseButton5.setBounds(400,425,100,100);
        ButtonGroup group5= new ButtonGroup();
        group5.add(trueButton5);
        group5.add(falseButton5);
        p.add(trueButton5);
        p.add(falseButton5);

        pack();


        //Save button
         save = new JButton("Save");
         save.setBounds(700,570,100,50);
         save.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 //creating JSON objects from user input
                 write = new JSONObject();
                 writeObject = new JSONObject();

                 write.put("output_directory",output_directoryField.getText());
                 write.put("dt", dt1Field.getText());
                 write.put("bladeWrite",group.getSelection().getActionCommand());
                 write.put("latticeWrite",group1.getSelection().getActionCommand());
                 write.put("infCoeffWrite",group2.getSelection().getActionCommand());
                 write.put("CP_Write",group3.getSelection().getActionCommand());
                 write.put("indVelWrite",group4.getSelection().getActionCommand());
                 write.put("elemVelWrite",group5.getSelection().getActionCommand());

               // writeObject.put("write",write);
                System.out.println(write);



             }
         });


        p.add(output_directory);
        p.add(output_directoryField);
        p.add(bladeWrite);
        p.add(latticeWrite);
        p.add(dt1);
        p.add(dt1Field);
        p.add(infCoeffWrite);
        p.add(CPWrite);
        p.add(indVelWrite);
        p.add(elemVelWrite);
        p.add(save);

        return  p;
    }


}
