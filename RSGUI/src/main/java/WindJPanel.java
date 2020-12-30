package main.java;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindJPanel extends JFrame {

    static private JPanel p;
    static private JLabel type, shear, u_mean, h_ref, rho, direction, X, Y, Z;
    static private JTextField  shearField, u_meanField, h_refField, rhoField, directionField, xField, yField, zField;
    static private String[] typeWind = new String[]{"Deterministic", " other types "};
    static private JComboBox<String> types;
    static private JButton save;
    static private JSONObject wind;

    public static JSONObject getWindObject() {
        return windObject;
    }

    public static void setWindObject(JSONObject windObject) {
        WindJPanel.windObject = windObject;
    }

    static private JSONObject windObject;
    static private JSONArray coordinates;


    JPanel getJPanel(){

        setBounds(100,100, 800,800 );
        p = new JPanel();
        p.setBounds(400,400,200,200);
        p.setLayout(null);

        type = new JLabel("Type");
        type.setBounds(200,100,100,50);
        types= new JComboBox<String>(typeWind);
        types.setBounds(350,100,200,50);


        //shear
        shear = new JLabel("Shear");
        shear.setBounds(200,190, 100,50);
        shearField = new JTextField(30);
        shearField.setBounds(350, 200, 200,30);

        //u_mean
        u_mean = new JLabel("U_mean");
        u_mean.setBounds(200,250,100,50);
        u_meanField = new JTextField(15);
        u_meanField.setBounds(350,250, 150,30);

        // rho
        rho = new JLabel("Rho");
        rho.setBounds(200,300, 100,50);
        rhoField = new JTextField(15);
        rhoField.setBounds(350,300, 100,30);

        //h_ref
        h_ref = new JLabel("H_ref");
        h_ref.setBounds(200,350,100,50);
        h_refField = new JTextField(15);
        h_refField.setBounds(350,350,100,30);

        //direction make json array
        direction = new JLabel("Direction");
        direction.setBounds(200,400,150,30);
        directionField = new JTextField(15);
        //directionField.setBounds(350,400,100,30);

        //separate GUI field for getting direction coordinates
        X = new JLabel("X_Coordinate");
        X.setBounds(350,400,100,30);
        xField = new JTextField(10);
        xField.setBounds(450,400,100,30);

        Y = new JLabel("Y_Coordinate");
        Y.setBounds(350,420,100,30);
        yField = new JTextField(10);
        yField.setBounds(450,420,100,30);

        Z = new JLabel("Z_Coordinate");
        Z.setBounds(350,440,100,30);
        zField = new JTextField(10);
        zField.setBounds(450,440,100,30);

        //save button
        save = new JButton("Save");
        save.setBounds(300,600,100,50);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                wind = new JSONObject();
                coordinates = new JSONArray();
                windObject = new JSONObject();
                wind.put("type",types.getSelectedItem());
                wind.put("shear",shearField.getText());
                wind.put("u_mean", u_meanField.getText());
                wind.put("h_ref",h_refField.getText());
                wind.put("rho",rhoField.getText());

                //creating a Json array for direction coordinates

                coordinates.put(xField.getText());
                coordinates.put(yField.getText());
                coordinates.put(zField.getText());
                wind.put("direction",coordinates);

                //adding all Json objects to json array windObject
                windObject.put("wind", wind);
                System.out.println(windObject);
            }
        });

        p.add(type);
        p.add(types);
        p.add(shear);
        p.add(shearField);
        p.add(u_mean);
        p.add(u_meanField);
        p.add(rho);
        p.add(rhoField);
        p.add(h_ref);
        p.add(h_refField);
        p.add(direction);
        //p.add(directionField);
        p.add(save);
        p.add(X);
        p.add(xField);
        p.add(Y);
        p.add(yField);
        p.add(Z);
        p.add(zField);




        return  p;
    }
}
