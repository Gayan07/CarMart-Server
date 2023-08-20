package services.server;

import model.Request;
import services.modelServices.RequestService;
import services.rmiInterface.TheInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;


/**
 * Basic RMI Server
 * @author Marc Conrad
 *
 */
public class RMIServer {
    public static Registry registry;
	/**
	 * Start RMI Server
	 */
	public static void startServer(){
		System.out.println("Attempting to start the Hello Server...");
		try {
			TheImplementation theInterface = new TheImplementation();
			registry = LocateRegistry.createRegistry(2022);
			LocateRegistry.getRegistry();
			registry.rebind("rmi://localhost/CarMartServer", theInterface);

			System.out.println("Service started. Welcome to the RMI Hello Service!");
//			Request request = new Request();
//			request.setrBrandName("ehjtrj");
//			request.setrModel("tjtrj");
//			request.setrColor("rtjrtj");
//			request.setrCusName("tjtrjrj");
//			request.setrCusEmail("tjrtjrj");
//			request.setrContactNo(Integer.parseInt("27378"));
//			TheImplementation theInterfaceOne = (TheImplementation) registry.lookup("rmi://localhost/CarMartServer");
//			RequestService requestService = new RequestService();
//			System.out.println(theInterfaceOne.addRequest(request));
		} catch (Exception e) {
			System.out.println("An error occured: "+e.toString());
			e.printStackTrace();
		}
	}

}


