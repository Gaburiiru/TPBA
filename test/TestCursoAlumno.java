import static org.junit.Assert.*;

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
		
		
		Curso curso1 = new Curso(1,materia1,null,null,null,null);
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

}
