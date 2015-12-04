package test.java.aydoo;

import org.junit.Assert;
import org.junit.Test;

import main.java.aydoo.ModoConsola;

public class ModoConsolaTest {

	@Test
	public void escrituraDeArchivoExitosa() {
	String	 archivoEntrada="testFiles/definicion-producto.json";
	String	 archivoSalida="testFiles/producto.json";

	ModoConsola modoConsola=new ModoConsola(archivoEntrada,archivoSalida);
	modoConsola.ejecutar();

	Assert.assertTrue(modoConsola.isEscrituraSatisfactoria());
	}
	
	@Test
	public void escrituraDeArchivoFallidaConArchivoDeEntradaInexistente() {
	String	 archivoEntrada="testFiles/definicion-product.json";
	String	 archivoSalida="testFiles/producto.json";

	ModoConsola modoConsola=new ModoConsola(archivoEntrada,archivoSalida);
	modoConsola.ejecutar();

	Assert.assertFalse(modoConsola.isEscrituraSatisfactoria());
	}

}
