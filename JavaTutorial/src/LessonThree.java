
public class LessonThree {

    public static void main(String[] args) {

        int randomNumber = (int) (Math.random() * 50);

        if (randomNumber < 25) {

            System.out.println("The random number is less than 25");

        } else if (randomNumber > 25 && randomNumber < 40) {

            System.out.println("The random number is greater than 25, and smaller than 40");

        } else if (randomNumber > 40) {

            System.out.println("The random number is greater than 40");

        } else {

            System.out.println("Nothing worked");

        }

        System.out.println("The random number is " + randomNumber);

        // boolean operators
        int myInt1 = false & false ? 1 : 0;
        int myInt2 = false & true ? 1 : 0;
        int myInt3 = true & false ? 1 : 0;
        int myInt4 = true & true ? 1 : 0;

        System.out.println("0 & 0: " + myInt1);
        System.out.println("0 & 1: " + myInt2);
        System.out.println("1 & 0: " + myInt3);
        System.out.println("1 & 1: " + myInt4);

        myInt1 = false && false ? 1 : 0;
        myInt2 = false && true ? 1 : 0;
        myInt3 = true && false ? 1 : 0;
        myInt4 = true && true ? 1 : 0;

        System.out.println("0 && 0: " + myInt1);
        System.out.println("0 && 1: " + myInt2);
        System.out.println("1 && 0: " + myInt3);
        System.out.println("1 && 1: " + myInt4);

        myInt1 = false | false ? 1 : 0;
        myInt2 = false | true ? 1 : 0;
        myInt3 = true | false ? 1 : 0;
        myInt4 = true | true ? 1 : 0;

        System.out.println("0 | 0: " + myInt1);
        System.out.println("0 | 1: " + myInt2);
        System.out.println("1 | 0: " + myInt3);
        System.out.println("1 | 1: " + myInt4);

        myInt1 = false || false ? 1 : 0;
        myInt2 = false || true ? 1 : 0;
        myInt3 = true || false ? 1 : 0;
        myInt4 = true || true ? 1 : 0;

        System.out.println("0 || 0: " + myInt1);
        System.out.println("0 || 1: " + myInt2);
        System.out.println("1 || 0: " + myInt3);
        System.out.println("1 || 1: " + myInt4);

        myInt1 = false ^ false ? 1 : 0;
        myInt2 = false ^ true ? 1 : 0;
        myInt3 = true ^ false ? 1 : 0;
        myInt4 = true ^ true ? 1 : 0;

        System.out.println("0 ^ 0: " + myInt1);
        System.out.println("0 ^ 1: " + myInt2);
        System.out.println("1 ^ 0: " + myInt3);
        System.out.println("1 ^ 1: " + myInt4);

        // ternary operator
        int valueOne = 1;
        int valueTwo = 2;

        int biggestValue = (valueOne > valueTwo) ? valueOne : valueTwo;

        System.out.println("valueOne or valueTwo: " + biggestValue);

        char theGrade = 'B';

        switch (theGrade) {

            case 'a':
            case 'A':
                System.out.println("Great job");
                break;

            case 'b':
            case 'B':
                System.out.println("Good job");
                break;

            default:
                System.out.println("You Failed");
                break;
        }

    }

}
