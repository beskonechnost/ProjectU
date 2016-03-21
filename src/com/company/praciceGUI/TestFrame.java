package com.company.praciceGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;


/**
 * Created by Андрей on 03.03.2016.
 */
class TestFrame{
    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        TestFrame gui = new TestFrame();
        gui.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton ColorButton = new JButton("Кликни, и цвет панели поменяется.");
        ColorButton.addActionListener(new ColorListener());

        JButton labelButton = new JButton("1");
        labelButton.addActionListener(new LabelListener());

        label = new JLabel("Я метка");
        GraphicTest drawPanel = new GraphicTest();

        frame.getContentPane().add(BorderLayout.SOUTH, ColorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            frame.repaint();
        }
    }
    class LabelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            label.setText("новый текст");
        }
    }
}
