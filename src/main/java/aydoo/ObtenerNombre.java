package main.java.aydoo;

public class ObtenerNombre {
	String nombre;

	public ObtenerNombre(String nombre) {
		this.nombre = nombre;

	}

	public String getNombreEntidad() {

		return uppercasePrimeraLetra(this.nombre.substring(this.nombre.indexOf('-') + 1, this.nombre.indexOf('.') ));

	}
	
	private String uppercasePrimeraLetra(String cadena)
	{
	    boolean prevWasWhiteSp = true;
	    char[] chars = cadena.toCharArray();
	    for (int i = 0; i < chars.length; i++) {
	        if (Character.isLetter(chars[i])) {
	            if (prevWasWhiteSp) {
	                chars[i] = Character.toUpperCase(chars[i]);
	            }
	            prevWasWhiteSp = false;
	        } else {
	            prevWasWhiteSp = Character.isWhitespace(chars[i]);
	        }
	    }
	    return new String(chars);
	}
}
