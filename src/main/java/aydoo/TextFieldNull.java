package main.java.aydoo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class TextFieldNull {

	private TextField field;
	private String tipoDeVariable;
	
	public TextFieldNull(TextField field,String tipoVariable){
		 this.field=field;
		 this.tipoDeVariable=tipoVariable;
	}

	public TextField getTextFieldNull()
	 {
		this.setearTextFieldNull();


		return this.field;
	 }

	private void setearTextFieldNull() {
		field.setPromptText("Campo " + this.tipoDeVariable);

		field.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

				field.setText("null");
			}

		});

	}

}
