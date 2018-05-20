import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;


public class EventHost{
	public static void main(String[] args){
		try{
			String hostName = "127.0.0.1";
			Registry registry = LocateRegistry.getRegistry(hostName);
			Ticket stub = (Ticket)registry.lookup("ticket");

			secondStub.setName(sampleName);
			stub.setNumber(5);
			stub.sendNotification();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}