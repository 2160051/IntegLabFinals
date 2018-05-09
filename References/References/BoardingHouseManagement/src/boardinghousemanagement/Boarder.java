/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardinghousemanagement;

import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class Boarder {
    
    public Boarder(String RoomID, String boarderID, String firstName, String middleName, 
            String lastName, String brgy, String town, String prov, String mobile, String age, 
            String gender, String status, String type, String rateID, String pFirstName, 
            String pMiddleName, String pLastName, String picPath) {
        setRoomID(RoomID);
        setBoarderID(boarderID);
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setFullName();
        setBrgy(brgy);
        setTown(town);
        setProv(prov);
        setAddress();
        setAge(age);
        setGender(gender);
        setStatus(status);
        setType(type);
        setRateID(rateID);
        setParentFirstName(pFirstName);
        setParentMiddleName(pMiddleName);
        setParentLastName(pLastName);
        setParentFullName();
        setPicPath(picPath);
    }
    
    public static void updateBoarderTable() {
        String query = "SELECT BoarderID as \"Boarder ID\", FirstName as \"First Name\", MiddleName as \"Middle Name\", "
                + "LastName as \"Last Name\", Type as \"Boarder Type\" FROM Boarders ORDER BY BoarderID;";
        
        try {
            setConnection(Database.getConnection());
            setPst(connection_.prepareStatement(query));
            setRs(pst_.executeQuery());
            
            setTableModel(DbUtils.resultSetToTableModel(rs_));
        }
        catch(Exception exception) {
            new Error("Cannot initialized Boarders Table.\n\nERROR:    "+exception).showErrorDialog();
        }
    }
    
    public Boarder() {
        
    }
    
    public static void getBoarder(String boarderID) {
        String query = "SELECT ActiveBoarders.RoomID, "
                + "Boarders.BoarderID, Boarders.FirstName, Boarders.MiddleName, "
                + "Boarders.LastName, Boarders.Brgy, Boarders.Town, Boarders.Province, "
                + "Boarders.Status, Boarders.Age, Boarders.Gender, Boarders.MobileNo, Boarders.PicPath "
                + "FROM ActiveBoarders INNER JOIN Boarders ON Boarders.BoarderID=ActiveBoarders.BoarderID "
                + "WHERE ActiveBoarders.BoarderID = "+Integer.parseInt(boarderID)+";";
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                setRoomID(getRs().getString("RoomID"));
                setBoarderID(getRs().getString("BoarderID"));
                setFirstName(getRs().getString("FirstName"));
                setMiddleName(getRs().getString("MiddleName"));
                setLastName(getRs().getString("LastName"));
                setFullName();
                setBrgy(getRs().getString("Brgy"));
                setTown(getRs().getString("Town"));
                setProv(getRs().getString("Province"));
                setAddress();
                setStatus(getRs().getString("Status"));
                setAge(getRs().getString("Age"));
                setGender(getRs().getString("Gender"));
                setMobile(getRs().getString("MobileNo"));
                setPicPath(getRs().getString("PicPath"));
            }
        }
        catch(Exception exception) {
            new Error("Error getting Boarder "+boarderID+" Data.\n\nERROR: "+exception).showErrorDialog();
        }
    }
    
    public static TableModel getActiveBoarders() {
        String query = "SELECT ActiveBoarders.RoomID, Boarders.BoarderID, Boarders.FirstName, "
                + "Boarders.MiddleName, Boarders.LastName "
                + "FROM ActiveBoarders INNER JOIN Boarders ON ActiveBoarders.BoarderID=Boarders.BoarderID "
                + "ORDER BY ActiveBoarders.RoomID;";
        
        try {
            setConnection(Database.getConnection());
            setPst(connection_.prepareStatement(query));
            setRs(pst_.executeQuery());
            
            return DbUtils.resultSetToTableModel(rs_);
        }
        catch(Exception exception) {
            new Error("Cannot initialized Boarders Table.\n\nERROR:    "+exception).showErrorDialog();
            return null;
        }
    }
    
    public void addBorder() {
        String query = "INSERT INTO Boarders (BoarderID, FirstName, MiddleName, LastName, "
                + "Brgy, Town, Province, Age, Gender, Status, MobileNo, "
                + "P_fName, P_mName, P_lName, Type, PicPath) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            
            getPst().setInt(1, Integer.parseInt(getBoarderID()));
            getPst().setString(2, getFirstName());
            getPst().setString(3, getMiddleName());
            getPst().setString(4, getLastName());
            getPst().setString(5, getBrgy());
            getPst().setString(6, getTown());
            getPst().setString(7, getProv());
            getPst().setInt(8, Integer.parseInt(getAge()));
            getPst().setString(9, getGender());
            getPst().setString(10, getStatus());
            getPst().setString(11, getMobile());
            getPst().setString(12, getParentFirstName());
            getPst().setString(13, getParentMiddleName());
            getPst().setString(14, getParentLastName());
            getPst().setString(15, getType());
            uploadPhoto();
            getPst().setString(16, getPicPath());
            
            getPst().executeUpdate();
            pst_.close();
            
            query = "INSERT INTO ActiveBoarders (BoarderID, RoomID, RateID, DateAdded) VALUES (?, ?, ?, ?);";
            
            setPst(getConnection().prepareStatement(query));
            
            getPst().setInt(1, Integer.parseInt(getBoarderID()));
            getPst().setString(2, getRoomID());
            getPst().setInt(3, Integer.parseInt(getRateID()));
            getPst().setString(4, String.valueOf(new SimpleDateFormat("MMMM dd, yyyy").format(new Date())));
            
            getPst().executeUpdate();
            pst_.close();
            
            JOptionPane.showMessageDialog(null, "New Boarder "+getBoarderID()+" Saved!", "", JOptionPane.INFORMATION_MESSAGE);
            
            Rooms.updateNoOfBoarders(getRoomID());
        }
        catch(SQLException | NumberFormatException exception) {
            new Error("Cannot save Boarder "+getBoarderID()+"\n\nERROR: "+exception).showErrorDialog();
        }
    }
    
    public static void deleteBorder(String boarderID, String roomID) {
        String query = "DELETE ActiveBoarders.*, Boarders.* FROM ActiveBoarders INNER JOIN Boarders "
                + "ON ActiveBoarders.BoarderID=Boarders.BoarderID "
                + "WHERE ActiveBoarders.BoarderID="+Integer.parseInt(boarderID)+"; ";
        
        try {
            deletePhoto(boarderID);
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            getPst().execute();
            
            JOptionPane.showMessageDialog(null, boarderID+" Deleted", "", JOptionPane.INFORMATION_MESSAGE);
            
            Rooms.updateNoOfBoarders(roomID);
        }
        catch(SQLException | HeadlessException exception) {
            new Error("Error Deleting Boarder "+boarderID+" ERROR\n\nERROR: "+exception).showErrorDialog();
        }
    }

    private void uploadPhoto() {
        File out = null;
        File file;
        BufferedImage newImg = null;
        
        file = new File(getPicPath());
        
        try {
            newImg = ImageIO.read(file);
            out = new File("Images/"+"Boarder "+getBoarderID()+" - pic.png");            
        }
        catch(Exception exception) {
            new Error("ERROR READING IMAGE!\n\nERROR: "+exception).showErrorDialog();
        }
        
        try { 
            ImageIO.write(newImg, "png", out);
            setPicPath(out.toString());
        } 
        catch (Exception exception) {
            new Error("ERROR UPLOADING IMAGE!\n\nERROR: "+exception).showErrorDialog();
        }
    }
    
    private static void deletePhoto(String boarderID) {
        String query = "SELECT PicPath FROM Boarders WHERE BoarderID="+Integer.parseInt(boarderID)+";";
        File file = null;
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                file = new File(getRs().getString("PicPath"));
            }
            
            if(file.delete()) {
            }
            else {
                new Error("Error deleting File.").showErrorDialog();
            }
        }
        catch(Exception exception) {
            new Error("Error deleting File.\n\nERROR: "+exception).showErrorDialog();
        }
    }
    public static String getRoomID() {
        return RoomID_;
    }

    public static void setRoomID(String RoomID) {
        RoomID_ = RoomID;
    }

    public static String getBoarderID() {
        return BoarderID_;
    }

    public static void setBoarderID(String BoarderID) {
        BoarderID_ = BoarderID;
    }

    public static String getFirstName() {
        return firstName_;
    }

    public static void setFirstName(String firstName) {
        firstName_ = firstName;
    }

    public static String getMiddleName() {
        return middleName_;
    }

    public static void setMiddleName(String middleName) {
        middleName_ = middleName;
    }

    public static String getLastName() {
        return lastName_;
    }

    public static void setLastName(String lastName) {
        lastName_ = lastName;
    }

    public static String getFullName() {
        return fullName_;
    }

    public static void setFullName() {
        fullName_ = getFirstName()+" "+getMiddleName()+" "+getLastName();
    }

    public static String getBrgy() {
        return brgy_;
    }

    public static void setBrgy(String brgy) {
        brgy_ = brgy;
    }

    public static String getTown() {
        return town_;
    }

    public static void setTown(String town) {
        town_ = town;
    }

    public static String getProv() {
        return prov_;
    }

    public static void setProv(String prov) {
        prov_ = prov;
    }

    public static String getAddress() {
        return address_;
    }

    public static void setAddress() {
        address_ = getBrgy()+", "+getTown()+", "+getProv();
    }

    public static String getAge() {
        return age_;
    }

    public static void setAge(String age) {
        age_ = age;
    }

    public static String getGender() {
        return gender_;
    }

    public static void setGender(String gender) {
        gender_ = gender;
    }

    public static String getMobile() {
        return mobile_;
    }

    public static void setMobile(String mobile) {
        mobile_ = mobile;
    }

    public static String getParentFirstName() {
        return parentFirstName_;
    }

    public static void setParentFirstName(String parentFirstName) {
        parentFirstName_ = parentFirstName;
    }

    public static String getParentMiddleName() {
        return parentMiddleName_;
    }

    public static void setParentMiddleName(String parentMiddleName) {
        parentMiddleName_ = parentMiddleName;
    }

    public static String getParentLastName() {
        return parentLastName_;
    }

    public static void setParentLastName(String parentLastName) {
        parentLastName_ = parentLastName;
    }

    public static String getParentFullName() {
        return parentFullName_;
    }

    public static void setParentFullName() {
        parentFullName_ = getParentFirstName()+" "+getMiddleName()+" "+getLastName();
    }

    public static String getStatus() {
        return status_;
    }

    public static void setStatus(String status) {
        status_ = status;
    }

    public static String getType() {
        return type_;
    }

    public static void setType(String type) {
        type_ = type;
    }

    public static String getRateID() {
        return rateID_;
    }

    public static void setRateID(String rateID) {
        rateID_ = rateID;
    }

    public static String getPicPath() {
        return picPath_;
    }

    public static void setPicPath(String picPath) {
        picPath_ = picPath;
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

    private static String RoomID_;
    private static String BoarderID_;
    private static String firstName_;
    private static String middleName_;
    private static String lastName_;
    private static String fullName_;
    private static String brgy_;
    private static String town_;
    private static String prov_;
    private static String address_;
    private static String age_;
    private static String gender_;
    private static String mobile_;
    private static String parentFirstName_;
    private static String parentMiddleName_;
    private static String parentLastName_;
    private static String parentFullName_;
    private static String status_;
    private static String type_;
    private static String rateID_;
    private static String picPath_;
    
    private static Connection connection_;
    private static PreparedStatement pst_;
    private static ResultSet rs_;
    private static TableModel tableModel_;
}
