import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class LessonEleven {
    public static void main(String[] args) {
//        System.out.println("This is java lesson eleven");
        ArrayList arrayListOne;
        arrayListOne = new ArrayList();
        // by default this array list can contain any type of objects
        // means any kind of elements of any data type
        ArrayList arrayListTwo = new ArrayList();
        ArrayList<String> names = new ArrayList<String>();
        names.add("John Smith");
        names.add("Mohammed alami");
        names.add("Oliver Miller");
        names.set(0, "john adams");
        names.add(2, "Jack Ryan");
        names.remove(3);
        // names.removeRange(0, 1);
        for(int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        System.out.println(names);
        for(String i: names) {
            System.out.println(i);
        }

        Iterator indivItems = names.iterator();
        while(indivItems.hasNext()) {
            System.out.println(indivItems.next());
        }
        ArrayList nameCopy = new ArrayList();
        ArrayList nameBackup = new ArrayList();
        nameCopy.addAll(names);
        String paulYoung = "Paul Young";
        names.add(paulYoung);
        if(names.contains(paulYoung)) {
            System.out.println("Pual is here !!");
        }
        if(names.containsAll(nameCopy)) {
            System.out.println("Names arraylist have everthing of nameCopy");
        }
        // copied names to nameCopy
        names.clear();
        if(names.isEmpty()) {
            System.out.println("names arraylist is empty");
        }

        Object[] moreNames = new Object[4];
        moreNames = nameCopy.toArray();
        System.out.println(Arrays.toString(moreNames)+ " " + moreNames.length);
    }
}
