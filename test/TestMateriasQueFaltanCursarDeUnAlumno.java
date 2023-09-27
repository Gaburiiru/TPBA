import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.List;
import org.junit.Test;

public class TestMateriasQueFaltanCursarDeUnAlumno {

	@Test
	public void queSePuedaObtenerCorrectamentaLaListaDeMateriasQueLeFaltanCursarAUnAlumno() {
		///creamos un alumno
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez";
		Integer id = 1, idCurso = 1,idCurso2 = 2, edad = 20, idAlumno = 1, DNIAlumno = 7575, edadAlumno = 18;
		Universidad universidad = new Universidad(nombreUniversidad);
		///creamos 2 materias que seran el plan de estudio
		Materia materiaAprobada = new Materia(1,"Pb1");
		Materia materiaQueLeFaltaCursar = new Materia(2, "pb2");
		
		///creamos los ciclosLectivos
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		Alumno alumno = new Alumno(idAlumno, nombre, apellido, DNIAlumno, edadAlumno,fechaDeNac, fechaDeIngreso);
		
		///creamos los cursos
		Integer idCursoDeMateriaAprobada = 1,idCursoDeMateriaDesaprobada = 2;
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		DiaDeLaSemana martes = DiaDeLaSemana.MARTES;
		Curso cursoDeMateriaAprobada = new Curso(idCursoDeMateriaAprobada, materiaAprobada, aulaDeCurso, cicloLectivo, turnoString, lunes);
		Curso cursoDeMateriaQueNecesitaCursar = new Curso(idCursoDeMateriaDesaprobada, materiaQueLeFaltaCursar, aulaDeCurso, cicloLectivo, turnoString, martes);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,alumno,cursoDeMateriaAprobada);
		universidad.agregarCicloLectivo(cicloLectivo);
		universidad.registrarAlumno(alumno);
		universidad.registrarMateria(materiaQueLeFaltaCursar);
		universidad.registrarMateria(materiaAprobada);
		universidad.registrarCurso(cursoDeMateriaQueNecesitaCursar);
		universidad.registrarCurso(cursoDeMateriaAprobada);
		TipoDeNota nota1erP = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota nota2doP = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota nota1Rec = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		TipoDeNota nota2Rec = TipoDeNota.RECUPERATORIO_2DOPARCIAL;
		//1er curso
		Nota nota = new Nota(1, 10,nota1erP);
		Nota nota2 = new Nota(2, 10,nota2doP);
		cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		cursoAlumno.registrarNota(idCurso, idAlumno, nota2);

		List<Materia> materiasQueLeFaltanCursar = universidad.obtenerMateriasQueFaltanCursarDeUnAlumno(DNIAlumno);
		
