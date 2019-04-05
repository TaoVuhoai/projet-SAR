package projet;

import java.rmi.*;

public interface SiteInterface extends Remote {
	   public String sendMsg(Msg msg) throws RemoteException;
		//Msg is a class include election msg and candidat msg as well as confirm msg
}
