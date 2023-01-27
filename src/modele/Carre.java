package modele;

public class Carre implements Forme{
	// propriétés
	private float cote;
	// constructeur
	public Carre(float cote) {
		this.cote = cote;
	}
	public float perimetre() {
		// TODO Auto-generated method stub
		return cote*4;
	}

	public float surface() {
		// TODO Auto-generated method stub
		return cote*cote;
	}

	public float getCote() {
		return cote;
	}

}
