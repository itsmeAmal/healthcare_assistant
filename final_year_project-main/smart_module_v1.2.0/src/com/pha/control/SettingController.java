/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.control;

import com.pha.daoimpl.SettingsDaoImpl;
import com.pha.model.settings;
import java.sql.SQLException;

/**
 *
 * @author malaa
 */
public class SettingController {
    
    public static boolean updateSetting(String value, int id)throws SQLException{
        settings s = new settings();
        s.setId(id);
        s.setSettingValue(value);
        return new SettingsDaoImpl().updateSetting(s);
    }
    
    
}
