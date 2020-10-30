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
public class StudentsController extends Students {
    public boolean addStudent(String first_name, String last_name, String email, int age,
        String gender, String address, String username) throws SQLException, ClassNotFoundException{
        
        return addStudentDB(first_name, last_name, email, age, gender, address, username);
    }
    
    public boolean deleteStudent(int student_id) throws SQLException, ClassNotFoundException{
        return deleteStudentDB(student_id);
    }
    
    public boolean updateStudent(String first_name, String last_name, String email, int age, String gender, 
            String address, String username, String password, int student_id) throws SQLException, ClassNotFoundException{     
        return updateStudentDB(first_name, last_name, email, age, gender, address, username, password, student_id);
    }
    
    public boolean deleteStudentBooks(int student_id) throws SQLException, ClassNotFoundException{
        return deleteStudentBooksDB(student_id);
    }
    
    public boolean addContact(String full_name, String email, String subject, String body) throws SQLException, ClassNotFoundException{
        
        return addContactDB(full_name, email, subject, body);
        
    }
    
    public boolean changeStudentPassword(int student_id, String password) throws SQLException, ClassNotFoundException{
        
        return changeStudentPasswordDB(student_id, password);
        
    }
    
    public boolean deleteStudentBookRequests(int student_id) throws SQLException, ClassNotFoundException{
        return deleteStudentBookRequestsDB(student_id);
    }
}
