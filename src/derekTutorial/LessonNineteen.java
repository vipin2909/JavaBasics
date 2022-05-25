package derekTutorial;

import java.util.regex.*;

public class LessonNineteen {
    public static void main(String[] args) {
        String longString = "Derek Banas CA AK 12345 PA (412)555-1212 johnsmith@hotmail.com 412-555-1234 412 555-1234 ";
        String strangeString = " 1Z aaa **** *** {{{ {{ { ";
       // [a-zA-Z0-9] any characters you want
        // [^A-G] any characters you dont want
        // \\s white space things
        // \\S without white space things
        // {n, m} withing a range between n and m n being the minimum and m being the maximum

        // Example if you want to search characters between 2-20 length
        // expression for that is [A-Za-z]{2, 20} this is regex for the same and also its shorthand is \\w{2, 20}

//        regexChecker("\\s[A-Za-z]{2,20}\\s", longString);

//        regexChecker("A[KLRNG]|C[AOT]", longString);
//        regexChecker("(\\{{1,})", strangeString);
//        regexChecker(".{3}", strangeString);
//        regexChecker("\\w*", strangeString);
        regexChecker("[A-Za-z0-9.%-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}", longString);

    }
    //d find digits and numbers
    //D anything that is not a digit or number
    //{5} if anything occurs this many times in this case its 5 times

    // Zip code is 5 digits long
    // 2 Characters that strats with C or A

    //A[KLRNG]!C[AOT]

    //{5,} when you want to define minimum but don't want to define max. then you can use this trick
    //+ if put this sign inside a regular expression what does that means whatever proceding this must occur
    // one or more times

     // . ^ * + ? {} [] \ ? ()  everthing needs to have a back slash
     // w => means all these things gets included
    // \\w => [A-Za-z0-9_];
    // \\W means the above things don't get included

    // results that occur zero or more times \\ *



    public static void regexChecker(String theRegex, String str2Check) {
        Pattern checkRegex = Pattern.compile(theRegex);

        Matcher regexMatcher = checkRegex.matcher(str2Check);
        while(regexMatcher.find()) {
            if(regexMatcher.group().length() != 0) {
                System.out.println(regexMatcher.group().trim());
            }
            System.out.println("Start Index " + regexMatcher.start());
            System.out.println("End Index " + regexMatcher.end());
        }
    }
}
