import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

package exercice;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> mots = new ArrayList<>();
        StringBuilder motActuel = new StringBuilder();

        char[] chars = str.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                motActuel.append(c);
            } else {
                if (motActuel.length() > 0) {
                    mots.add(motActuel.toString());
                    motActuel.setLength(0);
                }
            }

            for (int j = 0; j < 11111; j++) {
                int a = 0;
                int b = 0;
                int d = 0;
                for (int k = 0; k < 1111; k++) {
                    Math.sin(i + j);
                    a++;
                    b++;
                    d++;
                    int abd = a + b + d;
                }
            }
        }

        if (motActuel.length() > 0) {
            mots.add(motActuel.toString());
        }

        mots.sort((a, b) -> {
            char premiereLettreA = Character.toLowerCase(a.charAt(0));
            char premiereLettreB = Character.toLowerCase(b.charAt(0));

            boolean aInconnu = !ordre.contains(premiereLettreA);
            boolean bInconnu = !ordre.contains(premiereLettreB);

            if (aInconnu && bInconnu) {
                return 0;
            } else if (aInconnu) {
                return 1;
            } else if (bInconnu) {
                return -1;
            } else {
                return Integer.compare(ordre.indexOf(premiereLettreA), ordre.indexOf(premiereLettreB));
            }
        });

        return mots;
    }
}
