import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
	
/**
 * @author Said Belhadj
 */
public final class Serialization {
	
	    private Serialization() {}
	    
	    /**
	     * This function encode JAVA object (ArrayList<MusicalElement>) to XMl element.
	     * @param list ArrayList<MusicalElement>
	     * @param fileName String
	     * @throws FileNotFoundException
	     * @throws IOException
	     */
	    public static void encodeListMusicalElementToFile(ArrayList<MusicalElement> list, String fileName) throws FileNotFoundException, IOException {
	        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
	        try {
	            encoder.writeObject(list);
	            encoder.flush();
	        } finally {
	            encoder.close();
	        }
	    }

	    /**
	     * This function decode XML file to JAVA object. 
	     * @param fileName String
	     * @return list Collection<? extends MusicalElement> 
	     * @throws FileNotFoundException
	     * @throws IOException
	     */
	    @SuppressWarnings("unchecked")
		public static Collection<MusicalElement> decodeListMusicalElementFromFile(String fileName) throws FileNotFoundException, IOException {
	    	Collection<MusicalElement> list;
	        XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
	        try {
	            list = (Collection<MusicalElement>) decoder.readObject();
	        } finally {
	            decoder.close();
	        }
	        return list;
	    }
	    
		/**
	     * This function encode JAVA object to XMl element.
	     * @param list Collection<Album>
	     * @param fileName String
	     * @throws FileNotFoundException
	     * @throws IOException
	     */
	    public static void encodeListAlbumsToFile(Collection<Album> list, String fileName) throws FileNotFoundException, IOException {
	        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
	        try {
	            encoder.writeObject(list);
	            encoder.flush();
	        } finally {
	            encoder.close();
	        }
	    
	    }
	    
	    /**
	     * This function decode XML file to JAVA object. 
	     * @param fileName String
	     * @return list Collection<Album> 
	     * @throws FileNotFoundException
	     * @throws IOException
	     */
	    @SuppressWarnings("unchecked")
		public static Collection<Album> decodeListAlbumsFromFile(String fileName) throws FileNotFoundException, IOException {
	    	Collection<Album> list;
	        XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
	        try {
	            list = (Collection<Album>) decoder.readObject();
	        } finally {
	            decoder.close();
	        }
	        return list;
	    }
	    
		/**
	     * This function encode JAVA object to XMl element.
	     * @param list Collection<Playlist>
	     * @param fileName String
	     * @throws FileNotFoundException
	     * @throws IOException
	     */
	    public static void encodeListPlaylistsToFile(Collection<Playlist> list, String fileName) throws FileNotFoundException, IOException {
	        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
	        try {
	            encoder.writeObject(list);
	            encoder.flush();
	        } finally {
	            encoder.close();
	        }
	    
	    }
	    
	    /**
	     * This function decode XML file to JAVA object. 
	     * @param fileName String
	     * @return list Collection<Playlist>
	     * @throws FileNotFoundException
	     * @throws IOException
	     */
	    @SuppressWarnings("unchecked")
		public static Collection<Playlist> decodeListPlaylistsFromFile(String fileName) throws FileNotFoundException, IOException {
	    	Collection<Playlist> list;
	        XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
	        try {
	            list = (Collection<Playlist>) decoder.readObject();
	        } finally {
	            decoder.close();
	        }
	        return list;
	    }


}
