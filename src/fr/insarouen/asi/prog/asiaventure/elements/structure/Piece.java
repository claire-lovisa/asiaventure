package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.GestionObjets;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;


/**
 * Piece est la classe permettant de représenter une pièce.
 * Une pièce possède un nom qui lui est donné et appartient à un monde.
 * Elle peut contenir des objets et des vivants.
 *
 * @author Sandratra
 * @author Claire
*/

public class Piece extends ElementStructurel {

  /**
   * Les objets de la pièce.
   *
   * @see Piece#getObjets()
  */
  private Map<String,Objet> objets2;

  /**
   * Les vivants de la pièce.
   *
  */
  private Map<String,Vivant> vivants2;

  /**
   * Les portes de la pièce.
   *
  */
  private Map<String, Porte> portes2;

  /**
   * Constructeur Piece.
   * A la création d'une pièce, elle est représentée par un nom et un monde donnés.
   * Quand une pièce est creee, elle contient 0 objets et 0 vivants.
   *
   * @param nom Le nom de la pièce
   * @param monde Le monde dans lequel est la pièce
   *
   * @see Monde
  */
  public Piece(String nom, Monde monde)
    throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);


    objets2 = new HashMap<String,Objet>();

    vivants2 = new HashMap<String,Vivant>();

    portes2 = new HashMap<String,Porte>();
  }


  /**
   * Permet de savoir si la pièce contient un objet.
   *
   * @param obj L'objet cherché dans la pièce
   *
   * @return Vrai si la pièce contient l'objet, faux sinon.
   *
   * @see Objet
  */
  public boolean contientObjet(Objet obj) {
    return this.contientObjet(obj.getNom());
  }

  /**
   * Permet de savoir si la pièce contient un objet.
   *
   * @param nomObj Le nom de l'objet cherché dans la pièce
   *
   * @return Vrai si la pièce contient l'objet, faux sinon.
  */
  public boolean contientObjet(String nomObj) {
    return this.objets2.containsKey(nomObj);
  }

  /**
   * Permet d'ajouter une porte à la collection des portes d'une pièce.
   *
   * @see Porte
  */

  /**
   * Permet d'obtenir la collection des objets d'une pièce.
   *
   * @return La collection d'objets présents dans la pièce.
   *
   * @see Objet
  */
  public Collection<Objet> getObjets() {
    return this.objets2.values();
  }

  /**
   * Permet déposer un objet dans la pièce.
   *
   * @param obj L'objet à déposer dans la pièce
   *
   * @see Objet
  */
  public void deposer(Objet obj) {
    this.objets2.put(obj.getNom(),obj);
  }

  /**
   * Permet retirer un objet de la pièce.
   *
   * @param obj L'objet à retirer de la pièce.
   *
   * @return L'objet qui a été retiré de la pièce.
   *
  * @see Objet
  */
  public Objet retirer(Objet obj)
    throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException {
    if(!contientObjet(obj.getNom())) {
      throw new ObjetAbsentDeLaPieceException("L'objet n'est pas dans la pièce");
    }
    if(!obj.estDeplacable()) {
      throw new ObjetNonDeplacableException("L'objet n'est pas déplacable");
    }
    return this.retirer(obj.getNom());
  }

  /**
   * Permet retirer un objet de la pièce.
   *
   * @param nomObj Le nom de l'objet à retirer de la pièce.
   *
   * @return L'objet qui a été retiré de la pièce.
   *
  * @see Objet
  */
  public Objet retirer(String nomObj)
    throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException {
    if(!contientObjet(nomObj)) {
      throw new ObjetAbsentDeLaPieceException("L'objet n'est pas dans la pièce");
    }
    return this.objets2.remove(nomObj);
  }


  /**
   * Permet de savoir si la pièce contient un certain vivant.
   *
   * @param vivant Le vivant à chercher dans la pièce
   *
   * @return Vrai si la pièce contient le vivant, faux sinon.
   *
  * @see Vivant
  */
  public boolean contientVivant(Vivant vivant) {
    return contientVivant(vivant.getNom());
  }

  /**
   * Permet de savoir si la pièce contient un certain vivant.
   *
   * @param nomVivant Le nom du vivant à chercher dans la pièce
   *
   * @return Vrai si la pièce contient le vivant, faux sinon.
   *
  * @see Vivant
  */
  public boolean contientVivant(String nomVivant) {
    return this.vivants2.containsKey(nomVivant);
  }

  /**
   * Permet de faire entrer un certain vivant dans une pièce.
   *
   * @param vivant Le vivant à chercher dans la pièce
   *
  * @see Vivant
  */
  public void entrer(Vivant vivant) {
    this.vivants2.put(vivant.getNom(),vivant);
  }

  /**
   * Permet de faire sortir un certain vivant d'une pièce.
   *
   * @param vivant Le vivant à faire sortir de la pièce
   *
   * @return Le vivant qui est sorti de la pièce.
   *
  * @see Vivant
  */
  public Vivant sortir(Vivant vivant)
    throws VivantAbsentDeLaPieceException {
    return sortir(vivant.getNom());
  }

  /**
   * Permet de faire sortir un certain vivant d'une pièce.
   *
   * @param nomVivant Le nom du vivant à faire sortir de la pièce
   *
   * @return Le vivant qui est sorti de la pièce.
   *
  * @see Vivant
  */
  public Vivant sortir(String nomVivant)
    throws VivantAbsentDeLaPieceException {
    if(!contientVivant(nomVivant)) {
      throw new VivantAbsentDeLaPieceException("Le vivant n'est pas dans la pièce");
    }
    return this.vivants2.remove(nomVivant);
  }


  /**
   * Permet d'ajouter une porte à une pièce
   *
   * @param porte La porte à ajouter
   *
  * @see Porte
  */
  public void addPorte(Porte porte) {
    this.portes2.put(porte.getNom(),porte);
  }

  /**
	 * Indique si la porte existe dans cette pièce
   *
	 * @param nomPorte Le nom de la porte à tester
   *
	 * @return Vrai si la porte existe dans cette pièce, Faux sinon
   *
	 * */
  public boolean aLaPorte(String nomPorte) {
    return portes2.containsKey(nomPorte);
  }

  /**
	 * Indique si la porte existe dans cette pièce
   *
	 * @param porte La porte à tester
   *
	 * @return Vrai si la porte existe dans cette pièce, Faux sinon
   *
	 * */
  public boolean aLaPorte(Porte porte){
    return aLaPorte(porte.getNom());
  }

  /**
	 * Renvoit le nom de la porte d'une pièce
   *
	 * @param nomPorte Le nom de la porte à tester
   *
	 * @return La porte de la pièce
   *
	 * */
  public Porte getPorte(String nomPorte) {
    return portes2.get(nomPorte);
  }

  /**
	 * Renvoit la collection de portes présentes dans la pièce
   *
	 * @return La collection de portes
   *
	 * */
  public Collection<Porte> getPortes(){
    return this.portes2.values();
  }


  /**
   * Donne une représentation de la pièce en chaine de caractere.
   *
   * @return La chaine de caractere representant la pièce.
  */
  public String toString() {
		StringBuilder res = new StringBuilder("Piece " + super.toString()+" :\n");
		res.append(" Les objets de la pièce :\n");
		for (Objet obj : objets2.values())
			res.append("  "+obj.toString()+"\n");
		res.append(" Les vivants de la pièce"+this.getNom()+":\n");
		for (Vivant v : vivants2.values())
			res.append("  "+v.toString()+"\n");
		res.append(" Les portes de la pièce :\n");
		for (Porte p : portes2.values())
			res.append("  "+p.getNom().toString()+"\n");
		return res.toString();
	}
}
