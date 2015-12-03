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
	
	@Test
	public void escrituraEnArchivoCuandoArchivoDeEntradaNoExisteModoGrafico() {
		String archivoEntrada = "F:/testFiles/definicion-producto.json";
		String archivoSalida = "F:/testFiles/producto.json";
		ArrayList<RegistroJson> arrayPrueba = null;

		Controlador controlador = new Controlador();
		controlador.modoGraficoObtenerDatos(archivoEntrada);
		arrayPrueba = controlador.getVectorDeRegistros();
		controlador.modoGraficoEscribirDatos(archivoSalida, arrayPrueba);

		Assert.assertEquals(0, arrayPrueba.size());
		Assert.assertFalse(controlador.isEscrituraSatisfactoria());
		Assert.assertFalse(controlador.isLecturaSatisfactoria());
	}

	@Test
	public void escrituraEnArchivoCuandoArchivoDeEntradaExisteModoGrafico() {
		String archivoEntrada = "testFiles/definicion-producto.json";
		String archivoSalida = "testFiles/producto.json";
		ArrayList<RegistroJson> arrayPrueba = null;

		Controlador controlador = new Controlador();
		controlador.modoGraficoObtenerDatos(archivoEntrada);
		arrayPrueba = controlador.getVectorDeRegistros();
		controlador.modoGraficoEscribirDatos(archivoSalida, arrayPrueba);

		Assert.assertNotEquals(0, controlador.getVectorDeRegistros().size());
		Assert.assertTrue(controlador.isEscrituraSatisfactoria());
		Assert.assertTrue(controlador.isLecturaSatisfactoria());
	}
	
}
