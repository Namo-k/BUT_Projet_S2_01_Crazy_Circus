package crazycircus;
/**
 * @file Paquets.java
 * @brief Entête de la classe Paquets
 */

import java.util.ArrayList;
import java.util.Collections;

public class Paquet {
	private ArrayList<Plateau> paquet;
	
	/**
	 * Construit le paquet de 24 cartes mélangé, une carte est un podium
	 */
	public Paquet() {
			
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
		p2.getPodium(Couleur.BLEU).ajouter(lion);
		p2.getPodium(Couleur.BLEU).ajouter(ours);
		paquet.add(p2);
		
		Plateau p3 = new Plateau();
		p3.getPodium(Couleur.BLEU).ajouter(lion);
		p3.getPodium(Couleur.BLEU).ajouter(ours);
		p3.getPodium(Couleur.BLEU).ajouter(elephant);
		paquet.add(p3);
		
		Plateau p4 = new Plateau();
		p4.getPodium(Couleur.BLEU).ajouter(lion);
		p4.getPodium(Couleur.BLEU).ajouter(elephant);
		p4.getPodium(Couleur.BLEU).ajouter(ours);
		paquet.add(p4);
		
		Plateau p5 = new Plateau();
		p5.getPodium(Couleur.BLEU).ajouter(ours);
		p5.getPodium(Couleur.BLEU).ajouter(elephant);
		p5.getPodium(Couleur.BLEU).ajouter(lion);
		paquet.add(p5);
		
		Plateau p6 = new Plateau();
		p6.getPodium(Couleur.BLEU).ajouter(ours);
		p6.getPodium(Couleur.BLEU).ajouter(lion);
		p6.getPodium(Couleur.BLEU).ajouter(elephant);
		paquet.add(p6);
		
		Plateau p7 = new Plateau();
		p7.getPodium(Couleur.ROUGE).ajouter(elephant);
		p7.getPodium(Couleur.ROUGE).ajouter(ours);
		p7.getPodium(Couleur.ROUGE).ajouter(lion);
		paquet.add(p7);
		
		Plateau p8 = new Plateau();
		p8.getPodium(Couleur.ROUGE).ajouter(elephant);
		p8.getPodium(Couleur.ROUGE).ajouter(lion);
		p8.getPodium(Couleur.ROUGE).ajouter(ours);
		paquet.add(p8);
		
		Plateau p9 = new Plateau();
		p9.getPodium(Couleur.ROUGE).ajouter(lion);
		p9.getPodium(Couleur.ROUGE).ajouter(ours);
		p9.getPodium(Couleur.ROUGE).ajouter(elephant);
		paquet.add(p9);
		
		Plateau p10 = new Plateau();
		p10.getPodium(Couleur.ROUGE).ajouter(lion);
		p10.getPodium(Couleur.ROUGE).ajouter(elephant);
		p10.getPodium(Couleur.ROUGE).ajouter(ours);
		paquet.add(p10);
		
		Plateau p11 = new Plateau();
		p11.getPodium(Couleur.ROUGE).ajouter(ours);
		p11.getPodium(Couleur.ROUGE).ajouter(elephant);
		p11.getPodium(Couleur.ROUGE).ajouter(lion);
		paquet.add(p11);
		
		Plateau p12 = new Plateau();
		p12.getPodium(Couleur.ROUGE).ajouter(ours);
		p12.getPodium(Couleur.ROUGE).ajouter(lion);
		p12.getPodium(Couleur.ROUGE).ajouter(elephant);
		paquet.add(p12);
		
		Plateau p13 = new Plateau();
		p13.getPodium(Couleur.BLEU).ajouter(elephant);
		p13.getPodium(Couleur.BLEU).ajouter(lion);
		p13.getPodium(Couleur.ROUGE).ajouter(ours);
		paquet.add(p13);
		
		Plateau p14 = new Plateau();
		p14.getPodium(Couleur.BLEU).ajouter(elephant);
		p14.getPodium(Couleur.BLEU).ajouter(ours);
		p14.getPodium(Couleur.ROUGE).ajouter(lion);
		paquet.add(p14);
		
		Plateau p15 = new Plateau();
		p15.getPodium(Couleur.BLEU).ajouter(lion);
		p15.getPodium(Couleur.BLEU).ajouter(ours);
		p15.getPodium(Couleur.ROUGE).ajouter(elephant);
		paquet.add(p15);
		
		Plateau p16 = new Plateau();
		p16.getPodium(Couleur.BLEU).ajouter(lion);
		p16.getPodium(Couleur.BLEU).ajouter(elephant);
		p16.getPodium(Couleur.ROUGE).ajouter(ours);
		paquet.add(p16);
		
		Plateau p17 = new Plateau();
		p17.getPodium(Couleur.BLEU).ajouter(ours);
		p17.getPodium(Couleur.BLEU).ajouter(elephant);
		p17.getPodium(Couleur.ROUGE).ajouter(lion);
		paquet.add(p17);
		
		Plateau p18 = new Plateau();
		p18.getPodium(Couleur.BLEU).ajouter(ours);
		p18.getPodium(Couleur.BLEU).ajouter(lion);
		p18.getPodium(Couleur.ROUGE).ajouter(elephant);
		paquet.add(p18);
		
		Plateau p19 = new Plateau();
		p19.getPodium(Couleur.BLEU).ajouter(elephant);
		p19.getPodium(Couleur.ROUGE).ajouter(lion);
		p19.getPodium(Couleur.ROUGE).ajouter(ours);
		paquet.add(p19);
		
		Plateau p20 = new Plateau();
		p20.getPodium(Couleur.BLEU).ajouter(elephant);
		p20.getPodium(Couleur.ROUGE).ajouter(ours);
		p20.getPodium(Couleur.ROUGE).ajouter(lion);
		paquet.add(p20);
		
		Plateau p21 = new Plateau();
		p21.getPodium(Couleur.BLEU).ajouter(lion);
		p21.getPodium(Couleur.ROUGE).ajouter(ours);
		p21.getPodium(Couleur.ROUGE).ajouter(elephant);
		paquet.add(p21);
		
		Plateau p22 = new Plateau();
		p22.getPodium(Couleur.BLEU).ajouter(lion);
		p22.getPodium(Couleur.ROUGE).ajouter(elephant);
		p22.getPodium(Couleur.ROUGE).ajouter(ours);
		paquet.add(p22);
		
		Plateau p23 = new Plateau();
		p23.getPodium(Couleur.BLEU).ajouter(ours);
		p23.getPodium(Couleur.ROUGE).ajouter(elephant);
		p23.getPodium(Couleur.ROUGE).ajouter(lion);
		paquet.add(p23);
		
		Plateau p24 = new Plateau();
		p24.getPodium(Couleur.BLEU).ajouter(ours);
		p24.getPodium(Couleur.ROUGE).ajouter(lion);
		p24.getPodium(Couleur.ROUGE).ajouter(elephant);
		paquet.add(p24);
		
		melanger();
	}
	
	/**
	 * Mélange le paquet
	 */
	public void melanger() {
		Collections.shuffle(paquet);
	}
	
	/**
	 * Revoi le nombre de carte du paquet
	 * @return la taille du paquet
	 */
	public int getSizePaquet() {
		return paquet.size();
	}
	
	/**
	 * Pioche une carte du paquet
	 * @param indice la position d'une carte
	 * @return une carte du paquet à la position indice
	 */
	public Plateau getCarte(int indice) {
		return paquet.get(indice);
	}
}
