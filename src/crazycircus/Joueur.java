package crazycircus;
/**
 * @file Joueur.java
 * @brief Entête de la classe Joueur
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Joueur {
	private String nomJoueur;
	private int scoreJoueur;
	private boolean aDejaJouer;

	/**
	 * Construie l'objet joueur avec un nom defini
	 * @param nom du joueur
	 */
	public Joueur(String nom) {
		this.nomJoueur = nom;
		this.scoreJoueur = 0;
		this.aDejaJouer=false;
	}
	/**
	 * Ajoute le joueur dans le tableau de joueurs
	 * @param joueurs l'ArrayList contenant les joueurs
	 * @param nomJoueur le nom du joueur a ajouter
	 */
	public static void creerJoueur(ArrayList<Joueur> joueurs, String nomJoueur) {
		Joueur j = new Joueur(nomJoueur);
		joueurs.add(j);
	}
	/**
	 * Verifie la presence du joueur dans le tableau de joueurs
	 * @param joueurs l'ArrayList contenant les joueurs
	 * @param nom le nom du joueur a ajouter
	 * @return un boolean en fonction de la verification
	 */
	public static boolean verifJoueur(ArrayList<Joueur> joueurs, String nom) {
		for(int i = 0; i < joueurs.size(); ++i) {
			if(nom.equals(joueurs.get(i).nomJoueur))
				return true;
		}
		return false;
	}
	/**
	 * Ajoute 1 point au joueur
	 */
	public void ajouterPoint() {
		++scoreJoueur;
	}
	/**
	 * Renvoi le score du joueur
	 * @return scoreJoueur du joueur
	 */
	public int getScore() {
		return scoreJoueur;
	}
	/**
	 * Renvoi le nom du joueur
	 * @return nomJoueur du joueur
	 */
	public String getNom() {
		return nomJoueur;
	}
	/**
	 * Renvoi la situation du joueur
	 * @return un boolean aDejaJoueur
	 */
	public boolean getADejaJouer() {
		return aDejaJouer;
	}
	/**
	 * Defini le joueur comme joué
	 */
	public void setADejaJouer() {
		aDejaJouer = true;
	}
	/**
	 *  Defini le joueur comme pas joué
	 */
	public void setAPasJouer() {
		aDejaJouer = false;
	}
	/**
	 * Renvoi la position/l'indice du joueur dans le tableau de joueur
	 * @param joueurs l'ArrayList contenant les joueurs
	 * @param nomJ le nom du joueur a ajouter
	 * @return l'indice indice du joueur
	 */
	public static int getIndice(ArrayList<Joueur> joueurs, String nomJ) {
		int indice = 0;
		for(int i = 0; i < joueurs.size(); ++i) {
			if(nomJ.equals(joueurs.get(i).nomJoueur)){
				indice = i;
				break;
			}
		}
		return indice;
	}
	/**
	 * Reinisialise la situation de tout les joueurs à pas jouer
	 * @param joueurs l'ArrayList contenant les joueurs
	 */
	public static void resetADejaJouer(ArrayList<Joueur> joueurs) {
		for(int i = 0; i < joueurs.size(); i++) {
			joueurs.get(i).setAPasJouer();
		}
	}
	/**
	 * Trie le classement par score décroissant et par ordre alphabétique en cas d’égalité
	 * @param joueurs l'ArrayList contenant les joueurs
	 */
	public final static void triClassement(ArrayList<Joueur> joueurs) {
		List<Joueur> listeJoueurs = joueurs;
		listeJoueurs.sort(Comparator.comparing(Joueur::getScore).reversed().thenComparing(Joueur::getNom));
	}
	/**
	 * Affiche le classement final
	 * @param joueurs l'ArrayList contenant les joueurs
	 */
	public static final void afficherClassement(ArrayList<Joueur>joueurs) {
		System.out.println("\n---------------- CLASSEMENT ----------------\n");
		for(int i = 0; i < joueurs.size(); i++) {
			if(i == 0) {
				System.out.println((i+1) + "er : " + joueurs.get(i).getNom() +
						" - " + joueurs.get(i).getScore() + " points ");
			}
			else {
				System.out.println((i+1) + "ème : " + joueurs.get(i).getNom() +
						" - " + joueurs.get(i).getScore() + " point" + (joueurs.get(i).getScore() <= 1 ? "" : "s"));
			}
		}
	}
	
}
