package com.company.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Work on 09.02.2016.
 */
public class GameHelper {
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
        return inputLine;
    }
}
