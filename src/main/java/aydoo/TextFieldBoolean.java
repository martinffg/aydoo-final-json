package main.java.aydoo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class TextFieldBoolean {
	
	private TextField field;
	private String tipoDeVariable;

	public TextFieldBoolean(TextField field, String tipoVariable) {
		this.field = field;
		this.tipoDeVariable = tipoVariable;
	}

	public TextField getTextFieldBoolean() {
		this.setearTextFieldBoolean();

		return this.field;
	}

	private void setearTextFieldBoolean() {
		field.setPromptText("Campo " + this.tipoDeVariable + "- t o f");

		field.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

				boolean isValidoCaracter = true;
				if (newValue.intValue() > oldValue.intValue()) {
					char ch = field.getText().charAt(oldValue.intValue());

					isValidoCaracter = validarCaracterBoolean(ch);
					if (!(isValidoCaracter)) {
						field.setText(field.getText().substring(0, field.getText().length() - 1));

					}
				}

			}

		});
	}

	private boolean isTrue(char ch) {

		boolean isValidoCaracter = false;
		if ((field.getText().length() == 1) && (ch == 't')) {
			isValidoCaracter = true;
			field.setText("true ");
		}
		return isValidoCaracter;
	}

	private boolean isFalse(char ch) {

		boolean isValidoCaracter = false;
		if ((field.getText().length() == 1) && (ch == 'f')) {
			isValidoCaracter = true;
			field.setText("false ");
		}
		return isValidoCaracter;
	}

	private boolean validarCaracterBoolean(char ch) {
		boolean isValidoCaracter = isFalse(ch);
		if (!isValidoCaracter)
			isValidoCaracter = isTrue(ch);

		return isValidoCaracter;
	}

}
