package main.java;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.json.JSONObject;
public class SimulationJPanel extends JFrame implements ActionListener {

    static private JPanel p;
    static private JButton save;
    static private JLabel DOE, DOEFile, timeStart, timeEnd, dt, relaxationFactor;
    static private JTextField DOEFileField, timeStartField, timeEndField, dtField, relaxationFactorField;
    static private String[] trueFalse = new String[]{"True","False"};
    static private JComboBox<String>TF;

    public static JSONObject getSimulation() {
        return simulation;
    }

    public static void setSimulation(JSONObject simulation) {
        SimulationJPanel.simulation = simulation;
    }

    static private JSONObject  simulation;

    public static JSONObject getSimulationObject() {
        return simulationObject;
    }

    public static void setSimulationObject(JSONObject simulationObject) {
        SimulationJPanel.simulationObject = simulationObject;
    }

    private static JSONObject simulationObject;

    /**
     * getpanel returns the panel with gui components and will be called in main Driver
     * @return
     */
    JPanel getJPanel(){
        setLayout(null);
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
        timeStartField.setBounds(350,250, 100,30);

        // End time
        timeEnd = new JLabel(" Time End  (0.0)");
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

                }
                if(TF.getSelectedItem() =="True"){
                    //create dEO file

                }

            }
        });

        //save button
        save = new JButton("save");
        save.setBounds(350,450,100,30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulation = new JSONObject();
                simulation.put("DOE", TF.getSelectedItem());
                simulation.put("DOE_File", DOEFileField.getText());
                simulation.put("timeStart",timeStartField.getText());
                simulation.put("timeEnd",timeEndField.getText());
                simulation.put("dt",dtField.getText());
                simulation.put("relaxation_factor",relaxationFactorField.getText());

                simulationObject =new JSONObject();
                simulationObject.put("simulation",simulation);

                System.out.println(simulationObject);
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
        p.add(save);
        return  p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
