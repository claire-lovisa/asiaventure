package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;

/**
 * Coffre est la classe permettant de représenter un coffre.
 * A chaque coffre est associé un état.
 *
 * @author Sandratra
 * @author Claire
 *
 *@see Objet
 *@see Activable
*/
public class Coffre extends Objet implements Activable{

  /**
   * L'état du coffre
   *
   * @see Etat
  */
private Etat etat;

/**
 * Constructeur Coffre.
 * Permet de créer un coffre. Il est initialement fermé.
 *
 * @param nom Le nom du coffre
 * @param monde Le monde dans lequel est le coffre
 *
 * @see Monde
*/
  public Coffre(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.etat=etat.FERME;
  }

  /**
   * Dit si le coffre est activable ou non avec cet objet
   *
   * @param obj L'objet servant à activer le coffre
   *
   * @return Oui si le coffre est activable avec cet objet, non sinon
  */
  public boolean activableAvec(Objet obj){
    if (obj instanceof PiedDeBiche){
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * Active le coffre sans objet
  */
  public void activer(){
    if (this.etat == etat.FERME){
      this.etat = etat.OUVERT;
    }
    else if (this.etat == etat.OUVERT){
      this.etat = etat.OUVERT;
    }
  }

  /**
   * Active le coffre si l'objet est valide
   *
   * @param obj L'objet servant à activer le coffre
  */
  public void activerAvec(Objet obj)throws ActivationException{
    if (activableAvec(obj)){
      if (this.etat == etat.FERME) {
        this.etat = etat.CASSE;
      }
    } else {
      throw new ActivationException("Pas activable laisse moi tranquille aventurier de pacotille !");
    }

  }

  /**
   * Permet de définir si le coffre est déplacable ou non
   *
   * @return Non car le coffre n'est pas déplacable
  */
  public boolean estDeplacable(){
    return false;
  }

  /**
   * Permet de connaitre l'état du coffre
   *
   * @return L'état du coffre
  */
  public Etat getEtat(){
    return etat;
  }

  /**
   * Donne une représentation du coffre en chaine de caractere.
   *
   * @return La chaine de caractere representant le coffre.
  */
  public String toString() {
		return "Le Coffre "+getNom()+" est "+getEtat();
	}

}
