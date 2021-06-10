import java.io.Serializable;

public class Note implements Serializable {
    private String title;
    private String content;
    private String date;

    /**
     * Constructor and initialize
     *
     * @param title
     * @param content
     * @param date
     */
    public Note(String title, String content, String date) {
        this.content = content;
        this.date = date;
        this.title = title;
    }

    /**
     * get content of note
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * Edit text of note
     * @param s
     */
    public void changeContent(String s) {
        this.content = s;
    }

    /**
     * Get title of note
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get date
     * @return date
     */
    public String getDate() {
        return date;
    }
}
