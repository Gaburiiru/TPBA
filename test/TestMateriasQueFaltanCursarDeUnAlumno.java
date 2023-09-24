import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Test;

public class TestMateriasQueFaltanCursarDeUnAlumno {

	@Test
	public void queSePuedaObtenerCorrectamentaLaListaDeMateriasQueLeFaltanCursarAUnAlumno() {
		///creamos un alumno
		Integer dniAlumno = 43105267;
		Integer idAlumno = 1;
		
		Alumno alumno = new Alumno(idAlumno, null, null, dniAlumno, null,null, null);
		
		///creamos 2 materias que seran el plan de estudi
		Materia materiaAprobada = new Materia(1,"Pb1");
		Materia materiaQueLeFaltaCursar = new Materia(2, "pb2");
		
		///creamos los ciclosLectivos
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		
		///creamos los cursos
		Integer idCursoDeMateriaAprobada = 1;
		Integer idCursoDeMateriaDesaprobada = 2;
		Curso cursoDeMateriaAprobada = new Curso(idCursoDeMateriaAprobada, materiaAprobada, null, null, null, null);
		Curso cursoDeMateriaQueNecesitaCursar = new Curso(idCursoDeMateriaDesaprobada, materiaQueLeFaltaCursar, null, null, null, null);
		
		///necesito el metodo de registrarNota xq si no se puedo saber si una materia esta aprobada o no 
		///creamos la universidad 
		
		Universidad unlam = new Universidad("unlam");
		
		
		unlam.agregarCicloLectivo(cicloLectivo);
		unlam.registrarAlumno(alumno);
		unlam.registrarMateria(materiaQueLeFaltaCursar);
		unlam.registrarMateria(materiaAprobada);
		unlam.registrarCurso(cursoDeMateriaQueNecesitaCursar);
		unlam.registrarCurso(cursoDeMateriaAprobada);
		
		
		List<Materia> materiasQueLeFaltanCursar = unlam.obtenerMateriasQueFaltanCursarDeUnAlumno(dniAlumno);
		
		///assert
		assertTrue(materiasQueLeFaltanCursar.contains(materiaQueLeFaltaCursar));
		
	}
	
	@Test
	public void alumnoAproboTodasLasMaterias() {
		///creamos un alumno
		Integer dniAlumno = 43105267;
		Integer idAlumno = 1;
		
		Alumno alumno = new Alumno(idAlumno, null, null, dniAlumno, null,null, null);
		
		///creamos 2 materias que seran el plan de estudi
		Materia materiaAprobada = new Materia(1,"Pb1");
		Materia materiaQueLeFaltaCursar = new Materia(2, "pb2");
		
		///creamos los ciclosLectivos
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		
		///creamos los cursos
		Integer idCursoDeMateriaAprobada = 1;
		Integer idCursoDeMateriaDesaprobada = 2;
		Curso cursoDeMateriaAprobada = new Curso(idCursoDeMateriaAprobada, materiaAprobada, null, null, null, null);
		Curso cursoDeMateriaQueNecesitaCursar = new Curso(idCursoDeMateriaDesaprobada, materiaQueLeFaltaCursar, null, null, null, null);
		
		///necesito el metodo de registrarNota xq si no se puedo saber si una materia esta aprobada o no 
		///en este caso necesito que ambas materia esten aprobadas
		///creamos la universidad 
		
		Universidad unlam = new Universidad("unlam");
		
		
		unlam.agregarCicloLectivo(cicloLectivo);
		unlam.registrarAlumno(alumno);
		unlam.registrarMateria(materiaQueLeFaltaCursar);
		unlam.registrarMateria(materiaAprobada);
		unlam.registrarCurso(cursoDeMateriaQueNecesitaCursar);
		unlam.registrarCurso(cursoDeMateriaAprobada);
		
		
		List<Materia> materiasQueLeFaltanCursar = unlam.obtenerMateriasQueFaltanCursarDeUnAlumno(dniAlumno);
		
		///assert
		assertTrue(materiasQueLeFaltanCursar.isEmpty());
	}
	@Test
	public void alumnoLeFaltanCursasTodasLasMaterias() {
		///creamos un alumno
		Integer dniAlumno = 43105267;
		Integer idAlumno = 1;
		
		Alumno alumno = new Alumno(idAlumno, null, null, dniAlumno, null,null, null);
		
		///creamos 2 materias que seran el plan de estudi
		Materia materiaAprobada = new Materia(1,"Pb1");
		Materia materiaAprobada2 = new Materia(2, "pb2");
		
		///creamos los ciclosLectivos
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		
		///creamos los cursos
		Integer idCursoDeMateriaAprobada = 1;
		Integer idCursoDeMateriaDesaprobada = 2;
		Curso cursoDeMateriaAprobada = new Curso(idCursoDeMateriaAprobada, materiaAprobada, null, null, null, null);
		Curso cursoDeMateriaQueNecesitaCursar = new Curso(idCursoDeMateriaDesaprobada, materiaAprobada2, null, null, null, null);
		
		///necesito el metodo de registrarNota xq si no se puedo saber si una materia esta aprobada o no 
		///en este caso necesito que ambas materia esten aprobadas
		///creamos la universidad 
		
		Universidad unlam = new Universidad("unlam");
		
		
		unlam.agregarCicloLectivo(cicloLectivo);
		unlam.registrarAlumno(alumno);
		unlam.registrarMateria(materiaAprobada2);
		unlam.registrarMateria(materiaAprobada);
		unlam.registrarCurso(cursoDeMateriaQueNecesitaCursar);
		unlam.registrarCurso(cursoDeMateriaAprobada);
		
		
		List<Materia> materiasQueLeFaltanCursar = unlam.obtenerMateriasQueFaltanCursarDeUnAlumno(dniAlumno);
		
		///con dos ya tengo confirmado el test		
			assertTrue(materiasQueLeFaltanCursar.contains(materiaAprobada));
			assertTrue(materiasQueLeFaltanCursar.contains(materiaAprobada2));
	}
	
	@Test 
	public void queNoExistaElAlumno() {
		///
		Integer dniAlumnoQuenoExiste = 43105267;
		Integer dniAlumnoQueExiste = 99999;
		
		Alumno alumno = new Alumno(1, null, null, dniAlumnoQuenoExiste, 20, null, null);
		
		Universidad unlam = new Universidad("unlam");
		
		unlam.registrarAlumno(alumno);
		
		assertNull(unlam.obtenerMateriasQueFaltanCursarDeUnAlumno(dniAlumnoQuenoExiste));
	}

}
