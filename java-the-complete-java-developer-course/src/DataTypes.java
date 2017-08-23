public class DataTypes {

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

        long numAssignment = 50_000 + 10 * byteNum + num3 + num;

        System.out.println("Hello, World!");

    }

}
