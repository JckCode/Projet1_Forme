package controleur;

import java.util.ArrayList;

import modele.Carre;
import modele.Forme;
import modele.Rond;
import vue.FrmForme;

public class Controle {
	//propriétés
	private FrmForme frmForme;
	private ArrayList<Forme> lesFormes = new ArrayList<Forme>();
	public static void main(String[] args) {
		new Controle();
	}
	
	/**
	 * Demande de la vue pour obtenir le périmètre et la surface de la forme.
	 * @param typeForme
	 * @param valeur
	 */
	public void demandeFrmFormeValeurs(String typeForme, float valeur) {
		Forme uneForme;
		if(typeForme=="carre") {
			uneForme = new Carre(valeur);
			frmForme.affichageResultatCarre(uneForme.perimetre(), uneForme.surface());
		}
		else {
			uneForme = new Rond(valeur);
			frmForme.affichageResultatCercle(uneForme.perimetre(), uneForme.surface());
		}
		//Ajout de la nouvelle forme dans la collecion.
		lesFormes.add(uneForme);
		//demande de à la vue de mise à jour de la liste des formes.
		frmForme.majLstFormes(lesFormes);
	}
	
	public void demandeFrmFormeDel(int indice) {
		//Suppression d'une forme dans la collectiion
		lesFormes.remove(indice);
		// demande de mise à jour après suppression.
		frmForme.majLstFormes(lesFormes);
	}
	
	/**
	 * Contructeur
	 */
	public Controle(){
		frmForme = new FrmForme(this);
		frmForme.setVisible(true);
	}

}
