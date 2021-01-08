package main.java;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
public class WindfarmJPanel extends JFrame {

    static private JPanel p;
    static private JButton add, save;
    static private JLabel numTurbine, turbineLabel, idLabel, xlabel,rmpLabel, pitchLabel, fileLabel, initIndDistLabel, initInductionLabel,nRotLabel, rot_trefftzLabel;
    private int countTurbine =0;
    static private JSONObject windFarmObject,turbine, n_turbines, ID, X, rpm, pitch, outputFile, initIndDist, initInduction, nRot, rot_trefftz;
    static private JTable windTable;
    static private JScrollPane scrollTable;
    static private JComboBox<String> turbineComboBox;
    static private String[] optionTurbine = {"Turbine1", "Turbine2", "Turbine3", "Turbine4","Turbine5"};
    //static private JSONArray turbine;
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
        save = new JButton( "save");
        save.setBounds(500,650,100,30);

        //Creating a table for turbine input data
        DefaultTableModel model= new DefaultTableModel(); //this default will allow rows to be added
        model.addColumn("n_turbines");
        model.addColumn("ID");
        model.addColumn("x");
        model.addColumn("rpm");
        model.addColumn("pitch");
        model.addColumn("Input File ");
        model.addColumn("initIndDist");
        model.addColumn("initInduction");
        model.addColumn("nRot");
        model.addColumn("rot_trefftz");

        turbineComboBox = new JComboBox<>(optionTurbine);
        windTable = new JTable(model);
        scrollTable =new JScrollPane(windTable);
        scrollTable.setBounds(200,200,700,400);
        TableColumn fileColumn = windTable.getColumnModel().getColumn(5);
        fileColumn.setCellEditor(new DefaultCellEditor(turbineComboBox));


        windFarmObject = new JSONObject();
        windFarmObject.put("n_turbines", countTurbine);



        //adds rows to JTable each row represents a n_turbine
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countTurbine = countTurbine +1;
                turbineLabel.setText("Number of Turbines: " + Integer.toString(countTurbine));
                model.addRow(new Object[]{Integer.toString(countTurbine), "0","0","0 ","0"," ","0","0","0","0"});
            }
        });
        //saving the data from the JTable into new JSON Objects.
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //need to access each element int the table and put into JSON array.
              //  windFarmObject.put("turbine", model.getDataVector().elementAt(windTable.getSelectedRow()));
              turbine  = new JSONObject();
                turbine.put(("ID"),model.getValueAt(0,1));
                turbine.put(("X"),model.getValueAt(0,2));

                System.out.println(turbine);
            }
        });

        windFarmObject.put("turbine",turbine);
        System.out.println(windFarmObject);
        p.add(add);
        p.add(turbineLabel);
        p.add(scrollTable);
        p.add(save);

        return  p;
    }


}
