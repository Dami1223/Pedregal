package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EntradaSalida {

	public static int casaF;
	public static int casaL;
	public static int cantidadPiedras;

	public static Integer[][] leer(String path) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(new FileReader(new File(path)));
		int DX = sc.nextInt();
		int DY = sc.nextInt();
		casaF = sc.nextInt();
		casaL = sc.nextInt();
		cantidadPiedras = sc.nextInt();

		Integer[][] terreno = new Integer[DX][DY];
		for (int i = 0; i < terreno.length; i++) {
			for (int j = 0; j < terreno[0].length; j++) {
				terreno[i][j] = 0;
			}
		}

		while (sc.hasNextInt()) {
			int fila = sc.nextInt();
			int columna = sc.nextInt();
			terreno[fila-1][columna-1] = 1;
		}
		sc.close();
		return terreno;
	}
}