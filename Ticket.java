import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Ticket extends Remote{


	public String getName() throws RemoteException;
	public int getNumberSold() throws RemoteException;
	public int getNumberAvailable() throws RemoteException;
	public void buyTicket() throws RemoteException;
	public void returnTicket() throws RemoteException;
	public String getNotification() throws RemoteException;

}