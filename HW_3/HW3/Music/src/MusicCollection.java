import java.security.PrivateKey;
import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> pop;
    private ArrayList<String> rock;
    private ArrayList<String> jazz;
    private ArrayList<String> country;
    private ArrayList<String> favorite;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        pop=new ArrayList<>();
        rock=new ArrayList<>();
        jazz=new ArrayList<>();
        country=new ArrayList<>();
        favorite=new ArrayList<>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename,int num)
    {
        switch (num){
            case 1: pop.add(filename);break;
            case 2: jazz.add(filename);break;
            case 3: rock.add(filename);break;
            case 4: country.add(filename);break;
        }
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles(int num)
    {
        switch (num){
            case 1: return pop.size();
            case 2: return jazz.size();
            case 3: return rock.size();
            case 4: return country.size();
            case 5: return favorite.size();
        }
        return 0;
    }

    /**
     *
     * @param num Type of music
     * @return Access to the files
     */
    public ArrayList<String> getFiles(int num) {
        switch (num) {
            case 1:
            return pop;
            case 2:
            return jazz;
            case 3:
            return rock;
            case 4:
            return country;
            case 5:
            return favorite;
        }
        return null;
    }
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        switch (index){
            case 1: for(int i=0;i<pop.size();i++){ System.out.println("[" + (i+1)+"] " + pop.get(i));}break;
            case 2: for(int i=0;i<jazz.size();i++){ System.out.println("[" + (i+1)+"] " + jazz.get(i));}break;
            case 3: for(int i=0;i<rock.size();i++){ System.out.println("[" + (i+1)+"] " + rock.get(i));}break;
            case 4: for(int i=0;i<country.size();i++){ System.out.println("[" + (i+1)+"] " + country.get(i));}break;
        }
    }
    
    /**
     * Show a list of all the files in the collections.
     */
    public void listAllFiles()
    {
        System.out.println("Pop: ");
        for (int i=0;i<pop.size();i++){
            System.out.println(pop.get(i));
        }
        System.out.println("\nJazz: ");
        for (int i=0;i<jazz.size();i++){
            System.out.println(jazz.get(i));
        }
        System.out.println("\nRock: ");
        for (int i=0;i<rock.size();i++){
            System.out.println(rock.get(i));
        }
        System.out.println("\nCountry: ");
        for (int i=0;i<country.size();i++){
            System.out.println(country.get(i));
        }
        System.out.println("\nFavorites: ");
        for (int i=0;i<favorite.size();i++){
            System.out.println(favorite.get(i));
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index,int num) {
        switch (index) {
            case 1:
            pop.remove(num);break;
            case 2:
            jazz.remove(num);break;
            case 3:
            rock.remove(num);break;
            case 4:
            country.remove(num);break;
            case 5:
            favorite.remove(num);break;
        }
    }

    /**
     * Add music to favorite
     * @param index Which music add to favorites
     * @param num Type of music
     */
    public void addFavorite(int index,int num)
    {
        switch (num) {
            case 1:
            favorite.add(pop.get(index)+"(Pop)");break;
            case 2:
            favorite.add(jazz.get(index)+"(Jazz)");break;
            case 3:
            favorite.add(rock.get(index)+"(Rock)");break;
            case 4:
            favorite.add(country.get(index)+"(Country)");break;
        }
    }

    /**
     *
     * @param index Element that should check.
     * @param num Type of music
     * @return true or false
     */
    public boolean checkDuplicate(int index,int num)
    {
        switch (num) {
            case 1:
                return favorite.contains(pop.get(index)+"(Pop)");
            case 2:
                return favorite.contains(jazz.get(index)+"(Jazz)");
            case 3:
                return favorite.contains(rock.get(index)+"(Rock)");
            case 4:
                return favorite.contains(country.get(index)+"(Country)");
        }
        return false;
    }
    /**
     * Show favorites
     */
    public void showFavorite(){
        for (int i=0;i<favorite.size();i++){
            System.out.println("["+(i+1)+"] " + favorite.get(i));
        }
    }

    /**
     *When delete music from playlist, it should delete from favorites too!
     * @param num Type of music
     * @param name Name of the music
     */
    public void bothDelete(int num,String name)
    {
        switch (num) {
            case 1:
            favorite.remove(name+"(Pop)");break;
            case 2:
            favorite.remove(name+"(Jazz)");break;
            case 3:
            favorite.remove(name+"(Rock)");break;
            case 4:
            favorite.remove(name+"(Country)");break;
        }
    }
    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     *@param num Which music.
     * */
    public void startPlaying(int index,int num)
    {
        player.startPlaying(getFiles(index).get(num-1));
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @param num Type of music
     * @return true if the index is valid, false otherwise.
     */
    public boolean validIndex(int index,int num)
    {
        switch (num){
            case 1: if(index>pop.size()||index<1) { System.out.println("Error");return false;} break;
            case 2: if(index>jazz.size() || index<1){System.out.println("Error"); return false;} break;
            case 3: if (index>rock.size() || index<1){System.out.println("Error"); return false;} break;
            case 4: if (index>country.size() || index<1){System.out.println("Error"); return false;} break;
            case 5: if (index>favorite.size() || index<1){System.out.println("Error"); return false;} break;
        }
        return true;
        // The return value.
        // Set according to whether the index is valid or not.
       
    }
}