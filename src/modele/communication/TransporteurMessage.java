package modele.communication;
/**
 * Classe qui implémente le protocole de communication entre le robot
 * et le Centre d'opération.
 * 
 * Il se base sur une interprétation libre du concept de Nack:
 * 	https://webrtcglossary.com/nack/
 *  
 * Les messages envoyés sont mémorisés. À l'aide du compte unique
 * le transporteur de message peut identifier les messages manquant
 * dans la séquence et demander le renvoi d'un message à l'aide du Nack.
 * 
 * Pour contourner la situation où le Nack lui-même est perdu, le Nack
 * est renvoyé periodiquement, tant que le Message manquant n'a pas été reçu.
 * 
 * C'est également cette classe qui gère les comptes uniques.
 * 
 * Les messages reçus sont mis en file pour être traités.
 * 
 * La gestion des messages reçus s'effectue comme une tâche s'exécutant 
 * indépendamment (Thread)
 * 
 * Quelques détails:
 *  - Le traitement du Nack a priorité sur tout autre message.
 *  - Un message NoOp est envoyé périodiquement pour s'assurer de maintenir
 *    une communication active et identifier les messages manquants en bout de 
 *    séquence.
 * 
 * Services offerts:
 *  - TransporteurMessage
 *  - receptionMessageDeSatellite
 *  - run
 * 
 * @author Frederic Simard, ETS
 * @author Simon Pichette, ETS (révision groupe 03)
 * @version Hiver, 2019
 */

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public abstract class TransporteurMessage extends Thread {

	private ArrayList<Object> liste=new ArrayList<Object>();

	// compteur de message
	protected CompteurMessage compteurMsg;
	
	// lock qui protège la liste de messages reçus
	private ReentrantLock lock = new ReentrantLock();
	
	/**
	 * Constructeur, initialise le compteur de messages unique
	 */
	public TransporteurMessage() {
		compteurMsg = new CompteurMessage();		
	}
	
	/**
	 * Méthode gérant les messages reçus du satellite. La gestion se limite
	 * à l'implémentation du Nack, les messages spécialisés sont envoyés
	 * aux classes dérivées
	 * @param msg, message reçu
	 */
	public void receptionMessageDeSatellite(Message msg) {
		
		lock.lock();

		try {

			if(msg.getClass().equals("class modele.communication.Nack")){
				liste.add(0, msg);
			}
			else{
				liste.set(msg.compte(),msg);
			}

		}finally {
			lock.unlock();
		}
	}

	@Override
	/**
	 * Tâche effectuant la gestion des messages reçus
	 */
	public void run() {
		
		int compteCourant = 0;
		
		while(true) {
			
			lock.lock();
			
			
			
			try {

				while()
			
			}finally{
				lock.unlock();
			}
			
			// pause, cycle de traitement de messages
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * méthode abstraite utilisée pour envoyer un message
	 * @param msg, le message à envoyer
	 */
	abstract protected void envoyerMessage(Message msg);

	/**
	 * méthode abstraite utilisée pour effectuer le traitement d'un message
	 * @param msg, le message à traiter
	 */
	abstract protected void gestionnaireMessage(Message msg);

	

}
