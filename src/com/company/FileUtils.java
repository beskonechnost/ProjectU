package com.company;

import com.company.importPojo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Андрей on 12.02.2016.
 */
public class FileUtils {
    public static String getThePathToTheSource (importPojo ip) throws ParseException {
        String path = null;
        String stringNumberFilial = getNulliki(ip.getNumberFilial());
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
    public static String getNulliki (int number) {
        String s;
        if (number < 10) {
            String a = Integer.toString(number);
            s = "00" + a;
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

    //для работы приведенных ниже методов, нужно прописать путь к папке winRar
    //т.к. данные методы взаимодействуют с командной строкой
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
}
