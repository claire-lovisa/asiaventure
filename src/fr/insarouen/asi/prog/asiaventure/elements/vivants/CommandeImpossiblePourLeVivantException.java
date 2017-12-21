package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.VivantException;

/**
 * CommandeImpossiblePourLeVivantException est la classe permettant de représenter les exceptions sur les commandes non réalisables par un vivant.
 *
 * @see VivantException
 *
 * @author Sandratra
 * @author Claire
*/
public class CommandeImpossiblePourLeVivantException extends VivantException {

  /**
   * Constructeur CommandeImpossiblePourLeVivantException.
  */
  public CommandeImpossiblePourLeVivantException(){
  }

  /**
   * Constructeur CommandeImpossiblePourLeVivantException.
   * Appelle le constructeur de VivantException avec un message
   *
   * @param msg le message envoyé
   *
   * @see VivantException
  */
  public CommandeImpossiblePourLeVivantException(String msg){
    super(msg);
  }

  /**
   * Constructeur CommandeImpossiblePourLeVivantException.
   * Appelle le constructeur de VivantException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see VivantException
  */
  public CommandeImpossiblePourLeVivantException(String msg, Throwable e){
    super(msg,e);
  }
}
