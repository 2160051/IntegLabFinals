import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Ticket extends Remote{
	public String getName() throws RemoteException;
	public int getTicketSold() throws RemoteException;
	public int getTicketAvailable() throws RemoteException;
	public void buyTicket() throws RemoteException;
	public void returnTicket() throws RemoteException;
	public String getNotification() throws RemoteException;
	
	public void setName(String name) throws RemoteException;
	public void setTicketSold(int ticketSold) throws RemoteException;
	public void setTicketAvailable(int ticketAvailable) throws RemoteException;
	public void setNotification(String notif);
}