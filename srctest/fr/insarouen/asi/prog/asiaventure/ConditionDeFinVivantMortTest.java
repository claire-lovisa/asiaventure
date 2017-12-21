package fr.insarouen.asi.prog.asiaventure;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsSame;
import org.junit.*;
import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import java.util.*;

public class ConditionDeFinVivantMortTest {
  private Monde m;
  private Vivant v1;
  private Objet[] objs;
  private ConditionDeFinVivantMort cond;
  private Piece piece;

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    m = new Monde("Ordinateur");
    objs = new Objet[0];
    piece = new Piece("The Maze",m);
    v1 = new Vivant("PacMan",m,10,10,piece,objs){
      public void executer() throws Throwable{

      }
    };
    cond = new ConditionDeFinVivantMort(EtatDuJeu.ECHEC,v1);
  }

  @Test()
  public void testVerifierCondition() {
    assertThat(cond.getEtatConditionVerifiee(), IsEqual.equalTo(EtatDuJeu.ENCOURS));
  }
}
