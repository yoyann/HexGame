package hexGame.model;

import java.util.Set;

import hexGame.util.Coord;

/** 
 * @inv <pre>
 * 		MIN_SIZE_BOARD <= getSize() <= MAX_SIZE_BOARD
 *		getNextMoveAI() != null
 * 		getPlayer() != null 
 *		isFreeTile(getNextMoveAI())
 * 		isFinished() <=> Il existe un unique PlayerId p tel que hasPlayerWon(p)
 * 		getPositions(p) != null
 * </pre>
 * 		
 * @cons
 * 		Construit un modele representant un jeu de hex fournit avec une IA.
 * 		$ARGS$ /
 * 		$PRE$ /
 * 		$POST$ <pre>
 * 			getSize() == MAX_SIZE_BOARD
 * 			forall Coord c : (0, 0) .. (getSize() - 1, getSize() - 1) : 
 * 				isFreeTile(c)</pre>
 */
public interface HexModel {
	// ATTRIBUTS
	
	/**
	 * La taille minimale d'un plateau de jeu.
	 */
	public static final int MIN_SIZE_BOARD = 4;
	/**
	 * La taille maximale d'un plateau de jeu.
	 */
	public static final int MAX_SIZE_BOARD = 11;
	
	// REQUETES
	
	/**
	 * Calcule le prochain mouvement que jouerait l'IA et le renvoie.
	 * @pre <pre>
	 * 		!isFinished()</pre>
	 */
	Coord getNextMoveAI();
	
	/**
	 * Retourne la taille du plateau.
	 */
	int getSize();
	
	/**
	 * Retourne le prochain joueur a jouer.
	 */
	PlayerId getPlayer();
	
	/**
	 * Teste si la case en c est vide.
	 * @pre <pre>
	 * 		c != null</pre>
	 */
	boolean isFreeTile(Coord c);
	
	/**
	 * Teste si une partie est terminée.
	 */
	boolean isFinished();
	
	/**
	 * Teste si le joueur p a gagne la partie.
	 * @pre <pre>
	 * 		p != null</pre>
	 */
	boolean hasPlayerWon(PlayerId p);
	
	/**
	 * Renvoie la liste des coordonnées où joueur a des pièces.
	 * @pre <pre>
	 * 		p != null</pre>
	 */
	Set<Coord> getPositions(PlayerId p); 
	
	// COMMANDES
	
	/**
	 * Joue pour le joueur getPlayer() un mouvement en c.
	 * @pre <pre>
	 * 		c != null
	 * 		isFreeTile(c)
	 * 		!isFinished()</pre>
	 * @post <pre>
	 * 		getPlayer() != old getPlayer()
	 * 		c in getPositions(old getPlayer())</pre>
	 */
	void nextMove(Coord c);
	
	/**
	 * Vide le plateau de jeu.
	 * @post <pre>
	 * 		forall Coord c : (0, 0) .. (getSize() - 1, getSize() - 1) : 
 * 				isFreeTile(c)</pre>
	 */
	void reset();
	
	/**
	 * Défini la nouvelle taille du plateau de jeu.
	 * @pre <pre>
	 * 		MIN_SIZE_BOARD <= size <= MAX_SIZE_BOARD </pre>
	 * @post <pre>
	 * 		getSize() == size</pre>
	 */
	void setSize(int size);
}
