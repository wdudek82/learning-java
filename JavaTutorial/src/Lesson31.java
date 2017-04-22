import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.sound.midi.Soundbank;
import javax.swing.JFrame;
import javax.swing.JFileChooser;


public class Lesson31 extends JFrame {

    static String filepath, parentDir;
    static File randomDir, randomFile, randomFile2;
    static Date date;

    public static void main(String[] args) {
        randomDir = new File("dir_31");
        randomDir.mkdir();

        randomFile = new File("./dir_31/random.txt");
        randomFile2 = new File("./dir_31/random2.txt");

        try {
            randomFile.createNewFile();
            randomFile2.createNewFile();
//            filepath = randomFile.getCanonicalPath();
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.print("Dir Info: ");
        for(String file: randomDir.list()) {
            System.out.print(file + ", ");
        }
        System.out.println();
        for(File file: randomDir.listFiles()) {
            System.out.print("Dir (files): " + file.toString() + ", ");
            System.out.println("readable: " + file.canRead());
            date = new Date(randomFile.lastModified());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
            sdf.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
            String formattedDate = sdf.format(date);
            System.out.println("last modified: " + formattedDate);
//            file.renameTo(new File("dir_31/" + file.getName() + ".bak"));
        }

        if(randomFile.exists()) {
            System.out.println("File 'randomFile' Exists");
            System.out.println("File randomFile is readable: " + randomFile.canRead());
            System.out.println("File randomFile is writable: " + randomFile.canWrite());
            System.out.println("File randomFile is executable: " + randomFile.canExecute());
            System.out.println("File randomFile absolute path: " + randomFile.getAbsolutePath());
            System.out.println("File randomFile is hidden: " + randomFile.isHidden());
            System.out.println("Get parent: " + randomFile.getParent());

            System.out.println();

            new Lesson31();
        } else {
            System.out.println("File doesn't exist");
        }
        if(randomFile2.exists()) {
            System.out.println("File 'randomFile2' Exists");
        } else {
            System.out.println("File doesn't exist");
        }

//        File[] fileInDir = randomDir.listFiles();
//        for(File file: fileInDir) {
//            file.delete();
//        }
//        randomDir.delete();

    } // END OF main

    public Lesson31() {
        JFileChooser fileChooser = new JFileChooser(randomDir);
        fileChooser.showOpenDialog(this);
    } // END OF Lesson31 CONSTRUCTOR

} // END OF Lesson31 CLASS
