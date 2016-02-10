package com.company.practice;

import java.util.ArrayList;

/**
 * Created by Work on 09.02.2016.
 */
public class SimpleDotComGame {
    public static void main(String[] args) {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        SimpleDotCom theDotCom = new SimpleDotCom();
        int randomNum = (int)(Math.random()*5);
        ArrayList<String> locations = null;
        locations.add(String.valueOf(randomNum));
        locations.add(String.valueOf(randomNum+1));
        locations.add(String.valueOf(randomNum+2));
        theDotCom.setLocationCells(locations);
        boolean isAlive = true;
        while (isAlive==true){
            String guess = helper.getUserInput("Введите число");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if(result.equals("Потопил")){
                isAlive = false;
                System.out.println("Вам потребовалось "+numOfGuesses+" попыток(и)");
            }
        }
    }
}
