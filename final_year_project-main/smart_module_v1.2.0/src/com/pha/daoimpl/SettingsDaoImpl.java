/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.daoimpl;

import com.pha.connection.databaseConnection;
import com.pha.dao.adminSettingDao;
import com.pha.model.settings;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author malaa
 */
public class SettingsDaoImpl implements adminSettingDao{

    @Override
    public boolean addSetting(settings s) throws SQLException {
        Connection con = databaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("");
        return false;
    }

    @Override
    public boolean updateSetting(settings s) throws SQLException {
        Connection con = databaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update settings set setting_code=?, setting_name=?, setting_value=? where id=?");
        ps.setString(1, s.getSettingCode());
        ps.setString(2, s.getSettingName());
        ps.setString(3, s.getSettingValue());
        ps.setInt(4, s.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean getSettingByAttribute(String attribute, String conditions, String value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
