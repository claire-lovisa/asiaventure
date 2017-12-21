package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;

/**
 * PorteFermeException est la classe permettant de représenter les exceptions sur les portes fermés.
 *
 * @see ElementStructurelException
 *
 * @author Sandratra
 * @author Claire
*/

public class PorteFermeException extends ElementStructurelException{

  /**
   * Constructeur PorteFermeException.
  */
  public PorteFermeException(){

  }


  /**
   * Constructeur PorteFermeException.
   * Appelle le constructeur de ElementStructurelException avec un message
   *
   * @param msg le message envoyé
   *
   * @see ElementStructurelException
  */
  public PorteFermeException(String msg){
    super(msg);
  }

  /**
   * Constructeur PorteFermeException.
   * Appelle le constructeur de ElementStructurelException avec un message
   *
   * @param msg le message envoyé
   * @param e l'exception envoyée
   *
   * @see ElementStructurelException
  */
  public PorteFermeException(String msg, Throwable e){
    super(msg,e);
  }

}
