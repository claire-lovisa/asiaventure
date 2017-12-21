package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
/**
 * ElementStructurel est la classe permettant de représenter un element
 * structurel, qui est une entite.
 *
 * @see Entite
 *
 * @author Sandratra
 * @author Claire
*/
public abstract class ElementStructurel extends Entite {

  /**
   * Constructeur ElementStructurel.
   * A la création d'un element structurel, il est représenté par un nom et un
   * monde donnés.
   *
   * @param nom Le nom de l'element structurel
   * @param monde Le monde dans lequel est l'element structurel
   *
   * @see Monde
  */
  public ElementStructurel(String nom, Monde monde)
    throws NomDEntiteDejaUtiliseDansLeMondeException {
    super(nom, monde);
  }
}
