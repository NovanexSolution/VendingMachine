
package lk.novanex.vendingMachine.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class MySQL {
    private static Connection con;
    
    private static String dbName = "mydb";
<<<<<<< HEAD
    private static String port = "3307";
    private static String user = "root";
    private static String pswd = "SuV@gmv0";
=======
    private static String port = "3306";
    private static String user = "root";
    private static String pswd = "Minu@123";
>>>>>>> 0c8d89ecee4f630a39b286db68a9f3b539c07f81

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
