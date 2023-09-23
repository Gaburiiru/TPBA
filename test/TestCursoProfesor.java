import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestCursoProfesor {

	@Test
	public void testAgregarProfesorEnCurso() {
		// preparacion
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", materia = "matematica",
				nombreAlumno = "juan", apellidoAlumno = "pepe";
		Integer id = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 1), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 1), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1);

		// ejecuacion
		Universidad universidad = new Universidad(nombreUniversidad);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		Materia materiaAsignada = new Materia(id, materia);
		CursoProfesor cursoProfesor = new CursoProfesor(id, profesor, materiaAsignada);
		resultadoObtenido = universidad.asignarDocentesAComision(id, cursoProfesor);

		// test
		assertTrue(resultadoObtenido);
	}

	@Test
	public void testQueNoSePuedaAgregarProfesorRepetidoEnCurso() {
		// preparacion
		String nombreUniversidad = "UNLAM";
		String nombre = "rodolfo", apellido = "perez", nombre2 = "victor", apellido2 = "heredia",
				materia = "matematica", nombreAlumno = "juan", apellidoAlumno = "pepe";
		Integer id = 1, DNI = 12345, edad = 20, id2 = 2, DNI2 = 12345, edad2 = 20, idAlumno = 1, DNIAlumno = 12345,
				edadAlumno = 18;
		Boolean resultadoProfesor1 = false, resultadoObtenido = false;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 1);
		LocalDate fechaDeIngreso = LocalDate.of(2020, 3, 1);
		LocalDate fechaDeNac2 = LocalDate.of(2000, 4, 1);
		LocalDate fechaDeIngreso2 = LocalDate.of(2021, 3, 1), fechaDeNacAlumno = LocalDate.of(1999, 11, 1),
				fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1);

		// ejecuacion
		Universidad universidad = new Universidad(nombreUniversidad);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		Profesor profesor1 = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor1);
		Profesor profesor2 = new Profesor(id2, nombre2, apellido2, DNI2, edad2, fechaDeNac2, fechaDeIngreso2);
		universidad.registrarProfesor(profesor2);
		Materia materiaAsignada = new Materia(id, materia);
		CursoProfesor cursoProfesor = new CursoProfesor(id, profesor1, materiaAsignada);
		CursoProfesor cursoProfesorRepetido = new CursoProfesor(id, profesor2, materiaAsignada);
		resultadoProfesor1 = universidad.asignarDocentesAComision(id, cursoProfesor);
		resultadoObtenido = universidad.asignarDocentesAComision(id, cursoProfesorRepetido);

		// test
		assertNotEquals(resultadoProfesor1, resultadoObtenido);
	}

	@Test
	public void testQueNoSePuedaAgregar2ProfesoresEnCursoConMenosDe20Alumnos() {
		// preparacion
		String nombreUniversidad = "UNLAM";
		String nombre = "rodolfo", apellido = "perez", nombre2 = "victor", apellido2 = "heredia",
				materia = "matematica", nombreAlumno = "juan", apellidoAlumno = "pepe", nombreAlumno2 = "martin",
				apellidoAlumno2 = "ramirez";
		Integer id = 1, DNI = 12345, edad = 20, id2 = 2, DNI2 = 678910, edad2 = 20, idAlumno = 1, DNIAlumno = 12345,
				edadAlumno = 18, idAlumno2 = 2, DNIAlumno2 = 34734, edadAlumno2 = 19;
		Boolean resultadoProfesor1 = false, resultadoObtenido = false;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 1);
		LocalDate fechaDeIngreso = LocalDate.of(2020, 3, 1);
		LocalDate fechaDeNac2 = LocalDate.of(2000, 4, 1);
		LocalDate fechaDeIngreso2 = LocalDate.of(2021, 3, 1), fechaDeNacAlumno = LocalDate.of(1999, 11, 1),
				fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1), fechaDeNacAlumno2 = LocalDate.of(1999, 11, 1),
				fechaDeIngresoAlumno2 = LocalDate.of(2021, 03, 1);

		// ejecuacion
		Universidad universidad = new Universidad(nombreUniversidad);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		Alumno nuevoAlumno2 = new Alumno(idAlumno2, nombreAlumno2, apellidoAlumno2, DNIAlumno2, edadAlumno2,
				fechaDeNacAlumno2, fechaDeIngresoAlumno2);
		universidad.registrarAlumno(nuevoAlumno2);
		Profesor profesor1 = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor1);
		Profesor profesor2 = new Profesor(id2, nombre2, apellido2, DNI2, edad2, fechaDeNac2, fechaDeIngreso2);
		universidad.registrarProfesor(profesor2);
		Materia materiaAsignada = new Materia(id, materia);
		CursoProfesor cursoProfesor = new CursoProfesor(id, profesor1, materiaAsignada);
		CursoProfesor cursoProfesorRepetido = new CursoProfesor(id, profesor2, materiaAsignada);
		resultadoProfesor1 = universidad.asignarDocentesAComision(id, cursoProfesor);
		resultadoObtenido = universidad.asignarDocentesAComision(id, cursoProfesorRepetido);

		// test
		assertTrue(resultadoObtenido);
	}

}
