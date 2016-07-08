package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Андрей on 07.07.2016.
 */
public class Frame {
    private String nameNewDepartment = null;
    JTextField textNameDepartment;

    public void frameAddDepartment(){
        JFrame addDepartmentFrame = new JFrame("Добавление нового департамента");
        addDepartmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addDepartmentFrame.setLayout(new FlowLayout());
        JLabel labelNameDepartment = new JLabel("Введите имя нового департамента: ");
        textNameDepartment = new JTextField(20);
        JButton addNewDepartment = new JButton("Add new department");
        addNewDepartment.addActionListener(new addNewDepartmentListener());

        Box box1 = new Box(BoxLayout.Y_AXIS);
        Box box2 = new Box(BoxLayout.Y_AXIS);
        box1.add(textNameDepartment);
        box1.add(Box.createVerticalStrut(10));
        box1.add(addNewDepartment);
        box2.add(labelNameDepartment);
        box2.add(Box.createVerticalStrut(37));
        addDepartmentFrame.getContentPane().add(box2);
        addDepartmentFrame.getContentPane().add(box1);

        addDepartmentFrame.setSize(50,100);
        addDepartmentFrame.pack();
        addDepartmentFrame.setVisible(true);
    }

    private class addNewDepartmentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setNameNewDepartment(textNameDepartment.getText());
            if(textNameDepartment.getText().isEmpty()){
                //if(nameNewDepartment == null){
                    JDialog noneName = new JDialog();
                    JOptionPane.showMessageDialog(noneName,
                            "Поле имени не может быть пустым. Введите имя департамента!",
                            "Введите имя департамента",
                            JOptionPane.WARNING_MESSAGE);
                }else{
                    Department department = new Department(nameNewDepartment);
                    ConnectDB.Connect();
                    ConnectDB.querySelect("SELECT * FROM department");
                    try {
                        boolean flag = false;
                        while (ConnectDB.rs.next()){
                            int d1 = Integer.parseInt(ConnectDB.rs.getString("id"));
                            String d2 = ConnectDB.rs.getString(2);
                            Department d = new Department(d1,d2);
                            if(department.equals(d)){
                                flag = true;
                            }
                        }
                        if(flag){
                            JDialog departmentAlreadyExists = new JDialog();
                            JOptionPane.showMessageDialog(departmentAlreadyExists,
                                    "Департамент с таким именем уже существует! Введите другое имя",
                                    "Ошибка",
                                    JOptionPane.ERROR_MESSAGE);
                        } else{
                            ConnectDB.query("INSERT INTO `department`(`name_department`) VALUES (\""+department.getNameDepartment()+"\")");
                            JDialog departmentAddOk = new JDialog();
                            JOptionPane.showMessageDialog(departmentAddOk,
                                    "Департамент добавлен успешно",
                                    "Удача",
                                    JOptionPane.PLAIN_MESSAGE);
                        }
                        ConnectDB.Disconnect();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                }
            }
    }


    public void setNameNewDepartment(String nameNewDepartment) {
        this.nameNewDepartment = nameNewDepartment;
    }
}
