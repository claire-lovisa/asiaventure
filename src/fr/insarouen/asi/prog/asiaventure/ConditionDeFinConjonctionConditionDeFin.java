package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFin;
import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.*;

/**
 * ConditionDeFinConjonctionConditionDeFin est la classe permettant de représenter une conjonction de conditions de fin de partie.
 * Une ConditionDeFinConjonctionConditionDeFin est une condition de fin.
 *
 * @author Sandratra
 * @author Claire
 *
 * @see ConditionDeFin
*/
public class ConditionDeFinConjonctionConditionDeFin extends ConditionDeFin {

  /**
  * Les conditions à conjectionner
  */
  private ConditionDeFin[] cfs;

  /**
   * Constructeur ConditionDeFinConjonctionConditionDeFin.
   * Permet de créer une conjonction de conditions de fin.
   *
   * @param etatDuJeu L'état du jeu
   * @param cfs Les conditions à conjectionner
   *
   * @see EtatDuJeu
   * @see ConditionDeFin
  */
  public ConditionDeFinConjonctionConditionDeFin(EtatDuJeu etatDuJeu,
                                         ConditionDeFin... cfs) {
    super(etatDuJeu);
    this.cfs = cfs;
  }

  /**
   * Donne l'état du jeu actuel, après vérification de la condition de fin.
   *
   * @return L'état du jeu actuel.
   *
   *@ see EtatDuJeu
  */
  public EtatDuJeu verifierCondition() {
    boolean estEnCours, aEchoue;
    estEnCours = false;
    aEchoue = false;
    for(ConditionDeFin i : cfs){
      if(i.getEtatConditionVerifiee().equals(EtatDuJeu.ENCOURS)){
        return EtatDuJeu.ENCOURS;
      }
    }
    return getEtatConditionVerifiee();
  }

}
