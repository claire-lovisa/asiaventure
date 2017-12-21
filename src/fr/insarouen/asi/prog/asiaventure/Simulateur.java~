package fr.insarouen.asi.prog.asiaventure;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsSame;
import org.junit.*;
import java.io.*;
import java.util.Scanner;
import java.util.Collection;
import fr.insarouen.asi.prog.asiaventure.*;
import java.util.ArrayList;
import fr.insarouen.asi.prog.asiaventure.elements.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import java.lang.*;

/**
 * Classe qui simule le jeu
 * @author Elise TELLIER et Madeleine ZUBER
 * */

public class Simulateur {

	// **** Attributs **** //

	private Monde monde;
	private ArrayList<ConditionDeFin> listeConditions = new ArrayList<ConditionDeFin>();
	private EtatDuJeu etatJeu;


	// **** Constructeur **** //
	/**
	 * Constructeur du simulateur à partir d'un monde
	 * @param monde Monde à simuler
	 * */

	public Simulateur(Monde monde, ConditionDeFin... conditionsdeFin) {
		this.monde = monde;
		etatJeu = EtatDuJeu.ENCOURS;
		for(ConditionDeFin cf : conditionsdeFin)
			listeConditions.add(cf);
	}

	/**
	 * Constructeur du simulateur à partir d'un fichier de partie enregistrée
	 * @param ois Le fichier à lire
	 * */
	public Simulateur(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		monde = (Monde)ois.readObject();
		etatJeu = (EtatDuJeu)ois.readObject();
		listeConditions = (ArrayList<ConditionDeFin>)ois.readObject();
	}


	private void creerMonde(StreamTokenizer flux) throws IOException {
		flux.nextToken();
		monde = new Monde(flux.sval);
	}

	private void creerPorte(StreamTokenizer flux) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException {
		String nomPorte;
		Piece piece1;
		Piece piece2;

		flux.nextToken();
		nomPorte = flux.sval;
		flux.nextToken();
		piece1 = (Piece)monde.getEntite(flux.sval);
		flux.nextToken();
		piece2 = (Piece)monde.getEntite(flux.sval);
		Porte porte = new Porte(nomPorte, monde, piece1, piece2);
	}

	private void creerPiece(StreamTokenizer flux) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException {
		flux.nextToken();
		Piece piece = new Piece(flux.sval, monde);
	}

	private void creerPorteSerrure(StreamTokenizer flux) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException {
		String nomPorte;
		Piece piece1;
		Piece piece2;

		flux.nextToken();
		nomPorte = flux.sval;
		flux.nextToken();
		piece1 = (Piece)monde.getEntite(flux.sval);
		flux.nextToken();
		piece2 = (Piece)monde.getEntite(flux.sval);

		Serrure serrure = new Serrure("serrureDe"+nomPorte, monde);
		Porte porte = new Porte(nomPorte, monde, serrure, piece1, piece2);
	}

	private void creerClef(StreamTokenizer flux) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException {
		flux.nextToken();
		Porte porte = (Porte)monde.getEntite(flux.sval); // on récupère la porte dont il faut faire la cle
		Clef cle = porte.getSerrure().creerClef(); // on creer la cle de la serrure de la porte
		flux.nextToken();
		Piece piece = (Piece)monde.getEntite(flux.sval); // on lit la piece où il faut deposer la cle
		piece.deposer(cle); //depot de la cle dans la piece.

	}

	private void creerJoueurHumain(StreamTokenizer flux) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException {
		flux.nextToken();
		String nomJoueur = flux.sval;
		flux.nextToken();
		int nbPtVie = (int) flux.nval;
		flux.nextToken();
		int nbForce = (int) flux.nval;
		flux.nextToken();
		Piece piece = (Piece)monde.getEntite(flux.sval);
		JoueurHumain joueur = new JoueurHumain(nomJoueur, monde, nbPtVie, nbForce, piece);
	}

	private void creerMonstre(StreamTokenizer flux) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException {
		flux.nextToken();
		String nomJoueur = flux.sval;
		flux.nextToken();
		int nbPtVie = (int) flux.nval;
		flux.nextToken();
		int nbForce = (int) flux.nval;
		flux.nextToken();
		Piece piece = (Piece)monde.getEntite(flux.sval); // why ?
		Monstre monstre = new Monstre(nomJoueur, monde, nbPtVie, nbForce, piece);
	}

	private void creerPdb(StreamTokenizer flux) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException {
		flux.nextToken();
		String nom = flux.sval;
		PiedDeBiche pdb = new PiedDeBiche(nom, monde);
		// on le fait entrer dans une piece initiale.
		flux.nextToken();
		Piece piece = (Piece)monde.getEntite(flux.sval);
		piece.deposer(pdb);
	}

	private void creerCoffre(StreamTokenizer flux) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException {
		flux.nextToken();
		String nom = flux.sval;
		Coffre coffre = new Coffre(nom, monde);
		// on le fait entrer dans une piece initiale.
		flux.nextToken();
		Piece piece = (Piece)monde.getEntite(flux.sval);
		piece.deposer(coffre);
	}

