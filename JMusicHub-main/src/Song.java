/**
 * @author Said Belhadj
 */
public class Song extends MusicalElement implements Comparable<Song>{


    private String artist;
    private Genre genre;

   /**
    * Constructor Song
    */
   public Song(){
	   super();
	   this.getTitle();
	   this.getDuration();
	   this.getContent();
	   this.getArtist();
	   this.getGenre();
   }
    
    @Override
    public String toString() {
        return "\n\t[Chanson][id:"+this.getId()+", "
        		+ "Artiste:"+this.artist+", "
        		+ "Titre:"+this.getTitle()+", "
				+ "Durée:"+this.getDuration()+", "
				+ "Contenu:"+this.getContent()+", "
				+ "Genre:"+this.getGenre()+"]";
    }
    
    @Override
	public int compareTo(Song s) {
	    return getGenre().compareTo(s.getGenre());
	}
    
    /**
     * Getter of Song genre
     * @return genre Genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Setter of Song genre
     * @param genre Genre
     */
    public void setGenre(Genre genre) { 
        this.genre = genre;
    }

    /**
     * Getter of Song artist
     * @return artist String
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Setter of Song artist
     * @param artist String
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
   
}
