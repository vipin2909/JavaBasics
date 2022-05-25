import java.util.Arrays;
import java.util.LinkedList;

public class LessonTwelve {
    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList();
        LinkedList<String> names = new LinkedList<String>();
        names.add("Ahmed bennani");
        names.add("Ali syed");
        names.addLast("Nathan martin");
        names.addFirst("Joshua smith");
        names.add(0, "Noah peteres");
        names.set(4, "Paul new man");
        names.remove(4);
        names.remove("Joshua smith");

        for(String name: names) {
            System.out.println(name);
        }
        System.out.println("\nFirst Index: " + names.get(0));
        System.out.println("\nFirst Index: " + names.getLast());
        LinkedList<String> nameCopy = new LinkedList<String>(names);
        System.out.println("\nnameCopy: " + nameCopy);
        if(names.contains("Noah peteres")) {
            System.out.println("\nnoah is here");
        }
        if(names.containsAll(nameCopy)) {
            System.out.println("\nCollections are same");
        }
        System.out.println("\nAli index is: "+names.indexOf("Ali syed"));
        System.out.println("\nList empty ? "+ names.isEmpty());
        System.out.println("\nHow many "+names.size());
        System.out.println("\nLook Without error "+names.peek());
        System.out.println("\nRemove first element "+names.poll());
        System.out.println(names);
        System.out.println("\nRemove last "+names.pollLast());
        System.out.println(names);
        System.out.println("\nRemove first "+names.pollFirst());
        System.out.println(names);
        nameCopy.push("Noah peteres");
        nameCopy.pop();
        for(String name: nameCopy) {
            System.out.println(name);
        }
        Object[] newArray = new Object[4];
        newArray = nameCopy.toArray();
        System.out.println(Arrays.toString(newArray)+" "+newArray.length);
    }
}
