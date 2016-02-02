package com.company;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

/**
    Логика
 1. Чекаем, есть ли список за сегодня?

 SELECT count(id) FROM dailyData
 if count = 0 then {
 идём дальше в пункт 2.}
 else {
 идём дальше в пункт 3.}

 2. Добавим список открытых на сегодня ЛО
 INSERT INTO dailyData
 (codeFilial,loadDate,loadStatus)
 SELECT code_filial,now(),0 FROM filials
 WHERE enabl=true

 3. Выбираем нужный для загрузки list
 SELECT * FROM dailyData
 WHERE loadStatus=0
**/

    public static void main(String[] args) throws IOException{
        /*
        Date myDate1 = new Date("01/12/2015");
        importPojo ip = new importPojo(2,11,myDate1);
        try {
            WorkingWithFiles.getThePathToTheSource(ip);
        } catch (ParseException e) {
            e.printStackTrace();
            //проверка даты. (выводит в формате МесяцДеньГод) проветрить позже
        }
        */
        String s1 = "C:\\Users\\Work\\IdeaProjects\\importData-master.zip";
        String s2 = "C:\\Users\\Work\\IdeaProjects\\1";
        try {
            WorkingWithFiles.copyToZDrive(s1, s2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ok!");
    }
}
