package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import java.util.*;
/**
  * <b>Monde est la classe representant l'univers que l'on parcourt.</b>
  * <p>
  * L'univers est caracterise par les informations suivantes :
  * <ul>
  * <li> un nomDuMonde </li>
  * <li> un ensemble d'entites. On peut ajouter des entites à cet ensemble </li>
  * </ul>
  * </p>
  *
  * @see Entite
  *
  * @author Sandratra
  * @author Claire
  * @version 1.0
*/
public class Monde {

  /**
  * Le nom du monde.
  *
  * @see Monde#Monde(String nomDuMonde)
  * @see Monde#getNom()
  */
  private String nomDuMonde;
  /**
  * L'ensemble des entites
  *
  * @see Entite
  *
  * @see Monde#Monde(String nomDuMonde)
  * @see Monde#ajouter(Entite entite)
  * @see Monde#getEntite(String nomEntite)
  */

  private Map<String,Entite> entites2;

  /**
  * L'ensemble des executables
  *
  * @see Executable
  *
  * @see Monde#Monde(String nomDuMonde)
  * @see Monde#ajouter(Entite entite)
  * @see Monde#getExecutables()
  */
  private ArrayList<Executable> executables;
  /**
  * constructeur Monde
  * <p>
  * A la construction d'un objet Monde, on choisit un nomDuMonde. L'ensemble des
  * entites est initialement vide.
  * </p>
  *
  * @param nomDuMonde
  *                   Le nom du monde
  * @see Monde#nomDuMonde
  * @see Monde#entites
  */
  public Monde(String nomDuMonde) {
    this.nomDuMonde = nomDuMonde;
    this.entites2 = new HashMap<String, Entite>();
    this.executables = new ArrayList<Executable>();
  }

  /**
  * Ajoute une entite a l'ensemble des entites.
  *
  * @param entite
  *               une nouvelle entite
  *
  * @see Monde#entites
  */
  public void ajouter(Entite entite)
      throws NomDEntiteDejaUtiliseDansLeMondeException,
              EntiteDejaDansUnAutreMondeException {

    if(!entite.getMonde().equals(this)) {
      throw new EntiteDejaDansUnAutreMondeException("Entité déjà dans un autre monde");
    }
    else if(this.entites2.containsKey(entite.getNom())){
      throw new NomDEntiteDejaUtiliseDansLeMondeException("Nom d'entité déja utilisé dans le monde");
    }
    else {
    this.entites2.put(entite.getNom(),entite);
    if(entite instanceof Executable){
      this.executables.add((Executable)entite);
    }
    }
  }

  /**
  * Retourne une entite de l'ensemble entites
  *
  * @param nomEntite
  *                 le nom de l'entite
  * @return Une entite ou rien si ensemble vide
  *
  * @see Monde#entites
  */
  public Entite getEntite(String nomEntite) {
    return this.entites2.get(nomEntite);
  }

  /**
  * Retourne le nom du monde
  *
  * @return Le nom du monde
  *
  * @see Monde
  */
  public String getNom() {
    return this.nomDuMonde;
  }

  /**
  * Retourne l'ensemble d'entites
  *
  * @return Les entites
  *
  * @see Entite
  */

  public Map<String,Entite> getEntitesCollection(){
    return this.entites2;
  }

  /**
  * Retourne l'ensemble des executables
  *
  * @return Les executables
  *
  * @see Executable
  */
  public Collection<Executable> getExecutables(){
    return this.executables;
  }

  /**
  * Description du monde et de ses entites
  *
  * @return Le nom du monde et de ses entites en CdC
  */
  public String toString(){
		StringBuilder res = new StringBuilder("Monde " +nomDuMonde+" :\n");
		for(Entite ent : entites2.values())
			res.append("\t"+ent.toString()+"\n");
		return res.toString();
	}


}
