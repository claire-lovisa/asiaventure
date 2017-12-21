package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.MondeException;

/**
 * EntiteDejaDansUnAutreMondeException est la classe permettant de représenter les exceptions sur les entités déjà présentes dans d'autres mondes.
 *
 * @see MondeException
 *
 * @author Sandratra
 * @author Claire
*/
public class EntiteDejaDansUnAutreMondeException extends MondeException {

  /**
   * Constructeur EntiteDejaDansUnAutreMondeException.
  */
  public EntiteDejaDansUnAutreMondeException(){
  }

  /**
   * Constructeur EntiteDejaDansUnAutreMondeException.
   * Appelle le constructeur de MondeException avec un message
   *
   * @param msg le message envoyé
   *
   * @see MondeException
  */
  public EntiteDejaDansUnAutreMondeException(String msg){
    super(msg);
  }

  /**
   * Constructeur EntiteDejaDansUnAutreMondeException.
   * Appelle le constructeur de MondeException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see MondeException
  */
  public EntiteDejaDansUnAutreMondeException(String msg, Throwable e){
    super(msg,e);
  }
}
