/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author REHOBOTH
 */
public class Categories extends Dbh {
    //Categories View Methods
    public int getNewCategoryID() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM CATEGORIES";
        
        Statement stmt = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        int id = 0;
        while(rs.next()){
            id++;
        }
        
        int new_id = id + 1;
        
        return new_id;
    }
    
    public ResultSet viewCategoriesDB() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM CATEGORIES";
        
        Statement stmt= getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        return rs;
    }
    
    public ResultSet getCategoryDetailsDB(int category_id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM CATEGORIES WHERE CATEGORYID = ?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        stmt.setInt(1, category_id);
        
        ResultSet rs = stmt.executeQuery();
        
        rs.last();
        
        return rs;
    }
    
    
    //Categories Controller Methods
    public boolean addCategoryDB(String category_name, String status) throws SQLException, ClassNotFoundException{
        
        int category_id = getNewCategoryID();
        
        String sql = "INSERT INTO CATEGORIES(CATEGORYID, CATEGORYNAME, STATUS) "
                + "VALUES (?, ?, ?)";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, category_id);
        stmt.setString(2, category_name);
        stmt.setString(3, status);
        
        boolean executedSuccessfully = stmt.execute();
        
        return executedSuccessfully;
        
    }
    
    public boolean updateCategoryDB(String category_name, String status, int category_id) throws SQLException, ClassNotFoundException{
        
        String sql = "UPDATE CATEGORIES SET CATEGORYNAME = ?, STATUS = ? WHERE CATEGORYID = ?";
        
        PreparedStatement stmt= getConnection().prepareStatement(sql);
        stmt.setString(1, category_name);
        stmt.setString(2, status);
        stmt.setInt(3, category_id);
        
        boolean updateSuccessfully = stmt.execute();
        
        return updateSuccessfully;
    }
    
    public boolean deleteCategoryDB(int category_id) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM CATEGORIES WHERE CATEGORYID = ?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, category_id);
        
        boolean deletedSuccessfully = stmt.execute();
        
        return deletedSuccessfully;
    }
    
    public boolean deleteBookCategoriesDB(int category_id) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM BOOKCATEGORIES WHERE CATEGORYID = ?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, category_id);
        
        boolean deletedSuccessfully = stmt.execute();
        
        return deletedSuccessfully;
    }
}
