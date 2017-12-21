package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

/**
 * VivantException est la classe permettant de représenter les exceptions sur les vivants.
 *
 * @see ASIAventureException
 *
 * @author Sandratra
 * @author Claire
*/
public class VivantException extends ASIAventureException {

  /**
   * Constructeur VivantException.
  */
  public VivantException(){
  }

  /**
   * Constructeur VivantException.
   * Appelle le constructeur d'ASIAventureException avec un message
   *
   * @param msg le message envoyé
   *
   * @see ASIAventureException
  */
  public VivantException(String msg){
    super(msg);
  }

  /**
   * Constructeur VivantException.
   * Appelle le constructeur d'ASIAventureException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see ASIAventureException
  */
  public VivantException(String msg, Throwable e){
    super(msg,e);
  }
}
