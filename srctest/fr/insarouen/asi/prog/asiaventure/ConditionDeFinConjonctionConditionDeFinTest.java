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

public class ConditionDeFinConjonctionConditionDeFinTest {
  Monde m;
  Vivant v1;
  Objet[] objs;
  ConditionDeFinConjonctionConditionDeFin conjonction;
  ConditionDeFin[] cfs;
  ConditionDeFinVivantPossedeObjets cond1;
  ConditionDeFinVivantMort cond2;
  Piece piece;

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    m = new Monde("Ordinateur");
    objs = new Objet[0];
    piece = new Piece("The Maze",m);
    v1 = new Vivant("PacMan",m,10,10,piece,objs){};
    cond1 = new ConditionDeFinVivantPossedeObjets(EtatDuJeu.SUCCES,v1,objs);
    cond2 = new ConditionDeFinVivantMort(EtatDuJeu.ECHEC,v1);
    cfs[0] = cond1;
    cfs[1] = cond2;
    conjonction = new ConditionDeFinConjonctionConditionDeFin(EtatDuJeu.ECHEC,cfs);
  }

  @Test()
  public void testVerifierCondition() {
    assertThat(conjonction.getEtatConditionVerifiee(), IsEqual.equalTo(EtatDuJeu.SUCCES));
  }
}
