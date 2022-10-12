/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.model;

/**
 *
 * @author malaa
 */
public class settings {
    
    //id, setting_code, setting_name, setting_value, remark
    
    private int id;
    private String settingCode;
    private String settingName;
    private String settingValue;
    private String remark;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the settingCode
     */
    public String getSettingCode() {
        return settingCode;
    }

    /**
     * @param settingCode the settingCode to set
     */
    public void setSettingCode(String settingCode) {
        this.settingCode = settingCode;
    }

    /**
     * @return the settingName
     */
    public String getSettingName() {
        return settingName;
    }

    /**
     * @param settingName the settingName to set
     */
    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }    

    /**
     * @return the settingValue
     */
    public String getSettingValue() {
        return settingValue;
    }

    /**
     * @param settingValue the settingValue to set
     */
    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }
    
}
