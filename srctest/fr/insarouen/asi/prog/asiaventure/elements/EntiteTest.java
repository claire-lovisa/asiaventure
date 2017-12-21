package fr.insarouen.asi.prog.asiaventure.elements;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import org.junit.Before;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class EntiteTest {

  public class EntitePourLeTest extends Entite {
    public EntitePourLeTest(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
      super(nom, monde);
    }
  }

  public Monde monde;
  public EntitePourLeTest entite,autreEntite,entite1,entite2;

  @Before
  public void genese() throws NomDEntiteDejaUtiliseDansLeMondeException {
    monde = new Monde("Maison des écureuils");
    entite = new EntitePourLeTest("Entitounette",monde);
    autreEntite = new EntitePourLeTest("Entitounet",monde);
  }

  @Test
  public void constructeur() {
    assertThat(entite.getNom(),IsEqual.equalTo("Entitounette"));
    assertThat(entite.getMonde(),IsEqual.equalTo(monde));
  }

  @Test
  public void egalites() {
    assertThat(entite.equals(autreEntite),is(false));
    assertThat(entite.equals(entite),is(true));
  }

  @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testNomDEntiteDejaUtiliseDansLeMondeException()
  throws NomDEntiteDejaUtiliseDansLeMondeException{
    entite1 = new EntitePourLeTest("entite1",monde) {};
    entite2 = new EntitePourLeTest("entite1",monde) {};
  }

}
