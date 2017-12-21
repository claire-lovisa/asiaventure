package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

/**
 * VivantAbsentDeLaPieceException est la classe permettant de représenter les exceptions sur les vivants absents de la pièce.
 *
 * @see PieceException
 *
 * @author Sandratra
 * @author Claire
*/
public class VivantAbsentDeLaPieceException extends PieceException {

  /**
   * Constructeur VivantAbsentDeLaPieceException.
  */
  public VivantAbsentDeLaPieceException(){
  }

  /**
   * Constructeur VivantAbsentDeLaPieceException.
   * Appelle le constructeur de PieceException avec un message
   *
   * @param msg le message envoyé
   *
   * @see PieceException
  */
  public VivantAbsentDeLaPieceException(String msg){
    super(msg);
  }

  /**
   * Constructeur VivantAbsentDeLaPieceException.
   * Appelle le constructeur de PieceException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see PieceException
  */
  public VivantAbsentDeLaPieceException(String msg, Throwable e){
    super(msg,e);
  }
}
