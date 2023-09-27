import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TestMetodosCorrelativas {

	@Test
	public void queSePuedaAgregarUnaCorrelativaAUnaMateria() {
		Materia materia = new Materia(2, "pb2");
		Integer idCorrelativa = 1;
		Materia materiaCorrelativa = new Materia(idCorrelativa, "pb1");
		Boolean resultadoEsperado = true;
		Universidad unlam = new Universidad("unlam");
		unlam.registrarMateria(materia);
		unlam.registrarMateria(materiaCorrelativa);
		Boolean resultadoObtenido = unlam.agregarCorrelativa(materia.getId(), idCorrelativa);

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void queNoSePuedaAgregarUnaCorrelativaAUnaMateriaQueNoExiste() {

		Integer idCorrelativa = 1;
		Integer idMateriaQueNoExiste = 3;
		Materia materiaCorrelativa = new Materia(idCorrelativa, "pb1");
		Boolean resultadoEsperado = false;
		Universidad unlam = new Universidad("unlam");
		unlam.registrarMateria(materiaCorrelativa);
		Boolean resultadoObtenido = unlam.agregarCorrelativa(idMateriaQueNoExiste, idCorrelativa);

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void queSePuedaEliminarCorrelativa() {

		Materia materia1 = new Materia(1, "pb3");
		Materia materia2 = new Materia(2, "pb2");
		Materia materia3 = new Materia(3, "pb1");
		Integer idMateriaCorrelativaAElimnar = 2;
		Boolean resultadoEsperado = true;
		Boolean resultadoObtenido;
		Universidad unlam = new Universidad("unlam");
		unlam.registrarMateria(materia1);
		unlam.registrarMateria(materia2);
		unlam.registrarMateria(materia3);
		unlam.agregarCorrelativa(materia3.getId(), materia1.getId());
		unlam.agregarCorrelativa(materia3.getId(), materia2.getId());
		resultadoObtenido = unlam.eliminarCorrelatividad(materia3.getId(), idMateriaCorrelativaAElimnar);

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void queNoSePuedaEliminarCorrelativaDeUnaMateriaQueNoExiste() {

		Integer idMateriaQueNoExiste = 4;
		Materia materia1 = new Materia(3, "pb1");
		List<Integer> correlativas = new ArrayList<>();
		Boolean resultadoEsperado = false;
		Boolean resultadoObtenido;
		correlativas.add(1);
		correlativas.add(2);
		materia1.setCorrelativa(correlativas);
		Universidad unlam = new Universidad("unlam");
		unlam.registrarMateria(materia1);
		resultadoObtenido = unlam.eliminarCorrelatividad(idMateriaQueNoExiste, 2);

		assertEquals(resultadoEsperado, resultadoObtenido);
	}
}