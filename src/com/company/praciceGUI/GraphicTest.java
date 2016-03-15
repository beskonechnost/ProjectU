package com.company.praciceGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by Андрей on 09.03.2016.
 */
public class GraphicTest extends JPanel {

    /*public void paintComponent(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(20,30,40,50);
    }//рисуем прямоугольник*/

    /*public void paintComponent(Graphics g){
        Image image = new ImageIcon("C:/1/22.jpg").getImage();
        g.drawImage(image,1,1,this);
    }//добавляем изображение формсата jpg*/

    public void paintComponent(Graphics g){
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        int red = (int)(Math.random()*255);
        int green = (int)(Math.random()*255);
        int blue = (int)(Math.random()*255);
        Color randomColor = new Color(red+green+blue);
        g.setColor(randomColor);
        g.fillOval(70,70,100,100);
    }//круг на черном фоне*/


}
