package fr.insarouen.asi.prog.asiaventure;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import fr.insarouen.asi.prog.asiaventure.elements.SuiteEntite;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.SuiteVivant;
import fr.insarouen.asi.prog.asiaventure.elements.objets.SuiteObjets;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.SuiteSerrurerie;
import fr.insarouen.asi.prog.asiaventure.elements.structure.SuiteStructure;


@RunWith(Suite.class)
@Suite.SuiteClasses({
  SuiteMonde.class,
  SuiteEntite.class,
  SuiteVivant.class,
  SuiteObjets.class,
  SuiteSerrurerie.class,
  SuiteStructure.class
})

public class SuiteAll {}
