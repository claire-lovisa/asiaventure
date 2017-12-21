package fr.insarouen.asi.prog.asiaventure;

import java.io.*;
import java.util.*;
import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.*;

/**
 * ConditionDeFinVivantDansPieceEtPossedeObjets est la classe permettant de représenter la condition d'un vivant qui est dans une pièce donnée et qui possède des objets donnés
 * Une ConditionDeFinVivantDansPieceEtPossedeObjets est une condition de fin.
 *
 * @author Sandratra
 * @author Claire
 *
 * @see ConditionDeFin
*/
public class ConditionDeFinVivantDansPieceEtPossedeObjets extends ConditionDeFin {

  /**
  * Le vivant
  */
  private Vivant vivant;

  /**
  * La pièce
  */
  private Piece piece;

  /**
  * Les objets
  */
  private Objet[] objets;

  /**
  * La condition de vivant dans pièce
  */
  private ConditionDeFinVivantDansPiece cond1;

  /**
  * La condition de vivant possède objet
  */
  private ConditionDeFinVivantPossedeObjets cond2;

  /**
   * Constructeur ConditionDeFinVivantDansPieceEtPossedeObjets.
   * Permet de créer la condition où le vivant est dans la pièce et possède des objets.
   *
   * @param etatDuJeu L'état du jeu
   * @param vivant Le vivant
   * @param piece La pièce
   * @param objets Les objets
   *
   * @see EtatDuJeu
   * @see Vivant
   * @see Piece
   * @see Objet
  */
  public ConditionDeFinVivantDansPieceEtPossedeObjets(EtatDuJeu etatConditionVerifiee,
                                            Vivant vivant,
                                            Piece piece,
                                            Objet... objets) {

    super(etatConditionVerifiee);
    this.vivant = vivant;
    this.piece = piece;
    this.objets = objets;
    this.cond1 = new ConditionDeFinVivantDansPiece(this.getEtatConditionVerifiee(),vivant,piece);
    this.cond2 = new ConditionDeFinVivantPossedeObjets(this.getEtatConditionVerifiee(),vivant,objets);
  }

  /**
   * Donne l'état du jeu actuel, après vérification de la condition de fin.
   *
   * @return L'état du jeu actuel.
   *
   *@ see EtatDuJeu
  */
  public EtatDuJeu verifierCondition() {
    ConditionDeFinConjonctionConditionDeFin cond = new ConditionDeFinConjonctionConditionDeFin(this.getEtatConditionVerifiee(), cond1, cond2);
    return cond.verifierCondition();
  }

}
