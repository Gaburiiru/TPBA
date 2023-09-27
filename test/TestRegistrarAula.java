import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import junit.runner.BaseTestRunner;

public class TestRegistrarAula {

	@Test
	public void queSePuedaAsignarUnAulaAUnCurso() {
		String nombreUniversidad="UNLAM";
		LocalDate fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();
		Materia materia = new Materia(1, "Pb1");
		Integer idAulaARegistrarI = 20,idCurso = 1;
		Aula aulaARegistar = new Aula(idAulaARegistrarI, 50);
		Universidad universidad = new Universidad(nombreUniversidad);
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Turno turnoMañana = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		Curso curso = new Curso(idCurso, materia, aulaARegistar, cicloLectivo, turnoMañana, lunes);
		universidad.registrarCurso(curso);
		universidad.registrarAula(aulaARegistar);
		universidad.asignarAulaALaComision(idCurso, idAulaARegistrarI);
		
		@SuppressWarnings("static-access")
		Curso cursoACompararCurso = universidad.buscarCurso(idCurso);
		Integer idDelAulaDelCurso = cursoACompararCurso.getAula().getId();

		// test
		assertEquals(idAulaARegistrarI, idDelAulaDelCurso);
	}

	@Test
	public void queNoSePuedaAsignarUnAulaQueNoEstaRegistradoAUnCurso() {

		String nombreUniversidad="UNLAM";
		LocalDate fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();
		Materia materia = new Materia(1, "Pb1");
		Integer idAulaARegistrarI = 20,idCurso = 1;
		Aula aulaARegistar = new Aula(idAulaARegistrarI, 50);
		Universidad universidad = new Universidad(nombreUniversidad);
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Turno turnoMañana = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		Curso curso = new Curso(idCurso, materia, aulaARegistar, cicloLectivo, turnoMañana, lunes);
		universidad.registrarCurso(curso);
		/// no registramos el aula a asignar
		/// unlam.registrarAula(aulaARegistar);
		Boolean obtenido = universidad.asignarAulaALaComision(idCurso, idAulaARegistrarI);

		// test
		assertFalse(obtenido);
	}

	@Test
	public void queNoSePuedaAsignarUnAulaAUnCursoQueNoEstaRegistrado() {

		String nombreUniversidad="UNLAM";
		LocalDate fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();
		Materia materia = new Materia(1, "Pb1");
		Integer idAulaARegistrarI = 20,idCurso = 1;
		Aula aulaARegistar = new Aula(idAulaARegistrarI, 50);
		Universidad universidad = new Universidad(nombreUniversidad);
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Turno turnoMañana = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		@SuppressWarnings("unused")
		Curso curso = new Curso(idCurso, materia, aulaARegistar, cicloLectivo, turnoMañana, lunes);
		/// en este caso no registramos el curso
		/// unlam.registrarCurso(curso);
		universidad.registrarAula(aulaARegistar);
		Boolean obtenido = universidad.asignarAulaALaComision(idCurso, idAulaARegistrarI);

		// test
		assertFalse(obtenido);
	}
}