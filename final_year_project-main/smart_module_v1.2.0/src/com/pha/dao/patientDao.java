/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.dao;

import com.pha.model.patient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rashmi
 */
public interface patientDao {
    
    boolean addPatient(patient p)throws SQLException;
    
    boolean updatePatient(patient q)throws SQLException;
    
    boolean deletePatient(Integer patientId)throws SQLException;
    
    ResultSet getAllPatients()throws SQLException;
    
    //----------------------------------------
    
    ResultSet getPatientByAttribute(String attribute, String condition, String value)throws SQLException;
    
    ResultSet getPatientsByMoreAttribute(ArrayList<String[]> attributeConditionValueList, String operator) throws SQLException;
    
}
