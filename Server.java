import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Ticket{


	public String getName(){

	}
	public int getNumberSold(){

	}
	public int getNumberAvailable(){

	}
	public void buyTicket(){

	}
	public void returnTicket(){

	}
	public String getNotification(){

	}

	    public static void main(String[] args){
	    	try{
		    	Server obj = new Server();
		    	Ticket stub = (Ticket)UnicastRemoteObject.exportObject(obj,0);
		    	Registry registry = LocateRegistry.getRegistry();
		    	registry.rebind("ticket",stub);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
}