	private void creerConditionDeFinVivantDansPiece(StreamTokenizer flux) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException {
		flux.nextToken();
		EtatDuJeu etat = EtatDuJeu.valueOf(flux.sval);
		flux.nextToken();
		Vivant vivant = (Vivant)monde.getEntite(flux.sval);
		flux.nextToken();
		Piece piece = (Piece)monde.getEntite(flux.sval);
		ConditionDeFinVivantDansPiece c = new ConditionDeFinVivantDansPiece(etat, vivant, piece);
		ajouterConditionDeFin(c);
	}

	/**
	 * Constructeur du simulateur à partir d'un fichier de configuration
	 * @param ois Le fichier à lire
	 * */
	public Simulateur(Reader reader) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException {
		StreamTokenizer flux = new StreamTokenizer(reader);
		String  type;
		int ttype;
		while ((ttype = flux.nextToken()) != StreamTokenizer.TT_EOF) {
			type = flux.sval; // on recupère le premier mot de la ligne donc  le type
			if(ttype == StreamTokenizer.TT_WORD) {
				switch (type) {
					case "Monde" :
						creerMonde(flux);
						break;
					case "Piece" :
						creerPiece(flux);
						break;
					case "Porte" :
						creerPorte(flux);
						break;
					case "PorteSerrure" :
						creerPorteSerrure(flux);
						break;
					case "Clef" :
						creerClef(flux);
						break;
					case "JoueurHumain" :
						creerJoueurHumain(flux);
						break;
					case "Monstre" :
						creerMonstre(flux);
						break;
					case "PiedDeBiche" :
						creerPdb(flux);
						break;
					case "Coffre" :
						creerCoffre(flux);
						break;
					case "ConditionDeFinVivantDansPiece" :
						creerConditionDeFinVivantDansPiece(flux);
						break;
					default :
						System.err.println("Action inconnue : " + type);
						break;
				}
			}
		}
		etatJeu = EtatDuJeu.ENCOURS;
	}


	// **** Méthodes **** //
	/**
	 * Enregistre une partie
	 * @param ois Le fichier à écrire
	 * */
	public void enregistrer(ObjectOutputStream oos) throws IOException {
		oos.writeObject(monde);
		oos.writeObject(etatJeu);
		oos.writeObject(listeConditions);
	}

	/**
	 * Retourne le monde du simulateur
	 * @return le monde
	 * */
	public Monde getMonde() {
		return monde;
	}

	/**
	 *Ajoute une condition de fin au Simulateur
	 * @param c Condition de fin à ajouter
	 * */
	public void ajouterConditionDeFin(ConditionDeFin c) {
		listeConditions.add(c);
	}

	/**
	 *Ajoute une collection de conditions de fin au Simulateur
	 * @param conditions Collection de conditions de fin à ajouter
	 * */
	public void ajouterConditionsDeFin(Collection<ConditionDeFin> conditions) {
		listeConditions.addAll(conditions);
	}

	/**
	 * Retourne l'état du jeu du simulateur
	 * @return l'état du jeu
	 * */
	public EtatDuJeu getEtatDuJeu() {
		return etatJeu;
	}

/**
	* Execute un tour de jeu
	* @return l'etat du jeu à la fin du tour
	* */
	public EtatDuJeu executerUnTour() throws Throwable {

		Collection<Executable> lesExec = monde.getExecutables();
		for (Executable e : lesExec)
			if (e instanceof JoueurHumain){
				System.out.println(" ****** votre situation ******");
				System.out.println(e.toString());
				System.out.println(" ****** la pièce où vous êtes : ******");
				System.out.println(((JoueurHumain)e).getPiece().toString());
				System.out.println("Veuillez entrer votre ordre s'il vous plaît :");
				Scanner sc = new Scanner(System.in);
				((JoueurHumain)e).setOrdre(sc.nextLine());			
			}

		for (Executable e : lesExec) { 
			try {
				e.executer();
			}
			catch (ASIAventureException exception){
				System.out.println("Exception : "+exception.getMessage());
			}
		}

		for (ConditionDeFin cdf : listeConditions) {
			System.out.println(cdf.verifierCondition());
			if (cdf.verifierCondition() != EtatDuJeu.ENCOURS) 
				return cdf.getEtatConditionVerifiee();
			}
		return EtatDuJeu.ENCOURS;
	}

	public EtatDuJeu executerJusquALaFin() throws Throwable{
		EtatDuJeu etat = EtatDuJeu.ENCOURS;
		while(!etat.equals(EtatDuJeu.ENCOURS)){
			etat=this.executerUnTour();
		}
		return etat;
	}

	public EtatDuJeu executerNbTours(int n) throws Throwable{
		for(int i=0;i<n-1;i++){
			this.executerUnTour();
		}
		return this.executerUnTour();
	}

	public void stopperJeu(){
		this.etatJeu = EtatDuJeu.ECHEC;
	}
}
