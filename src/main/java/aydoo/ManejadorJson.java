package main.java.aydoo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;

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
			ParserJson parserJson=new ParserJson();
			try {
				fileLectura = new FileReader(this.path);
				  this.archivoDinamico=parserJson.getArchivoDinamico(fileLectura);
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
