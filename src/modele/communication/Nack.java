package modele.communication;

public class Nack extends Message {

	public Nack(int compte) {
		super(compte);

	}


	public static void main(String[]args) {
		Nack n = new Nack(1);
		n.getCompte();
		System.out.println(n.getClass());
	}


}
