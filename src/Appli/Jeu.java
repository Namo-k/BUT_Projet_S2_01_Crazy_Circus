package Appli;
import crazycircus.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @file jeu.java
 * Projet BUT S2 - Le jeu Crazy Circus
 * @author Namodacane KALIAMOORTHY et Alexandre CAROUNANITHI
 * @version 5 - 15/03/2023
 * @brief Programme principal du jeu : Crazy Circus
 */

public class Jeu {

	public static void main(String[] args) {
		
		System.out.println("\n================= BIENVENUE SUR CRAZY CIRCUS =================");
		System.out.println("Voici les règles : \nEssayez de trouvez le plus rapidement possible la bonne combinaison. Bonne chance !\n");
		ArrayList<Joueur> joueurs  = new ArrayList<>();
		int nbJoueur = 0;
		
		/*Creation des Joueurs*/
		if(args.length < 2) {
			System.out.println("Saisissez au minimum 2 joueurs");
			System.exit(1);
		}	
		else {
			for(int i = 0; i<args.length; ++i) {
				String nomJoueur = args[i].toUpperCase();
				if(Joueur.verifJoueur(joueurs, nomJoueur)) {
					System.out.println("Le joueur " + nomJoueur + " existe déjà, relancez le jeu !");
					System.exit(1);
				}else {
					Joueur.creerJoueur(joueurs, nomJoueur);
					System.out.println("Joueur " + (i+1) + " : " + nomJoueur);
					++nbJoueur;
				}
			}
			System.out.println("Nombre de participant : " + nbJoueur);
		}
		/*Fin création des joueurs*/
		
		/*Début du jeu*/
		System.out.println("\nQue le jeu commence !\n");
		
		Paquet paquet = new Paquet();
		paquet.melanger();
		System.out.println("Pour répondre, saisissez votre nom puis la bonne suite d'ordre (exemple : DP KIMALONI)\n");
		
		
		for(int i = 0; i<paquet.getSizePaquet()-1; ++i) {
			Plateau.AffichePartie(paquet.getCarte(i), paquet.getCarte(i+1)); //Affiche la partie
			int nbJoueurRestant = joueurs.size();
			do {
				
				if(nbJoueurRestant != 1) {
					String nomJoueur = "";
					String ordreJoueur = "";
					
					while(nomJoueur.trim().isEmpty() || ordreJoueur.trim().isEmpty()) {
						
						System.out.print("Votre réponse : ");
						@SuppressWarnings("resource")
						
						Scanner sc = new Scanner(System.in);
						
						nomJoueur = sc.next().toUpperCase().trim();
						ordreJoueur = sc.nextLine().toUpperCase().trim();
						
						//System.out.println(nomJoueur +" " + ordreJoueur);
						
						if(nomJoueur.trim().isEmpty() || ordreJoueur.trim().isEmpty()) {
							System.out.println("Veuillez saisir le nom et ensuite l'ordre !");
						}
						
					}
					
					if(!Joueur.verifJoueur(joueurs, nomJoueur))
						System.out.println("Le joueur n'existe pas !");
					else {
						if(joueurs.get(Joueur.getIndice(joueurs, nomJoueur)).getADejaJouer()) {
							System.out.println("Vous ne pouvez plus rejouer pendant cette manche !");
						}
						else {
							if(!Plateau.ordreCorrect(ordreJoueur)) {
								--nbJoueurRestant;
								System.out.println("Votre réponse est incorrecte, vous ne pouvez plus jouer pendant cette manche !");
								joueurs.get(Joueur.getIndice(joueurs, nomJoueur)).setADejaJouer();
							}
							else {
								Plateau pExecuter = paquet.getCarte(i);
								pExecuter.executerOrdre(ordreJoueur);
								if(!pExecuter.comparer(paquet.getCarte(i+1))) {
									--nbJoueurRestant;
									System.out.println("Votre réponse est incorrecte, vous ne pouvez plus jouer pendant cette manche !");
									joueurs.get(Joueur.getIndice(joueurs, nomJoueur)).setADejaJouer();
								}
								else {
									System.out.println("Bravo ! Vous avez gagnez un point !\n");
									joueurs.get(Joueur.getIndice(joueurs, nomJoueur)).ajouterPoint();
									Joueur.resetADejaJouer(joueurs);
									break;
								}
							}
						}
					}
					
					
				}
				else {
					System.out.println("Il ne reste qu'un joueur, il gagne la manche\n");
					for(int j = 0; j < joueurs.size(); ++j) {
						if(!joueurs.get(j).getADejaJouer()) {
							joueurs.get(j).ajouterPoint();
						}
					}
					Joueur.resetADejaJouer(joueurs);
					break;
				}
			}while((paquet.getCarte(i).equals(paquet.getCarte(i+1)) == false));
		}
		/*Fin du jeu*/
		System.out.println("Fin du jeu ! Merci d'avoir joué");
		Joueur.triClassement(joueurs);
		Joueur.afficherClassement(joueurs);
		System.out.println("\n==============================================================");
	}
	
}
