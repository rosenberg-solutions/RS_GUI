package main.java;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.json.JSONObject;
public class WindfarmJPanel extends JFrame {

    static private JPanel p;
    static private JButton add;
    static private JLabel numTurbine, turbineLabel, idLabel, xlabel,rmpLabel, pitchLabel, fileLabel, initIndDistLabel, initInductionLabel,nRotLabel, rot_trefftzLabel;
    private int countTurbine =0;
    static private JSONObject windFarmObject, n_turbines, turbines, ID, X, rpm, pitch, outputFile, initIndDist, initInduction, nRot, rot_trefftz;
    static private JTable windTable;
    //final private String columnNames[] = {"n_turbine","ID","X","rpm","pitch","input_file","initIndDist","initInduction","nRot","rot_treet"};
   //static private String data[][]= {{"1","0","0,0,0","12.0","0.0","outputPath/file","linear", "4.0","0.1","0.9"}
    //,{"2", "0","0,0,0","12.0","0.0","outputPath/file","linear", "4.0","0.1","0.9"}};
    static private JScrollPane scrollTable;
    JPanel getJPanel(){


        setBounds(100,100, 800,800 );
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(400,400,200,200);


        //add button to add multiple turbine
        add = new JButton("Add Turbine");
        add.setBounds(350,50,125,30);
        turbineLabel = new JLabel("Number of Turbines: " + Integer.toString(countTurbine));
        turbineLabel.setBounds(200,50,150,30);

        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("n_turbines");
        model.addColumn("ID");
        model.addColumn("x");
        model.addColumn("rpm");
        model.addColumn("pitch");
        model.addColumn("Output File ");
        model.addColumn("initIndDist");
        model.addColumn("initInduction");
        model.addColumn("nRot");
        model.addColumn("rot_trefftz");
        windTable = new JTable(model);

        scrollTable =new JScrollPane(windTable);
        scrollTable.setBounds(200,200,700,400);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countTurbine = countTurbine +1;
                turbineLabel.setText("Number of Turbines: " + Integer.toString(countTurbine));
                model.addRow(new Object[]{Integer.toString(countTurbine), "null","null","null ","null ","null","null "," null","null","null"});
            }
        });

        windFarmObject = new JSONObject();
        windFarmObject.put("n_turbines", countTurbine);

        p.add(add);
        p.add(turbineLabel);
        p.add(scrollTable);

        return  p;
    }


}
