package clases;

import java.io.FileNotFoundException;
import utils.EntradaSalida;

public class Pedregal_ON4 {

	private Integer[][] terreno;
	private boolean tieneCasa;
	private int posXCasa;
	private int posYCasa;

	public Pedregal_ON4(Integer[][] terreno) {
		this.terreno = terreno;
	}

	public void colocarCasa() throws FileNotFoundException {

		boolean flag = true;
		boolean escribir = false;

		int posx = 0;
		int posy = 0;

		for (int i = 0; i < terreno.length; i++) {
			if (escribir)
				break;
			for (int j = 0; j < terreno[0].length; j++) {
				for (int j2 = 0; j2 < EntradaSalida.casaF; j2++) {
					for (int k = 0; k < EntradaSalida.casaL; k++) {
						if ((i + j2) < terreno.length && (j + k) < terreno[0].length)
							if (terreno[i + j2][j + k] == 1) {
								flag = false;
								break;
							}
					}
				}
				if (flag) {
					posx = i + 1;
					posy = j + 1;
					escribir = true;
					break;
				} else {
					flag = true;
				}
				for (int j2 = 0; j2 < EntradaSalida.casaF; j2++) {
					for (int k = 0; k < EntradaSalida.casaL; k++) {
						if ((j + j2) < terreno.length && (i + k) < terreno[0].length)
							if (terreno[j + j2][i + k] == 1) {
								flag = false;
								break;
							}
					}
				}
				if (flag) {
					posx = i + 1;
					posy = j + 1;
					escribir = true;
					break;
				} else {
					flag = true;
				}
			}
		}

		if (flag && escribir) {
			this.tieneCasa = true;
			this.posXCasa = posx;
			this.posYCasa = posy;
			System.out.println("SI");
			System.out.println(posx + " " + posy);
			System.out.println("S");
		} else {
			this.tieneCasa = false;
			System.out.println("NO");
		}

	}

	public void mostrarTerreno() {
		int i, j;
		for (i = terreno[0].length - 1; i >= 0; i--) {
			System.out.print(i + 1 + "|");
			for (j = 0; j < terreno.length; j++) {
				System.out.print(terreno[j][i] + " ");
			}
			System.out.println();
		}
		System.out.print(" |");
		for (int j2 = 0; j2 < terreno.length; j2++) {
			System.out.print(j2 + 1 + " ");
		}
		System.out.println();
		System.out.println();
	}

	public boolean sePuedeColocarCasa() {
		return this.tieneCasa;
	}

	public int getPosXCasa() {
		return posXCasa;
	}

	public int getPosYCasa() {
		return posYCasa;
	}

	public boolean tieneCasa() {
		return tieneCasa;
	}

}
