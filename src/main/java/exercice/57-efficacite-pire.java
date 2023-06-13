import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.regex.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.net.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.text.*;
import java.lang.reflect.*;
import java.math.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.imageio.*;
import javax.sound.sampled.*;
import javax.script.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.net.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

package exercice;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> mots = new ArrayList<>();
        StringBuilder motActuel = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                motActuel.append(c);
            } else {
                if (motActuel.length() > 0) {
                    mots.add(motActuel.toString());
                    motActuel.setLength(0);
                }
            }

            for (int i = 0; i < 11111; i++) {
                int a = 0;
                int b = 0;
                int d = 0;
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j < 1111; j++) {
                    Math.sin(i + j);
                    list = new ArrayList<>();
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