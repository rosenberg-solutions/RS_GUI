import javax.swing.*;

public class WindfarmJPanel extends JFrame {

    static private JPanel p;

    JPanel getJPanel(){

        setLayout(null);
        setBounds(100,100, 800,800 );
        p = new JPanel();
        p.setBounds(400,400,200,200);
        return  p;
    }
}
