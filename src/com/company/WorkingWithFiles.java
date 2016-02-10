package com.company;

import java.io.*;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;


public class WorkingWithFiles {
    public static void copy(File source, File receiver) throws IOException {
        FileChannel sourceChannel = new FileInputStream(source).getChannel();
        try {
            FileChannel receiverChannel = new FileOutputStream(receiver).getChannel();
            try {
                receiverChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            } finally {
                receiverChannel.close();
            }
        } finally {
            sourceChannel.close();
        }
    }
    //копирование файлов (пробное)
    public static String getThePathToTheSource (importPojo ip) throws ParseException {
        String path = null;
        String stringNumberFilial = threeGigitNumber(ip.getNumberFilial());
        path = "C:\\DropBox\\"+stringNumberFilial+"\\data\\daily_"+ip.getNumberFilial()+"_"+
                +ip.getCodeFilial()+"_"+workWithData(ip.getLoadDate())+".rar";
        //посмотреть нужный формат даты и форма первого номера ЛО
        System.out.println(path);
       return  path;
    }
    public static String getThePathToTheReceiver (importPojo ip) throws ParseException {
        String path = null;
        path = "C:\\DataForImport\\daily_"+ip.getNumberFilial()+"_"+ip.getCodeFilial()+"_"+
                workWithData(ip.getLoadDate())+".rar";
        return path;
    }
    public static String threeGigitNumber (int number) {
        String s;
        if (number < 10) {
            String a = Integer.toString(number);
            s = "00"+a;
        } else {
            if ((number > 10) && (number < 100)) {
                s = "0" + Integer.toString(number);
            } else {
                s = Integer.toString(number);
            }

        }
        return s;
    }
    public static String workWithData(Date data){
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date d1 = data;
        sdf.applyPattern("ddMMyyyy");
        String s = sdf.format(data);
        return s;
    }
    public static void copyToZDrive(String source, String receiver) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("cmd /c xcopy \"" + source + "\" \"" + receiver +
                "\" /z /y /j /c /q");
        p.waitFor();
    }
    public static void unRarFile(String rarFiles, String pathToExtract){
        try {
            Process p = Runtime.getRuntime().exec("cmd /c  unrar x -y "+rarFiles+" "+pathToExtract);
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void unRarFileFull(String rarFiles, String pathToExtract, int codeFilial){
        try {
            Process p = Runtime.getRuntime().exec("cmd /c  unrar x -y "+rarFiles+" "+pathToExtract);
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File db = new File(pathToExtract+"\\lo.accdb");
        db.getName();
    }
}
