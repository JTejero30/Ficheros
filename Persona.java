package fechasEjercicio;

import java.time.LocalDate;


public class Persona {

	Fichero miFichero = null;

	private String nombre;
	private LocalDate fecha;
	private String curso;

	public Persona(String nombre, LocalDate fecha, String curso) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return String.format(nombre + ", " + fecha + ", " + curso + "%n");
	}

	public Persona() {
		super();
	}
}
