package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.*;

/**
 * ConditionDeFinVivantPossedeObjets est la classe permettant de représenter la condition qu'un vivant possède des objets donnés
 * Une ConditionDeFinVivantPossedeObjets est une condition de fin.
 *
 * @author Sandratra
 * @author Claire
 *
 * @see ConditionDeFin
*/
public class ConditionDeFinVivantPossedeObjets extends ConditionDeFin {

  /**
  * Le vivant
  */
  private Vivant vivant;

  /**
  * Les objets
  */
  private Objet[] objets;

  /**
   * Constructeur ConditionDeFinVivantPossedeObjets.
   * Permet de créer la condition où le vivant possède des objets.
   *
   * @param etatDuJeu L'état du jeu
   * @param vivant Le vivant
   * @param objets Les objets
   *
   * @see EtatDuJeu
   * @see Vivant
   * @see Objet
  */
  public ConditionDeFinVivantPossedeObjets(EtatDuJeu etatConditionVerifiee,
                                            Vivant vivant,
                                            Objet[] objets){
    super(etatConditionVerifiee);
    this.vivant = vivant;
    this.objets = objets;
  }

  /**
   * Donne l'état du jeu actuel, après vérification de la condition de fin.
   *
   * @return L'état du jeu actuel.
   *
   *@ see EtatDuJeu
  */
  public EtatDuJeu verifierCondition(){
    boolean possedeLObjet = true;
    for(Objet i : objets){
      if(!(vivant.possede(i))){
        return EtatDuJeu.ENCOURS;
      }
    }
    return getEtatConditionVerifiee();
  }
}
