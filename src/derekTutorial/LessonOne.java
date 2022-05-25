package derekTutorial;

// Here i am defining a new class (Blueprint) named LessonOne
// public tells Java that this should be available to all other classes and methods (functions)
// LessonOne is just what you named your program. That allows you to reference it later
// { is the opening brace that surrounds the code used by LessonOne

public class LessonOne {
    // public allows other classes to use this function
    // static means that only a class can call for this function to execute
    // void states that this function doesn't return any values after it is done executing
    // main is required in every java program. This function is always executed first
    // Every main function must accept an Array of String objects
    // Class variables must start with static if you want to access them with any other methods in the class

    static String randomString = "String to Print";

    // constant variables are defined with the final keyword
    static final double PINUM = 3.1415929;

    public static void main(String[] args) {
        // System.out is an object that outputs information
        // println is a function that prints to the screen what ever you provide betweens braces
        // "Hello World" is a String of characters, Strings. Strings must be sourrounded with quotes
        // Every statement ends with a semicolon;

        System.out.println("Hello World");
        // variables names are case sensitive, Age is not same as age.
        // variables must began with a letter and contain numbers, '_' or $
        // you must declare all variables before you can use them with a data type
         /* You can use any variable name except for
             * abstract     continue    for     new     switch  assert  default goto    package     synchronized
             * boolean  do  if  private this    break   double  implements  protected   throw
             * byte else    import  public  throws  case    enum    instanceof  return  transient
             * catch    extends int short   try char    final   interface   static  void
             * class    finally long    strictfp    volatile    const   float   native  super   while
             */

        // Java Primitive types
        byte bigByte = 127; // min val -128 and max val 127
        short bigShort = 32767; // min val -32768 and max val 32767
        int bigInt = 2147483647; // min val -2147483648 and max val
        long bigLong = 9223372036854775807L; // Minimum value -9223372036854775808L

        float bigFloat = 3.14F; // you must end float with an F

        double bigDouble = 3.1234567890D; // The D is not required with doubles

        System.out.println(Float.MAX_VALUE); // Float is precise to 6 decimal places
        System.out.println(Double.MAX_VALUE); // Double is precise to 15 decimal places
        boolean trueOrFalse = true; // Booleans are True or False, not 1 or 0
        // A char will accept a number or a character surrounded by apostrophes
        char randomChar = 65; // Character Code for A is 65 Minimum value 0 Maximum value 65535
        char anotherChar = 'A';
        System.out.println(randomChar);
        // chars can also contain escaped characters
        char backSpace = '\b';
        char formFeed = '\f';
        char lineFeed = '\n';
        char carriageReturn = '\r';
        char horizontalTab = '\t';
        char doubleQuote = '\"';
        char singleQuote = '\'';
        char backSlash = '\\';

        // A string contains a series of characters
        String randomString = "I'm just a random";
        String anotherString = "string";
        // You combine strings with a +
        String combinedString = randomString + ' ' + anotherString;
        System.out.println(combinedString);


        // How to convert any other type to String
        String byteString = Byte.toString(bigByte);
        String shortString = Short.toString(bigShort);
        String intString = Integer.toString(bigInt);
        String longString = Long.toString(bigLong);
        String floatString = Float.toString(bigFloat);

        String doubleString = Double.toString(bigDouble);
        String booleanString = Boolean.toString(trueOrFalse);
        String charString = Character.toString(randomChar); // We don't need to do this
        System.out.println(charString);

        // can't do this because char is a primitive data type
//        System.out.println(randomChar.getClass());

        // Can do this because String is an object
        System.out.println(charString.getClass());

        // You can use casting to convert from one primitive type to another
        // if you convert a number that is to big the largest possible value will be
        // used insted

        /**
         * To Case to other primitive just proceed the conversion with type
         * ie (byte) (short) (long) (double)
         * (float) & (boolan) & (char) don't work
         * (char) stays as a number insted of char
         */

        // use parseInt to convert a string into an integer

        int stringInput = Integer.parseInt(intString);

        // Other parse functions
        // parseShort, parseLong, parseByte,parseFloat, parseDouble, parseBoolean
        // There is no region to parse a character







    }
}
