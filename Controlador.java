package fechasEjercicio;

import java.util.Scanner;

public class Controlador {

	public static void main(String[] args) {

		Fichero miFichero = new Fichero("src/fechasEjercicio/datos.txt");
		Clase miClase = new Clase();

		char opcion;
		String datos;
		Scanner lector = new Scanner(System.in);

		

		System.out.println("¿Que desea hacer?");
		System.out.println("1. Inscribir alumno");
		System.out.println("2. Métodos");
		opcion = lector.next().charAt(0);
		lector.nextLine();

		if (opcion == '1') {

			datos=(miFichero.datosAlumno());
			miFichero.escribirAlumno(datos);

		} else {
			
			miClase.añadirPersona();// lo primero que hago es añadir personas

			System.out.println("1. Cumpleaños por cada mes");
			System.out.println("2. Mayor y menor de la clase");
			System.out.println("3. Alumnos por rango de edad");
			System.out.println("4. Alumnos por signo del zodiaco");
			System.out.println("5. Ordenar por edad");
			System.out.println("6. Edad media");

			opcion = lector.next().charAt(0);
			lector.nextLine();

			switch (opcion) {
			case '1':
				System.out.println(miClase.cumpleañosPorMes());
				break;
			case '2':
				miClase.mayorYmenor();
				break;
			case '3':
				System.out.println(miClase.rangoEdad());
				break;
			case '4':
				miClase.zodiaco();// metodo sobrecargado por mi, elijo el que te muestra por
				// pantalla
				break;
			case '5':
				miClase.ordenarEdades(); //solo ordena edades para alumnos con 100 años o menos, porque asi lo he decidido
				break;
			case '6':
				System.out.println(miClase.mediaEdad());
				break;

			default:
				System.out.println("Opcion no valida");
				break;
			}
		}
		lector.close();
	}

}
