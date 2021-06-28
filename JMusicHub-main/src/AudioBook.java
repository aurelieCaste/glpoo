/**
 * @author Said Belhadj
 */
public class AudioBook extends MusicalElement implements Comparable<AudioBook>{

    private String author;
    private Language language;
    private Category category;
    
    /**
	 * Constructor AudioBook.
	 */
    public AudioBook () {
        super();
        this.getAuthor();
        this.getLanguage();
        this.getCategory();
    }
    
    @Override
    public String toString() {
        return "\n\t[Livre audio][id:"+this.getId()+", "
        		+ "Author:"+this.author+", "
        		+ "Titre:"+this.getTitle()+", "
				+ "Durée:"+this.getDuration()+", "
				+ "Contenu:"+this.getContent()+", "
				+ "Langue:"+this.language+","
				+ "Catégorie:"+this.category+"]";
    }
    
    /**
     * Allow us to sort audio books by Author 
     * @param a AudioBook
     * @return int
     */
    @Override
	public int compareTo(AudioBook a) {
	    return getAuthor().compareTo(a.getAuthor());
	}

    /**
	 * Getter of Language (AudioBook).
	 * @return language type Language.
	 */
    public Language getLanguage() {
        return language;
    }

    /**
	 * Setter of Language (AudioBook).
	 * @param language type Language.
	 */
    public void setLanguage(Language language) {
        this.language = language;
    }
    
    /**
	 * Getter of Category (AudioBook).
	 * @return category type Category.
	 */
    public Category getCategory() {
        return category;
    }

    /**
	 * Setter of Category (AudioBook).
	 * @param category type Category.
	 */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
	 * Getter of author (AudioBook).
	 * @return author type String.
	 */
    public String getAuthor() {
        return author;
    }

    /**
	 * Setter of author (AudioBook).
	 * @param author type String.
	 */
    public void setAuthor(String author) {
        this.author = author;
    }

}
