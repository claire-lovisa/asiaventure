package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFin;
import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.*;
import fr.insarouen.asi.prog.asiaventure.elements.*;

/**
 * ConditionDeFinVivantMort est la classe permettant de représenter la condition d'un vivant mort.
 * Une ConditionDeFinVivantMort est une condition de fin.
 *
 * @author Sandratra
 * @author Claire
 *
 * @see ConditionDeFin
*/
public class ConditionDeFinVivantMort extends ConditionDeFin{

  /**
  * Le vivant
  */
  private Vivant vivant;

  /**
   * Constructeur ConditionDeFinVivantMort.
   * Permet de créer la condition où le vivant est mort.
   *
   * @param etatDuJeu L'état du jeu
   * @param vivant Le vivant
   *
   * @see EtatDuJeu
   * @see Vivant
  */
  public ConditionDeFinVivantMort(EtatDuJeu etatConditionVerifiee,
                                  Vivant vivant){
    super(etatConditionVerifiee);
    this.vivant = vivant;
  }

  /**
   * Donne l'état du jeu actuel, après vérification de la condition de fin.
   *
   * @return L'état du jeu actuel.
   *
   *@ see EtatDuJeu
  */
  public EtatDuJeu verifierCondition(){
    if(this.vivant.estMort()){
      return getEtatConditionVerifiee();
    }
    else
      return EtatDuJeu.ENCOURS;
  }
}
