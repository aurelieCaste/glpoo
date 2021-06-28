import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Said Belhadj
 */
public class ListPlaylist {
	
	private ArrayList<Playlist> Playlists;

	/**
	 * Constructor of ListPlaylist
	 */
	public ListPlaylist() {
		this.getPlaylists();
	}
	
	/**
	 * Getter of ListPlaylist Playlists sort by name 
	 * @return Playlists ArrayList<Playlist>
	 */
	public ArrayList<Playlist> getPlaylists() {
		if(this.Playlists != null) {
			Collections.sort(this.Playlists);
		}
		return Playlists;
	}
	
	/**
	 * Setter of ListPlaylist Playlists
	 * @param listPlaylists ArrayList<Playlist> 
	 */
	public void setPlaylists(ArrayList<Playlist> listPlaylists) {
		this.Playlists = listPlaylists;
	}
	
	/**
	 * Encode and store data from XML file
	 * @param fileName: path to XML file String
	 * @param list ArrayList<Playlist>
	 */
	public void storeListPlaylist(ArrayList<Playlist> list, String fileName) {
		try {
            Serialization.encodeListPlaylistsToFile(list, fileName);
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Getter of Playlist from id Playlist
	 * @return playlist Playlist
	 */
	public Playlist getPlaylistOfListById(int id) {
		for(Playlist p: this.Playlists) {
			if(p.getId() == id) {
				return p;
			}
        }
		return null;
	}
	
	/**
	 * Store JAVA objects inside XML file
	 * @param file String 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void readListPlaylist(String file) throws FileNotFoundException, IOException {
		this.getPlaylists().addAll(Serialization.decodeListPlaylistsFromFile(file));
	}

	/**
	 * Add a Playlist object to ListPlaylist 
	 * @param pl Playlist
	 */
	public void addPlaylistToListPlaylist(Playlist pl) {
		this.Playlists.add(pl);
		
	}
	
	/**
	 * Add MusicalElement to Playlist from ListMusicalElement
	 * @param idPlaylist int
	 * @param idMusicalElement int
	 * @param lme ListMusicalElement
	 */
	public void addMusicalElementToPlaylist(int idPlaylist, int idMusicalElement, ListMusicalElement lme) {
		this.getPlaylistOfListById(idPlaylist).addMusicalElement(lme.getMusicalElementOfListById(idMusicalElement));
	}
}
