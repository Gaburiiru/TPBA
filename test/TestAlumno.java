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
		
		Boolean resultadoAlumno1,resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999,11,1),
				fechaDeIngreso = LocalDate.of(2020,03,1),
				fechaDeNac2 = LocalDate.of(2000,04,1),
				fechaDeIngreso2 = LocalDate.of(2021,03,1);
		
		Universidad universidad = new Universidad(nombreUniversidad);
		
		Alumno nuevoAlumno = new Alumno(id,nombre,apellido,DNI,edad,fechaDeNac,fechaDeIngreso);
		Alumno nuevoAlumno2 = new Alumno(id2,nombre2,apellido2,DNI2,edad2,fechaDeNac2,fechaDeIngreso2);
		
		resultadoAlumno1 = universidad.registrarAlumno(nuevoAlumno);
		
		//ejecuacion
		resultadoObtenido = universidad.registrarAlumno(nuevoAlumno2);

        //test
		assertNotEquals(resultadoAlumno1,resultadoObtenido);
	}
	
	@Test
	public void testSacarPromedioDeUnAlumno() {
		// Preparación
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, idCurso2 = 2,idMateria = 1,idMateria2=2, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido,resultado1,resultado2,resultado3,resultado4,resultado5;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();
		
		// Ejecución
		Materia materia = new Materia(idMateria, "PB2");
		Materia materia2 = new Materia(idMateria2, "Ingles1");
		Aula aulaDeCurso = new Aula(1, 50);
		Aula aulaDeCurso2 = new Aula(2, 50);
		Universidad universidad = new Universidad(nombreUniversidad);
		universidad.registrarMateria(materia);
		universidad.registrarMateria(materia2);
		Turno turnoMañana = Turno.MAÑANA;
		Turno turnoNoche = Turno.NOCHE;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoMañana);
		universidad.registrarCurso(cursoAregistrar);
		Curso cursoAregistrar2 = new Curso(idCurso2, materia2, aulaDeCurso2, cicloLectivo, turnoNoche);
		universidad.registrarCurso(cursoAregistrar2);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		CursoAlumno cursoAlumno2 = new CursoAlumno(idCurso2,nuevoAlumno,cursoAregistrar2);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.incribirAlumnoACurso(DNIAlumno, idCurso2);
		TipoDeNota nota1erP = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota nota2doP = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota nota1Rec = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		TipoDeNota nota2Rec = TipoDeNota.RECUPERATORIO_2DOPARCIAL;
		//1er curso
		Nota nota = new Nota(1, 4,nota1erP);
		Nota nota2 = new Nota(2, 4,nota2doP);
		//2da curso
		Nota nota3 = new Nota(1, 4,nota1erP);
		Nota nota4 = new Nota(2, 4,nota2doP);
		Nota nota5 = new Nota(3, 4,nota1Rec);
		//1er curso
		resultado1 =cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		resultado2 = cursoAlumno.registrarNota(idCurso, idAlumno, nota2);
		//2do curso
		resultado3 = cursoAlumno2.registrarNota(idCurso2, idAlumno, nota3);
		resultado4 = cursoAlumno2.registrarNota(idCurso2, idAlumno, nota4);
		resultado5 = cursoAlumno2.registrarNota(idCurso2, idAlumno, nota5);
		//resultadoObtenido = cursoAlumno.calcularPromedioPorCurso(idAlumno);
		resultadoObtenido = universidad.obtenerPromedio(idAlumno);
		
		// Test
		assertTrue(resultado1);
		assertTrue(resultado2);
		assertTrue(resultado3);
		assertTrue(resultado4);
		assertTrue(resultado5);
		assertTrue(resultadoObtenido);
	}
}