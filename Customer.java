import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;


public class Customer{
	public static void main(String[] args){
		try{
			String hostName = "127.0.0.1";
			Registry registry = LocateRegistry.getRegistry(hostName);
			Ticket stub = (Ticket)registry.lookup("ticket");

			stub.getName();
			stub.getNumberSold();
			stub.getNumberAvailable();
			stub.buyTicket();
			stub.returnTicket();
			stub.getNotification();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}