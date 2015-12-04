package main.java.aydoo;

public class ModoConsola {
	String archivoEntrada, archivoSalida;
	boolean escrituraSatisfactoria;

	public ModoConsola(String archivoEntrada, String archivoSalida) {
		this.archivoEntrada = archivoEntrada;
		this.archivoSalida = archivoSalida;

	}

	public void ejecutar() {
		Controlador controlador = new Controlador();
		controlador.modoConsola(this.archivoEntrada, this.archivoSalida);
		this.escrituraSatisfactoria=controlador.isEscrituraSatisfactoria();

	}

	public boolean isEscrituraSatisfactoria() {

		return this.escrituraSatisfactoria;
	}
}
