package main.java.aydoo;

import javafx.scene.control.TextField;

public class TextFieldString {
	
	private TextField field;
	private String tipoDeVariable;

	public TextFieldString(TextField field, String tipoVariable) {
		this.field = field;
		this.tipoDeVariable = tipoVariable;
	}

	public TextField getTextFieldString() {
		this.setearTextFieldString();

		return this.field;
	}

	private void setearTextFieldString() {

		field.setPromptText("Campo " + this.tipoDeVariable);
	}

}
