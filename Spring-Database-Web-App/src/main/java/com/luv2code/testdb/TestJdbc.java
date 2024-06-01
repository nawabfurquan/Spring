package com.luv2code.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) throws Exception {
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user = "springstudent";
        String password = "springstudent";
        try {
            System.out.println("Connecting to database");
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connected to Database!!");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
