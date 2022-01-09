 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo22115f.pbo2_19631119.model;

import com.pbo22115f.pbo2_19631119.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tobi
 */
public class Pengguna {
      private int id;
    private String user;
    private String password;
    private boolean isAdmin;
    
    public Database database;
    public Connection connection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    public Pengguna() throws SQLException{
        
        this.database = new Database();
        this.connection = database.getConnection();
}
    public Pengguna login(){
    String loginSQL= "SELECT *FROM `admin` WHERE user = ? AND password = MD5(?)";
     try {
        Statement statement = connection.createStatement();
       
        
            PreparedStatement ps = connection.prepareStatement(loginSQL);
        ps.setString(1, this.user);
        ps.setString(2, this.password);

        ps.execute();
         ResultSet resultSet = ps.executeQuery();
        
        while(resultSet.next()){
            this.id = resultSet.getInt(1);
            this.user = resultSet.getString(2);
            this.isAdmin = resultSet.getBoolean(4);
            return this;
                
            
            
        }
        System.out.println(this.id);
            System.out.println(this.isAdmin);
            
    } catch (SQLException ex) {
        System.out.println(ex.toString());
    }
       return null;
    
    }
}
    
    
    

