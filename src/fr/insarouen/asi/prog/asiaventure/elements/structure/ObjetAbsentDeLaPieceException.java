package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

/**
 * ObjetAbsentDeLaPieceException est la classe permettant de représenter les exceptions sur les objets absents de la pièce.
 *
 * @see PieceException
 *
 * @author Sandratra
 * @author Claire
*/
public class ObjetAbsentDeLaPieceException extends PieceException {

  /**
   * Constructeur ObjetAbsentDeLaPieceException.
  */
  public ObjetAbsentDeLaPieceException(){
  }

  /**
   * Constructeur ObjetAbsentDeLaPieceException.
   * Appelle le constructeur de PieceException avec un message
   *
   * @param msg le message envoyé
   *
   * @see PieceException
  */
  public ObjetAbsentDeLaPieceException(String msg){
    super(msg);
  }

  /**
   * Constructeur ObjetAbsentDeLaPieceException.
   * Appelle le constructeur de PieceException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see PieceException
  */
  public ObjetAbsentDeLaPieceException(String msg, Throwable e){
    super(msg,e);
  }
}
