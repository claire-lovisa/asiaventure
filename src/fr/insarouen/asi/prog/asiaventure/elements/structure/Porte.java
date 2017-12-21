package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

/**
 * Porte est la classe permettant de représenter une porte.
 * Une porte possède un nom qui lui est donné et appartient à un monde.
 * Elle se trouve entre deux pièces. Elle peut avoir une Serrure?
 *
 * @author Sandratra
 * @author Claire
*/

public class Porte extends ElementStructurel implements Activable{

    /**
     * La pièce A.
     *
     * @see Piece
    */
  private Piece pieceA;
    /**
     * La pièce B.
     *
     * @see Piece
    */
  private Piece pieceB;
  /**
   * La serrure.
   *
   * @see Serrure
  */
  private Serrure serrure;
  /**
   * L'état de la porte.
   *
   * @see Etat
  */
  private Etat etat;

  /**
   * Constructeur Porte.
   * A la création d'une porte, elle est représentée par un nom , deux pièces et un monde donnés.
   * Elle n'a pas encore de serrure
   *
   * @param nom Le nom de la porte
   * @param monde Le monde dans lequel est la porte
   * @param pieceA La pièce A
   * @param pieceB La pièce B
   *
   * @see Monde
  */
  public Porte(String nom,Monde monde, Piece pieceA, Piece pieceB)
  throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.pieceA = pieceA;
    this.pieceB = pieceB;
    pieceA.addPorte(this);
		pieceB.addPorte(this);
    this.etat = Etat.OUVERT;
    this.serrure= null;
  }

  /**
   * Constructeur Porte.
   * A la création d'une porte, elle est représentée par un nom , deux pièces et un monde donnés.
   * Elle a une serrure
   *
   * @param nom Le nom de la porte
   * @param monde Le monde dans lequel est la porte
   * @param pieceA La pièce A
   * @param pieceB La pièce B
   * @param serrure La serrure
   *
   * @see Monde
  */
  public Porte(String nom,Monde monde,Serrure serrure, Piece pieceA, Piece pieceB)
  throws NomDEntiteDejaUtiliseDansLeMondeException{
    this(nom,monde,pieceA,pieceB);
    this.serrure = serrure;
  }

  /**
   * Permet de savoir si la porte est activable avec un objet.
   *
   * @param obj L'objet utilisé
   *
   * @return Vrai si la porte est activable avec cet objet.
   *
   * @see Activable
  */
  public boolean activableAvec(Objet obj) {
    return true;
  }

  /**
   * Permet d'activer une porte.
   *
   * @return Vrai si la porte est activable avec cet objet.
   *
   * @see Activable
  */
  public void activer() throws ActivationImpossibleException{

  }

  /**
   * Permet d'activer une porte avec un objet.
   *
   * @param obj L'objet utilisé
   *
   * @return Vrai si la porte est activable avec cet objet.
   *
   * @see Activable
  */
  public void activerAvec(Objet obj)throws ActivationImpossibleAvecObjetException,
  ActivationImpossibleException {

  }

  /**
   * Permet daller dans l'autre pièce.
   *
   * @param piece La pièce courante
   *
   * @return Vrai si la porte est activable avec cet objet.
   *
   * @see Activable
  */
  public Piece getPieceAutreCote(Piece piece){
    if (piece.equals(pieceA)){
      return pieceB;
    }
    else if (piece.equals(pieceB)){
      return pieceA;
    }
    else {
      return null;
    }
  }

  /**
   * retourne l'état de la porte.
   *
   *
   * @return etat
   *
   * @see Etat
  */
  public Etat getEtat(){
    return this.etat;
  }

  /**
   * retourne la serrure de la porte.
   *
   *
   * @return serrure
   *
   * @see Serrure
  */
  public Serrure getSerrure() {
  	return this.serrure;
  }

  /**
	 * Permet de décrire la porte de manière textuelle
	 * @return Chaîne de caractères décrivant la porte
	 * */
	 public String toString() {
		StringBuilder res = new StringBuilder("porte " + super.toString()+ " :\n");
		res.append(" Etat de la porte : "+ etat +"\n");
		res.append("entre les pieces "+ pieceA + " et " + pieceB + "\n");
		return res.toString();

	}
}
