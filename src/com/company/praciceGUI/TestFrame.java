package com.company.praciceGUI;

import javax.swing.*;
import java.awt.event.*;



/**
 * Created by Андрей on 03.03.2016.
 */
public class TestFrame implements ActionListener{
    JButton button;
    int n = 1;


    public static void main(String[] args) {
        TestFrame gui = new TestFrame();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("ты кликнул по кнопке "+n+" раз");
        n++;
    }
}
