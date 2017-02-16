package com.budzet.frame;

import com.budzet.model.DochodModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsunPrzychod extends JFrame
{
    public UsunPrzychod()
    {
        super("ModyfikujPrzychod");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(500,200,500,250);
        setResizable(false);

        JPanel elementy = new JPanel();
        elementy.setLayout(new GridLayout(5,1));
        JLabel textID = new JLabel("ID: ");
        JTextField textFieldID = new JTextField();
        JButton dodaj = new JButton("Zakoncz edycje");

        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    DochodModel dm = new DochodModel();
                    int id = Integer.parseInt(textFieldID.getText());
                    dm.deleteDochod(id);
                    dispose();
                }catch (Exception e1)
                {
                    System.out.println("Wyjatek:\n" +e1);
                }
            }
        });
        elementy.add(textID);
        elementy.add(textFieldID);
        elementy.add(dodaj);

        add(elementy);
        setVisible(true);
    }
}
