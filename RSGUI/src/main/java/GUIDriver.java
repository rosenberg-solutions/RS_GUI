package main.java;

import javax.swing.*;

import org.json.JSONArray;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;



public class GUIDriver {

    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setBounds(250, 250, 800, 800);
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

        //writing file with user clicks the submit button
        submit.addActionListener(e -> {
            // FileWriter  file1 = new FileWriter(home.getFileName());
            JSONArray windFarm_x1 = new JSONArray();

            //file1.write(HomeJPanel.getFiletype().toString());
            //file1.write(SimulationJPanel.getSimulation().toString());

            windFarm_x1.put(HomeJPanel.getFiletypeObject());
            windFarm_x1.put(SimulationJPanel.getSimulationObject());
            windFarm_x1.put(WindJPanel.getWindObject());
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
