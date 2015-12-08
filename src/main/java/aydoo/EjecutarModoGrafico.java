package main.java.aydoo;

import javafx.application.Application;
import javafx.stage.Stage;

public class EjecutarModoGrafico extends Application {

	static String archivoEntrada;
	
	public static void main(String[] args)
    {archivoEntrada = args[0];
      launch(args);
    }

	@Override
	public void start(Stage stage) {
	    System.out.println("Inicializando Modo Grafico");
		ModoGrafico interfazGrafica = new ModoGrafico();
		interfazGrafica.ejecutar(stage, archivoEntrada);
	}

}