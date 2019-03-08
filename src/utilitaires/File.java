package utilitaires;

import java.util.ArrayList;
import java.util.LinkedList;
/*
 * 
 * @version : 2019/02/25
 * @author Farouk Baaziz
 * 			
 */
public class File {


	// attributs d'instance	
	// capacite initiale par defaut
	private static final int CAPACITE_INITIALE = 10;
	private int capacite; // nbr de places dans la file
	private ArrayList<Object> elements; // array list contenant les element de la file

	

	//constructeur par default
	public File() {
		this(CAPACITE_INITIALE);
	
	}
	
	//constructeur avec parametre
	public File(int capacite) {
		
		this.capacite = capacite;
		elements = new ArrayList<Object>();
	
	}
	
	/*
	 * Ajoute un element a la fin de cette file
	 * 
	 * @param elem l'element a ajouter a la fin de cette fille
	 */
	
	public void ajouterElement(Object elem) { 
	
		elements.add(elem);
		
		}
	
	//enleverElement de la file  et le retourner
	public Object enleverElement() {
		//declaration de la variable de reference
		Object elem;
		
		//si la file n'est pas vide
		if(!elements.isEmpty()) {
		//mettre la reference sur le premier element de la file
		 elem = elements.get(0);	
		//retirer l'element de la file
		elements.remove(0);
		}
		else {
			elem= null;
		}
		
		//retourne l'element enlevee
		return elem;
	}
	
	public int getNbrElements() {
		return elements.size();
	}
	
	//return true si la file est vide
	public boolean estVide() {

		return elements.isEmpty();
	}
	
	// methode de test
	public static void main(String[]args) {
		File f = new File(10);
		
		f.ajouterElement(null);
		f.ajouterElement(null);
		f.ajouterElement(null);
		f.ajouterElement(null);		
		
		LinkedList<Object> liste  = new LinkedList<Object>();
		liste.add(null);
		liste.add(null);
		System.out.println(liste.size());
		
		
		
//		System.out.println(f.elements.get(0));
//		System.out.println(f.getNbrElements());
//		System.out.println();
//		File t = new File();
//		System.out.println(t.enleverElement());
//		System.out.println(t.getNbrElements());
	}
		
}
