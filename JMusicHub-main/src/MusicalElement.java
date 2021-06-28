import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Said Belhadj
 */
public abstract class MusicalElement {

    private static final AtomicInteger countm = new AtomicInteger(0); 
    private int id;
    private String title;
    private int duration;
    private String content;


    /**
     * Constructor of MusicalElement
     */
    public MusicalElement() {
		this.setId(countm.incrementAndGet());
        this.getTitle();
        this.getDuration();
        this.getContent();
    }
    

    /**
     * Getter of MusicalElement id
     * @return id int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Setter of MusicalElement id 
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter of MusicalElement title
     * @return title String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter of MusicalElement title
     * @param title String
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter of MusicalElement duration (second)
     * @return duration int
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Setter of MusicalElement duration (second)
     * @param duration int
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Getter of MusicalElement content
     * @return content String
     */
    public String getContent() {
        return content;
    }

    /**
     * Setter of MusicalElement content
     * @param content String
     */
    public void setContent(String content) {
        this.content = content;
    }
}
