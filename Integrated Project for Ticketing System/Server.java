

import java.sql.*;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Ticket{
	int eventid = 2;
	String usersname;
	String eventsname;
	
	public void registerCustomer(String name, String address, String email, String username, String password){
		try{
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system?user=root&password=");
            PreparedStatement ps; 
            String stIns = "INSERT INTO customer(username, password, customername, address, email) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(stIns);
            
        	ps.setString(1, name);
        	ps.setString(2, address);
        	ps.setString(3, email);
        	ps.setString(4, username);
        	ps.setString(5, password);
        	ps.executeUpdate();
		}catch(Exception sqe){
			sqe.printStackTrace();
		} 
	}

	public String logIn(String username, String password){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system?user=root&password=");
			String query_login = "SELECT username, password FROM customer WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query_login);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            	return "Customer";
            }
            
            query_login = "SELECT handlerusername, handlerpassword FROM event_handler WHERE handlerusername = ? AND handlerpassword = ?";
            ps = con.prepareStatement(query_login);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            while(rs.next()){
            	return "Event Handler";
            }
            
            return "null";
		}catch(Exception sqe){
			sqe.printStackTrace();
		} 
			return "null";
	}

	public String getEvent(){
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system?user=root&password=");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("Select * FROM event where status = 'In-Progress' order by eventid");
                rs = stmt.executeQuery("Select * FROM event where status = 'In-Progress' order by eventid");
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
	
	public void buyTicket(String event, int eventname, int quantity){
		try{
			String conStr = "jdbc:mysql://localhost:3306/ticketing_system?user=root&password=";
            Connection con = DriverManager.getConnection(conStr);
            System.out.println("connection done");
            String user = getUser();
            
            String stSel = "SELECT * FROM event WHERE eventid = ?";
            PreparedStatement ps = con.prepareStatement(stSel);
            ps.setInt(1, eventname); 
            ResultSet rs = ps.executeQuery();
        
            rs.first();
            int sold = rs.getInt(4);
            int newNumb = sold + quantity;
            
            String stSel2 = "SELECT * FROM customer WHERE username = ?";
            ps = con.prepareStatement(stSel2);
            ps.setString(1, user); 
            rs = ps.executeQuery();
            rs.first();
            int id = rs.getInt("customerid");
            
            String crSel = "UPDATE event SET soldTickets = ? WHERE eventid = ?";
            PreparedStatement pss = con.prepareStatement(crSel);
            pss.setInt(1, newNumb);
            pss.setInt(2, eventname);
            addEventCustomer(id, eventname, event);
            pss.executeUpdate();
		}catch(Exception sqe){
			sqe.printStackTrace();
		}
	}
	
	public void addEventCustomer(int id, int eventname, String event){
		try{
			String conStr = "jdbc:mysql://localhost:3306/ticketing_system?user=root&password=";
            Connection con = DriverManager.getConnection(conStr);
			String crSel2 = "INSERT INTO event_customers(customerid, eventid, eventname) VALUES (?,?,?)";
            PreparedStatement pss = con.prepareStatement(crSel2);
            pss.setInt(1, id);
            pss.setInt(2, eventname);
            pss.setString(3, event);
            pss.executeUpdate();
		}catch(Exception sqe){
			sqe.printStackTrace();
		}
	}
	
	public void setUser(String username){
		this.usersname = username;
	}
	
	public String getUser(){
		return usersname;
	}
	
	public void setEvent(String event){
		this.eventsname = event;
	}
	
	public String getEventName(){
		return eventsname;
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
        
	public void returnTicket(String eventname, int quantity){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system?user=root&password=");
			String crSel2 = "Select * FROM event where status = 'In-Progress' AND eventname = ? order by eventname";
			PreparedStatement stmt = con.prepareStatement(crSel2);
			stmt.setString(1, eventname);
        	ResultSet rs = stmt.executeQuery();
        	
        	rs.first();
	       	int soldTickets = rs.getInt("soldTickets");
			
			int returned = soldTickets - quantity;
			PreparedStatement psu = 
         	con.prepareStatement("UPDATE event SET soldTickets = ?"+" WHERE eventname = ?");
         	psu.setInt(1, returned);
         	psu.setString(2, eventname);
         	psu.executeUpdate();
		}catch(Exception sqe){
			sqe.printStackTrace();
		}
	}
	
	public String getNotification(String username){
		try{			
            String conStr = "jdbc:mysql://localhost:3306/ticketing_system?user=root&password=";
            Connection con = DriverManager.getConnection(conStr);
            System.out.println("connection done");
            
            String stSel = "Select * from customer JOIN event_customers USING(customerid) JOIN notification USING(eventid) WHERE username = ?";
        	PreparedStatement stmt = con.prepareStatement(stSel);
        	stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            rs.beforeFirst();
            String notif = "";
            
            while (rs.next()) {
                String evntname = rs.getString(9);
                String message = rs.getString(11);
                notif += evntname+"-"+message+",";
            }
            return notif;
		}catch(Exception e){
			e.printStackTrace();
		}
			return "";
	}
	
	public void addEvent(String name, int totalTickets, String description, String eventDate, double price){
            try{
		eventid += 1;
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system?user=root&password=");
                PreparedStatement psi; 
                String stIns = "INSERT INTO event(eventname, totalTickets, soldTickets, description, eventDate, status, price) VALUES (?,?,?,?,?,?,?)";
                psi = con.prepareStatement(stIns);

                psi.setString(1, name);
                psi.setInt(2, totalTickets);
                psi.setInt(3, 0);
                psi.setString(4, description);
                psi.setString(5, eventDate);
                psi.setString(6, "In-Progress");
                psi.setDouble(7, price);
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

