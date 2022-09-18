/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.daoimpl;

import com.pha.connection.databaseConnection;
import com.pha.control.CommonController;
import com.pha.dao.patientDao;
import com.pha.model.patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rashmi
 */
public class patientDaoImpl implements patientDao{

    private String selectQuery = "select id, name, current_address, permanent_address, dob, contact_1, contact_2, "
            + " email, status, remark, create_on, create_by, deleted_on, deleted_by, update_on, update_by, "
            + " user_password from patient_reg_data";
    
    @Override
    public boolean addPatient(patient p) throws SQLException {
        Connection con = databaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into patient_reg_data (name, current_address, "
                + " permanent_address, dob, contact_1, "
                + "contact_2, email, remark, create_by, user_password) values (?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, p.getName());
        ps.setString(2, p.getCurrentAddress());
        ps.setString(3, p.getPermanentAddress());
        ps.setDate(4, p.getDateOfBirth()); 
        ps.setString(5, p.getContact1());
        ps.setString(6, p.getContact2()); 
        ps.setString(7, p.getEmail());
        ps.setString(8, p.getRemark());
        ps.setString(9, p.getCreateBy());
        ps.setString(10, p.getPassword());
        ps.executeUpdate();
        ps.close();
        return true;       
    }

    @Override
    public boolean updatePatient(patient p) throws SQLException { 
        Connection con = databaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update patient_reg_data set name=?, current_address=?, permanent_address=?, "
                + " dob=?, contact_1=?, contact_2=?, email=?, remark=?, update_on=? where id=?");
        ps.setString(1, p.getName());
        ps.setString(2, p.getCurrentAddress());
        ps.setString(3, p.getPermanentAddress());
        ps.setDate(4, p.getDateOfBirth()); 
        ps.setString(5, p.getContact1());
        ps.setString(6, p.getContact2()); 
        ps.setString(7, p.getEmail());
        ps.setString(8, p.getRemark());
        ps.setDate(9, CommonController.getCurrentJavaSqlDate());
        ps.setInt(10, p.getId()); 
        ps.executeUpdate();
        ps.close();
        return true;  
        
    }

    @Override
    public boolean deletePatient(Integer patientId) throws SQLException {
        Connection con = databaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from patient_reg_data where id=?");
        ps.setInt(1, patientId);
        ps.executeUpdate();
        con.close();
        return true;
    }

    @Override
    public ResultSet getAllPatients() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getPatientByAttribute(String attribute, String condition, String value) throws SQLException {
        return new CommonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    @Override
    public ResultSet getPatientsByMoreAttribute(ArrayList<String[]> attributeConditionValueList, String operator) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
