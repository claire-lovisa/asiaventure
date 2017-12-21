package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

/**
 * ActivationException est la classe permettant de représenter les exceptions sur les activations.
 *
 * @see ASIAventureException
 *
 * @author Sandratra
 * @author Claire
*/
public class ActivationException extends ASIAventureException {

  /**
   * Constructeur ActivationException.
  */
  public ActivationException(){
  }

  /**
   * Constructeur ActivationException.
   * Appelle le constructeur d'ASIAventureException avec un message
   *
   * @param msg le message envoyé
   *
   * @see ASIAventureException
  */
  public ActivationException(String msg){
    super(msg);
  }

  /**
   * Constructeur ActivationException.
   * Appelle le constructeur d'ASIAventureException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see ASIAventureException
  */
  public ActivationException(String msg, Throwable e){
    super(msg,e);
  }
}
