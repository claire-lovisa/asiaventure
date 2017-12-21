package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;

/**
 * ActivationException est la classe permettant de représenter les exceptions sur les activations.
 *
 * @see ASIAventureException
 *
 * @author Sandratra
 * @author Claire
*/
public class ActivationImpossibleAvecObjetException extends ActivationImpossibleException {

  /**
   * Constructeur ActivationImpossibleAvecObjetException.
  */
  public ActivationImpossibleAvecObjetException(){
  }

  /**
   * Constructeur ActivationImpossibleAvecObjetException.
   * Appelle le constructeur d'ActivationImpossibleException avec un message
   *
   * @param msg le message envoyé
   *
   * @see ActivationImpossibleException
  */
  public ActivationImpossibleAvecObjetException(String msg){
    super(msg);
  }

  /**
   * Constructeur ActivationImpossibleAvecObjetException.
   * Appelle le constructeur d'ActivationImpossibleException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see ActivationImpossibleException
  */
  public ActivationImpossibleAvecObjetException(String msg, Throwable e){
    super(msg,e);
  }
}
