/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.util;

import java.sql.Date;

/**
 *
 * @author Rashmi
 */
public class commonBase {
    
    private String createBy;
    private Date createOn;
    private String updateBy;
    private Date updateOn;
    private String deletedBy;
    private Date deletedOn;

    /**
     * @return the createBy
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy the createBy to set
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * @return the createOn
     */
    public Date getCreateOn() {
        return createOn;
    }

    /**
     * @param createOn the createOn to set
     */
    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    /**
     * @return the updateBy
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy the updateBy to set
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * @return the updateOn
     */
    public Date getUpdateOn() {
        return updateOn;
    }

    /**
     * @param updateOn the updateOn to set
     */
    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    /**
     * @return the deletedBy
     */
    public String getDeletedBy() {
        return deletedBy;
    }

    /**
     * @param deletedBy the deletedBy to set
     */
    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    /**
     * @return the deletedOn
     */
    public Date getDeletedOn() {
        return deletedOn;
    }

    /**
     * @param deletedOn the deletedOn to set
     */
    public void setDeletedOn(Date deletedOn) {
        this.deletedOn = deletedOn;
    }
    
}
