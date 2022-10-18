/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.daoimpl;

import com.pha.connection.databaseConnection;
import com.pha.dao.sensorDataDao;
import com.pha.model.sensorData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author malaa
 */
public class sensorDataDaoImpl implements sensorDataDao{
    
    private String selectQuery = "select id, patient_id, pulse_rate_string, pulse_rate_decimal, spo2_level_string, "
            + " spo2_level_decimal, temp_string, temp_decimal, status, remark, create_on, create_by, update_on, "
            + " update_by, deleted_on, deleted_by sensor_data";

    @Override
    public boolean addSensorData(sensorData sd) throws SQLException {
        Connection con = databaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into sensor_data (patient_id, pulse_rate_string, pulse_rate_decimal, "
                + "spo2_level_string, spo2_level_decimal, temp_string, temp_decimal, status, remark) values (?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, sd.getPatientId());
        ps.setString(2, sd.getPulseRateString());
        ps.setBigDecimal(3, sd.getPulseRateDecimal());
        ps.setString(4, sd.getSpo2LevelStrng());
        ps.setBigDecimal(5, sd.getSpo2LevelDecimal());
        ps.setString(6, sd.getTempString());
        ps.setBigDecimal(7, sd.getTempDecimal()); 
        ps.setString(8, sd.getStatus());
        ps.setString(9, sd.getRemark());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean updateSensorData(sensorData sd) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSensorData(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAllSensorData() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getSensordataByAttribute(String attribute, String condition, String value) throws SQLException {
        return new CommonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    @Override
    public ResultSet getSensordataByMoreAttribute(ArrayList<String[]> attributeConditionValueList, String operator) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
