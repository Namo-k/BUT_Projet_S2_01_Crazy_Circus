package crazycircus;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PaquetTest {

	@Test
	public void testPaquets() {
		ArrayList<Plateau> paquet;
		
		Animal elephant = Animal.ELEPHANT;
		Animal ours = Animal.OURS;
		Animal lion = Animal.LION;
		
		paquet = new ArrayList<>();
		
		Plateau p1 = new Plateau();
		p1.getPodium(Couleur.BLEU).ajouter(elephant);
		p1.getPodium(Couleur.BLEU).ajouter(ours);
		p1.getPodium(Couleur.BLEU).ajouter(lion);
		paquet.add(p1);
		
		Plateau p2 = new Plateau();
		p2.getPodium(Couleur.BLEU).ajouter(elephant);
		p2.getPodium(Couleur.BLEU).ajouter(ours);
		p2.getPodium(Couleur.BLEU).ajouter(lion);
		paquet.add(p2);	
		
		assertTrue(p1.getPodium(Couleur.BLEU).getPodium().equals(p2.getPodium(Couleur.BLEU).getPodium()));
	}

	@Test
	public void testMelanger() {
		
		Animal elephant = Animal.ELEPHANT;
		Animal ours = Animal.OURS;
		Animal lion = Animal.LION;
		
		Plateau p1 = new Plateau();
		p1.getPodium(Couleur.BLEU).ajouter(elephant);
		p1.getPodium(Couleur.BLEU).ajouter(ours);
		p1.getPodium(Couleur.BLEU).ajouter(lion);
		
		Paquet paquet = new Paquet();
		paquet.melanger();
		
		assertTrue(!p1.equals(paquet.getCarte(0)));
	}

}
