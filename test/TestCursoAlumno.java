import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestCursoAlumno {

	@Test
	public void testearLasMateriasAprobadasPorUnAlumno() {
		///lista de materias aprobadas hardcodeada
		Materia materia1 = new Materia(1, "Pb1");
		Integer dniAlumno = 43105267;
		Alumno alumno1 = new Alumno(2, "emir", "masi", dniAlumno, null, null, null);
		
		
		Curso curso1 = new Curso(1,materia1,null,null,null);
		Universidad unlam = new Universidad("unlam");
		unlam.registrarAlumno(alumno1);
		unlam.registrarMateria(materia1);
		unlam.registrarCurso(curso1);
		///necesito registrarNota para hacer este test
		
		List<Materia> materiasAprobadasEsperadasList = new ArrayList<>();
		materiasAprobadasEsperadasList.add(materia1);
		List<Materia> materiasAprobadas = unlam.obtenerMateriasAprobadasDeUnAlumno(dniAlumno);
		
		for (Materia materia : materiasAprobadas) {
			assertFalse(materiasAprobadasEsperadasList.contains(materia));
		}
	}
	
	@Test
	public void testAsignarAlumnoACurso() {
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, edad = 20, idAlumno = 1, DNIAlumno = 7575, edadAlumno = 18;
		Boolean resultadoObtenido;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		resultadoObtenido = universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		assertTrue(resultadoObtenido);
	}
	@Test
	public void testAsignarAlumnoRepetidoACurso() {
		Materia materia = new Materia(1, "PB2");
		Aula aulaDeCurso = new Aula(1, 50);
		String nombreUniversidad = "UNLAM", nombre = "rodolfo", apellido = "perez", nombreAlumno = "juan",
				apellidoAlumno = "pepe";
		Integer id = 1, idCurso = 1, edad = 20, idAlumno = 1, DNIAlumno = 7575, edadAlumno = 18;
		Boolean resultadoObtenido,resultado;
		LocalDate fechaDeNac = LocalDate.of(1999, 11, 01), fechaDeIngreso = LocalDate.of(2021, 03, 1),
				fechaDeNacAlumno = LocalDate.of(1999, 11, 01), fechaDeIngresoAlumno = LocalDate.of(2021, 03, 1),
				fechaInicioCurso = LocalDate.of(2023, 03, 27), fechaFinCurso = LocalDate.of(2023, 07, 14),
				fechaInicioInscripcion = LocalDate.now(), fechaFinInscripcion = LocalDate.now();

		Universidad universidad = new Universidad(nombreUniversidad);
		Turno turnoString = Turno.MAÑANA;
		CicloLectivo cicloLectivo = new CicloLectivo(1, fechaInicioCurso, fechaFinCurso, fechaInicioInscripcion,
				fechaFinInscripcion);
		universidad.agregarCicloLectivo(cicloLectivo);
		Curso cursoAregistrar = new Curso(idCurso, materia, aulaDeCurso, cicloLectivo, turnoString);
		universidad.registrarCurso(cursoAregistrar);
		Alumno nuevoAlumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, DNIAlumno, edadAlumno, fechaDeNacAlumno,
				fechaDeIngresoAlumno);
		universidad.registrarAlumno(nuevoAlumno);
		resultadoObtenido = universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		resultado = universidad.incribirAlumnoACurso(DNIAlumno, idCurso);
		System.out.println(resultadoObtenido +" "+ resultado );
		assertNotEquals(resultadoObtenido, resultado);
	}
}
