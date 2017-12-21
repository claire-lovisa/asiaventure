package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class ClefTest {

  Monde m;
  Clef cle;

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
    m = new Monde("Boite de Pandore");
    cle = new Clef("Passe-partout",m);
  }

  @Test
  public void testConstructeur() throws NomDEntiteDejaUtiliseDansLeMondeException{
    assertThat(cle.getNom(),IsEqual.equalTo("Passe-partout"));
    assertThat(cle.getMonde(),IsEqual.equalTo(m));
  }

  @Test
  public void deplacableClef() {
    assertThat(cle.estDeplacable(), is(true));
  }
}
