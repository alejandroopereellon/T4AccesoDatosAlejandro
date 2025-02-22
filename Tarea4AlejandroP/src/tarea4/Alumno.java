package tarea4;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

public class Alumno implements Serializable {
	private static final long serialVersionUID = -3886814686772411828L;
	/**
	 * Realiza un programa Java que lea los datos de 5 alumnos y los guarde campo a
	 * campo en un fichero binario cuyo nombre (y dirección) se solicitará por
	 * teclado. Cada alumno leído deberá ser guardado antes de solicitar el
	 * siguiente. Para cada alumno se tiene la siguiente información: NIA (entero),
	 * Nombre (String), Apellidos (String), Genero (Char), Fecha de Nacimiento
	 * (Fecha), Ciclo (String), Curso (String), Grupo (String).
	 */
	private String nombre, apellidos, ciclo, curso, grupo;
	private int nia;
	private char genero;
	private LocalDate fechaNacimiento;

	/**
	 * Este constructor crea un objeto ALUMNO con los siguentes parametros
	 * 
	 * @param nombre          Nombre del alumno
	 * @param apellidos       Apellidos del alumno
	 * @param ciclo           Ciclo del alumno
	 * @param curso           Curso del alumno
	 * @param grupo           Grupo del alumno
	 * @param nia             NIA del alumno (Solo numeros)
	 * @param genero          Genero del alumno (Debe ser H o M)
	 * @param fechaNacimiento Fecha de nacimiento del alumno
	 * @author Alejandro
	 */
	public Alumno(String nombre, String apellidos, String ciclo, String curso, String grupo, int nia, char genero,
			LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciclo = ciclo;
		this.curso = curso;
		this.grupo = grupo;
		this.nia = nia;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getNia() {
		return nia;
	}

	public void setNia(int nia) {
		this.nia = nia;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
