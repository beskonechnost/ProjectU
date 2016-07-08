package test;

import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by Андрей on 08.07.2016.
 */
public class ForJTable {
    public Vector nameColumn() {
        Vector nameColumn = new Vector();
        ConnectDB.querySelect("SELECT * FROM department");
        try {
            int i = 0;
            while (i <= ConnectDB.rs.getRow()) {
                nameColumn.add(ConnectDB.rs.getString(i));
            }
            ConnectDB.rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nameColumn;
    }

    public Vector row() throws SQLException {
        Vector vecData = new Vector();
        ConnectDB.querySelect("SELECT * FROM department");
        while (ConnectDB.rs.next()) {
            Vector v = new Vector();
        }
        return vecData;
    }
}