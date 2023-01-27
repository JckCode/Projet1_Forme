package modele;

public class Rond implements Forme{
	// propriétés
	private float rayon;
	public Rond(float rayon) {
		this.rayon = rayon;
	}

	public float perimetre() {
		// TODO Auto-generated method stub
		return (float) (2*Math.PI*this.rayon);
	}

	public float surface() {
		// TODO Auto-generated method stub
		return (float) (Math.PI*this.rayon*this.rayon);
	}

	public float getRayon() {
		return rayon;
	}

}
