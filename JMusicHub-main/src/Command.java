import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Said Belhadj
 */
public abstract class Command {
	
	/**
	 * create an Album object according of user inputs then displays it thanks to println function and finally add it to the list of Albums.
	 * @param ListAlbums object from ListAlbums class.
	 */
	public static void createAlbum(ListAlbum ListAlbums) {
		Scanner scanAlbum = new Scanner(System.in);
		boolean error= false;
		String dtString = "";
		Date release = null;
		SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
		String titleAlbum = null;
		String contentAlbum = null;
		String artistAlbum = null;
		
		Album album = new Album();
		
		ArrayList<Song> Songs = new ArrayList<Song>();
		album.setSongs(Songs);
		
		do {
			error = false;
			try {
				System.out.println("Entrer le nom de l'artiste : \n");
				artistAlbum = scanAlbum.nextLine().trim();
				InputException.controleString(artistAlbum);
			
			}catch(InputException e) {
				error = true;
				System.err.println(e.getMessage());
				scanAlbum.nextLine().trim();
				
			}
		}while(error);
		album.setArtist(artistAlbum);
		
		do {
			error = false;
			try {
				System.out.println("Entrer votre titre : \n");
				titleAlbum = scanAlbum.nextLine().trim();
				InputException.controleString(titleAlbum);
			
			}catch(InputException e) {
				error = true;
				System.err.println(e.getMessage());
				titleAlbum = scanAlbum.nextLine().trim();
				
			}
		}while(error);
		album.setTitle(titleAlbum);

		do {
			error = false;
			try {
				System.out.println("Saisissez une date (JJ/MM/AAAA) :");
				dtString = scanAlbum.nextLine().trim();
				release = dateF.parse(dtString);
			
			}catch(java.text.ParseException e) {
				error = true;
				System.err.println("Saisie erronée : MAUVAIS FORMAT DE DATE");
				scanAlbum.nextLine().trim();
			}
		}while(error);
		album.setRelease(release);
		
		do {
			error = false;
			try {
				System.out.println("Entrer le contenu : \n");
				contentAlbum = scanAlbum.nextLine().trim();
				InputException.controleString(contentAlbum);
			
			}catch(InputException e) {
				error = true;
				contentAlbum = scanAlbum.nextLine().trim();
				System.err.println(e.getMessage());
			}
		}while(error);
		album.setContent(contentAlbum);
		
		ListAlbums.addAlbumToListAlbum(album);

		System.out.println("Votre Album a bien été créé \n" + album);
	}

	/**
	 * Delete an Album according of user inputs
	 * @param listAlbums object from ListAlbums class.
	 */
	public static void deleteAlbum(ListAlbum listAlbums) {
		Scanner sc = new Scanner(System.in);
		boolean error = true;
		int id = 0;
		
		if(!listAlbums.getAlbums().isEmpty()) {
			do {
				error = false;
				try {
					System.out.println("Veuillez saisir l'identifiant de l'Album que vous souhaitez supprimer \n");
					for(Album a : listAlbums.getAlbums()) {
						System.out.println(a);
					}
					id = sc.nextInt();
					InputException.controleInt(id);
					listAlbums.getAlbumOfListById(id).getArtist(); // if this album doesn't exist it will throw java.lang.NullPointerException 
				} catch(InputException e) {
					error = true;
					System.err.println(e.getMessage());
					sc.nextLine().trim();
				} catch(java.util.InputMismatchException e) {
					error = true;
					System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
					sc.nextLine().trim();
				} catch(java.lang.NullPointerException e) {
					error = true;
					System.err.println("CET ALBUM N'EXISTE PAS, VEUILLEZ SAISIR UN ALBUM EXISTANT");
					sc.nextLine().trim();
				} 
			} while(error);
			Album a = listAlbums.getAlbumOfListById(id);
			listAlbums.getAlbums().remove(a);
		} else {
			System.err.println("Il n'existe aucun Album");
		}
	}
	
