package hexGame.util.language;

import hexGame.util.Contract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Language implements ILanguage {
	
	// ATTRIBUTS
	
	/**
	 * Table des string correspondant à chaque expression.
	 */
	private Map<ExpressionLanguage, String> expression;
	
	/**
	 * Le langage représenté.
	 */
	private SupportedLanguage language;
	
	// CONSTRUCTEUR
	
	/**
	 * Un language initialisé avec les commandes de l.getFile().
	 * @throws IOException 
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
	public Language(SupportedLanguage l) throws IOException {
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
	
	public void changeLanguage(SupportedLanguage l) throws IOException {
		Contract.checkCondition(l != null, "L'argument est invalide.");
		
		loading();
	}
	
	// OUTILS
	
	/**
	 * @throws IOException
	 */
	private void loading() throws IOException {
		expression.clear();
		BufferedReader fluxIn = new BufferedReader(
				new FileReader(getLanguage().getFile()));
		try {
			String str = fluxIn.readLine();
			while (str != null) {
				int begin = str.indexOf(" ");
				expression.put(ExpressionLanguage.getExpression(
						//shortcut
						str.substring(0, begin)),
						//expression
						str.substring(begin + 1));
				str = fluxIn.readLine();
			}
		} finally {
			fluxIn.close();
		}
		for (ExpressionLanguage expr : ExpressionLanguage.values()) {
			if (!expression.containsKey(expr)) {
				expression.put(expr, UNDEFINED_EXPRESSION);
			}
		}
	}
}
