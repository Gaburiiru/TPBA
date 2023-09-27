import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;
public class TestProfesor {

	@Test
	public void testQueSePuedaRegistrarProfesorEnUniversidad() {
        //preparacion
		String nombreUniversidad = "UNLAM",nombre="rodolfo",apellido="perez";
		Integer id=1,edad=20,DNI = 123;
		boolean resultado;
		LocalDate fechaDeNac = LocalDate.of(1999,11,1),
				fechaDeIngreso = LocalDate.of(2020,03,1);
		//ejecuacion
		Universidad universidad = new Universidad(nombreUniversidad);
		Profesor nuevoProfesor = new Profesor(id,nombre,apellido,DNI,edad,fechaDeNac,fechaDeIngreso);
		resultado = universidad.registrarProfesor(nuevoProfesor);

        //test
		assertTrue(resultado);
	}
	
	@Test
	public void testRegistrarProfesorExistenteEnUniversidad() {
	    //preparación
	    String nombreUniversidad = "UNLAM";
	    String nombre = "rodolfo", apellido = "perez", nombre2 = "victor", apellido2 = "heredia";
	    Integer id = 1, DNI = 12345, edad = 20, id2 = 2, DNI2 = 12345, edad2 = 20;
	    Boolean resultadoProfesor1 = false, resultadoObtenido = false;
	    LocalDate fechaDeNac = LocalDate.of(1999, 11, 1);
	    LocalDate fechaDeIngreso = LocalDate.of(2020, 3, 1);
	    LocalDate fechaDeNac2 = LocalDate.of(2000, 4, 1);
	    LocalDate fechaDeIngreso2 = LocalDate.of(2021, 3, 1);

	    //ejecución
	    Universidad universidad = new Universidad(nombreUniversidad);
	    Profesor nuevoProfesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
	    Profesor nuevoProfesor2 = new Profesor(id2, nombre2, apellido2, DNI2, edad2, fechaDeNac2, fechaDeIngreso2);
	    resultadoProfesor1 = universidad.registrarProfesor(nuevoProfesor);
	    resultadoObtenido = universidad.registrarProfesor(nuevoProfesor2);

	    //test
	    assertNotEquals(resultadoProfesor1,resultadoObtenido);
	}
}
