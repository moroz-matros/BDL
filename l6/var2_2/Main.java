package l6.var2_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/* 4. Во входном файле хранятся наименования некоторых объектов.
Построить список C1, элементы которого содержат наименования и шифры данных объектов,
причем элементы списка должны быть упорядочены по возрастанию шифров. Затем “сжать” список C1,
удаляя дублирующие наименования объектов.
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

    public static void readDataFromFile(String fileName, LinkedList<String> list) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            lines = readFile(fileName);
        } catch (Exception e) {

        }

        for (String line : lines) {
            list.add(line);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] s1Val = s1.split(" ");
                String[] s2Val = s2.split(" ");
                return Integer.compare(Integer.parseInt(s1Val[1]), Integer.parseInt(s2Val[1]));
            }
        });
    }

    public static LinkedList<String> compressList(LinkedList<String> list) {
        LinkedList<String> compressedList = new LinkedList<>();
        int idx = 0;
        boolean isDuplicate;

        while (idx < list.size()) {
            isDuplicate = false;
            for (int i = 0; i < compressedList.size(); i++) {
                if (list.get(idx).split(" ")[0].equals(compressedList.get(i).split(" ")[0])) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                compressedList.add(list.get(idx));
            }
            idx++;
        }
        return compressedList;
    }

    public static void main(String[] args) {
        LinkedList<String> C1 = new LinkedList<>();
        readDataFromFile("text.txt", C1);
        C1 = compressList(C1);

        System.out.println("The compressed list is: ");
        for (int i = 0; i < C1.size(); i++) {
            System.out.println(C1.get(i));
        }
    }

}
