/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pbo2.model;

import com.mycompany.pbo2.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tobi
 */
public class Pasien {
    private  int id;
    private String nama;
    private String alamat;
    private String goldar;

    private Database database;
    private Connection connection;
    
    public boolean create(){
        String insertSQL = "INSERT INTO pasien Values (NULL,?, ?, ?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
       
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, this.nama);
            preparedStatement.setString(2, this.alamat);
            preparedStatement.setString(3, this.goldar);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Pasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     public boolean update(){
          String updateSQL = "UPDATE pasien set nama = ?, alamat = ?, goldar = ? WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
       
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateSQL);
           
            preparedStatement.setString(1, this.nama);
            preparedStatement.setString(2, this.alamat);
            preparedStatement.setString(3, this.goldar);
            preparedStatement.setInt(4, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Pasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
      public boolean delete(){
          String deleteSQL = "DELETE FROM pasien WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
       
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteSQL);
           
            preparedStatement.setInt(1, this.id);
            
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Pasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      
       public ArrayList<Pasien> read(){
            ArrayList<Pasien> list = new ArrayList<>();
            
            String selectSQL = "SELECT * FROM pasien";
            this.database = new Database();
            this.connection = this.database.getConnection();
            
            try {
                PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
                ResultSet rs = preparedStatement.executeQuery();
                
                while(rs.next()){
                    Pasien pp = new Pasien();
                    pp.setId(rs.getInt("id"));
                    pp.setNama(rs.getString("nama"));
                    pp.setAlamat(rs.getString("alamat"));
                    pp.setGoldar(rs.getString("goldar"));
                    
                    list.add(pp);
                }
            
                   return list;
                
            } catch (SQLException ex) {
                 Logger.getLogger(Pasien.class.getName()).log(Level.SEVERE, null, ex);
                
            }
          return null;
      }
      
       public boolean find(){
           String findSQL = "SELECT * FROM pasien WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
       
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(findSQL);
           
            preparedStatement.setInt(1, this.id);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                this.setNama(rs.getString("nama"));
                this.setAlamat(rs.getString("alamat"));
                this.setGoldar(rs.getString("goldar"));
                
                 return true;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Pasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       }
        public ArrayList<Pasien> search(String keyword){
            ArrayList<Pasien> list = new ArrayList<>();
            
            String searchSQL = "SELECT * FROM pasien WHERE nama like ?";
            
            keyword = "%" + keyword + "%";
            
            this.database = new Database();
            this.connection = this.database.getConnection();
            
            try {
                PreparedStatement preparedStatement = this.connection.prepareStatement(searchSQL);
                preparedStatement.setString(1, keyword);
                ResultSet rs = preparedStatement.executeQuery();
                
                while(rs.next()){
                    Pasien pp = new Pasien();
                    pp.setId(rs.getInt("id"));
                    pp.setNama(rs.getString("nama"));
                    pp.setAlamat(rs.getString("alamat"));
                    pp.setGoldar(rs.getString("goldar"));
                    
                    list.add(pp);
                }
            
                   return list;
                
            } catch (SQLException ex) {
                 Logger.getLogger(Pasien.class.getName()).log(Level.SEVERE, null, ex);
                
            }
          return null;
    }
       
      
    
      
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getGoldar() {
        return goldar;
    }

    public void setGoldar(String goldar) {
        this.goldar = goldar;
    }
    
}
