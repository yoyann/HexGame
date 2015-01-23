package hexGame.model;

import java.awt.Color;
/**
 * La représentation d'un joueur et les préférences de ce dernier. 
 * @inv <pre>
 * 		getId() != null
 * 		getName() != null
 * 		getName().length() > 0
 * 		getColorPieces() != null </pre>
 */
public interface Player {
	
	// REQUETES
	
	/**
	 * PlayerId représentant la signature unique du joueur. 
	 */
	PlayerId getId();
	
	/**
	 * Le nom du joueur. 
	 */
	String getName();
	
	/**
	 * La couleur du joueur. 
	 */
	Color getColorPieces();
	
	// COMMANDES
	
	/**
	 * Change le nom du joueur.
	 * @pre <pre>
	 * 		name != null
	 * 		name.length > 0
	 * </pre>
	 * @post <pre>
	 * 		getName() == name
	 * </pre>
	 */
	void setName(String name);
	
	/**
	 * Change la coueleur d'un joueur.
	 * @pre <pre>
	 * 		color != null
	 * </pre>
	 * @post <pre>
	 * 		getColorPieces() != null
	 * </pre>
	 */
	void setColor(Color color);
}
