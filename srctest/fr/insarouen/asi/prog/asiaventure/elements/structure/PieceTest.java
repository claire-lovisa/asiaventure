package fr.insarouen.asi.prog.asiaventure.elements.structure;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.Ignore;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.GestionObjets;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import org.junit.Before;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import java.util.*;
import org.hamcrest.core.IsSame;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.Is;

public class PieceTest {

  public Monde monde;
  public Piece piece,autrePiece;
  public Objet objet,o2;
  public Objet[] objets;
  public Objet[] objs;
  public Porte p1;

  @Before
  public void genese() throws NomDEntiteDejaUtiliseDansLeMondeException {
    monde = new Monde("Maison des écureuils");
    piece = new Piece("Tronc",monde);
    autrePiece = new Piece("Wesh",monde);
    objet = new Objet("Noisette",monde) {
      public boolean estDeplacable() {
        return true;
      }
    };
    objets=new Objet[0];
    p1 = new Porte("Passage magique",monde,piece,autrePiece);
  }

  @Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testNomDEntiteDejaUtiliseDansLeMondeException() throws NomDEntiteDejaUtiliseDansLeMondeException {
    o2 = new Objet("Noisette",monde){
      public boolean estDeplacable() {
        return true;
      }
    };
  }

  @Test
  public void constructeur() {
    Map<String,Objet> objetsVide = new HashMap<>();
    assertThat(piece.getNom(),IsEqual.equalTo("Tronc"));
    assertThat(piece.getMonde(),IsEqual.equalTo(monde));
    ;
  }

  @Test
  public void egalites() throws NomDEntiteDejaUtiliseDansLeMondeException {
    autrePiece = new Piece("Racine",monde);
    assertThat(piece.equals(autrePiece),is(false));
    assertThat(piece.equals(piece),is(true));
  }

  @Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void egalitesException() throws NomDEntiteDejaUtiliseDansLeMondeException {
    autrePiece = new Piece("Tronc",monde);
  }

  @Test
  public void testDeposerObjets() {
    assertThat(piece.contientObjet(objet), is(false));
		piece.deposer(objet);
		assertThat(piece.contientObjet(objet), is(true));
  }

  @Test
  public void testContientObjet() {
    piece.deposer(objet);
    assertThat(piece.contientObjet(objet), is(true));
    assertThat(piece.contientObjet(objet.getNom()), is(true));
  }


  @Test(expected = ObjetAbsentDeLaPieceException.class)
  public void getObjetsObjetAbsentDeLaPieceException() throws NomDEntiteDejaUtiliseDansLeMondeException,ObjetAbsentDeLaPieceException,ObjetNonDeplacableException {
    Objet o1;
    o1 = new Objet("Truc 1",monde){
      public boolean estDeplacable() {
        return true;
      }
    };
    o1=piece.retirer(o1);
  }

  @Test(expected = ObjetNonDeplacableException.class)
  public void getObjetsObjetNonDeplacableException() throws NomDEntiteDejaUtiliseDansLeMondeException,ObjetAbsentDeLaPieceException,ObjetNonDeplacableException {
    Objet o1;
    o1 = new Objet("Truc 1",monde){
      public boolean estDeplacable() {
        return false;
      }
    };
    piece.deposer(o1);
    o1=piece.retirer(o1);
  }

  @Test
  public void testVivants() throws NomDEntiteDejaUtiliseDansLeMondeException,VivantAbsentDeLaPieceException {
    Vivant v1 = new Vivant("Alouette",monde,10,10,piece,objets){
        public void executer() throws Throwable{

        }
    };
    assertThat(piece.contientVivant(v1),is(true));
    piece.sortir(v1);
    assertThat(piece.contientVivant(v1),is(false));
  }

  @Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testVivantsNomDEntiteDejaUtiliseDansLeMondeException() throws NomDEntiteDejaUtiliseDansLeMondeException,VivantAbsentDeLaPieceException {
    Vivant v1 = new Vivant("Alouette",monde,10,10,piece,objets){
      public void executer() throws Throwable{

      }
    };
    Vivant v2 = new Vivant("Alouette",monde,10,10,piece,objets){
      public void executer() throws Throwable{

      }
    };
  }

  @Test(expected = VivantAbsentDeLaPieceException.class)
  public void testVivantsVivantAbsentDeLaPieceException() throws NomDEntiteDejaUtiliseDansLeMondeException,VivantAbsentDeLaPieceException {
    Vivant v1 = new Vivant("Alouette",monde,10,10,piece,objets){
      public void executer() throws Throwable{

      }
    };
    piece.sortir("Alouette");
    piece.sortir("Alouette");
  }

  @Test
  public void testPortes() {
    assertThat(piece.aLaPorte(p1),is(true)); // la porte s'ajoute automatiquement à la création d'une porte
    piece.addPorte(p1);
    assertThat(piece.aLaPorte(p1),is(true));
    autrePiece.addPorte(p1);
    assertThat(autrePiece.aLaPorte(p1),is(true));
  }

}
