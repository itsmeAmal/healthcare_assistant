/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.control;

import com.pha.daoimpl.sensorDataDaoImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class SDController {

    public static void getBodyTemperature(String searchValue) throws SQLException {

        //id, patient_id, pulse_rate_string, pulse_rate_decimal, spo2_level_string, spo2_level_decimal, 
        //temp_string, temp_decimal, status, remark, create_on, create_by, update_on, update_by, deleted_on, deleted_by
        ArrayList<String[]> attributeCOnditionValueList = new ArrayList<>();

        String[] arr1 = {"holiday_date_from", " LIKE ", "%" + searchValue + "%"};
        attributeCOnditionValueList.add(arr1);

    }

    public static ResultSet getResultsetByDateAndPatientId(String searchDate, int patientId) throws SQLException {
        ArrayList<String[]> attributeCOnditionValueList = new ArrayList<>();

        String[] arr1 = {"create_on", " = ",  searchDate};
        attributeCOnditionValueList.add(arr1);
        
        String[] arr2 = {"patient_id", " = ",  Integer.toString(patientId)};
        attributeCOnditionValueList.add(arr2);
        
        return new sensorDataDaoImpl().getSensordataByMoreAttribute(attributeCOnditionValueList, " AND ");
    }

    public static ResultSet getAllRecords() throws SQLException{
        return new sensorDataDaoImpl().getAllSensorData();
    }
    
    
}
