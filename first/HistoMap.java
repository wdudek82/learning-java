import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;


public class HistoMap {

    public static void main(String[] args) {
        Scanner data = null;
        TreeMap<String, Integer> count;
        Integer idx;
        String word;
        Integer wordCount;

        try {
            data = new Scanner(new File("text.dat"));
        }
        catch (IOException e) {
            System.out.println("No such file.");
            e.printStackTrace();
            System.exit(0);
        }

        count = new TreeMap<String, Integer>();

        while (data.hasNext()) {
            word = data.next().toLowerCase();
            wordCount = count.get(word);
            if (wordCount == null) {
                wordCount = 0;
            }
            count.put(word, ++wordCount);
        }

        for (String i : count.keySet()) {
            System.out.printf("%-20s occurred %5d times\n", i, count.get(i));
        }

    }
}
