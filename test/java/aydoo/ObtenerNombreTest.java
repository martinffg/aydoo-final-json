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
	public void obtenerElnombreDeLaEntidadAPartirDeUnPathDondeLaPrimeraLetraNoEsUnChar() {
		String archivoEntrada = "testFiles/definicion-1producto.json";

		ObtenerNombre obtenerNombre = new ObtenerNombre(archivoEntrada);
		String nombreEntidad = obtenerNombre.getNombreEntidad();
		
		Assert.assertEquals(nombreEntidad, "1Producto");
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
