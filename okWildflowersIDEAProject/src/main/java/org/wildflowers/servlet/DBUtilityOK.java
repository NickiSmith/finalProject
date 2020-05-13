package org.wildflowers.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtilityOK {
    private static final String Driver = "org.postgresql.Driver";

    private static final String ConnUrl = "jdbc:postgresql://ec2-18-235-20-228.compute-1.amazonaws.com:5432/d5lucrbuppa2h7";
    private static final String Username = "zpxhyiszlihrzk";
    private static final String Password = "d8071070280d011e26ffa689ac4946852dd0a76c1f3887361653b8f55f4055da";

    // This is a constructor
    public DBUtilityOK() {
    }

    // create a Connection to the database
    private Connection connectDB() {
        Connection conn = null;
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(ConnUrl, Username, Password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // execute a sql query (e.g. SELECT) and return a ResultSet
    public ResultSet queryDB(String sql) {
        Connection conn = connectDB();
        ResultSet res = null;
        try {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                res = stmt.executeQuery(sql);
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    // execute a sql query (e.g. INSERT) to modify the database;
    // no return value needed
    public void modifyDB(String sql) {
        Connection conn = connectDB();
        try {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                stmt.execute(sql);
                stmt.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        // You can test the methods you created here
        DBUtilityOK util = new DBUtilityOK();

//        // 1. create a user
//       util.modifyDB("insert into wildflowers (county, scientific_name) values ('ztest', 'ztest')");

        // 2. query the database
        ResultSet res = util.queryDB("select * from okwildflower");
        while (res.next()) {
            System.out.println(res.getString("common_name"));
        }

    }

}