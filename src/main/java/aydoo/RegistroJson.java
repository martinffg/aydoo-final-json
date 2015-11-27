package main.java.aydoo;

public class RegistroJson {
	
	private String tipo;
	private String nombre;
	private String valor;
	
	public RegistroJson(String tipoJson,String nombreJson,String valorJson){
		this.tipo=tipoJson;
		this.nombre=nombreJson;
		this.valor=valorJson;		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getRegistroEnFormatoJson(){
		
		return "{\"nombre\":\""+this.getNombre()+"\", \"tipo\":\""
						+this.getTipo()+"\", \"valor\":\""+this.getValor()+"\"}";
		
	}

}
