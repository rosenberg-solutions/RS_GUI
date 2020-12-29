import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class GUIDriver {

    public static void main(String[] args){

        //MyJPanel gui = new MyJPanel();
        //gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame frame = new JFrame();
        frame.setBounds(250,250,800,800);
        JTabbedPane tp = new JTabbedPane();
        tp.setBackground(Color.BLACK);
        HomeJPanel home = new HomeJPanel();
        SimulationJPanel simulation = new SimulationJPanel();
        WindJPanel wind = new WindJPanel();
        WindfarmJPanel windfarm = new WindfarmJPanel();
        WriteJPanel write = new WriteJPanel();

        frame.add(tp);
        tp.add("Home",home.getJPanel());
        tp.add("Simulation",simulation.getJPanel());
        tp.add("Wind",wind.getJPanel());
        tp.add("Write",write.getJPanel());
        tp.add("Wind Farm ",windfarm.getJPanel());


        frame.add(tp);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

