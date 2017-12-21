package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

/**
 * PorteInexistanteDansLaPieceException est la classe permettant de représenter les exceptions sur les portes inexistantes dans la pièce.
 *
 * @see PieceException
 *
 * @author Sandratra
 * @author Claire
*/

public class PorteInexistanteDansLaPieceException extends PieceException{

  /**
   * Constructeur PorteInexistanteDansLaPieceException.
  */
  public PorteInexistanteDansLaPieceException(){

  }

  /**
   * Constructeur PorteInexistanteDansLaPieceException.
   * Appelle le constructeur de PieceException avec un message
   *
   * @param msg le message envoyé
   *
   * @see PieceException
  */
  public PorteInexistanteDansLaPieceException(String msg){
    super(msg);
  }

  /**
   * Constructeur PorteInexistanteDansLaPieceException.
   * Appelle le constructeur de PieceException avec un message et une exception
   * Appelle le constructeur de PieceException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see PieceException
  */
  public PorteInexistanteDansLaPieceException(String msg, Throwable e){
    super(msg,e);
  }
}
