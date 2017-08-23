public class PrimitiveDataTypes {

    public static double lb2kg(double pounds) {

        // 1lb == 0.45359237
        double KG = 0.45359237d;

        return pounds * KG;

    }

    public static void main(String[] args) {

        // 2**64
        long longNum = 9_223_372_036_854_775_807L;

        // 2**32
        int num = 2_147_483_647;

        // 2**16
        short num3 = 32767;

        // 2**8
        byte byteNum = 127;

        // Without casting it'll became an int, so 32 bits long
        byte byteNum2 = (byte) (byteNum / 2);

        long numAssignment = 50000L + 10L * byteNum + num3 + num;

        // 2**32
        float myFloat = 5f;

        // 2**64 (8 bytes)
        double myDouble = 5d;

        float testFloat = (float) 5.25;

        // 2**16 (2 bytes)
        char myChar = '\u00A9';
        System.out.println(myChar);

        System.out.println("Hello, World!");

        System.out.println(lb2kg(90));


        double double1 = 20d;
        double double2 = 80d;
        double result = (double1 + double2) * 25;
        double result2 = result % 40;

        System.out.println(result2);

        if (result2 <= 20) {
            System.out.println("Total was over the limit!");
        }

    }

}
