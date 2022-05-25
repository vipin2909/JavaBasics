import javax.swing.*;

import java.io.*;


public class Lesson31 extends JFrame {

    static String filePath, parentDirectory;
    static File randomDir, randomFile, randomFile2;

    public static void main(String[] args) {

        String filePathName = "C:\\Users\\vipin sharma\\Documents\\Java\\Java";
        randomDir = new File(filePathName);
        randomDir.mkdir();
        randomFile = new File("random.txt");
        randomFile2 = new File("C:\\Users\\vipin sharma\\Documents\\Java\\Java\\random2.txt");

        try {
            randomFile.createNewFile();
            randomFile2.createNewFile();
            filePath = randomFile.getCanonicalPath();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        if(randomFile.exists()) {
            System.out.println("File Exists "+randomFile.canRead());
            System.out.println("File Writable "+randomFile.canWrite());
            System.out.println("File Location "+filePath);
            // the below value is null because this shows parent directory only
            // when specify it before calling getParent() function

            System.out.println("Parent Directory "+randomFile.getParent());
            System.out.println("File 2 Parent "+randomFile2.getParent());
            System.out.println("File Name "+randomFile.getName());

            System.out.println("Is it a directory "+randomDir.isDirectory());


            String[] fileInDir = randomDir.list();
            System.out.println("Files in directory\n");
            for(String fileName: fileInDir) {
                System.out.println(fileName+"\n");
            }

            System.out.println("Is a File "+randomFile.isFile());
            System.out.println("Is Hidden "+randomFile.isHidden());
            System.out.println("Last Modified "+randomFile.lastModified());
            System.out.println("File Size "+randomFile.length());
            randomFile2. renameTo((new File("C:\\Users\\vipin sharma\\Documents\\Java\\Java\\random25.txt")));

            new Lesson31();


        }
        else {
            System.out.println("File Doesn't exists");
        }
        if(randomFile2.delete()) {
            System.out.println("File deleted RandomFile ");
        }

        // if you want to delete a directory you should first delete
        // all the files inside that directory

        File[] filesInDir = randomDir.listFiles();
        for(File fileName: filesInDir) {
            fileName.delete();
        }

        if(randomDir.delete()) {
            System.out.println("Directory Deleted");
        }

    }

    public Lesson31() {
        JFileChooser fileChooser = new JFileChooser(randomDir);
        fileChooser.showOpenDialog(this);
    }
}
