

import java.sql.*;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Ticket{
	int eventid = 2;

	public String getEvent(){
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system?user=root&password=");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("Select * FROM event where status = 'In-Progress' order by eventname");
                rs = stmt.executeQuery("Select * FROM event where status = 'In-Progress' order by eventname");
                rs.beforeFirst();
        		String event = "";
        	while (rs.next()) {
                    int eventid = rs.getInt(1);
                    String eventname = rs.getString("eventname");
                    event += eventid+"-"+eventname+",";             
        	}
        	return event;
		}catch(Exception sqe){
			sqe.printStackTrace();
		} 
			return "";         
	}
	
	public String eventDetail(int eventToSee){
			try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system?user=root&password=");
                String stSel = "SELECT * FROM event WHERE eventid = ?";
            	PreparedStatement ps = con.prepareStatement(stSel);
            	ps.setInt(1, eventToSee); 
            	ResultSet rs = ps.executeQuery();
        		
        		rs.first();
        		int eventid = rs.getInt(1);
            	String eventname = rs.getString(2);
            	int leftTicks = rs.getInt(3) - rs.getInt(4);
            	String desc = rs.getString(5);
            	String date = rs.getString(6);
            	double price = rs.getDouble(8);
            	
        		return eventname+"-"+date+"-"+desc+"-"+price+"-"+leftTicks;
		}catch(Exception sqe){
			sqe.printStackTrace();
		} 
			return ""; 
	}
	
	public int getTicketSold(String eventname){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system?user=root&password=");  
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE);
        	ResultSet rs = stmt.executeQuery("Select * FROM event where status = 'In-Progress' order by eventname");      	
			PreparedStatement ps1 = 
            con.prepareStatement("Select * FROM event where eventname = ? AND status = 'In-Progress' order by eventname");
            ps1.setString(1, eventname);
            ps1.execute();
			
            while (rs.next()) {
            	if(rs.getString("eventname") == eventname){
            		return rs.getInt("totalTickets");
            	}
        	}
		}catch(Exception sqe){
			sqe.printStackTrace();
		}
		return 0;
	}
	
	public int getTicketAvailable(String eventname){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system?user=root&password="); 
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE);
        	ResultSet rs = stmt.executeQuery("Select * FROM event where status = 'In-Progress' order by eventname");       	
			PreparedStatement ps1 = 
            con.prepareStatement("Select * FROM event where status = 'In-Progress' AND eventname = ? order by eventname");
            ps1.setString(1, eventname);
            ps1.execute();

            while (rs.next()) {
            	if(rs.getString("eventname") == eventname){
            		return (rs.getInt("totalTickets")) - (rs.getInt("soldTickets"));
            	}
        	}
		}catch(Exception sqe){
			sqe.printStackTrace();
		}
		return 0;
	}
	
	public void buyTicket(int eventname, int quantity){
		try{
			String conStr = "jdbc:mysql://localhost:3306/ticketing_system?user=root&password=";
            Connection con = DriverManager.getConnection(conStr);
            System.out.println("connection done");
            
            String stSel = "SELECT * FROM event WHERE eventid = ?";
            PreparedStatement ps = con.prepareStatement(stSel);
            ps.setInt(1, eventname); 
            ResultSet rs = ps.executeQuery();
        
            rs.first();
            int sold = rs.getInt(4);
            int newNumb = sold + quantity;
            String crSel = "UPDATE event SET soldTickets = ? WHERE eventid = ?";
            PreparedStatement pss = con.prepareStatement(crSel);
            pss.setInt(1, newNumb);
            pss.setInt(2, eventname);
            pss.executeUpdate();
		}catch(Exception sqe){
			sqe.printStackTrace();
		}
	}
	
	public double getPrice(int eventid){
		try{
			String conStr = "jdbc:mysql://localhost:3306/ticketing_system?user=root&password=";
            Connection con = DriverManager.getConnection(conStr);
            System.out.println("connection done");
            
            String stSel = "SELECT * FROM event WHERE eventid = ?";
            PreparedStatement ps = con.prepareStatement(stSel);
            ps.setInt(1, eventid); 
            ResultSet rs = ps.executeQuery();
            rs.first();
            double price = rs.getDouble(8);
            return price;
		}catch(Exception sqe){
			sqe.printStackTrace();
		}
		return 0;
	}
        
	public void returnTicket(String eventname){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system?user=root&password=");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE);
        	ResultSet rs = stmt.executeQuery("Select * FROM event where status = 'In-Progress' order by eventname");
	       	int soldTickets = rs.getInt("soldTickets");

			PreparedStatement psu = 
         	con.prepareStatement("UPDATE event SET soldTickets = ?"+" WHERE eventname = ?");
         	psu.setInt(1, soldTickets--);
         	psu.setString(2, eventname);
         	psu.executeUpdate();
		}catch(Exception sqe){
			sqe.printStackTrace();
		}
	}
	
	/*public String getNotification(String eventname){

	}*/
	
	public void addEvent(String name, int totalTickets, String description, String eventDate, double price){
            try{
		eventid += 1;
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system?user=root&password=");
                PreparedStatement psi; 
                String stIns = "INSERT INTO event(eventid, eventname, totalTickets, soldTickets, description, eventDate, status, price) VALUES (?,?,?,?,?,?,?,?)";
                psi = con.prepareStatement(stIns);
                psi.setInt(1,eventid);
                psi.setString(2, name);
                psi.setInt(3, totalTickets);
                psi.setInt(4, 0);
                psi.setString(5, description);
                psi.setString(6, eventDate);
                psi.setString(7, "In-Progress");
                psi.setDouble(8, price);
                psi.executeUpdate();
            }catch(Exception sqe){
			sqe.printStackTrace();
		}
	}

	/*public void setNotification(String notif){

	}*/

	public static void main(String[] args){
		try{
		    Server obj = new Server();
		    Ticket stub = (Ticket)UnicastRemoteObject.exportObject(obj,0);
		    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
		    registry.rebind("ticket",stub);
                    
            System.out.println("Running Server");       	
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
}

