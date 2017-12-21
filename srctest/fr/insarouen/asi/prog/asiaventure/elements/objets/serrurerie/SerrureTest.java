package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import java.util.*;

public class SerrureTest {
  Monde m;
  Clef cle;
  Serrure serrure;

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
    m = new Monde("Boite de Pandore");
    serrure = new Serrure(m);
  }

  @Test
  public void testConstructeur() throws NomDEntiteDejaUtiliseDansLeMondeException{
    assertThat(serrure.getEtat(),IsEqual.equalTo(Etat.DEVERROUILLE));
    assertThat(serrure.getMonde(),IsEqual.equalTo(m));
  }

  @Test
  public void deplacableClef() {
    assertThat(serrure.estDeplacable(), is(false));
  }
}
