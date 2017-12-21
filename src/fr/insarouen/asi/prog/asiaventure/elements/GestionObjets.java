package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import java.util.Arrays;

/**
 * GestionObjets est la classe permettant de gerer un ensemble d'objets.
 *
 * <p>
 * GestionObjets est caracterise par un ensemble d'objets.
 * </p>
 * @see Objet
 * @see Vivant
 * @see Piece
 *
 * @author Sandratra
 * @author Claire
*/

public class GestionObjets {

  /**
  * L'ensemble des objets
  *
  * @see GestionObjets#getObjets()
  * @see GestionObjets#contientObjet(String nomObj)
  * @see GestionObjets#deposer(Objet obj)
  * @see GestionObjets#retirer(String nomObj)
  */

  private Objet[] objets;


  public GestionObjets(Objet[] objets) {
    this.objets=objets;
  }

  /**
  * Retourne l'ensemble des objets
  *
  * @return les objets
  *
  * @see Objet
  */
  public Objet[] getObjets() {
    return this.objets;
  }

  /**
  * Retourne vrai si le vivant possede un objet. Faux sinon
  *
  * @param nomObj
  * @return un booleen
  */

  public boolean contientObjet(String nomObj) {
    for(int i=0;i<this.objets.length;i++) {
      if(nomObj == this.objets[i].getNom()) {
        return true;
      }
    }
    return false;
  }

  /**
  * permet d'ajouter un objet à l'ensemble des objets
  *
  * @param nomObj
  */

  public Objet[] deposer(Objet obj) {
    Objet[] tabObjets = new Objet[this.objets.length+1];
    tabObjets = Arrays.copyOf(this.objets, this.objets.length+1);
    tabObjets[this.objets.length] = obj;
    return tabObjets;
  }

  /**
  * permet de retirer un objet à l'ensemble des objets
  *
  * @param nomObj
  */

  public Objet[] retirer(String nomObj){
    int decalage = 0;
    Objet obj = null;
    if (contientObjet(nomObj)) {
      Objet[] temp = new Objet[this.objets.length-1];
      for (int i=0;i<this.objets.length;i++) {
        if(!(nomObj.equals(this.objets[i].getNom()))) {
          temp[i-decalage] = this.objets[i];
        }
        else {
          obj=this.objets[i];
          decalage=decalage+1;
        }
      }
      this.objets = temp;
      return this.objets;
    }
    else {
        return this.objets;
    }
  }

  public Objet getObjet(String nomObj) {
    Objet o=null;
    for (int i=0;i<this.objets.length;i++) {
      if(this.objets[i].getNom().equals(nomObj)) {
        o=this.objets[i];
      }
    }
    return o;
  }
}
