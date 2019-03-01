package utilitaires;

import modele.SatelliteRelais;
/*
 * 
 * @version : 2019/02/25
 * @author Farouk Baaziz
 * 			
 */
public class Vecteur2D {
	
	private double x;	//longueur en x
	private double y;	//longueur en y
	
	//********** const. par defaut
	public Vecteur2D () {
		this(0,0);
	}

	//********** const. par parametre
	public Vecteur2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//********** const. par copie
	public Vecteur2D(Vecteur2D precedant) {
		this(precedant.x, precedant.y); 
	}
	
	
	//********** accesseurs 
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	//********** methode publique
	public double getLongueur() {
		return Math.sqrt((x*x)+(y*y));
	}
	
	public double getAngle() {
		return Math.atan(y/x);
	}
	
	// Cette méthode reçoit un Vecteur2D positionFin. Elle crée un nouveau Vecteur2D qui
	// contient la différence entre positionFin et le vecteur this.
	public Vecteur2D difference(Vecteur2D positionFin) {
		Vecteur2D v2 = new Vecteur2D(positionFin.x-this.x, positionFin.y-this.y);
		return v2;
		
	}
	
	public void diviser(double a) {
		x/= a;
		y/= a;
	}
	
	//Cette méthode reçoit un Vecteur2D. Elle crée un nouveau Vecteur2D qui contient la
	//somme du vecteur existant et du vecteur reçu
	public Vecteur2D ajouter(Vecteur2D v1) {
		Vecteur2D v2 = new Vecteur2D(v1.x+this.x, v1.y+this.y);
		return v2;
	}
	
	public String toString() {
		
		return "Le vecteur a pour valeur: " + x +" en x et "+ y +" en y";
	}
	
	public boolean equals(Vecteur2D v2) {
		if(x== v2.x && y == v2.y) {
			return true;
		}
		return false;
	}
	
	//test des methode
	public static void main(String[] args){
		
		Vecteur2D v1 = new Vecteur2D(1,1);
		Vecteur2D v2 = new Vecteur2D(10,10);
		System.out.println(""+ v1.difference(v2).toString());
		v2.diviser(2);
		System.out.println(v2.toString());
		
	}
}
