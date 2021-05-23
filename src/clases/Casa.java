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
		designarOrientacion(frente, profundidad);
	}

	private void designarOrientacion(int frente, int profundidad) {
		if (frente > profundidad) {
			this.orientacion = 'S';
			this.frente = frente;
			this.profundidad = profundidad;
		} else {
			this.orientacion = 'O';
			this.frente = profundidad;
			this.profundidad = frente;
		}
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

	@Override
	public String toString() {
		return "X=" + posX + ", Y=" + posY + ", " + orientacion;
	}

}
