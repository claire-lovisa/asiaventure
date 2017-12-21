package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * Clef est la classe permettant de représenter une clef.
 * Une clef n'ouvre qu'une serrure dans le monde.
 *
 * @author Sandratra
 * @author Claire
 *
 *@see Objet
*/
public final class Clef extends Objet {

  /**
   * Constructeur Clef.
   * Permet de créer une clef associée à une serrure quand une serrure est créée
   *
   * @param nom Le nom de la clef
   * @param monde Le monde dans lequel est la clef
   *
   * @see Monde
  */
  protected Clef(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
  }

  /**
   * Permet de définir si la clef est déplacable ou non
   *
   * @return Oui car la clef est déplacable
  */
  public boolean estDeplacable() {
    return true;
  }

  /**
   * Donne une représentation de la clef en chaine de caractere.
   *
   * @return La chaine de caractere representant la clef.
  */
  public String ToString() {
    StringBuilder s = new StringBuilder("");
    s.append(super.getNom());
    return s.toString();
  }

}
