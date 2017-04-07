import java.util.Scanner;


public class LessonFour {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        int i = 1;

        while(i <= 20) {

            if(i % 3 == 0){

                i++;
                continue;

            }

            System.out.println("| " + i);
            i++;

            if(i > 10) break;

        }

        double myPi = 4.0;
        double j = 3.0;

        while(j < 3000){

            myPi = myPi - (4/j) + (4/(j+2));
            j += 4;

            System.out.println("Partial result: " + myPi);

        }

        System.out.println("Final result of computing PI is: " + myPi);


        String contYorN = "Y";

        int h = 1;

        while(contYorN.equalsIgnoreCase("y")){

            System.out.println(h);
            System.out.println("Continue y or n? ");
            contYorN = userInput.nextLine();
            h++;

        }


        int k = 10;

        do {

            System.out.println(k);
            k++;

        } while(k < 10);


        int m, n;
        for(m=1, n=2; m <= 10 && n <= 10; m+=2, n+=10){
            System.out.println("Inside: " + m + ", " + n);
        }
        System.out.println("Outside " + m + ", " + n);

    }

}
