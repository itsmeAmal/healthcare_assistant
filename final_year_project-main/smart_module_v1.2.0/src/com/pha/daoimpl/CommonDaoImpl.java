/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.daoimpl;

import com.pha.connection.databaseConnection;
import com.pha.core.CommonConstants;
import com.pha.dao.commonDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 4m4l
 */
public class CommonDaoImpl implements commonDao {

    @Override
    public ResultSet getAllRecords(String selectQuery) throws SQLException {
        Connection con = databaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement(selectQuery);
        ResultSet rset = ps.executeQuery();
        return rset;
    }

    @Override
    public ResultSet getResultByAttribute(String selectQuery, String attribute, String condition, String value) throws SQLException {
        Connection con = databaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement(selectQuery + CommonConstants.sql.WHERE + attribute
                + condition + CommonConstants.sql.PARAMETER);
        ps.setString(1, value);
        ResultSet rset = ps.executeQuery();
        return rset;
    }

    public ResultSet getResultByAttributesWithJoinOperator(String selectQuery,
            ArrayList<String[]> attributeConditionValueList, String operator) throws SQLException {

        Connection con = databaseConnection.getDatabaseConnection();
        PreparedStatement ps;
        int noOfConditions = attributeConditionValueList.size();
        if (noOfConditions == 0) {
            ps = con.prepareStatement(selectQuery);
        } else {
            String query = selectQuery + CommonConstants.sql.WHERE + attributeConditionValueList.get(0)[0]
                    + attributeConditionValueList.get(0)[1] + CommonConstants.sql.PARAMETER;

            for (int i = 1; i < noOfConditions; i++) {
                query = query + operator + attributeConditionValueList.get(i)[0]
                        + attributeConditionValueList.get(i)[1] + CommonConstants.sql.PARAMETER;
            }

            ps = con.prepareStatement(query);
            for (int i = 0; i < noOfConditions; i++) {
                ps.setString(i + 1, attributeConditionValueList.get(i)[2]);
            }
        }
        ResultSet rst = ps.executeQuery();
        return rst;
    }
}
