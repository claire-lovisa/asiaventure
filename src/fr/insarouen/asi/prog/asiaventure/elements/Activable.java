package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;

/**
 * Activable est l'interface permettant de dire si un objet est activable, et avec quoi.
 *
 * @author Sandratra
 * @author Claire
*/
public interface Activable {

  /**
   * Dit si un objet est actiable en fonction de l'objet utilisé
   *
   * @param obj L'objet
   * @return Oui si l'objet est activable avec l'objet, non sinon
   *
   * @see Monde
  */
  boolean activableAvec(Objet obj);

  /**
   * Active quelque chose
   *
   * @see Monde
  */
  void activer() throws ActivationException;

  /**
   * Active queklque chose avec un objet
   *
   * @param obj L'objet pour activer
   *
   * @see Monde
  */
  void activerAvec(Objet obj) throws ActivationException;
}
