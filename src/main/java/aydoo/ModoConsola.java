package main.java.aydoo;

public class ModoConsola {
	private String archivoEntrada, archivoSalida;
	private boolean escrituraSatisfactoria, errorExtension;
	private final String mensajeErrorExtension = "Las extensiones no son iguales";
	private final String mensajeEscrituraSatisfactoria = "El archivo se escribio Correctamente";
	private final String mensajeEscrituraNoSatisfactoria = "ERROR, El archivo no se escribio";

	public ModoConsola(String archivoEntrada, String archivoSalida) {

		this.escrituraSatisfactoria = false;

		this.archivoEntrada = archivoEntrada;
		this.archivoSalida = archivoSalida;

	}

	public void ejecutar() {

		this.comprobarExtensiones(archivoEntrada, archivoSalida);
		if (!this.errorExtension) {
			Controlador controlador = new Controlador();
			controlador.modoConsola(this.archivoEntrada, this.archivoSalida);
			this.escrituraSatisfactoria = controlador.isEscrituraSatisfactoria();
		}
	}

	private void comprobarExtensiones(String archivoEntrada, String archivoSalida) {
		ObtenerNombre extension = new ObtenerNombre(archivoEntrada);

		this.errorExtension = !extension.isExtensionesIguales(archivoSalida);

	}

	public String mensajeDeSalida() {

		if (errorExtension)
			return mensajeErrorExtension;
		else if (this.escrituraSatisfactoria)
			return mensajeEscrituraSatisfactoria;
		else
			return mensajeEscrituraNoSatisfactoria;

	}

	public boolean isEscrituraSatisfactoria() {

		return this.escrituraSatisfactoria;
	}
}
