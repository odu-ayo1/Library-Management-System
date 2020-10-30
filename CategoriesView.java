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
public class CategoriesView extends Categories {
    public ResultSet viewCategories() throws SQLException, ClassNotFoundException{
        return viewCategoriesDB();
    }
    
    public ResultSet getCategoryDetails(int category_id) throws SQLException, ClassNotFoundException{
        return getCategoryDetailsDB(category_id);
    }
}
