package derekTutorial;

import java.util.Arrays;
import java.util.LinkedList;

public class LessonTwelve {

    // not restricted to recieve any particualr data type
    public static void main(String[] args) {


        LinkedList linkedListOne = new LinkedList();

        // restricted to recive a particualr data type
        LinkedList<String> names = new LinkedList<String>();

        names.add("Ahmed Bennani");
        names.add("Ali Syed");
        names.addLast("Nathan Martin");
        names.addFirst("Joshua Smith");
        // this will add element at index 0 and append the list after that
        names.add(0, "Noah Peters");

        // and set method will change the curr element at position 2 (0 based index)
        names.set(2, "Paul Newman");

        names.remove(4);
        names.remove("Joshua Smith");

        System.out.println("\nFirst Index: " + names.get(0));

        System.out.println(names);

        for(String name: names) {
            System.out.println(name);
        }


        LinkedList<String> nameCopy = new LinkedList<String>(names);

        System.out.println("\nNameCopy Linked List is: " + nameCopy);

        if(names.contains("Noah Peters")) {
            System.out.println("\n Noah is Here!!");
        }

        if(names.containsAll(nameCopy)) {
            System.out.println("\n Collections are same !!");
        }

        System.out.println("\n Ali is at index: " + names.indexOf("Ali Syed") );
        System.out.println("\n List is empty ? " + names.isEmpty());
        System.out.println("\nHow many " + names.size());

//        int[] n1 = new int[0];
//        boolean[] n2 = new boolean[-200];
//        double[] n3 = new double[2241423798];
//        char[] n4 = new char[20];

//        System.out.println(n1.length);

//        System.out.println("\n removeFirstElement " + nameCopy.poll());

        System.out.println("\nLook without error " + names.peek());

//        System.out.println("\n remove last element " + nameCopy.peekLast());

        nameCopy.push("Noah Peters");
        // it pushes to the front of the list
        nameCopy.pop();
        // pop() method chop of the first element

        for(String name: nameCopy) {
            System.out.println(name);
        }

        Object[] nameArray = new Object[4];

        nameArray = names.toArray();
        System.out.println(nameArray.length);
        System.out.println(Arrays.toString(nameArray));

        names.clear();
        // this will make it empty
    }

}
