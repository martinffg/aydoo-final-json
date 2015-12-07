package main.java.aydoo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class TextFieldDouble {

	private TextField field;
	private String tipoDeVariable;

	public TextFieldDouble(TextField field, String tipoVariable) {
		this.field = field;
		this.tipoDeVariable = tipoVariable;
	}

	public TextField getTextFieldDouble() {
		this.setearTextFieldDouble();

		return this.field;
	}

	private void setearTextFieldDouble() {
		field.setPromptText("Campo " + this.tipoDeVariable);
		field.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

				boolean isValidoCaracter = true;
				if (newValue.intValue() > oldValue.intValue()) {
					char ch = field.getText().charAt(oldValue.intValue());

					isValidoCaracter = validarCaracterDouble(ch);
					if (!(isValidoCaracter)) {
						field.setText(field.getText().substring(0, field.getText().length() - 1));

					}
				}

			}

		});
	}

	private boolean validarCaracterDouble(char ch) {

		String characterToString = Character.toString(ch);
		boolean isValidoCaracter;

		isValidoCaracter = isCaracterPunto(ch);

		if ((!isValidoCaracter) && (!isCaracterGuion(ch)))
			isValidoCaracter = isParserDouble(characterToString);
		else if (!isValidoCaracter)
			isValidoCaracter = isCaracterGuion(ch);

		return isValidoCaracter;
	}

	private boolean isCaracterPunto(char ch) {
		return ((field.getText().length() != 1) && (ch == '.') && (isPuntoEncontrado(field.getText(), '.')));
	}

	private boolean isCaracterGuion(char ch) {
		return ((field.getText().length() == 1) && (ch == '-'));
	}

	private boolean isParserDouble(String characterToString) {
		boolean isValidoCaracter = false;
		try {
			Double.parseDouble(characterToString);
			Double.parseDouble(field.getText());
			isValidoCaracter = true;
		} catch (NumberFormatException e) {
			isValidoCaracter = false;
		}

		return isValidoCaracter;
	}

	private boolean isPuntoEncontrado(String cadena, char caracterABuscar) {
		ObtenerNombre cantidadCaracteres = new ObtenerNombre(cadena);
		return (cantidadCaracteres.getCantidadDeCaracteres(caracterABuscar) == 1);

	}

}
