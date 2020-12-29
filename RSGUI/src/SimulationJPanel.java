import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.json.JSONObject;
public class SimulationJPanel extends JFrame implements ActionListener {

    static private JPanel p;
    static private JLabel DOE, DOEFile, timeStart, timeEnd, dt, relaxationFactor;
    static private JTextField DOEFileField, timeStartField, timeEndField, dtField, relaxationFactorField;
    static private String[] trueFalse = new String[]{"True","False"};
    static private JComboBox<String>TF;

    /**
     * getpanel returns the panel with gui components and will be called in main Driver
     * @return
     */
    JPanel getJPanel(){
        setBounds(100,100, 800,800 );
        //panel
        p = new JPanel();
        p.setBounds(400,400,200,200);
        p.setLayout(null);

        //DOE File
        DOE = new JLabel("DOE");
        DOE.setBounds(200,100,100,50);


        //DOE FileName
        DOEFile = new JLabel("DOE File Name");
        DOEFile.setBounds(200,190, 100,50);
        DOEFileField = new JTextField(30);
        DOEFileField.setBounds(350, 200, 200,30);
        //Start time

        timeStart = new JLabel("Time Start (0.0)");
        timeStart.setBounds(200,250,100,50);
        timeStartField = new JTextField(15);
        timeStartField.setBounds(350,250, 150,30);

        // End time
        timeEnd = new JLabel("Time  (0.0)");
        timeEnd.setBounds(200,300, 100,50);
        timeEndField = new JTextField(15);
        timeEndField.setBounds(350,300, 100,30);

        //dt
        dt = new JLabel("dt (0.0)");
        dt.setBounds(200,350,100,50);
        dtField = new JTextField(15);
        dtField.setBounds(350,350,100,30);

        //relaxation Factor
        relaxationFactor = new JLabel("Relaxation Factor (0.0)");
        relaxationFactor.setBounds(200,400,150,30);
        relaxationFactorField = new JTextField(15);
        relaxationFactorField.setBounds(350,400,100,30);


        // True or false Combobox
        TF = new JComboBox<String>(trueFalse);
        TF.setBounds(250,100,100,50);
        TF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TF.getSelectedItem() =="False"){
                    DOEFileField.setEditable(false);
                    DOEFileField.setEditable(false);
                    timeStartField.setEditable(false);
                    timeEndField.setEditable(false);
                    relaxationFactorField.setEditable(false);

                }
                if(TF.getSelectedItem() =="True"){

                    DOEFileField.setEditable(true);
                    DOEFileField.setEditable(true);
                    timeStartField.setEditable(true);
                    timeEndField.setEditable(true);
                    relaxationFactorField.setEditable(true);




                }

            }
        });


        //adding components to panel
        p.add(DOE);
        p.add(TF);
        p.add(DOEFile);
        p.add(DOEFileField);
        p.add(timeStart);
        p.add(timeStartField);
        p.add(timeEnd);
        p.add(timeEndField);
        p.add(dt);
        p.add(dtField);
        p.add(relaxationFactor);
        p.add(relaxationFactorField);
        return  p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
