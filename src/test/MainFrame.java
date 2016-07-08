package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Андрей on 08.07.2016.
 */
public class MainFrame {
    public static void MainFrame(){
        JFrame mainFrame = new JFrame("Основная форма");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());
        JLabel labelAllDepartment = new JLabel("Департаменты в данном оффисе: ");
        JTable tableDepartment = new JTable();
        tableDepartment.setSize(100, 200);
        tableDepartment.setAutoscrolls(true);

        JButton addDepartment = new JButton("Add");
        addDepartment.addActionListener(new addDepartmentListener());
        JButton removeDepartment = new JButton("Remove");
        removeDepartment.addActionListener(new removeDepartmentListener());
        JButton updateDepartment = new JButton("Update");
        updateDepartment.addActionListener(new updateDepartmentListener());
        JButton listEmployees = new JButton("List");
        listEmployees.addActionListener(new listEmployeeListener());

        Box box1 = new Box(BoxLayout.Y_AXIS);
        Box box2 = new Box(BoxLayout.Y_AXIS);

        box1.add(labelAllDepartment);
        box1.add(Box.createVerticalStrut(10));
        box1.add(tableDepartment);

        box2.add(addDepartment);
        box2.add(Box.createVerticalStrut(10));
        box2.add(removeDepartment);
        box2.add(Box.createVerticalStrut(10));
        box2.add(updateDepartment);
        box2.add(Box.createVerticalStrut(10));
        box2.add(listEmployees);

        mainFrame.getContentPane().add(box1);
        mainFrame.getContentPane().add(box2);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private static class addDepartmentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Frame f = new Frame();
            f.frameAddDepartment();
        }
    }

    private static class removeDepartmentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    private static class updateDepartmentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    private static class listEmployeeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
