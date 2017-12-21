package fr.insarouen.asi.prog.asiaventure.elements.objets;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.junit.Test;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.Monde;
import org.junit.Before;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;


public class PiedDeBicheTest {

  public PiedDeBiche pdb,pdb2;
  public Monde m;

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
    m = new Monde("Maison");
    pdb = new PiedDeBiche("Bichette",m);
  }

  @Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testNomDEntiteDejaUtiliseDansLeMondeExceptionPdb() throws NomDEntiteDejaUtiliseDansLeMondeException {
    pdb2 = new PiedDeBiche("Bichette",m);
  }

  @Test
  public void deplacablePdb() {
    assertThat(pdb.estDeplacable(), is(true));
  }

}
