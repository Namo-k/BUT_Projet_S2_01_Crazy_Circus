package crazycircus;
/**
 * @file Plateau.java
 * @brief Entête de la classe Plateau
 */

import java.util.Arrays;

public class Plateau {
	private Podium podiumBleu;
	private Podium podiumRouge;

	/**
	 * Construit le plateau composé de deux podiums
	 */
	public Plateau() {
		podiumBleu = new Podium(Couleur.BLEU);
		podiumRouge = new Podium(Couleur.ROUGE);
	}

	/**
	 * Renvoi le podium en fonction de sa couleur
	 * @param c la Couleur du podium
	 * @return podiumBleu l'ArrayList du podium bleu
	 */
	public Podium getPodium(Couleur c) {
		if (c == Couleur.BLEU)
	        return podiumBleu;
	    return podiumRouge;
	}

	/**
	 * Verifie si le podium est vide
	 * @param c la Couleur du podium
	 * @return un boolean en fonction de la verification
	 */
	public boolean estVide(Couleur c) {
		if (c == Couleur.BLEU)
	        return (this.podiumBleu.estVide());
	    return (this.podiumRouge.estVide());
	}
	
	/**
	 * Ajoute au sommet du podium rouge l'animal qui se trouve au sommet du podium bleu
	 * @param p le plateau
	 */
	public void KI() {		
		if(!podiumBleu.estVide()) {
			podiumRouge.ajouter(podiumBleu.getSommet());
			podiumBleu.retirer(podiumBleu.getSize()-1);
		}
	}
	/**
	 * Ajoute au sommet du podium bleu l'animal qui se trouve au sommet du podium rouge
	 * @param p le plateau
	 */
	public void LO() {
		if(!podiumRouge.estVide()) {
			podiumBleu.ajouter(podiumRouge.getSommet());
			podiumRouge.retirer(podiumRouge.getSize()-1);
		}
	}
	/**
	 * Echange les sommets du podium rouge et du podium bleu
	 * @param p le plateau
	 */
	public void SO() {
		Animal tmp = podiumRouge.getSommet();
		podiumRouge.retirer(podiumRouge.getSize()-1);
		KI();
		podiumBleu.ajouter(tmp);
	}
	/**
	 * Prend l'animal en bas du podium bleu pour le mettre au sommet de ce même podium
	 * @param p le plateau
	 */
	public void NI() {
		if(!podiumBleu.estVide()) {
			podiumBleu.ajouter(podiumBleu.getAnimal(0));
			podiumBleu.retirer(0);
		}
	}
	/**
	 * Prend l'animal en bas du podium rouge pour le mettre au sommet de ce même podium
	 * @param p le plateau
	 */
	public void MA() {
		if(!podiumRouge.estVide()) {
			podiumRouge.ajouter(podiumRouge.getAnimal(0));
			podiumRouge.retirer(0);
		}
	}
	/**
	 * Verifie si l'ordre entrée est correcte
	 * @param ordres l'ordre tapé du joueur
	 * @return un boolean en fonction de la verification
	 */
	public static boolean ordreCorrect(String ordres) {
		
		String[] ordresValide = {"KI", "LO", "SO", "NI", "MA"};
		
		for(int i = 0; i<ordres.length()-1; i+=2) {
			String ordre = ordres.substring(i, i+2);			
			if(!Arrays.asList(ordresValide).contains(ordre)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Execute l'ordre du joueur
	 * @param reponse qui est l'ordre donnée par le joueur
	 */
	public void executerOrdre(String reponse) {
		for(int i = 0; i < reponse.length(); i += 2) {
			String ordre = reponse.substring(i, i + 2);
	        switch (ordre) {
		        case "KI":
		        	KI();
	                break;
	            case "LO":
	            	LO();
	                break;
	            case "SO":
	            	SO();
	                break;
	            case "NI":
	            	NI();
	                break;
	            case "MA":
	            	MA();
	                break;
	            default:
	                break;
	        }
		}
	
	}
	
	/**
	 * Verifie le plateau initiale et le plateau final sont identiques
	 * @param pfinal le plateau final
	 * @return un boolean en fonction de la verification
	 */
	public boolean comparer(Plateau pFinal) {
		return (this.podiumBleu.getPodium().equals(pFinal.podiumBleu.getPodium()) && this.podiumRouge.getPodium().equals(pFinal.podiumRouge.getPodium()));
	}
	
	/**
	 * Affiche la partie donc le plateau initial et le plateau final
	 * @param pInitiale le plateau initiale
	 * @param pFinal le plateau final
	 */
	public static final void AffichePartie(Plateau pInitial, Plateau pFinal) {
		
		/* Création des animaux */
		Animal elephant = Animal.ELEPHANT;
		Animal ours = Animal.OURS;
		Animal lion = Animal.LION;
		
		/* Affichage */
		for(int i = 3; i > 0; i--) {
			if(i <= pInitial.podiumBleu.getSize()) {
				if(pInitial.podiumBleu.getAnimal(i-1).equals(ours)) {
					System.out.print("  " + pInitial.podiumBleu.getAnimal(i-1) + "  ");
				}
				if(pInitial.podiumBleu.getAnimal(i-1).equals(lion)) {
					System.out.print("  " + pInitial.podiumBleu.getAnimal(i-1) + "  ");
				}
				if(pInitial.podiumBleu.getAnimal(i-1).equals(elephant)) {
					System.out.print(pInitial.podiumBleu.getAnimal(i-1));
				}
			}
			else {
				System.out.print("        ");
			}
			
			if(i <= pInitial.podiumRouge.getSize()) {
				if(pInitial.podiumRouge.getAnimal(i-1).equals(ours)) {
					System.out.print("   " + pInitial.podiumRouge.getAnimal(i-1) + "         ");
				}
				else if(pInitial.podiumRouge.getAnimal(i-1).equals(lion)) {
					System.out.print("   " + pInitial.podiumRouge.getAnimal(i-1) + "         ");
				}
				else if(pInitial.podiumRouge.getAnimal(i-1).equals(elephant)) {
					System.out.print(" " + pInitial.podiumRouge.getAnimal(i-1) + "       ");
				}
			}
			else {
				System.out.print("                ");
			}
			
			if(i <= pFinal.podiumBleu.getSize()) {
				if(pFinal.podiumBleu.getAnimal(i-1).equals(ours)) {
					System.out.print("  " + pFinal.podiumBleu.getAnimal(i-1) + "  ");
				}
				else if(pFinal.podiumBleu.getAnimal(i-1).equals(lion)) {
					System.out.print("  " +pFinal.podiumBleu.getAnimal(i-1) + "  ");
				}
				else if(pFinal.podiumBleu.getAnimal(i-1).equals(elephant)) {
					System.out.print(pFinal.podiumBleu.getAnimal(i-1));
				}
			}
			else {
				System.out.print("        ");
			}
			
			if(i <= pFinal.podiumRouge.getSize()) {
				if(pFinal.podiumRouge.getAnimal(i-1).equals(ours)) {
					System.out.println("   " + pFinal.podiumRouge.getAnimal(i-1));
				}
				else if(pFinal.podiumRouge.getAnimal(i-1).equals(lion)) {
					System.out.println("   " + pFinal.podiumRouge.getAnimal(i-1));
				}
				else if(pFinal.podiumRouge.getAnimal(i-1).equals(elephant)) {
					System.out.println(" " + pFinal.podiumRouge.getAnimal(i-1));
				}
			}
			else {
				System.out.println("        ");
			}
		}
		AfficheOrdrePossible();
	}
	
	/**
	 * Affiche les ordres possibles
	 */
	public static final void AfficheOrdrePossible() {
		System.out.println("  ----     ----    ==>    ----     ----");
		System.out.println("  BLEU     ROUGE          BLEU     ROUGE\n");
		System.out.println("------------------------------------------");
		System.out.println("KI : BLEU --> ROUGE    NI : BLEU  ^");
		System.out.println("LO : BLEU <-- ROUGE    MA : ROUGE ^");
		System.out.println("SO : BLEU <-> ROUGE\n");
	}
}
