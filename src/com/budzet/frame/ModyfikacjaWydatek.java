package com.budzet.frame;


import com.budzet.model.DochodModel;
import com.budzet.model.WydatekModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModyfikacjaWydatek extends JFrame
{
    public ModyfikacjaWydatek()
    {
        super("ModyfikujWydatek");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(500,200,500,250);
        setResizable(false);

        JPanel elementy = new JPanel();
        elementy.setLayout(new GridLayout(5,1));
        JLabel textID = new JLabel("ID: ");
        JLabel textCena = new JLabel("Nowa cena: ");
        JLabel textOpis = new JLabel("Nazwa wydatku: ");
        JTextField textFieldCena = new JTextField();
        JTextField textFieldID = new JTextField();
        JTextField textFieldOpis = new JTextField();
        JButton dodaj = new JButton("Zakoncz edycje");

        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    WydatekModel wm = new WydatekModel();
                    int id = Integer.parseInt(textFieldID.getText());
                    double cena = Double.parseDouble(textFieldCena.getText());
                    String opis = textFieldOpis.getText();
                    wm.updateWydatek(id,cena,opis);
                    dispose();
                }catch (Exception e1)
                {
                    System.out.println("Wyjatek:\n" +e1);
                }
            }
        });
        elementy.add(textID);
        elementy.add(textFieldID);
        elementy.add(textCena);
        elementy.add(textFieldCena);
        elementy.add(textOpis);
        elementy.add(textFieldOpis);
        elementy.add(dodaj);

        add(elementy);
        setVisible(true);
    }
}
