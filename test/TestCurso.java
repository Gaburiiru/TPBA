import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Test;

public class TestCurso {

	@Test
	public void queSePuedaRegistrarUnCursoCorrectamente() {
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana diaDeCursada = DiaDeLaSemana.JUEVES;
		Curso cursoAregistrar = new Curso(1, materia, aulaDeCurso, cicloLectivo,turnoString,diaDeCursada);
		
		Universidad universidad = new Universidad("Unlam");
		Boolean esperadoBoolean = true;
		Boolean obtenidoBoolean;
		universidad.agregarCicloLectivo(cicloLectivo);
		obtenidoBoolean = universidad.registrarCurso(cursoAregistrar);
		
		assertEquals(esperadoBoolean, obtenidoBoolean);
	}
	
	@Test
	public void queNoSePuedaRegistrarUnCursoQueYaEsteRegistado() {
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana diaDeCursada = DiaDeLaSemana.JUEVES;
		Curso cursoAregistrar = new Curso(1, materia, aulaDeCurso, cicloLectivo,turnoString,diaDeCursada);
		Curso cursoRepetido = new Curso(1, materia, aulaDeCurso, cicloLectivo,turnoString,diaDeCursada);		
		Universidad universidad = new Universidad("Unlam");
		Boolean esperadoBoolean = false;
		Boolean obtenidoBoolean;
		obtenidoBoolean = universidad.registrarCurso(cursoAregistrar);
		obtenidoBoolean = universidad.registrarCurso(cursoRepetido);
		
		assertEquals(esperadoBoolean, obtenidoBoolean);
	}
	
	@Test
	public void queNoSePuedaRegistrarUnCursoQueTengaElMismoMateriaTurnoYCicloLectivo() {
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana diaDeCursada = DiaDeLaSemana.JUEVES;
		Curso cursoAregistrar = new Curso(1, materia, aulaDeCurso, cicloLectivo,turnoString,diaDeCursada);
		Curso cursoRepetido = new Curso(20, materia, aulaDeCurso, cicloLectivo,turnoString,diaDeCursada);		
		Universidad universidad = new Universidad("Unlam");
		Boolean esperadoBoolean = false;
		Boolean obtenidoBoolean;
		///ejecucion
		universidad.agregarCicloLectivo(cicloLectivo);
		obtenidoBoolean = universidad.registrarCurso(cursoAregistrar);
		obtenidoBoolean = universidad.registrarCurso(cursoRepetido);
		
		assertEquals(esperadoBoolean, obtenidoBoolean);
	}
	
	@Test
	public void queNoSePuedaRegistrarUnCursoQueElCicloLectivoNoEsteRegistradoEnLaUniversidad() {
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana diaDeCursada = DiaDeLaSemana.JUEVES;
		Curso cursoAregistrar = new Curso(1, materia, aulaDeCurso, cicloLectivo,turnoString,diaDeCursada);
		Universidad universidad = new Universidad("Unlam");
		Boolean esperadoBoolean = false;
		Boolean obtenidoBoolean;
		obtenidoBoolean = universidad.registrarCurso(cursoAregistrar);
		
		assertEquals(esperadoBoolean, obtenidoBoolean);
	}
}