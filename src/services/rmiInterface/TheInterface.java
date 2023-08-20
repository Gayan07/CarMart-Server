package services.rmiInterface;


import model.Request;
import model.Request1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * RMI interface for a basic service that return a greeting
 * @author Marc Conrad
 *
 */
public interface TheInterface extends Remote {

	/**
	 * Says Hello
	 * @return
	 * @throws RemoteException
	 */
	public String getGreeting() throws RemoteException; 
	/**
	 * Retrieve specific question from the server. 
	 * param i number of the question.
	 * return the Question.
	 * throws RemoteException
	 */
	boolean getInstance() throws RemoteException, ClassNotFoundException, SQLException;
	public String printBanner(String name) throws RemoteException;
	public boolean addRequest(Request1 request) throws RemoteException;
}
