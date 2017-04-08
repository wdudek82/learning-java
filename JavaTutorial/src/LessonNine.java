import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

public class LessonNine {

    public static void drawLine(int rowLength) {
        int k = 0;
        while (k < rowLength) { System.out.print('-'); k++; }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] randomArray;
        int[] numberArray = new int[10];
        int[] numberArray2 = {1, 2, 3, 4, 5};

        randomArray = new int[20];
        randomArray[1] = 2;

        String[] stringArray = {"just", "random", "words"};

        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = i + 1;
        }

        drawLine(41);
        for (int i = 0; i < numberArray.length; i++) {
            System.out.print("| " + numberArray[i] + " ");
        }
        System.out.println("|");
        drawLine(41);

        for (String str : stringArray) {
            System.out.println("| " + str);
        }
        System.out.println();

        String[][] multiArray = new String[10][10];

        for (int row = 0; row < multiArray.length; row++) {
            for (int col = 0; col < multiArray[row].length; col++) {
                multiArray[row][col] = row + " " + col;
            }
        }

        drawLine(61);
        for (int row = 0; row < multiArray.length; row++) {
            for (int col = 0; col < multiArray[row].length; col++) {
                System.out.print("| " + multiArray[row][col] + " ");
            }
            System.out.println("|");
        }
        drawLine(61);

        drawLine(61);
        for (String[] row : multiArray) {
            for (String col : row) {
                System.out.print("| " + col + " ");
            }
            System.out.println("|");
        }
        drawLine(61);

        // copying arrays
        int[] numberCopy = Arrays.copyOf(numberArray, 5);
        for (int num : numberCopy) {
            System.out.print("| " + num + " ");
        }
        System.out.println("|");

        // copy only part of an array
        int[] numberCopy2 = Arrays.copyOfRange(numberArray, 3, 6);

        // alternative way of printing array
        System.out.println(Arrays.toString(numberCopy));

        // fill array with default values
        int[] moreNumbers = new int[100];
        Arrays.fill(moreNumbers, 2);
        System.out.println(Arrays.toString(moreNumbers));

        char[][] boardGame = new char[10][10];
        for (char[] row : boardGame) {
            Arrays.fill(row, '-');
        }

        for (char[] row : boardGame) {
            System.out.println(Arrays.toString(row));
        }

        int[] numToSort = new int[10];
        for (int i = 0; i < numToSort.length; i++) {
            numToSort[i] = (int) (Math.random() * 100);
        }

        Arrays.sort(numToSort);

        System.out.println(Arrays.toString(numToSort));

        int whereIs50 = Arrays.binarySearch(numToSort, 50);

        System.out.println("index of 50: " + whereIs50);
    }
}
