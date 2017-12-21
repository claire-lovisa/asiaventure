package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.*;
import fr.insarouen.asi.prog.asiaventure.*;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.*;
import java.util.*;
import org.hamcrest.core.IsSame;


public class CoffreTest {
  Monde m;
  Coffre c,c1;
  Objet o;
  PiedDeBiche pdb;
  Etat etat;

  @Before
  public void avantTest()throws NomDEntiteDejaUtiliseDansLeMondeException{
    m = new Monde("Maison");
    c = new Coffre("Tirelire",m);
    o = new Objet("Clou",m){
      public boolean estDeplacable() {
        return true;
      }
    };
    pdb = new PiedDeBiche("Bambi",m);
  }

  @Test
  public void testConstructeur(){
    assertThat(c.getNom(),IsEqual.equalTo("Tirelire"));
    assertThat(c.getMonde(),IsEqual.equalTo(m));
  }

  @Test
  public void testActivableAvec(){
    assertThat(c.activableAvec(o),is(false));
    assertThat(c.activableAvec(pdb),is(true));
  }

  @Test
  public void testActiver(){
    etat = c.getEtat();
    c.activer();
    assertThat(c.getEtat()==etat,is(false));
  }

  @Test
  public void testActiverAvec()throws ActivationException{
    c.activerAvec(pdb);
    assertThat(c.getEtat(),IsEqual.equalTo(etat.CASSE));
  }

  @Test
  public void testDeplacable() {
    assertThat(c.estDeplacable(), is(false));
  }

  @Test
  public void testGetEtat() throws NomDEntiteDejaUtiliseDansLeMondeException{
    c1 = new Coffre("boite de pandore",m);
    assertThat(c.getEtat(), IsEqual.equalTo(etat.FERME));
  }

}
