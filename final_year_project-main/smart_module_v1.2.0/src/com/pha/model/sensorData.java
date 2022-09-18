/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.model;

import com.pha.util.commonBase;
import java.math.BigDecimal;

/**
 *
 * @author Rashmi
 */
public class sensorData extends commonBase{
    //id, patient_id, pulse_rate_string, pulse_rate_decimal, spo2_level_string, spo2_level_decimal, temp_string, temp_decimal, status, remark, 
    //create_on, create_by, update_on, update_by, deleted_on, deleted_by
    
    private Integer id;
    private Integer patientId;
    private String pulseRateString;
    private BigDecimal pulseRateDecimal;
    private String spo2LevelStrng;
    private BigDecimal spo2LevelDecimal;
    private String tempString;
    private BigDecimal tempDecimal;
    private String status;
    private String remark;

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
     * @return the patientId
     */
    public Integer getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the pulseRateString
     */
    public String getPulseRateString() {
        return pulseRateString;
    }

    /**
     * @param pulseRateString the pulseRateString to set
     */
    public void setPulseRateString(String pulseRateString) {
        this.pulseRateString = pulseRateString;
    }

    /**
     * @return the pulseRateDecimal
     */
    public BigDecimal getPulseRateDecimal() {
        return pulseRateDecimal;
    }

    /**
     * @param pulseRateDecimal the pulseRateDecimal to set
     */
    public void setPulseRateDecimal(BigDecimal pulseRateDecimal) {
        this.pulseRateDecimal = pulseRateDecimal;
    }

    /**
     * @return the spo2LevelStrng
     */
    public String getSpo2LevelStrng() {
        return spo2LevelStrng;
    }

    /**
     * @param spo2LevelStrng the spo2LevelStrng to set
     */
    public void setSpo2LevelStrng(String spo2LevelStrng) {
        this.spo2LevelStrng = spo2LevelStrng;
    }

    /**
     * @return the spo2LevelDecimal
     */
    public BigDecimal getSpo2LevelDecimal() {
        return spo2LevelDecimal;
    }

    /**
     * @param spo2LevelDecimal the spo2LevelDecimal to set
     */
    public void setSpo2LevelDecimal(BigDecimal spo2LevelDecimal) {
        this.spo2LevelDecimal = spo2LevelDecimal;
    }

    /**
     * @return the tempString
     */
    public String getTempString() {
        return tempString;
    }

    /**
     * @param tempString the tempString to set
     */
    public void setTempString(String tempString) {
        this.tempString = tempString;
    }

    /**
     * @return the tempDecimal
     */
    public BigDecimal getTempDecimal() {
        return tempDecimal;
    }

    /**
     * @param tempDecimal the tempDecimal to set
     */
    public void setTempDecimal(BigDecimal tempDecimal) {
        this.tempDecimal = tempDecimal;
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
       
}
