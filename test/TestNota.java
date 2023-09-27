import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;

public class TestNota {

	@Test
	public void testQueSePuedaAgregarUnaNotaValida() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();
		// Ejecución
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString,lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		Nota nota = new Nota(idNota, 1,notaString);
		resultadoObtenido = cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		// Test
		assertTrue(resultadoObtenido);
	}
	
	@Test
	public void testQueNoSePuedaAgregarUnaNotaInvalida() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();
		// Ejecución
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString,lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		Nota nota = new Nota(idNota, 20,notaString);
		resultadoObtenido = cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		// Test
		assertFalse(resultadoObtenido);
	}

	@Test
	public void testQueNoSePuedaAgregarUnTipoDeNotaRepetida() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido,resultado;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		// Ejecución
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString,lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota notaString2 = TipoDeNota.PRIMER_PARCIAL;
		Nota nota = new Nota(idNota, 10,notaString);
		Nota nota2 = new Nota(idNota, 1,notaString2);
		resultado = cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		resultadoObtenido = cursoAlumno.registrarNota(idCurso, idAlumno, nota2);
		// Test
		assertNotEquals(resultado,resultadoObtenido);
	}
	
	@Test
	public void testQueSePuedaAgregarDosTiposDeNotasDistintas() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido,resultado;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		// Ejecución
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString,lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota notaString2 = TipoDeNota.SEGUNDO_PARCIAL;
		Nota nota = new Nota(idNota, 10,notaString);
		Nota nota2 = new Nota(idNota, 1,notaString2);
		resultado = cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		resultadoObtenido = cursoAlumno.registrarNota(idCurso, idAlumno, nota2);
		// Test
		assertEquals(resultado,resultadoObtenido);
	}
	
	@Test
	public void testQueSePuedaAgregarTresTiposDeNotasDistintas() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido,resultado1,resultado2;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		// Ejecución
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString,lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota notaString2 = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota notaString3 = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		Nota nota = new Nota(idNota, 10,notaString);
		Nota nota2 = new Nota(idNota, 1,notaString2);
		Nota nota3 = new Nota(idNota, 1,notaString3);
		resultado1 =cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		resultado2 = cursoAlumno.registrarNota(idCurso, idAlumno, nota2);
		resultadoObtenido = cursoAlumno.registrarNota(idCurso, idAlumno, nota3);
		// Test
		assertTrue(resultado1);
		assertTrue(resultado2);
		assertTrue(resultadoObtenido);
	}
	
	@Test
	public void testQueNoSePuedaAgregarMasDeTresTiposDeNotasDistintas() {
		// Preparación
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido,resultado1,resultado2,resultado3;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		// Ejecución
		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString,lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota notaString2 = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota notaString3 = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		TipoDeNota notaString4 = TipoDeNota.RECUPERATORIO_2DOPARCIAL;
		Nota nota = new Nota(idNota, 10,notaString);
		Nota nota2 = new Nota(idNota, 2,notaString2);
		Nota nota3 = new Nota(idNota, 1,notaString3);
		Nota nota4 = new Nota(idNota, 5,notaString4);
		resultado1 =cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		resultado2 = cursoAlumno.registrarNota(idCurso, idAlumno, nota2);
		resultado3 = cursoAlumno.registrarNota(idCurso, idAlumno, nota3);
		resultadoObtenido = cursoAlumno.registrarNota(idCurso, idAlumno, nota4);
		// Test
		assertTrue(resultado1);
		assertTrue(resultado2);
		assertTrue(resultado3);
		assertFalse(resultadoObtenido);
	}
	
	@Test
	public void testQueSePuedaObtenerUnaNota() {
		// Preparación
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idMateria = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido,resultado1;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		// Ejecución
		Materia materia = new Materia(idMateria, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		Universidad universidad = new Universidad(nombreUniversidad);
		universidad.registrarMateria(materia);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString,lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		Nota nota = new Nota(idNota, 10,notaString);
		resultado1 =cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		resultadoObtenido = cursoAlumno.obtenerNota(idAlumno, idMateria);
		
		// Test
		assertTrue(resultado1);
		assertTrue(resultadoObtenido);
	}
	@Test
	public void testQueNoSePuedaObtenerUnaNota() {
		// Preparación
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idMateria = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido,resultado1;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		// Ejecución
		Materia materia = new Materia(idMateria, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		Universidad universidad = new Universidad(nombreUniversidad);
		universidad.registrarMateria(materia);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString,lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		Nota nota = new Nota(idNota, 20,notaString);
		resultado1 =cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		resultadoObtenido = cursoAlumno.obtenerNota(idAlumno, idMateria);
		
		// Test
		assertFalse(resultado1);
		assertFalse(resultadoObtenido);
	}
	
	@Test
	public void testQueSePuedaObtenerMasDeUnaNota() {
		// Preparación
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idMateria = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoObtenido,resultado1,resultado2,resultado3;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		// Ejecución
		Materia materia = new Materia(idMateria, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		Universidad universidad = new Universidad(nombreUniversidad);
		universidad.registrarMateria(materia);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString,lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota notaString2 = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota notaString3 = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		Nota nota = new Nota(idNota, 10,notaString);
		Nota nota2 = new Nota(idNota, 2,notaString2);
		Nota nota3 = new Nota(idNota, 1,notaString3);
		resultado1 =cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		resultado2 = cursoAlumno.registrarNota(idCurso, idAlumno, nota2);
		resultado3 = cursoAlumno.registrarNota(idCurso, idAlumno, nota3);
		resultadoObtenido = cursoAlumno.obtenerNota(idAlumno, idMateria);
		
		// Test
		assertTrue(resultado1);
		assertTrue(resultado2);
		assertTrue(resultado3);
		assertTrue(resultadoObtenido);
	}
	
	@Test
	public void testQueNoPuedaCursarDosRecuperatorios() {
		// Preparación
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1,idMateria = 1,idNota = 1, DNI = 12345, edad = 20, idAlumno = 1, DNIAlumno = 12345, edadAlumno = 18;
		Boolean resultadoFalse,resultado1,resultado2,resultado3;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		// Ejecución
		Materia materia = new Materia(idMateria, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		Universidad universidad = new Universidad(nombreUniversidad);
		universidad.registrarMateria(materia);
		Turno turnoString = Turno.MAÑANA;
		DiaDeLaSemana lunes = DiaDeLaSemana.LUNES;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString,lunes);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		universidad.inscribirAlumnoACurso(DNIAlumno, idCurso);
		Profesor profesor = new Profesor(id, nombre, apellido, DNI, edad, fechaDeNac, fechaDeIngreso);
		universidad.registrarProfesor(profesor);
		universidad.asignarProfesorAlaComision(idCurso, DNI);
		CursoAlumno cursoAlumno = new CursoAlumno(idCurso,nuevoAlumno,cursoAregistrar);
		TipoDeNota notaString = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota notaString2 = TipoDeNota.SEGUNDO_PARCIAL;
		TipoDeNota notaString3 = TipoDeNota.RECUPERATORIO_1ERPARCIAL;
		TipoDeNota notaString4 = TipoDeNota.RECUPERATORIO_2DOPARCIAL;
		Nota nota = new Nota(idNota, 2,notaString);
		Nota nota2 = new Nota(idNota, 2,notaString2);
		Nota nota3 = new Nota(idNota, 7,notaString3);
		Nota nota4 = new Nota(idNota, 9,notaString4);
		resultado1 =cursoAlumno.registrarNota(idCurso, idAlumno, nota);
		resultado2 = cursoAlumno.registrarNota(idCurso, idAlumno, nota2);
		resultado3 = cursoAlumno.registrarNota(idCurso, idAlumno, nota3);
		resultadoFalse = cursoAlumno.registrarNota(idCurso, idAlumno, nota3);
		
		// Test
		assertTrue(resultado1);
		assertTrue(resultado2);
		assertTrue(resultado3);
		assertFalse(resultadoFalse);
	}
}
