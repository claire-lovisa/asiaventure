package fr.insarouen.asi.prog.asiaventure;

import java.io.*;
import java.util.Scanner;
import fr.insarouen.asi.prog.asiaventure.*;

public class Main {

	public static void main(String[] args) throws Throwable {
		boolean quitter = false;
		Simulateur simulateur = null;
		System.out.println("---------------------------------");
		System.out.println("-------  ASI-AVENTURE  ----------");
		System.out.println("---------------------------------");
		while (!quitter) {

			System.out.println();
			System.out.println("----------  Menu  ---------------");
			System.out.println();
			System.out.println("1/ Jouer");
			System.out.println("2/ Charger un fichier de description");
			System.out.println("3/ Sauver la partie actuelle");
			System.out.println("4/ Charger une partie");
			System.out.println("5/ Quitter");
			System.out.println();
			Scanner sc = new Scanner(System.in);
			String nomFichier;
			int i = sc.nextInt();
			switch (i) {
				case 1 :
					int choix;
					if(simulateur == null){
						System.out.println("Chargez un fichier de desciption");
					}
					else {
						do{
						simulateur.executerUnTour();
						System.out.println("Voulez vous rejouer ? (0 pour non, 1 pour oui)");
						Scanner rejouer = new Scanner(System.in);
						choix = rejouer.nextInt(); }
						while(choix == 1);
					}
					break;

				case 2 :
					sc.nextLine();
					System.out.println("Nom du fichier à lire : ");
					nomFichier = sc.nextLine();
					Reader reader = new FileReader(nomFichier);
					simulateur = new Simulateur(reader);
					break;

				case 3 :
					sc.nextLine();
					System.out.println("Nom du fichier de sauvegarde : ");
					nomFichier = sc.nextLine();
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier));
					simulateur.enregistrer(oos);
					break;

				case 4 :
					sc.nextLine();
					System.out.println("Nom du fichier à lire : ");
					nomFichier = sc.nextLine();
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier));
					simulateur = new Simulateur(ois);
					break;

				case 5 :
					quitter = true;
					break;
			}
		}
	}
}
