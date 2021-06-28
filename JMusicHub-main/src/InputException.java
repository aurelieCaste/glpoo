
/**
 * @author Said Belhadj
 *This class manage exception that not throws by java.lang.object or default java exception class
 */
@SuppressWarnings("serial")
public class InputException extends Exception {
	
	/**
	 * Constructor of InputException
	 */
	public InputException() {
		  super();
	}
	
	/**
	 * Constructor of InputException
	 * @param msg String
	 */
	public InputException(String msg) {
	  super(msg);
	}
	
	/**
	 * Verify some handling errors regarding string type
	 * @param chaine String
	 * @throws InputException
	 */
	public static void controleString(String chaine) throws InputException {
		if (chaine.equals("") == true) {
			throw new InputException("Saisie erronée : chaine vide");
		}else if(chaine.length() >= 50) {
	  		throw new InputException("Saisie erronée : chaine trop longue");
	  	 }
	 }
	 
	/**
	 * Verify some handling errors regarding int type
	 * @param integer
	 * @throws InputException
	 */
	 public static void controleInt(int integer) throws InputException {
		 if (integer >= 10000000) {
			  throw new InputException("Saisie erronée : entrée trop longue");
	  	  }else if(integer < 0) {
	  		  throw new InputException("Saisie erronée : entrée negative");
	  	  }
	  }
	  
}
