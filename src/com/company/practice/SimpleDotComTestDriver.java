package com.company.practice;

import java.util.ArrayList;

/**
 * Created by Work on 04.02.2016.
 */
public class SimpleDotComTestDriver {
    public static void main(String[] args) {
    }
}
class SimpleDotCom{
    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public String checkYourself(String userGuess) {

        int guess = Integer.parseInt(userGuess);
        String result = "Мимо";
        int index = locationCells.indexOf(userGuess);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Потопил";
            } else {
                result = "Попал";
            }

        }
        return result;
    }
}
