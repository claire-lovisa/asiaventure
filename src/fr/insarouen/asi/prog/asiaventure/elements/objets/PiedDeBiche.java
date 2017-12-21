package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
/**
 * PiedDeBiche est la classe permettant de représenter un pied de biche,
 * qui est un objet.
 *
 * @see Objet
 *
 * @author Sandratra
 * @author Claire
*/
public class PiedDeBiche extends Objet {

  /**
   * Constructeur PiedDeBiche.
   * A la création d'un pied de biche, il est représenté par un nom et un
   * monde donnés.
   *
   * @param nom Le nom du pied de biche
   * @param monde Le monde dans lequel est le pied de biche
   *
   * @see Monde
  */
  public PiedDeBiche(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
    super(nom, monde);
  }

  /**
   * Indique si le pied de biche est deplacable.
   * Par défaut, un pied de biche est deplacable.
   *
   * @return True car un pied de biche est deplacable.
  */
  public boolean estDeplacable() {
    return true;
  }

}
