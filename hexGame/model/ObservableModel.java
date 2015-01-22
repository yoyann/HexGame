package hexGame.model;

import javax.swing.event.ChangeListener;

/**
 * Interface pour certifier qu'un modele est observable.
 */
public interface ObservableModel {
	// COMMANDES
	
	/**
	 * Ajoute un ChangeListener ecoutant le modele.
	 * @pre <pre>
	 * 		cL != null</pre>
	 */
	void addChangeListener(ChangeListener cL);
	
	/**
	 * Retire un ChangeListener ecoutant le modele.
	 * @pre <pre>
	 * 		cL != null</pre>
	 */
	void removeChangeListener(ChangeListener cL);
}
