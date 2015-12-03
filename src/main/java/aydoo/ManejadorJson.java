package main.java.aydoo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class ManejadorJson {

	private String path;
	private ArrayList<RegistroJson> archivoDinamico;
	private boolean escrituraActivada;
	private boolean operacionSatisfactoria;
	
	public ManejadorJson(String pathJson,boolean escrituraAbierta){
		this.path=pathJson;
		this.archivoDinamico=new ArrayList<RegistroJson>();
		this.escrituraActivada=escrituraAbierta;
		this.operacionSatisfactoria=false;
	}
	
	public void leerDefinicionJson() {
		if (!this.isEscrituraActivada()){
			FileReader fileLectura;
			try {
				fileLectura = new FileReader(this.path);
				JsonElement valorEntradaArchivoJson=null;
				JsonParser parser = new JsonParser();
				JsonReader jsonR = new JsonReader(fileLectura);
		        JsonElement datos = parser.parse(jsonR);
		        JsonObject jsonObj = datos.getAsJsonObject();
		        Set<Map.Entry<String,JsonElement>> archivoJson = jsonObj.entrySet();
		        Iterator<Map.Entry<String,JsonElement>> iterArchivoJson = archivoJson.iterator();
		        while (iterArchivoJson.hasNext()){
		        	Map.Entry<String,JsonElement> entradaArchivoJson = iterArchivoJson.next();
		        	valorEntradaArchivoJson = entradaArchivoJson.getValue();
		        }
		        JsonArray datosArray = valorEntradaArchivoJson.getAsJsonArray();
		        Iterator<JsonElement> iterArray = datosArray.iterator();
		        while (iterArray.hasNext()) {
		        	JsonElement entradaArray = iterArray.next();
		        	JsonObject objArray = entradaArray.getAsJsonObject();
		                        
		            String nombreReg = objArray.get("nombre").getAsString();
		            String tipoReg = objArray.get("tipo").getAsString();
		            String valorReg ="";
		            	
		            RegistroJson registroNuevo = new RegistroJson(tipoReg,nombreReg,valorReg);
		            this.archivoDinamico.add(registroNuevo);
		        }
		        fileLectura.close();
		        this.operacionSatisfactoria=true;
			} catch (FileNotFoundException e) {
				this.operacionSatisfactoria=false;
				e.printStackTrace();
			} catch (IOException e) {
				this.operacionSatisfactoria=false;
				e.printStackTrace();
			}
		} else {
			this.operacionSatisfactoria=false;
		}
	}
	
	public void escribirSalidaJson() {
		if (this.isEscrituraActivada()){
			FileWriter fileSalida;
			try {
				fileSalida = new FileWriter(this.path);
				
				String jsonString = this.getCadenaSalida(this.getArchivoDinamico());
			    fileSalida.write(jsonString);
		        fileSalida.close();
		        this.operacionSatisfactoria=true;
			} catch (IOException e) {
				this.operacionSatisfactoria=false;
				e.printStackTrace();
			} 
		} else {
			this.operacionSatisfactoria=false;
		}
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ArrayList<RegistroJson> getArchivoDinamico() {
		return archivoDinamico;
	}

	public void setArchivoDinamico(ArrayList<RegistroJson> archivoDinamico) {
		this.archivoDinamico = archivoDinamico;
	}

	public boolean isEscrituraActivada() {
		return escrituraActivada;
	}

	public boolean isOperacionSatisfactoria() {
		return operacionSatisfactoria;
	}
	
	private String getCadenaSalida(ArrayList<RegistroJson> archivoSalidaDinamico) {
		String cadena="";
		cadena="{\n";
		Iterator<RegistroJson> iterador = archivoSalidaDinamico.iterator();
		while (iterador.hasNext()){
			RegistroJson registro = iterador.next();
			cadena+="\""+registro.getNombre()+"\":"+
					this.getCadenaValorPorTipo(registro.getTipo(),registro.getValor())+",\n";
		}
		cadena=cadena.substring(0, cadena.length()-2)+"\n}";
		return cadena;
	}
	
	private String getCadenaValorPorTipo(String tipo,String valor){
		String tipoValor=tipo.toLowerCase();
		String cadena="";
		switch (tipoValor) {
		case "boolean": {cadena=valor; }
			break;
		case "integer": {cadena=valor; }
			break;
		default: { cadena="\""+valor+"\"";}

		}
		return cadena;
	}
}
