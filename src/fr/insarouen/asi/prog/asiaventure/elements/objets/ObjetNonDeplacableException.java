package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetException;

/**
 * ObjetNonDeplacableException est la classe permettant de représenter les exceptions sur les objets non déplaçables.
 *
 * @see ObjetException
 *
 * @author Sandratra
 * @author Claire
*/
public class ObjetNonDeplacableException extends ObjetException {

  /**
   * Constructeur ObjetNonDeplacableException.
  */
  public ObjetNonDeplacableException(){
  }

  /**
   * Constructeur ObjetNonDeplacableException.
   * Appelle le constructeur d'ObjetException avec un message
   *
   * @param msg le message envoyé
   *
   * @see ObjetException
  */
  public ObjetNonDeplacableException(String msg){
    super(msg);
  }

  /**
   * Constructeur ObjetNonDeplacableException.
   * Appelle le constructeur d'ObjetException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see ObjetException
  */
  public ObjetNonDeplacableException(String msg, Throwable e){
    super(msg,e);
  }
}
