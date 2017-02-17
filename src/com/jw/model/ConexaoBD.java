package com.jw.model;

import java.sql.*;

public class ConexaoBD {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //private static final String HOST = "ec2-35-167-124-186.us-west-2.compute.amazonaws.com";
    private static final String HOST = "localhost";
    private static final String URL = "jdbc:mysql://" + HOST + ":3306/salao";
    private static final String USER = "salao";
    private static final String PASSWORD = "salao";
    private static Connection conexao;
    
    public static boolean openConnection() {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            
            return true;
        } catch (SQLException | ClassNotFoundException sqle) {
            System.out.println(sqle);
            return false;
        }
    }
    
    public static boolean closeConnection() {
        try {
            conexao.close();
            return true;
        } catch (SQLException sqle) {
            System.out.println(sqle);
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static Connection getConnection() {
        return conexao;
    }
    
    public static void rollBack() {
        try {
            conexao.rollback();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }
    
    public static void commit() {
        try {
            conexao.commit();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }
    
    public static void main (String[] args) throws Exception {
        ConexaoBD.openConnection();
        System.out.println("Conectou!");
    }
}
