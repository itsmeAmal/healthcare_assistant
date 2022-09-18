/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.daoimpl;

import com.pha.connection.databaseConnection;
import com.pha.dao.guardianDao;
import com.pha.model.guardian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rashmi
 */
public class guardianDaoImpl implements guardianDao{
    
    
    private String selectQuery="select id, name, contact_no, contact_sms, "
            + "address, status, remark from guardian";
 
    @Override
    public boolean addGuardian(guardian g) throws SQLException {
       Connection con = databaseConnection.getDatabaseConnection();
        PreparedStatement ps =con.prepareStatement("insert into guardian(name, contact_no, contact_sms, "
            + "address, remark) values (?,?,?,?,?)");
       ps.setString(1, g.getName());
       ps.setString(2, g.getContactNo());
       ps.setString(3, g.getContactSms());
       ps.setString(4, g.getAddress());
       ps.setString(5, g.getRemark());
       ps.executeUpdate();
       ps.close();
       return true;
    }

    @Override
    public boolean updateGuardian(guardian g) throws SQLException {
        Connection con=databaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update guardian set name=?,contact_no=?, contact_sms=?, "
            + "address=?, remark=? where id=?");
        ps.setString(1,g.getName());
        ps.setString(2,g.getContactNo());
        ps.setString(3,g.getContactSms());
        ps.setString(4,g.getAddress());
        ps.setString(5,g.getRemark());
        ps.setInt(6, g.getId());
        ps.executeUpdate();
        ps.close();
        return true;
        
    }

    @Override
    public boolean deleteGuadian(Integer guardianId) throws SQLException {
        Connection con = databaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from guardian where id=?");
        ps.setInt(1, guardianId);
        ps.executeUpdate();
        con.close();
        return true;
    }

    @Override
    public ResultSet getAllGuardians() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getGuardianByAttribute(String attribute, String conditions, String value) throws SQLException {
       return new CommonDaoImpl().getResultByAttribute(selectQuery, attribute, conditions, value);
    }

    @Override
    public ResultSet getGuardianByMoreAttribute(ArrayList<String[]> attributeConditionValueList, String operator) throws SQLException {
        return new CommonDaoImpl().getResultByAttributesWithJoinOperator(selectQuery, attributeConditionValueList, operator);
    }

}
