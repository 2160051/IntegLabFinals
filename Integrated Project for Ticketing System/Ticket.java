

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Ticket extends Remote{
	public String getEvent() throws RemoteException;
	public int getTicketSold(String eventname) throws RemoteException;
	public int getTicketAvailable(String eventname) throws RemoteException;
	public void buyTicket(int eventname, int quantity) throws RemoteException;
	public void returnTicket(String eventname) throws RemoteException;
	public String eventDetail(int eventToSee) throws RemoteException;
	public double getPrice(int eventid) throws RemoteException;
	public void registerCustomer(String name, String address, String email, String username, String password) throws RemoteException;
	//public String getNotification(String eventname) throws RemoteException;
	
	public void addEvent(String name, int totalTickets, String description, String eventDate, double price) throws RemoteException;
	//public void setNotification(String notif) throws RemoteException;
}