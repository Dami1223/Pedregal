package clases;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class Pedregal_PD {
	/*
	 * Implementacion con Programacion Dinamica
	 */

	private Integer[][] acumulada;
	private List<Casa> casas = new LinkedList<Casa>();

	public Pedregal_PD(Integer[][] terreno) {
		acumulada = new Integer[terreno.length][terreno[0].length];
		acumulada[0][0] = terreno[0][0];
		for (int i = 1; i < acumulada[i].length; i++) {
			acumulada[0][i] = acumulada[0][i - 1] + terreno[0][i];
		}
		for (int i = 1; i < acumulada.length; i++) {
			acumulada[i][0] = acumulada[i - 1][0] + terreno[i][0];
		}
		for (int i = 1; i < acumulada.length; i++) {
			for (int j = 1; j < acumulada[i].length; j++) {
				acumulada[i][j] = acumulada[i - 1][j] + acumulada[i][j - 1] - acumulada[i - 1][j - 1] + terreno[i][j];
			}
		}
	}

	public List<Casa> colocarCasas(int frente, int profundidad) throws FileNotFoundException {
		this.colocarCasaUnSentido(frente, profundidad);// Sentido Sur
		this.colocarCasaUnSentido(profundidad, frente);// Sentido Oeste
		return this.casas;
	}

	private void colocarCasaUnSentido(int frente, int profundidad) throws FileNotFoundException {
		if (frente >= acumulada.length)
			return;
		if (profundidad >= acumulada[0].length)
			return;
		if (acumulada[frente - 1][profundidad - 1] == 0) {
			casas.add(new Casa(frente, profundidad, frente, profundidad));
		}
		for (int i = 1; i < acumulada.length - frente; i++) {
			if (acumulada[i - 1][profundidad - 1] - acumulada[i + frente - 1][profundidad - 1] == 0) {
				casas.add(new Casa(i + 1, 1, frente, profundidad));
			}
		}
		for (int i = 1; i < acumulada[i].length - profundidad; i++) {
			if (acumulada[frente - 1][i - 1] - acumulada[frente - 1][i + profundidad - 1] == 0) {
				casas.add(new Casa(1, i + 1, frente, profundidad));
			}
		}
		for (int i = 1; i < acumulada.length - frente; i++) {
			for (int j = 1; j < acumulada[i].length - profundidad; j++) {
				int f = i + frente - 1;
				int c = j + profundidad - 1;
				if ((acumulada[f][c] - acumulada[f][j - 1] - acumulada[i - 1][c] + acumulada[i - 1][j - 1]) == 0) {
					casas.add(new Casa(i + 1, j + 1, frente, profundidad));
				}
			}
		}
	}

	public void mostrarTerreno() {
		int i, j;
		for (i = acumulada[0].length - 1; i >= 0; i--) {
			System.out.print(i + 1 + "|");
			for (j = 0; j < acumulada.length; j++) {
				System.out.print(acumulada[j][i] + " ");
			}
			System.out.println();
		}
		System.out.print(" |");
		for (int j2 = 0; j2 < acumulada.length; j2++) {
			System.out.print(j2 + 1 + " ");
		}
		System.out.println();
	}

}
