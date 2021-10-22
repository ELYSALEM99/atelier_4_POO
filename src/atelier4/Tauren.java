package atelier4;

import java.util.Random;

public class Tauren extends Personnage {
	private int taille;
	
	public Tauren(String nom,int age,int taille) {
		super(nom,age);
		this.taille=taille;
	}
	public int positionSouhaitee() {
		Random nb = new Random();
		int r=nb.nextInt(taille)+1;
		return this.getPosition()+r;
		
	}
	public String toString() {
		return super.toString();
		}
}
