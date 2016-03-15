package com.company.praciceGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;


/**
 * Created by Андрей on 03.03.2016.
 */
public class TestFrame implements ActionListener{
    JFrame frame;

    JButton button1;
    int n = 1;


    public static void main(String[] args) {
        TestFrame gui = new TestFrame();
        gui.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1 = new JButton("Кликни, и цвет панели поменяется.");
        button1.addActionListener(this);
        GraphicTest drawPanel = new GraphicTest();

        frame.getContentPane().add(BorderLayout.SOUTH, button1);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
        button1.setText("Мы изменили цвет "+n+" раз");
        n++;
    }
}
