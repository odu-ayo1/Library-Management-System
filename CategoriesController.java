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
public class CategoriesController extends Categories{
    public boolean addCategory(String category_name, String status) throws SQLException, ClassNotFoundException{
        
        return addCategoryDB(category_name, status);
        
    }
    
    public boolean updateCategory(String category_name, String status, int category_id) throws SQLException, ClassNotFoundException{
        
        return updateCategoryDB(category_name, status, category_id);
    }
    
    public boolean deleteCategory(int category_id) throws SQLException, ClassNotFoundException{
        return deleteCategoryDB(category_id);
    }
    
    public boolean deleteBookCategories(int category_id) throws SQLException, ClassNotFoundException{
        return deleteBookCategoriesDB(category_id);
    }
}
