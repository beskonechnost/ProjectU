package com.company.praciceGUI;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Андрей on 24.03.2016.
 */

public class AnimationTest {
    int x = 70;
    int y = 70;

    public static void main(String[] args) {
        AnimationTest animation = new AnimationTest();
        animation.go();
    }

    private void go() {
        JFrame frame = new JFrame("1");
        MyDrawPanel1 drawPanel2 = new MyDrawPanel1();

        for (int i = 0; i <= 130; i++){
            x++;
            y++;

          drawPanel2.repaint();

            try {
                Thread.sleep(50);
            }catch (Exception x){}
        }
        frame.getContentPane().add(drawPanel2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    class MyDrawPanel1 extends JPanel {

        public void paintComponents(Graphics g) {
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color randomColor = new Color(red + green + blue);
            g.setColor(randomColor);
            g.fillOval(70, 70, 100, 100);
        }
    }
}




