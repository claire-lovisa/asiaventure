package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;

/**
 * Entite est la classe permettant de représenter une entité.
 * Une entité possède un nom qui lui est donné et appartient à un monde.
 *
 * @author Sandratra
 * @author Claire
*/
public abstract class Entite {

  /**
   * Le nom de l'entite. Il est donné lors de la création d'une entite.
   *
   * @see Entite#getNom()
  */
  private String nom;

  /**
   * Le monde dans lequel est l'entite. Il est donné lors de la création
   * d'une entite.
   *
   * @see Entite#getMonde()
  */
  protected Monde monde;

  /**
   * Constructeur Entite.
   * A la création d'une entite, elle est représentée par un nom et un monde
   * donnés.
   * Quand une entite est creee, elle est automatiquement ajoutee au monde
   * correspondant.
   *
   * @param nom Le nom de l'objet
   * @param monde Le monde dans lequel est l'objet
   *
   * @see Monde
  */
  public Entite(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
    this.nom = nom;
    this.monde = monde;
    try {
      this.monde.ajouter(this);
    } catch (EntiteDejaDansUnAutreMondeException e) {

    }


  }

  /**
   * Donne le nom de l'objet.
   *
   * @return Le nom de l'objet.
  */
  public String getNom() {
    return this.nom;
  }

  /**
   * Donne le monde de l'objet.
   *
   * @return Le monde de l'objet.
   *
   *@ see Monde
  */
  public Monde getMonde() {
    return this.monde;
  }

  /**
   * Donne une représentation de l'objet en chaine de caractere.
   *
   * @return La chaine de caractere representant l'objet.
   *
   * @see Monde#getMonde
  */
  public String toString(){
		return(nom+" appartient au monde "+monde.getNom());
	}

  /**
   * Retourne l'égalite de deux entites.
   *
   * @return True si les entites sont egales, false sinon.
  */
  public boolean equals(Object o) {
    if(o.getClass() != this.getClass()) {
      return false;
    }

    Entite ent=(Entite)o;
    return((this.nom.equals(ent.getNom())) && (this.monde.equals(ent.getMonde())));

  }

  /**
   * Donne un nouveau hashcode pour une entite.
   *
   * @return Le hashcode de l'entite.
  */
  public int hashCode() {
    return(this.nom.hashCode()+this.monde.hashCode());
  }


}
