import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class TestRegistrarAula {

	@Test
	public void queSePuedaAsignarUnAulaAUnCurso() {
		
		Integer idAulaARegistrarI = 20;
		Aula aulaARegistar = new Aula(idAulaARegistrarI, 50);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate fechaInicioCurso = LocalDate.parse("2023-03-27", formatter);
		LocalDate fechaFinCurso = LocalDate.parse("2023-07-14", formatter);
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-01",formatter);
		LocalDate fechaFinInscripcion = LocalDate.parse("2023-03-20",formatter);
		
		Universidad unlam = new Universidad("unlam");
		
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion, fechaFinInscripcion);
		unlam.agregarCicloLectivo(cicloLectivo);
		Integer idCurso = 1;
		Curso curso = new Curso(idCurso, null, null, cicloLectivo, null,null);
		
		
		unlam.registrarCurso(curso);
		unlam.registrarAula(aulaARegistar);
		
		unlam.asignarAulaALaComision(idCurso, idAulaARegistrarI);
		
		Curso cursoACompararCurso = unlam.buscarCurso(idCurso);
		Integer idDelAulaDelCurso = cursoACompararCurso.getAula().getId();
		
		//
		assertEquals(idAulaARegistrarI, idDelAulaDelCurso);
		
	
	}
}
