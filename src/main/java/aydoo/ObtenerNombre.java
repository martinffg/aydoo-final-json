package main.java.aydoo;

public class ObtenerNombre {
	String nombre;

	public ObtenerNombre(String nombre) {
		this.nombre = nombre;

	}

	public String getNombreEntidad() {

		return upperCasePrimeraLetra(this.nombre.substring(this.nombre.indexOf('-') + 1, this.nombre.indexOf('.') ));

	}
	public String getPahtArchivoSalida() {

		return this.nombre.substring(0, this.nombre.indexOf('-') - 10).concat(this.getNombreArchivo());

	}

	public String getNombreArchivo() {

		return this.nombre.substring(this.nombre.indexOf('-') + 1);

	}

	private String upperCasePrimeraLetra(String cadena)
	{
	    boolean isPrimeraLetra = true;
	    char[] chars = cadena.toCharArray();
	    for (int i = 0; i < chars.length; i++) {
	        if ((Character.isLetter(chars[i]))&& (isPrimeraLetra)) {
	                chars[i] = Character.toUpperCase(chars[i]);
	            isPrimeraLetra = false; 
	           
	        } 
	    }
	    return new String(chars);
	}
}
