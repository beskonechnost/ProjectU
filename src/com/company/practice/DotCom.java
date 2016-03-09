package com.company.practice;

import java.util.ArrayList;

/**
 * Created by Андрей on 15.02.2016.
 */
public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc) {
        this.locationCells = loc;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String checkYourself(String userGuess) {
        String result = "Мимо";
        int index = locationCells.indexOf(userGuess);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Потопил";
                System.out.println("Был потоплен сайт "+name+" :(");
            } else {
                result = "Попал";
            }

        }
        System.out.println(result);
        return result;
    }
}
