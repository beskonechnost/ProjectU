package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by DanNetoff on 30.01.2016.
 */
public class DButils {

    public static Set<importPojo> getList(String q1, Object... params) throws SQLException, ParseException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Set<importPojo> set = new HashSet<>();
        ResultSet myRes = getResultSet(q1, params);
        ResultSetMetaData rsmd = null;

        try {

            rsmd = myRes.getMetaData();
            while (myRes.next()) {
                importPojo pojo1 = new importPojo();
                for (int indexCol = 1; indexCol <= rsmd.getColumnCount(); indexCol++) {
                    Class pojo = pojo1.getClass();
                    String columnLabel = rsmd.getColumnLabel(indexCol);
                    Method method = pojo.getMethod(columnLabel, int.class);
                    method.invoke(pojo1,myRes.getInt(columnLabel));
                }
                set.add(pojo1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  set;
    }


    public static ResultSet getResultSet(String q1, Object... params) throws SQLException, ClassNotFoundException, ParseException {
        PreparedStatement stmt = null;
        try {
            stmt = connectionToMDB.getConnection().prepareStatement(q1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            DButils.setParameters(stmt, params);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // Параметризуем параметры
    private static void setParameters(PreparedStatement preparedStatement, Object... params) throws SQLException {
        if(params != null){
            int pos = 0;
            for(Object o : params){
                pos++;
                if(o.getClass().equals(java.util.Date.class)){
                    preparedStatement.setDate(pos, new java.sql.Date(((Date) o).getTime()));
                    continue;
                }
                if(o.getClass().equals(java.lang.Integer.class)){
                    preparedStatement.setInt(pos, (Integer) o);
                    continue;
                }
                if(o.getClass().equals(java.lang.Double.class)){
                    preparedStatement.setDouble(pos, (Double) o);
                    continue;
                }
                if(o.getClass().equals(java.lang.String.class)){
                    preparedStatement.setString(pos, (String) o);
                    continue;
                }
            }

        }

    }
}
