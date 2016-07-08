package test;

import java.sql.*;

/**
 * Created by Андрей on 29.06.2016.
 */
public class ConnectDB {
    static Statement stmt;
    static ResultSet rs;
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ошибка подключения драйвера");
        }
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/offece",
                    "root", "");



            if (conn == null) {
                System.out.println("Нет соединения с БД!");
                System.exit(0);
            } else {
                System.out.println("Connected.");
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM department");

            while (rs.next()) {
                /*System.out.println(rs.getRow() + ". " + rs.getString("id")
                        + "\t" + rs.getString("FIO")
                        + "\t" + rs.getString("birthday")
                        + "\t" + rs.getString("email")
                        + "\t" + rs.getString("year_of_birth")
                        + "\t" + rs.getString("id_department"));*/
                System.out.println(rs.getRow() + ". " + rs.getString("id")
                        + "\t" + rs.getString("name_department"));

            }
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Исключение SQL");
            e.printStackTrace();
        }
    }
    public static void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ошибка подключения драйвера");
        }
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/offece",
                    "root", "");


            if (conn == null) {
                System.out.println("Нет соединения с БД!");
                System.exit(0);
            } else {
                System.out.println("Connected.");
            }
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Исключение SQL");
            e.printStackTrace();
        }
    }
    public static void querySelect(String query){
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void query(String query){
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Disconnect(){
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}