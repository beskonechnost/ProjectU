package com.company.praciceGUI;

import org.omg.CORBA.DATA_CONVERSION;
import org.omg.CORBA.portable.Streamable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/**
 * Created by Андрей on 03.03.2016.
 */
public class Q {
    public static void main(String[] args) throws IOException {
        String[][] massTest1 = {{"Component1", "25"}, {"Component2", "50"}, {"Component3", "75"},{"Component4", "100"},};
        String[][] massTest2 = {{"Year", "Param1", "Param2","Param3"}, {"2013", "150", "120","70"}, {"2014", "100", "300","200"}, {"2015", "200", "200","300"},{"2016", "50", "400","200"}};
        //createPieChart(massTest1);
        createAreaChart(massTest2);
    }

    public static String dataFormat(){
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date d1 = data;
        sdf.applyPattern("ddMMyyyy");
        String s = sdf.format(data);
        return s;
    }

    public static void createPieChart(String[][] mass) throws IOException {
        String data = Q.dataFormat();
        File f1 = new File("C:\\1\\Круговая_диаграмма_от_" + data + ".html");
        f1.createNewFile();
        String head = Q.textHeadPieChart();
        String middle = Q.textMiddlePieChart(mass);
        String bottom = Q.textBottomPieChart();
        PrintWriter out = new PrintWriter(f1.getAbsoluteFile());
        out.print(head + middle + bottom);
        out.close();
    }
    public static String textHeadPieChart() {
        String s = "<html>\n" +
                "  <head>\n" +
                "    <!--Load the AJAX API-->\n" +
                "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                "    <script type=\"text/javascript\">\n" +
                "\n" +
                "      // Load the Visualization API and the corechart package.\n" +
                "      google.charts.load('current', {'packages':['corechart']});\n" +
                "\n" +
                "      // Set a callback to run when the Google Visualization API is loaded.\n" +
                "      google.charts.setOnLoadCallback(drawChart);\n" +
                "\n" +
                "      // Callback that creates and populates a data table,\n" +
                "      // instantiates the pie chart, passes in the data and\n" +
                "      // draws it.\n" +
                "      function drawChart() {\n" +
                "\n" +
                "        // Create the data table.\n" +
                "        var data = new google.visualization.DataTable();\n" +
                "        data.addColumn('string', 'Topping');\n" +
                "        data.addColumn('number', 'Slices');\n" +
                "        data.addRows([\n";
        return s;
    }
    public static String textBottomPieChart() {
        String s = "\n" +
                "        // Instantiate and draw our chart, passing in some options.\n" +
                "        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));\n" +
                "        chart.draw(data, options);\n" +
                "      }\n" +
                "    </script>\n" +
                "  </head>\n" +
                "\n" +
                "  <body>\n" +
                "    <!--Div that will hold the pie chart-->\n" +
                "    <div id=\"chart_div\"></div>\n" +
                "  </body>\n" +
                "</html>";
        return s;
    }
    public static String textMiddlePieChart(String[][] mass) {
        String text = null;
        for (int i = 0; i < mass.length; i++) {
            String s = "          ['" + mass[i][0] + "', " + mass[i][1] + "],\n";
            if (i == 0) {
                text = s;
            } else {
                text += s;
            }
        }
            text += "        ]);\n" +
                    "\n" +
                    "        // Set chart options\n" +
                    "        var options = {'title':'Pie Chart',\n" +
                    "                       'width':800,\n" +
                    "                       'height':600};\n";
            return text;
    }

    public static void createAreaChart(String[][] mass)throws IOException{
        String data = Q.dataFormat();
        File f1 = new File("C:\\1\\Диаграмма_областная_от_" + data + ".html");
        f1.createNewFile();
        String head = Q.textHeadAreaChart();
        String bottom = Q.textBottomAreaChart();
        String middle = Q.textMiddleAreaChart(mass);
        PrintWriter out = new PrintWriter(f1.getAbsoluteFile());
        out.print(head+middle+bottom);
        out.close();
    }
    public static String textHeadAreaChart(){
        String s = "<html>\n" +
                "  <head>\n" +
                "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                "    <script type=\"text/javascript\">\n" +
                "      google.charts.load('current', {'packages':['corechart']});\n" +
                "      google.charts.setOnLoadCallback(drawChart);\n" +
                "      function drawChart() {\n" +
                "        var data = google.visualization.arrayToDataTable([\n";
        return s;
    }
    public static String textBottomAreaChart(){
        String s = "        };\n" +
                "\n" +
                "        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));\n" +
                "        chart.draw(data, options);\n" +
                "      }\n" +
                "    </script>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div id=\"chart_div\" style=\"width: 900px; height: 600px;\"></div>\n" +
                "  </body>\n" +
                "</html>";
        return s;
    }
    public static String textMiddleAreaChart(String[][] m){
        String text = "";
        for (int i = 0; i< m.length; i++) {
            String s = "[";
            for (int j = 0; j < m[i].length; j++) {
                if (i == 0 || j == 0) {
                    s += "'";
                    s += m[i][j];
                    s += "', ";

                } else {
                    s += m[i][j];
                    s += ", ";
                }
            }
            s += "],\n";
            text += s;
        }

        text += "        ]);\n" +
                "\n" +
                "        var options = {\n" +
                "          title: 'Area Chart',\n" +
                "          hAxis: {title: '"+m[0][0]+"',  titleTextStyle: {color: '#333'}},\n" +
                "          vAxis: {minValue: 0}\n";
        return text;
    }



}