	/**
	 * Create an AudioBook object according of user inputs then display it thanks to println function and finally adds it to ListMusical.
	 * @param ListMusicalElement object from ListMusicalElements class.
	 */
 	public static void createAudioBook(ListMusicalElement list) {
		
 		int choice = 0;
		int choice2 = 0;
		int duration = 0;
		String author = "";
		String content  = "";
		String title = "";
		boolean error = false;
		Language lg = null;
		Category ct = null;
		AudioBook book = new AudioBook();
		
		Scanner scanBook = new Scanner(System.in);
		
		
		do {
			error = false;
			try {
				System.out.println("Entrer votre titre : \n");
				title = scanBook.nextLine().trim();
				InputException.controleString(title);
			
			}catch(InputException e) {
				error = true;
				System.err.println(e.getMessage());
				title = scanBook.nextLine().trim();
			}
		}while(error);
		
		book.setTitle(title);
		
		do {
			error = false;
			try {
				System.out.println("Entrer le nom de l'auteur : \n");
				author = scanBook.nextLine().trim();
				InputException.controleString(author);
			} catch (InputException e) {
				error = true;
				System.err.println(e.getMessage());
				scanBook.nextLine().trim();
			}
		}while(error);
		
		book.setAuthor(author);
		
		do {
			error = false;
			try {
				System.out.println("Entrer le contenu : \n");
			    content = scanBook.nextLine().trim();
				InputException.controleString(content);
			} catch (InputException e) {
				error = true;
				System.err.println(e.getMessage());
				content = scanBook.nextLine().trim();
			}
		}while(error);
		
		book.setContent(content);

		
		
		
		do {
			error = false;
			try {
				
				System.out.println("Entrer la durée : \n");
				duration = scanBook.nextInt();
				InputException.controleInt(duration);
			
			}catch(java.util.InputMismatchException e) {
				error = true;
				System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
				scanBook.nextLine().trim();
			} catch (InputException e) {
				error = true;
				System.err.println(e.getMessage());
				scanBook.nextLine().trim();
			}
		}while(error);
		
		
		book.setDuration(duration);


		do {
			error = false;
			try {
				System.out.println("Sélectionner la langue : \n " + "\t 1.   FRANCAIS,\n" + "\t 2.   ANGLAIS,\n"
				+ "\t 3.   ITALIAN,\n" + "\t 4.   ESPAGNOL,\n" + "\t 5.   ALLEMAND\n");
				choice = scanBook.nextInt();
				if(choice > 5 | choice <= 0) {
					throw new InputException("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR ENTRE 1 ET 5");
				}
			
			}catch(java.util.InputMismatchException e) {
				error = true;
				System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
				scanBook.nextLine().trim();
			}catch(InputException e) {
				error = true;
				System.err.println(e.getMessage());
				scanBook.nextLine().trim();
			}
		}while(error);
		

		switch (choice) {
		case 1:
			lg = Language.FRANCAIS;
			break;
		case 2:
			lg = Language.ANGLAIS;
			break;
		case 3:
			lg = Language.ITALIEN;
			break;
		case 4:
			lg = Language.ESPAGNOL;
			break;
		case 5:
			lg = Language.ALLEMAND;
			break;
		}
		
		book.setLanguage(lg);

		

		do {
			error = false;
			try {
				System.out.println("Sélectionner la catégorie : \n " + "\t 1.   JEUNESSE,\n" + "\t 2.   ROMAN,\n"
				+ "\t 3.   THEATRE,\n" + "\t 4.   DISCOURS,\n" + "\t 5.   DOCUMENTAIRE\n");
				choice2 = scanBook.nextInt();
				if(choice2 > 5 | choice2 <= 0) {
					throw new InputException("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR ENTRE 1 ET 5");
				}
			
			}catch(java.util.InputMismatchException e) {
				error = true;
				System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
				scanBook.nextLine().trim();
			}catch(InputException e) {
				error = true;
				System.err.println(e.getMessage());
				scanBook.nextLine().trim();
			}
			
		}while(error);

		switch (choice2) {
		case 1:
			ct = Category.JEUNESSE;
			break;
		case 2:
			ct = Category.ROMAN;
			break;
		case 3:
			ct = Category.THEATRE;
			break;
		case 4:
			ct = Category.DISCOURS;
			break;
		case 5:
			ct = Category.DOCUMENTAIRE;
			break;
		}

		book.setCategory(ct);
		
		list.addMusicalElementToMusicalElements(book);
		
		System.out.println("Votre livre audio a bien été créé \n" + book);
	}
 
