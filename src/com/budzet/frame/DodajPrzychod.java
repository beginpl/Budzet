package com.budzet.frame;


import com.budzet.model.DochodModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajPrzychod extends JFrame
{


    public DodajPrzychod()
    {
        super("DodajPrzychod");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(500,200,500,250);
        setResizable(false);

        JPanel elementy = new JPanel();
        elementy.setLayout(new GridLayout(5,1));
        JLabel textCena = new JLabel("Cena: ");
        JLabel textOpis = new JLabel("Nazwa przychodu: ");
        JTextField textFieldCena = new JTextField();
        JTextField textFieldOpis = new JTextField();
        JButton dodaj = new JButton("Dodaj wydatek");

        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    DochodModel dm = new DochodModel();
                    double cena = Double.parseDouble(textFieldCena.getText());
                    String opis = textFieldOpis.getText();
                    System.out.println(cena + " " + opis);
                    dm.addDochod(cena,opis);
                    dispose();
                }catch (Exception e1)
                {
                    System.out.println("Wyjatek:\n" +e1);
                }
            }
        });
        elementy.add(textCena);
        elementy.add(textFieldCena);
        elementy.add(textOpis);
        elementy.add(textFieldOpis);
        elementy.add(dodaj);

        add(elementy);
        setVisible(true);
    }
}
