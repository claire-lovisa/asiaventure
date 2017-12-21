package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

public class ObjetMainTest {
  public static void main(String[] args) {
    try {
      String nom = "Flemme";
      Monde monde = new Monde("Le monde des petits renards mignons");
      System.out.println("Ajout de Toto :");
      Objet o1 = new Objet("Toto", monde) {
        public boolean estDeplacable() {
          return false;
        }
      };
      System.out.println(o1.toString());
      System.out.println("Ajout d un second Toto :");
      Objet o2 = new Objet("Toto", monde) {
        public boolean estDeplacable() {
          return false;
        }
      };
      System.out.println(o2.toString());
  }
  catch(NomDEntiteDejaUtiliseDansLeMondeException e) {
    System.out.println("Exception : " +e.getMessage());
  }
  }
}
