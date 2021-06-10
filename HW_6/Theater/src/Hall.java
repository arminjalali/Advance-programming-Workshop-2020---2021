import java.util.ArrayList;

public class Hall {
    private String name;

    /**
     * Constructor
     * @param name
     */
    Hall(String name){
        this.name = name;
    }
    private ArrayList<Movie> movies = new ArrayList<>();

    /**
     * Add a movie to list
     * @param movie
     */
    public void addMovie(Movie movie){
        movies.add(movie);
    }

    /**
     * Remove a movie frim list
     * @param num
     */
    public void removeMovie(int num){
        movies.remove(num);
    }

    /**
     * Print list of movie
     */
    public void listOfMovies(){
        for (int i=0;i<movies.size();i++){
            System.out.println("[" + (i+1)+"] " + movies.get(i).getName());
        }
    }

    /**
     * Get the name of hall
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get the list of Movies
     * @return
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
