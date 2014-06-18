/**
 * 
 */
package Test;

import projetwebone.objet.metier.Personne;

/**
 * @author 8510502w
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Personne personne = new Personne();
		for(int i = 0; i < personne.getListpersonne().size(); i++){
			System.out.println(personne.getListpersonne().get(i).toString());
		}
		
		System.out.println("Fin ");
		
	}

}
