/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libms;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author REHOBOTH
 */
public class BooksView extends Books {
    //Methods for StudentsView
    
    public int getNewBookID() throws SQLException, ClassNotFoundException{
        return getNewBookIDDB();
    }
    
    public boolean inCategory(int book_id, int category_id) throws SQLException, ClassNotFoundException{
        return inCategoryDB(book_id, category_id);
    }
    
    public boolean inBooks(int book_id, int student_id) throws SQLException, ClassNotFoundException{
        return inBooksDB(book_id, student_id);
    }
    
    public boolean inBooksRequest(int book_id, int student_id) throws SQLException, ClassNotFoundException{
        return inBooksRequestDB(book_id, student_id);
    }
    
    public ResultSet SearchBook(String seacrh_word) throws SQLException, ClassNotFoundException{
        
        return SearchBookDB(seacrh_word);
        
    }
    
    public ResultSet viewBooks() throws SQLException, ClassNotFoundException{
        return viewBooksDB();
    }
    
    public ResultSet viewBookCategories(int book_id) throws SQLException, ClassNotFoundException{
        return viewBookCategoriesDB(book_id);
    }
    
    public ResultSet viewStudentBooks(int student_id) throws SQLException, ClassNotFoundException{
        return viewStudentBooksDB(student_id);
    }
    
    public ResultSet getBookDetails(int book_id) throws SQLException, ClassNotFoundException{
        return getBookDetailsDB(book_id);
    }
}
