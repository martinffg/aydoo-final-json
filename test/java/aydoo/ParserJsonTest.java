package test.java.aydoo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import main.java.aydoo.ParserJson;
import main.java.aydoo.RegistroJson;

public class ParserJsonTest {

	@Test
	public void devuelveUnArrayConContenidoCuandoElArchivoExiste() {
		ArrayList<RegistroJson> archivoDinamico = null;
		String pathYNombreArchivoJson = "testFiles/definicion-producto.json";
	
		FileReader fileLectura;
		ParserJson parserJson=new ParserJson();
		
		try {
			fileLectura = new FileReader(pathYNombreArchivoJson);
			archivoDinamico=parserJson.getArchivoDinamico(fileLectura);
			fileLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: El archivo de definicion JSON no se encuentra en la ruta especificada.");
		} catch (IOException e) {
			System.out.println("Error: Ha ocurrido un problema al procesar archivoDinamico - IO Error");
		}
			 
		Assert.assertEquals(2,archivoDinamico.size());
		Assert.assertEquals("identificador",archivoDinamico.get(0).getNombre());
		Assert.assertEquals("String",archivoDinamico.get(0).getTipo());			
		Assert.assertEquals("String",archivoDinamico.get(1).getTipo());
		Assert.assertEquals("apellido",archivoDinamico.get(1).getNombre());

	}
	
	
	@Test
	public void devuelveUnArraySinContenidoCuandoElArchivoExisteSinContenido() {
		ArrayList<RegistroJson> archivoDinamico = null;
		String pathYNombreArchivoJson = "testFiles/definicion-vacio.json";
	
		FileReader fileLectura;
		ParserJson parserJson=new ParserJson();
		
			try {
				fileLectura = new FileReader(pathYNombreArchivoJson);
				archivoDinamico=parserJson.getArchivoDinamico(fileLectura);
				fileLectura.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error: El archivo de definicion JSON no se encuentra en la ruta especificada.");
			} catch (IOException e) {
				System.out.println("Error: Ha ocurrido un problema al procesar archivoDinamico - IO Error");
			}
			 
		Assert.assertEquals(0,archivoDinamico.size());
		
	}
}
