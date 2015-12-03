package main.java.aydoo;

import java.util.ArrayList;

public class Controlador {

	private ManejadorJson jsonEntrada, jsonSalida;
	private ArrayList<RegistroJson> arrayRegistrosJson;
	private boolean isEscrituraCorrecta, isLecturaCorrecta;

	public void modoConsola(String entrada, String salida) {
		this.modoGraficoObtenerDatos(entrada);
		if (jsonEntrada.isOperacionSatisfactoria())
			this.modoGraficoEscribirDatos(salida, arrayRegistrosJson);
		else
			this.isEscrituraCorrecta = false;

	}

	public void modoGraficoObtenerDatos(String entrada) {
		jsonEntrada = new ManejadorJson(entrada, false);
		jsonEntrada.leerDefinicionJson();
		this.arrayRegistrosJson = jsonEntrada.getArchivoDinamico();
		isLecturaCorrecta = this.jsonEntrada.isOperacionSatisfactoria();

	}

	public void modoGraficoEscribirDatos(String nombreArchivoSalida, ArrayList<RegistroJson> arrayRegistrosJson) {
		jsonSalida = new ManejadorJson(nombreArchivoSalida, true);
		jsonSalida.setArchivoDinamico(arrayRegistrosJson);

		jsonSalida.escribirSalidaJson();
		this.isEscrituraCorrecta = this.jsonSalida.isOperacionSatisfactoria();
	}

	public ArrayList<RegistroJson> getVectorDeRegistros() {
		return this.arrayRegistrosJson;
	}

	public boolean isEscrituraSatisfactoria() {

		return this.isEscrituraCorrecta;

	}

	public boolean isLecturaSatisfactoria() {
		return isLecturaCorrecta;
	}

}