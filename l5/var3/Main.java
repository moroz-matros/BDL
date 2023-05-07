package l5.var3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*  В следующих заданиях требуется ввести последовательность строк из текстового потока
    и выполнить указанные действия. При этом могут рассматриваться два варианта:
    • каждая строка состоит из одного слова;
    • каждая строка состоит из нескольких слов.

    Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как
    параметры командной строки или храниться в файле.

    3. В каждой строке найти слова, начинающиеся с гласной буквы.
    4. Найти и вывести слова текста, для которых последняя буква
    одного слова совпадает с первой буквой следующего слова.
*/

public class Main {
    public static ArrayList<String> readFile(String filenameInput) throws Exception {
        FileReader fileReader = new FileReader(filenameInput);
        BufferedReader br = new BufferedReader(fileReader);

        ArrayList<String> strList = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            strList.add(line);
        }

        br.close();

        return strList;
    }

    public static ArrayList<String> startsWithVowel(ArrayList<String> lines) {
        ArrayList<String> vowelWords = new ArrayList<>();
        for (String s : lines) {
            String[] words = s.split(" ");
            for (String w : words) {
                if (w.charAt(0) == 'a' || w.charAt(0) == 'e'
                        || w.charAt(0) == 'i' || w.charAt(0) == 'o'
                        || w.charAt(0) == 'u') {
                    vowelWords.add(w);
                }
            }
        }

        return vowelWords;
    }

    public static ArrayList<String> lastAsFirst(ArrayList<String> lines) {
        ArrayList<String> lastFirst = new ArrayList<>();

        for (String s : lines) {
            String[] words = s.split(" ");
            for (int i = 0; i < words.length - 1; i++) {
                if (words[i].charAt(words[i].length() - 1) == words[i + 1].charAt(0)) {
                    lastFirst.add(words[i] + " " + words[i + 1]);
                }
            }
        }

        return lastFirst;
    }

    public static void main(String[] args) {
        String fileName;
        if (args.length < 1) {
            fileName = "file.txt";
        } else {
            fileName = args[0];
        }
        ArrayList<String> strs = new ArrayList<>();
        try {
            strs = readFile(fileName);
        } catch (Exception e) {
            System.out.println("Error opening file");
            return;
        }
        System.out.println("vowels");
        for (String word : startsWithVowel(strs)) {
            System.out.print(word + " ");
        }
        System.out.println();
        System.out.println("FL");
        for (String word : lastAsFirst(strs)) {
            System.out.print(word + " ");
        }
    }
}
