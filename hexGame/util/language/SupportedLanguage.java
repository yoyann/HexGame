package hexGame.util.language;

import hexGame.util.Contract;
import java.io.File;

/**
 * Les langages supportés par l'appli.
 * @inv <pre>
 *		getFile() != null
 * </pre>
 */
public enum SupportedLanguage {
	FRANCAIS("francais.lang"),
	ENGLISH("english.lang");
	
	// ATTRIBUTS
	
	/**
	 * Le fichier associé au langage.
	 */
	private File file;
	
	// CONSTRUCTEUR
	
	/**
	 * Un langage supporté.
	 * @pre <pre>
	 * 		fileName != null 
	 * </pre>
	 * @post <pre>
	 * 		getFile().getName() == fileName
	 * </pre>
	 */
	private SupportedLanguage(String fileName) {
		Contract.checkCondition(fileName != null, 
				"Le paramètre doit être différent de null.");

		file = new File(fileName);
	}
	
	// REQUETES
	
	/**
	 * Le fichier associé au langage.
	 */
	public File getFile() {
		return file;
	} 
}
