package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";
        try {
            System.out.println("Connecting to database");
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connected to Database!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
