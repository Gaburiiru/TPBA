import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestMateria {

	@Test
	public void queSePuedaRegistrarUnaMateriaCorrectamente() {
		Materia materiaARegistrar = new Materia(1, "PB2");
		Universidad universidad = new Universidad("Unlam");
		Boolean esperadoBoolean  = true;
		Boolean obtenidoBoolean;
		///
		obtenidoBoolean = universidad.registrarMateria(materiaARegistrar);
		
		///
		assertEquals(esperadoBoolean, obtenidoBoolean);
	}
	

	@Test
	public void queNoPuedaRegistrarUnaMateriaQueYaEsteRegistrada() {
		Materia materiaARegistrar = new Materia(1, "PB2");
		Materia materiaRepetida = new Materia(1, "PB2");
		Universidad universidad = new Universidad("Unlam");
		Boolean esperadoBoolean  = false;
		Boolean obtenidoBoolean;
		///
		obtenidoBoolean = universidad.registrarMateria(materiaARegistrar);
		obtenidoBoolean = universidad.registrarMateria(materiaRepetida);
		
		///
		assertEquals(esperadoBoolean, obtenidoBoolean);
	}
	
	@Test
	public void queNoPuedaRegistrarUnaMateriaQueNofueInicializada() {
		Materia materiaARegistrar = null;
		Universidad universidad = new Universidad("Unlam");
		Boolean esperadoBoolean  = false;
		Boolean obtenidoBoolean;
		///
		obtenidoBoolean = universidad.registrarMateria(materiaARegistrar);
		
		///
		assertEquals(esperadoBoolean, obtenidoBoolean);
	}
	
	
}
