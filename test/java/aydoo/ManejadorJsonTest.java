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
		
		String pathYNombreArchivoJson = "testFiles/definicion-persona.json";
		boolean esArchivoDeSalida=false;
		ManejadorJson mjson = new ManejadorJson(pathYNombreArchivoJson,esArchivoDeSalida);
		mjson.leerDefinicionJson();
		Assert.assertEquals(4,mjson.getArchivoDinamico().size());
	}
	
	@Test
	public void leerYescribirConManejadorJsonTest() {
		
		String pathEntradaArchivoJson = "testFiles/definicion-persona.json";
		String pathSalidaArchivoJson = "testFiles/persona.json";
		ArrayList<RegistroJson> archivoSalidaDinamico;
		RegistroJson registro;
				
		ManejadorJson lecturaMJson = new ManejadorJson(pathEntradaArchivoJson,false);
		ManejadorJson escrituraMJson = new ManejadorJson(pathSalidaArchivoJson,true);

		lecturaMJson.leerDefinicionJson();
		if (lecturaMJson.isOperacionSatisfactoria()) {
			archivoSalidaDinamico = lecturaMJson.getArchivoDinamico();
			Iterator<RegistroJson> iterador = archivoSalidaDinamico.iterator();
			while (iterador.hasNext()){
				registro = iterador.next();
				switch (registro.getTipo()) {
					case "boolean": {registro.setValor("true"); }
						break;
					case "integer": {registro.setValor("18"); }
						break;
					default: { registro.setValor("datoEjemplo");}
				}
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
	
	@Test
	public void escribirArchivoEntradaPorErrorManejadorJsonTest() {
		
		String pathEntradaArchivoJson = "testFiles/definicion-producto.json";
		
		ManejadorJson lecturaMJson = new ManejadorJson(pathEntradaArchivoJson,false);;
						
		try { 	
			lecturaMJson.escribirSalidaJson();
		} catch (Exception e) {
			System.out.println("Error de escritura en archivo de definicion."); 
		}
		
		Assert.assertFalse(lecturaMJson.isOperacionSatisfactoria());
	}
	
	@Test
	public void leerRutaVaciaConManejadorJsonTest() {
		
		String pathYNombreArchivoJson = "";
		boolean esArchivoDeSalida=false;
		ManejadorJson mjson = new ManejadorJson(pathYNombreArchivoJson,esArchivoDeSalida);
		String prueba= mjson.getPath();
		prueba="";
		mjson.setPath(prueba);
		mjson.escribirSalidaJson();
		Assert.assertFalse(mjson.isOperacionSatisfactoria());
	}
	
}
