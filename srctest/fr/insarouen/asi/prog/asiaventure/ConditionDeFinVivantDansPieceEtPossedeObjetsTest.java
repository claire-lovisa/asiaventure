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

public class ConditionDeFinVivantDansPieceEtPossedeObjetsTest {
  private Monde m;
  private Vivant v1;
  private Objet[] objets;
  private ConditionDeFinVivantDansPieceEtPossedeObjets cond;
  private Piece piece;

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    m = new Monde("Ordinateur");
    Objet obj = new Objet("Noisette",m){
      public boolean estDeplacable() {
        return true;
      }
    };
    objets = new Objet[1];
    objets[0] = obj;
    piece = new Piece("The Maze",m);
    v1 = new Vivant("PacMan",m,10,10,piece,objets){
      public void executer() throws Throwable{

      }
    };
    cond = new ConditionDeFinVivantDansPieceEtPossedeObjets(EtatDuJeu.SUCCES,v1,piece,objets);
  }

  @Test()
  public void testVerifierCondition() {
    assertThat(cond.getEtatConditionVerifiee(), IsEqual.equalTo(EtatDuJeu.SUCCES));
  }
}
