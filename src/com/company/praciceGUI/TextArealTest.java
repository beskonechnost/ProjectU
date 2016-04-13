package com.company.praciceGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Андрей on 01.04.2016.
 */
public class TextArealTest implements ActionListener{
    JTextArea text;

    public static void main(String[] args) {
        TextArealTest gui = new TextArealTest();
        gui.go();
    }

    private void go() {
        JFrame frame = new JFrame("1");
        JPanel panel = new JPanel();
        JButton button = new JButton("click me");
        button.addActionListener(this);
        text = new JTextArea(10, 20);
        text.setLineWrap(true);

        JScrollPane scroll = new JScrollPane(text);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scroll);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        text.append("button clicked \n ");
    }
}
