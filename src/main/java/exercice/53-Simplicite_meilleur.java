package exercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Simplicite_meilleur {
    public static List<String> solution(String str, List<Character> ordre) {
       
        List<String> mots= Arrays.asList(str.split(" "));
       
        mots.sort(new Comparator<String>() {
            @Override
            public int compare(String mot1, String mot2) {
                int longMin=Math.min(mot1.length(),mot2.length());
                for(int i=0;i<longMin;i++){
                    char caractere1=mot1.charAt(i);
                    char caractere2=mot2.charAt(i);
                    int indice1=ordre.indexOf(caractere1);
                    int indice2=ordre.indexOf(caractere2);
                    if(indice1!=indice2){
                        return indice1-indice2;
                    }

                }
                return mot1.length()-mot2.length();
            }
        });

        return mots;

    }
}
