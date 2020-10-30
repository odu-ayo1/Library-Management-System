/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libms;

import java.sql.SQLException;

/**
 *
 * @author REHOBOTH
 */
public class BooksController extends Books {
    public boolean addBook(String book_title, String author, String book_description, String thumbnail_path,
        String book_path) throws SQLException, ClassNotFoundException{
        
        return addBookDB(book_title, author, book_description, thumbnail_path, book_path);
        
    }
    
    public boolean addBookCategory(int BookID, int CategoryID) throws SQLException, ClassNotFoundException{
        
        return addBookCategoryDB(BookID, CategoryID);
                
    }
    
    public boolean addBookToStudent(int student_id, int book_id) throws SQLException, ClassNotFoundException{
        return addBookToStudentDB(student_id, book_id);
    }
    
    public boolean addBookRequest(int student_id, int book_id) throws SQLException, ClassNotFoundException{
        return addBookRequestDB(student_id, book_id);
    }
    
    public boolean updateBook(String title, String author, String description, String thumbnailpath, String bookpath,
    int book_id) throws SQLException, ClassNotFoundException{
        
        return updateBookDB(title, author, description, thumbnailpath, bookpath, book_id);
    }
    
    public boolean deleteBookCategories(int book_id) throws SQLException, ClassNotFoundException{
        return deleteBookCategoriesDB(book_id);
    }
}
