import java.lang.reflect.Array;
import java.util.Arrays;


public class Lesson13 {
    public static void main(String[] args) {
        String randomString = "I'm just a random string.";
        String uppercaseStr = "BIG";
        String lowercaseStr = "big";

        System.out.println("uppercaseStr equals lowercaseStr: " + uppercaseStr.equals(lowercaseStr));
        System.out.println("uppercaseStr equals lowercaseStr: " + uppercaseStr.equalsIgnoreCase(lowercaseStr));
        System.out.println("uppercaseStr startswith \"BI\": " + uppercaseStr.startsWith("BI"));
        System.out.println("uppercaseStr endswith \"IG\": " + uppercaseStr.endsWith("IG"));
        System.out.println("uppercaseStr to lower: " + uppercaseStr.toLowerCase());
        System.out.println("|" + randomString.replaceAll("[a-z]", "*"));

        String lettersOne = "abcde";
        String lettersTwo = "efghijk";
        String lettersThree = "abdc";

        System.out.println(lettersOne.charAt(2));
        System.out.println(lettersOne.indexOf("c"));
        System.out.println(lettersOne.indexOf("c", 3));
        System.out.println(lettersOne.compareTo(lettersTwo));
        System.out.println(lettersOne.compareTo(lettersThree));
        System.out.println(lettersOne.contains("ace"));
        System.out.println(lettersOne.contains("abc"));
        System.out.println("Length: " + lettersOne.length());

        String[] letterArray = lettersOne.split("");
        System.out.println("\n" + Arrays.toString(letterArray));

        String[] randomArray = randomString.split(" ");
        System.out.println("\n" + Arrays.toString(randomArray));

        char[] charsArray = lettersOne.toCharArray();
        System.out.println("chars array: " + Arrays.toString(charsArray));

        System.out.println("\nSubstring: " + randomString.substring(4, 8));

        // sout...
        StringBuilder randSB = new StringBuilder("A random value");
        System.out.println(randSB.append(" to the string builder"));
        System.out.println(randSB);
        System.out.println(randSB.delete(15, 21));

        System.out.println(randSB.capacity());
        randSB.ensureCapacity(100);
        System.out.println(randSB.capacity());
        randSB.trimToSize();
        System.out.println(randSB.capacity());

        System.out.println(randSB.insert(1, "nother"));
        System.out.println(randSB.capacity());

        String newString = randSB.toString();
        System.out.println(newString);

        // charAt()
        // indexOf()
        // lastIndexOf()
        // substring()
    }
}
