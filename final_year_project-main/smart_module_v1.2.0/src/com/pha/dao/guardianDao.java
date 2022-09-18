/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.dao;

import com.pha.model.guardian;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rashmi
 */
public interface guardianDao {
    
    boolean addGuardian(guardian g) throws SQLException;
    
    boolean updateGuardian(guardian g)throws SQLException;
      
    boolean deleteGuadian(Integer guardianId)throws SQLException;
   
    ResultSet getAllGuardians()throws SQLException;
    
    
    ResultSet getGuardianByAttribute(String attribute,String conditions,String value) throws SQLException;
    
    ResultSet getGuardianByMoreAttribute(ArrayList<String[]>attributeConditionValueList,String operator)throws SQLException;
}
