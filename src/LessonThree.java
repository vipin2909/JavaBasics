public class LessonThree {

    public static void main(String[] args) {
//        int randomNumber = (int)(Math.random()*50);
        int randomNumber = 18;
        if(randomNumber < 25) {
            System.out.println("This number is less than 25");
        }
        else if(randomNumber > 40) {
            System.out.println("The random number is greater then 40");
        }
        else if(randomNumber == 18 ) {
            System.out.println("The random number is equals to 18");
        }
        else if(randomNumber != 40) {
            System.out.println("The random number is not equals to 40");
        }
        System.out.println("The random number is " + randomNumber);
        char theGrade =  'p';
        switch(theGrade) {
            case 'A':
                System.out.println("Great job");
                break;
            case 'B':
                System.out.println("God job");
                break;
            case 'C':
                System.out.println("Ok");
                break;
            default:
                System.out.println("You failed");
                break;
        }
    }
}
