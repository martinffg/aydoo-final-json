package main.java.aydoo;

public class ObtenerNombre {
	private String nombre;

	public ObtenerNombre(String nombre) {
		this.nombre = nombre;

	}

	public String getNombreEntidad() {

		return upperCasePrimeraLetra(this.nombre.substring(this.nombre.indexOf('-') + 1, this.nombre.indexOf('.')));

	}

	public String getExtensionArchivo() {

		return this.nombre.substring(this.nombre.length() - 4);

	}

	public String getPahtArchivoSalida() {

		return this.nombre.substring(0, this.nombre.indexOf('-') - 10).concat(this.getNombreArchivo());

	}

	public boolean isExtensionesIguales(String nombreArchivo) {

		return (this.getExtensionArchivo().equals(nombreArchivo.substring(nombreArchivo.length() - 4)));

	}

	public String getNombreArchivo() {

		return this.nombre.substring(this.nombre.indexOf('-') + 1);

	}

	private String upperCasePrimeraLetra(String cadena) {
		boolean isPrimeraLetra = true;
		char[] chars = cadena.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if ((Character.isLetter(chars[i])) && (isPrimeraLetra)) {
				chars[i] = Character.toUpperCase(chars[i]);
				isPrimeraLetra = false;

			}
		}
		return new String(chars);
	}

	public int getCantidadDeCaracteres(char caracterABuscar) {
		int cantidadEncontrado = 0;

		for (int i = 0; i < this.nombre.length(); i++){
			if (this.nombre.charAt(i) == caracterABuscar){
				cantidadEncontrado++;
            }
        }    
		return cantidadEncontrado;
	}
}
