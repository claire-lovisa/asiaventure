package fr.insarouen.asi.prog.asiaventure.elements.structure;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.Ignore;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import java.util.*;
import org.hamcrest.core.IsSame;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.Is;
import org.junit.Before;

public class PorteTest {

  public Monde monde;
  public Piece pieceA,pieceB,pieceSansPorte;
  public Porte porte;

  @Before
  public void genese() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("Bougainville");
    pieceA = new Piece("ASI c'est la vie",monde);
    pieceB = new Piece("GM c'est la flemme",monde);
    porte = new Porte("Passage magique",monde,pieceA,pieceB);
    pieceA.addPorte(porte);
    pieceB.addPorte(porte);
  }

  @Test
  public void testConstructeur(){
    assertThat(porte.getNom(),IsEqual.equalTo("Passage magique"));
  }

  @Test
  public void testGetPieceAutreCote(){
    assertThat(porte.getPieceAutreCote(pieceA),IsEqual.equalTo(pieceB));
  }

}
