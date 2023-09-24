import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;

public class TestCursoProfesor {
	@Test
	public void testAgregarProfesorEnCurso() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.of(2023, 9, 23), fechaFinInscripcion = LocalDate.of(2023, 9, 23);

		// Ejecución
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		resultadoObtenido = universidad.asignarProfesorAlaComision(idCurso, DNI);

		// Test
		assertTrue(resultadoObtenido);
	}

	@Test
	public void testQueNoSePuedaAgregarProfesorRepetidoEnCurso() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido, profesorAsignado;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.of(2023, 9, 23), fechaFinInscripcion = LocalDate.of(2023, 9, 23);

		// Ejecución
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		Profesor profesor2 = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor2);
		profesorAsignado = universidad.asignarProfesorAlaComision(idCurso, DNI);
		resultadoObtenido = universidad.asignarProfesorAlaComision(idCurso, DNI);

		// Test
		assertNotEquals(profesorAsignado, resultadoObtenido);
	}

	@Test
	public void testQueNoSePuedaAgregar2ProfesoresEnCursoConMenosDe20Alumnos() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombre2 = "martin",
				apellido2 = "ramirez", nombreAlumno = "juan", apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, DNI = 12345, edad = 20, id2 = 1, idCurso2 = 1, DNI2 = 12345, edad2 = 20,
				idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido, profesorAsignado;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNac2 = LocalDate.of(1999, 11, 01), fechaDeIngreso2 = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.of(2023, 9, 23), fechaFinInscripcion = LocalDate.of(2023, 9, 23);

		// Ejecución
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		Profesor profesor2 = new Profesor(id2, nombre2, apellido2, DNI2, edad2, fechaDeNac2, fechaDeIngreso2);
		universidad.registrarProfesor(profesor2);
		profesorAsignado = universidad.asignarProfesorAlaComision(idCurso, DNI);
		resultadoObtenido = universidad.asignarProfesorAlaComision(idCurso, DNI);

		// Test
		assertNotEquals(profesorAsignado, resultadoObtenido);
	}

	@Test
	public void testQueSePuedaAgregar2ProfesoresEnCursoConMasDe20Alumnos() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombre2 = "martin",
				apellido2 = "ramirez", nombreAlumno = "juan", apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, DNI = 12345, edad = 20, id2 = 1, idCurso2 = 1, DNI2 = 12828, edad2 = 20,
				idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido, profesorAsignado;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNac2 = LocalDate.of(1999, 11, 01), fechaDeIngreso2 = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.of(2023, 9, 23), fechaFinInscripcion = LocalDate.of(2023, 9, 23);

		// Ejecución
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		Profesor profesor2 = new Profesor(id2, nombre2, apellido2, DNI2, edad2, fechaDeNac2, fechaDeIngreso2);
		universidad.registrarProfesor(profesor2);
		profesorAsignado = universidad.asignarProfesorAlaComision(idCurso, DNI);
		resultadoObtenido = universidad.asignarProfesorAlaComision(idCurso, DNI2);
		
		// Test
		assertEquals(profesorAsignado, resultadoObtenido);
	}
}
