import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Test;

public class JsongenTest {

	@Test
	public void ejecucionDelMainConMensajeSatisfactorioModoConsola() {
		String archivoEntrada = "testFiles/definicion-producto.json";
		String archivoSalida = "testFiles/producto.json";
		String mensajeEscrituraSatisfactoria = "El archivo se escribio Correctamente";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		PrintStream testOutPrintStream = new PrintStream(testOut);
		System.setOut(testOutPrintStream);
		jsongen jsonMain = new jsongen();
				
		jsongen.main(new String[] { archivoEntrada, archivoSalida });

		String newLine = System.getProperty("line.separator");
		if (newLine == null)
			newLine = "\n";

		String expected = mensajeEscrituraSatisfactoria + newLine;

		Assert.assertEquals(expected, testOut.toString());
		Assert.assertNotNull(jsonMain);

	}

	@Test
	public void ejecucionDelMainConMensajeDeErrorDeExtensionesModoConsola() {
		String archivoEntrada = "testFiles/definicion-product.json";
		String archivoSalida = "testFiles/producto.jso";
		String mensajeErrorExtension = "Las extensiones no son iguales";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		PrintStream testOutPrintStream = new PrintStream(testOut);
		System.setOut(testOutPrintStream);

		jsongen.main(new String[] { archivoEntrada, archivoSalida });

		String newLine = System.getProperty("line.separator");
		if (newLine == null)
			newLine = "\n";

		String expected = mensajeErrorExtension + newLine;

		Assert.assertEquals(expected, testOut.toString());

	}

	@Test
	public void ejecucionDelMainConNingunParametro() {

		String mensaje = "";
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		PrintStream testOutPrintStream = new PrintStream(testOut);
		System.setOut(testOutPrintStream);

		jsongen.main(new String[] { " ", " ", " " });

		String expected = mensaje;

		Assert.assertEquals(expected, testOut.toString());

	}

}
