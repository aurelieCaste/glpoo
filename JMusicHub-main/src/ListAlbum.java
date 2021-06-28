import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Said Belhadj
 */
public class ListAlbum {
	
	
	private ArrayList<Album> Albums;
	
	/**
	 * Constructor of ListAlbum
	 */
	public ListAlbum() {
		this.getAlbums();
	}
	
	/**
	 * Getter od Album from id Album
	 * @param id int
	 * @return album Album
	 */
	public Album getAlbumOfListById(int id) {
		for(Album a : this.Albums) {
			if(a.getId() == id) {
				return a;
			}
        }
		return null;
	}
	
	/**
	 * Add Song to Album from ListMusicalElement
	 * @param idAlbum int
	 * @param idSong int
	 * @param lme ListMusicalElement
	 */
	public void addSongToAlbum(int idAlbum, int idSong, ListMusicalElement lme) {
		this.getAlbumOfListById(idAlbum).addSong(lme.getSongElementOfListById(idSong));
	}
	
	/**
	 * Add an Album to ListAlbum
	 * @param album Album
	 */
	public void addAlbumToListAlbum(Album album) {
		this.Albums.add(album);
	}
	
	/**
	 * Delete an Album to ListAlbum
	 * @param album Album
	 */
	public void deleteAlbum(Album album) {
		this.Albums.remove(album);
	}
	
	/**
	 * Getter of ListAlbum Albums sort by release date.
	 * @return Albums ArrayList<Album>
	 */
	public ArrayList<Album> getAlbums() {
		if(this.Albums != null) {
			Collections.sort(this.Albums);
		}
		return Albums;
	} 
	
	/**
	 * Setter of ListAlbum Albums.
	 * @param listAlbums ArrayList<Album>
	 */
	public void setListAlbums(ArrayList<Album> listAlbums) {
		this.Albums = listAlbums;
	}

	/**
	 * Store JAVA objects inside XML file
	 * @param list ArrayList<Album> 
	 * @param fileName: path of the XML file String
	 */
	public void storeListAlbum(ArrayList<Album> list, String fileName) {
		try {
            Serialization.encodeListAlbumsToFile(list, fileName);
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Encode and store data from XML file
	 * @param list ArrayList<MusicalElement>
	 */
	public void readListAlbum(String file) throws FileNotFoundException, IOException {
		this.getAlbums().addAll(Serialization.decodeListAlbumsFromFile(file));
	}
	
	
}
