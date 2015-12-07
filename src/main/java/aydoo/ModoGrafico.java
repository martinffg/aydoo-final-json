package main.java.aydoo;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ModoGrafico {

	private ArrayList<TextField> arrayListTextField;
	private ArrayList<Label> arrayListLabel;
	private Controlador controlador;
	private Scene scene;
	private GridPane grid;
	private Button guardar;
	private Group root;
	private int posicionFilaFinal;
	private ObtenerNombre obtenerNombre;
	private ArrayList<RegistroJson> arrayRegistrosJson;

	public ModoGrafico() {

		controlador = new Controlador();

	}

	public ArrayList<TextField> getArrayListTextField() {
		return arrayListTextField;
	}

	public void crearArrayTextField(ArrayList<RegistroJson> registrosJson) {

		arrayListTextField = new ArrayList<TextField>();

		for (int i = 0; i < registrosJson.size(); i++) {
			TextfieldTipos textField=new TextfieldTipos(registrosJson.get(i).getTipo());
			arrayListTextField.add(textField.getTextField());
		}
	}

	public void crearArrayLabel(ArrayList<RegistroJson> registrosJson) {

		arrayListLabel = new ArrayList<Label>();

		for (int i = 0; i < registrosJson.size(); i++) {

			arrayListLabel.add(new Label(registrosJson.get(i).getNombre()));
		}
	}

	private void crearInterfaz(ArrayList<RegistroJson> arrayRegistrosJson, Stage stage, String archivoEntrada) {
		int tamaniocolumna = 150 + (arrayRegistrosJson.size() * 30);
		scene = new Scene(new Group(), 500, tamaniocolumna);

		this.crearArrayTextField(arrayRegistrosJson);
		this.crearArrayLabel(arrayRegistrosJson);

		guardar = new Button("Guardar");
		guardar.setDefaultButton(true);
		guardar.setEffect(new Reflection());
		this.setGridPane();

		this.llenarCabecera(archivoEntrada);
		this.llenarDatosEnInterfaz(arrayRegistrosJson.size());
		this.setStage(stage);

	}

	private void setGridPane() {

		grid = new GridPane();
		grid.setVgap(4);
		grid.setHgap(10);
		grid.setPadding(new Insets(5, 5, 5, 5));

	}

	private void setStage(Stage stage) {

		root = (Group) scene.getRoot();
		root.getChildren().add(grid);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}

	private void llenarCabecera(String archivoEntrada) {
		this.obtenerNombre = new ObtenerNombre(archivoEntrada);

		grid.add(new Label("Nombre de Entidad"), 0, 0);
		grid.add(new Label("Archivo de Definicion"), 0, 1);

		TextField nombreEntidad = new TextField(obtenerNombre.getNombreEntidad());
		TextField nombreArchivo = new TextField(obtenerNombre.getNombreArchivo());
		nombreEntidad.setEditable(false);
		nombreArchivo.setEditable(false);

		grid.add(nombreEntidad, 1, 0);
		grid.add(nombreArchivo, 1, 1);

	}

	private void llenarDatosEnInterfaz(int cantidadElementos) {
		int i = 0;
		for (i = 0; i < cantidadElementos; i++) {
			grid.add(arrayListLabel.get(i), 0, i + 2);

			grid.add(arrayListTextField.get(i), 1, i + 2);
			
		}

		grid.add(guardar, 3, i + 4);
		this.posicionFilaFinal = i + 6;
	}



	public void ejecutar(Stage stage, String archivoEntrada) {
		arrayRegistrosJson = this.obtenerDatos(archivoEntrada);
		if (!controlador.isLecturaSatisfactoria())
			this.ventadaDeAlerta();
		else {
			stage.setTitle("Editor Json");

			crearInterfaz(arrayRegistrosJson, stage, archivoEntrada);

			guardar.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					if (guardar.isFocused()) {
						controlador.modoGraficoEscribirDatos(obtenerNombre.getPahtArchivoSalida(),
								guardarValoresEnArray());
						mensajeDeEscritura();

					}
				}

			});
		}
	}

	private void ventadaDeAlerta() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("No se ha encontrado el archivo");
		alert.setContentText("La aplicacion  no se ejecutara!");

		alert.showAndWait();
	}

	private void mensajeDeEscritura() {
		Label mensajeLabel = new Label();
		mensajeLabel.setFont(new Font("Arial", 15));
		mensajeLabel.setWrapText(true);
		if (controlador.isEscrituraSatisfactoria()) {
			mensajeLabel.setText("Escritura Satisfactoria");
			grid.setDisable(true);
				
			this.guardar.setDisable(true);
			guardar.setText("Guardado");
			
			
		} else
			mensajeLabel.setText("Ocurrio un error de escritura.");

		grid.add(mensajeLabel, 1, this.posicionFilaFinal + 5);

	}

	private ArrayList<RegistroJson> guardarValoresEnArray() {
		for (int i = 0; i < arrayListTextField.size(); i++) {

			this.arrayRegistrosJson.get(i).setValor(arrayListTextField.get(i).getText());
		}
		return this.arrayRegistrosJson;

	}

	private ArrayList<RegistroJson> obtenerDatos(String archivoEntrada) {
		controlador.modoGraficoObtenerDatos(archivoEntrada);
		return controlador.getVectorDeRegistros();
	}

}
