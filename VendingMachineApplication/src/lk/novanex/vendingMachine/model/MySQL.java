
package lk.novanex.vendingMachine.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class MySQL {
    private static Connection con;
    
    private static String dbName = "madusankadev_vendingMachine";
    private static String port = "5522";
    private static String user = "madusankadev_root";
    private static String pswd = "SuV@gmv0SuV@gmv1";

    public static void createConnection() throws Exception {
        if (con == null) {
            System.out.println("start");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:"+ port +"/" + dbName  , user, pswd);
            System.out.println("connection sucess");
        }
    }

    public static ResultSet execute(String querry) throws Exception {
        createConnection();
        return con.createStatement().executeQuery(querry);
    }

    public static Integer executeIUD(String querry) throws Exception {
        createConnection();
        return con.createStatement().executeUpdate(querry);

    }

    
}