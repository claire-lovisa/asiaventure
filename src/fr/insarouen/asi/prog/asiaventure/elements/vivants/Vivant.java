package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.GestionObjets;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;

/**
  * <b>Vivant est la classe representant les êtres vivants. C'est une entite.</b>
  * <p>
  * Le Vivant est caracterise par les informations suivantes :
  * <ul>
  * <li> des points de vie </li>
  * <li> des points de force </li>
  * <li> une piece </li>
  * <li> un ensemble d'objets. On peut ajouter/enlever des entites à cet ensemble </li>
  * </ul>
  * </p>
  *
  * @see Entite
  *
  * @author Sandratra
  * @author Claire
  * @version 1.0
*/
public abstract class Vivant extends Entite implements Executable{

  /**
  * Les points de vie/force du vivant.
  *
  * @see Vivant#Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet[] objets)
  * @see Vivant#getPointVie()
  * @see Vivant#getPointForce()
  */
  private int pointVie, pointForce;

  /**
  * Une piece
  *
  * @see Vivant#Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet[] objets)
  * @see Vivant#getPiece()
  */
  protected Piece piece;

  /**
  * L'ensemble des objets
  *
  * @see Vivant#Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet[] objets)
  * @see Vivant#possede(Objet obj)
  * @see Vivant#deposer(String nomObj)
  * @see Vivant#prendre(String nomObj)
  * @see Vivant#getObjets()
  */
  protected Map<String,Objet>objets2;

  /**
  * constructeur Vivant
  * <p>
  * A la construction d'un objet Vivant, on choisit son nom, un Monde,
  * ses points de vie/force, une piece et des objets. L'ensemble des
  * objets est initialement vide.
  * </p>
  *
  * @param nom
  * @param Monde
  * @param pointVie
  * @param pointForce
  * @param piece
  * @param objets
  */
  public Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets)
  throws NomDEntiteDejaUtiliseDansLeMondeException {
    super(nom,monde);
    this.pointVie = pointVie;
    this.pointForce = pointForce;
    this.piece=piece;
    objets2 = new HashMap<String, Objet>();
    for(int i = 0 ; i<objets.length ; i++){
      this.objets2.put(objets[i].getNom(), objets[i]);
    }
    piece.entrer(this);
  }

  /**
  * Retourne vrai si le vivant possede un objet. Faux sinon
  *
  * @param nomObj Le nom de l'objet à tester
  * @return vrai si l'objet est possédé, faux sinon
  */
  private boolean possede(String nomObj) {
  return this.objets2.containsKey(nomObj);
  }

  /**
  * Retourne vrai si le vivant possede un objet. Faux sinon
  *
  * @param obj L'objet à tester
  * @return vrai si l'objet est possédé, faux sinon
  */
  public boolean possede(Objet obj) {
    return possede(obj.getNom());
  }

  /**
  * permet d'ajouter un objet à l'ensemble des objets
  *
  * @param nomObj
  */
  public void deposer(String nomObj)
    throws ObjetNonPossedeParLeVivantException{
      Objet o;
  if (!(this.possede(nomObj))) {
    throw new ObjetNonPossedeParLeVivantException("Le vivant ne possède pas l'objet");
  }
  o=this.objets2.remove(nomObj);
  this.piece.deposer(o);
  }

  /**
  * permet d'ajouter un objet à l'ensemble des objets
  *
  * @param obj
  */
  public void deposer(Objet obj)
    throws ObjetNonPossedeParLeVivantException{
    deposer(obj.getNom());
  }

  /**
  * permet de retirer un objet à l'ensemble des objets
  *
  * @param obj
  */
  public void prendre(Objet obj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
		this.prendre(obj.getNom());

	}

  /**
  * permet de retirer un objet à l'ensemble des objets
  *
  * @param nomObj
  */
	public void prendre(String nomObj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
	Objet o;
	if (!piece.contientObjet(nomObj) )
		throw new ObjetAbsentDeLaPieceException("Objet "+nomObj+" absent de la pièce"+piece.getNom()+" : on ne peut pas le prendre");
	Entite e = monde.getEntite(nomObj);
		if (e instanceof Objet) {
			if (!(((Objet)e).estDeplacable()))
				throw new ObjetNonDeplacableException("L'objet "+nomObj+" n'est pas déplaçable : on ne peut pas le prendre");
			o = piece.retirer(nomObj);
			objets2.put(o.getNom(), o);
		}
	}


  /**
  * Retourne la piece où le vivant se trouve
  *
  * @return la piece
  *
  * @see Piece
  */
  public Piece getPiece() {
    return this.piece;
  }

  /**
  * Retourne l'ensemble des objets
  *
  * @return les objets
  *
  * @see Objet
  */
  public Collection<Objet> getObjets() {
    return this.objets2.values();
  }

  /**
  * Retourne un objet dont le nom est donné
  *
  * @param nomObj
  *
  * @return les objets
  *
  * @see Objet
  */
  public Objet getObjet(String nomObj) {
    return this.objets2.get(nomObj);
  }


  /**
  * Retourne les points de vie du vivant
  *
  * @return les points de vie
  *
  * @see Vivant#pointVie
  */
  public int getPointVie() {
    return this.pointVie;
  }

  /**
  * Retourne les points de force du vivant
  *
  * @return les points de force
  *
  * @see Vivant#pointForce
  */
  public int getPointForce() {
    return this.pointForce;
  }

  /**
  * Retourne vrai si les points de vie sont nuls, faux sinon
  *
  * @return un booleen
  */
  public boolean estMort() {
    return pointVie==0 ;
  }

  /**
  * Permet de passer à une autre pièce
  *
  * @param porte
  */
  public void franchir(Porte porte)throws PorteFermeException,
  PorteInexistanteDansLaPieceException{
    if (!(this.piece.aLaPorte(porte))){
      throw new PorteInexistanteDansLaPieceException("Pas de porte !");
    }
    franchir(porte.getNom());
  }

  /**
  * Permet de passer à une autre pièce
  *
  * @param nomPorte
  */
  public void franchir(String nomPorte)
  throws PorteFermeException,PorteInexistanteDansLaPieceException{
    Piece pieceB = (this.piece.getPorte(nomPorte)).getPieceAutreCote(this.piece);
    this.piece = pieceB;
  }

  /**
  * Permet de définir les points de vie d'un vivant
  *
  * @param i Le nombre de points de vie à donner au vivant
  */
  public void setPointsDeVie(int i) {
    this.pointVie=i;
  }


/**
* Description du Vivant
*
* @return Le nom du vivant ses autres parametres en CdC
*/
  public String toString() {
  StringBuilder res = new StringBuilder("Vivant " + super.toString()+ " :\n");
  res.append("  Objets de "+getNom()+" : \n");
  for (Objet obj : objets2.values())
    res.append("\t"+obj.toString()+"\n");
  res.append("  nb PointsVie : " + pointVie+"\n");
  res.append("  nb PointsForce : " + pointForce+"\n");
  res.append("  Piece : " + piece.getNom()+"\n");
  return res.toString();

  }

}
