package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import client.ClientXmlRpc;

public class SPClass {	
	private ChatRoom room;
	public boolean subscribe(String pseudo, String salon) {
		boolean retour = false;
		try {
			Remote r = Naming.lookup(salon);
			this.room = (ChatRoom)r;
			retour = this.room.subscribe(pseudo);
		} catch (MalformedURLException e) {
			System.out.println("Impossible de joindre la salle de discussion");
			System.exit(0);
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return retour;
	}
	
	public boolean unsubscribe(String pseudo, String url) throws Exception{
		//return (boolean) this.client.unsubscribe(pseudo, salon);
		this.room = (ChatRoom) Naming.lookup(url);
		this.room.unsubscribe(pseudo);
		return true;
	}
	
	public String postMessage(String pseudo, String mesage, String url) throws Exception{
		this.room = (ChatRoom) Naming.lookup(url);
		this.room.postMessage(pseudo, mesage);
		return pseudo +" >>> "+mesage ;
	}
	
	public String getMessage(String url) throws Exception{
		this.room = (ChatRoom) Naming.lookup(url);
		return (String) this.room.getMessage();
		
	}
}
