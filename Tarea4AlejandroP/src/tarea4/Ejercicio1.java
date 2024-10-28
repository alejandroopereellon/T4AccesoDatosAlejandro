package tarea4;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
	/**
	 * Realiza un programa Java que lea los datos de 5 alumnos y los guarde campo a
	 * campo en un fichero binario cuyo nombre (y dirección) se solicitará por
	 * teclado. Cada alumno leído deberá ser guardado antes de solicitar el
	 * siguiente. Para cada alumno se tiene la siguiente información: NIA (entero),
	 * Nombre (String), Apellidos (String), Genero (Char), Fecha de Nacimiento
	 * (Fecha), Ciclo (String), Curso (String), Grupo (String).
	 * 
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		// Iniciamos el recurso de escaner
		Scanner sc = new Scanner(System.in);

		// Solicitamos la ruta donde se almacenan todos los archivos
		File rutaEscritura = crearRutaAlmacenamiento(sc);
		// Solicitamos el nombre del archivo
		File ficheroAlmacenar = crearNombreFicheroAlmacenamiento(sc, rutaEscritura);

		// Creamos 5 alumnos y almacenamos para caracteristica
		for (int i = 0; i < 5; i++) {
			Alumno alumno = CrearAlumno.crear();
			almacenarAlumno(alumno, ficheroAlmacenar);
		}
	}

	/**
	 * Este metodo se encarga de almacenar los diferentes atributos del objeto,
	 * solicita el objeto del alumno y la ruta donde se va a almacenar los datos
	 * 
	 * A continuacion recoge los atributos uno a uno y los almacena en el archivo
	 * 
	 * @param alumno       es el alumno que se va a almacenar
	 * @param rutaGuardado es la ruta principal donde se almacena el archivo
	 * @author Alejandro
	 */
	private static void almacenarAlumno(Alumno alumno, File rutaGuardado) {

		try (FileOutputStream salida = new FileOutputStream(new File(rutaGuardado + "\\datos.dat"), true);
				DataOutputStream out = new DataOutputStream(salida)) {
			out.write(alumno.getNia());
			out.writeUTF(alumno.getNombre());
			out.writeUTF(alumno.getApellidos());
			out.writeUTF(alumno.getCiclo());
			out.writeUTF(alumno.getCurso());
			out.writeUTF(alumno.getGrupo());
			out.writeChar(alumno.getGenero());
			out.writeUTF(alumno.getFechaNacimiento().toString());
			System.out.println("Se ha completado el proceso correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este metodo solicita la ruta donde se van a almacenar los datos, primero
	 * solicita la ruta donde se va a almacenar, comprueba que existe, en caso de no
	 * existir va a preguntar si la quiere crear el usuario
	 * 
	 * @param sc es el escaner que se solicita
	 * @return File con la ruta donde se van a almacenar los datos
	 * @author Alejandro
	 */
	private static File crearRutaAlmacenamiento(Scanner sc) {
		File rutaEscritura;
		do {
			System.out.println("Introduce la ruta de guardado");
			rutaEscritura = new File(sc.nextLine());
			if (!rutaEscritura.exists()) {
				System.out.println("La ruta introducida no existe, deseas crear el directorio?\t S/N");
				if (sc.nextLine().equalsIgnoreCase("s")) {
					rutaEscritura.mkdirs();
				}
			}
		} while (!rutaEscritura.exists());
		return rutaEscritura;
	}

	/**
	 * Este metodo se encarga de crear el fichero de escritura, para ello
	 * previamente solicita la ruta y dentro de este metodo va a comprobar que
	 * existe el fichero de almacenamiento y en caso de no existir se consulta si se
	 * desea crear el fichero
	 * 
	 * @param sc            escaner que solicita el texto
	 * @param rutaEscritura es la ruta del archivo que se va solicitar
	 * @return File es la ruta final donde se almacenan los atributos
	 * @author Alejandro
	 * @throws IOException
	 */
	private static File crearNombreFicheroAlmacenamiento(Scanner sc, File rutaEscritura) throws IOException {
		File rutaAlmacenado;
		System.out.println("Introduce el nombre del fichero donde se guardan todos los datos ");
		do {
			rutaAlmacenado = new File(rutaEscritura + "//" + sc.nextLine());
			if (!rutaAlmacenado.exists()) {
				System.out.println("El fichero no existe, deseas crear el fichero?\tS/N");
				if (sc.nextLine().equalsIgnoreCase("s")) {
					// Creamos el archivo necesario
					rutaAlmacenado.createNewFile();
				}
			}
		} while (!rutaAlmacenado.exists());
		return rutaAlmacenado;
	}
}
