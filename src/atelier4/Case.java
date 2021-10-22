package atelier4;

public class Case {
	private int gain;
	private Personnage Perso;
	private Obstacle obs;
	
	public Case(Obstacle obs,int gain) {
		this.obs=obs;
		this.gain=gain;
	}
	public Case(int gain) {
		this.gain=gain;
	}
	public int getGain() {
		return gain;
	}
	public int getPenalite() {
		if (this.obs==null)
			return 0;
		else
			return obs.getpenalite();
	}
	public void placerPersonnage(Personnage Perso) {
		 this.Perso=Perso;
	}
	public void placerObstacle(Obstacle obs) {
		this.obs=obs;
	}
	public void enleverPersonnage(){
		this.Perso=null;
	}
	public boolean estLibre() {
		return((this.obs==null)&&(this.Perso==null));
	}
	public boolean sansObstacle() {
		return (this.obs==null);
	}
	public boolean sansPerso() {
		return (this.Perso==null);
	}
	public String toString() {
		if (this.estLibre()==true)
			return "Libre (gain = "+this.gain+")";
		else if(this.sansObstacle()==false)
			return "Obstacle (penalité= "+obs.getpenalite()+")";
		else
			return Perso.getNom()+" (penalité= "+(-this.gain)+")";
	}
	

}
