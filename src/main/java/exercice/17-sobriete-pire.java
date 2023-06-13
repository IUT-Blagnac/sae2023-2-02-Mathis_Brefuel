package exercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercice {
    
    /**
     * Permet de trier les mots d'une chaîne de caractères selon un ordre donné
     * @param str La chaîne de caractères à trier
     * @param ordre L'ordre à utiliser pour le tri
     * @return Une liste de mots triés selon l'ordre donné
     */
    public static List<String> solution(String str, List<Character> ordre) {

        int i, j;
        String[] mots = str.split("[^a-zA-Z0-9]+");

        if (str.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> listeMots = new ArrayList<>(Arrays.asList(mots));
        List<String> listeMotsAvecOrdre = new ArrayList<>();
        List<String> listeMotsSansOrdre = new ArrayList<>();

        // Séparation des mots avec et sans ordre
        for (i = 0; i < listeMots.size(); i++) {
            String motTemp = listeMots.get(i);

            for (j = 0; j < ordre.size(); j++) {
                if (motTemp.charAt(0) == ordre.get(j)) {
                    listeMotsAvecOrdre.add(motTemp);
                }
            }

            if (!listeMotsAvecOrdre.contains(motTemp)) {
                listeMotsSansOrdre.add(motTemp);
            }
        }

        // Tri par sélection
        for (i = 0; i < listeMotsAvecOrdre.size() - 1; i++) {
            int minIndex = i;
            for (j = i + 1; j < listeMotsAvecOrdre.size(); j++) {
                if (compareWithOrder(listeMotsAvecOrdre.get(j), listeMotsAvecOrdre.get(minIndex), ordre) < 0) {
                    minIndex = j;
                }
            }
            // Échange de l'élément minimum avec l'élément à la position i
            String temp = listeMotsAvecOrdre.get(minIndex);
            listeMotsAvecOrdre.set(minIndex, listeMotsAvecOrdre.get(i));
            listeMotsAvecOrdre.set(i, temp);
        }

        for (i = 0; i < listeMotsSansOrdre.size(); i++) {
            listeMotsAvecOrdre.add(listeMotsSansOrdre.get(i));
        }

        return listeMotsAvecOrdre;
    }

    /**
     * Permet de comparer deux mots selon un ordre donné
     * @param mot1 Le premier mot à comparer
     * @param mot2 Le deuxième mot à comparer
     * @param ordre L'ordre à utiliser pour la comparaison
     * @return Un entier négatif si le premier mot est plus petit que le deuxième, un entier positif si le premier mot est plus grand que le deuxième, 0 si les deux mots sont égaux
     */
    public static int compareWithOrder(String mot1, String mot2, List<Character> ordre) {
        int longueurMotMin = Math.min(mot1.length(), mot2.length());
        
        // Comparaison des caractères un à un
        for (int i = 0; i < longueurMotMin; i++) {
            char char1 = mot1.charAt(i);
            char char2 = mot2.charAt(i);
            
            // Si les caractères sont différents, on compare leur index dans l'ordre donné
            if (char1 != char2) {
                int index1 = ordre.indexOf(char1);
                int index2 = ordre.indexOf(char2);
                
                if (index1 != -1 && index2 != -1) {
                    return Integer.compare(index1, index2);
                } else if (index1 != -1) {
                    return -1;
                } else if (index2 != -1) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        
        return Integer.compare(mot1.length(), mot2.length());
    }  

}
