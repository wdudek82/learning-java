import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;


public class LessonEleven {
    public static void main(String[] args) {
        // ArrayList()
        // ArrayList<type>()
        // .add(item) | add(ind, item)
        // .get(ind)
        // .set(ind, item)
        // .remove(ind)

        ArrayList arrayListOne;
        arrayListOne = new ArrayList();

        ArrayList arrayListTwo = new ArrayList();

        // ArrayList: allow only strings
        ArrayList<String> names = new ArrayList<String>();

        names.add("John Smith");
        names.add("Mohamed Alami");
        names.add("Oliver Miller");

        names.add(2, "Jack Ryan");

        System.out.println(names);
        System.out.println("Item: " + names.get(0));

        for (int i = 0; i < names.size(); i++) {
            System.out.println("Item index " + i + ": " + names.get(i));
        }

        names.set(0, "John Adams");
        System.out.println("Changed item 0: " + names.get(0));

        names.remove(2);
        System.out.println("ArrayList: " + names);

        // To remove slice from a ArrayList: .subList(start, stop).clear()
        names.subList(0, 1).clear();
        System.out.println("Sublist: " + names);

        // How clear ArrayList works
        ArrayList nums = new ArrayList();
        for (int i = 0; i < 10; i++) {
            nums.add((int) Math.pow(i+1, 2));
        }
        System.out.println("Nums: " + nums);
//        nums.clear();
//        System.out.println("Cleared nums: " + nums);

        for (String name : names) {
            System.out.println("Person in ArrayList: " + name);
        }

        Iterator indivItems = names.iterator();

        while (indivItems.hasNext()) {
            System.out.println(indivItems.next());
        }

        ArrayList numsBackup = new ArrayList();

        numsBackup.addAll(nums);
        System.out.println("Original nums list: " + nums);
        nums.clear();
        System.out.println("Original nums list cleared: " + nums);
        System.out.println("Copy of nums list:" + numsBackup);

        String paulYoung = "Paul Young";
        names.add(paulYoung);

        if (names.contains("Paul Young")) {
            System.out.println("Paul is here!");
        }

        ArrayList namesCopy = new ArrayList();
        namesCopy.addAll(names);
        System.out.println(namesCopy);

        if (names.containsAll(namesCopy)) {
            System.out.println("Everything in namesCopy is in names");
        }

        System.out.println("names arr is empty: " + names.isEmpty());

        // List of objects
        namesCopy.add(7);
        System.out.println("namesCopy + int 7: " + namesCopy);
        Object[] moreNames = new Object[4];
        moreNames = namesCopy.toArray();

        System.out.println("more names: " + Arrays.toString(moreNames));

    }
}
