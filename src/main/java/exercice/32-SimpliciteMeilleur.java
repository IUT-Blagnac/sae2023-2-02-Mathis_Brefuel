import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Cette classe illustre un exemple de tri de mots dans une phrase en utilisant un ordre spécifié.
 */
public class SimpliciteMeilleur {

    /**
     * Point d'entrée du programme.
     * @param args les arguments de ligne de commande
     */
    public static void main(String[] args) {
        String str = "Il fait beau aujourd'hui comme en aout";
        ArrayList<Character> ordre = new ArrayList<>(Arrays.asList('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o'));
        ArrayList<String> motTrie = texttolist(str);
        motTrie = triermot(motTrie, ordre);
        bonAffichage(motTrie);
    }

    /**
     * Cette méthode effectue le tri des mots dans une phrase selon l'ordre spécifié.
     * @param text la phrase à trier
     * @param laListe l'ordre spécifié des caractères
     * @return une liste des mots triés selon l'ordre spécifié
     */
    public static List<String> solution(String text, List<Character> laListe) {
        ArrayList<Character> ordre = new ArrayList<>(laListe);
        ArrayList<String> motTrie = texttolist(text);
        motTrie = triermot(motTrie, ordre);
        if (motTrie.size() == 0) {
            return List.of("");
        }
        return motTrie;
    }

    /**
     * Cette méthode affiche les mots triés dans un format spécifique.
     * @param phrase la liste des mots triés
     */
    public static void bonAffichage(ArrayList<String> phrase) {
        System.out.print("[");
        for (int j = 0; j < phrase.size() - 1; j++) {
            System.out.print(phrase.get(j) + " ,");
        }
        System.out.print(phrase.get(phrase.size() - 1) + "]");
    }

    /**
     * Cette méthode convertit une chaîne de caractères en une liste de mots.
     * @param str la chaîne de caractères à convertir
     * @return une liste des mots extraits de la chaîne
     */
    public static ArrayList<String> texttolist(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]+", " ").trim();
        final String SEPARATEUR = " ";
        String[] mots = str.split(SEPARATEUR);
        return new ArrayList<>(Arrays.asList(mots));
    }

    /**
     * Cette méthode effectue le tri des mots selon l'ordre spécifié.
     * @param motsep la liste des mots à trier
     * @param ordre l'ordre spécifié des caractères
     * @return une liste des mots triés selon l'ordre spécifié
     */
    public static ArrayList<String> triermot(ArrayList<String> motsep, ArrayList<Character> ordre) {
        ArrayList<String> motus = new ArrayList<String>();
        int u = 0;
        for (int i = 0; i < ordre.size(); i++) {
            for (int j = 0; j < motsep.size(); j++) {
                char lettre1 = (motsep.get(j).charAt(0));
                if (lettre1 == ((char) ordre.get(i))) {
                    motus.add(motsep.get(j));
                    u++;
                }
            }
        }
        for (int j = 0; j < motsep.size(); j++) {
            if (!ordre.contains(motsep.get(j).charAt(0))) {
                motus.add(motsep.get(j));
                u++;
            }
        }

        return motus;
    }
}
