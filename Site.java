package projet;
import java.rmi.*;
import java.rmi.server.*;
 
public class Site extends UnicastRemoteObject implements SiteInterface {
	
	private Gestion_anneau gest_ann;
  
    private Site successeur;
    private String port;
    private int id;
      public Site (int id,String port) throws RemoteException {  
    	  this.port=port;
    	  gest_ann.add(this);
    	  successeur=null;
    	  this.id=id;
    	  try {
			   System.setSecurityManager(new RMISecurityManager());

			 	   		   
			   Naming.rebind("rmi://localhost/"+port, this);

			   System.out.println("Server n°"+Integer.toString(id)+"__is__ready.");
			   }catch (Exception e) {
				   System.out.println("Central Server failed: " + e);
				}

    	  
      }
 
      public String sendMsg(Msg msg) throws RemoteException {
		String str = msg.showMsg();
		return str;      
	}
     
      public void set_successeur(Site site) {
    	  this.successeur=site;
   
      }
      public String get_port() {
    	  return this.port;
      }
      public void send_message_elec(Msg msg) {
    	 //envoie le message a son successeur
    	 SiteInterface egsite;
 		try {
   		        System.setSecurityManager(new RMISecurityManager());
 			egsite = (SiteInterface)Naming.lookup("rmi://localhost/"+successeur.get_port());
 			 //soit le message + id si election=true 
 	    	  //soit le message - id si election=false ( dans le cas ou c'est une message de confirmation (pour indiquer si tous les sites fonctionnent
 			msg.add_elec(this.id);
 			String str = egsite.sendMsg(msg);
 			System.out.println("Msgggg is :" + str);
  
 			}catch (Exception e) {
 				System.out.println("SiteClient exception: " + e);
 				}
      	}
     
    	 
    	  
     }
