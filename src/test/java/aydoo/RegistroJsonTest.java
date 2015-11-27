package test.java.aydoo;

import org.junit.Assert;
import org.junit.Test;
import main.java.aydoo.RegistroJson;

public class RegistroJsonTest {

	@Test
	public void registroJsonConCambiosPostCreacionGetterYSetterTest() {
		
		RegistroJson registro = new RegistroJson("string","Nombre","null");
		
		registro.setNombre("Edad");
		registro.setTipo("integer");
		registro.setValor("34");
		
		Assert.assertEquals("Edad", registro.getNombre());
		Assert.assertEquals("integer", registro.getTipo());
		Assert.assertEquals("34", registro.getValor());		
		
	}	
		
	@Test
	public void registroJsonSinCambiosPostCreacionTest() {
		
		RegistroJson registro = new RegistroJson("string","Nombre","null");
		
		Assert.assertEquals("{\"nombre\":\"Nombre\", \"tipo\":\"string\", \"valor\":\"null\"}", registro.getRegistroEnFormatoJson());
		
	}
	
	@Test
	public void registroJsonConCambiosPostCreacionTest() {
		
		RegistroJson registro = new RegistroJson("boolean","married","true");
		
		registro.setNombre("Tipo de colegio");
		registro.setTipo("string");
		registro.setValor("primario");
		
		Assert.assertEquals("{\"nombre\":\"Tipo de colegio\", \"tipo\":\"string\", \"valor\":\"primario\"}", registro.getRegistroEnFormatoJson());
		
	}
}
