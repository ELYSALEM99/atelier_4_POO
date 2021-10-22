package atelier4;

public abstract class Personnage {
	private String nom;
	private int age;
	private int position;
	private Joueur Proprietaire;
	
	public Personnage(String nom,int age) {
		this.nom=nom;
		this.age=age;
	}
	public void  deplacer(int destination, int gain) {
		position+=destination;
		Proprietaire.modifierPoints(gain);
	}
	public void penaliser(int penalite) {
		Proprietaire.modifierPoints(penalite);
	}
	public void setProprietaire(Joueur Proprietaire) {
		this.Proprietaire=Proprietaire;
	}
	public String toString() {
		return nom;
	}
	public abstract int positionSouhaitee() ;
	public int getPosition() {
		return position;
	}
	public String getNom() {
		return nom;
	}
}
