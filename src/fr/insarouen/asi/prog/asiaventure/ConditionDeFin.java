package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;


/**
 * ConditionDeFin est la classe permettant de représenter une condition de fin de partie.
 * Une ConditionDeFin est un objet.
 *
 * @author Sandratra
 * @author Claire
 *
 * @see java.lang.Object
 * @see java.io.Serializable
*/
public abstract class ConditionDeFin extends java.lang.Object implements java.io.Serializable {

  /**
  * L'état du jeu.
  */
  private EtatDuJeu etatDuJeu;

  /**
   * Constructeur ConditionDeFin.
   * Permet de créer une condition de fin.
   *
   * @param etatDuJeu L'état du jeu
   *
   * @see EtatDuJeu
  */
  public ConditionDeFin(EtatDuJeu etatDuJeu) {
    this.etatDuJeu = etatDuJeu;
  }

  /**
   * Donne l'état du jeu si la condition est vérifiée.
   *
   * @return L'état du jeu.
   *
   *@ see EtatDuJeu
  */
  public EtatDuJeu getEtatConditionVerifiee() {
    return this.etatDuJeu;
  }

  /**
   * Donne l'état du jeu actuel, après vérification de la condition de fin.
   *
   * @return L'état du jeu actuel.
   *
   *@ see EtatDuJeu
  */
  public abstract EtatDuJeu verifierCondition();

}
