package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;

/**
 * PieceException est la classe permettant de représenter les exceptions sur les pièces.
 *
 * @see ElementStructurelException
 *
 * @author Sandratra
 * @author Claire
*/
public class PieceException extends ElementStructurelException {

  /**
   * Constructeur PieceException.
  */
  public PieceException(){
  }

  /**
   * Constructeur PieceException.
   * Appelle le constructeur d'ElementStructurelException avec un message
   *
   * @param msg le message envoyé
   *
   * @see ElementStructurelException
  */
  public PieceException(String msg){
    super(msg);
  }

  /**
   * Constructeur PieceException.
   * Appelle le constructeur d'ElementStructurelException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see ElementStructurelException
  */
  public PieceException(String msg, Throwable e){
    super(msg,e);
  }
}
