package com.budzet.frame;

import com.budzet.model.Dochod;
import com.budzet.model.DochodModel;
import com.budzet.model.Wydatek;
import com.budzet.model.WydatekModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Saldo extends JFrame
{
    public Saldo()
    {
        super("Saldo");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(500,200,500,250);
        setResizable(false);

        JPanel elementy = new JPanel();
        elementy.setLayout(new GridLayout(5,1));
        JLabel dochod = new JLabel("Dochod : ");
        JLabel wydatek = new JLabel("Wydatek : ");
        JLabel saldo = new JLabel("Stan konta : ");

        try {
            DochodModel dochodModel = new DochodModel();
            WydatekModel wydatekModel = new WydatekModel();
            double dm = dochodModel.sumaDochod();
            String d = Double.toString(dm);
            dochod.setText("Dochod:  "+ d);
            double wm = wydatekModel.sumaWydatek();
            String w = Double.toString(wm);
            wydatek.setText("Wydatek:  "+ w);
            double sm = dm-wm;
            String s = Double.toString(sm);
            saldo.setText("Dochod:  "+ s);

        }catch (Exception e) {
            System.out.println("Cos poszlo nie tak:\n"+e);
        }

        elementy.add(dochod);
        elementy.add(wydatek);
        elementy.add(saldo);

        add(elementy);
        setVisible(true);
    }
}

