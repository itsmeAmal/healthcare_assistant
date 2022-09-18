/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.dao;

import com.pha.model.sensorData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rashmi
 */
public interface sensorDataDao {
    
    boolean addSensorData(sensorData sd)throws SQLException;
  
    boolean updateSensorData(sensorData sd)throws SQLException;
    
    boolean deleteSensorData(Integer id)throws SQLException;
    
    ResultSet getAllSensorData()throws SQLException;
    
    //----------------------------------------------------
    
    ResultSet getSensordataByAttribute(String attribute, String condition, String value)throws SQLException;
    
    ResultSet getSensordataByMoreAttribute(ArrayList<String[]> attributeConditionValueList, String operator)throws SQLException;
    
}
