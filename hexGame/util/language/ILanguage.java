package hexGame.util.language;

/**
 * Un Ilanguage est un objet contenant la totalité des expressions 
 * linguistiques.
 * @cons
 * 		$DESC$
 * 			Un language initialisé avec les commandes de l.getFile()
 * 		$ARGS$
 * 			SupportedLanguage l
 * 		$PRE$
 * 			l != null
 * 		$POST$
 * 			for all ExpressionLanguage.values() : e
 * 				getText(e) != null
 * 				getText(e) est une ligne du fichier l.getFile()	 
 *				(Toutes les expressions d'expressionLanguage ont été initialisé 
 *					avec chacun une ligne de l.getFile())
 *			getLanguage() == l
 */
public interface ILanguage {
	
	// ATTRIBUTS
	
	/**
	 * Le texte associé à l'expression expr dans le langage.
	 * @pre
	 * 		expr != null
	 */
	String getText(ExpressionLanguage expr);
	
	// COMMANDES
	
	/**
	 * Change le language utilisé.
	 * @pre
	 * 		l != null
	 * @post
	 * 		for all ExpressionLanguage.values() : e
	 *			getText(e) != null
	 *			getText(e) est une ligne du fichier l.getFile()	 
	 *			(Toutes les expressions d'expressionLanguage ont été initialisé 
	 *				avec chacun une ligne de l.getFile())
	 *			getLanguage() == l
	 */
	void changeLanguage(SupportedLanguage l);
}
