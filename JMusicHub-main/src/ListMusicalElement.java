import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Said Belhadj
 */
public class ListMusicalElement {

	private ArrayList<MusicalElement> MusicalElements;
	
	/**
	 * Constructor of ListMusicalElement
	 */
	public ListMusicalElement() {
			this.getMusicalElements();
	}
	
	/**
	 * Add MusicalElement to a ListMusicalElement
	 * @param musicalElement MusicalElement
	 */
	public void addMusicalElementToMusicalElements(MusicalElement musicalElement) {
		this.MusicalElements.add(musicalElement);
	}
	
	/**
	 * Delete a MusicalELement from a ListMusicalELement
	 * @param musicalElement MusicalElement
	 */
	public void deleteMusicalElement(MusicalElement musicalElement) {
		this.MusicalElements.remove(musicalElement);
	}
	
	/**
	 * Getter of ListMusicalElement MusicalElements
	 * @return MusicalElement MusicalElement
	 */
	public ArrayList<MusicalElement> getMusicalElements() {
		return MusicalElements;
	}

	/**
	 * Setter of ListMusicalElement MusicalElements
	 * @param listMusicalElements ArrayList<MusicalElement>
	 */
	public void setMusicalElements(ArrayList<MusicalElement> listMusicalElements) {
		this.MusicalElements = listMusicalElements;
	}
	
	/**
	 * Getter of Musical Element inside a ListMusicalEleme
	 * nt
	 * @param id int
	 * @return m Musical Element
	 */
	public MusicalElement getMusicalElementOfListById(int id) {
		for(MusicalElement m: this.MusicalElements) {
			if(m.getId() == id) {
				return m;
			}
        }
		return null;
	}
	
	/**
	 * Getter of Song inside a ListMusicalElemnt
	 * @param id int
	 * @return s Song
	 */
	public Song getSongElementOfListById(int id) {
		for(MusicalElement s: this.MusicalElements) {
			if(s.getClass().getName() == "Song") {
				if(s.getId() == id) {
					return (Song) s;
				}
			}
        }
		return null;
	}
	
	/**
	 * Getter of AudioBook inside a ListMusicalElemnt
	 * @param id int
	 * @return a AudioBook
	 */
	public AudioBook getAudioBookElementOfListById(int id) {
		for(MusicalElement a: this.MusicalElements) {
			if(a.getClass().getName() == "AudioBook") {
				if(a.getId() == id) {
					return (AudioBook) a;
				}
			}
        }
		return null;
	}
	
	/**
	 * Display a string message of MusicalElements
	 */
	public void displayMusicalElement() {
		System.out.println(this.MusicalElements);
	}
	
	/**
	 * Display a string message of songs from MusicalElements
	 * @throws InputException 
	 */
	public void displaySongs() {
		for(MusicalElement s: this.MusicalElements) {
			if(s.getClass().getName() == "Song") {
				System.out.println(s);
			}
		}
	}
	
	/**
	 * Display the audio books from MusicalElements sort by author
	 * @throws InputException 
	 * @throws Exception 
	 */
	public void displayAudioBooks() throws InputException {
		ArrayList<AudioBook> sortList = new ArrayList<AudioBook>();
		for(MusicalElement a: this.MusicalElements) {
			if(a.getClass().getName() == "AudioBook") {
				sortList.add((AudioBook) a);
			}
		}
		if(sortList != null && !sortList.isEmpty()) {
			Collections.sort(sortList);
			for(AudioBook a : sortList) {
				System.out.println(a);
			}
		} else {
			throw new InputException("Il n'existe aucun livre");
		}
	}
	
	/**
	 * Encode and store data from XML file
	 * @param list ArrayList<MusicalElement>
	 * @param fileName: the path of the XML file String
	 */
	public void storeMusicalElement(ArrayList<MusicalElement> list, String fileName) {
		try {
            Serialization.encodeListMusicalElementToFile(list, fileName);
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	 /**
	 * Store JAVA objects inside XML file
	 * @param file String 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void readMusicalElement(String file) throws FileNotFoundException, IOException {
		this.getMusicalElements().addAll(Serialization.decodeListMusicalElementFromFile(file));
	}
	
}
