/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardinghousemanagement;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class Rate {

    public Rate(String type, String amount, String desc) {
        setType(type);
        setAmount(amount);
        setDesc(desc);
    }

    public Rate() {
        
    }
    
    public static void updateRateTable() {
        String query = "SELECT RateID as \"Rate ID\", RateType as \"Rate Type\", RateDescription as \"Description\", RateAmount as \"Amount\" FROM Rates ORDER BY RateID";
        
        try {
            setConnection(Database.getConnection());
            setPst(connection_.prepareStatement(query));
            setRs(pst_.executeQuery());
            
            setTableModel(DbUtils.resultSetToTableModel(rs_));
        }
        catch(Exception exception) {
            new Error("Cannot initialized Rates Table.\n\nERROR:    "+exception).showErrorDialog();
        }
    }
    
    public void addRate() {
        String query = "INSERT INTO Rates (RateType, RateDescription, RateAmount) VALUES(?, ?, ?)";
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            
            getPst().setString(1, getType());
            getPst().setString(2, getDesc());
            getPst().setDouble(3, Double.parseDouble(getAmount()));
            
            getPst().executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Rate Saved!", "", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException | NumberFormatException exception) {
            new Error("Error adding new Rate Record.\n\nERROR: "+exception).showErrorDialog();
        }
    }
    
    public static void getRate(String rateID) {
        String query = "SELECT * FROM Rates WHERE RateID="+rateID+";";
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                setType(getRs().getString("RateType"));
                setDesc(getRs().getString("RateDescription"));
                setAmount(getRs().getString("RateAmount"));
            }
        }
        catch(Exception exception) {
            new Error("ERROR GETTING RATE DATA").showErrorDialog();
        }
    } 
    
    public static void deleteRate(String type) {
        String query = "DELETE FROM Rates WHERE RateType='"+type+"';";
        
        try {
            setPst(Database.getConnection().prepareStatement(query));
            getPst().execute();
            
            JOptionPane.showMessageDialog(null, "RATE DELETED", "", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException | HeadlessException exception) {
            new Error("Error in deleting rate.\n\nERRROR: "+exception).showErrorDialog();
        }
    }
    
    public void updateRate(String rateID) {
        String query = "UPDATE Rates SET RateType='"+getType()+"', RateDescription='"+getDesc()+"', RateAmount="+Double.parseDouble(getAmount())+" WHERE RateID="+Integer.parseInt(rateID)+";";
        
        try {
            setPst(Database.getConnection().prepareStatement(query));
            getPst().executeUpdate();
            
            JOptionPane.showMessageDialog(null, "RATE UPDATED", "", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException | HeadlessException exception) {
            new Error("ERROR UPDATING RATE "+getType()+"\n\nERROR: "+exception).showErrorDialog();
        }
    }
    
    public static ArrayList<String> getRateList() {
        String query = "SELECT RateType FROM Rates ORDER BY RateType;";
        
        rateList = new ArrayList<>();
        
        try {
            setConnection(Database.getConnection());
            setPst(connection_.prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                rateList.add(rs_.getString(1));
            }
            
            return rateList;
        }
        catch(Exception exception) {
            new Error("Error loading array of Rates! \n\n ERROR:    "+exception).showErrorDialog();
            return null;
        }
    }
    
    public static String getType() {
        return type_;
    }

    public static void setType(String type) {
        type_ = type;
    }

    public static String getAmount() {
        return amount_;
    }

    public static void setAmount(String amount) {
        amount_ = amount;
    }

    public static String getDesc() {
        return desc_;
    }

    public static void setDesc(String desc) {
        desc_ = desc;
    }

    public static Connection getConnection() {
        return connection_;
    }

    public static void setConnection(Connection connection) {
        connection_ = connection;
    }

    public static PreparedStatement getPst() {
        return pst_;
    }

    public static void setPst(PreparedStatement pst) {
        pst_ = pst;
    }

    public static ResultSet getRs() {
        return rs_;
    }

    public static void setRs(ResultSet rs) {
        rs_ = rs;
    }

    public static TableModel getTableModel() {
        return tableModel_;
    }

    public static void setTableModel(TableModel tableModel) {
        tableModel_ = tableModel;
    }
    
    private static String type_;
    private static String amount_;
    private static String desc_;
    
    private static Connection connection_;
    private static PreparedStatement pst_;
    private static ResultSet rs_;
    
    private static ArrayList<String> rateList;
    
    private static TableModel tableModel_;
}
