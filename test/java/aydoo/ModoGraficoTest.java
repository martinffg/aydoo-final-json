package test.java.aydoo;

import org.junit.Assert;
import org.junit.Test;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import main.java.aydoo.ModoGrafico;

public class ModoGraficoTest {

	 @Test
	public void mensajeDeErrorCuandoElArchivoNoSeEncuentra() throws InterruptedException {

		Thread thread = new Thread(new Runnable() {
			String pathYNombreArchivoJson = "C:/aydo ojson/testFiles/definicion-ejemplo.json";

			@Override
			public void run() {
				new JFXPanel();
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						ModoGrafico interfaz;
						interfaz = new ModoGrafico();
						interfaz.ejecutar(new Stage(), pathYNombreArchivoJson);
						if (Platform.isFxApplicationThread()) {
							Assert.assertTrue(Platform.isFxApplicationThread());
						}
					}
				});
			}
		});
		thread.start();

		Thread.sleep(5000);
		Assert.assertFalse(Platform.isFxApplicationThread());

	}

	@Test
	public void ejecutaModoGraficoCuandoEncuentraElArchivo() throws InterruptedException {

		Thread thread = new Thread(new Runnable() {
			String pathYNombreArchivoJson = "testFiles/definicion-ejemplo.json";
		

			@Override
			public void run() {
				new JFXPanel();
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						ModoGrafico interfaz;
						interfaz = new ModoGrafico();
						interfaz.ejecutar(new Stage(), pathYNombreArchivoJson);

						if (Platform.isFxApplicationThread()) {
							Assert.assertTrue(Platform.isFxApplicationThread());
						}
					}
				});
			}
		});
		Assert.assertFalse(Platform.isFxApplicationThread());
		thread.start();

		Thread.sleep(5000);

	}
}


