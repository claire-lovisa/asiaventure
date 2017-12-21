package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

/**
 * ObjetException est la classe permettant de représenter les exceptions sur les objets.
 *
 * @see ASIAventureException
 *
 * @author Sandratra
 * @author Claire
*/
public class ObjetException extends ASIAventureException {

  /**
   * Constructeur ObjetException.
  */
  public ObjetException(){
  }

  /**
   * Constructeur ObjetException.
   * Appelle le constructeur d'ASIAventureException avec un message
   *
   * @param msg le message envoyé
   *
   * @see ASIAventureException
  */
  public ObjetException(String msg){
    super(msg);
  }

  /**
   * Constructeur ObjetException.
   * Appelle le constructeur d'ASIAventureException avec un message et une exception
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see ASIAventureException
  */
  public ObjetException(String msg, Throwable e){
    super(msg,e);
  }
}
