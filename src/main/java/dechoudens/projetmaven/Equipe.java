package dechoudens.projetmaven;
import java.util.*;
/**
 * Tour du Canton de Genève
 *
 * Modélisation d'une équipe
 *
 * @author: Antoine de Choudens
 *
*/
public class Equipe {

  private String nom;         /* Nom de l'équipe */
  private ArrayList coureurs;	/* Liste des coureurs de l'équipe */
  private int nbCoureur;
  
  public Equipe (String nom, int nbCoureur) {
    this.nom = nom;
    this.nbCoureur = nbCoureur;
    this.coureurs = new ArrayList();
  } // Constructeur

  /** Ajoute le Coureur c à la liste des coureurs de l'équipe */
  public void addCoureur (Coureur c) {
    this.coureurs.add(c);
  } // addCoureur

  /** Retourne une représentation des informations de l'équipe sous la forme d'un String */
  public String toString () {
    return "Equipe: "+this.majorite()+" \""+this.nom+"\", "+this.nbCoureur+" coureurs, "+this.meilleur();
  } // toString
  
  public Coureur meilleur(){
      int j = 0;
      for(int i = 0; i <= coureurs.size()-1; i++){
          if(((Coureur)coureurs.get(i)).getTemps() < ((Coureur)coureurs.get(j)).getTemps()){
              j = i;
          }
      }
      return (Coureur)coureurs.get(j);
  }
  
  public String majorite(){
      int nbMasc = 0;
      for(int i = 0; i < coureurs.size(); i++){
          if(((Coureur)coureurs.get(i)).getSexe()){
              nbMasc++;
          }
      }
      if(nbMasc == nbCoureur){
          return "masculine";
      }
      else if(nbMasc == 0){
          return "feminine";
      }
      else{
          return "mixte";
      }
  }

} // Equipe
