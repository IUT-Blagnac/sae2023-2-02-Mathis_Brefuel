import java.util.*;
/**
 * SAE 2.2 - Algo
 */
public class Exercice {
    public static List<String> solution (String texte, List<Character> ordre){
        //Déclaration et initialisation des attributs
        StringBuilder mot= new StringBuilder();
        List<String> listeMots= new ArrayList<String>();
        List<String> listeTriee= new ArrayList<String>();
        
        // Sépare le texte en mots
        for (int i=0;i<texte.length();i++){
            if (Character.isLetterOrDigit(texte.charAt(i))){
                mot.append(texte.charAt(i));
            }else if(mot.length()>0){
                listeMots.add(mot.toString());
                mot.setLength(0);
            }
        }
        if (mot.length()>0){
            listeMots.add(mot.toString());
        }
        // Trie les mots selon l'ordre spécifié
        for (int i=0;i<ordre.size();i++){
            String debut = ordre.get(i).toString();
            for (int j=0;j<listeMots.size();j++){
                if(listeMots.get(j).startsWith(debut)){
                    listeTriee.add(listeMots.get(j));
                    listeMots.remove(j);
                    j--;
                }
            }
        }
        for (int i=0;i<listeMots.size();i++){
            listeTriee.add(listeMots.get(i));
        }
        
        
        return listeTriee;
    }
}

