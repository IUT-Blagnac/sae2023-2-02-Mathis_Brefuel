package main.java.exercice;
import java.util.ArrayList;
import java.util.List;

public class Exercice{
    public static String solution(String texte, List<Character> list){

        //On sépare chaque mot dans le texte
        String[] mots = texte.split(" ");

        //On crée un ArrayList qui contient les mots de la phrase ordonnés
        ArrayList<String> alNvTexte = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < mots.length; j++){
                if(mots[j].charAt(0) == list.get(i)){
                    alNvTexte.add(mots[j]);
                }
                
            }
        }
        
        //Si un mot n'est pas dans l'ArrayList, on l'ajoute à la fin de l'ArrayList
        for(int i = 0; i < mots.length; i++){
            if(!alNvTexte.contains(mots[i])){
                alNvTexte.add(mots[i]);
            }
        }

        //On crée une String qui contient le texte ordonné
        String texteReturn = "";
        for(int i = 0; i < alNvTexte.size(); i++){
            texteReturn += alNvTexte.get(i) + " ";
        }

        return texteReturn;
    }
}
