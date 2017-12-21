package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;

public class PieceMainTest {
  public static void main(String[] args){

    try {
      String nomPiece = "Pioulpe";
      Monde monde = new Monde("Le monde des Pieces");
      Piece piece = new Piece(nomPiece,monde);
      Objet objet = new Objet("Tyran des bisounours",monde) {
        public boolean estDeplacable(){
          return false;
        }
      };
      PiedDeBiche pdb = new PiedDeBiche("PiedFromager",monde);
      System.out.println("\nTests sur les objets \n \nLa pièce contient l'objet avant l'avoir mis : "+piece.contientObjet(objet));
      piece.deposer(objet);
      System.out.println("\nLa pièce contient l'objet après l'avoir mis : "+piece.contientObjet(objet)+"\n");
      piece.deposer(pdb);
      System.out.println(piece.retirer(pdb)+"\n"+"La pièce contient le pied de biche après l'avoir retiré : "+piece.contientObjet(pdb));
      System.out.println("Tentative de retirer l'objet de la pièce :");
      objet=piece.retirer(objet);
    }
    catch (NomDEntiteDejaUtiliseDansLeMondeException e) {
			System.out.println("Exception : "+ e.getMessage());
		}
    catch (ObjetAbsentDeLaPieceException e) {
  		System.out.println("Exception : " +e.getMessage());
  	}
    catch (ObjetNonDeplacableException e) {
  		System.out.println("Exception : "+ e.getMessage());
  	}



    try {
      System.out.println("\nTests sur les vivants \n \n");

      String nomVivant = "Grenouille";
      String nomPiece2 = "Mare aux canards";
      Monde monde2 = new Monde("Le monde des Vivants");
      Piece piece2 = new Piece(nomPiece2,monde2);
      int pointVie=10, pointForce=100;
      Objet[] objets = new Objet[0];
      Vivant vivant = new Vivant(nomVivant,monde2,pointVie,pointForce,piece2,objets){};

      System.out.println("La piece contient un vivant avant qu'il soit entré : "+piece2.contientVivant(vivant));
      piece2.entrer(vivant);
      System.out.println("La piece contient un vivant après qu'il soit entré : "+piece2.contientVivant(vivant));
      System.out.println(piece2.toString());
      piece2.sortir(vivant);
      System.out.println("La piece contient un vivant après qu'il soit sorti : "+piece2.contientVivant(vivant));
      System.out.println(piece2.toString());
      System.out.println("Tentative de retrait d'un vivant absent d'une pièce :");
      piece2.sortir(vivant);
    }
    catch (NomDEntiteDejaUtiliseDansLeMondeException e) {
			System.out.println("Exception : "+ e.getMessage());
		}
    catch (VivantAbsentDeLaPieceException e) {
			System.out.println("Exception : "+ e.getMessage());
		}
  }
}