		// test
		assertTrue(materiasQueLeFaltanCursar.contains(materiaQueLeFaltaCursar));
	}
	/* ACLARACION: TEST NO FUNCIONAL, por falta de tiempo no llegamos a terminarlo.
	@Test
	public void alumnoAproboTodasLasMaterias() {
		///creamos un alumno
		Boolean cursoAprobado,cursoNoAprobado;
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez";
		Integer id = 1, idCurso = 1,idCurso2 = 2, edad = 20, idAlumno = 1, DNIAlumno = 7575, edadAlumno = 18;
		Universidad universidad = new Universidad(nombreUniversidad);
		Materia materiaAprobada = new Materia(1,"Pb1");
		Materia materiaAprobada2 = new Materia(2, "pb2");
		universidad.registrarMateria(materiaAprobada2);
		universidad.registrarMateria(materiaAprobada);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		DiaDeLaSemana martes = DiaDeLaSemana.MARTES;
		///creamos los ciclosLectivos
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Alumno alumno = new Alumno(idAlumno, nombre, apellido, DNIAlumno, edadAlumno,fechaDeNac, fechaDeIngreso);
		universidad.registrarAlumno(alumno);
		///creamos los cursos
		Integer idCursoDeMateriaAprobada = 1,idCursoDeMateriaAprobada2 = 2;
		Curso cursoDeMateriaAprobada = new Curso(idCursoDeMateriaAprobada, materiaAprobada, aulaDeCurso, cicloLectivo, turnoString, lunes);
		Curso cursoDeMateriaAprobada2 = new Curso(idCursoDeMateriaAprobada2, materiaAprobada2, aulaDeCurso, cicloLectivo, turnoString, martes);
		universidad.registrarCurso(cursoDeMateriaAprobada2);
		universidad.registrarCurso(cursoDeMateriaAprobada);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCursoDeMateriaAprobada);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCursoDeMateriaAprobada2);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,alumno,cursoDeMateriaAprobada);
		CursoAlumno cursoAlumno2 = new CursoAlumno(idCurso2,alumno,cursoDeMateriaAprobada2);
		

		TipoDeNota nota1erP = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota nota2doP = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota nota1Rec = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		TipoDeNota nota2Rec = TipoDeNota.RECUPERATORIO_2DOPARCIAL;
		//1er curso
		Nota nota = new Nota(1, 10,nota1erP);
		Nota nota2 = new Nota(2, 10,nota2doP);
		cursoAlumno.registrarNota(1, idAlumno, nota);
		cursoAlumno.registrarNota(2, idAlumno, nota2);
		//2do curso
		Nota nota3 = new Nota(1, 10,nota1erP);
		Nota nota4 = new Nota(2, 10,nota2doP);
		cursoAlumno2.registrarNota(1, idAlumno, nota3);
		cursoAlumno2.registrarNota(2, idAlumno, nota4);

		List<Materia> materiasQueLeFaltanCursar = universidad.obtenerMateriasQueFaltanCursarDeUnAlumno(DNIAlumno);
		
		assertTrue(materiasQueLeFaltanCursar.isEmpty());
	}*/

	@Test
	public void alumnoLeFaltanCursasTodasLasMaterias() {
		///creamos un alumno
		Universidad unlam = new Universidad("unlam");
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez";
		Integer id = 1, idCurso = 1,idCurso2 = 2, edad = 20, idAlumno = 1, DNIAlumno = 7575, edadAlumno = 18;
		Aula aulaDeCurso = new Aula(1, 50);
		
		///creamos 2 materias que seran el plan de estudi
		Materia materiaAprobada = new Materia(1,"Pb1");
		Materia materiaAprobada2 = new Materia(2, "pb2");
		unlam.registrarMateria(materiaAprobada2);
		unlam.registrarMateria(materiaAprobada);
		///creamos los ciclosLectivos
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		Alumno alumno = new Alumno(idAlumno, nombre, apellido, DNIAlumno, edadAlumno,fechaDeNac, fechaDeIngreso);
		unlam.registrarAlumno(alumno);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		DiaDeLaSemana martes = DiaDeLaSemana.MARTES;
		///creamos los cursos
		Integer idCursoDeMateriaAprobada = 1;
		Integer idCursoDeMateriaDesaprobada = 2;
		Curso cursoDeMateriaAprobada = new Curso(idCursoDeMateriaAprobada, materiaAprobada, aulaDeCurso, cicloLectivo, turnoString, lunes);
		Curso cursoDeMateriaQueNecesitaCursar = new Curso(idCursoDeMateriaDesaprobada, materiaAprobada2, aulaDeCurso, cicloLectivo, turnoString, martes);

		///necesito el metodo de registrarNota xq si no se puedo saber si una materia esta aprobada o no 
		///en este caso necesito que ambas materia esten aprobadas
		///creamos la universidad 

		
		unlam.agregarCicloLectivo(cicloLectivo);
		unlam.registrarCurso(cursoDeMateriaQueNecesitaCursar);
		unlam.registrarCurso(cursoDeMateriaAprobada);
		List<Materia> materiasQueLeFaltanCursar = unlam.obtenerMateriasQueFaltanCursarDeUnAlumno(DNIAlumno);
		///con dos ya tengo confirmado el test		
		assertTrue(materiasQueLeFaltanCursar.contains(materiaAprobada));
		assertTrue(materiasQueLeFaltanCursar.contains(materiaAprobada2));
	}
	
	@Test 
	public void testNoObtenerMateriasDeUnAlumnoqueNoExista() {
		String nombreUniversidad = "UNLAM",nombre="juan",apellido="pepe";
		Integer dniAlumnoQueExiste = 43105,dniAlumnoQuenoExiste = 99999,idAlumno=1,edadAlumno=20;
		LocalDate fechaDeNac = LocalDate.of(1999,11,1),fechaDeIngreso = LocalDate.of(2020,03,1);
		Universidad universidad = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(idAlumno, nombre, apellido, dniAlumnoQueExiste, edadAlumno, fechaDeNac, fechaDeIngreso);
		Boolean resultado = universidad.registrarAlumno(alumno);
		assertTrue(resultado);
		assertNull(universidad.obtenerMateriasQueFaltanCursarDeUnAlumno(dniAlumnoQuenoExiste));
	}
}