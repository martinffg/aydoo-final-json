package main.java.aydoo;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class ParserJson {
	
	private ArrayList<RegistroJson> archivoDinamico;

	public ArrayList<RegistroJson> getArchivoDinamico(FileReader fileLectura) {
this.archivoDinamico=new ArrayList<RegistroJson>();
		this.parserDatos(fileLectura);
		return archivoDinamico;
	}

	private void parserDatos(FileReader fileLectura) {

		JsonElement valorEntradaArchivoJson = null;
		JsonParser parser = new JsonParser();
		JsonReader jsonR = new JsonReader(fileLectura);
		JsonElement datos = parser.parse(jsonR);
		JsonObject jsonObj = datos.getAsJsonObject();
		Set<Map.Entry<String, JsonElement>> archivoJson = jsonObj.entrySet();
		Iterator<Map.Entry<String, JsonElement>> iterArchivoJson = archivoJson.iterator();
		while (iterArchivoJson.hasNext()) {
			Map.Entry<String, JsonElement> entradaArchivoJson = iterArchivoJson.next();
			valorEntradaArchivoJson = entradaArchivoJson.getValue();
		}
		JsonArray datosArray = valorEntradaArchivoJson.getAsJsonArray();
		Iterator<JsonElement> iterArray = datosArray.iterator();
		while (iterArray.hasNext()) {
			JsonElement entradaArray = iterArray.next();
			JsonObject objArray = entradaArray.getAsJsonObject();

			String nombreReg = objArray.get("nombre").getAsString();
			String tipoReg = objArray.get("tipo").getAsString();
			String valorReg = "";

			RegistroJson registroNuevo = new RegistroJson(tipoReg, nombreReg, valorReg);
			this.archivoDinamico.add(registroNuevo);

		}
	}
}
