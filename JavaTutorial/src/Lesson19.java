import java.util.regex.*;

public class Lesson19 {
    public static void main(String[] args) {
        String longString = " Derek Banas CA 1234 PA (412)555-1212 johnsmith@hotmail.com 412-555-1234 412 555-1234 ";
        String strangeString = " 1Z aaa **** *** {{{ {{ { ";

//        regexChecker("\\s\\w{2,20}", longString);
//        regexChecker("\\(\\d{3,5}\\)", longString);
//        regexChecker("[DBCP]\\w{1,5}", longString);
//        regexChecker("([\\w\\.\\%\\-]+)@([\\w]+)\\.([\\w]{2,4})", longString);
        regexChecker("(\\d( |-)?)?(\\(?\\d{3}\\)?|\\d{3})( |-)?(\\d{3}( |-)?\\d{4}|[A-Za-z0-9]{7})", longString);

        regexReplace(longString);
    }

    public static void regexChecker(String theRegex, String str2Check) {
//        Pattern checkRegex = Pattern.compile(theRegex, Pattern.CASE_INSENSITIVE);
        Pattern checkRegex = Pattern.compile(theRegex);

        Matcher regexMatcher = checkRegex.matcher(str2Check);

        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                System.out.println(regexMatcher.group().trim());
            }

//            System.out.println("Group: " + regexMatcher.group());
//            System.out.println("Group: " + regexMatcher.group(1));
//            System.out.println("Group: " + regexMatcher.group(2));
//            System.out.println("Group: " + regexMatcher.group(3));
            System.out.println("Start index: " + regexMatcher.start() + "; End Index: " + regexMatcher.end());
        }

    }

    public static void regexReplace(String str2Replace) {
        Pattern replacePattern = Pattern.compile("\\s+");
        Matcher regexMatcher = replacePattern.matcher(str2Replace.trim());

        System.out.println(regexMatcher.replaceAll(", "));
    }
}
