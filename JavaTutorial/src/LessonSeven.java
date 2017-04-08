
public class LessonSeven {

    public static void main(String[] args) {

        Monster Adahn = new Monster();

        System.out.println(Adahn.getHealth());
        Adahn.setHealth(10);
        System.out.println(Adahn.getHealth());

        Adahn.setHealth(10.00);
        System.out.println(Adahn.getHealth());

    }

}