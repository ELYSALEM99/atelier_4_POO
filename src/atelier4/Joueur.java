package atelier4;

import java.util.ArrayList;

public class Joueur {
	private String nom;
	private String code;
	static int nbJoueurs=0;
	private int nbPoints;
	private  ArrayList<Personnage> listePersos;
	
	public Joueur(String nom) {
		nbJoueurs++;
		this.nom=nom;
		this.code="J"+nbJoueurs;
		this.nbPoints=0;
		listePersos=new ArrayList<Personnage>();
	}
	
	public void ajouterPersonnage(Personnage P) {
		listePersos.add(P);
	}
	
	public void modifierPoints(int nb) {
		 nbPoints=nb + nbPoints;
	}
	
	public boolean peutJouer() {
		return this.listePersos.size()>=1;
	}
	
	public int getNbPoints() {
		return nbPoints;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public ArrayList<Personnage> getListePersos() {
		return listePersos;
	}
	
	public String toString() {
		if (peutJouer()==true)
		{
			return this.code+" "+ this.nom +" ("+this.nbPoints+" points"+") avec "+this.listePersos.size()+" perssonage(s)";
		}
		else
			this.nbPoints=0;
			return this.code+" "+ this.nom +" ("+this.nbPoints+" point"+") aucun "+this.listePersos.size()+" perssonage";	
	}
}
