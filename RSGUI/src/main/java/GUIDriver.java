package main.java;

import javax.swing.*;

import org.json.JSONArray;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;



public class GUIDriver {

    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setBounds(250, 250, 1000, 800);
        JTabbedPane tp = new JTabbedPane();
        tp.setBackground(Color.BLACK);
        HomeJPanel home = new HomeJPanel();
        SimulationJPanel simulation = new SimulationJPanel();
        WindJPanel wind = new WindJPanel();
        WindfarmJPanel windfarm = new WindfarmJPanel();
        WriteJPanel write = new WriteJPanel();
        ReviewJPanel review = new ReviewJPanel();

        JButton submit = new JButton("Write File");
        submit.setBounds(100, 600, 100, 100);
        frame.add(submit);
        frame.add(tp);
        tp.add("Home", home.getJPanel());
        tp.add("Simulation", simulation.getJPanel());
        tp.add("Wind", wind.getJPanel());
        tp.add("Write", write.getJPanel());
        tp.add("Wind Farm ", windfarm.getJPanel());
        tp.add("Review File", review.getJPanel());


        frame.add(tp);


        submit.addActionListener(e -> {

            JSONArray windFarm_x1 = new JSONArray();
            //creating a Json array to put in json objects for file
            windFarm_x1.put(HomeJPanel.getFiletypeObject());
            windFarm_x1.put(SimulationJPanel.getSimulationObject());
            windFarm_x1.put(WindJPanel.getWindObject());
            windFarm_x1.put(WriteJPanel.getWriteObject());
            try ( FileWriter  file1 = new FileWriter("test.json")){
                System.out.println("Hi I am in try");
                file1.write(windFarm_x1.toString());
                file1.flush();
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

