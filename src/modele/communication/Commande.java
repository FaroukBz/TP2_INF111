package modele.communication;

public class Commande extends Message {
	
	private eCommande commande;
	
	public Commande(int compte) {
		super(compte);
	
	}

	
	public eCommande getECommande() {
		return commande;
	}
	
	
	public static void main(String[]args) {
		
		
		Commande c = new Commande(1);
	}
	
}
