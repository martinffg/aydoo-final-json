package main.java.aydoo;

import java.util.ArrayList;

public class Controlador {

	private ManejadorJson jsonEntrada, jsonSalida;
	private ArrayList<RegistroJson> arrayRegistrosJson;
	private boolean isLecturaCorrecta;
	

	public void modoGraficoObtenerDatos(String entrada) {
		jsonEntrada = new ManejadorJson(entrada, false);
		jsonEntrada.leerDefinicionJson();
		this.arrayRegistrosJson = jsonEntrada.getArchivoDinamico();
		isLecturaCorrecta=this.jsonEntrada.isOperacionSatisfactoria();

	}

	
	public ArrayList<RegistroJson> getVectorDeRegistros() {
		return this.arrayRegistrosJson;
	}
	

	public boolean isLecturaSatisfactoria() {
		return isLecturaCorrecta;
	}



}