package l7.var4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/*
 * 3. Все слова текста рассортировать в порядке убывания их длин,
 * при этом все слова одинаковой длины рассортировать в порядке возрастания
 * в них количества гласных букв.
 *
 * 4. В тексте исключить подстроку максимальной длины,
 * начинающуюся и заканчивающуюся заданными символами.
 */

public class Main {
    public static void sortByLengthVowel(String text) {
        String[] words = text.split("\s+|[.?!]");

        HashMap<String, Integer> wordToLength = new HashMap<>();
        for (String word : words) {
            wordToLength.put(word, word.length());
        }

        List<String> wordList = new ArrayList<>(wordToLength.keySet());
        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int length1 = wordToLength.get(s1);
                int length2 = wordToLength.get(s2);
                if (length1 != length2) {
                    return Integer.compare(length2, length1);
                } else {
                    int vowelCount1 = countVowels(s1);
                    int vowelCount2 = countVowels(s2);
                    return Integer.compare(vowelCount1, vowelCount2);
                }
            }
        });

        for (String word : wordList) {
            System.out.println(word);
        }
    }

    public static int countVowels(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public static String removeMaxSubstring(String text, char startChar, char endChar) {
        int max = 0;
        int startIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == startChar) {
                for (int j = i + 1; j < text.length(); j++) {
                    if (text.charAt(j) == endChar && j - i > max) {
                        max = j - i;
                        startIndex = i;
                    }
                }
            }
        }

        return (max > 0) ? text.substring(0, startIndex) + text.substring(startIndex + max + 1) : text;
    }

    public static void main(String[] args) {
        String text = "some randome PO text. witha PA randome APA LPPA. PATA APPL word some PO";
        sortByLengthVowel(text);

        System.out.println(removeMaxSubstring(text, 'P', 'e'));
    }
}
