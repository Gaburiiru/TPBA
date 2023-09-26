import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class TestIncribirAlumnoACurso {

	@Test
	public void queUnAlumnoSePuedaInscribirCorrectamenteAUnCurso() {
		///creamos el alumno y el curso
		Integer dniAlumnoAInscribir = 43105267;
		Alumno alumnoAInscribir = new Alumno(1, "isaias", "masi",dniAlumnoAInscribir , null, null, null);
		
		///creamos el curso
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-09",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-09-31",formatter);
		
		Universidad unlam = new Universidad("unlam");
		
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		
		Materia materia = new Materia(1, "pb2");
		Turno turnoDeCursada = Turno.MAÑANA;
		DiaDeLaSemana diaDeCursada = DiaDeLaSemana.LUNES;
		
		Aula aulaARegistar = new Aula(10, 50);
		
		Integer idCursoInteger = 1;
		Curso curso = new Curso(idCursoInteger, materia, aulaARegistar, cicloLectivo, turnoDeCursada, diaDeCursada);
		
		unlam.registrarAlumno(alumnoAInscribir);
		unlam.agregarCicloLectivo(cicloLectivo);
		unlam.registrarAula(aulaARegistar);
		unlam.registrarMateria(materia);
		unlam.registrarCurso(curso);
		
		Boolean esperado = true;
		Boolean obtenido = unlam.incribirAlumnoACurso(dniAlumnoAInscribir, idCursoInteger);
		
		///assert
		assertEquals(esperado, obtenido);
	}
	@Test
	public void queNoExistaElCursoAlCualSeQuieraInscribir() {
		///creamos el alumno y el curso
		Integer dniAlumnoAInscribir = 43105267;
		Alumno alumnoAInscribir = new Alumno(1, "isaias", "masi",dniAlumnoAInscribir , null, null, null);
		Integer idCursoQueNoExiste = 2;
		
		Universidad unlam = new Universidad("unlam");
		
		unlam.registrarAlumno(alumnoAInscribir);
		
		
		Boolean esperado = false;
		Boolean obtenido = unlam.incribirAlumnoACurso(dniAlumnoAInscribir, idCursoQueNoExiste);
		
		///assert
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void noEstaRegistradoElAlumnoEnLaUniversidad() {
		///creamos el alumno y el curso
		Integer dniAlumnoQuenoExisteEnLaUniversidad = 43105267;
		
		///creamos el curso
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		
		Universidad unlam = new Universidad("unlam");
		
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		
		Materia materia = new Materia(1, "pb2");
		Turno turnoDeCursada = Turno.MAÑANA;
		DiaDeLaSemana diaDeCursada = DiaDeLaSemana.LUNES;
		
		Aula aulaARegistar = new Aula(10, 50);
		
		Integer idCursoInteger = 1;
		Curso curso = new Curso(idCursoInteger, materia, aulaARegistar, cicloLectivo, turnoDeCursada, diaDeCursada);
		
		unlam.agregarCicloLectivo(cicloLectivo);
		unlam.registrarAula(aulaARegistar);
		unlam.registrarMateria(materia);
		unlam.registrarCurso(curso);
		
		Boolean esperado = false;
		Boolean obtenido = unlam.incribirAlumnoACurso(dniAlumnoQuenoExisteEnLaUniversidad, idCursoInteger);
		
		///assert
		assertEquals(esperado, obtenido);
	}
	
	///para este test necesito el metodo registrarNota
	@Test
	public void queNoEstenAprobadosLaCorrelativaDeLaMateriaQueSeQuiereInscribir() {
		///creamos el alumno y el curso
		Integer dniAlumno = 43105267;
		
		///creamos el curso
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		
		Universidad unlam = new Universidad("unlam");
		
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		
		
		Materia materia = new Materia(1, "pb2");
		Materia materiaCorrelativa = new Materia(2, "pb1");
		Turno turnoDeCursada = Turno.MAÑANA;
		DiaDeLaSemana diaDeCursada = DiaDeLaSemana.LUNES;
		
		Aula aulaARegistar = new Aula(10, 50);
		
		Integer idCursoInteger = 1;
		Curso curso = new Curso(idCursoInteger, materia, aulaARegistar, cicloLectivo, turnoDeCursada, diaDeCursada);
		
		
		unlam.agregarCicloLectivo(cicloLectivo);
		unlam.registrarAula(aulaARegistar);
		unlam.registrarMateria(materia);
		unlam.registrarMateria(materiaCorrelativa);
		unlam.agregarCorrelativa(materia.getId(), materiaCorrelativa.getId());
		unlam.registrarCurso(curso);
		
		///no asigne ninguna nota a la correlativa x lo tanto esta desaprobado
		
		Boolean esperado = false;
		Boolean obtenido = unlam.incribirAlumnoACurso(dniAlumno, idCursoInteger);
		
		///assert
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void queNoSePuedaInscribirAUnCurso() {
		///creamos el alumno y el curso
		Integer dniAlumnoQuenoExisteEnLaUniversidad = 43105267;
		
		///creamos el curso
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		
		////toma la fecha de hoy , pero no esta en la fecha de inscripcion
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		
		Universidad unlam = new Universidad("unlam");
		
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		
		
		Materia materia = new Materia(1, "pb2");
		Materia materiaCorrelativa = new Materia(2, "pb1");
		Turno turnoDeCursada = Turno.MAÑANA;
		DiaDeLaSemana diaDeCursada = DiaDeLaSemana.LUNES;
		
		Aula aulaARegistar = new Aula(10, 50);
		
		Integer idCursoInteger = 1;
		Curso curso = new Curso(idCursoInteger, materia, aulaARegistar, cicloLectivo, turnoDeCursada, diaDeCursada);
		
		
		unlam.agregarCicloLectivo(cicloLectivo);
		unlam.registrarAula(aulaARegistar);
		unlam.registrarMateria(materia);
		unlam.registrarMateria(materiaCorrelativa);
		unlam.agregarCorrelativa(materia.getId(), materiaCorrelativa.getId());
		unlam.registrarCurso(curso);
		
		Boolean esperado = false;
		Boolean obtenido = unlam.incribirAlumnoACurso(dniAlumnoQuenoExisteEnLaUniversidad, idCursoInteger);
		
		///assert
		assertEquals(esperado, obtenido);
	}
	@Test
	public void queNoSePuedaInscribirAUnCursoPorQueElAulaEstaLLeno() {
		///creamos el alumno y el curso
		Integer dniAlumno = 43105267;
		
		///creamos el curso
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		
		////toma la fecha de hoy , pero no esta en la fecha de inscripcion
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		
		Universidad unlam = new Universidad("unlam");
		
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		
		
		Materia materia = new Materia(1, "pb2");
		Turno turnoDeCursada = Turno.MAÑANA;
		DiaDeLaSemana diaDeCursada = DiaDeLaSemana.LUNES;
		Integer cantMaxDeAlumno = 50;
		
		Aula aulaARegistar = new Aula(10, cantMaxDeAlumno);
		
		Integer idCursoInteger = 1;
		Curso curso = new Curso(idCursoInteger, materia, aulaARegistar, cicloLectivo, turnoDeCursada, diaDeCursada);
		///seteamos la cantidad de alumnos del curso
		curso.setCantidadDeAlumnos(cantMaxDeAlumno);
		
		unlam.agregarCicloLectivo(cicloLectivo);
		unlam.registrarAula(aulaARegistar);
		unlam.registrarMateria(materia);
		unlam.registrarCurso(curso);
		
		Boolean esperado = false;
		Boolean obtenido = unlam.incribirAlumnoACurso(dniAlumno, idCursoInteger);
		
		///assert
		assertEquals(esperado, obtenido);
	}
	@Test
	public void queVerifiqueQueNoEsteInscriptoEnOtroCursoElMismoCicloLectivoDiaYTurno() {
		///creamos el alumno y el curso
		Integer dniAlumno = 43105267;
		
		///creamos el curso
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		
		////toma la fecha de hoy , pero no esta en la fecha de inscripcion
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		
		Universidad unlam = new Universidad("unlam");
		
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		
		
		Materia materiaAInscribir = new Materia(1, "pb2");
		Materia materiaYaInscriptoo = new Materia(2, "bd");
		Turno turnoDeCursada = Turno.MAÑANA;
		DiaDeLaSemana diaDeCursada = DiaDeLaSemana.LUNES;
		Integer cantMaxDeAlumno = 50;
		
		Aula aulaARegistar = new Aula(10, cantMaxDeAlumno);
		
		Integer idCursoInteger = 1;
		Integer idCursoQueYaEstaInscripto = 2;
		Curso curso = new Curso(idCursoInteger, materiaAInscribir, aulaARegistar, cicloLectivo, turnoDeCursada, diaDeCursada);
		Curso cursoYaInscripto = new Curso(idCursoQueYaEstaInscripto, materiaYaInscriptoo, aulaARegistar, cicloLectivo, turnoDeCursada, diaDeCursada);
		///seteamos la cantidad de alumnos del curso
	
		
		unlam.agregarCicloLectivo(cicloLectivo);
		unlam.registrarAula(aulaARegistar);
		unlam.registrarMateria(materiaAInscribir);
		unlam.registrarMateria(materiaYaInscriptoo);
		unlam.agregarCorrelativa(materiaAInscribir.getId(), materiaYaInscriptoo.getId());
		unlam.registrarCurso(curso);
		unlam.registrarCurso(cursoYaInscripto);
		unlam.incribirAlumnoACurso(dniAlumno, idCursoQueYaEstaInscripto);
		
		Boolean esperado = false;
		Boolean obtenido = unlam.incribirAlumnoACurso(dniAlumno, idCursoInteger);
		
		///assert
		assertEquals(esperado, obtenido);
	}
	

}
