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
	void mostrarTerrenoTest() throws NumberFormatException, IOException {
		setUp();
		pedregal.mostrarTerreno();
	}

	@Test
	void colocarPrimeraCasaTest() throws NumberFormatException, IOException {
		setUp();
		List<Casa> casa = pedregal.colocarCasa(EntradaSalida.casaF, EntradaSalida.casaL);
		assertEquals('S', casa.get(0).getOrientacion());
		assertEquals(1, casa.get(0).getPosX());
		assertEquals(4, casa.get(0).getPosY());
	}

	@Test
	void colocarPrimeraCasaOtroSentidoTest() throws NumberFormatException, IOException {
		setUp();
		List<Casa> casa = pedregal.colocarCasa(EntradaSalida.casaL, EntradaSalida.casaF);
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
		List<Casa> casas = pedregal.colocarCasa(EntradaSalida.casaF, EntradaSalida.casaL);
		for (Casa casa : casas) {
			validarCasa(casa, terreno);
		}
		List<Casa> casasOtraOrientacion = pedregal.colocarCasa(EntradaSalida.casaL, EntradaSalida.casaF);
		for (Casa casa : casasOtraOrientacion) {
			validarCasa(casa, terreno);
		}
		System.out.println("Cantidad total de casas posibles:" + casas.size() + casasOtraOrientacion.size());
	}

	private void validarCasa(Casa casa, Integer[][] terreno) throws NumberFormatException, IOException {
		if (casa == null) {
			System.out.println("Es muy dificil probar que no se puede colocar la casa");
			return;
		}
		for (int i = casa.getPosX() - 1; i < casa.getPosX() + casa.getFrente() - 1; i++) {
			for (int j = casa.getPosY() - 1; j < casa.getPosY() + casa.getProfundidad() - 1; j++) {
				assertEquals(0, terreno[i][j]);
			}
		}
		if (casa.getPosX() > casa.getPosY())
			assertEquals('O', casa.getOrientacion());
		else
			assertEquals('S', casa.getOrientacion());
	}
}
