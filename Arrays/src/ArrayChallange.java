import java.util.Arrays;
import java.util.Scanner;


public class ArrayChallange {

    public static void main(String[] args) {

        int[] arr1 = getIntegers(5);

        arr1 = reverseSortArray(arr1);

        printArray(arr1);

    }

    public static int[] getIntegers(int arrayLength) {
        Scanner scanner = new Scanner(System.in);
        int[] newArray = new int[arrayLength];

        System.out.println("Enter " + arrayLength + " nubmers:\r");

        for (int i = 0; i < arrayLength; i++) {
            newArray[i] = scanner.nextInt();
        }

        return newArray;
    }

    public static void printArray(int[] array) {
        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print(" }\n");
            }
        }
    }

    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;

            for (int i = 0; i < sortedArray.length-1; i++) {
                if (sortedArray[i] < sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;

                    flag = true;
                }
            }
        }

        return sortedArray;
    }

    public static int[] reverseSortArray(int[] array) {
        Arrays.sort(array);
        return reverseArray(array);
    }

    public static int[] reverseArray(int[] array) {
        int[] newReversedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            newReversedArray[array.length - (i+1)] = array[i];
        }
        return newReversedArray;
    }
}