 	/**
	 * Delete an AudioBook according the id selected by the user.
	 * @param ListMusicalElement object from ListMusicalElements class.
	 */
 	public static void deleteAudioBook(ListMusicalElement list) {
		
 		Scanner sc = new Scanner(System.in);
		boolean error = true;
		int id = 0;
		
		if(!list.getMusicalElements().isEmpty() ) {
			do {
				error = false;
				try {
					System.out.println("Veuillez saisir l'identifiant du livre audio que vous souhaitez supprimer \n");
					list.displayAudioBooks();
					id = sc.nextInt();
					InputException.controleInt(id);
					list.getAudioBookElementOfListById(id).getAuthor(); // if this song doesn't exist it will throw java.lang.NullPointerException 
				} catch(InputException e) {
					error = true;
					System.err.println(e.getMessage());
					if(e.getMessage() == "Il n'existe aucun livre") {
						return; // On sort de la fonction car il n'y a aucun livre
					}
					sc.nextLine();
				} catch(java.util.InputMismatchException e) {
					error = true;
					System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
					sc.nextLine();
				} catch(java.lang.NullPointerException e) {
					error = true;
					System.err.println("CE LIVRE AUDIO N'EXISTE PAS, VEUILLEZ SAISIR UN LIVRE AUDIO EXISTANT");
					sc.nextLine();
				} 
			} while(error);
			AudioBook a = list.getAudioBookElementOfListById(id);
			list.getMusicalElements().remove(a);
			System.out.println("Livre audio supprimé ! (N'oubliez pas de sauvegarder vos changements)");
		} else {
			System.err.println("Il n'existe aucune chanson");
		}
	}
 	
	/**
	 * Create a Song object according of user inputs then display it thanks to println function and finally adds it to ListMusicalElements and finally diplays the created Song.
	 * @param ListMusicalElement object from ListMusicalElements class.
	 */
	public static void createSong(ListMusicalElement list) {

		Scanner scanSong = new Scanner(System.in);
		boolean error = false;
		int duration1 = 0;
		int choice1 = 0;
		String title = "";
		String content = "";
		String artist = "";
		Song sg = new Song();
		Genre genre = null;
		
		
		do {
			error = false;
			try {
				System.out.println("Entrer votre titre : \n");
				title = scanSong.nextLine().trim();
				InputException.controleString(title);
			}catch(InputException e) {
				error = true;
				System.err.println(e.getMessage());
				scanSong.nextLine().trim();
			}
		}while(error);
		sg.setTitle(title);

		do {
			error = false;
			try {
				System.out.println("Entrer le contenu : \n");
				content = scanSong.nextLine().trim();
				InputException.controleString(content);
			
			}catch(InputException e) {
				error = true;
				System.err.println(e.getMessage());
				scanSong.nextLine().trim();
			}
		}while(error);
		sg.setContent(content);
		
		do {
			error = false;
			try {
				System.out.println("Entrer le nom de l'artiste : \n");
				artist = scanSong.nextLine().trim();
				InputException.controleString(artist);
			
			}catch(InputException e) {
				error = true;
				System.err.println(e.getMessage());
				scanSong.nextLine().trim();
			}
		}while(error);
		sg.setArtist(artist);
		
		
		do {
			error = false;
			try {
				System.out.println("Entrer la durée : \n");
				duration1 = scanSong.nextInt();
			
			}catch(java.util.InputMismatchException e) {
				error = true;
				System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
				scanSong.nextLine().trim();
			}
		}while(error);
		sg.setDuration(duration1);

		do {
			error = false;
			try {
				System.out.println("Sélectionner le genre : \n " + "\t 1.   JAZZ,\n" + "\t 2.   CLASSIQUE,\n"
				+ "\t 3.   HIPHOP,\n" + "\t 4.   ROCK,\n" + "\t 5.   POP,\n" + "\t 6.   RAP");
				choice1 = scanSong.nextInt();
				if(choice1 > 6 | choice1 <= 0) {
					throw new InputException("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR ENTRE 1 ET 6");
				}
			
			}catch(java.util.InputMismatchException e) {
				error = true;
				System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
				scanSong.nextLine().trim();
			}catch(InputException e) {
				error = true;
				System.err.println(e.getMessage());
				scanSong.nextLine().trim();
			}
		}while(error);

		switch (choice1) {
		case 1:
			genre = Genre.JAZZ;
			break;
		case 2:
			genre = Genre.CLASSIC;
			break;
		case 3:
			genre = Genre.HIPHOP;
			break;
		case 4:
			genre = Genre.ROCK;
			break;
		case 5:
			genre = Genre.POP;
			break;
		case 6:
			genre = Genre.RAP;
			break;
		}
		
		sg.setGenre(genre);
		
		list.addMusicalElementToMusicalElements(sg);

		System.out.println("Votre chanson a bien été créé \n" + sg);
	}

