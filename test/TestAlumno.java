import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;

public class TestAlumno {

	@Test
	public void testRegistrarAlumnoEnUniversidad() {
        //preparacion
		String nombreUniversidad = "UNLAM",nombre="juan",apellido="pepe";
		Integer id=1,DNI=12345,edad=20;
		boolean resultado;
		LocalDate fechaDeNac = LocalDate.of(1999,11,1),
				fechaDeIngreso = LocalDate.of(2020,03,1);
		//ejecuacion
		Universidad universidad = new Universidad(nombreUniversidad);
		Alumno nuevoAlumno = new Alumno(id,nombre,apellido,DNI,edad,fechaDeNac,fechaDeIngreso);
		resultado = universidad.registrarAlumno(nuevoAlumno);

        //test
		assertTrue(resultado);
	}
	
	@Test
	public void testRegistrarAlumnoExistenteEnUniversidad() {
        //preparacion
		String nombreUniversidad = "UNLAM",
				nombre="juan",
				apellido="pepe",
				nombre2="carlos",
				apellido2="duty";
		
		Integer id=1,
				DNI=127,
				edad=20,
				id2=2,
				DNI2=127,
				edad2=20;
		
		Boolean resultadoAlumno1;
		Boolean resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999,11,1),
				fechaDeIngreso = LocalDate.of(2020,03,1),
				fechaDeNac2 = LocalDate.of(1999,11,1),
				fechaDeIngreso2 = LocalDate.of(2020,03,1);
		
		Universidad universidad = new Universidad(nombreUniversidad);
		
		Alumno nuevoAlumno = new Alumno(id,nombre,apellido,DNI,edad,fechaDeNac,fechaDeIngreso);
		Alumno nuevoAlumno2 = new Alumno(id2,nombre2,apellido2,DNI2,edad2,fechaDeNac2,fechaDeIngreso2);
		
		resultadoAlumno1 = universidad.registrarAlumno(nuevoAlumno);
		
		//ejecuacion
		resultadoObtenido = universidad.registrarAlumno(nuevoAlumno2);

        //test
	}
}