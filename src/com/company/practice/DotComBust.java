package com.company.practice;

import java.util.ArrayList;

/**
 * Created by Андрей on 15.02.2016.
 */
public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<>();
    private int numOfGuesses = 0;

    void setUpGame(){
        DotCom one = new DotCom();
        one.setName("vk.com");
        dotComList.add(one);
        DotCom two = new DotCom();
        two.setName("google.com");
        dotComList.add(two);
        DotCom three = new DotCom();
        three.setName("dropbox.com");
        dotComList.add(three);

        System.out.println("Цель - \"потопить\" три сайта");
        System.out.println("vk.com, google.com, dropbox.com");
        System.out.println("Попробуем потопить их за минимальное число попыток");

        for(DotCom dotComToSet : dotComList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    void startToPlaying(){
        while (!dotComList.isEmpty()){
            String userGuess = helper.getUserInput("Сделайте ваш ход!");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    private void finishGame() {
        System.out.println("Все \"сайты\" потоплены. ");
        if(numOfGuesses<=18){
            System.out.println("Это заняло у вас всего "+numOfGuesses+" попыток!");
            System.out.println("Вы успели выбраться!");
        }else {
            System.out.println("Это заняло довольно много времени. "+numOfGuesses+" попыток!");
            System.out.println("Вы пошли на корм рыбам!");
        }
    }
    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо";
        for (DotCom dotComToTest : dotComList){
            result = dotComToTest.checkYourself(userGuess);
            if(result.equals("Попал")){
                break;
            }
            if (result.equals("Потопил")){
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

}