	/**
	 * Delete a Song according the id selected by the user.
	 * @param ListMusicalElement object from ListMusicalElements class.
	 */
	public static void deleteSong(ListMusicalElement list) {
		Scanner sc = new Scanner(System.in);
		boolean error = true;
		int id = 0;
		
		if(!list.getMusicalElements().isEmpty()) {
			do {
				error = false;
				try {
					System.out.println("Veuillez saisir l'identifiant de la chanson que vous souhaitez supprimer \n");
					list.displaySongs();
					id = sc.nextInt();
					InputException.controleInt(id);
					list.getSongElementOfListById(id).getArtist(); // if this song doesn't exist it will throw java.lang.NullPointerException 
				} catch(InputException e) {
					error = true;
					System.err.println(e.getMessage());
					if(e.getMessage() == "Il n'existe aucune chanson") {
						return; // On sort de la fonction car il n'y a aucun livre
					}
					sc.nextLine().trim();
				} catch(java.util.InputMismatchException e) {
					error = true;
					System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
					sc.nextLine().trim();
				} catch(java.lang.NullPointerException e) {
					error = true;
					System.err.println("CET CHANSON N'EXISTE PAS, VEUILLEZ SAISIR UNE CHANSON EXISTANTE");
					sc.nextLine().trim();
				} 
			} while(error);
			Song s = list.getSongElementOfListById(id);
			list.getMusicalElements().remove(s);
			System.out.println("Chanson supprimée ! (N'oubliez pas de sauvegarder vos changements)");
		} else {
			System.err.println("Il n'existe aucune chanson");
		}
	}
	
	/**
	 * Displays Guide of all user command.
	 */
	public static void help() {
		String guide = "Mode d'emploi :\n"
				+ "\t - « a » : ajout d’un nouvel album \n"
				+ "\t - « -a » : suppression d’un album \n"
				+ "\t - « + » : ajout d’une chanson existante à un album\n "
				+ "\t - « - » : supression d’une chanson d'un album\n "
				+ "\t - « ++ » : ajout d’un élément existant à une playlist\n "
				+ "\t - « -- » : supression d’un élément d'une playlist\n "
				+ "\t - « livres » : afficher tous les livres \n "
				+ "\t - « chansons » : afficher toutes les chansons \n "
				+ "\t - « playlists » : afficher toutes les playlists\n "
				+ "\t - « albums » : afficher tous les albums\n "
				+ "\t - « * » : afficher tous les éléments musicaux \n "
				+ "\t - « l » : ajout d’un nouveau livre audio\n "
				+ "\t - « -l » : suppression d'un livre audio\n "
				+ "\t - « c » : ajout d’une nouvelle chanson\n "
				+ "\t - « -c » : ajout d’une nouvelle chanson\n "
				+ "\t - « p » : création d’une nouvelle playlist à partir de chansons et livres audio existants\n "
				+ "\t - « -p » : suppression d’une playlist\n"
				+ "\t - « s » : sauvegarde des playlists, des albums, des chansons et des livres audios dans les fichiers\n"
				+ "\t - « q » : Quitter l'application\n";
		
		System.out.println(guide);
	}
	
	/**
	 * quit the application and to display a goodbye message in String format.
	 */
	public static void quit() {
		System.err.println("Merci et à bientôt !");
		System.exit(0);
	}
	
