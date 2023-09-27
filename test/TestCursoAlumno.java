import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestCursoAlumno {

	@Test
	public void testearLasMateriasAprobadasPorUnAlumno() {
		/// lista de materias aprobadas hardcodeada
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, edad = 20, idAlumno = 1, DNIAlumno = 7575, edadAlumno = 18;
		Boolean resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		Alumno alumno1 = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNac,
				fechaDeIngreso);
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		Curso curso1 = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString, lunes);
		universidad.registrarAlumno(alumno1);
		universidad.registrarMateria(materia);
		universidad.registrarCurso(curso1);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,alumno1,curso1);

		List<Materia> materiasAprobadasEsperadasList = new ArrayList<>();
		materiasAprobadasEsperadasList.add(materia);
		List<Materia> materiasAprobadas = Universidad.obtenerMateriasAprobadasDeUnAlumno(DNIAlumno);

		for (Materia materia1 : materiasAprobadas) {
			assertTrue(materiasAprobadas.contains(materia1));
		}

	}

	@Test
	public void testearLasMateriasNoAprobadasPorUnAlumno() {
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, edad = 20, idAlumno = 1, DNIAlumno = 7575, edadAlumno = 18;
		Boolean resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		Alumno alumno1 = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNac,
				fechaDeIngreso);
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		Curso curso1 = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString, lunes);
		universidad.registrarAlumno(alumno1);
		universidad.registrarMateria(materia);
		universidad.registrarCurso(curso1);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,alumno1,curso1);
		TipoDeNota nota1erP = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota nota2doP = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota nota1Rec = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		TipoDeNota nota2Rec = TipoDeNota.RECUPERATORIO_2DOPARCIAL;
		//1er curso
		Nota nota = new Nota(1, 4,nota1erP);
		Nota nota2 = new Nota(2, 4,nota2doP);
		cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		cursoAlumno.registrarNota(idCurso, idAlumno, nota2);

		List<Materia> materiasAprobadasEsperadasList = new ArrayList<>();
		materiasAprobadasEsperadasList.add(materia);
		List<Materia> materiasAprobadas = universidad.obtenerMateriasAprobadasDeUnAlumno(DNIAlumno);

		for (Materia materia1 : materiasAprobadas) {
			assertFalse(materiasAprobadas.contains(materia1));
		}
	}

	@Test
	public void testAsignarAlumnoACurso() {
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, edad = 20, idAlumno = 1, DNIAlumno = 7575, edadAlumno = 18;
		Boolean resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString, lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		resultadoObtenido = universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		assertTrue(resultadoObtenido);
	}

	@Test
	public void testQueNoSePuedaInscribirElAlumnoAElMismoCurso() {
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, edad = 20, idAlumno = 1, DNIAlumno = 7575, edadAlumno = 18;
		Boolean resultadoObtenido, resultado;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString, lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		resultadoObtenido = universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		resultado = universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		assertNotEquals(resultadoObtenido, resultado);
	}
	
	@Test
	public void testQueSePuedaSacarPromedioPorElCurso() {
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, edad = 20, idAlumno = 1, DNIAlumno = 7575, edadAlumno = 18;
		Boolean resultadoObtenido, resultado;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString, lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		TipoDeNota nota1erP = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota nota2doP = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota nota1Rec = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		TipoDeNota nota2Rec = TipoDeNota.RECUPERATORIO_2DOPARCIAL;
		//1er curso
		Nota nota = new Nota(1, 4,nota1erP);
		Nota nota2 = new Nota(2, 4,nota2doP);
		cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		cursoAlumno.registrarNota(idCurso, idAlumno, nota2);
		resultadoObtenido = cursoAlumno.calcularPromedioPorCurso(idAlumno);
		//test
		assertTrue(resultadoObtenido);
	}
	
	@Test
	public void testQueNoSePuedaSacarPromedioPorElCursoSinNotas() {
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, edad = 20, idAlumno = 1, DNIAlumno = 7575, edadAlumno = 18;
		Boolean resultadoObtenido, resultado;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString, lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		resultadoObtenido = cursoAlumno.calcularPromedioPorCurso(idAlumno);
		
		assertFalse(resultadoObtenido);
	}
}
