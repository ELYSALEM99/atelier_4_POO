package atelier4;

public class TestJeu {

	public static void main(String[] args) {
		Jeu jeu=new Jeu("AtelierPOO",4,10);
		
		Joueur jou1=new Joueur("Paul");
		Personnage p1=new Tauren("Hector",15,10);
		Personnage p2=new Humain("Jean",10);
		jou1.ajouterPersonnage(p1);
		jou1.ajouterPersonnage(p2);
		p1.setProprietaire(jou1);
		p2.setProprietaire(jou1);
		
		Joueur jou2=new Joueur("Lucien");
		Personnage p3=new Tauren("Hercule",20,5);
		Personnage p4=new Humain("Marie",10);
		jou2.ajouterPersonnage(p3);
		jou2.ajouterPersonnage(p4);
		p3.setProprietaire(jou2);
		p4.setProprietaire(jou2);
		
		jeu.ajouterJoueur(jou1);
		jeu.ajouterJoueur(jou2);
		jeu.tousLesPersos();
		jeu.initialiserCases();
		jeu.lancerJeu();
		jeu.afficherResultats();
	}

}
