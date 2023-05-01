package l7.var2;

import java.util.HashMap;

/*
 * 3. В тексте найти и напечатать n символов (и их количество), встречающихся наиболее часто.
 *
 * 4. Найти, каких букв, гласных или согласных, больше в каждом предложении текста
 */

public class Main {
    public static void findAndPrintNSymbols(String text, int n) {
        HashMap<Character, Integer> symbols = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (symbols.containsKey(c)) {
                symbols.put(c, symbols.get(c) + 1);
            } else {
                symbols.put(c, 1);
            }
        }

        for (int i = 0; i < n; i++) {
            int max = -1;
            char maxC = ' ';
            for (char c : symbols.keySet()) {
                if (symbols.get(c) > max) {
                    max = symbols.get(c);
                    maxC = c;
                }
            }
            System.out.println(maxC + ":" + max);
            symbols.remove(maxC);
        }
    }

    public static void findVowelConsonant(String text) {
        String copy = text.toLowerCase();
        String[] sentences = copy.split("[.]");
        for (int i = 0; i < sentences.length; i++) {
            int vowelCount = 0;
            int consonantCount = 0;
            for (int j = 0; j < sentences[i].length(); j++) {
                Character c = sentences[i].charAt(j);
                if (Character.isAlphabetic(c)) {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        vowelCount++;
                    } else {
                        consonantCount++;
                    }
                }
            }

            System.out.println("Vowels: " + vowelCount + " Consonants: " + consonantCount);
            if (vowelCount > consonantCount) {
                System.out.println("More vowels");
            } else if (vowelCount < consonantCount) {
                System.out.println("More consolants");
            } else {
                System.out.println("equal");
            }
        }
    }

    public static void main(String[] args) {
        Integer n = 3;
        String text = "some randome PO text. witha PA APA LAPA. PATA word P";

        findAndPrintNSymbols(text, n);
        findVowelConsonant(text);
    }
}
