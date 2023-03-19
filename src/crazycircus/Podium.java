package crazycircus;

/**
* @file Podium.java
* @brief Entête de la classe Podium
*/

import java.util.ArrayList;

public class Podium {
	private ArrayList<Animal> podium;
	Couleur couleur;
	
	/**
	 * Construit l'objet podium correspondant à une couleur
	 */
	public Podium (Couleur c) {
		podium = new ArrayList<>();
		couleur = c;
	}
	
	/**
	 * Verifie si le podium est vide
	 * @return un boolean estVide
	 */
	public boolean estVide() {
		return (this.podium.isEmpty());
	}

	/**
	 * Renvoie la taille du podium
	 * @return size la taille du podium
	 */
	public int getSize() {
		return podium.size();
	}

	/**
	 * Renvoie l'animal à la position donné
	 * @param position la position de l'animal
	 * @return l'animal à la position
	 */
	public Animal getAnimal(int position) {
		return podium.get(position);
	}

	/**
	 * Renvoie l'animal au sommet du podium
	 * @return l'animal situé au sommet
	 */
	public Animal getSommet() {	
		return getAnimal(podium.size()-1);
	}
	
	/**
	 * Ajouter l'animal au podium
	 * @param e l'animal à ajouter
	 */
	public void ajouter(Animal e) {
		podium.add(e);
	}
	
	/**
	 * Retirer l'élément i du podium
	 * @param i position i
	 */
	public void retirer(int i) {
		podium.remove(i);
	}
	
	/**
	 * Renvoie le podium
	 * @return podium
	 */
	public ArrayList<Animal> getPodium(){
		return podium;
	}
}
