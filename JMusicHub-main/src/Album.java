import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author Said Belhadj
 */
public class Album implements Comparable<Album>{
	
	private static final AtomicInteger counta = new AtomicInteger(0); 
    private int id;
	private String title;
	private String artist;
	private int duration;
	private Date release;
	private ArrayList<Song> Songs;
	private String content;
	
	/**
	 * Constructor <b>Album<b>
	 */
	public Album() {
		this.setId(counta.incrementAndGet());
        this.getSongs();
        this.getTitle();
        this.getArtist();
        this.getContent();
        this.getRelease();
        this.getSongs();
        this.getDuration();
    }

	@Override
    public String toString() {
		SimpleDateFormat formater = new SimpleDateFormat("EEEE, d MMM yyyy");
        return "[Album][id:"+this.id+", "
        		+ "Artiste:"+this.artist+", "
        		+ "Titre:"+this.title+", "
				+ "Date de sortie:"+formater.format(this.release)+", "
				+ "Durée:"+this.getDuration()+", "
				+ "Contenu:"+this.content+", "
				+ "\n\tListe des Chansons"+this.getSongs()+"]\n";
    }
	
	@Override
	public int compareTo(Album a) {
	    return getRelease().compareTo(a.getRelease());
	}
	
	/** 
	 * Setter of Album Songs allow us to modify our current Song list  
	 * @param ArrayList of Song
	 */
	public void setSongs(ArrayList<Song> songs) {
		this.Songs = songs;
	}
	
	
	/**
	 * Getter of Album Songs. 
	 * @return ArrayList of Song
	 */
	public ArrayList<Song> getSongs() {
		if(this.Songs != null) {
			Collections.sort(this.Songs);
		}
		return this.Songs;
	}
	
	/**
	 * Add a Song to Songs ArrayList<Song>.
	 * @param Song.
	 */
	public void addSong(Song song){
		this.Songs.add(song);
	}
	
	/**
	 * Getter of Content (Album). 
	 * @return content type String.
	 */
	public String getContent() {
		return content;
	}
	
	
	/**
	 * Setter of Content (Album). the content is the path of your Album file.
	 * @param content type String.
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	
	/**
	 * Getter of id (Album).
	 * @return id type int.
	 */
	public int getId() {
		return id;
	}

	
	/**
	 * Setter of id (Album).
	 * @param id type int.
	 */
	public void setId(int id) {
		this.id = id;
	}

	
	/**
	 * Getter of title (Album).
	 * @return title type String.
	 */
	public String getTitle() {
		return title;
	}

	
	/**
	 * Setter of title (Album).
	 * @param title type String.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	/**
	 * Setter of id (Album).
	 * @return artist type int.
	 */
	public String getArtist() {
		return artist;
	}

	
	/**
	 * Setter of artist (Album).
	 * @param artist type String.
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	
	/**
	 * Getter that calculates the total duration of the all songs duration in Songs (Album).
	 * @return duration type int.
	 */
	public int getDuration() {
		int durationTotal=0;
		if(this.getSongs() != null) {
			for(Song s : this.Songs) {
				durationTotal += s.getDuration();
			}
		}
		this.duration = durationTotal;
		
		return this.duration;
	}

	
	/**
	 * Getter of release (Album).
	 * @return release type Date.
	 */
	public Date getRelease() {
		return release;
	}
	
	
	/**
	 * Setter of release (Album).
	 * @param release type Date.
	 */
	public void setRelease(Date release) {
		this.release = release;
	}
	
	/**
	 * Getter of Song from list of Song of an ALbum
	 * @param id int
	 * @return Song
	 */
	public Song getSongById(int id) {
		if(this.getSongs() != null) {
			for(Song s : this.Songs) {
				if(id == s.getId()) {
					return s;
				}
			}
		}
		return null;
	}
	
}
