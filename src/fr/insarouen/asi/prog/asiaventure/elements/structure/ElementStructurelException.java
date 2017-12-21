package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

/**
 * ElementStructurelException est la classe permettant de représenter les exceptions sur les éléments structurels.
 *
 * @see ASIAventureException
 *
 * @author Sandratra
 * @author Claire
*/
public class ElementStructurelException extends ASIAventureException {

  /**
   * Constructeur ElementStructurelException.
  */
  public ElementStructurelException(){
  }

  /**
   * Constructeur ElementStructurelException.
   * Appelle le constructeur d'ASIAventureException avec un message
   *
   * @param msg le message envoyé
   *
   * @see ASIAventureException
  */
  public ElementStructurelException(String msg){
    super(msg);
  }

  /**
   * Constructeur ElementStructurelException.
   * Appelle le constructeur d'ASIAventureException avec un message et une exception
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see ASIAventureException
  */
  public ElementStructurelException(String msg, Throwable e){
    super(msg,e);
  }
}
