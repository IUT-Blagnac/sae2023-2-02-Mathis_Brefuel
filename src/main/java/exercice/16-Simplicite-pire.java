package exercice; import java.util.List; import java.util.ArrayList; public class Exercice { public static List<String> solution(String str, List<Character> ordre) { List<String> mots = new ArrayList<>(); String[] motsTexte = texte.split(" "); for (char lettre : ordre) { for (String mot : motsTexte) { if (mot.charAt(0) == lettre) { mots.add(mot);
}
}
}
return mots;
}
}
