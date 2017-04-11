
public class Lesson17 {
    public static void main(String[] args) {
        Thread getTime = new GetTime20();
        Runnable getMail = new GetTheMail(10);
        Runnable getMailAgain = new GetTheMail(15);

        getTime.start();

        new Thread(getMail).start();
        new Thread(getMailAgain).start();
    }
}

