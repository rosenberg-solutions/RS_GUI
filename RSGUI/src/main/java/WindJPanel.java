package main.java;

import javax.swing.*;

public class WindJPanel extends JFrame {

    static private JPanel p;
    static private JLabel type, shear, u_mean, h_ref, rho, direction;
    static private JTextField  shearField, u_meanField, h_refField, rhoField, directionField;
    static private String[] typeWind = new String[]{"Deterministic", " other types "};
    static private JComboBox<String> types;


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
        directionField.setBounds(350,400,100,30);

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
        p.add(directionField);



        return  p;
    }
}
