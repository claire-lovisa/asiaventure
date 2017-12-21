package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.io.*;
import java.util.*;
import java.lang.Object.*;
import java.lang.reflect.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.*;
import fr.insarouen.asi.prog.asiaventure.*;

/**
  * <b>JoueurHumain est la classe permettant de représenter un joueur humain.</b>
  * <p>
  * Le JoueurHumain est caracterise par les informations suivantes :
  * Le Vivant est caracterise par les informations suivantes :
  * <ul>
  * <li> des points de vie </li>
  * <li> des points de force </li>
  * <li> une piece </li>
  * <li> un ensemble d'objets. On peut ajouter/enlever des entites à cet ensemble </li>
  * <li> un ordre </li>
  * </ul>
  * </p>
  *
  * @see Vivant
  *
  * @author Sandratra
  * @author Claire
  * @version 1.0
*/

public class JoueurHumain extends Vivant {

  /**
  * L'ordre d'action du joueur humain.
  */

  private String ordre;

  /**
  * constructeur Vivant
  * <p>
  * A la construction d'un objet Vivant, on choisit son nom, un Monde,
  * ses points de vie/force, une piece et des objets. L'ensemble des
  * objets est initialement vide. Il ne reçoit pas encore d'ordre.
  * </p>
  *
  * @param nom
  * @param Monde
  * @param pointVie
  * @param pointForce
  * @param piece
  * @param objets
  */

  public JoueurHumain(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets)
    throws NomDEntiteDejaUtiliseDansLeMondeException {
    super(nom,monde,pointVie,pointForce,piece,objets);
    ordre="";
  }

  /**
  * Permet de définir l'ordre d'un joueur.
  *
  * @param ordre L'ordre d'action
  */

  public void setOrdre(String ordre) {
    this.ordre=ordre;
  }

  /**
   * Exécute un cycle d'actions du joueur humain.
  */

  public void executer()
              throws CommandeImpossiblePourLeVivantException,Throwable {
    String param[] = ordre.split(" +");
    Class paramFormels[] = new Class[param.length-1];

    // Met la première lettre en majuscule
    char[] char_table = param[0].toCharArray();
    char_table[0]=Character.toUpperCase(char_table[0]);
    param[0] = new String(char_table);

    for (int i = 0 ; i<paramFormels.length ; i++)
      paramFormels[i] = String.class;
    try {
      Method m = getClass().getDeclaredMethod("commande"+param[0], paramFormels);
      String paramEffectifs[] = Arrays.copyOfRange(param, 1, param.length);
      m.invoke(this, (Object[])paramEffectifs);
    }
    catch (InvocationTargetException e) {
      throw e.getCause();
    }
    catch (NoSuchMethodException e) {
      throw new CommandeImpossiblePourLeVivantException("La commande n'existe pas");
    }

  }

  private void commandePrendre(String nomObjet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
    this.prendre(nomObjet);
  }

  private void commandePoser(String nomObjet) throws ObjetNonPossedeParLeVivantException {
    this.deposer(nomObjet);
  }

  private void commandeFranchir(String nomPorte) throws PorteFermeException, PorteInexistanteDansLaPieceException {
    this.franchir(nomPorte);
  }

  private void commandeOuvrirPorte(String nomPorte) throws ActivationException, PorteInexistanteDansLaPieceException {
    this.getPiece().getPorte(nomPorte).activer();
  }

  private void commandeOuvrirPorte(String nomPorte, String nomObjet) throws ActivationException, PorteInexistanteDansLaPieceException,
ObjetNonPossedeParLeVivantException {
    this.getPiece().getPorte(nomPorte).activerAvec(getObjet(nomObjet));
  }

  /**
   * Donne une représentation du joueur humain en chaine de caractere.
   *
   * @return La chaine de caractere representant le joueur humain.
  */
  public String toString(){
    StringBuilder s = new StringBuilder("");
    s.append("Joueur humain "+super.getNom());
    return s.toString();
  }

}