	/**
	 * Add MusicalElement from ListMusicalElements to playlist.
	 * @param ListMusicalElement object from ListMusicalElements class.
	 * @param ListAlbum object from ListAlbum class.
	 */
	public static void addMusicalElementToPlaylist(ListMusicalElement lme, ListPlaylist lp) {
		
		Scanner sc = new Scanner(System.in);
		boolean error = false;
		int id = 0;
		int idMusicalElement = 0;
		
		
		do {
			error = false;
			try {
				System.out.println("Veuillez saisir l\'id de la playlist(rangé par nom)");
				for(Playlist p : lp.getPlaylists()) {
					System.out.println("ID : "+p.getId()+") "+p);
				}
				id = sc.nextInt();
				lp.getPlaylistOfListById(id).getName();// Throw NullPointerException if it doesn't exist
			}catch(java.util.InputMismatchException e) {
				error = true;
				System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
				sc.nextLine();
			}catch(java.lang.NullPointerException e) {
				error = true;
				System.err.println("CETTE PLAYLIST N'EXISTE PAS, VEUILLEZ SAISIR UN ALBUM EXISTANT");
				sc.nextLine().trim();
			}
			
		}while(error);
		
		do {
			error = false;
			try {
				System.out.println("Veuillez saisir l\'id de la chanson que vous voulez ajouter à l'album "+ lp.getPlaylistOfListById(id).getName());
				for(MusicalElement m : lme.getMusicalElements()) {
					System.out.println("ID : "+m.getId()+") "+m);
				}
				idMusicalElement = sc.nextInt();
				lme.getMusicalElementOfListById(idMusicalElement).getTitle();// Throw NullPointerException if it doesn't exist
			}catch(java.util.InputMismatchException e) {
				error = true;
				System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
				sc.nextLine().trim();
			}catch(java.lang.NullPointerException e) {
				error = true;
				System.err.println("CET ÉLÉMENT N'EXISTE PAS, VEUILLEZ SAISIR UN ÉLÉMENT EXISTANT");
				sc.nextLine().trim();
			}
		}while(error);
		
		lp.addMusicalElementToPlaylist(id, idMusicalElement, lme);
		System.out.println("\nL'élément : "
							+lme.getMusicalElementOfListById(idMusicalElement)
							+" a bien été ajoutée à l'album : \n"+
							lp.getPlaylistOfListById(id));
	}
	
	/**
	 * Delete MusicalElement from a playlist.
	 * @param ListAlbum object from ListAlbum class.
	 */
	public static void deleteMusicalElementFromPlaylist(ListPlaylist lp) {
		Scanner sc = new Scanner(System.in);
		boolean error = false;
		int idPlaylist = 0;
		int idMusicalElement = 0;
		
		do {
			error = false;
			try {
				System.out.println("Veuillez saisir l\'id d'une playlist");
				for(Playlist p : lp.getPlaylists()) {
					System.out.println("ID : "+p.getId()+") "+p);
				}
				idPlaylist = sc.nextInt();
				lp.getPlaylistOfListById(idPlaylist).getName();// Throw NullPointerException if it doesn't exist
			}catch(java.util.InputMismatchException e) {
				error = true;
				System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
				sc.nextLine().trim();
			}catch(java.lang.NullPointerException e) {
				error = true;
				System.err.println("CETTE PLAYLIST N'EXISTE PAS, VEUILLEZ SAISIR UNE PLAYLIST EXISTANTE");
				sc.nextLine().trim();
			}
			
		}while(error);
		
		if(!lp.getPlaylistOfListById(idPlaylist).getMusicalElements().isEmpty() && lp.getPlaylistOfListById(idPlaylist).getMusicalElements() != null) {
			do {
				error = false;
				try {
					System.out.println("Veuillez saisir l\'id de l'élément que vous souhaitez supprimer de la playlist "+ lp.getPlaylistOfListById(idPlaylist).getName());
					for(MusicalElement m: lp.getPlaylistOfListById(idPlaylist).getMusicalElements()) {
						System.out.println("ID : "+m.getId()+") "+m);
					}
					idMusicalElement = sc.nextInt();
					lp.getPlaylistOfListById(idPlaylist).getMusicalElementById(idMusicalElement).getTitle();// Throw NullPointerException if it doesn't exist
				}catch(java.util.InputMismatchException e) {
					error = true;
					System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
					sc.nextLine().trim();
				}catch(java.lang.NullPointerException e) {
					error = true;
					System.err.println("CET ÉLÉMENT N'EXISTE PAS");
					sc.nextLine().trim();
				}
			}while(error);
			
			System.out.println("\nL' élément : \n"
								+lp.getPlaylistOfListById(idPlaylist).getMusicalElementById(idMusicalElement)
								+"\n a bien été supprimée de la playlist : \n\t"+
								lp.getPlaylistOfListById(idPlaylist).getName());
			lp.getPlaylistOfListById(idPlaylist).getMusicalElements().remove(lp.getPlaylistOfListById(idPlaylist).getMusicalElementById(idMusicalElement)); // This line remove a Song from an album
			
		} else {
			System.err.println("La playlist : "+lp.getPlaylistOfListById(idPlaylist).getName()+" ne contient aucun élément");
		}
		
	}
	
