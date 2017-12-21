package fr.insarouen.asi.prog.asiaventure;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsSame;
import org.junit.Test;
import fr.insarouen.asi.prog.asiaventure.Monde;
import org.junit.Before;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import java.util.*;

public class MondeTest {
  public Monde monde,autreMonde;
  public Entite entite,entite1,entite2;

  @Before
  public void genese(){
    monde = new Monde("Maison des écureuils");
  }

  @Test
  public void testNomDuMonde() {
    assertThat(monde.getNom(), IsEqual.equalTo("Maison des écureuils"));
  }

  @Test()
  public void testEntiteDansUnMonde()
  throws NomDEntiteDejaUtiliseDansLeMondeException,EntiteDejaDansUnAutreMondeException{

    entite = new Entite("douche",monde) {};
    Entite pdb = new PiedDeBiche("noisetteFake",monde);
    assertThat(monde.getEntite(entite.getNom()), IsEqual.equalTo(entite));
    assertThat(monde.getEntite(pdb.getNom()),IsSame.sameInstance(pdb));
  }

  @Test
  public void testConstructeur() {
    Map<String,Entite> tabVide = new HashMap<>();
    assertThat(monde.getNom(), IsEqual.equalTo("Maison des écureuils"));
    assertThat(monde.getEntitesCollection(), IsEqual.equalTo(tabVide));
  }

  @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testNomDEntiteDejaUtiliseDansLeMondeException()
  throws NomDEntiteDejaUtiliseDansLeMondeException{
    entite1 = new Entite("entite1",monde) {};
    entite2 = new Entite("entite1",monde) {};
  }

  @Test(expected=EntiteDejaDansUnAutreMondeException.class)
  public void testEntiteDejaDansUnAutreMondeException()
  throws EntiteDejaDansUnAutreMondeException,NomDEntiteDejaUtiliseDansLeMondeException{
    entite = new Entite("Houloucouptère",monde) {};
    autreMonde = new Monde("Abri à escargots volants qui font peur");
    autreMonde.ajouter(entite);
  }
}
