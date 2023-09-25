import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class TestNota {

	@Test
	public void testQueSePuedaAgregarUnaNota() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();
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
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		Nota nota = new Nota(idNota, 1,notaString);
		resultadoObtenido = universidad.registrarNota(idCurso, idAlumno, nota);
		// Test
		assertTrue(resultadoObtenido);
	}

	@Test
	public void testQueNoSePuedaAgregarUnTipoDeNotaRepetida() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido,resultado;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.of(2023, 9, 24), fechaFinInscripcion = LocalDate.of(2023, 9, 24);

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
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota notaString2 = TipoDeNota.PRIMER_PARCIAL;
		Nota nota = new Nota(idNota, 10,notaString);
		Nota nota2 = new Nota(idNota, 1,notaString2);
		resultado = universidad.registrarNota(idCurso, idAlumno, nota);
		resultadoObtenido = universidad.registrarNota(idCurso, idAlumno, nota2);
		// Test
		assertNotEquals(resultado,resultadoObtenido);
	}
	
	@Test
	public void testQueSePuedaAgregarDosTiposDeNotasDistintas() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido,resultado;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.of(2023, 9, 24), fechaFinInscripcion = LocalDate.of(2023, 9, 24);

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
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota notaString2 = TipoDeNota.SEGUNDO_PARCIAL;
		Nota nota = new Nota(idNota, 10,notaString);
		Nota nota2 = new Nota(idNota, 1,notaString2);
		resultado = universidad.registrarNota(idCurso, idAlumno, nota);
		resultadoObtenido = universidad.registrarNota(idCurso, idAlumno, nota2);
		// Test
		assertEquals(resultado,resultadoObtenido);
	}
	
	@Test
	public void testQueSePuedaAgregarTresTiposDeNotasDistintas() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido,resultado1,resultado2;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.of(2023, 9, 24), fechaFinInscripcion = LocalDate.of(2023, 9, 24);

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
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota notaString2 = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota notaString3 = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		Nota nota = new Nota(idNota, 10,notaString);
		Nota nota2 = new Nota(idNota, 1,notaString2);
		Nota nota3 = new Nota(idNota, 1,notaString3);
		resultado1 =universidad.registrarNota(idCurso, idAlumno, nota);
		resultado2 = universidad.registrarNota(idCurso, idAlumno, nota2);
		resultadoObtenido = universidad.registrarNota(idCurso, idAlumno, nota3);
		// Test
		assertTrue(resultado1);
		assertTrue(resultado2);
		assertTrue(resultadoObtenido);
	}
	
	@Test
	public void testQueNoSePuedaAgregarMasDeTresTiposDeNotasDistintas() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido,resultado1,resultado2,resultado3;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.of(2023, 9, 24), fechaFinInscripcion = LocalDate.of(2023, 9, 24);

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
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota notaString2 = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota notaString3 = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		TipoDeNota notaString4 = TipoDeNota.RECUPERATORIO_2DOPARCIAL;
		Nota nota = new Nota(idNota, 10,notaString);
		Nota nota2 = new Nota(idNota, 2,notaString2);
		Nota nota3 = new Nota(idNota, 1,notaString3);
		Nota nota4 = new Nota(idNota, 5,notaString4);
		resultado1 =universidad.registrarNota(idCurso, idAlumno, nota);
		resultado2 = universidad.registrarNota(idCurso, idAlumno, nota2);
		resultado3 = universidad.registrarNota(idCurso, idAlumno, nota3);
		resultadoObtenido = universidad.registrarNota(idCurso, idAlumno, nota4);
		// Test
		assertTrue(resultado1);
		assertTrue(resultado2);
		assertTrue(resultado3);
		assertFalse(resultadoObtenido);
	}
}