	/**
	 * Add Song from ListMusicalElements to album.
	 * @param ListMusicalElement object from ListMusicalElements class.
	 * @param ListAlbum object from ListAlbum class.
	 */
	public static void addSongToAlbum(ListMusicalElement lme, ListAlbum la) {
		
		Scanner sc = new Scanner(System.in);
		boolean error = false;
		int idAlbum = 0;
		int idSong = 0;
		
		
		do {
			error = false;
			try {
				System.out.println("Veuillez saisir l\'id de l\'album (rangé par date)");
				for(Album a : la.getAlbums()) {
					System.out.println("ID : "+a.getId()+") "+a);
				}
				idAlbum = sc.nextInt();
				la.getAlbumOfListById(idAlbum).getTitle();// Throw NullPointerException if it doesn't exist
			}catch(java.util.InputMismatchException e) {
				error = true;
				System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
				sc.nextLine();
			}catch(java.lang.NullPointerException e) {
				error = true;
				System.err.println("CET ALBUM N'EXISTE PAS, VEUILLEZ SAISIR UN ALBUM EXISTANT");
				sc.nextLine().trim();
			}
			
		}while(error);
		
		do {
			error = false;
			try {
				System.out.println("Veuillez saisir l\'id de la chanson que vous voulez ajouter à l'album "+ la.getAlbumOfListById(idAlbum).getTitle());
				for(MusicalElement s : lme.getMusicalElements()) {
					if(s.getClass().getName() == "Song") {
						System.out.println(s.getId()+") "+s);
					}
				}
				idSong = sc.nextInt();
				lme.getSongElementOfListById(idSong).getArtist();// Throw NullPointerException if it doesn't exist
			}catch(java.util.InputMismatchException e) {
				error = true;
				System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
				sc.nextLine().trim();
			}catch(java.lang.NullPointerException e) {
				error = true;
				System.err.println("CETTE CHANSON N'EXISTE PAS, VEUILLEZ SAISIR UNE CHANSON EXISTANTE");
				sc.nextLine().trim();
			}
		}while(error);
		
		la.addSongToAlbum(idAlbum, idSong, lme);
		System.out.println("\n La chanson : "
							+lme.getSongElementOfListById(idSong)
							+" a bien été ajoutée à l'album : \n"+
							la.getAlbumOfListById(idAlbum));
	}

	/**
	 * Delete Song from an album.
	 * @param ListAlbum object from ListAlbum class.
	 */
	public static void deleteSongFromAlbum(ListAlbum la) {
		Scanner sc = new Scanner(System.in);
		boolean error = false;
		int idAlbum = 0;
		int idSong = 0;
		
		do {
			error = false;
			try {
				System.out.println("Veuillez saisir l\'id de l\'album");
				for(Album a : la.getAlbums()) {
					System.out.println("ID : "+a.getId()+") "+a);
				}
				idAlbum = sc.nextInt();
				la.getAlbumOfListById(idAlbum).getTitle();// Throw NullPointerException if it doesn't exist
			}catch(java.util.InputMismatchException e) {
				error = true;
				System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
				sc.nextLine().trim();
			}catch(java.lang.NullPointerException e) {
				error = true;
				System.err.println("CET ALBUM N'EXISTE PAS, VEUILLEZ SAISIR UN ALBUM EXISTANT");
				sc.nextLine().trim();
			}
			
		}while(error);
		
		if(!la.getAlbumOfListById(idAlbum).getSongs().isEmpty() && la.getAlbumOfListById(idAlbum).getSongs() != null) {
			do {
				error = false;
				try {
					System.out.println("Veuillez saisir l\'id de la chanson que vous voulez supprimer de l'album "+ la.getAlbumOfListById(idAlbum).getTitle());
					for(Song s : la.getAlbumOfListById(idAlbum).getSongs()) {
						System.out.println(s.getId()+") "+s);
					}
					idSong = sc.nextInt();
					la.getAlbumOfListById(idAlbum).getSongById(idSong).getArtist();// Throw NullPointerException if it doesn't exist
				}catch(java.util.InputMismatchException e) {
					error = true;
					System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
					sc.nextLine().trim();
				}catch(java.lang.NullPointerException e) {
					error = true;
					System.err.println("CETTE CHANSON N'EXISTE PAS");
					sc.nextLine().trim();
				}
			}while(error);
			
			System.out.println("\n La chanson : \n"
								+la.getAlbumOfListById(idAlbum).getSongById(idSong)
								+"\n a bien été supprimée de l'album : \n\t"+
								la.getAlbumOfListById(idAlbum).getTitle());
			la.getAlbumOfListById(idAlbum).getSongs().remove(la.getAlbumOfListById(idAlbum).getSongById(idSong)); // This line remove a Song from an album
			
		} else {
			System.err.println("l'Album : "+la.getAlbumOfListById(idAlbum).getTitle()+" ne contient aucune chanson");
		}
		
		
	}


