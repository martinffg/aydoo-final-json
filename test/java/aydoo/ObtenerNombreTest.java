package test.java.aydoo;

import org.junit.Assert;
import org.junit.Test;

import main.java.aydoo.ObtenerNombre;

public class ObtenerNombreTest {

	@Test
	public void obtenerElnombreDeLaEntidadAPartirDeUnPath() {
		String archivoEntrada = "testFiles/definicion-producto.json";

		ObtenerNombre obtenerNombre = new ObtenerNombre(archivoEntrada);
		String nombreEntidad = obtenerNombre.getNombreEntidad();

		Assert.assertEquals(nombreEntidad, "Producto");
	}

	@Test
	public void obtenerExtensionDeUnArchivo() {
		String archivoEntrada = "testFiles/definicion-producto.json";

		ObtenerNombre obtenerNombre = new ObtenerNombre(archivoEntrada);
		String extensionEntidad = obtenerNombre.getExtensionArchivo();

		Assert.assertEquals(extensionEntidad, "json");
	}

	@Test
	public void obtenerElnombreDeLaEntidadAPartirDeUnPathDondeLaPrimeraLetraNoEsUnChar() {
		String archivoEntrada = "testFiles/definicion-1producto.json";

		ObtenerNombre obtenerNombre = new ObtenerNombre(archivoEntrada);
		String nombreEntidad = obtenerNombre.getNombreEntidad();

		Assert.assertEquals(nombreEntidad, "1Producto");
	}

	@Test
	public void dosExtensionesIgualesDevuelveTrue() {
		String archivoEntrada = "testFiles/definicion-producto.json";
		String archivoSalida = "testFiles/producto.json";
		ObtenerNombre extension = new ObtenerNombre(archivoEntrada);

		Assert.assertTrue(extension.isExtensionesIguales(archivoSalida));
	}

	@Test
	public void obtenerLaCantidadDeCaracteresEncontrados() {
		String archivoEntrada = "testFiles/definicion-producto.json";

		ObtenerNombre cadena = new ObtenerNombre(archivoEntrada);
		int cantidadEncontrada = cadena.getCantidadDeCaracteres('o');

		Assert.assertEquals(cantidadEncontrada, 4);
	}

	@Test
	public void dosExtensionesNoIgualesDevuelveFalse() {
		String archivoEntrada = "testFiles/definicion-producto.json";
		String archivoSalida = "testFiles/producto.js";
		ObtenerNombre extension = new ObtenerNombre(archivoEntrada);

		Assert.assertFalse(extension.isExtensionesIguales(archivoSalida));
	}

	@Test
	public void obtenerElnombreDeArchivoAPartirDeUnPath() {
		String archivoEntrada = "testFiles/definicion-producto.json";

		ObtenerNombre obtenerNombre = new ObtenerNombre(archivoEntrada);
		String nombreArchivo = obtenerNombre.getNombreArchivo();

		Assert.assertEquals(nombreArchivo, "producto.json");
	}

	@Test
	public void obtenerElPathDeUnArchivoDeSalidaAPartirDeUnPathDeEntrada() {
		String archivoEntrada = "testFiles/definicion-producto.json";
		String archivoSalida = "testFiles/producto.json";

		ObtenerNombre obtenerNombre = new ObtenerNombre(archivoEntrada);
		String pathArchivoDeSalida = obtenerNombre.getPahtArchivoSalida();

		Assert.assertEquals(pathArchivoDeSalida, archivoSalida);
	}

}
