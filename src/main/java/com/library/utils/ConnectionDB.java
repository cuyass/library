package com.library.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionDB {
    private static final Dotenv dotenv = Dotenv.load();

    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASS = dotenv.get("DB_PASS");

    private static Connection connection;
    public static Connection initConnection(){
        try{
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected successfully!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            connection.close();
            System.out.println("Closed connection");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
} 
