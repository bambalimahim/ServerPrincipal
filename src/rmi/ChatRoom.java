package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatRoom extends Remote{
	public boolean subscribe(String pseudo) throws RemoteException;
	public void unsubscribe(String pseudo) throws RemoteException;
	public void postMessage(String pseudo, String message) throws RemoteException;
	public String getMessage() throws RemoteException;
}
