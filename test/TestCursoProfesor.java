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
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString, lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
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
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString, lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
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
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString, lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
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
				idAlumno = 1, idAlumno2 = 2, DNIAlumno = 12345, edadAlumno = 18, DNIAlumno2 = 67891, DNIAlumno3 = 12233,
				DNIAlumno4 = 66556, DNIAlumno5 = 12445, DNIAlumno6 = 99223, DNIAlumno7 = 77839, DNIAlumno8 = 41513,
				DNIAlumno9 = 76187, DNIAlumno10 = 51262, DNIAlumno11 = 88438, DNIAlumno12 = 35663, DNIAlumno13 = 84897,
				DNIAlumno14 = 93058, DNIAlumno15 = 52525, DNIAlumno16 = 25666, DNIAlumno17 = 31667, DNIAlumno18 = 93493,
				DNIAlumno19 = 23982, DNIAlumno20 = 12381, DNIAlumno21 = 15533;
		Boolean resultadoObtenido, profesorAsignado;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNac2 = LocalDate.of(1999, 11, 01), fechaDeIngreso2 = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		// Ejecución
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString, lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		Alumno nuevoAlumno2 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno2, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno3 = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno3, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno4 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno4, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno5 = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno5, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno6 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno6, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno7 = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno7, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno8 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno8, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno9 = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno9, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno10 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno10, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno11 = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno11, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno12 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno12, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno13 = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno13, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno14 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno14, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno15 = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno15, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno16 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno16, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno17 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno17, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno18 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno18, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno19 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno19, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno20 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno20, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);
		Alumno nuevoAlumno21 = new Alumno(idAlumno2, nombreAlumno, apellidoAlumno, DNIAlumno21, edadAlumno,
				fechaDeNacAlumno, fechaDeIngresoAlumno);

		universidad.registrarAlumno(nuevoAlumno);
		universidad.registrarAlumno(nuevoAlumno2);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno2, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno3, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno4, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno5, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno6, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno7, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno8, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno9, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno10, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno11, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno12, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno13, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno14, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno15, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno16, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno17, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno18, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno19, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno20, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno21, idCurso);
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
