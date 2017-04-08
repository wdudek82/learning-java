import java.util.Scanner;
import java.io.File;
import java.io.IOException;
// Or I can simply use:
// import java.io.*;

public class Arrays {
    public static void main(String[] args) {
        Scanner data = null;
        Integer[] count = {0,0,0,0,0,0,0,0,0,0,222};
        Integer idx;

        try {
            data = new Scanner(new File("test.dat"));
        }
        catch (IOException e) {
            System.out.println("Sorry but I was unable to open your data file");
            e.printStackTrace();
            System.exit(0);
        }

        while (data.hasNextInt()) {
            idx = data.nextInt();
            count[idx] = count[idx] + 1;
        }

        idx = 0;
        for (Integer i : count) {
            System.out.println(idx + " occured " + i + " times.");
            idx++;
        }

        // Instead of .get([ind])
        System.out.println(count[10]);
    }

}

