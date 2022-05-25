package derekTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class LessonEleven {
    public static void main(String[] args) {
        ArrayList arrayListOne;
        arrayListOne = new ArrayList();

        ArrayList arrayListTwo = new ArrayList();

        ArrayList<String> names = new ArrayList<String>();

        names.add("John Smith");
        names.add("Mohmed Alami");
        names.add("Oliver Miller");
        names.add(2, "Jack Ryan");
        names.set(1, "John Addams");

        names.remove(0);
        // names.removeRange(startIndex, endIndex);



//        for(int index = 0; index < names.size(); index++) {
//            System.out.println(names.get(index));
//        }

        System.out.println(names);
//
//        for(String name: names) {
//            System.out.println(name);
//        }

        // Iterator
        // these are all objects are all have some methods we can use to enhance quality of our code

//        Iterator indivItems = names.iterator();
//
//        while(indivItems.hasNext()) {
//            System.out.println(indivItems.next());
//        }


        ArrayList nameCopy = new ArrayList();
        ArrayList nameBackup = new ArrayList();

        nameCopy.addAll(names);
        String paulYoung = "Paul Young";

        names.add(paulYoung);

        System.out.println(names);

        for(Object name: nameCopy) {
            System.out.println(name);
        }
        System.out.println(nameCopy+" and size of names now and nameCopy is " + names.size() + ", " + nameCopy.size() + " respectively");

        if(names.containsAll(nameCopy)) {
            System.out.println("Everything in nameCopy is in names");
        }

        // Copies names to nameCopy
        // Added to names

         names.clear();

        if(names.isEmpty()) {
            System.out.println("Names arrayList is empty");
        }

        Object[] moreNames = new Object[4];

        moreNames = nameCopy.toArray();
        System.out.println(Arrays.toString(moreNames));

    }
}
