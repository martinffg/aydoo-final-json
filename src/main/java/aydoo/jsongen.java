package main.java.aydoo;

public class jsongen {


	static ModoConsola consola;

	public static void main(String[] args) {

		if (args.length == 2){
			consola = new ModoConsola(args[0], args[1]);
			consola.ejecutar();
		}

	}

}
