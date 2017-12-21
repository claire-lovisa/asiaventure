package fr.insarouen.asi.prog.asiaventure.elements.objets;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.Ignore;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.GestionObjets;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import org.junit.Before;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;

public class ObjetTest {

  Objet o,o2;
  Monde m;

  public class ObjetPourLeTest extends Objet {

    public ObjetPourLeTest(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
      super(nom, monde);
    }

    public boolean estDeplacable(){
      return false;
    }
  }

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
    m = new Monde("Maison");
    o = new Objet("Obou",m){
      public boolean estDeplacable() {
        return true;
      }
    };
  }

  @Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testNomDEntiteDejaUtiliseDansLeMondeException() throws NomDEntiteDejaUtiliseDansLeMondeException {
    o2 = new Objet("Obou",m){
      public boolean estDeplacable() {
        return true;
      }
    };
  }

  @Test
  public void deplacable() {
    assertThat(o.estDeplacable(), is(true));
  }

}
