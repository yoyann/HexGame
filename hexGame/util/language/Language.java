package hexGame.util.language;

import hexGame.util.Contract;

import java.util.HashMap;


public class Language implements ILanguage {
	
	// ATTRIBUTS
	
	/**
	 * Table des string correspondant à chaque expression.
	 */
	private HashMap<ExpressionLanguage, String> expression;
	private SupportedLanguage language;
	// CONSTRUCTEUR
	
	/**
	 * Un language initialisé avec les commandes de l.getFile().
	 * @pre
	 * 		l != null
	 * @post
	 * 		for all ExpressionLanguage.values() : e
	 * 			getText(e) != null
	 * 			getText(e) est une ligne du fichier l.getFile()	 
	 *			(Toutes les expressions d'expressionLanguage ont été initialisé 
	 *				avec chacun une ligne de l.getFile())
	 *		getLanguage() == l
	 */
	public Language(SupportedLanguage l) {
		Contract.checkCondition(l != null, "L'argument est invalide.");
		
		language = l;
		loading();
	}

	// REQUETES
	
	public String getText(ExpressionLanguage expr) {
		Contract.checkCondition(expr != null, "L'argument est invalide.");
		return expression.get(expr);
	}
	
	public SupportedLanguage getLanguage() {
		return language;
	}
	// COMMANDES
	
	public void changeLanguage(SupportedLanguage l) {
		Contract.checkCondition(l != null, "L'argument est invalide.");
		
		loading();
	}
	
	// OUTILS
	
	private void loading() {
		// VERIFICATION DU NOMBRE DE LIGNE
		// BOUCLE : tant que ligne
			// LECTURE DUNE LIGNE
			// ASSOCIATION A LA PREMIERE EXPRESSION
		
		// SI ECHEC QUELCONQUE LANCER initialisation()
	}
	
	private void initialisation() {
		// CREATION DU FICHIER
		// BOUCLE : pour chaque expression
			// DEMANDE A LUTILISATEUR LE STRING CORRESPONDANT
			// INSCRIPTION DANS LE FICHIER
			// ASSOCIATION DANS LA MAP
		
		// SI ECHEC REMONTER L'EXCEPTION
	}
	

}
