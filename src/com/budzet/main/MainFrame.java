package com.budzet.main;

import com.budzet.frame.*;
import com.budzet.model.Dochod;
import com.budzet.model.DochodModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame
{

     MainFrame()
     {
        super("Budzet");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400,200,900,400);


        JPanel jp0 = new JPanel();
        JPanel jp1 = new JPanel();

        jp0.setLayout(new BoxLayout(jp0,BoxLayout.Y_AXIS));
        jp1.setLayout(new BoxLayout(jp1,BoxLayout.X_AXIS));

        JButton b0 = new JButton("Home");
        JButton b1 = new JButton("Dodaj wydatek");
        JButton b2 = new JButton("Dodaj przychod");
        JButton b3 = new JButton("Modyfikuj wydatek");
        JButton b4 = new JButton("Modyfikuj przychod");
        JButton b5 = new JButton("Usun wydatek");
        JButton b6 = new JButton("Usun przychod");
        JButton b7 = new JButton("Saldo");

        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp0.revalidate();
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajWydatek dodajWydatek = new DodajWydatek();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajPrzychod dodajPrzychod = new DodajPrzychod();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModyfikacjaWydatek modyfikacjaWydatek = new ModyfikacjaWydatek();
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModyfikacjaPrzychod modyfikacjaPrzychod  = new ModyfikacjaPrzychod();
            }
        });

         b5.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 UsunWydatek usunWydatek = new UsunWydatek();
             }
         });

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsunPrzychod usunPrzychod = new UsunPrzychod();
            }
        });

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Saldo saldo = new Saldo();
            }
        });



        jp1.add(b0);
        jp1.add(b1);
        jp1.add(b2);
        jp1.add(b3);
        jp1.add(b4);
        jp1.add(b5);
        jp1.add(b6);
        jp1.add(b7);

        jp0.add(jp1);
        add(jp0);
        setVisible(true);
    }
}
