package fr.insarouen.asi.prog.asiaventure;

import java.lang.Exception;

/**
 * ASIAventureException est la classe permettant de représenter les exceptions d'ASI Aventure.
 *
 * @see Exception
 *
 * @author Sandratra
 * @author Claire
*/
public class ASIAventureException extends Exception {

  /**
   * Constructeur ASIAventureException.
  */
  public ASIAventureException(){
  }

  /**
   * Constructeur ASIAventureException.
   * Appelle le constructeur d'Exception avec un message
   *
   * @param msg le message envoyé
   *
   * @see Exception
  */
  public ASIAventureException(String msg){
    super(msg);
  }

  /**
   * Constructeur ASIAventureException.
   * Appelle le constructeur d'Exception avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see Exception
  */
  public ASIAventureException(String msg, Throwable e){
    super(msg,e);
  }
}
