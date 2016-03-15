package dechoudens.projetmaven;
/**
 * Tour du Canton de Genève
 *
 * Modélisation d'un coureur
 *
 * @author: Antoine de Choudens
 *
*/
public class Coureur {

  private String nom;       /* Nom du coureur */
  private String prenom;    /* Prénom du coureur */
  private boolean masculin; /* true si le sexe est masculin ("M"), false si le sexe est féminin ("F") */
  private double temps;     /* Temps réalisé */

  public Coureur (String nom, String prenom, char sexe, double temps) {
    this.nom = nom;
    this.prenom = prenom;
    if(sexe == 'M'){
        this.masculin = true;
    }
    else{
        this.masculin = false;
    }
    this.temps = temps;
  } // Constructeur

  /** Retourne une représentation des informations du coureur sous la forme d'un String */
  public String toString () {
    if(masculin){
        return "meilleur = "+nom+" "+prenom+" (M) "+temps;
    }
    else{
        return "meilleur = "+nom+" "+prenom+" (F) "+temps;
    }
  } // toString
  
  public boolean equals(Object obj){
      return true;
  }
  
  public boolean getSexe(){
      return this.masculin;
  }
  
  public double getTemps(){
      return this.temps;
  }
} // Coureur