	/**
	 * create a Playlist object according of user inputs then displays it thanks to println function and finally add it to the list of Playlist.
	 * @param ListPlaylists object from ListPlaylists class.
	 * @param ListMusicalElement object from  ListMusicalElements class.
	 */
	public static void createPlaylist(ListPlaylist ListPlaylists, ListMusicalElement list) {
		Scanner scanAlbum = new Scanner(System.in);
		boolean error= false;
		String name = "";
		
		Playlist p = new Playlist();
		
		ArrayList<MusicalElement> me = new ArrayList<MusicalElement>();
		p.setMusicalElements(me);
		
		do {
			error = false;
			try {
				System.out.println("Entrer le Nom de votre playlist : \n");
				name = scanAlbum.nextLine().trim();
				InputException.controleString(name);
			
			}catch(InputException e) {
				error = true;
				System.err.println(e.getMessage());
				name= scanAlbum.nextLine().trim();
			}
		}while(error);
		p.setName(name);
		
		ListPlaylists.addPlaylistToListPlaylist(p);

		System.out.println("Votre Playlist a bien été créé \n" + p);
	}
	
	/**
	 * Delete a playlist from user input .
	 * @param ListPlaylists object from ListPlaylists class.
	 */
	public static void deletePlaylist(ListPlaylist list) {

		Scanner sc = new Scanner(System.in);
		boolean error = true;
		int id = 0;
		
		if(!list.getPlaylists().isEmpty()) {
			System.out.println("Veuillez saisir l'identifiant de la playlist que vous souhaitez supprimer \n");
			for(Playlist p : list.getPlaylists()) {
				System.out.println("ID : "+p.getId()+") "+p);
			}
			do {
				error = false;
				try {
					id = sc.nextInt();
					InputException.controleInt(id);
					list.getPlaylistOfListById(id).getName();// Throw NullPointerException if it doesn't exist
				} catch(InputException e) {
					error = true;
					System.err.println(e.getMessage());
					sc.nextLine().trim();
				} catch(java.util.InputMismatchException e) {
					error = true;
					System.err.println("ENTRÉE INVALIDE CECI N'EST PAS UNE VALEUR NUMERIQUE");
					sc.nextLine().trim();
				} catch(java.lang.NullPointerException e) {
					error = true;
					System.err.println("CETTE PLAYLIST N'EXISTE PAS, VEUILLEZ SAISIR UNE PLAYLIST EXISTANTE");
					sc.nextLine().trim();
				} 
			} while(error);
			Playlist p = list.getPlaylistOfListById(id);
			list.getPlaylists().remove(p);
		} else {
			System.err.println("Il n'existe aucune playlist");
		}
		
	}
	
	/**
	 * Display a string message of audio books from MusicalElements
	 * @param ListMusicalElement
	 */
	public static void displayAudioBooks(ListMusicalElement list) {
		try {
			list.displayAudioBooks();
		} catch(InputException e) {
			if(e.getMessage() == "Il n'existe aucun livre") {
				return;
			}
		}
	}
	
	/**
	 * Display a string message of audio books from MusicalElements
	 * @param ListMusicalElement
	 */
	public static void displaySongs(ListMusicalElement list) {
		list.displaySongs();
	}
	
}
