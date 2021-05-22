package clases;

public class Casa {

	private int posX;
	private int posY;
	private char orientacion;
	private int frente;
	private int profundidad;

	public Casa(int posX, int posY, int frente, int profundidad) {
		this.posX = posX;
		this.posY = posY;
		this.orientacion = designarOrientacion();
		this.frente = frente;
		this.profundidad = profundidad;
	}

	private char designarOrientacion() {
		if (posX > posY)
			return 'O';
		return 'S';
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public char getOrientacion() {
		return orientacion;
	}

	public int getFrente() {
		return frente;
	}

	public int getProfundidad() {
		return profundidad;
	}

}
