package projet;

import java.util.ArrayList;

public class Gestion_anneau {
		public int nb_site;
		public ArrayList<Site> sous_reseau;
		public Gestion_anneau(){
				nb_site=0;
				this.sous_reseau=new ArrayList<Site>();
		}
		public void add(Site site) {
			nb_site++;
			/*cpt_sous_reseau++;
			if(cpt_sous_reseau>3) {
				nb_sous_reseau++;
				cpt_sous_reseau=0;
			}*/
			sous_reseau.add(site);
		
			if(sous_reseau.size()==1) {
				site.set_successeur(site);
			}
			if(sous_reseau.size()>1) {
				Site successeur=sous_reseau.get(-1);
				site.set_successeur(successeur);
			}
			if (sous_reseau.size()==3) {
				System.out.println("il ya 3 serveur ajoutée");
				lancer_anneau(); 
			}
			
		}
		public void lancer_anneau() {
			sous_reseau.get(0).send_message_elec(new Msg());
		}
}
