package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * Objet est la classe permettant de représenter un objet, qui est une entité.
 *
 * @see Entite
 *
 * @author Sandratra
 * @author Claire
*/
public abstract class Objet extends Entite {

  /**
   * Constructeur Objet.
   * A la création d'un objet, il est représenté par un nom et un monde donnés.
   *
   * @param nom Le nom de l'objet
   * @param monde Le monde dans lequel est l'objet
   *
   * @see Monde
  */

  public Objet(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom, monde);
  }

  /**
   * Indique si l'objet est deplacable.
   * Par défaut, un objet n'est pas deplacable.
   *
   * @return True si l'objet est deplacable, false sinon.
  */
  public abstract boolean estDeplacable(); /*{
    return false;
  }*/

}
