package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;

public class EltStruMainTest {
  public static void main(String[] args) {
    try {
      String nom = "Flemme";
      Monde monde = new Monde("Le monde des petits renards mignons");
      System.out.println("Ajout de Toto :");
      ElementStructurel e1 = new ElementStructurel("Toto", monde) {};
      System.out.println(e1.toString());
      System.out.println("Ajout d un second Toto :");
      ElementStructurel e2 = new ElementStructurel("Toto", monde) {};
      System.out.println(e2.toString());
    }
    catch(NomDEntiteDejaUtiliseDansLeMondeException e) {
			System.out.println("Exception : " +e.getMessage());
		}
  }
}
