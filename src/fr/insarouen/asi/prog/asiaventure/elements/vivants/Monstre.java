package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import java.util.*;
import java.util.Random;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

/**
 * Montre est la classe permettant de représenter un monstre.
 * Un monstre est un vivant.
 *
 * @author Sandratra
 * @author Claire
 *
 * @see Vivant
 * @see Executable
*/
public class Monstre extends Vivant implements Executable{

  /**
   * Constructeur Monstre.
   * Permet de créer un Monstre.
   *
   * @param nom Le nom du monstre
   * @param monde Le monde dans lequel est le monstre
   *
   * @see Monde
  */
  public Monstre(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets)
  throws NomDEntiteDejaUtiliseDansLeMondeException {
    super(nom,monde,pointVie,pointForce,piece,objets);
  }

  /**
   * Exécute un cycle d'actions du monstre.
  */
  public void executer()
  throws ASIAventureException{
    if (!(super.getPointVie()==0)){
      this.changerPiece();
      this.setPointsDeVie(super.getPointVie()-1);
      this.echangerLesObjets();
    }
  }

  /**
   * Echange les objets possédés par le monstre et les objets de la pièce.
  */
  private void echangerLesObjets() throws ObjetAbsentDeLaPieceException,ObjetNonPossedeParLeVivantException,ObjetNonDeplacableException {
    Collection<Objet> lesObjetsPiece, lesObjetsVivant;
    Objet[] tabObjetsPiece, tabObjetsVivant;
    lesObjetsPiece=piece.getObjets();
    lesObjetsVivant=this.getObjets();
    tabObjetsPiece=lesObjetsPiece.toArray(new Objet[lesObjetsPiece.size()]);
    tabObjetsVivant=lesObjetsVivant.toArray(new Objet[lesObjetsVivant.size()]);

    try {
    for (int j=0;j<lesObjetsPiece.size();j++) { // On retire les objets de la piece
      piece.retirer(tabObjetsPiece[j]);
    }
    for (int j=0;j<lesObjetsPiece.size();j++) { // On retire les objets du monstre, et ça les met en meme temps dans la piece
      this.deposer(tabObjetsVivant[j]);
    }
    for (int j=0;j<lesObjetsPiece.size();j++) { // On met les anciens objets de la piece dans le monstre
      this.prendre(tabObjetsPiece[j]);
    } }
    catch(ObjetAbsentDeLaPieceException e) {System.out.println("Objet absent de la piece");	}
    catch(ObjetNonPossedeParLeVivantException e) {System.out.println("Objet absent de la piece");	}
    catch(ObjetNonDeplacableException e) {System.out.println("Objet absent de la piece");	}

  }

  /**
   * Change le monstre de pièce si une porte est franchissable.
  */
  private void changerPiece() throws PorteFermeException,PorteInexistanteDansLaPieceException{
    Collection<Porte> portes = super.piece.getPortes();
    Porte[] tabPortes = portes.toArray(new Porte[portes.size()]);
    Porte porte = null;
    for (int j=0;j<portes.size();j++) {
      if(tabPortes[j].getEtat().equals(Etat.DEVERROUILLE) || tabPortes[j].getEtat().equals(Etat.CASSE) || tabPortes[j].getEtat().equals(Etat.FERME) || tabPortes[j].getEtat().equals(Etat.OUVERT))
        porte = tabPortes[j];
    }
    if (porte == null) {
      throw new PorteFermeException("Pas de porte déverrouillée, cassée, fermée ou ouverte !");
    }
    super.franchir(porte.getNom());
  }

  /**
   * Donne une représentation du monstre en chaine de caractere.
   *
   * @return La chaine de caractere representant le monstre.
  */
  public String toString(){
    StringBuilder s = new StringBuilder("");
    s.append("Monstre "+super.getNom());
    return s.toString();
  }
}
