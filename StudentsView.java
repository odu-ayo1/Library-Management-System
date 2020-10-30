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
public class StudentsView extends Students {
    public ResultSet viewStudent() throws SQLException, ClassNotFoundException{
        return viewStudentsDB();
    }
    
    public ResultSet getStudentDetails(int student_id) throws SQLException, ClassNotFoundException{
        return getStudentDetailsDB(student_id);
    }
    
    public boolean studentExists(String email, String password) throws SQLException, ClassNotFoundException{
        return studentExistsDB(email, password);
    }
    
    public int getStudentID(String email, String password) throws SQLException, ClassNotFoundException{
        return getStudentIDDB(email, password);
    }
    
    public ResultSet viewBookRequests() throws SQLException, ClassNotFoundException{
        return viewBookRequestsDB();
    }
    
    public ResultSet viewContacts() throws SQLException, ClassNotFoundException{
        return viewContactsDB();
    }
}
