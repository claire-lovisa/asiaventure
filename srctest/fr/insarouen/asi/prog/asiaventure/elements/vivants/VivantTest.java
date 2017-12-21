package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.Ignore;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.GestionObjets;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import org.junit.Before;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import java.util.*;
import org.hamcrest.core.IsSame;

public class VivantTest {

  Monde m;
  Objet o,objetNonDeplacable,objetNonPossedeVivant;
  Vivant v,v2,vivant1,vivant2,vivantQuiFranchit;
  Map<String,Objet> objets;
  Piece piece,pieceA,pieceB;
  Objet[] objs;
  Porte porte;

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
    m = new Monde("Ordinateur");
    o = new Objet("Poubelle",m){
      public boolean estDeplacable() {
        return true;
      }
    };
    objs = new Objet[0];
    piece = new Piece("Bureau",m);
    objets = new HashMap<>();
    v = new Vivant("PacMan",m,10,10,piece,objs){
      public void executer() throws Throwable{

      }
    };
  }

  @Test
  public void testPrendreDeposer() throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException,ObjetNonPossedeParLeVivantException {
    piece.deposer(o);
    v.prendre("Poubelle");
    assertThat(v.possede(o),is(true));
    assertThat(piece.contientObjet(o),is(false));
    v.deposer("Poubelle");
    assertThat(v.possede(o),is(false));
    assertThat(piece.contientObjet(o),is(true));

  }

  @Test
  public void testGetPieceEtObjet() throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException{
    assertThat(v.getPiece(),IsSame.sameInstance(piece));
    piece.deposer(o);
    v.prendre("Poubelle");
    objets.put(o.getNom(),o);
    assertThat(v.getObjet("Poubelle")==o, is(true));
  }

  @Test
  public void testVieForce() throws NomDEntiteDejaUtiliseDansLeMondeException{
    assertThat(v.getPointVie(),IsEqual.equalTo(10));
    assertThat(v.getPointForce(),IsEqual.equalTo(10));
    assertThat(v.estMort(),is(false));

    v2 = new Vivant("PacMan2",m,0,10,piece,objs){
      public void executer() throws Throwable{

      }
    };
    assertThat(v2.estMort(),is(true));
  }

  @Test
  public void testFranchir() throws PorteFermeException,
  PorteInexistanteDansLaPieceException,NomDEntiteDejaUtiliseDansLeMondeException{
    pieceA = new Piece("RiveGauche",m);
    pieceB = new Piece("RiveDroite",m);
    vivantQuiFranchit = new Vivant("Joey le canard",m,10,10,pieceA,objs) {
      public void executer() throws Throwable{

      }
    };
    Porte porte = new Porte("Pont à canards",m,pieceA,pieceB);
    pieceA.addPorte(porte);
    pieceB.addPorte(porte);
    vivantQuiFranchit.franchir(porte);
    assertThat(vivantQuiFranchit.getPiece(),IsEqual.equalTo(pieceB));
  }

  @Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testNomDEntiteDejaUtiliseDansLeMondeException()
  throws NomDEntiteDejaUtiliseDansLeMondeException{
    vivant1 = new Vivant("HappySnail",m,10,10,piece,objs) {
      public void executer() throws Throwable{

      }
    };
    vivant2 = new Vivant("HappySnail",m,10,10,piece,objs) {
      public void executer() throws Throwable{

      }
    };
  }

  @Test(expected=ObjetAbsentDeLaPieceException.class)
  public void testObjetAbsentDeLaPieceException()
  throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException{
    v.prendre("Poubelle");
  }

  @Test(expected=ObjetNonDeplacableException.class)
  public void testObjetNonDeplacableException()
  throws ObjetNonDeplacableException,NomDEntiteDejaUtiliseDansLeMondeException,
  ObjetAbsentDeLaPieceException{
    objetNonDeplacable = new Objet("ObjetLourd",m){
      public boolean estDeplacable() {
        return false;
      }
    };
    piece.deposer(objetNonDeplacable);
    v.prendre(objetNonDeplacable);
  }

  @Test(expected=ObjetNonPossedeParLeVivantException.class)
  public void testObjetNonPossedeParLeVivantException()
  throws ObjetNonPossedeParLeVivantException,NomDEntiteDejaUtiliseDansLeMondeException,
  ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
    v.deposer("Poubelle");
  }

  @Test(expected=PorteInexistanteDansLaPieceException.class)
  public void testPorteInexistanteDansLaPieceException()throws PorteFermeException,
  PorteInexistanteDansLaPieceException,NomDEntiteDejaUtiliseDansLeMondeException{
    pieceA = new Piece("RiveG",m);
    pieceB = new Piece("Rive",m);
    Porte porte = new Porte("Pont",m,pieceA,pieceB);
    v2 = new Vivant("Pac",m,10,10,piece,objs){
      public void executer() throws Throwable{

      }
    };
    v2.franchir(porte);
  }
}
