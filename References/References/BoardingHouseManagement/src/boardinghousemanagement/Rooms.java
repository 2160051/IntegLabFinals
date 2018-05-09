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
public class Rooms {
    
    public Rooms(String letter, String num, String desc, String decks, String spaceAv, 
            String numOfBoarders, String state) {
        setLetter(letter);
        setNum(num);
        setRoomNo();
        setDesc(desc);
        setDecks(decks);
        setSpaceAvailable(spaceAv);
        setNumOfBoarders(numOfBoarders);
        setState(state);
    }
    
    public Rooms() {
        
    }
    
    public static void updateNoOfBoarders(String roomID) {
        String query = "SELECT * FROM ActiveBoarders INNER JOIN Rooms ON ActiveBoarders.RoomID=Rooms.RoomID "
                + "WHERE ActiveBoarders.RoomID='"+roomID+"';";
        int i = 0;
        int j = 0;
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                i++;
                j = getRs().getInt("SpaceAvailable");
            }
            
            String s = (i >= j ? "Full":"Available");
            
            getPst().close();
            
            String q = "UPDATE Rooms SET NoOfBoarders="+i+", Status='"+s+"' WHERE RoomID='"+roomID+"';";
            
            setPst(getConnection().prepareStatement(q));
            getPst().executeUpdate();
        }
        catch(Exception exception) {
            new Error("Error Adding to No. of Boarders.\n\nERROR: "+exception).showErrorDialog();
        }
    }
    
    public static void updateRoomTable() {
        String query = "SELECT RoomID as \"Room No\", Description, DeckNos as \"Number of Decks\", "
                + "SpaceAvailable  as \"Number of Space Available\", Status FROM Rooms ORDER BY RoomID";
        
        try {
            setConnection(Database.getConnection());
            setPst(connection_.prepareStatement(query));
            setRs(pst_.executeQuery());
            
            setTableModel(DbUtils.resultSetToTableModel(rs_));
        }
        catch(Exception exception) {
            new Error("Cannot initialized Rooms Table.\n\nERROR:    "+exception).showErrorDialog();
        }
    }

    public static String getLetter() {
        return letter_;
    }

    public static void setLetter(String letter) {
        letter_ = letter;
    }

    public static String getNum() {
        return num_;
    }

    public static void setNum(String num) {
        num_ = num;
    }

    public static String getRoomNo() {
        return roomNo_;
    }
    
    public static ArrayList<String> getRoomList() {
        String query = "SELECT RoomID FROM Rooms WHERE Status='Available' ORDER BY RoomID;";
        
        roomList = new ArrayList<>();
        
        try {
            setConnection(Database.getConnection());
            setPst(connection_.prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                roomList.add(rs_.getString(1));
            }
            
            return roomList;
        }
        catch(Exception exception) {
            new Error("Error loading array of Rooms! \n\n ERROR:    "+exception).showErrorDialog();
            return null;
        }
    }

    public static void setRoomNo() {
        roomNo_ = getLetter()+" - "+getNum();
    }

    public static String getDesc() {
        return desc_;
    }

    public static void setDesc(String desc) {
        desc_ = desc;
    }

    public static String getDecks() {
        return decks_;
    }

    public static void setDecks(String decks) {
        decks_ = decks;
    }

    public static String getSpaceAvailable() {
        return spaceAvailable_;
    }

    public static void setSpaceAvailable(String spaceAvailable) {
        spaceAvailable_ = spaceAvailable;
    }

    public static String getNumOfBoarders() {
        return numOfBoarders_;
    }

    public static void setNumOfBoarders(String numOfBoarders) {
        numOfBoarders_ = numOfBoarders;
    }

    public static String getState() {
        return state_;
    }

    public static void setState(String state) {
        state_ = state;
    }

    public void addRoom() {
        String query = "INSERT INTO Rooms (RoomID, Category, RoomNo, Description, DeckNos, "
                + "SpaceAvailable, NoOfBoarders, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            setPst(Database.getConnection().prepareStatement(query));
            
            getPst().setString(1, getRoomNo());
            getPst().setString(2, getLetter());
            getPst().setInt(3, Integer.parseInt(getNum()));
            getPst().setString(4, getDesc());
            getPst().setInt(5, Integer.parseInt(getDecks()));
            getPst().setInt(6, Integer.parseInt(getSpaceAvailable()));
            getPst().setInt(7, Integer.parseInt(getNumOfBoarders()));
            getPst().setString(8, getState());
            
            getPst().executeUpdate();
            
            JOptionPane.showMessageDialog(null, "NEW ROOM "+roomNo_+" SAVED!\n\n", "", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException | HeadlessException exception) {
            new Error("Error Adding Room# "+roomNo_+"\n\nERROR: "+exception).showErrorDialog();
        }
    }
    
    public static void deleteRoom(String roomID) {
        String query = "DELETE FROM Rooms WHERE RoomID='"+roomID+"';";
        
        try {
            setPst(Database.getConnection().prepareStatement(query));
            getPst().execute();
            
            JOptionPane.showMessageDialog(null, "ROOM "+roomID+" DELETED", "", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException | HeadlessException exception) {
            new Error("Error in deleting rate.\n\nERRROR: "+exception).showErrorDialog();
        }
    }
    
    public void updateRoom(String roomID) {
        String query = "UPDATE Rooms SET Description='"+getDesc()+"', DeckNos="+Integer.parseInt(getDecks())+", SpaceAvailable="+Integer.parseInt(getSpaceAvailable())+", NoOfBoarders="+Integer.parseInt(getNumOfBoarders())+", Status='"+getState()+"' WHERE RoomID='"+roomID+"';";
        
        try {
            setPst(Database.getConnection().prepareStatement(query));
            getPst().executeUpdate();
            
            JOptionPane.showMessageDialog(null, "ROOM "+roomID+" UPDATED", "", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException | HeadlessException exception) {
            new Error("ERROR UPDATING ROOM "+roomID+"\n\nERROR: "+exception).showErrorDialog();
        }
    }
    
    public static void getRoom(String roomID) {
        String query = "SELECT * FROM Rooms WHERE RoomID='"+roomID+"';";
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                setLetter(getRs().getString("Category"));
                setNum(getRs().getString("RoomNo"));
                setDesc(getRs().getString("Description"));
                setDecks(getRs().getString("DeckNos"));
                setSpaceAvailable(getRs().getString("SpaceAvailable"));
                setNumOfBoarders(getRs().getString("NoOfBoarders"));
                setState(getRs().getString("Status"));
            }
        }
        catch(Exception exception) {
            new Error("ERROR GETTING ROOM "+roomID+" DATA\n\nERROR: "+exception).showErrorDialog();
        }
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
    
    private static Connection connection_;
    private static PreparedStatement pst_;
    private static ResultSet rs_;
    
    private static TableModel tableModel_;
    
    private static String letter_;
    private static String num_;
    private static String roomNo_;
    private static String desc_;
    private static String decks_;
    private static String spaceAvailable_;
    private static String numOfBoarders_;
    private static String state_;
    
    private static ArrayList<String> roomList;
    
}
