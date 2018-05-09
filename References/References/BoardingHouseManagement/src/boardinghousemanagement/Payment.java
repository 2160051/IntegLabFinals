/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardinghousemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class Payment {
    
    public Payment() {
        
    }
    
    public static TableModel getPaymentTable() {
        String query = "SELECT ActiveBoarders.BoarderID, Boarders.FirstName as \"First Name\", "
                + "Boarders.MiddleName as \"Middle Name\", Boarders.LastName as \"Last Name\", "
                + "Boarders.Type, Rates.RateAmount as \"Rental\" "
                + "FROM (ActiveBoarders INNER JOIN Boarders ON ActiveBoarders.BoarderID=Boarders.BoarderID) "
                + "INNER JOIN Rates ON ActiveBoarders.RateID=Rates.RateID ORDER BY ActiveBoarders.BoarderID;";
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            return DbUtils.resultSetToTableModel(getRs());
        }
        catch(Exception exception) {
            new Error("Error initializing payment tabel\n\nERROR: "+exception).showErrorDialog();
            return null;
        }
    }
    
    public static String getRental(String boarderID) {        
        String query = "SELECT ActiveBoarders.RateID, Rates.RateAmount FROM ActiveBoarders "
                + "INNER JOIN Rates ON ActiveBoarders.RateID = Rates.RateID "
                + "WHERE ActiveBoarders.BoarderID="+Integer.parseInt(boarderID)+";";
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                setRentAmount(getRs().getString("RateAmount"));
                setRateID(getRs().getString("RateID"));
            }
            
            return getRentAmount();
        }
        catch(Exception exception) {
            new Error("Error getting border "+boarderID+" data.\n\nERROR: "+exception).showErrorDialog();
            
            return null;
        }
    }
    
    public static String getRentalDate(String boarderID) {
        String query = "SELECT PaymentDate FROM Payments "
                + "WHERE BoarderID = "+Integer.parseInt(boarderID)+";";
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            int i = 0;
            
            while(getRs().next()) {
                setDate(getRs().getString("PaymentDate"));
                
                i++;
            }
            
            if(i == 0) {
                setConnection(Database.getConnection());
                setPst(getConnection().prepareStatement("SELECT DateAdded FROM ActiveBoarders "
                        + "WHERE BoarderID = "+Integer.parseInt(boarderID)+";"));
                setRs(getPst().executeQuery());
                
                while(getRs().next()) {
                    setDate(getRs().getString("DateAdded"));
                }
            }
            
            return getDate();
        }
        catch(SQLException | NumberFormatException exception) {
            new Error("Error getting border "+boarderID+" data.\n\nERROR: "+exception).showErrorDialog();
            
            return null;
        }
    }

    public static String computePenalty(String date) {
        try {
            Calendar now = Calendar.getInstance();
            Calendar sd = Calendar.getInstance();
                    
            Date d = new SimpleDateFormat("MMMM dd, yyyy").parse(date);
            sd.setTime(d);
            sd.add(Calendar.MONTH, 1);
            
            long diff;
            
            if(now.after(sd)) {
                Date nd = sd.getTime();
                Date n = now.getTime();
                
                long ndt = nd.getTime();
                long nt = n.getTime();
                
                diff = (nt - ndt) / (1000 * 60 * 60 * 24);
                
                setRentPenalty(String.valueOf(diff * 10));
            }
            else {
                setRentPenalty("0.0");
            }
                      
            return getRentPenalty();
        }
        catch(Exception exception) {
            new Error("Error Computing penalty.\n\nERROR: "+exception).showErrorDialog();
            
            return "0.0";
        }
    }
    
    public static void addPayment(String boarderID, String rateID, String penalty) {
        String query = "INSERT INTO Payments (BoarderID, RateID, Penalty, PaymentDate) VALUES(?, ?, ?, ?);";
        String payDate = new SimpleDateFormat("MMMM dd, yyyy").format(new Date());
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            
            getPst().setInt(1, Integer.parseInt(boarderID));
            getPst().setInt(2, Integer.parseInt(rateID));
            getPst().setDouble(3, Double.parseDouble(penalty));
            getPst().setString(4, payDate);
            
            getPst().executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Boarder "+boarderID+" Payment submitted.", "", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException | NumberFormatException exception) {
            new Error("Error submitting payment.\n\nERROR: "+exception).showErrorDialog();
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        Payment.connection = connection;
    }

    public static PreparedStatement getPst() {
        return pst;
    }

    public static void setPst(PreparedStatement pst) {
        Payment.pst = pst;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet rs) {
        Payment.rs = rs;
    }

    public static String getBoarderID() {
        return boarderID;
    }

    public static void setBoarderID(String boarderID) {
        Payment.boarderID = boarderID;
    }

    public static String getRoomID() {
        return roomID;
    }

    public static void setRoomID(String roomID) {
        Payment.roomID = roomID;
    }

    public static String getRateID() {
        return rateID;
    }

    public static void setRateID(String rateID) {
        Payment.rateID = rateID;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        Payment.date = date;
    }

    public static String getRentDate() {
        return rentDate;
    }

    public static void setRentDate(String rentDate) {
        Payment.rentDate = rentDate;
    }

    public static String getRentAmount() {
        return rentAmount;
    }

    public static void setRentAmount(String rentAmount) {
        Payment.rentAmount = rentAmount;
    }

    public static String getRentPenalty() {
        return rentPenalty;
    }

    public static void setRentPenalty(String rentPenalty) {
        Payment.rentPenalty = rentPenalty;
    }
    
    private static Connection connection;
    private static PreparedStatement pst;
    private static ResultSet rs;
    
    private static String boarderID;
    private static String roomID;
    private static String rateID;
    
    private static String date;
    private static String rentDate;
    private static String rentAmount;
    private static String rentPenalty;    
}