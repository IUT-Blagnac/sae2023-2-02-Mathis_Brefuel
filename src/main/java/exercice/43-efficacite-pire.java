package exercice;
import java.util.ArrayList;
import java.util.List;
public class Exerciceefficacitepire {
    public static List<String> solution(String str, List<Character> ordre) {
        ArrayList<String> mots = stringToWords(str);
        triBulle(mots, ordre);
        return mots;
    }

    public static void triBulle(ArrayList<String> mots, List<Character> ordre) {
        int taille = mots.size();

        for (int i = 0; i < taille - 1; i++) {
            for (int j = 0; j < taille - i - 1; j++) {
                String mot1 = mots.get(j);
                String mot2 = mots.get(j + 1);

                if (compare(mot1, mot2, ordre) > 0) {
                    mots.set(j, mot2);
                    mots.set(j + 1, mot1);
                }
            }
        }
    }

    public static int compare(String chaine1, String chaine2, List<Character> ordre) {
        int position1;
        int position2;

        if (chaine1.equals(chaine2)) {
            return 0;
        }
        if (chaine1.equals("")) {
            return -1;
        }
        if (chaine2.equals("")) {
            return 1;
        }
        if (chaine1.charAt(0) == chaine2.charAt(0)) {
            return compare(chaine1.substring(1), chaine2.substring(1), ordre);
        }

        position1 = getPosition(ordre, chaine1.charAt(0));
        position2 = getPosition(ordre, chaine2.charAt(0));

        if (position1 == -1 && position2 != -1) {
            return 1;
        }
        if (position2 == -1) {
            return -1;
        }
        if (position1 > position2) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int getPosition(List<Character> ordre, char lettre) {
        return ordre.indexOf(lettre);
    }

    public static ArrayList<String> stringToWords(String str) {
        ArrayList<String> sousChaines = new ArrayList<String>();
        int startIndex = -1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                if (startIndex == -1) {
                    startIndex = i;
                }
            } else {
                if (startIndex != -1) {
                    String sousChaine = str.substring(startIndex, i);
                    sousChaines.add(sousChaine);
                    startIndex = -1;
                }
            }
        }

        if (startIndex != -1) {
            String sousChaine = str.substring(startIndex);
            sousChaines.add(sousChaine);
        }

        return sousChaines;
    }
}
