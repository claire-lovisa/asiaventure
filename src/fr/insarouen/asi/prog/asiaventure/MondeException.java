package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

/**
 * MondeException est la classe permettant de représenter les exceptions sur les mondes.
 *
 * @see ASIAventureException
 *
 * @author Sandratra
 * @author Claire
*/
public class MondeException extends ASIAventureException {

  /**
   * Constructeur MondeException.
  */
  public MondeException(){
  }

  /**
   * Constructeur MondeException.
   * Appelle le constructeur d'ASIAventureException avec un message
   *
   * @param msg le message envoyé
   *
   * @see ASIAventureException
  */
  public MondeException(String msg){
    super(msg);
  }

  /**
   * Constructeur MondeException.
   * Appelle le constructeur d'ASIAventureException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see ASIAventureException
  */
  public MondeException(String msg, Throwable e){
    super(msg,e);
  }
}
