package derekTutorial;

import java.util.Arrays;


/**
 * String is immutable
 * i.e Every single time you change a String in any way it doesn't delete the previous version of
 * that string in memory but it creates a brand new location in memory for the string over and over again
 * this is kind of time consuming
 * if we have to make so many changes inside a string we should use StringBuilder over Strings because
 * StringBuilder is muttable
 * and it doesn't recreate the string over and over again
 */


// This class focuses on String and StringBuilder
public class LessonThirteen {

    public static void main(String[] args) {
        String randomString = "I'm just a randomString";
        String gotToQuote = "He said, \"I'm here\"";
        System.out.println(randomString + " " + gotToQuote);

        int numTwo = 2;
        System.out.println(randomString + " " + numTwo);

        String upperCaseString = "BIG";
        String lowerCaseString = "big";

        if(upperCaseString.equalsIgnoreCase(lowerCaseString)) {
            System.out.println(" They are equal ");
        }


        System.out.println(upperCaseString instanceof Object);

        String letters = "abcde";
        String moreLetters = "fghijk";

        System.out.println("2nd char: " + letters.charAt(1));
        System.out.println(moreLetters.compareTo(moreLetters));

        System.out.println(letters.endsWith("de"));

        System.out.println(letters.indexOf("cd"));
        System.out.println(letters.indexOf("cd", 1));

        System.out.println(letters.lastIndexOf("d"));
        // this is same as indexOf method but is starts from the end of the String
        // it starts from searching from end of the string insted of being searching from the begining

        System.out.println(letters.length());
        System.out.println(letters.replace("abcd", "xy"));
        System.out.println(letters);


        String[] letterArray = letters.split("");
        System.out.println(Arrays.toString(letterArray));

        char[] charArray = letters.toCharArray();
        System.out.println(Arrays.toString(charArray));

        System.out.println(letters.substring(1, 4));
        System.out.println(letters.toUpperCase()+ " "+letters.toLowerCase());

        String randString = "       abcdefghijk        ";
        System.out.println(randString.trim());

        StringBuilder randSb = new StringBuilder("A Random Value");
        System.out.println(randSb.append(" again"));

        // this change is permanent unlike string (because Strings are immutable)

        System.out.println(randSb.delete(15, 21));
        System.out.println(randSb.capacity());

        randSb.ensureCapacity(60);
        System.out.println(randSb.capacity());
        System.out.println(randSb.length());
        randSb.trimToSize();
        System.out.println(randSb.capacity());

        System.out.println(randSb.insert(1, "nother"));
        String oldSb = randSb.toString();

        // charAt();
        // indexOf();
        // lastIndexOf()
        // substring()
        // these methods are common in StringBuilder same as String
        // \n, \n, \\
    }
}
