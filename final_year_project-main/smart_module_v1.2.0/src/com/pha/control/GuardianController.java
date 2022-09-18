/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.control;

import com.pha.daoimpl.guardianDaoImpl;
import com.pha.model.guardian;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rashmi
 */
public class GuardianController  {

    public static boolean addGuardian(String name, String contactNo, String contactSms,
            String address, String remark) throws SQLException {
        guardian g = new guardian();
        g.setAddress(address);
        g.setContactNo(contactNo);
        g.setContactSms(contactSms);
        g.setName(name);
        g.setRemark(remark);
        return new guardianDaoImpl().addGuardian(g);
    }

    public static boolean updateguardian(Integer id, String name, String contactNo, String contactSms,
            String address, String remark) throws SQLException {

        guardian g = new guardian();
         g.setAddress(address);
         g.setContactNo(contactNo);
         g.setContactSms(contactSms);
         g.setName(name);
         g.setRemark(remark);
         g.setId(id);
         return new guardianDaoImpl().updateGuardian(g);
       
    }

    public static boolean deleteguardian(int guardianId) throws SQLException {
        return new guardianDaoImpl().deleteGuadian(guardianId);
    }

    public static ResultSet getAllguardian() throws SQLException {
        return new guardianDaoImpl().getAllGuardians();

    }

}
