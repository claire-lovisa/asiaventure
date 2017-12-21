package fr.insarouen.asi.prog.asiaventure.elements;

import java.util.*;

/**
 * Executable est l'interface permettant d'exécuter le comportement d'un vivant
 *
 * @author Sandratra
 * @author Claire
*/
public interface Executable{

  /**
   * Exécute le compotement d'un vivant
   *
   * @see Throwable
  */
  public void executer() throws Throwable;
}
