/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.control;

import com.pha.core.CommonConstants;
import com.pha.core.Validations;
import com.pha.daoimpl.patientDaoImpl;
import com.pha.model.patient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Rashmi
 */
public class UserController {
    
    public static boolean addUser(String name, String currentAddress, String permanentAddress,
            Date dob, String contact1, String contact2, String email, String remark, String password) throws ParseException, SQLException{
        
        patient p = new patient();
        p.setName(name); 
        p.setCurrentAddress(currentAddress); 
        p.setPermanentAddress(permanentAddress);
        p.setDateOfBirth(Validations.getSqlDateByUtilDate(dob)); 
        p.setContact1(contact1);
        p.setContact2(contact2); 
        p.setEmail(email);
        p.setRemark(remark); 
        p.setPassword(password);
        return new patientDaoImpl().addPatient(p);

    }
    
    public static ResultSet getAllUsers() throws SQLException{
        return new patientDaoImpl().getAllPatients();
    }
    
    public static boolean deletePatient(int patientId)throws SQLException {
        return new patientDaoImpl().deletePatient(patientId);
    }
    
    public static patient getPatientById(Integer userPrimaryKey)throws SQLException{
        ResultSet rset = new patientDaoImpl().getPatientByAttribute("id", CommonConstants.sql.EQUAL, 
                Integer.toString(userPrimaryKey));
        patient pt = null;
        while (rset.next()) {            
            pt = new patient();
            pt.setId(rset.getInt("id"));
            pt.setName(rset.getString("name"));
            pt.setCurrentAddress(rset.getString("current_address"));
            pt.setPermanentAddress(rset.getString("permanent_address"));
            pt.setDateOfBirth(rset.getDate("dob"));
            pt.setContact1(rset.getString("contact_1"));
            pt.setContact2(rset.getString("contact_2"));
            pt.setEmail(rset.getString("email"));
            pt.setStatus(rset.getString("status")); 
            pt.setRemark(rset.getString("remark")); 
        }
        return pt;
    }
    
        public static patient getPatientByUserName(String userPrimaryKey)throws SQLException{
        ResultSet rset = new patientDaoImpl().getPatientByAttribute("email", CommonConstants.sql.EQUAL, 
                userPrimaryKey);
        patient pt = null;
        while (rset.next()) {            
            pt = new patient();
            pt.setId(rset.getInt("id"));
            pt.setName(rset.getString("name"));
            pt.setCurrentAddress(rset.getString("current_address"));
            pt.setPermanentAddress(rset.getString("permanent_address"));
            pt.setDateOfBirth(rset.getDate("dob"));
            pt.setContact1(rset.getString("contact_1"));
            pt.setContact2(rset.getString("contact_2"));
            pt.setEmail(rset.getString("email"));
            pt.setStatus(rset.getString("status")); 
            pt.setRemark(rset.getString("remark")); 
            pt.setPassword(rset.getString("user_password")); 
        }
        return pt;
    }
    
    
    public static boolean updatePatient(patient p)throws SQLException{
        return new patientDaoImpl().updatePatient(p);
    }
    
}
