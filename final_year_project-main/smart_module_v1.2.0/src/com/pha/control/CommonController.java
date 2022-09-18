/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.control;


import com.pha.connection.databaseConnection;
import com.pha.core.Validations;
import com.pha.model.DataObject;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Amal
 */
public class CommonController {

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isLong(String value) {
        try {
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isBigdDecimal(String value) {
        try {
            new BigDecimal(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getSqlTimeFromSeparateHoursAndMinutes(String Hours, String Minutes) {
//        07:30:00 format is standard time format for time in sql
        return Hours + ":" + Minutes + ":" + "00";
    }

    public static Time getMysqlEndTimeFromStartTimeAndTimeGap(String lectureStartTime, String TimeGap) {
        String[] lectureStartTimeArray = lectureStartTime.split(":");

        int timeGapStartHour = getIntOrZeroFromString(lectureStartTimeArray[0]);
        int timeGapStartMinute = getIntOrZeroFromString(lectureStartTimeArray[1]);

        String[] timeGap = TimeGap.split(":");

        int hoursOutPut = getIntOrZeroFromString(timeGap[0]) + timeGapStartHour;
        int minutesOutPut = getIntOrZeroFromString(timeGap[1]) + timeGapStartMinute;

        return java.sql.Time.valueOf(hoursOutPut + ":" + minutesOutPut + ":" + "00");
    }

    public static boolean isRecordAvailableInDeliveryPlanDetailUiTable(JTable table, Date SelectedDate,
            String LectureStartTime, String Level) {
        boolean Status = false;
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        /*
        lecture start time column = 10
        Lecture duration = 11
        Lecture end time = 13
        Lecture date = 0
        Level = 1
        location = 7
         */
        for (int i = 0; i < dtm.getRowCount(); i++) {
            if (dtm.getValueAt(i, 0).toString().equalsIgnoreCase(SelectedDate.toString())
                    && dtm.getValueAt(i, 10).toString().equalsIgnoreCase(LectureStartTime)
                    && dtm.getValueAt(i, 1).toString().equalsIgnoreCase(Level)) {
                Status = true;
            }
        }
        return Status;
    }

    public static int getIntOrZeroFromString(String value) {
        if (isInteger(value)) {
            return Integer.parseInt(value);
        } else {
            return 0;
        }
    }

//    public static java.sql.Date getMysqlDateFromJDateChooser(JDateChooser dateChooser) {
//        if (dateChooser.getDate() == null) {
//            return null;
//        }
//        java.sql.Date sqlDate = new java.sql.Date(dateChooser.getDate().getTime());
//        return sqlDate;
//    }

    public static java.sql.Date getCurrentJavaSqlDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Time getCurrentJavaSqlTime() {
        java.util.Date date = new java.util.Date();
        return new java.sql.Time(date.getTime());
    }

    public static void loadDataToDetailTable(JTable table, ResultSet rst, String[] columnList, String column1,
            String column2) throws SQLException {
        BigDecimal value1 = BigDecimal.ZERO;
        BigDecimal value2 = BigDecimal.ZERO;
        DefaultTableModel dtm1 = (DefaultTableModel) table.getModel();
        int rw = dtm1.getRowCount();
        for (int i = 0; i < rw; i++) {
            dtm1.removeRow(0);
        }
        while (rst.next()) {
            Object[] rowCells = new Object[columnList.length + 1];
            for (int i = 0; i < columnList.length; i++) {
                rowCells[i] = rst.getString(columnList[i]);
                if (i == columnList.length - 1) {
                    value1 = Validations.getBigDecimalFromString(rst.getString(column1));
                    value2 = Validations.getBigDecimalFromString(rst.getString(column2));
                    rowCells[i + 1] = Validations.formatWithTwoDigits(value1.multiply(value2).toString());
                }
            }
            dtm1.addRow(rowCells);
        }

    }

    public static void removeAllRowsFromTable(JTable table) {
        DefaultTableModel dtm1 = (DefaultTableModel) table.getModel();
        int rw = dtm1.getRowCount();
        for (int i = 0; i < rw; i++) {
            dtm1.removeRow(0);
        }
    }

    public static void loadDataToTable(JTable table, ResultSet rst, String[] columnList) throws SQLException {
        DefaultTableModel dtm1 = (DefaultTableModel) table.getModel();
        int rw = dtm1.getRowCount();
        for (int i = 0; i < rw; i++) {
            dtm1.removeRow(0);
        }
        while (rst.next()) {
            Object[] rowCells = new Object[columnList.length];
            for (int i = 0; i < columnList.length; i++) {
                rowCells[i] = rst.getString(columnList[i]);
            }
            dtm1.addRow(rowCells);
        }
        rst.getStatement().close();
        rst.close();
    }

    public static void loadDataToComboBox(JComboBox comboBox, ResultSet rst, String attribute) throws SQLException {
        comboBox.removeAllItems();
        while (rst.next()) {
            comboBox.addItem(rst.getString(attribute));
        }
    }

    public static String decryptActivation(String activationKey) {
        String[] arr = activationKey.split("-");
        String concatinatedYear = arr[1];
        String year = concatinatedYear.substring(0, 4);

        String concatinatedMonth = arr[3];
        String month = concatinatedMonth.substring(3, 4);

        String date = arr[4];

        String decryptedKey = year + "-" + month + "-" + date;
        return decryptedKey;
    }
    
//
//    public static void printCommonReport(String reportName, HashMap<String, Object> hm) throws SQLException, JRException {
////        HashMap<String, Object> hm = new HashMap<>();
////        hm.put("shopName", Loading.getShopName());
//        Connection con = databaseConnection.getDatabaseConnection();
//        JasperDesign jsd = JRXmlLoader.load("C:\\reports\\" + reportName + ".jrxml"); //src\\cazzendra\\pos\\
//        JasperReport jr = JasperCompileManager.compileReport(jsd);
//        JasperPrint jp = JasperFillManager.fillReport(jr, hm, con);
//        JasperViewer jasperViewer = new JasperViewer(jp, false);
//        jasperViewer.setVisible(true);
//    }

    public static void loadDataObjectsIntoComboBox(JComboBox comboBox, ResultSet rst, String[] columnList,
            String defaultAttribute) throws SQLException {
        comboBox.removeAllItems();
        while (rst.next()) {
            DataObject object = new DataObject(defaultAttribute);
            for (int i = 0; i < columnList.length; i++) {
                object.addProperty(columnList[i], rst.getString(columnList[i]));
            }
            comboBox.addItem(object);
        }
    }
}

//String uerAccName = System.getProperty("user.name");
