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
public class Books extends Dbh {
    //BooksView Methods
    public int getNewBookIDDB() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM BOOKS";
        
        Statement stmt = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        int id = 0;
        
        while(rs.next()){
            id++;
        }
        
        int new_id = id + 1;
        
        return new_id;
    }
    
    public int getNewBookCategoryIDDB() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM BOOKCATEGORIES";
        
        Statement stmt = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        int id = 0;
        while(rs.next()){
            id++;
        }
        
        int new_id = id + 1;
        
        return new_id;
    }
    
    public int getNewStudentBookIDDB() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM STUDENTBOOK";
        
        Statement stmt = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        int id = 0;
        while(rs.next()){
            id++;
        }
        
        int new_id = id + 1;
        
        return new_id;
    }
    
    public int getNewBookRequestIDDB() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM BOOKREQUEST";
        
        Statement stmt = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        int id = 0;
        while(rs.next()){
            id++;
        }
        
        int new_id = id + 1;
        
        return new_id;
    }
    
    public ResultSet viewBooksDB() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM BOOKS";
        
        Statement stmt= getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        return rs;
    }
    
    public boolean inCategoryDB(int book_id, int category_id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM BOOKCATEGORIES WHERE BOOKID = ? AND CATEGORYID = ?";
               
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, book_id);
        stmt.setInt(2, category_id);
        
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
    
    public boolean inBooksDB(int book_id, int student_id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM STUDENTBOOK WHERE BOOKID = ? AND STUDENTID = ?";
               
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, book_id);
        stmt.setInt(2, student_id);
        
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
    
    public boolean inBooksRequestDB(int book_id, int student_id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM BOOKREQUEST WHERE BOOKID = ? AND STUDENTID = ?";
               
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, book_id);
        stmt.setInt(2, student_id);
        
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
    
    public ResultSet viewBookCategoriesDB(int book_id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM BOOKCATEGORIES WHERE BOOKID = ?";
               
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, book_id);
        
        ResultSet rs = stmt.executeQuery();
        
        return rs;
    }
    
    public ResultSet viewStudentBooksDB(int student_id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM STUDENTBOOK WHERE STUDENTID = ?";
               
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, student_id);
        
        ResultSet rs = stmt.executeQuery();
        
        return rs;
    }
    
    public ResultSet viewBookRequestsDB(int student_id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM BOOKREQUEST WHERE STUDENTID = ?";
               
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, student_id);
        
        ResultSet rs = stmt.executeQuery();
        
        return rs;
    }
    
    public ResultSet SearchBookDB(String seacrh_word) throws SQLException, ClassNotFoundException{
        
        seacrh_word = "%"+seacrh_word+"%";
        
        String sql = "SELECT * FROM BOOKS WHERE TITLE LIKE ?";
               
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, seacrh_word);

        ResultSet rs = stmt.executeQuery();
        
        return rs;
        
    }
    
    public ResultSet getBookDetailsDB(int book_id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM BOOKS WHERE BOOKID = ?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        stmt.setInt(1, book_id);
        
        ResultSet rs = stmt.executeQuery();
        
        rs.last();
        
        return rs;
    }
    
    //BooksController Methods
    public boolean addBookDB(String book_title, String author, String book_description, String thumbnail_path,
        String book_path) throws SQLException, ClassNotFoundException{
        
        int book_id = getNewBookIDDB();
        
        String sql = "INSERT INTO BOOKS(BOOKID, TITLE, AUTHOR, DESCRIPTION, THUMBNAILPATH, BOOKPATH) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, book_id);
        stmt.setString(2, book_title);
        stmt.setString(3, author);
        stmt.setString(4, book_description);
        stmt.setString(5, thumbnail_path);
        stmt.setString(6, book_path);
        
        boolean executedSuccessfully = stmt.execute();
        
        return executedSuccessfully;
    }
    
    public boolean addBookCategoryDB(int BookID, int CategoryID) throws SQLException, ClassNotFoundException{
        
        int book_category_id = getNewBookCategoryIDDB();
        
        String sql = "INSERT INTO BOOKCATEGORIES(BOOKCATEGORIID, BOOKID, CATEGORYID) "
                + "VALUES (?, ?, ?)";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, book_category_id);
        stmt.setInt(2, BookID);
        stmt.setInt(3, CategoryID);
        
        boolean executedSuccessfully = stmt.execute();
        
        return executedSuccessfully;
    }
    
    public boolean addBookToStudentDB(int student_id, int book_id) throws SQLException, ClassNotFoundException{
        int student_book_id = getNewStudentBookIDDB();
        
        String sql = "INSERT INTO STUDENTBOOK(STUDENTBOOKID, STUDENTID, BOOKID) "
                + "VALUES (?, ?, ?)";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, student_book_id);
        stmt.setInt(2, student_id);
        stmt.setInt(3, book_id);
        
        boolean executedSuccessfully = stmt.execute();
        
        return executedSuccessfully;
    }
    
    public boolean addBookRequestDB(int student_id, int book_id) throws SQLException, ClassNotFoundException{
        int book_request_id = getNewBookRequestIDDB();
        
        String sql = "INSERT INTO BOOKREQUEST(BOOKREQUESTID, STUDENTID, BOOKID) "
                + "VALUES (?, ?, ?)";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, book_request_id);
        stmt.setInt(2, student_id);
        stmt.setInt(3, book_id);
        
        boolean executedSuccessfully = stmt.execute();
        
        return executedSuccessfully;
    }
    
    public boolean updateBookDB(String title, String author, String description, String thumbnailpath, String bookpath,
    int book_id) throws SQLException, ClassNotFoundException{
        
        String sql = "UPDATE BOOKS SET TITLE = ?, AUTHOR = ?, DESCRIPTION = ?, THUMBNAILPATH = ?, BOOKPATH = ?"
                + " WHERE BOOKID = ?";
        
        PreparedStatement stmt= getConnection().prepareStatement(sql);
        stmt.setString(1, title);
        stmt.setString(2, author);
        stmt.setString(3, description);
        stmt.setString(4, thumbnailpath);
        stmt.setString(5, bookpath);
        stmt.setInt(6, book_id);
        
        boolean updateSuccessfully = stmt.execute();
        
        return updateSuccessfully;
    }
    
    public boolean deleteBookCategoriesDB(int book_id) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM BOOKCATEGORIES WHERE BOOKID = ?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, book_id);
        
        boolean deletedSuccessfully = stmt.execute();
        
        return deletedSuccessfully;
    }
    
    public boolean deleteBookDB(int book_id) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM BOOKS WHERE BOOKID = ?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, book_id);
        
        boolean deletedSuccessfully = stmt.execute();
        
        return deletedSuccessfully;
    }
}
