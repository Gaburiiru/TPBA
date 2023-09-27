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
		LocalDate fechaDeNac = LocalDate.of(1999,11,1),fechaDeIngreso = LocalDate.of(2020,03,1);
		
		//ejecuacion
		Universidad universidad = new Universidad(nombreUniversidad);
		Alumno nuevoAlumno = new Alumno(id,nombre,apellido,DNI,edad,fechaDeNac,fechaDeIngreso);
		resultado = universidad.registrarAlumno(nuevoAlumno);

        //test
		assertTrue(resultado);
	}
	
	@Test
	public void testQueNoSePuedaRegistrarAlumnoExistenteEnUniversidad() {
        //preparacion
		String nombreUniversidad = "UNLAM",nombre="juan",apellido="pepe",nombre2="carlos",apellido2="duty";
		Integer id=1,DNI=127,edad=20,id2=2,DNI2=127,edad2=20;
		Boolean resultadoAlumno1,resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999,11,1),
				fechaDeIngreso = LocalDate.of(2020,03,1),
				fechaDeNac2 = LocalDate.of(2000,04,1),
				fechaDeIngreso2 = LocalDate.of(2021,03,1);
		
		//ejecuacion
		Universidad universidad = new Universidad(nombreUniversidad);
		Alumno nuevoAlumno = new Alumno(id,nombre,apellido,DNI,edad,fechaDeNac,fechaDeIngreso);
		Alumno nuevoAlumno2 = new Alumno(id2,nombre2,apellido2,DNI2,edad2,fechaDeNac2,fechaDeIngreso2);
		resultadoAlumno1 = universidad.registrarAlumno(nuevoAlumno);
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
		Double resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();
		Turno turnoMañana = Turno.MAÑANA;
		Turno turnoNoche = Turno.NOCHE;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		DiaDeLaSemana miercoles = DiaDeLaSemana.MIERCOLES;
		TipoDeNota nota1erP = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota nota2doP = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota nota1Rec = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		TipoDeNota nota2Rec = TipoDeNota.RECUPERATORIO_2DOPARCIAL;
		
		// Ejecución
		Materia materia = new Materia(idMateria, "PB2");
		Materia materia2 = new Materia(idMateria2, "Ingles1");
		Aula aulaDeCurso = new Aula(1, 50);
		Aula aulaDeCurso2 = new Aula(2, 50);
		Universidad universidad = new Universidad(nombreUniversidad);
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoMañana, lunes);
		Curso cursoAregistrar2 = new Curso(idCurso2, materia2, aulaDeCurso2, cicloLectivo, turnoNoche, miercoles);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,fechaDeIngreso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		CursoAlumno cursoAlumno2 = new CursoAlumno(idCurso2,nuevoAlumno,cursoAregistrar2);
		//1er curso
		Nota nota = new Nota(1, 10,nota1erP);
		Nota nota2 = new Nota(2, 10,nota2doP);
		//2da curso
		Nota nota3 = new Nota(1, 10,nota1erP);
		Nota nota4 = new Nota(2, 10,nota2doP);
		
		universidad.registrarMateria(materia);
		universidad.registrarMateria(materia2);
		universidad.agregarCicloLectivo(cicloLectivo);		
		universidad.registrarCurso(cursoAregistrar);		
		universidad.registrarCurso(cursoAregistrar2);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso2);
		//1er curso
		cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		cursoAlumno.registrarNota(idCurso, idAlumno, nota2);
		//2do curso
		cursoAlumno2.registrarNota(idCurso2, idAlumno, nota3);
		cursoAlumno2.registrarNota(idCurso2, idAlumno, nota4);
		
		resultadoObtenido = universidad.obtenerPromedio(idAlumno);
		
		// Test
		assertEquals(resultadoObtenido,10.0,0);
	}
	
	@Test
	public void testQueNoPuedaSacarPromedioDeUnAlumnoSinNotas() {
		// Preparación
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, idCurso2 = 2,idMateria = 1,idMateria2=2, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Double resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();
		Turno turnoMañana = Turno.MAÑANA;
		Turno turnoNoche = Turno.NOCHE;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		DiaDeLaSemana miercoles = DiaDeLaSemana.MIERCOLES;
		TipoDeNota nota1erP = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota nota2doP = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota nota1Rec = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		TipoDeNota nota2Rec = TipoDeNota.RECUPERATORIO_2DOPARCIAL;
		// Ejecución
		Materia materia = new Materia(idMateria, "PB2");
		Materia materia2 = new Materia(idMateria2, "Ingles1");
		Aula aulaDeCurso = new Aula(1, 50);
		Aula aulaDeCurso2 = new Aula(2, 50);
		Universidad universidad = new Universidad(nombreUniversidad);
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoMañana, lunes);
		Curso cursoAregistrar2 = new Curso(idCurso2, materia2, aulaDeCurso2, cicloLectivo, turnoNoche, miercoles);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,fechaDeIngreso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		CursoAlumno cursoAlumno2 = new CursoAlumno(idCurso2,nuevoAlumno,cursoAregistrar2);
		universidad.registrarMateria(materia);
		universidad.registrarMateria(materia2);
		universidad.agregarCicloLectivo(cicloLectivo);
		universidad.registrarCurso(cursoAregistrar);
		universidad.registrarCurso(cursoAregistrar2);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso2);
		resultadoObtenido = universidad.obtenerPromedio(idAlumno);
		
		// Test
		assertEquals(resultadoObtenido,0.0,0);
	}
}