package programme;

import java.io.IOException;

import modele.SatelliteRelais;

public class ProgrammePrincipal {

	/**
	 * Programme principale, instancie les éléments de la simulation,
	 * les lie entre eux, puis lance la séquence de test.
	 * @param args, pas utilisé
	 */
	public static void main(String[] args){
	
		SatelliteRelais satellite = new SatelliteRelais();
		satellite.getMsgRobot().ajouterElement("a");
		satellite.getMsgRobot().ajouterElement("b");
		satellite.getMsgRobot().ajouterElement("c");
		satellite.start();
		System.out.println(satellite.getMsgRobot().getNbrElements());
		


	}

}
