package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.GestionObjets;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;

public class VivantMainTest {
  public static void main(String[] args) throws Exception {

  try {
    String nomVivant = "Grenouille";
    String nomVivant2 = "Papillon";
    String nomPiece = "Mare aux canards";
    Monde monde = new Monde("Le monde des Vivants");
    Piece piece = new Piece(nomPiece,monde);
    int pointVie=10, pointForce=100;
    Objet[] objets = new Objet[0];
    Vivant vivant = new Vivant(nomVivant,monde,pointVie,pointForce,piece,objets){};

    System.out.println(vivant.toString());
    Objet objet = new Objet("porte feuille en peau de serpent",monde) {
      public boolean estDeplacable(){
        return true;
      }
    };
    piece.deposer(objet);
    System.out.println("Le vivant possede l'objet avant l'avoir pris : "+vivant.possede(objet)+"\n");
    vivant.prendre(objet);
    System.out.println("Le vivant possede l'objet après l'avoir pris : "+vivant.possede(objet)+"\n");
    vivant.deposer(objet);
    System.out.println("Le vivant possede l'objet après l'avoir posé : "+vivant.possede(objet)+"\n");

    int pointVie2=0;
    Vivant vivant2 = new Vivant(nomVivant2,monde,pointVie2,pointForce,piece,objets){};
    System.out.println("Un vivant à 0 points de vie est mort : "+vivant2.estMort());

    Objet objet2 = new Objet("baguette magique",monde) {
      public boolean estDeplacable(){
        return true;
      }
    };

    System.out.println("\nPrendre un objet absent de la pièce : ");
    vivant2.prendre(objet2);

    		}
		catch (NomDEntiteDejaUtiliseDansLeMondeException e) {
			System.out.println("Exception : "+ e.getMessage());
		}
		catch (ObjetAbsentDeLaPieceException e) {
			System.out.println("Exception : "+ e.getMessage());
		}
		catch (ObjetNonDeplacableException e) {
			System.out.println("Exception : "+ e.getMessage());
		}
		catch (ObjetNonPossedeParLeVivantException e) {
			System.out.println("Exception : "+ e.getMessage());
		}
  }
}
