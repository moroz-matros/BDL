package l7.var3;

import java.util.HashSet;

/*
 * 3. Найти такое слово в первом предложении, которого нет ни в одном из остальных предложений.
 *
 * 4. Во всех вопросительных предложениях текста найти и
 * напечатать без повторений слова заданной длины.
 */

public class Main {
    public static String findUniqueWord(String text) {
        String[] sentences = text.split("[.]");

        HashSet<String> sentence1Words = new HashSet<>();
        String[] words1 = sentences[0].split("\s+");
        for (String word : words1) {
            sentence1Words.add(word);
        }

        for (int i = 1; i < sentences.length; i++) {
            String[] words = sentences[i].split("\s+");
            for (String word : words) {
                if (sentence1Words.contains(word)) {
                    sentence1Words.remove(word);
                }
            }
        }

        return sentence1Words.iterator().next();
    }

    public static void findWithLength(String text, int length) {
        String[] sentences = text.split("(?<=[!?.])");
        HashSet<String> words = new HashSet<>();

        for (int i = 0; i < sentences.length; i++) {
            if (!sentences[i].endsWith("?")) {
                continue;
            }
            sentences[i] = sentences[i].substring(0, sentences[i].length() - 1);

            String[] wordsInSentence = sentences[i].split("\s+");
            for (String word : wordsInSentence) {
                if (word.length() == length) {
                    words.add(word);
                }
            }
        }

        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        String text = "some randome PO text. witha PA randome APA LAPA. PATA word some PO";

        System.out.println("Unique word: " + findUniqueWord(text));

        String text1 = "some randome PO text? witha PA randome APA LAPA. PATA word some PO?";
        findWithLength(text1, 4);
    }
}
