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
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class Users {
    
    public Users(String fName, String mName, String lName, String username, String password, String type) {
        setFirstName(fName);
        setMiddleName(mName);
        setLastName(lName);
        setUsername(username);
        setPassword(password);
        setType(type);
    }
    
    public static TableModel getUserTable() {
        String query = "SELECT Username, FirstName as \"First Name\", MiddleName as \"Middle Name\", LastName as \"Last Name\", Type as \"User Type\" FROM Users;";
        
        try {
            setConnection(Database.getConnection());
            setPst(connection_.prepareStatement(query));
            setRs(pst_.executeQuery());
            
            return DbUtils.resultSetToTableModel(rs_);
        }
        catch(Exception exception) {
            new Error("Error getting Users Data.\n\nERROR:    "+exception).showErrorDialog();
            return null;
        }
    }

    public void addUser() {
        String query = "INSERT INTO Users (FirstName, MiddleName, LastName, Username, Password, Type) VALUES (?, ?, ?, ?, ?, ?);";
        
        try {
            setPst(Database.getConnection().prepareStatement(query));
            
            getPst().setString(1, getFirstName());
            getPst().setString(2, getMiddleName());
            getPst().setString(3, getLastName());
            getPst().setString(4, getUsername());
            getPst().setString(5, getPassword());
            getPst().setString(6, getType());
            
            getPst().executeUpdate();
            
            JOptionPane.showMessageDialog(null, "NEW USER SAVED!", "", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException | HeadlessException exception) {
            new Error("Error Adding User.\n\nERROR: "+exception).showErrorDialog();
        }
    }
    
    public static void deleteUser(String username) {
        String query = "DELETE FROM Users WHERE Username='"+username+"';";
        
        try {
            setPst(Database.getConnection().prepareStatement(query));
            getPst().execute();
            
            JOptionPane.showMessageDialog(null, "User "+username+" DELETED", "", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException | HeadlessException exception) {
            new Error("Error in deleting user.\n\nERRROR: "+exception).showErrorDialog();
        }
    }
    
    public static void getUser(String username) {
        String query = "SELECT * FROM Users WHERE Username='"+username+"';";
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                setFirstName(getRs().getString("FirstName"));
                setMiddleName(getRs().getString("MiddleName"));
                setLastName(getRs().getString("LastName"));
                setUsername(getRs().getString("Username"));
                setType(getRs().getString("Type"));
            }
        }
        catch(Exception exception) {
            new Error("ERROR GETTING ROOM USER DATA\n\nERROR: "+exception).showErrorDialog();
        }
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

    public static String getUsername() {
        return username_;
    }

    public static void setUsername(String username) {
        username_ = username;
    }

    public static String getPassword() {
        return password_;
    }

    public static void setPassword(String password) {
        password_ = password;
    }

    public static String getType() {
        return type_;
    }

    public static void setType(String type) {
        type_ = type;
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
    
    private static String firstName_;
    private static String middleName_;
    private static String lastName_;
    private static String username_;
    private static String password_;
    private static String type_;
    
    private static Connection connection_;
    private static PreparedStatement pst_;
    private static ResultSet rs_;
}
