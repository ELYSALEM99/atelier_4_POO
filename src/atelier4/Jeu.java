package atelier4;

import java.util.ArrayList;
import java.util.Random;

public class Jeu {
	private String  titre;
	private static final int NBJOUERMAX=6;
	private static final int NBCASES=50;
	private ArrayList<Joueur> listeJoueurs;
	private Case[] cases;
	private int nbEtapes;
	private int nbObstacles;
	private int scoreMax;
	
	public Jeu(String titre,int nbEtapes,int nbObstacles) {
		this.titre=titre;
		this.nbEtapes=nbEtapes;
		this.nbObstacles=nbObstacles;
		listeJoueurs=new ArrayList<Joueur>();
		cases=new Case[NBCASES];
		scoreMax=134;
	}
	public void ajouterJoueur(Joueur j) {
		listeJoueurs.add(j);
	}
	public ArrayList<Personnage> tousLesPersos(){
		ArrayList<Personnage> result=new ArrayList<Personnage>(); 
		for(Joueur j:listeJoueurs) 
		{	
			result.addAll(j.getListePersos());
		}
		return result;
	}
	public void initialiserCases() { 
		Random nb = new Random();
		Case c;
		Obstacle ob;
		int nbEffObs=0;
		for(int i=0;i<cases.length;i++)
		{
			int nbAleatoire=nb.nextInt(NBCASES)+1;
			c=new Case(nbAleatoire);
			cases[i]=c;
			if(nbAleatoire%5==0) 
			{	
				if(nbEffObs<nbObstacles) 
				{
					nbEffObs++;
					ob=new Obstacle(nbAleatoire*2);
					cases[i].placerObstacle(ob);
				}
					
			}
		}
	}
	public void lancerJeu() {
		for(int j=0;j<tousLesPersos().size();j++)
		{
			for(int i=0;i<cases.length;i++) 
			{
				if(cases[i].sansObstacle()==true)
				{
					cases[i].placerPersonnage(tousLesPersos().get(j));
					break;
				}
			}
		}
		for(Personnage pers:tousLesPersos()) 
		{
			int positionSouhai=pers.positionSouhaitee();
			if (positionSouhai>49) 
			{
				positionSouhai=49;
			}
			if (cases[positionSouhai].estLibre()) 
			{
				pers.deplacer(positionSouhai,cases[positionSouhai].getGain());
			}
			if(cases[positionSouhai].sansObstacle()==false || cases[positionSouhai].sansPerso()) 
			{
				pers.penaliser(cases[positionSouhai].getGain());
			}
		}
		
	}
	public void afficherCases() {
		for(int i=0;i<NBCASES;i++) {
			System.out.println("Case "+i+" : "+cases[i].toString());
		}
	}
	public void afficherParticipants() {
		System.out.println("LISTE DES JOUEURS");
		for(Joueur joueur:listeJoueurs) 
		{
			System.out.println("------------------------------------");
			System.out.println(joueur.toString());
		}
	}
	public void afficherResultats() {
		this.afficherParticipants();
		System.out.println("JEU "+this.titre);
		System.out.println("******************************************************");
		Joueur j=null;
		for(int i=0;i<listeJoueurs.size()-1;i++)
		{
			if((listeJoueurs.get(i)).getNbPoints()<(listeJoueurs.get(i+1)).getNbPoints())
				j=listeJoueurs.get(i+1);
			else
				j=listeJoueurs.get(i);
		}
		System.out.println("Le gagnant est "+j.getNom()+" avec "+j.getNbPoints()+" points ");
		if(j.getNbPoints()>scoreMax) 
		{
			System.out.println("Record battu : Ancien score maximum "+scoreMax);
			scoreMax=j.getNbPoints();
		}
	}
}
