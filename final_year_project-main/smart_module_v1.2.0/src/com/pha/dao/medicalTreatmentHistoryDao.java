/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.dao;

import com.pha.model.medicalTreatmentHistory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rashmi
 */
public interface medicalTreatmentHistoryDao {
    
    boolean addMedicalTreatmentHistory(medicalTreatmentHistory  history)throws SQLException;
    
    boolean updateMedicalTreatmentHistory(medicalTreatmentHistory history)throws SQLException;
    
    boolean deleteMedicalTreatmentHistory(Integer id)throws SQLException;
    
    ResultSet getAllMedicalTreatmentHistory()throws SQLException;
    
    //-----------------------------------------------------------
    
    ResultSet getMedicalTreatmentHistoryByAttribute(String attribute, String condition, String value)throws SQLException;
    
    ResultSet getMedicalTreatmentHistoryByMoreAttribute(ArrayList<String[]> attributeConditonValueList, String operator)throws SQLException;
    
}
