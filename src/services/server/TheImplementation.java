package services.server;

import model.Request;
import model.Request1;
import services.modelServices.RequestService;
import services.rmiInterface.TheInterface;
import util.dbConnection.DBConnection;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;


/**
 * Implements the Service. 
 * @author Marc Conrad
 *
 */
public class TheImplementation extends UnicastRemoteObject implements TheInterface {
	
	protected TheImplementation() throws RemoteException {
		super();
	}
	
	public String getGreeting() throws RemoteException {
		
		return "Hello. This is Marc Conrad's Server! How are you today?";
	}
	public String printBanner(String name) throws RemoteException {
		return name;
	}

	public boolean getInstance() throws RemoteException, ClassNotFoundException, SQLException {
		if(DBConnection.Connect() != null){
			return true;
		} else {
			return false;
		}
	}


	public boolean addRequest(Request1 request) throws RemoteException {
		RequestService requestService = new RequestService();
		return requestService.addRequest(request);
	}

}
