import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Playlist implements Comparable<Playlist>{

	private static final AtomicInteger countp = new AtomicInteger(0); 
    private int id;
	private String name;
	private ArrayList<MusicalElement> MusicalElements;
	
	/**
	 * Constructor <b>Playlist<b>
	 */
	public Playlist() {
		this.setId(countp.incrementAndGet());
		this.getName();
        this.getMusicalElements();
       
    }

	@Override
    public String toString() {
        return "[Playlist][id:"+this.id+", "
        		+ "Nom:"+this.name+", "
				+ "\n\tListe des éléments"+this.getMusicalElements()+"]\n";
    }
	
	@Override
	public int compareTo(Playlist p) {
	    return getName().compareTo(p.getName());
	}
	
	/** 
	 * Setter of Playlist MusicalElement allow us to modify our current Song list  
	 * @param ArrayList<MusicalElement>
	 */
	public void setMusicalElements(ArrayList<MusicalElement> me) {
		this.MusicalElements = me;
	}
	
	
	/**
	 * Getter of Playlist MusicalElement. 
	 * @return ArrayList<MusicalElement>
	 */
	public ArrayList<MusicalElement> getMusicalElements() {
		return this.MusicalElements;
	}
	
	/**
	 * Add a MusicalElement to MusicalElements ArrayList<MusicalElement>.
	 * @param MusicalElement.
	 */
	public void addMusicalElement(MusicalElement m){
		this.MusicalElements.add(m);
	}
	
	
	/**
	 * Getter of id (Playlist).
	 * @return id type int.
	 */
	public int getId() {
		return id;
	}

	
	/**
	 * Setter of id (Playlist).
	 * @param id type int.
	 */
	public void setId(int id) {
		this.id = id;
	}

	
	/**
	 * Getter of Name's Playlist.
	 * @return name type String.
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * Setter of Name's Playlist.
	 * @param name type String.
	 */
	public void setName(String title) {
		this.name = title;
	}
	
	/**
	 * Getter of MusicalElement from list of MusicalElement of a Playlist
	 * @param id int
	 * @return Song
	 */
	public MusicalElement getMusicalElementById(int id) {
		if(this.getMusicalElements() != null) {
			for(MusicalElement m : this.MusicalElements) {
				if(id == m.getId()) {
					return m;
				}
			}
		}
		return null;
	}
	
}
