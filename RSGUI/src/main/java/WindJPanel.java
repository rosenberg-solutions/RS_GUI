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

    public static JSONObject getWind() {
        return wind;
    }

    public static void setWind(JSONObject wind) {
        WindJPanel.wind = wind;
    }

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
        types.setBounds(450,100,200,50);


        //shear
        shear = new JLabel("Power Law Exponent[-]");
        shear.setBounds(200,190, 200,50);
        shearField = new JTextField(30);
        shearField.setBounds(450, 200, 200,30);

        //u_mean
        u_mean = new JLabel("Mean Wind Speed [m/s]");
        u_mean.setBounds(200,250,200,50);
        u_meanField = new JTextField(15);
        u_meanField.setBounds(450,250, 150,30);

        // rho
        rho = new JLabel("Air Density [kg/m^3]");
        rho.setBounds(200,300, 200,50);
        rhoField = new JTextField(15);
        rhoField.setBounds(450,300, 100,30);

        //h_ref
        h_ref = new JLabel("Mean Wind Speed Reference Height[m]");
        h_ref.setBounds(200,350,240,50);
        h_refField = new JTextField(15);
        h_refField.setBounds(450,350,100,30);

        //direction make json array
        direction = new JLabel("Wind Direction Unit Vector");
        direction.setBounds(200,400,200,30);
        directionField = new JTextField(15);
        //directionField.setBounds(350,400,100,30);

        //separate GUI field for getting direction coordinates
        X = new JLabel("X-Component");
        X.setBounds(450,400,100,30);
        xField = new JTextField(10);
        xField.setBounds(550,400,100,30);

        Y = new JLabel("Y-Component");
        Y.setBounds(450,420,100,30);
        yField = new JTextField(10);
        yField.setBounds(550,420,100,30);

        Z = new JLabel("Z_Component");
        Z.setBounds(450,440,100,30);
        zField = new JTextField(10);
        zField.setBounds(550,440,100,30);

        //save button
        save = new JButton("Save");
        save.setBounds(700,570,100,50);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                wind = new JSONObject();
                coordinates = new JSONArray();
                windObject = new JSONObject();
                wind.put("type",types.getSelectedItem());
                wind.put("Shear",shearField.getText());
                wind.put("U_mean", u_meanField.getText());
                wind.put("H_ref",h_refField.getText());
                wind.put("Rho",rhoField.getText());

                //creating a Json array for direction coordinates

                coordinates.put(xField.getText());
                coordinates.put(yField.getText());
                coordinates.put(zField.getText());
                wind.put("Direction",coordinates);

                //adding all Json objects to json array windObject
                //windObject.put("wind", wind);
                System.out.println(wind);
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
