/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.model;

import com.pha.util.commonBase;

/**
 *
 * @author Rashmi
 */
public class adminUser extends commonBase {
    
    //id, admin_user_name, admin_user_password, status
    
    private Integer id;
    private String adminUserName;
    private String adminUserPassword;
    private String status;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the adminUserName
     */
    public String getAdminUserName() {
        return adminUserName;
    }

    /**
     * @param adminUserName the adminUserName to set
     */
    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    /**
     * @return the adminUserPassword
     */
    public String getAdminUserPassword() {
        return adminUserPassword;
    }

    /**
     * @param adminUserPassword the adminUserPassword to set
     */
    public void setAdminUserPassword(String adminUserPassword) {
        this.adminUserPassword = adminUserPassword;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
  
    
    
}
