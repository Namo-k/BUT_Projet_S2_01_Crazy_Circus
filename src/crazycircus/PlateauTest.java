package crazycircus;
import static org.junit.Assert.*;

import org.junit.Test;

public class PlateauTest {

	@Test
	public void testEstVide() {
		Plateau p = new Plateau();
		assertTrue(p.estVide(Couleur.BLEU) == true);
	}

	@Test
	public void testKI() {
		Animal elephant = Animal.ELEPHANT;
		Animal ours = Animal.OURS;
		Animal lion = Animal.LION;
		
		Plateau p1 = new Plateau();
		p1.getPodium(Couleur.BLEU).ajouter(elephant);
		p1.getPodium(Couleur.BLEU).ajouter(lion);
		p1.getPodium(Couleur.ROUGE).ajouter(ours);
		
		p1.KI();
		assertTrue(p1.getPodium(Couleur.BLEU).getSommet().equals(elephant));
		assertTrue(p1.getPodium(Couleur.ROUGE).getSommet().equals(lion));
	
	}
	
	@Test
	public void testLO() {
		Animal elephant = Animal.ELEPHANT;
		Animal ours = Animal.OURS;
		Animal lion = Animal.LION;
		
		Plateau p1 = new Plateau();
		p1.getPodium(Couleur.ROUGE).ajouter(elephant);
		p1.getPodium(Couleur.ROUGE).ajouter(lion);
		p1.getPodium(Couleur.BLEU).ajouter(ours);
		
		p1.LO();
		assertTrue(p1.getPodium(Couleur.ROUGE).getSommet().equals(elephant));
		assertTrue(p1.getPodium(Couleur.BLEU).getSommet().equals(lion));
	}
	
	@Test
	public void testSO() {
		Animal elephant = Animal.ELEPHANT;
		Animal ours = Animal.OURS;
		Animal lion = Animal.LION;
		
		Plateau p1 = new Plateau();
		p1.getPodium(Couleur.ROUGE).ajouter(elephant);
		p1.getPodium(Couleur.ROUGE).ajouter(lion);
		p1.getPodium(Couleur.BLEU).ajouter(ours);
		
		p1.SO();
		assertTrue(p1.getPodium(Couleur.ROUGE).getSommet().equals(ours));
		assertTrue(p1.getPodium(Couleur.BLEU).getSommet().equals(lion));
	}
	
	@Test
	public void testNI() {
		Animal elephant = Animal.ELEPHANT;
		Animal ours = Animal.OURS;
		Animal lion = Animal.LION;
		
		Plateau p1 = new Plateau();
		p1.getPodium(Couleur.BLEU).ajouter(elephant);
		p1.getPodium(Couleur.BLEU).ajouter(lion);
		p1.getPodium(Couleur.BLEU).ajouter(ours);
		
		p1.NI();
		assertTrue(p1.getPodium(Couleur.BLEU).getSommet().equals(elephant));
		assertTrue(p1.getPodium(Couleur.BLEU).getAnimal(0).equals(lion));
	}
	
	@Test
	public void testMA() {
		Animal elephant = Animal.ELEPHANT;
		Animal ours = Animal.OURS;
		Animal lion = Animal.LION;
		
		Plateau p1 = new Plateau();
		p1.getPodium(Couleur.ROUGE).ajouter(elephant);
		p1.getPodium(Couleur.ROUGE).ajouter(lion);
		p1.getPodium(Couleur.ROUGE).ajouter(ours);
		
		p1.MA();
		assertTrue(p1.getPodium(Couleur.ROUGE).getSommet().equals(elephant));
		assertTrue(p1.getPodium(Couleur.ROUGE).getAnimal(0).equals(lion));
	}
	
	@Test
	public void testOrdreCorrect() {
		String ordres1 = "SOLOMANIKI";
		assertTrue(Plateau.ordreCorrect(ordres1) == true);
		
		String ordres2 = "NAMO";
		assertTrue(Plateau.ordreCorrect(ordres2) == false);
	}
	
	@Test
	public void testExecuterOrdre() {
		String reponse = "KI";
		
		Animal elephant = Animal.ELEPHANT;
		Animal ours = Animal.OURS;
		Animal lion = Animal.LION;
		
		Plateau p1 = new Plateau();
		p1.getPodium(Couleur.BLEU).ajouter(elephant);
		p1.getPodium(Couleur.ROUGE).ajouter(ours);
		p1.getPodium(Couleur.ROUGE).ajouter(lion);
		
		p1.executerOrdre(reponse);
		assertTrue(p1.estVide(Couleur.BLEU) == true);
		assertTrue(p1.getPodium(Couleur.ROUGE).getSommet() == elephant);
	}

	@Test
	public void testComparer() {
		
		Animal elephant = Animal.ELEPHANT;
		Animal ours = Animal.OURS;
		Animal lion = Animal.LION;
		
		
		Plateau p1 = new Plateau();
		p1.getPodium(Couleur.BLEU).ajouter(elephant);
		p1.getPodium(Couleur.ROUGE).ajouter(ours);
		p1.getPodium(Couleur.ROUGE).ajouter(lion);
		
		Plateau p2 = new Plateau();
		p2.getPodium(Couleur.BLEU).ajouter(elephant);
		p2.getPodium(Couleur.ROUGE).ajouter(ours);
		p2.getPodium(Couleur.ROUGE).ajouter(lion);
		
		assertTrue(p1.comparer(p2) == true);
	}


}
