public class HelloWorld {

    static String randomString = "String to print";

    // constat
    static final double PINUM = 3.14;

    public static void main(String[] args) {

        // primitives
        byte maxByte = 127;
        short maxShort = 32767;
        int maxInt = 2100000000;
        long maxLong = 9220000000000000000L;  // 16 zeros,
        float maxFlot = 3.14F;  // precise to ~5 decimal places
        double maxDouble = 3.14823794872734872347923748D;  // D is optional; precise ~15 decimal places

        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);

        boolean trueOrFalse = true;
        char randomChar = 65;
        char anotherChar = 'A';
        char escapedChars = '\\';

        System.out.println(randomChar);
        System.out.println(anotherChar);
        System.out.println(escapedChars);

        String randomString = "I'm a random string.";
        String anotherString = "Stuff";
        String combinedStrings = randomString + ' ' + anotherString;

        System.out.println(combinedStrings);

        // converting any type to String
        String byteString = Byte.toString(maxByte);
        String booleanString = Boolean.toString(trueOrFalse);

        System.out.println(booleanString);

        // casting to a type
        double aDoubleValue = 3.123432143543215;
        int doubleToInt = (int) aDoubleValue;

        System.out.printf("1 | %d\n", doubleToInt);

        int stringToInt = Integer.parseInt("2100");

        System.out.println("2 | " + stringToInt);

        // int integerOne, integerTwo, integerThree;
        int integerOne = 22;
        int integerTwo = integerOne++;

        System.out.printf("%d, %d\n", integerOne, integerTwo);

        System.out.println("Hello World!");
        System.out.println(randomString);
        System.out.println(PINUM);

    }

}
