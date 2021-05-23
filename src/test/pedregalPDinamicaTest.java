package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import clases.Casa;
import clases.Pedregal_PD;
import utils.EntradaSalida;

class pedregalPDinamicaTest {

	private Pedregal_PD pedregal;
	private final String rutaEntrada = "LoteDePrueba\\Entrada\\pedregal";

	@Before
	private void setUp() throws NumberFormatException, IOException {
		pedregal = new Pedregal_PD(EntradaSalida.leer(rutaEntrada + "_00-Enunciado.in"));
	}

	@Test
	void colocarPrimeraSentidoSurCasaTest() throws NumberFormatException, IOException {
		setUp();
		List<Casa> casa = pedregal.colocarCasas(EntradaSalida.casaF, EntradaSalida.casaL);
		assertEquals('S', casa.get(0).getOrientacion());
		assertEquals(1, casa.get(0).getPosX());
		assertEquals(4, casa.get(0).getPosY());
	}

	@Test
	void colocarPrimeraCasaSentidoOesteTest() throws NumberFormatException, IOException {
		setUp();
		List<Casa> casa = pedregal.colocarCasas(EntradaSalida.casaL, EntradaSalida.casaF);
		assertEquals('O', casa.get(0).getOrientacion());
		assertEquals(3, casa.get(0).getPosX());
		assertEquals(1, casa.get(0).getPosY());
	}

	@Test
	@DisplayName("Todas las casas posibles")
	void TodasLasCasasTest() throws NumberFormatException, IOException {
		String nombreCaso = "_00-Enunciado";
		Integer[][] terreno = EntradaSalida.leer(rutaEntrada + nombreCaso + ".in");
		Pedregal_PD pedregal = new Pedregal_PD(terreno);
		List<Casa> casas = pedregal.colocarCasas(EntradaSalida.casaF, EntradaSalida.casaL);
		for (int i = 0; i < casas.size(); i++) {
			validarCasa(casas.get(i), terreno);
		}
	}

	private void validarCasa(Casa casa, Integer[][] terreno) throws NumberFormatException, IOException {
		if (casa == null) {
			System.out.println("Es muy dificil probar que no se puede colocar la casa");
			return;
		}
		if (casa.getOrientacion() == 'S')
			for (int i = casa.getPosX() - 1; i < casa.getPosX() + casa.getFrente() - 1; i++) {
				for (int j = casa.getPosY() - 1; j < casa.getPosY() + casa.getProfundidad() - 1; j++) {
					assertEquals(0, terreno[i][j]);
				}
			}
		else if (casa.getOrientacion() == 'O')
			for (int i = casa.getPosX() - 1; i < casa.getPosX() + casa.getProfundidad() - 1; i++) {
				for (int j = casa.getPosY() - 1; j < casa.getPosY() + casa.getFrente() - 1; j++) {
					assertEquals(0, terreno[i][j]);
				}
			}
	}
}
