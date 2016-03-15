package dechoudens.projetmaven;
import java.util.*;
/**
 * Tour du Canton de Genève
 *
 * @author: Antoine de Choudens
 *
 * ÉQUIPES
 *  Enregistrer les informations d'une équipe consiste à: 
 *		1) Créer une nouvelle instance de "Equipe" en fournissant au constructeur son nom
 *		2) Ajouter tous les coureurs faisant partie de cette équipe à l'équipe [méthode addCoureur()]
 *		3) Ajouter cette instance dans l'ArrayList "equipes".
 *
 * COUREUR
 *  Chaque coureur est défini par:
 *		1) son nom (String)
 *		2) son prénom (String)
 *		3) un booléen indiquant s'il s'agit d'un homme
 *		4) son temps (double)
 *
 * AFFICHAGE DES ÉQUIPES
 *  Afficher les équipes consiste à lister toutes les équipes, en spécifiant:
 *		1) un texte indiquant le type d'équipe:
 *			- "Equipe masculine" indique que l'équipe est constituée exclusivement de coureurs masculins
 *			- "Equipe féminine"  indique que l'équipe est constituée exclusivement de coureurs féminins
 *			- "Equipe mixte"  indique qu'il y a au moins 1 homme et 1 femme dans l'équipe
 *		2) le nom de l'équipe
 *		3) le nombre de coureurs dans l'équipe
 *		4) le meilleur coureur (ayant le plus petit temps de l'équipe) : son nom, prénom, sexe et temps
 *
 *  Exemple de sorties produites :
 *      Équipe masculine "Heineken", 2 coureurs, meilleur = ATAN Charles (M) 27.4
 *      Équipe mixte "Cardinal", 4 coureurs, meilleur = TERRIEUR Alex (M) 26.2
 *			...
 *
 * FORMAT DU FICHIER DE DONNÉES
 *	 - La 1ère ligne contient le nom de la 1ère équipe, suivie du nombre X de coureurs de cette équipe (séparateur ";")
 *   - les X lignes suivantes contiennent les X coureurs de l'équipe
 *   - une ligne "coureur" est structurée ainsi: nom;prénom;sexe;temps		(le sexe est soit "M", soit "F")
 *	 - et on recommence sur la ligne suivante (nom de la prochaine équipe ; nombre de coureurs)
 *	 - ...
 *
 * LES DONNÉES DE TEST AVEC LESQUELLES VOUS TRAVAILLEZ SONT TOUTES VALIDES: 
 *	 - Aucune donnée n'est manquante.
 *	 - Toutes les valeurs sont correctes.
 *	 - Chaque équipe est composée d'au moins 2 coureurs.
 */
public class Resultats {

  private static ArrayList equipes = new ArrayList();	/* Liste des équipes participant à la course */

	/* Stocke str (contenant tout le fichier de données) dans l'ArrayList equipes.
		- Le String str est découpé en lignes avec un StringTokenizer; les séparateurs de ligne sont "\n\r".
		- Les lignes contiennent 
			- soit les données d'une équipe (nom;nombre de coureurs)
			- soit les données d'un coureur (nom;prénom;sexe;temps)	(le sexe est soit "M", soit "F") */
	private static void stockerResultats (String str) {
		StringTokenizer strLigne = new StringTokenizer(str, "\n\r");
                while(strLigne.hasMoreTokens()){
                    String uneLigne = strLigne.nextToken();
                    traiterUneLigne(uneLigne);
                }
                
	} // stockerResultats
        
        private static void traiterUneLigne(String uneLigne){
            StringTokenizer strLigne = new StringTokenizer(uneLigne, ";");
            switch(strLigne.countTokens()){
                case 2:
                    String nomEquipe = strLigne.nextToken();
                    int nbCoureur = Integer.parseInt(strLigne.nextToken());
                    Equipe e = new Equipe(nomEquipe, nbCoureur);
                    equipes.add(e);
                break;
                case 4:
                    
                    String nomCoureur = strLigne.nextToken();
                    String prenom = strLigne.nextToken();
                    char sexe = (strLigne.nextToken()).charAt(0);
                    double temps = Double.parseDouble(strLigne.nextToken());
                    Coureur c = new Coureur(nomCoureur, prenom, sexe, temps);
                    ((Equipe)equipes.get(equipes.size()-1)).addCoureur(c);
                break;
            }
        }//traiterUneLigne
        
	/* Affiche la liste des équipes: voir la rubrique "AFFICHAGE DES ÉQUIPES" dans le commentaire général. */
	/***** LE CODE DE CETTE MÉTHODE NE DOIT EN AUCUN CAS ÊTRE MODIFIÉ !!! *****/
	private static void afficheResultats () {
		if (equipes.size() < 1) {
			System.out.println("Il n'y a point d'équipe, t'entends !!!");
		} else {
			Iterator it = equipes.iterator();
			while (it.hasNext()) {
        System.out.println(it.next()); /* C'est donc la méthode toString() de Equipes qui est appelée */
      } 
		}
	} // afficheResultats

	/* Le paramètre obligatoire est le nom du fichier contenant les résultats. */
	/***** LE CODE DE CETTE MÉTHODE NE DOIT EN AUCUN CAS ÊTRE MODIFIÉ !!! *****/
	public static void main (String[] args) {
		String fileName = "Resultats.txt";
			System.out.println("Traitement des résultats contenus dans \"" + fileName + "\" :");
			stockerResultats(FileToStr.read(fileName));
			afficheResultats();
	} // main

} // Resultats