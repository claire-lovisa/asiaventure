package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.*;
import fr.insarouen.asi.prog.asiaventure.elements.*;

/**
 * ConditionDeFinVivantDansPiece est la classe permettant de représenter une conjonction de conditions de fin de partie.
 * Une ConditionDeFinVivantDansPiece est une condition de fin.
 *
 * @author Sandratra
 * @author Claire
 *
 * @see ConditionDeFin
*/
public class ConditionDeFinVivantDansPiece extends ConditionDeFin {

  /**
  * Le vivant
  */
  private Vivant vivant;

  /**
  * La pièce
  */
  private Piece piece;

  /**
   * Constructeur ConditionDeFinVivantDansPiece.
   * Permet de créer la condition où le vivant est dans la pièce.
   *
   * @param etatDuJeu L'état du jeu
   * @param vivant Le vivant
   * @param piece La pièce
   *
   * @see EtatDuJeu
   * @see Vivant
   * @see Piece
  */
  public ConditionDeFinVivantDansPiece(EtatDuJeu etatConditionVerifiee,
                                        Vivant vivant,
                                        Piece piece) {
    super(etatConditionVerifiee);
    this.vivant = vivant;
    this.piece = piece;
  }

  /**
   * Donne l'état du jeu actuel, après vérification de la condition de fin.
   *
   * @return L'état du jeu actuel.
   *
   *@ see EtatDuJeu
  */
  public EtatDuJeu verifierCondition() {
    if(vivant.getPiece().equals(piece)) {
      return getEtatConditionVerifiee();
    }
    else return EtatDuJeu.ENCOURS;
  }

}
