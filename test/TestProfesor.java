import static org.junit.Assert.*;

import org.junit.Test;

public class TestProfesor {

	@Test
	public void testRegistrarProfesorEnUniversidad() {
        //preparacion
		String nombreUniversidad = "UNLAM",nombre="rodolfo",apellido="perez";
		Integer id=1,DNI=12345,edad=20;
		boolean resultado;
		//ejecuacion
		Universidad universidad = new Universidad(nombreUniversidad);
		Profesor nuevoProfesor = new Profesor(id,nombre,apellido,DNI,edad);
		resultado = universidad.registrarProfesor(nuevoProfesor);

        //test
		assertTrue(resultado);
	}
	
	@Test
	public void testRegistrarProfesorExistenteEnUniversidad() {
        //preparacion
		String nombreUniversidad = "UNLAM",nombre="rodolfo",apellido="perez",
		nombre2="victor",apellido2="heredia";
		Integer id=1,DNI=12345,edad=20,id2=1,DNI2=12345,edad2=20;
		boolean resultado,resultado2;
		//ejecuacion
		Universidad universidad = new Universidad(nombreUniversidad);
		Profesor nuevoProfesor = new Profesor(id,nombre,apellido,DNI,edad);
		Profesor nuevoProfesor2 = new Profesor(id,nombre,apellido,DNI,edad);
		resultado = universidad.registrarProfesor(nuevoProfesor);
		resultado2 = universidad.registrarProfesor(nuevoProfesor2);

        //test
		assertFalse(resultado2);
	}

}
