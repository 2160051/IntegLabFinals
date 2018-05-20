

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Ticket extends Remote{
	public String getEvent() throws RemoteException;
	public int getTicketSold(String eventname) throws RemoteException;
	public int getTicketAvailable(String eventname) throws RemoteException;
	public void buyTicket(String event, int eventname, int quantity) throws RemoteException;
	public void returnTicket(String eventname, int quantity) throws RemoteException;
	public String eventDetail(int eventToSee) throws RemoteException;
	public double getPrice(int eventid) throws RemoteException;
	public void registerCustomer(String name, String address, String email, String username, String password) throws RemoteException;
	public String getNotification(String username) throws RemoteException;
	public String logIn(String username, String password) throws RemoteException;
	public void setUser(String username) throws RemoteException;
	public String getUser() throws RemoteException;
	public void setEvent(String event) throws RemoteException;
	public String getEventName() throws RemoteException;
	public void addEventCustomer(int id, int eventname, String event) throws RemoteException;
	public void addEvent(String name, int totalTickets, String description, String eventDate, double price) throws RemoteException;
	public void setNotification(String message, String event) throws RemoteException;
	public int getEventByName(String event) throws RemoteException;
}