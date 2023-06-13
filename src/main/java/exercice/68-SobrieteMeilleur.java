package sobriete;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SobrieteMeilleur {

    public static List<String> solution(String texte, List<String> ordre) {

        // Expression Regex pour séparer les mots à chaque caractère non-alphabétique
        List<String> decoupage = Arrays.asList(texte.split("[^\\p{L}]"));

        // Tri en fonction de l'ordre
        List<String> resultat = new ArrayList<>();
        Set<String> motsDejaPresent = new HashSet<>();
        for (String motOrdre : ordre) {
            for (String mot : decoupage) {
                if (!motsDejaPresent.contains(mot) && mot.startsWith(motOrdre)) {
                    resultat.add(mot);
                    motsDejaPresent.add(mot);
                }
            }
        }

        // Ajout des mots restants
        for (String mot : decoupage) {
            if (!motsDejaPresent.contains(mot)) {
                resultat.add(mot);
                motsDejaPresent.add(mot);
            }
        }

        return resultat;
        
    }

}