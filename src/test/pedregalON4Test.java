package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.Pedregal_ON4;
import utils.EntradaSalida;

class pedregalON4Test {

	private Pedregal_ON4 pedregal;

	@Before
	private void setUp() throws NumberFormatException, IOException {
		pedregal = new Pedregal_ON4(EntradaSalida.leer("pedregal.in"));
	}

	@Test
	void mostrarTerrenoTest() throws NumberFormatException, IOException {
		setUp();
		pedregal.mostrarTerreno();
	}

	@Test
	void colocarCasaTest() throws NumberFormatException, IOException {
		setUp();
		pedregal.colocarCasa();
		assertTrue(pedregal.tieneCasa());
		assertEquals(1, pedregal.getPosXCasa());
		assertEquals(4, pedregal.getPosYCasa());
	}

}
