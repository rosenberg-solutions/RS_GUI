package main.java;

import javax.swing.*;
import org.json.JSONObject;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JsonObject;


public class GUIDriver {

    public static void main(String[] args){


        JFrame frame = new JFrame();
        frame.setBounds(250,250,800,800);
        JTabbedPane tp = new JTabbedPane();
        tp.setBackground(Color.BLACK);
        HomeJPanel home = new HomeJPanel();
        SimulationJPanel simulation = new SimulationJPanel();
        WindJPanel wind = new WindJPanel();
        WindfarmJPanel windfarm = new WindfarmJPanel();
        WriteJPanel write = new WriteJPanel();
        ReviewJPanel review = new ReviewJPanel();
        FileWriter file;



        frame.add(tp);
        tp.add("Home",home.getJPanel());
        tp.add("Simulation",simulation.getJPanel());
        tp.add("Wind",wind.getJPanel());
        tp.add("Write",write.getJPanel());
        tp.add("Wind Farm ",windfarm.getJPanel());
        tp.add("Review File",review.getJPanel());


        frame.add(tp);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //writing to JSON file create boolean for this
        if (review.isDone()) {
            System.out.println("Hi I am in try");
            try {
                System.out.println("Hi I am in try");
                file = new FileWriter(home.getFileName());
                file.write(HomeJPanel.getFiletype().toString());
                file.write(SimulationJPanel.getSimulation().toString());
                file.flush();
                file.close();
                System.out.print(file);

            } catch (IOException e) {
                e.printStackTrace();
                System.out.print("Error in Creating JSON File");

            }

            System.out.println(review.isDone());
        }

        }
}

