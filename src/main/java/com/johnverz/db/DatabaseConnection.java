package com.johnverz.db;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class DatabaseConnection {
    private String url = "jdbc:mysql://localhost:3306/fx_db_app";
    private String user = "fx";
    private String password = "1234";
    private Connection connection;

    public DatabaseConnection(){
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public boolean authenticate(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                //the user is present, check password
                if(BCrypt.checkpw(password, rs.getString("password"))){
                    return true;
                }else{
                    return false;
                }

            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }


}
