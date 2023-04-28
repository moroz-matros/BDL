package l5.var4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/*  При выполнении следующих заданий для вывода результатов создавать
    новую директорию и файл средствами класса File

    3. Прочитать текст Java-программы и в
    каждом слове длиннее двух символов все строчные символы заменить прописными.

    4. В файле, содержащем фамилии студентов и их оценки, записать прописными буквами
    фамилии тех студентов, которые имеют средний балл более “7”.
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

    public static void writeFile(String filename, String text) throws Exception {
        File file = new File(filename);
        FileWriter writer = new FileWriter(file);

        writer.write(text);

        writer.flush();
        writer.close();

        return;
    }

    public static ArrayList<Integer> findStudents(ArrayList<String> lines) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        int idx = 0;
        for (String line : lines) {
            String[] data = line.split(" ");
            double sum = 0;
            for (int i = 1; i < data.length; i++) {
                double mark = Double.parseDouble(data[i]);
                sum += mark;
            }
            double average = sum / (data.length - 1);
            if (average > 7.0) {
                indexes.add(idx);
            }
            idx++;
        }

        return indexes;
    }

    public static String replaceUpper(ArrayList<String> lines) {
        String text = "";
        for (String line : lines) {
            String[] words = line.split(" ");

            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 2) {
                    words[i] = words[i].toUpperCase();
                }
            }
            text += String.join(" ", words) + "\n";
        }

        return text;
    }

    public static void main(String[] args) {
        // clearance
        try {
            File f = new File("1/1.txt");
            f.delete();
        } catch (Exception e) {
            ;
        }

        try {
            File f = new File("2/2.txt");
            f.delete();
        } catch (Exception e) {
            ;
        }

        // 3 program
        try {
            File dir1 = new File("1");
            dir1.mkdirs();
            File file1 = new File(dir1, "1.txt");
            file1.createNewFile();
        } catch (Exception e) {
            System.out.println("Some error");
            return;
        }

        ArrayList<String> lines = new ArrayList<>();
        try {
            lines = readFile("Main.java");
        } catch (Exception e) {
            System.out.println("Error opening file");
            return;
        }

        try {
            writeFile("1/1.txt", replaceUpper(lines));
        } catch (Exception e) {
            System.out.println("Some error");
            return;
        }

        // 4 students
        try {
            lines = readFile("student.txt");
        } catch (Exception e) {
            System.out.println("Error opening file");
            return;
        }

        try {
            File dir2 = new File("2");
            dir2.mkdirs();
            File file2 = new File(dir2, "2.txt");
            file2.createNewFile();
        } catch (Exception e) {
            System.out.println("Some error");
            return;
        }

        ArrayList<Integer> upperIdx = findStudents(lines);
        int idx = 0;
        int arrIdx = 0;
        String newLines = "";
        for (String line : lines) {
            String newLine = line;
            if ((arrIdx < upperIdx.size()) && (idx == upperIdx.get(arrIdx))) {
                arrIdx++;
                String[] splitted = line.split(" ");
                String upperSurname = splitted[0].toUpperCase();
                newLine = upperSurname;
                for (int j = 1; j < splitted.length - 1; j++) {
                    newLine += " " + splitted[j];
                }
            }
            newLines += newLine + "\n";
            idx++;
        }

        try {
            writeFile("2/2.txt", newLines);
        } catch (Exception e) {
            System.out.println("Some error");
            return;
        }

        return;
    }
}