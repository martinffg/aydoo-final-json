package main.java.aydoo;

import javafx.scene.control.TextField;

public class TextfieldTipos {
	
	private TextField field;
	private String tipoDeVariable;

	public TextfieldTipos(String tipoDeVariable) {
		this.tipoDeVariable = tipoDeVariable;
		field = new TextField();

	}

	public TextField getTextField() {
		selectorDeTipo();
		return field;
	}

	private void selectorDeTipo() {
		switch (this.tipoDeVariable.toLowerCase()) {
		case "integer": {

			this.textFieldInteger();
			break;
		}
		case "number": {

			this.textFieldFloat();
			break;
		}

		case "float": {

			this.textFieldFloat();
			break;
		}

		case "double": {
			this.textFieldDouble();
			break;
		}
		case "string": {
			this.textFieldString();
			break;
		}

		case "boolean": {
			this.textFieldBoolean();
			break;
		}

		case "null": {
			this.textFieldNull();
			break;
		}
		}

	}

	private void textFieldNull() {
		TextFieldNull fieldNull=new TextFieldNull(field,tipoDeVariable);
		this.field=fieldNull.getTextFieldNull();

	}


	private void textFieldFloat() {
		TextFieldFloat fieldFloat=new TextFieldFloat(field,tipoDeVariable);
		this.field=fieldFloat.getTextFieldFloat();
	}

	private void textFieldBoolean() {
		TextFieldBoolean fieldBoolean=new TextFieldBoolean(field,tipoDeVariable);
		this.field=fieldBoolean.getTextFieldBoolean();
	}

	private void textFieldString() {

		TextFieldString fieldString=new TextFieldString(field,tipoDeVariable);
	this.field=fieldString.getTextFieldString();
	}

	private void textFieldDouble() {
		TextFieldDouble fieldDouble=new TextFieldDouble(field,tipoDeVariable);
		this.field=fieldDouble.getTextFieldDouble();
	}

	private void textFieldInteger() {
		TextFieldInteger fieldInteger=new TextFieldInteger(field,tipoDeVariable);
		this.field=fieldInteger.getTextFieldInteger();


	}


}
