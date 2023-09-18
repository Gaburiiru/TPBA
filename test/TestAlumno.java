import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class TestAlumno {

	@Test
	public void testRegistrarAlumnoEnUniversidad() {
        //preparacion
		String nombreUniversidad = "UNLAM",nombre="juan",apellido="pepe";
		Integer id=1,DNI=12345,edad=20;
		boolean resultado;
		//ejecuacion
		Universidad universidad = new Universidad(nombreUniversidad);
		Alumno nuevoAlumno = new Alumno(id,nombre,apellido,DNI,edad);
		resultado = universidad.registrarAlumno(nuevoAlumno);

        //test
		assertTrue(resultado);
	}
	
	@Test
	public void testRegistrarAlumnoExistenteEnUniversidad() {
        //preparacion
		String nombreUniversidad = "UNLAM",nombre="juan",apellido="pepe",
		nombre2="carlos",apellido2="duty";
		Integer id=1,DNI=12345,edad=20,id2=1,DNI2=12345,edad2=20;
		boolean resultado,resultado2;
		//ejecuacion
		Universidad universidad = new Universidad(nombreUniversidad);
		Alumno nuevoAlumno = new Alumno(id,nombre,apellido,DNI,edad);
		Alumno nuevoAlumno2 = new Alumno(id2,nombre2,apellido2,DNI2,edad2);
		resultado = universidad.registrarAlumno(nuevoAlumno);
		resultado2 = universidad.registrarAlumno(nuevoAlumno2);

        //test
		assertFalse(resultado2);
	}
}