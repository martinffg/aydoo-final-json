package test.java.aydoo;

import main.java.aydoo.jsongen;

import org.junit.Test;

public class JsongenTest {

	@Test
	public void registroJsonConCambiosPostCreacionGetterYSetterTest() {
		String	 archivoEntrada="testFiles/definicion-producto.json";
		String	 archivoSalida="testFiles/producto.json";
		       jsongen.main(new String[] {archivoEntrada, archivoSalida});
	}

}
