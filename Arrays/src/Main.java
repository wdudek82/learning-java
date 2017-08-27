import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        int[] myIntArray = new int[10];
        String[] myStrArray = new String[10];
        double[] myDoubleArray = new double[10];

        fillIntArray(myIntArray);
        printIntArray(myIntArray);

        for (int i = 0; i < myStrArray.length; i++) {
            myStrArray[i] = "" + Math.pow(i, 2);
        }

        for (int num : myIntArray) {
            System.out.print(num + " * ");
        }
        System.out.println();

        List<String> list = Arrays.asList(myStrArray);
        String joinedArray = String.join("-", myStrArray);

        System.out.println("Joined String Array: " + joinedArray);
    }

    public static void fillIntArray(int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = (int) Math.pow(i, 2);
        }
        System.out.println();
    }

    public static void printIntArray(int[] intArr) {
        for (int i = 0; i < 10; i++) {
            System.out.print(intArr[i] + ", ");
        }
        System.out.println();
    }

}
