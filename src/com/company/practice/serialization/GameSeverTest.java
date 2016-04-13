package com.company.practice.serialization;

import java.io.*;

/**
 * Created by Андрей on 12.04.2016.
 */
public class GameSeverTest {
    public static void main(String[] args) {
        GameCharacter oneCharacter = new GameCharacter(50, "Elf", new String[]{"Лук","Меч","Кастет"});
        GameCharacter twoCharacter = new GameCharacter(200, "Troll", new String[]{"Секира","Голые руки"});
        GameCharacter threeCharacter = new GameCharacter(120, "Magician", new String[]{"Заклинания","Невидимость"});

        try {
            FileOutputStream fos = new FileOutputStream("Game.ser");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(oneCharacter);
            os.writeObject(twoCharacter);
            os.writeObject(threeCharacter);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        oneCharacter = null;
        twoCharacter = null;
        threeCharacter = null;

        try {
            FileInputStream fis = new FileInputStream("Game.ser");
            ObjectInputStream is = new ObjectInputStream(fis);
            GameCharacter one = (GameCharacter) is.readObject();
            GameCharacter two = (GameCharacter) is.readObject();
            GameCharacter three = (GameCharacter) is.readObject();
            System.out.println(one.getType());
            System.out.println(two.getType());
            System.out.println(three.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
