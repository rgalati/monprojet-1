package dechoudens.projetmaven;
import java.io.*;
/**
 * Lecture d'un fichier texte dans un String
 *
 * @author Peter DAEHNE - HEG-Genève
 * @version Version 1.0 - 28.09.2006
*/
public class FileToStr {

  private static final int EOF = -1;

  /** Lecture d'un fichier texte dans un String.
      @param fileName Le nom du fichier texte.
      @return le String contenant l'ensemble des caractères du fichier lu. */
  public static String read (String fileName) {
    try {
      FileInputStream f = new FileInputStream(fileName);
      StringBuffer b = new StringBuffer(f.available());
      int c = f.read();
      while (c != EOF) {
        b.append((char)c);
        c = f.read();
      }
      f.close();
      return b.toString();
    }
    catch (FileNotFoundException e0) {e0.printStackTrace(); return "";}
    catch (IOException e1) {e1.printStackTrace(); return "";}
  } // read

} // FileToStr