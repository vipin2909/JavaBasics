public class LessonThirteen {
    public static void main(String[] args) {
        String letters = "I'm just a random string";
        String letter = "He said, \"I'm here\"";
        System.out.println(letters+" "+letter);
        System.out.println(letters.indexOf("ra", 10));
        String bigSting = "BIG";
        String smallString = "big";
        System.out.println(letters.contains("ust"));
        if(bigSting.equalsIgnoreCase(smallString)) {
            System.out.println("They are equal");
        }
        System.out.println(letters.lastIndexOf("i"));
        String a = "abcde";
        System.out.println(a.split(","));
        System.out.println(a.toCharArray());
        StringBuilder randSB = new StringBuilder("A random value");
        System.out.println(randSB.append(" again"));
        System.out.println(randSB.delete(15, 60));
        System.out.println(randSB.capacity());
        randSB.ensureCapacity(60);
        System.out.println(randSB.capacity());
        System.out.println(randSB.length());
        randSB.trimToSize();
        System.out.println(randSB.capacity());
        System.out.println("First another "+randSB.insert(1, "nother"));
        String oldSb = randSB.toString();
        System.out.println(oldSb);
    }
}
