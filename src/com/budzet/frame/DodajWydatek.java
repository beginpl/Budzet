package com.budzet.frame;

import com.budzet.model.DochodModel;
import com.budzet.model.Wydatek;
import com.budzet.model.WydatekModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajWydatek extends JFrame
{
    public DodajWydatek()
    {
        super("DodajWydatek");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(500,200,500,250);
        setResizable(false);

        JPanel elementy = new JPanel();
        elementy.setLayout(new GridLayout(5,1));
        JLabel textCena = new JLabel("Cena: ");
        JLabel textOpis = new JLabel("Nazwa wydatku: ");
        JTextField textFieldCena = new JTextField();
        JTextField textFieldOpis = new JTextField();
        JButton dodaj = new JButton("Dodaj wydatek");

        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    WydatekModel wm = new WydatekModel();
                    double cena = Double.parseDouble(textFieldCena.getText());
                    String opis = textFieldOpis.getText();
                    wm.addWydatek(cena,opis);
                    dispose();
                }catch (Exception e1)
                {
                    System.out.println("DUPA"+e1);
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
