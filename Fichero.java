package fechasEjercicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichero {

	private String ruta ="src/fechasEjercicio/datos.txt";

	public Fichero(String ruta) {
		super();
		this.ruta = ruta;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "Fichero [ruta=" + ruta + "]";
	}

	public void leerFichero() {

		FileReader fichero = null;
		BufferedReader lector = null;
		String cadena;

		try {
			fichero = new FileReader(ruta);
			lector = new BufferedReader(fichero);

			while ((cadena = lector.readLine()) != null) {
				System.out.println(cadena);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			try {
				if (lector != null) {
					lector.close();
				}
				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("finally")
	public static ArrayList<String> devolverFichero() {

		FileReader fichero = null;
		BufferedReader lector = null;
		String cadena;
		ArrayList<String> contenido = new ArrayList<String>();

		try {
			fichero = new FileReader("src/fechasEjercicio/datos.txt");

			lector = new BufferedReader(fichero);

			while ((cadena = lector.readLine()) != null) {
				contenido.add(cadena);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			try {
				if (lector != null) {
					lector.close();
				}
				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
				e.printStackTrace();
			} finally {
				return contenido;
			}

		}

	}

	public void escribirFichero(ArrayList<String> datos) {
		FileWriter guardar = null;

		try {
			guardar = new FileWriter(ruta, true);// true = append

			for (String dato : datos) {
				guardar.write(dato + (char) 13);
			}
			// for(int i=0;i<datos.length;i++) {}

		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			System.out.println("Un error incontrolado");
		} finally {
			try {
				if (guardar != null) {
					guardar.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	public void escribirFichero(Fichero datos) {
		FileWriter guardar = null;
		FileReader fichero = null;
		BufferedReader lector = null;
		String cadena;

		try {
			guardar = new FileWriter(ruta, true);// true = append
			fichero = new FileReader(datos.getRuta());
			lector = new BufferedReader(fichero);

			while ((cadena = lector.readLine()) != null) {
				guardar.write(cadena + (char) 13);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			try {
				if (guardar != null) {
					guardar.close();
				}
				if (lector != null) {
					lector.close();
				}
				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
				e.printStackTrace();

			}

		}

	}

	public void escribirFichero(String dato) {
		FileWriter guardar = null;

		try {
			guardar = new FileWriter(ruta, true);// true = append
			guardar.write(dato + (char) 13);

		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			System.out.println("Un error incontrolado");
		} finally {
			try {
				if (guardar != null) {
					guardar.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	public void escribirAlumno(String datos) {

		FileWriter guardar = null;

		try {
			guardar = new FileWriter(ruta, true); // true para escribir en la ultima linea
			guardar.write(datos + (char) 13);

		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			System.out.println("Un error ha sucedido");
		} finally {
			try {
				if (guardar != null) {
					guardar.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public String datosAlumno() {

		
	
		Scanner lector = new Scanner(System.in);
		String dato;
		String datos = "";
		boolean valido = false;

		while (!valido) {
			System.out.println("Introduzca los datos del alumno");
			System.out.print("Año: ");
			dato = lector.nextLine();
			if (dato.length() == 4 && Integer.parseInt(dato) > 1900
					&& Integer.parseInt(dato) < LocalDate.now().getYear()) {
				valido = true;
				datos += dato + "-";
			} else {
				System.out.println("Año no valido");
			}
		}

		valido=false;
		while (!valido) {
			System.out.print("Mes en numero: ");
			dato = lector.nextLine();
			if (Integer.parseInt(dato)>0 && Integer.parseInt(dato)<=12) {
				valido = true;
							
				if (dato.length()==1) { // le pongo un 0 por si pone del 0 al 9 con un solo digito
					dato="0"+dato;
				}
				
				datos += dato + "-";
			} else {
				System.out.println("Mes no valido");
			}
			
		}
		valido=false;
		while (!valido) {
			System.out.print("Día: ");
			dato = lector.nextLine();
			if (Integer.parseInt(dato)>0 && Integer.parseInt(dato)<31) {
				valido = true;
				
				if (dato.length()==1) {
					dato="0"+dato;
				}
				datos += dato +";";
			} else {
				System.out.println("Día no valido");
			}
		}

		System.out.print("Nombre y apellidos:");
		dato = lector.nextLine();
		datos += dato + ";";

		System.out.print("Curso:");
		dato = lector.nextLine();
		datos += dato;
		
		lector.close();

		return datos;
		
		

	}
	
	
}
