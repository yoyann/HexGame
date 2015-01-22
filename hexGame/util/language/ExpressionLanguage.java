package hexGame.util.language;

import hexGame.util.Contract;

public enum ExpressionLanguage {
	WINDOW_TITLE("wt");
	
	// ATTRIBUTS
	
	/**
	 * Le string représentant l'expression.
	 */
	private String str;
	
	/**
	 * Une expression.
	 * @pre
	 * 		raccourci != null
	 * @post
	 * 		getShortCut() 
	 */
	private ExpressionLanguage(String raccourci) {
		Contract.checkCondition(raccourci != null, "L'argument est invalide.");
		
		str = raccourci;
	}
	
	/**
	 * Le raccourci des string. 
	 */
	public String getShortCut() {
		return str;
	}
	
}
