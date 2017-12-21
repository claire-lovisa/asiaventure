package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;

/**
 * ActivationException est la classe permettant de représenter les exceptions sur les activations.
 *
 * @see ASIAventureException
 *
 * @author Sandratra
 * @author Claire
*/
public class ActivationImpossibleException extends ActivationException {

  /**
   * Constructeur ActivationImpossibleException.
  */
  public ActivationImpossibleException(){
  }

  /**
   * Constructeur ActivationImpossibleException.
   * Appelle le constructeur d'ActivationException avec un message
   *
   * @param msg le message envoyé
   *
   * @see ActivationException
  */
  public ActivationImpossibleException(String msg){
    super(msg);
  }

  /**
   * Constructeur ActivationImpossibleException.
   * Appelle le constructeur d'ActivationException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see ActivationException
  */
  public ActivationImpossibleException(String msg, Throwable e){
    super(msg,e);
  }
}
