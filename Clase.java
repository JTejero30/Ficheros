package fechasEjercicio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Clase {

	ArrayList<Persona> DAM = new ArrayList<Persona>();

	public ArrayList<Persona> añadirPersona() {

		ArrayList<String> gente = new ArrayList<String>();
		String[] datos = null;
		String nombre;
		LocalDate fecha;
		String curso;

		try {
			gente = Fichero.devolverFichero();// leo linea por linea y devuelvo un arraylist

			for (int i = 0; i < gente.size(); i++) {
				datos = gente.get(i).split(";");// de la linea i separo por ;
				nombre = datos[1];// voy asignando
				curso = datos[2];
				String[] añoEntero = datos[0].split("-");
				int año = Integer.parseInt(añoEntero[0]);
				int mes = Integer.parseInt(añoEntero[1]);
				int dia = Integer.parseInt(añoEntero[2]);

				fecha = LocalDate.of(año, mes, dia);
				DAM.add(new Persona(nombre, fecha, curso));// creo persona
			}

		} catch (Exception e) {
			System.out.println("Error fatal");
		}
		return DAM;

	}

	public ArrayList<Persona> cumpleañosPorMes() {
		ArrayList<Persona> felicidades = new ArrayList<Persona>();
		String mes;
		Scanner lector = new Scanner(System.in);

		try {
			System.out.println("Introduce el mes en numero o en letra");
			mes = lector.nextLine().toLowerCase();

			if (mes.length() < 3) {
				for (Persona persona : DAM) {
					if (persona.getFecha().getMonthValue() == Integer.parseInt(mes)) {
						felicidades.add(persona);
					}
				}
			} else {
				for (Persona persona : DAM) {
					if (persona.getFecha().getMonthValue() == mesaNumero(mes)) {
						felicidades.add(persona);
					}
				}
			}

		} catch (Exception e) {

		} finally {
			lector.close();
		}
		return felicidades;
	}

	public int mesaNumero(String mes) {

		int numero = 0;

		switch (mes) {

		case "enero":
			numero = 1;
			break;
		case "febrero":
			numero = 2;
			break;
		case "marzo":
			numero = 3;
			break;
		case "abril":
			numero = 4;
			break;
		case "mayo":
			numero = 5;
			break;
		case "junio":
			numero = 6;
			break;
		case "julio":
			numero = 7;
			break;
		case "agosto":
			numero = 8;
			break;
		case "septiembre":
			numero = 9;
			break;
		case "octubre":
			numero = 10;
			break;
		case "noviembre":
			numero = 11;
			break;
		case "diciembre":
			numero = 12;
			break;

		default:
			break;
		}
		return numero;
	}

	public void mayorYmenor() {
		Persona menor = new Persona();
		Persona mayor = new Persona();
		long edadMayor = 0;
		long edadMenor = 100;

		try {
			for (Persona p : DAM) {
				if (ChronoUnit.YEARS.between(p.getFecha(), LocalDate.now()) > edadMayor) {
					edadMayor = ChronoUnit.YEARS.between(p.getFecha(), LocalDate.now());
					mayor = p;
				} else if (ChronoUnit.YEARS.between(p.getFecha(), LocalDate.now()) < edadMenor) {
					edadMenor = ChronoUnit.YEARS.between(p.getFecha(), LocalDate.now());
					menor = p;
				}
			}
			System.out.println("El mayor es " + mayor.getNombre() + ", " + edadMayor + " y el menor es "
					+ menor.getNombre() + ", " + edadMenor);

		} catch (Exception e) {
			System.out.println("Error");
		}

	}

	public ArrayList<Persona> rangoEdad() {
		Scanner lector = new Scanner(System.in);
		int edadMenor = 0;
		int edadMayor = 02;

		try {
			do {
				System.out.println("Determina el rango de edad");
				System.out.print("Edad menor:");
				edadMenor = lector.nextInt();
				lector.nextLine();
				System.out.print("Edad mayor:");
				edadMayor = lector.nextInt();
				lector.nextLine();
			} while (edadMenor > edadMayor);

		} catch (InputMismatchException e) {

			System.out.println("Dato introducido incorrecto, introduzcan un numero");

		} catch (Exception e) {
			// TODO: handle exception
		}

		ArrayList<Persona> comprendidos = new ArrayList<Persona>();

		try {
			for (Persona p : DAM) {
				if (ChronoUnit.YEARS.between(p.getFecha(), LocalDate.now()) >= edadMenor
						&& (ChronoUnit.YEARS.between(p.getFecha(), LocalDate.now()) <= edadMayor)) {
					comprendidos.add(p);
				}

			}
		} catch (Exception e) {

		}

		lector.close();

		return comprendidos;
	}

	public double mediaEdad() {
		double edadTotal = 0;

		try {
			for (Persona persona : DAM) {
				edadTotal += ChronoUnit.YEARS.between(persona.getFecha(), LocalDate.now());
			}
		} catch (Exception e) {

		}
		
		edadTotal= (edadTotal / DAM.size()*1000);

		return edadTotal;
	}

	public void ordenarEdades() {
		ArrayList<Persona> ordenados = new ArrayList<Persona>();
		char opcion;
		Scanner lector = new Scanner(System.in);

		System.out.println("De mayor a menor: '>' / De menor a mayor : '<'");
		opcion = lector.next().charAt(0);

		try {
			for (int i = 100; i > 0; i--) {
				for (Persona persona : DAM) {
					if (ChronoUnit.YEARS.between(persona.getFecha(), LocalDate.now()) == i) {
						ordenados.add(persona);
					}
				}
			}

			if (opcion == '<') {
				Collections.reverse(ordenados);
			}

		} catch (Exception e) {

		} finally {
			System.out.println(ordenados);
			lector.close();
		}

	}

	public String zodiaco(LocalDate fecha) {
		int mes = fecha.getMonthValue();
		int dia = fecha.getDayOfMonth();
		String signo = "";

		if ((mes == 3 && dia >= 21) || (mes == 4 && dia <= 19)) {
			signo = "Aries";
		} else if ((mes == 4 && dia >= 20) || (mes == 5 && dia <= 20)) {
			signo = "Tauro";
		} else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 20)) {
			signo = "Géminis";
		} else if ((mes == 6 && dia >= 21) || (mes == 7 && dia <= 22)) {
			signo = "Cancer";
		} else if ((mes == 7 && dia >= 23) || (mes == 8 && dia <= 22)) {
			signo = "Leo";
		} else if ((mes == 8 && dia >= 23) || (mes == 9 && dia <= 22)) {
			signo = "Virgo";
		} else if ((mes == 9 && dia >= 23) || (mes == 10 && dia <= 22)) {
			signo = "Libra";
		} else if ((mes == 10 && dia >= 23) || (mes == 11 && dia <= 21)) {
			signo = "Escorpio";
		} else if ((mes == 11 && dia >= 22) || (mes == 12 && dia <= 21)) {
			signo = "Sagitario";
		} else if ((mes == 12 && dia >= 22) || (mes == 1 && dia <= 19)) {
			signo = "Capricornio";
		} else if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)) {
			signo = "Acuario";
		} else if ((mes == 2 && dia >= 19) || (mes == 3 && dia <= 20)) {
			signo = "Piscis";
		}
		return signo;
	}

	public void zodiaco() {

		try {
			for (Persona persona : DAM) {
				System.out.println(persona.getNombre() + " es " + zodiaco(persona.getFecha()));
			}

		} catch (Exception e) {
			System.out.println("Error fatal");
		}

	}

}
