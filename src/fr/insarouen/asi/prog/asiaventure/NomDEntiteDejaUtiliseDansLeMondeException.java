package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.MondeException;

/**
 * NomDEntiteDejaUtiliseDansLeMondeException est la classe permettant de représenter les exceptions sur les entités dont le nom a déjà été utilisé.
 *
 * @see MondeException
 *
 * @author Sandratra
 * @author Claire
*/
public class NomDEntiteDejaUtiliseDansLeMondeException extends MondeException {

  /**
   * Constructeur NomDEntiteDejaUtiliseDansLeMondeException.
  */
  public NomDEntiteDejaUtiliseDansLeMondeException(){
  }

  /**
   * Constructeur NomDEntiteDejaUtiliseDansLeMondeException.
   * Appelle le constructeur de MondeException avec un message
   *
   * @param msg le message envoyé
   *
   * @see MondeException
  */
  public NomDEntiteDejaUtiliseDansLeMondeException(String msg){
    super(msg);
  }

  /**
   * Constructeur NomDEntiteDejaUtiliseDansLeMondeException.
   * Appelle le constructeur de MondeException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see MondeException
  */
  public NomDEntiteDejaUtiliseDansLeMondeException(String msg, Throwable e){
    super(msg,e);
  }
}
