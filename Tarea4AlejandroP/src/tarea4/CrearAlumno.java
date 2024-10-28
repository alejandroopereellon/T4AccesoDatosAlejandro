package tarea4;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

public class CrearAlumno {
	/**
	 * Este metodo recopila toda la informacion necesaria para la creacion del
	 * objeto Alumno, poco a poco va preguntando la informacion necesaria
	 * comprobando que complen los requisitos, ya sea de texto, de numero o de char.
	 * 
	 * @return objeto de Alumno
	 * @author Alejandro
	 */
	public static Alumno crear() {
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
}
