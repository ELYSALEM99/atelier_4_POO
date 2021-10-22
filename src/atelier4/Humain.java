package atelier4;

public class Humain extends Personnage {
	private int nbDeplacements;
	private int niveau;
	public Humain(String nom,int age) {
		super(nom,age);
		nbDeplacements=0;
		niveau=1;
	}
	public void  deplacer() {
		nbDeplacements++;
		if(nbDeplacements==4)
			niveau=2;
		else if(nbDeplacements==6)
			niveau=3;
	}
	public int positionSouhaitee() {
		return this.getPosition()+(niveau*nbDeplacements);
	}
	public String toString() {
		return super.toString();
	}
}
