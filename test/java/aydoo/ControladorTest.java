package test.java.aydoo;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import main.java.aydoo.Controlador;
import main.java.aydoo.RegistroJson;

public class ControladorTest {

	
	@Test
	public void cuandoArchivoDeEntradaNoExisteModoGrafico() {
		String archivoEntrada = "F:/testFiles/definicion-producto.json";

		Controlador controlador = new Controlador();
		controlador.modoGraficoObtenerDatos(archivoEntrada);

		Assert.assertEquals(0, controlador.getVectorDeRegistros().size());
		Assert.assertFalse(controlador.isLecturaSatisfactoria());
	}

	@Test
	public void cuandoArchivoDeEntradaExisteModoGrafico() {
		String archivoEntrada = "testFiles/definicion-producto.json";

		Controlador controlador = new Controlador();
		controlador.modoGraficoObtenerDatos(archivoEntrada);

		Assert.assertEquals(2, controlador.getVectorDeRegistros().size());
		Assert.assertTrue(controlador.isLecturaSatisfactoria());
	}
}
