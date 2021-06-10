import java.util.Scanner;

public class Main {
    static void menu() {
        System.out.println("[1] Add a music to the playlist\n[2] Remove a music from the playlist\n[3] Add a music to the favorites\n[4] Remove a music from the favorites\n[5] Show musics\n[6] Show number of musics\n[7] Show favorites\n[8] Show all\n\n[0] Exit");
    }

    static void type() {
        System.out.println("[1] Pop\n[2] Jazz\n[3] Rock\n[4] Country");
    }
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        MusicCollection musicCollection = new MusicCollection();
        int choose;
        while (true) {
            while (true) {
                menu();
                choose = get.nextInt();
                get.nextLine();
                if (choose < 0 || choose > 8) {
                    continue;
                }
                break;
            }
            if (choose == 1) {
                int type;
                while (true) {
                    type();
                    type = get.nextInt();
                    get.nextLine();
                    if (type < 1 || type > 4) {
                        continue;
                    }
                    break;
                }
                System.out.println("Enter the name of music");
                String name = get.nextLine();
                musicCollection.addFile(name, type);
            }
            if (choose == 2) {
                int remove;
                int removeMusic;
                int flag = 1;
                    while (true) {
                        type();
                        remove = get.nextInt();
                        get.nextLine();
                        if (remove < 1 || remove > 4) {
                            continue;
                        }
                        break;
                    }
                    musicCollection.listFile(remove);
                    removeMusic = get.nextInt();
                    get.nextLine();
                    if (musicCollection.validIndex(removeMusic, remove) == false) {
                        flag = 0;
                    }
                if (flag == 1) {
                    musicCollection.bothDelete(remove, musicCollection.getFiles(remove).get(removeMusic - 1));
                    musicCollection.removeFile(remove, removeMusic - 1);
                }
            }
            if (choose == 3) {
                int type;
                int flag = 1;
                while (true) {
                    type();
                    type = get.nextInt();
                    get.nextLine();
                    if (type < 1 || type > 4) {
                        continue;
                    }
                    break;
                }
                musicCollection.listFile(type);
                int favorite = get.nextInt();
                get.nextLine();
                if (musicCollection.validIndex(favorite, type) == false) {
                    flag = 0;
                }
                if (flag==1&&musicCollection.checkDuplicate(favorite - 1, type)) {
                    System.out.println("Error! This music added before");
                    flag = 0;
                }
                if (flag == 1) {
                    musicCollection.addFavorite(favorite - 1, type);
                }
            }
            if (choose == 4) {
                musicCollection.showFavorite();
                int flag = 1;
                int remove;
                remove = get.nextInt();
                get.nextLine();
                if (musicCollection.validIndex(remove, 5) == false) {
                    flag = 0;
                }
                if (flag == 1) {
                    musicCollection.removeFile(5, remove - 1);
                }
            }
            if (choose == 5) {
                int flag = 1;
                type();
                int type;
                while (true) {
                    type = get.nextInt();
                    get.nextLine();
                    if (type < 1 || type > 4) {
                        continue;
                    }
                    break;
                }
                musicCollection.listFile(type);
                int music = get.nextInt();
                get.nextLine();
                if (musicCollection.validIndex(music, type) == false) {
                    flag = 0;
                }
                if (flag == 1) {
                    System.out.println("Enter to play music");
                    get.nextLine();
                    musicCollection.startPlaying(type, music);
                    System.out.println("Enter to stop playing");
                    get.nextLine();
                    musicCollection.stopPlaying();
                }
            }
            if (choose == 6) {
                System.out.println("Pop: " + musicCollection.getNumberOfFiles(1) + "\nJaz: " + musicCollection.getNumberOfFiles(2) + "\nRock: " + musicCollection.getNumberOfFiles(3) + "\nCountry: " + musicCollection.getNumberOfFiles(4) + "\nFavorites: " + musicCollection.getNumberOfFiles(5));
            }
            if (choose==7){
                musicCollection.showFavorite();
            }
            if (choose == 8) {
                musicCollection.listAllFiles();
            }
            if (choose == 0) {
                System.exit(0);
            }
        }
    }
}