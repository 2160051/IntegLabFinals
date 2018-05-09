/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardinghousemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public final class Database {
    
    public Database() {
        
        setDatabase("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=b_hauz_db.mdb;");
    
    }
    
    public void connect() {
        
        try{
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            setConnection(DriverManager.getConnection(getDatabase(), "", ""));
            setConnected(true);
                    
        }
        catch(ClassNotFoundException | SQLException exception) {
            Error error = new Error("Cannot Established Connection to Database!\nPOSSIBLE ERROR:  "+exception.toString());
            error.showErrorDialog();
            setConnected(false);
        }
        
    }

    public static Connection getConnection() {
        return connection_;
    }

    public void setConnection(Connection connection) {
        connection_ = connection;
    }

    public String getDatabase() {
        return database;
    }

    public boolean isConnected() {
        return connected=true;
    }
    
    public boolean isNotConnected() {
        return connected=false;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
    
    private static Connection connection_;
    private String database;
    private boolean connected;
}
