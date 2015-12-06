package test.java.aydoo;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Assert;
import org.junit.Test;
import main.java.aydoo.ManejadorJson;
import main.java.aydoo.RegistroJson;

public class ManejadorJsonTest {
	
	@Test
	public void leerConManejadorJsonTest() {
		
		String pathYNombreArchivoJson = "testFiles/definicion-producto.json";
		boolean esArchivoDeSalida=false;
		ManejadorJson mjson = new ManejadorJson(pathYNombreArchivoJson,esArchivoDeSalida);
		mjson.leerDefinicionJson();
		Assert.assertEquals(2,mjson.getArchivoDinamico().size());
	}
	
	@Test
	public void leerYescribirConManejadorJsonTest() {
		
		String pathEntradaArchivoJson = "testFiles/definicion-producto.json";
		String pathSalidaArchivoJson = "testFiles/producto.json";
		ArrayList<RegistroJson> archivoSalidaDinamico;
				
		ManejadorJson lecturaMJson = new ManejadorJson(pathEntradaArchivoJson,false);
		ManejadorJson escrituraMJson = new ManejadorJson(pathSalidaArchivoJson,true);

		lecturaMJson.leerDefinicionJson();
		if (lecturaMJson.isOperacionSatisfactoria()) {
			archivoSalidaDinamico = lecturaMJson.getArchivoDinamico();
			Iterator<RegistroJson> iterador = archivoSalidaDinamico.iterator();
			while (iterador.hasNext()){
				iterador.next().setValor("datoEjemplo");
			}
			escrituraMJson.setArchivoDinamico(archivoSalidaDinamico);
		}
		escrituraMJson.escribirSalidaJson();
		Assert.assertTrue(escrituraMJson.isOperacionSatisfactoria());
		Assert.assertFalse(!escrituraMJson.isOperacionSatisfactoria());
	}
	
	
	@Test
	public void leerArchivoSalidaPorErrorManejadorJsonTest() {
		
		String pathSalidaArchivoJson = "testFiles/producto.json";
		
		ManejadorJson escrituraMJson = new ManejadorJson(pathSalidaArchivoJson,true);;
						
		try { 	
			escrituraMJson.leerDefinicionJson();
		} catch (Exception e) {
			System.out.println("Error en la apertura solo lectura en archivo de salida"); 
		}
		
		Assert.assertFalse(escrituraMJson.isOperacionSatisfactoria());
	}
	
}
