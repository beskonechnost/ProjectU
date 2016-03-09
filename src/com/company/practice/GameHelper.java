package com.company.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Work on 09.02.2016.
 */
public class GameHelper {
    private static final java.lang.String alphabet = "abcdifg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid =  new int [gridSize];
    private int comCount = 0;


    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.print(prompt+" ");
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = is.readLine();
            if (inputLine.length()==0) return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLine.toLowerCase();
    }
    public ArrayList<java.lang.String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphaCords = new String[comSize];
        String temp = null;
        int[] cords = new int[comSize];
        int attempts = 0;
        boolean success = false;

        comCount++;
        int incr = 1;
        if(comCount%2==1){
            incr = gridLength;
        }
        while (!success && attempts++ <200){
            int location = (int) (Math.random() * gridSize);
            int x = 0;
            success = true;
            while (success && x < comSize){
                if(grid[location]==0){
                    cords[x++] = incr;
                    if(location >= gridSize){
                        success = false;
                    }
                    if(x>0 && (location % gridLength ==0)){
                        success = false;
                    }
                } else {
                    success = false;
                }
            }
        }
        int x = 0;
        int row = 0;
        int column = 0;
        while (x<comSize){
            grid[cords[x]]=1;
            row = (int)(cords[x]/gridLength);
            column = cords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));
            alphaCells.add(temp.concat(Integer.toString(column)));
            x++;
        }
    return alphaCells;    
    }
}
