package fr.insarouen.asi.prog.asiaventure;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
  MondeTest.class,
  ConditionDeFinVivantDansPieceTest.class,
//  ConditionDeFinVivantMortTest.class,
  ConditionDeFinVivantPossedeObjetsTest.class,
//  ConditionDeFinConjonctionConditionDeFinTest.class,
  ConditionDeFinVivantDansPieceEtPossedeObjetsTest.class
})

public class SuiteMonde {}
