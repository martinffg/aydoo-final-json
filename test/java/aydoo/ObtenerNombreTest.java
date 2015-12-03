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
	
	

}
