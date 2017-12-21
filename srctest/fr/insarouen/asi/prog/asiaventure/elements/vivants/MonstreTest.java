package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.*;
import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.hamcrest.core.IsEqual;
import org.junit.*;
import java.util.*;
import org.hamcrest.core.IsSame;

public class MonstreTest{

  Monde m;
  Objet o;
  Monstre monstre;
  Map<String,Objet> objets;
  Piece pieceA,pieceB;
  Objet[] objs;
  Porte porte;

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    objs = new Objet[0];
    m = new Monde("Maison des monstres");
    pieceA = new Piece("Salle de Zombification",m);
    pieceB = new Piece("Salle de De-Zombification",m);
    monstre = new Monstre("Zombie-garou",m,10,10,pieceA,objs);
    porte = new Porte("Porte réanimée",m,pieceA,pieceB);
    pieceA.addPorte(porte);
  }

  @Test
  public void testExecuter() throws ASIAventureException {
    int vie = monstre.getPointVie();
    monstre.executer();
    assertThat(monstre.getPointVie(),IsEqual.equalTo(vie-1));
    assertThat(monstre.getPiece(),IsEqual.equalTo(pieceB));
  }
}
