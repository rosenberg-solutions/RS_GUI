package main.java;

import javax.swing.*;

import org.json.JSONArray;
import org.json.JSONObject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;



public class GUIDriver {

    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setBounds(250, 250, 1000, 800);
        JTabbedPane tp = new JTabbedPane();

        HomeJPanel home = new HomeJPanel();
        SimulationJPanel simulation = new SimulationJPanel();
        WindJPanel wind = new WindJPanel();
        WindfarmJPanel windfarm = new WindfarmJPanel();
        WriteJPanel write = new WriteJPanel();
        ReviewJPanel review = new ReviewJPanel();

        //Adding components to all tab pages
        JButton writeFile = new JButton("Write File");
        writeFile.setBounds(100, 600, 100, 50);

        JLabel nameLabel = new JLabel(" File Name");
        nameLabel.setBounds(100, 35, 100,50);

        JTextField nameField = new JTextField("",15);
        nameField.setBounds(200,50,200,30);
        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String fileName = nameField.getName();
            }
        });


        String[] versionString = new String[]{ "0.0.1","0.0.2", "0.0.3 "};
        JLabel versionLabel = new JLabel("GAVLL Version");
        versionLabel.setBounds(500, 35,100,50);
        JComboBox versionCombobox = new JComboBox<String>(versionString);
        versionCombobox.setBounds(600,50, 200,25);
        JSONObject filetype = new JSONObject();


//        JButton saveButton = new JButton("save");
//        saveButton.setBounds(800,600,75,25);
//        saveButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                filetype.put("name",nameField.getText());
//                filetype.put("version", versionCombobox.getSelectedItem());
//                versionCombobox.getSelectedItem();
//                System.out.println(filetype);
//            }
//        });

        
        frame.add(writeFile);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(versionLabel);
        frame.add(versionCombobox);
        //frame.add(saveButton);
        frame.add(versionLabel);
        frame.add(tp);
       // tp.add("Home", home.getJPanel());
        tp.add("Simulation", simulation.getJPanel());
        tp.add("Wind", wind.getJPanel());
        tp.add("Write", write.getJPanel());
        tp.add("Turbine", windfarm.getJPanel());
        tp.add("Review File", review.getJPanel());
        
        frame.add(tp);


        writeFile.addActionListener(e -> {

            JSONObject windFarm_x1 = new JSONObject();
            //creating a Json array to put in json objects for file

            windFarm_x1.put("FileType",filetype);
            windFarm_x1.put("Simulation",SimulationJPanel.getSimulation());
            windFarm_x1.put("Wind",WindJPanel.getWind());
            windFarm_x1.put("Write",WriteJPanel.getWrite());



            try ( FileWriter  file1 = new FileWriter("test.json")){
                System.out.println("Hi I am in try");
                file1.write(windFarm_x1.toString());
                file1.flush();
               // file1.close();
                System.out.print(file1);

            } catch (IOException e1) {
                System.out.print("Error in Creating JSON File");
                e1.printStackTrace();
            }

            System.out.println(review.isDone());

        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}

