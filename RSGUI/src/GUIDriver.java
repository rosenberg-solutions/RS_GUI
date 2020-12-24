import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class GUIDriver {

    public static void main(String[] args){

        //MyJPanel gui = new MyJPanel();
        //gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame frame = new JFrame();
        JTabbedPane tp = new JTabbedPane();
        HomeJPanel home = new HomeJPanel();
        frame.add(tp);
        tp.add("Home",home.getJPanel());

        frame.add(tp);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

