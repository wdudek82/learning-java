import java.util.Arrays;
import java.util.LinkedList;


public class LessonTwelve {
    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList();
        LinkedList<String> names = new LinkedList<String>();

        names.add("Ahmed Bennani");
        names.add("Ali Syed");

        names.addLast("Nathan Martin");
        names.addFirst("Joshua Smith");
        names.add(0, "Noah Peeters");
        names.set(2, "Paul Newman");
        names.remove(4);
        names.remove("Joshua Smith");

        System.out.println("\nFirst name: " + names.get(0));
        System.out.println("Last name: " + names.getLast());
        System.out.println();

        for (String name : names) {
            System.out.println("| " + name);
        }

        LinkedList<String> namesCopy = new LinkedList<String>(names);

        // Also works
        // namesCopy.addAll(names);

        System.out.println("\nnameCopy: " + namesCopy);

        names.add("Wojtek Dudek");
        System.out.println("namesCopy contains Noah Peeters: " + names.contains("Noah Peeters"));
        System.out.println("namesCopy contains names: " + namesCopy.containsAll(names));
        System.out.println("names contains nameCopy: " + names.containsAll(namesCopy));

        System.out.println("Index of Paul Newman: " + names.indexOf("Paul Newman"));
        System.out.println("List is empty: " + names.isEmpty());
        System.out.println("Size of the names list: " + names.size());

        System.out.println("\nLook without Error: " + names.peek());
        System.out.println("\nLook without Error: " + names.peekLast());

        System.out.println("\nRemove first element: " + namesCopy.poll());
        System.out.println("Remove last element: " + namesCopy.pollLast());
        System.out.println("namesCopy: " + namesCopy);

        // Add at the beginning of a list
        namesCopy.push("Noah Peters");
        System.out.println("namesCopy after push: " + namesCopy);

        namesCopy.pop();
        System.out.println("nameCopy after pop: " + namesCopy);

        Object[] nameArray = new Object[4];
        nameArray = names.toArray();

        System.out.println("\nnameArray: " + Arrays.toString(nameArray));

    }
}
