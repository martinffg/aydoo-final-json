package main.java.aydoo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class TextFieldInteger {
	
	private TextField field;
	private String tipoDeVariable;

	public TextFieldInteger(TextField field, String tipoVariable) {
		this.field = field;
		this.tipoDeVariable = tipoVariable;
	}

	public TextField getTextFieldInteger() {
		this.setearTextFieldInteger();

		return this.field;
	}

	private void setearTextFieldInteger() {
		field.setPromptText("Campo " + this.tipoDeVariable);
		field.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

				boolean isValidoCaracter = true;
				if (newValue.intValue() > oldValue.intValue()) {
					char ch = field.getText().charAt(oldValue.intValue());

					isValidoCaracter = validarCaracterInteger(ch);
					if (!(isValidoCaracter)) {
						field.setText(field.getText().substring(0, field.getText().length() - 1));

					}
				}

			}

		});
	}

	private boolean validarCaracterInteger(char ch) {
		boolean isValidoCaracter;
		String characterToString = Character.toString(ch);
		if ((field.getText().length() == 1) && (ch == '-'))
			isValidoCaracter = true;
		else

			try {
				Integer.parseInt(characterToString);
				Integer.parseInt(field.getText());
				isValidoCaracter = true;
			} catch (NumberFormatException e) {
				isValidoCaracter = false;
			}

		return isValidoCaracter;
	}


}
