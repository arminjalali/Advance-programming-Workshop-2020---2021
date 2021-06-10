import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    /**
     * Print main menu
     */
    public static void menu() {
        System.out.println("[1] new note\n[2] review\n[3] edit\n[4] delete\n[5] exit");
    }
    /**
     * return all file in directory for use BufferedWriter/BufferedReader
     * @return listOfFiles
     */
    public static File[] listOfNotes() {
        System.out.println("List of notes:");
        File[] listOfFiles = new File("C:\\Users\\jalal\\Desktop\\Note3").listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println("[" + (i + 1) + "] " + listOfFiles[i].getName() + " ");
        }
        return listOfFiles;
    }

    /**
     * Check if any file exist in directory
     * @return
     */
    public static boolean checkEmpty() {
        File[] listOfFiles = new File("C:\\Users\\jalal\\Desktop\\Note3").listFiles();
        if (listOfFiles.length == 0) {
            System.out.println("Empty!");
            return false;
        }
        return true;
    }

    /**
     * Check range
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

    public static void main(String[] args) {
        File[] listOfFiles;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        String date = format.format(today);
        while (true) {

            Scanner get = new Scanner(System.in);
            int num;
                while (true) {
                    do {
                        menu();
                        num = get.nextInt();
                        get.nextLine();
                    } while (!checkNum(num, 6));
                    if (num == 1) {
                        System.out.println("Enter name of file");
                        String name = get.nextLine();
                            if (new File("C:\\Users\\jalal\\Desktop\\Note3\\" + name + ".ser").exists()) {
                                System.out.println("The file is already exist");
                            }
                            else {
                                System.out.println("Enter title of note");
                                String title = get.nextLine();
                                try {
                                    FileOutputStream file = new FileOutputStream("C:\\Users\\jalal\\Desktop\\Note3\\" + name + ".ser");
                                    ObjectOutputStream out = new ObjectOutputStream(file);
                                    System.out.println("The file successfully created\nStart to write and you can enter 0 for exit: ");
                                    String text = "Title: " + title + "\nDate: " + date + "\n";
                                    String holder;
                                    while (!((holder = get.nextLine()).equals("0"))) {
                                        text += holder;
                                        text += "\n";
                                    }
                                    Note note = new Note(title, text, date);
                                    out.writeObject(note);
                                    file.close();
                                    out.close();
                                }catch (FileNotFoundException e){
                                    e.printStackTrace();
                                }
                                catch (IOException e){
                                    e.printStackTrace();
                                }
                            }
                    } else if (num == 2) {
                            if (!checkEmpty()) {
                                continue;
                            }
                            listOfFiles = listOfNotes();
                            for (int i = 0; i < listOfFiles.length; i++) {
                                System.out.println("[" + (i + 1) + "]: ");
                                try {
                                    FileInputStream reader = new FileInputStream("C:\\Users\\jalal\\Desktop\\Note3\\" + listOfFiles[i].getName());
                                    ObjectInputStream reader1 = new ObjectInputStream(reader);
                                    Note note = (Note) reader1.readObject();
                                    for (int j = 0 ; j < note.getContent().length() ; j++){
                                        System.out.print(note.getContent().charAt(j));
                                    }
                                    System.out.println("...");
                                    reader.close();
                                    reader1.close();
                                } catch (FileNotFoundException e){
                                    e.printStackTrace();
                                }
                                catch (StringIndexOutOfBoundsException e){
                                    e.printStackTrace();
                                }
                                catch (IOException e){
                                    e.printStackTrace();
                                }
                                catch (ClassNotFoundException e){
                                    e.printStackTrace();
                                }
                            }

                    } else if (num == 3) {
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
                        try {
                            FileInputStream reader = new FileInputStream("C:\\Users\\jalal\\Desktop\\Note3\\" + listOfFiles[which - 1].getName());
                            ObjectInputStream reader1 = new ObjectInputStream(reader);
                            Note note = (Note) reader1.readObject();
                            for (int i = 0 ; i < note.getContent().length() ; i++){
                                System.out.print(note.getContent().charAt(i));
                            }
                            System.out.println("");
                            FileOutputStream writer = new FileOutputStream("C:\\Users\\jalal\\Desktop\\Note3\\Edited.ser");
                            ObjectOutputStream writer1 = new ObjectOutputStream(writer);
                            System.out.println("Enter edited text and 0 for exit: ");
                            String edit = "Title: " + note.getTitle() + "\nDate: " + note.getDate() + "\n";
                            String hold;
                            while (!((hold = get.nextLine()).equals("0"))) {
                                edit += hold;
                                edit += "\n";
                            }
                            note.changeContent(edit);
                            writer1.writeObject(note);
                            reader.close();
                            reader1.close();
                            writer.close();
                            writer1.close();
                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                            String holder = listOfFiles[which - 1].getName();
                            new File(("C:\\Users\\jalal\\Desktop\\Note3\\" + holder)).delete();
                            new File("C:\\Users\\jalal\\Desktop\\Note3\\Edited.ser").renameTo(new File("C:\\Users\\jalal\\Desktop\\Note3\\" + holder));
                    }else if (num == 4) {
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
                                    File delete = new File("C:\\Users\\jalal\\Desktop\\Note3\\" + listOfFiles[which - 1].getName());
                                    delete.delete();
                                    break;
                                } else if (YOrN.equals("N") || YOrN.equals("n")) {
                                    break;
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
