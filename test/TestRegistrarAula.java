import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class TestRegistrarAula {

	@Test
	public void queSePuedaAsignarUnAulaAUnCurso() {
		
		Integer idAulaARegistrarI = 20;
		Aula aulaARegistar = new Aula(idAulaARegistrarI, 50);
		
		Universidad unlam = new Universidad("unlam");
		
		Integer idCurso = 1;
		Curso curso = new Curso(idCurso, null, null, null, null,null);
		
		
		unlam.registrarCurso(curso);
		unlam.registrarAula(aulaARegistar);
		
		unlam.asignarAulaALaComision(idCurso, idAulaARegistrarI);
		
		Curso cursoACompararCurso = unlam.buscarCurso(idCurso);
		Integer idDelAulaDelCurso = cursoACompararCurso.getAula().getId();
		
		//
		assertEquals(idAulaARegistrarI, idDelAulaDelCurso);
	}
	
	@Test
	public void queNoSePuedaAsignarUnAulaQueNoEstaRegistradoAUnCurso() {
		
		Integer idAulaARegistrarI = 20;
		Aula aulaARegistar = new Aula(idAulaARegistrarI, 50);
		
		Universidad unlam = new Universidad("unlam");
		
		Integer idCurso = 1;
		Curso curso = new Curso(idCurso, null, null, null, null,null);
		
		unlam.registrarCurso(curso);
		///no registramos el aula a asignar 
		///unlam.registrarAula(aulaARegistar);
		
		Boolean obtenido = unlam.asignarAulaALaComision(idCurso, idAulaARegistrarI);
		
		
		assertFalse(obtenido);
	}
	@Test
	public void queNoSePuedaAsignarUnAulaAUnCursoQueNoEstaRegistrado() {
		
		Integer idAulaARegistrarI = 20;
		Aula aulaARegistar = new Aula(idAulaARegistrarI, 50);
		Integer idCurso = 1;
		
		Curso curso = new Curso(idCurso, null, null, null, null,null);
		
		
		Universidad unlam = new Universidad("unlam");
		///en este caso no registramos el curso
		///unlam.registrarCurso(curso);
		unlam .registrarAula(aulaARegistar);
		
		Boolean obtenido = unlam.asignarAulaALaComision(idCurso, idAulaARegistrarI);
		
		
		assertFalse(obtenido);
	}
	
}
