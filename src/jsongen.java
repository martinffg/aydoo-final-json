import main.java.aydoo.ModoConsola;
import main.java.aydoo.EjecutarModoGrafico;

public class jsongen   {

	static String archivoEntrada;
	static ModoConsola consola;

	public static void main(String[] args) {

		if (args.length == 2){

			consola = new ModoConsola(args[0], args[1]);
			consola.ejecutar();
			String mensajeDeOperacion=consola.mensajeDeSalida();
			System.out.println(mensajeDeOperacion);


		}else if (args.length == 1){

           EjecutarModoGrafico modoGrafico= new EjecutarModoGrafico();
           modoGrafico.main(args);
            }
	}

	 



}