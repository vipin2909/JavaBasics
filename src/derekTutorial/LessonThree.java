package derekTutorial;

public class LessonThree {

    public static void main(String[] args) {

        int randomNumber = (int) (Math.random() * 50);

        /* Relational Operators
         * Java has 6 relational operators
         * > : Greater than
         * < : Less than
         * == : Equal to
         * != : not equal
         * >= Greater than or equal to
         * <= less than equal to
         */

        int valueOne = 1;
        int valueTwo = 2;

        int biggestValue = (valueOne > valueTwo) ? valueOne : valueTwo;
        System.out.println(biggestValue);

         char theGrade = 'B';
         switch(theGrade) {
             case 'A':
                 System.out.println("Great Job");
                 break;
             case 'b':
             case 'B':
                 System.out.println("Good Job");
                 break;

             case 'C':
                 System.out.println("Bad Job");
                 break;

             default:
                 System.out.println("The default Value");
                 break;
         }
        if(randomNumber < 25) {
            System.out.println("The random number is less than 25");
        }

        else if(randomNumber > 40) {
            System.out.println("The random number is greater than 40");
        }

        else if(randomNumber == 18) {
            System.out.println("The random number is equal to 18");
        }

       else if(randomNumber != 40) {
            System.out.println("The random number is not equal to 40");
        }

        else if(randomNumber >= 40) {
            System.out.println("The random number is greater than or equal to 40");
        }

        else {
            System.out.println("Nothing worked");
        }

        System.out.println("The random number is " + randomNumber);
//        if(randomNumber < 25) {
//            System.out.println("The random number is less than 25");
//        }


        /**
         * Logical Operators
         *
         *  Java has 6 logical operators
         *  ! : Converts the boolean value of its right to its opposite
         *  & : Return true if boolean value on right and left both side is true
         *  && : returns true if boolean value on the right and left are true
         *  | : returns true if either value on left or right is true
         *  || : return true if either value on left and right is true
         *  ^ : returns true if their is 1 true and 1 false otherwise return false
         */

        if(!(false)) {
            System.out.println("\nI turned false into true");
        }

        if((true) && (true)) {
            System.out.println("Both are true");
        }

        if((false) & (true)) {
            // the diff between this and && is it check the rightside value even after getting the left value false
            System.out.println("Both are true only one &");
        }

    }

}
