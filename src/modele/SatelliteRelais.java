package modele;


/**
 * Classe simulant le satellite relais
 * 
 * Le satellite se contente de transférer les messages du robot vers le 
 * centre de contrôle et vice-versa.
 * 
 * Le satellite exécute des cycles à intervale de TEMPS_CYCLE_MS. Période à
 * laquelle tous les messages en attente sont transmis. Ceci est implémenté à
 * l'aide d'une tâche (Thread).
 * 
 * Le relais satellite simule également les interférences dans l'envoi des 
 * messages.
 * 
 * Services offerts:
 *  - lierControle
 *  - lierRobot
 *  - envoyerMessageVersControle
 *  - envoyerMessageVersRobot
 * 
 * @author Frederic Simard, ETS
 * @author Simon Pichette, ETS (révision groupe 03)
 * @version Hiver, 2019
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import modele.communication.Message;
import utilitaires.File;

public class SatelliteRelais extends Thread{
	
	static final int TEMPS_CYCLE_MS = 500;
	static final double PROBABILITE_PERTE_MESSAGE = 0.15;
	
	ReentrantLock lock = new ReentrantLock();
	
	private Random rand = new Random();

	private File msgRobot = new File();
	private File msgControle = new File();
	
	/**
	 * Méthode permettant d'envoyer un message vers le centre de contrôle
	 * @param msg, message à envoyer
	 */
	public void envoyerMessageVersControle(Message msg) {
		
		lock.lock();
		
		try {

			/*
			 * (5.1) Insérer votre code ici 
			 */
			if(Math.random()>PROBABILITE_PERTE_MESSAGE) {
				msgControle.ajouterElement(msg);
			}
			
			
			
			
		}finally {
			lock.unlock();
		}
	}
	
	/**
	 * Méthode permettant d'envoyer un message vers le robot
	 * @param msg, message à envoyer
	 */
	public void envoyerMessageVersRobot(Message msg) {
		lock.lock();
		
		try {

			/*
			 * (5.2) Insérer votre code ici 
			 */
			if(Math.random()>PROBABILITE_PERTE_MESSAGE) {
				msgRobot.ajouterElement(msg);
			}
			
		}finally {
			lock.unlock();
		}
	}

	
	@Override
	public void run() {
		
		while(true) {
			
			/*
			 * (5.3) Insérer votre code ici 
			 */
			msgControle.enleverElement();
			msgRobot.enleverElement();

			// attend le prochain cycle
			try {
				Thread.sleep(TEMPS_CYCLE_MS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
