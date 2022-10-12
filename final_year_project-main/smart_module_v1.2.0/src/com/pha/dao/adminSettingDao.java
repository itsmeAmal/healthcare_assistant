/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.dao;

import com.pha.model.settings;
import java.sql.SQLException;

/**
 *
 * @author malaa
 */
public interface adminSettingDao {
    
    boolean addSetting(settings s) throws SQLException;
    
    boolean updateSetting(settings s) throws SQLException;
    
    boolean getSettingByAttribute(String attribute,String conditions,String value)throws SQLException;
    
}
