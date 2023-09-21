import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestProfesor {

	@Test
	public void testRegistrarProfesorEnUniversidad() {
        //preparacion
		String nombreUniversidad = "UNLAM",nombre="rodolfo",apellido="perez";
		Integer id=1,DNI=12345,edad=20;
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
        //preparacion
		String nombreUniversidad = "UNLAM",nombre="rodolfo",apellido="perez",
		nombre2="victor",apellido2="heredia";
		Integer id=1,DNI=12345,edad=20,id2=1,DNI2=12345,edad2=20;
		Boolean resultadoProfesor1,resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999,11,1),
				fechaDeIngreso = LocalDate.of(2020,03,1),
				fechaDeNac2 = LocalDate.of(2000,04,1),
				fechaDeIngreso2 = LocalDate.of(2021,03,1);
		
		//ejecuacion
		Universidad universidad = new Universidad(nombreUniversidad);
		Profesor nuevoProfesor = new Profesor(id,nombre,apellido,DNI,edad,fechaDeNac,fechaDeIngreso);
		Profesor nuevoProfesor2 = new Profesor(id,nombre,apellido,DNI,edad,fechaDeNac2,fechaDeIngreso2);
		resultadoProfesor1 = universidad.registrarProfesor(nuevoProfesor);
		resultadoObtenido = universidad.registrarProfesor(nuevoProfesor2);

        //test
		assertNotEquals(resultadoProfesor1,resultadoObtenido);
	}
}
