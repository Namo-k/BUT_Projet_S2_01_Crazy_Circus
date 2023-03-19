package crazycircus;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class JoueurTest {

	@Test
	public void testJoueur() {
		Joueur j = new Joueur("Alexandre");
		assertTrue(j.getNom().equals("Alexandre"));
		assertTrue(j.getScore() == 0);
		assertTrue(j.getADejaJouer() == false);
	}
	@Test
	public void testCreerJoueur() {
		ArrayList<Joueur> joueurs  = new ArrayList<>();
		String nomJoueur = "Alexandre";
		Joueur.creerJoueur(joueurs, nomJoueur);
		assertTrue("Alexandre" == joueurs.get(0).getNom());
	}
	@Test
	public void testVerifJoueur() {
		ArrayList<Joueur> joueurs  = new ArrayList<>();
		String nomJoueur1 = "Alexandre";
		Joueur.creerJoueur(joueurs, nomJoueur1);
		String nomJoueur2 = "Namodacane";
		Joueur.creerJoueur(joueurs, nomJoueur2);
		assertTrue(Joueur.verifJoueur(joueurs, "Alexandre") == true);
		assertTrue(Joueur.verifJoueur(joueurs, "Namodacane") == true);
	}
	@Test
	public void testAjouterPoint() {
		Joueur j = new Joueur("Alexandre");
		j.ajouterPoint();
		assertTrue(j.getScore() == 1);
	}
	@Test
	public void testSetADejaJoue() {
		Joueur j = new Joueur("Namodacane");
		j.setADejaJouer();
		assertTrue(j.getADejaJouer() == true);
	}
	@Test
	public void testSetAPasJoue() {
		Joueur j = new Joueur("Namodacane");
		j.setAPasJouer();
		assertTrue(j.getADejaJouer() == false);
	}
	@Test
	public void testResetADejaJouer() {
		ArrayList<Joueur> joueurs  = new ArrayList<>();
		String nomJoueur1 = "Alexandre";
		Joueur.creerJoueur(joueurs, nomJoueur1);
		String nomJoueur2 = "Namodacane";
		Joueur.creerJoueur(joueurs, nomJoueur2);
		joueurs.get(0).setADejaJouer();
		joueurs.get(1).setADejaJouer();
		Joueur.resetADejaJouer(joueurs);
		assertTrue(joueurs.get(0).getADejaJouer() == false);
		assertTrue(joueurs.get(1).getADejaJouer() == false);
	}
	@Test
	public void testTriClassment() {
		ArrayList<Joueur> joueurs  = new ArrayList<>();
		String nomJoueur1 = "Alexandre";
		Joueur.creerJoueur(joueurs, nomJoueur1);
		String nomJoueur2 = "Namodacane";
		Joueur.creerJoueur(joueurs, nomJoueur2);
		joueurs.get(1).ajouterPoint();
		Joueur.resetADejaJouer(joueurs);
		Joueur.triClassement(joueurs);
		assertTrue(joueurs.get(0).getNom().equals("Namodacane"));
		assertTrue(joueurs.get(1).getNom().equals("Alexandre"));
	}

}
