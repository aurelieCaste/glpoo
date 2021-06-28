import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Said Belhadj
 */
public class Main {

	public static void main(String[] args) {
		
		// Path to the differents XML File
		String PLAYLIST_XML = "../xml_file/listPlaylists.xml";
		String ALBUM_XML = "../xml_file/listAlbums.xml";
		String MUSICALELEMENT_XML = "../xml_file/listMusicalElements.xml";
		
		Command.help();
	
		// Creation of ListMusicalElement, ListAlbum, ListPlaylist to store XML element from XML files inside these list 
		ArrayList<MusicalElement> lme = new ArrayList<MusicalElement>();
		ListMusicalElement ListMusicalElement = new ListMusicalElement();
		ListMusicalElement.setMusicalElements(lme);
		
		ArrayList<Album> la = new ArrayList<Album>();
		ListAlbum ListAlbums = new ListAlbum();
		ListAlbums.setListAlbums(la);
		
		ArrayList<Playlist> lp = new ArrayList<Playlist>();
		ListPlaylist ListPlaylists = new ListPlaylist();
		ListPlaylists.setPlaylists(lp);
		
		try {
			ListMusicalElement.readMusicalElement(MUSICALELEMENT_XML);
			ListAlbums.readListAlbum(ALBUM_XML);
			ListPlaylists.readListPlaylist(PLAYLIST_XML);
		} catch(java.io.FileNotFoundException e) {
			System.err.println("Fichier introuvable, veuillez mettre vos fichiers XML dans le dossier xml_file");
		} catch (IOException e) {
			System.err.println("Fichier introuvable, veuillez mettre vos fichiers XML dans le dossier xml_file");
		}
		
		boolean x = true;

		// Main Loop of jMusicHub
		while (x) {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Veuillez entrer votre commande: ");
			String command = scanner.next();

			// User commands
			switch (command) {
			case "h":
				Command.help();
				break;
			case "l":
				Command.createAudioBook(ListMusicalElement);
				break;
			case "-l":
				Command.deleteAudioBook(ListMusicalElement);
				break;
			case "*":
				ListMusicalElement.displayMusicalElement();
				break;
			case "+":
				Command.addSongToAlbum(ListMusicalElement, ListAlbums);
				break;
			case "-":
				Command.deleteSongFromAlbum(ListAlbums);
				break;
			case "++":
				Command.addMusicalElementToPlaylist(ListMusicalElement, ListPlaylists);
				break;
			case "--":
				Command.deleteMusicalElementFromPlaylist(ListPlaylists);
				break;
			case "p":
				Command.createPlaylist(ListPlaylists, ListMusicalElement);
				break;
			case "a":
				Command.createAlbum(ListAlbums);
				break;
			case "-a":
				Command.deleteAlbum(ListAlbums);
				break;
			case "albums":
				System.out.println("\n Liste des albums : \n \n" + ListAlbums.getAlbums());
				break;
			case "playlists":
				System.out.println("\n Liste des playlists : \n \n" + ListPlaylists.getPlaylists());
				break;
			case "livres":
				Command.displayAudioBooks(ListMusicalElement);
				break;
			case "chansons":
				Command.displaySongs(ListMusicalElement);
				break;
			case "c":
				Command.createSong(ListMusicalElement);
				break;
			case "-c":
				Command.deleteSong(ListMusicalElement);
				break;
			case "-p":
				Command.deletePlaylist(ListPlaylists);
				break;
			case "s":
				ListMusicalElement.storeMusicalElement(ListMusicalElement.getMusicalElements(), MUSICALELEMENT_XML);
				ListAlbums.storeListAlbum(ListAlbums.getAlbums(), ALBUM_XML);
				ListPlaylists.storeListPlaylist(ListPlaylists.getPlaylists(), PLAYLIST_XML);
				System.out.println("Vos éléments ont été sauvegardés.");
				break;
			case "q":
				Command.quit();
				break;
			default: System.err.println("Mauvaise commande");
				break;
			}     

		}

	}

}
