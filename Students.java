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
public class Students extends Dbh{
    //Methods for StudentsView
    
    public int getNewStudentID() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM STUDENTS";
        
        Statement stmt = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        int id = 0;
        while(rs.next()){
            id++;
        }
        
        int new_id = id + 1;
        
        return new_id;
    }
    
    public int getNewContactID() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM CONTACT";
        
        Statement stmt = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        int id = 0;
        while(rs.next()){
            id++;
        }
        
        int new_id = id + 1;
        
        return new_id;
    }
    
    public ResultSet viewStudentsDB() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM STUDENTS";
        
        Statement stmt= getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        return rs;
    }
    
    public ResultSet viewContactsDB() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM CONTACT";
        
        Statement stmt= getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        return rs;
    }
    
    public ResultSet viewBookRequestsDB() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM BOOKREQUEST";
               
        Statement stmt= getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        return rs;
    }
    
    public ResultSet getStudentDetailsDB(int student_id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM STUDENTS WHERE STUDENTID = ?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        stmt.setInt(1, student_id);
        
        ResultSet rs = stmt.executeQuery();
        
        rs.last();
        
        return rs;
    }
    
    public int getStudentIDDB(String email, String password) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM STUDENTS WHERE EMAILADDRESS = ? AND PASSWORD = ?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        stmt.setString(1, email);
        stmt.setString(2, password);
        
        ResultSet rs = stmt.executeQuery();
        
        rs.last();
        
        return rs.getInt("STUDENTID");
    }
    
    public boolean studentExistsDB(String email, String password) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM STUDENTS WHERE EMAILADDRESS = ? AND PASSWORD = ?";
               
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, password);
        
        ResultSet rs = stmt.executeQuery();
        
        int counter = 0;
        
        while(rs.next()){
            counter = counter + 1;
        }
        
        boolean isCategory = false;
        
        if(counter == 1){
            isCategory = true;
        }
        
        if(rs != null){
            rs.close();
        }
        
        return isCategory;
    }
    
    //Methods for StudentsController
    
    public boolean addStudentDB(String first_name, String last_name, String email, int age,
        String gender, String address, String username) throws SQLException, ClassNotFoundException{
        
        int student_id = getNewStudentID();
        
        String password = "Student" + student_id;
        
        String sql = "INSERT INTO STUDENTS(STUDENTID, FIRSTNAME, LASTNAME, EMAILADDRESS, AGE, GENDER, ADDRESS, USERNAME, PASSWORD) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, student_id);
        stmt.setString(2, first_name);
        stmt.setString(3, last_name);
        stmt.setString(4, email);
        stmt.setInt(5, age);
        stmt.setString(6, gender);
        stmt.setString(7, address);
        stmt.setString(8, username);
        stmt.setString(9, password);
        
        boolean executedSuccessfully = stmt.execute();
        
        return executedSuccessfully;
        
    }
    
    public boolean addContactDB(String full_name, String email, String subject, String body) throws SQLException, ClassNotFoundException{
        
        int contact_id = getNewContactID();
        
        String sql = "INSERT INTO CONTACT(CONTACTID, FULLNAME, EMAIL, SUBJECT, BODY) "
                + "VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, contact_id);
        stmt.setString(2, full_name);
        stmt.setString(3, email);
        stmt.setString(4, subject);
        stmt.setString(5, body);
        
        boolean executedSuccessfully = stmt.execute();
        
        return executedSuccessfully;
        
    }
    
    public boolean updateStudentDB(String first_name, String last_name, String email, int age, String gender, 
            String address, String username, String password, int student_id) throws SQLException, ClassNotFoundException{
        
        String sql = "UPDATE STUDENTS SET FIRSTNAME = ?, LASTNAME = ?, EMAILADDRESS = ?, AGE = ?, GENDER = ?, "
                + "ADDRESS = ?, USERNAME = ?, PASSWORD = ? WHERE STUDENTID = ?";
        
        PreparedStatement stmt= getConnection().prepareStatement(sql);
        stmt.setString(1, first_name);
        stmt.setString(2, last_name);
        stmt.setString(3, email);
        stmt.setInt(4, age);
        stmt.setString(5, gender);
        stmt.setString(6, address);
        stmt.setString(7, username);
        stmt.setString(8, password);
        stmt.setInt(9, student_id);
        
        boolean updateSuccessfully = stmt.execute();
        
        return updateSuccessfully;
    }
    
    public boolean changeStudentPasswordDB(int student_id, String password) throws SQLException, ClassNotFoundException{
        
        String sql = "UPDATE STUDENTS SET PASSWORD = ? WHERE STUDENTID = ?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, password);
        stmt.setInt(2, student_id);
        
        boolean updateSuccessfully = stmt.execute();
        
        return updateSuccessfully;
    }
    
    public boolean deleteStudentDB(int student_id) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM STUDENTS WHERE STUDENTID = ?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, student_id);
        
        boolean deletedSuccessfully = stmt.execute();
        
        return deletedSuccessfully;
    }
    
    public boolean deleteStudentBooksDB(int student_id) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM STUDENTBOOK WHERE STUDENTID = ?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, student_id);
        
        boolean deletedSuccessfully = stmt.execute();
        
        return deletedSuccessfully;
    }
    
    public boolean deleteStudentBookRequestsDB(int student_id) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM BOOKREQUEST WHERE STUDENTID = ?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, student_id);
        
        boolean deletedSuccessfully = stmt.execute();
        
        return deletedSuccessfully;
    }
}
