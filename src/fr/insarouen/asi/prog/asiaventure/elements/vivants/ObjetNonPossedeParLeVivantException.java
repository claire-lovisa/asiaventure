package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.VivantException;

/**
 * ObjetNonPossedeParLeVivantException est la classe permettant de représenter les exceptions sur les objets non possédés par un vivant.
 *
 * @see VivantException
 *
 * @author Sandratra
 * @author Claire
*/
public class ObjetNonPossedeParLeVivantException extends VivantException {

  /**
   * Constructeur ObjetNonPossedeParLeVivantException.
  */
  public ObjetNonPossedeParLeVivantException(){
  }

  /**
   * Constructeur ObjetNonPossedeParLeVivantException.
   * Appelle le constructeur de VivantException avec un message
   *
   * @param msg le message envoyé
   *
   * @see VivantException
  */
  public ObjetNonPossedeParLeVivantException(String msg){
    super(msg);
  }

  /**
   * Constructeur ObjetNonPossedeParLeVivantException.
   * Appelle le constructeur de VivantException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see VivantException
  */
  public ObjetNonPossedeParLeVivantException(String msg, Throwable e){
    super(msg,e);
  }
}
