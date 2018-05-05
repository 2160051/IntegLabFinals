import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Ticket{


	public String getName(){
		return name;

	}
	public int getNumberSold(){
		return numberSold;

	}
	public int getNumberAvailable(){
		return numberAvailbale;

	}
	public void buyTicket(){
		

	}
	public void returnTicket(){

	}
	public String getNotification(){
		return notification;

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

