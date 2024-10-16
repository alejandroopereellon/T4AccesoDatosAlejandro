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

	/**
	 * Este metodo recopila toda la informacion necesaria para la creacion del
	 * objeto Alumno, poco a poco va preguntando la informacion necesaria
	 * comprobando que complen los requisitos, ya sea de texto, de numero o de char.
	 * 
	 * @return
	 */
	public static Alumno crearAlumno() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nia del alumno");
		// Solicitamos los datos del NIA
		int nia = 0;
		do {
			try {
				nia = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Introduce un numero");
			}
		} while (nia == 0);

		// Solicitamos los datos escritos
		String nombre, apellidos, ciclo, curso, grupo;
		System.out.println("Introduce el nombre");
		nombre = sc.nextLine();
		System.out.println("Introduce apellidos");
		apellidos = sc.nextLine();
		System.out.println("Introdude el ciclo");
		ciclo = sc.nextLine();
		System.out.println("Introduce el curso");
		curso = sc.nextLine();
		System.out.println("Introduce el grupo");
		grupo = sc.nextLine();

		// Solicitamos el genero de alumno
		System.out.println("Introduce el genero del alumno\tH/M");
		char genero;
		do {
			genero = sc.nextLine().toUpperCase().charAt(0);
			if (genero != 72 && genero != 77) {
				System.out.println("Introduce H o M");
			}
		} while (genero != 72 && genero != 77);

		// Solicitamos la fecha de nacimiento
		System.out.println("Introduce la fecha de nacimiento");
		int dia = 0, mes = 0, ano = 0;
		System.out.println("Introduce el dia");
		do {
			try {
				dia = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Introduce un numero");
			}
		} while (dia == 0);
		System.out.println("Introduce el mes");
		do {
			try {
				mes = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Introduce un numero");
			}
		} while (mes == 0);
		System.out.println("Introduce el año");
		do {
			try {
				ano = Integer.parseInt(sc.nextLine());
				if (ano > Year.now().getValue() || ano < 1900) {
					System.out.println("Introduce un año real");
					ano = 0;
				}
			} catch (Exception e) {
				System.out.println("Introduce un numero");
			}
		} while (ano == 0);
		// Creamos la fecha de nacimiento
		LocalDate fechaNacimiento = null;
		do {
			try {
				fechaNacimiento = LocalDate.of(ano, mes, dia);
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error en la fecha");
			}
		} while (fechaNacimiento == null);

		// Generamos un nuevo alumno
		return new Alumno(grupo, nombre, apellidos, ciclo, curso, nia, genero, fechaNacimiento);
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
