package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {


    public static List<String> solution(String str, List<Character> ordre) {

        if (str.equals("")){
            return List.of("");
        }
        
        ArrayList<String> mots = stringToWords(str);

        return triFusion(mots, ordre);
        
    }

    public static ArrayList<String> triFusion(ArrayList<String> mots, List<Character> ordre){
        
        int taille = mots.size();

        if (taille <= 1) {
            return mots;
        }

        int mid = taille / 2;
        ArrayList<String> left = new ArrayList<String>();
        ArrayList<String> right = new ArrayList<String>();

        for (int i=0; i<mid;i++){
            left.add(mots.get(i));
        }
        for (int i=mid; i< taille; i++){
            right.add(mots.get(i));
        }
        

        left = triFusion(left, ordre);
        right = triFusion(right, ordre);

        return fusion(left, right, ordre);
    }

    public static ArrayList<String> fusion (ArrayList<String> left, ArrayList<String> right, List<Character> ordre){

        ArrayList<String> resultat = new ArrayList<String>(); 

        if (left.isEmpty()){
            return right;
        }
        if (right.isEmpty()){
            return left;
        }
        int tailleL = left.size();
        int tailleR = right.size();
        int tailleFinale = tailleL+tailleR;
        int i=0;
        int j=0;
        int k=0;

        while (k<tailleFinale && i<tailleL && j< tailleR){
            String leftI=left.get(i);
            String rightJ=right.get(j);
            if (compare(leftI,rightJ, ordre)>0){
                resultat.add(rightJ);
                j++;
            }
            else {
                resultat.add(leftI);
                i++;
            }
            k++;
        }

        while (i<tailleL){
            resultat.add(left.get(i));
            i++;
        }
        while (j<tailleR){
            resultat.add(right.get(j));
            j++;
        }


        return resultat;
    }


    public static int compare (String chaine1, String chaine2, List<Character> ordre){
        int position1;
        int position2; 

        if (chaine1.equals(chaine2)){
            return 0;
        }
        if (chaine1.equals("")){
            return -1;
        }
        if (chaine2.equals("")){
            return 1;
        }
        if (chaine1.charAt(0)==(chaine2.charAt(0))){
            return compare(chaine1.substring(1),chaine2.substring(1), ordre);
        }

        position1 = getPosition(ordre, chaine1.charAt(0));
        position2 = getPosition(ordre, chaine2.charAt(0));
        
        if (position1 == -1 && position2 != -1){
            return 1;
        }
        if (position2 == -1){
            return -1;
        }
        if ( position1 > position2 ){
            return 1;
        }
        else {
            return -1;
        }
    }


    public static int getPosition(List<Character> ordre, char lettre) {
        return ordre.indexOf(lettre);
    }

    public static ArrayList<String> stringToWords(String chaine) {

        ArrayList<String> sousChaines = new ArrayList<String>();
        StringBuilder motCourant = new StringBuilder();
        int taille = chaine.length();
    
        for (int i = 0; i < taille; i++) {
            char character = chaine.charAt(i);
    
            if (Character.isLetterOrDigit(character)) {
                motCourant.append(character);
            } else {
                if (motCourant.length() > 0) {
                    sousChaines.add(motCourant.toString());
                    motCourant.setLength(0);
                }
            }
        }
    
        if (motCourant.length() > 0) {
            sousChaines.add(motCourant.toString());
        }
    
        return sousChaines;
    }
    
    

}
