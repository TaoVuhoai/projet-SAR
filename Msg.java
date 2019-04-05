package projet;
import java.rmi.*;
import java.io.Serializable;
public class Msg implements Serializable{
	//Serializable for sending msg
	int[] msg_election={};
	int[] msg_confirm={};
	int num_candidat=-1;
	int msg_elec_size;
	int msg_confirm_size;
	public Msg() {
		msg_elec_size=0;
		msg_confirm_size=0;
	}
	public String showMsg(){
		return "message is "+Integer.toString(num_candidat);
		
		
	}
	
	public void add_elec(int id) {
		if(msg_elec_size<=3) {
			msg_election[msg_elec_size]=id;
			msg_elec_size++;
		}
		else {
			//lancer confirm 
		}
	}
}