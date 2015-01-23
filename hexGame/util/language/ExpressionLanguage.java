package hexGame.util.language;

import java.util.HashMap;
import java.util.Map;

import hexGame.util.Contract;

/**
 * Une énumération des différentes expressions de la vue ainsi que le raccourci 
 * les représentant.
 * @inv <pre>
 * 		getShortCut() != null
 * 		getExpression(getShortCut()) == this
 * 		soit liste <- ExpressionLanguage.values()
 * 			getExpression(str) == null ==>
 * 				pour tout expr dans liste tel que 
 * 					!expr.getShortCut().equals(str)
 * 			getExpression(str) != null ==>
 * 				il existe expr dans liste tel que
 *					expr.getShortCut().equals(str)
 * </pre>
 */
public enum ExpressionLanguage {
	WINDOW_TITLE("wt"),
	WIN_TEXT("wi"),
	LOSE_TEXT("lo");
	
	// ATTRIBUTS
	
	/**
	 * Une map statique permettant de retrouver l'expression correspondant 
	 * au raccourci.
	 */
	private static Map<String, ExpressionLanguage> exprToShortcut;
	// initialisation de exprToShortcut
	static {
		exprToShortcut = new HashMap<String, ExpressionLanguage>();
		for (ExpressionLanguage expr : ExpressionLanguage.values()) {
			exprToShortcut.put(expr.getShortCut(), expr);
		}
	}
	
	/**
	 * Le string représentant l'expression.
	 */
	private String str;
	
	// CONSTRUCTEUR
	
	/**
	 * Une expression.
	 * @pre <pre>
	 * 		raccourci != null
	 * </pre>
	 * @post <pre>
	 * 		getShortCut().equals(raccourci)
	 * </pre>
	 */
	private ExpressionLanguage(String raccourci) {
		str = raccourci;
	}
	
	// REQUETES
	
	/**
	 * Le raccourci des string. 
	 */
	public String getShortCut() {
		return str;
	}
	
	/**
	 * L'expression correspondant au raccourci.
	 */
	public static ExpressionLanguage getExpression(String shortcut) {
		Contract.checkCondition(shortcut != null, 
				"Le paramètre est invalide : null.");
		return exprToShortcut.get(shortcut);
	}
}
