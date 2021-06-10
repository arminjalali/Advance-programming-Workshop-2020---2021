/**
 * Type 1 and every method that ends with number 1 related to BufferWriter/BufferReader
 * Type 2 and every method that ends with number 2 related to FileOutputStream/FileInputStream
 */


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    /**
     * Print main menu
     */
    public static void menu() {
        System.out.println("[1] new note\n[2] review\n[3] edit\n[4] delete\n[5] back\n[6] exit");
    }

    /**
     * print type menu
     */
    public static void type() {
        System.out.println("[1] BufferedWriter/BufferedReader\n[2] FileInputStream/FileOutputStream");
    }

    /**
     * return all file in directory for use BufferedWriter/BufferedReader
     * @return listOfFiles
     */
    public static File[] listOfNotes() {
        System.out.println("List of notes:");
        File[] listOfFiles = new File("C:\\Users\\jalal\\Desktop\\Note").listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println("[" + (i + 1) + "] " + listOfFiles[i].getName() + " ");
        }
        return listOfFiles;
    }

    /**
     * return all file in directory for use FileInputStream/FileOutputStream
     * @return listOfFiles
     */
    public static File[] listOfNotes2() {
        System.out.println("List of notes:");
        File[] listOfFiles = new File("C:\\Users\\jalal\\Desktop\\Note2").listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println("[" + (i + 1) + "] " + listOfFiles[i].getName() + " ");
        }
        return listOfFiles;
    }

    /**
     * Check if any file exist in directory (type 1)
     * @return
     */
    public static boolean checkEmpty() {
        File[] listOfFiles = new File("C:\\Users\\jalal\\Desktop\\Note").listFiles();
        if (listOfFiles.length == 0) {
            System.out.println("Empty!");
            return false;
        }
        return true;
    }

    /**
     * * Check if any file exist in directory (type 2)
     * @return
     */
    public static boolean checkEmpty2() {
        File[] listOfFiles = new File("C:\\Users\\jalal\\Desktop\\Note2").listFiles();
        if (listOfFiles.length == 0) {
            System.out.println("Empty!");
            return false;
        }
        return true;
    }

    /**
     * check range
     * @param num
     * @param up
     * @return
     */
    public static boolean checkNum(int num, int up) {
        if (num > 0 && num <= up) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        File[] listOfFiles;
        while (true) {

            Scanner get = new Scanner(System.in);
            int num;
            int type;
            while (true) {
                do {
                    type();
                    type = get.nextInt();
                    get.nextLine();
                }
                    while (!checkNum(type, 2)) ;
                while (true) {
                    do {
                        menu();
                        num = get.nextInt();
                        get.nextLine();
                    } while (!checkNum(num, 6));


                    if (num == 1) {
                        System.out.println("Enter name of file");
                        String name = get.nextLine();
                            if (type == 1) {
                                if (new File("C:\\Users\\jalal\\Desktop\\Note\\" + name + ".txt").exists()) {
                                    System.out.println("The file is already exist");
                                }
                                else {
                                    FileWriter file = new FileWriter("C:\\Users\\jalal\\Desktop\\Note\\" + name + ".txt");
                                    BufferedWriter writer = new BufferedWriter(file);
                                    System.out.println("The file successfully created\nStart to write and you can enter 0 for exit: ");
                                    String text;
                                    while (!((text = get.nextLine()).equals("0"))) {
                                        writer.append(text);
                                        writer.newLine();

                                    }
                                    writer.close();
                                }
                            } else if (type == 2) {
                                if (new File("C:\\Users\\jalal\\Desktop\\Note2\\" + name + ".txt").exists()) {
                                    System.out.println("The file is already exist");
                                } else {
                                    FileOutputStream file = new FileOutputStream("C:\\Users\\jalal\\Desktop\\Note2\\" + name + ".txt");
                                    System.out.println("The file successfully created\nStart to write and you can enter 0 for exit: ");
                                    String text;
                                    while (!((text = get.nextLine()).equals("0"))) {
                                        byte[] holder = text.getBytes(StandardCharsets.UTF_8);
                                        file.write(holder);
                                        file.write(13);
                                    }
                                    file.close();
                                }
                            }

                    } else if (num == 2) {
                            if (type == 1) {
                                if (!checkEmpty()) {
                                    continue;
                                }
                                listOfFiles = listOfNotes();
                                for (int i = 0; i < listOfFiles.length; i++) {
                                    System.out.println("[" + (i + 1) + "]: ");
                                    FileReader reader = new FileReader("C:\\Users\\jalal\\Desktop\\Note\\" + listOfFiles[i].getName());
                                    BufferedReader reader1 = new BufferedReader(reader);
                                    int j, counter = 0;
                                    while ((j = reader1.read()) != -1) {
                                        System.out.print((char) j);
                                        if (j == 13) {
                                            counter++;
                                        }
                                        if (counter == 3) {
                                            break;
                                        }
                                    }
                                    reader1.close();
                                    System.out.println("...");
                                }
                            }
                            else if (type == 2) {
                                if (!checkEmpty2()) {
                                    continue;
                                }
                                listOfFiles = listOfNotes2();
                                for (int i = 0; i < listOfFiles.length; i++) {
                                    System.out.println("[" + (i + 1) + "]: ");
                                    File f = new File("C:\\Users\\jalal\\Desktop\\Note2\\" + listOfFiles[i].getName());
                                    FileInputStream file = new FileInputStream(f);
                                    int j, counter = 0;
                                    String s = "";
                                    while ((j = file.read()) != -1) {
                                        char c = (char) (j);
                                        s+= c;
                                        if (j == 13) {
                                            counter++;
                                            s+="\n";
                                        }
                                        if (counter == 3) {
                                            break;
                                        }
                                    }
                                    System.out.println(s);
                                    file.close();
                                    System.out.println("...");
                                }
                            }

                    } else if (num == 3) {
                        if (type == 1){
                            if (!checkEmpty()) {
                                continue;
                            }
                            int which;
                            listOfFiles = listOfNotes();
                            System.out.print("Enter number of note: ");
                            while (true) {
                                which = get.nextInt();
                                get.nextLine();
                                if (checkNum(which, listOfFiles.length)) {
                                    break;
                                }
                            }
                            System.out.println("\nText of note: ");
                        FileReader reader = new FileReader("C:\\Users\\jalal\\Desktop\\Note\\" + listOfFiles[which - 1].getName());
                        BufferedReader reader1 = new BufferedReader(reader);
                        int j;
                        while ((j = reader1.read()) != -1) {
                            System.out.print((char) j);
                        }
                        reader1.close();
                        System.out.println("");
                        FileWriter writer = new FileWriter("C:\\Users\\jalal\\Desktop\\Note\\Edited.txt");
                        BufferedWriter writer1 = new BufferedWriter(writer);
                        System.out.println("Enter edited text and 0 for exit: ");
                        String edit;
                        while (!((edit = get.nextLine()).equals("0"))) {
                            writer1.append(edit);
                            writer1.newLine();

                        }
                        writer1.close();
                            String holder = listOfFiles[which - 1].getName();
                            new File(("C:\\Users\\jalal\\Desktop\\Note\\" + holder)).delete();
                            new File("C:\\Users\\jalal\\Desktop\\Note\\Edited.txt").renameTo(new File("C:\\Users\\jalal\\Desktop\\Note\\" + holder));
                    }
                        else if (type == 2){
                            if (!checkEmpty2()) {
                                continue;
                            }
                            int which;
                            listOfFiles = listOfNotes2();
                            System.out.print("Enter number of note: ");
                            while (true) {
                                which = get.nextInt();
                                get.nextLine();
                                if (checkNum(which, listOfFiles.length)) {
                                    break;
                                }
                            }
                            File f = new File("C:\\Users\\jalal\\Desktop\\Note2\\" + listOfFiles[which - 1].getName());
                            FileInputStream file = new FileInputStream(f);
                            System.out.println("\nText of note: ");
                            int j;
                            String s = "";
                            while ((j = file.read()) != -1) {
                                char c = (char) j;
                                s+=c;
                                if (j == 13) {
                                    s+="\n";
                                }
                            }
                            System.out.println(s);
                            file.close();
                            System.out.println("");
                            FileOutputStream writer = new FileOutputStream("C:\\Users\\jalal\\Desktop\\Note2\\Edited.txt");
                            System.out.println("Enter edited text and 0 for exit: ");
                            String edit;
                            while (!((edit = get.nextLine()).equals("0"))) {
                                byte[] holder = edit.getBytes(StandardCharsets.UTF_8);
                                writer.write(holder);
                                writer.write(13);

                            }
                            writer.close();
                            String holder = listOfFiles[which - 1].getName();
                            new File(("C:\\Users\\jalal\\Desktop\\Note2\\" + holder)).delete();
                            new File("C:\\Users\\jalal\\Desktop\\Note2\\Edited.txt").renameTo(new File("C:\\Users\\jalal\\Desktop\\Note2\\" + holder));
                        }
                    } else if (num == 4) {
                        if (type == 1) {
                            if (!checkEmpty()) {
                                continue;
                            }
                            int which;
                            listOfFiles = listOfNotes();
                            System.out.print("Enter number of note: ");
                            while (true) {
                                which = get.nextInt();
                                get.nextLine();
                                if (checkNum(which, listOfFiles.length)) {
                                    break;
                                }
                            }
                            String YOrN;
                            while (true) {
                                System.out.println("Are you sure? enter Y or N");
                                YOrN = get.nextLine();
                                if (YOrN.equals("Y") || YOrN.equals("y")) {
                                    File delete = new File("C:\\Users\\jalal\\Desktop\\Note\\" + listOfFiles[which - 1].getName());
                                    delete.delete();
                                    break;
                                } else if (YOrN.equals("N") || YOrN.equals("n")) {
                                    break;
                                }
                            }
                        }
                        else if (type == 2){
                            if (!checkEmpty2()) {
                                continue;
                            }
                            int which;
                            listOfFiles = listOfNotes2();
                            System.out.print("Enter number of note: ");
                            while (true) {
                                which = get.nextInt();
                                get.nextLine();
                                if (checkNum(which, listOfFiles.length)) {
                                    break;
                                }
                            }
                            String YOrN;
                            while (true) {
                                System.out.println("Are you sure? enter Y or N");
                                YOrN = get.nextLine();
                                if (YOrN.equals("Y") || YOrN.equals("y")) {
                                    File delete = new File("C:\\Users\\jalal\\Desktop\\Note2\\" + listOfFiles[which - 1].getName());
                                    delete.delete();
                                    break;
                                } else if (YOrN.equals("N") || YOrN.equals("n")) {
                                    break;
                                }
                            }
                        }
                    } else if (num == 5) {
                        break;
                    } else if (num == 6) {
                        System.exit(0);
                    }
                }
            }
        }
    }
}
