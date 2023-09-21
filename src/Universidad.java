import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
	private List<Alumno> listaDeAlumno;
	private List<Profesor> listaDeProfesor;
	private List<Curso> listaDeCurso;
	private List<CursoAlumno> listaDeCursoAlumnos;
	private List<CursoProfesor> listaDeCursoProfesor;
	private List<Materia> listaDeMaterias;
	private List<Aula> listaDeAulas;
	private List<CicloLectivo> listaDeCiclosLectivos;
	private String nombreDeUniversidad;

	public Universidad(String nombreDeUniversidad) {
		super();

		this.listaDeAlumno = new ArrayList<>();
		this.listaDeProfesor = new ArrayList<>();
		this.listaDeCurso = new ArrayList<>();
		this.listaDeCursoAlumnos = new ArrayList<>();
		this.listaDeCursoProfesor = new ArrayList<>();
		this.listaDeMaterias = new ArrayList<>();
		this.listaDeAulas = new ArrayList<>();
		this.listaDeCiclosLectivos = new ArrayList<>();
		this.nombreDeUniversidad = nombreDeUniversidad;
	}

	public Boolean registrarAlumno(Alumno alumnoNuevo) {
		// validar que el alumno no exista
		for (Alumno alumnoExistente : listaDeAlumno) {
			if (alumnoExistente.getDNI() == alumnoNuevo.getDNI()) {
				// el alumno ya existe, no se puede agregar nuevamente
				return false;
			}
		}
		// el alumno no existe y lo agregamos a la lista
		listaDeAlumno.add(alumnoNuevo);
		return true;
	}

	public Boolean registrarProfesor(Profesor profesorNuevo) {
		// validar que el profesor no exista
		for (Profesor profesorExistente : listaDeProfesor) {
			if (profesorExistente.getId() == profesorNuevo.getId()) {
				// el profesor ya existe, no se puede agregar nuevamente
				return false;
			}
		}
		// el profesor no existe y lo agregamos a la lista
		listaDeProfesor.add(profesorNuevo);
		return true;
	}

	public Boolean registrarMateria(Materia materiaARegistrar) {

		if (materiaARegistrar == null) {
			return false;
		}

		for (Materia materiaExistente : listaDeMaterias) {
			if (materiaExistente.getId() == materiaARegistrar.getId()) {
				return false;
			}
		}
		listaDeMaterias.add(materiaARegistrar);
		return true;
	}

	public Boolean registrarCurso(Curso cursoARegistrar) {

		/// verificar que la comision no este la misma materia, cicloLectivo y el mismo
		/// turno

		if (cursoARegistrar == null)
			return false;
		/// me falta validar que el aula y el turno no sean el mismo
		for (Curso cursoExistente : listaDeCurso) {

			if (cursoExistente.getId() == cursoARegistrar.getId())
				return false;

			if (cursoExistente.getMateria().getId() == cursoARegistrar.getMateria().getId()) {
				if (existeCicloLectivo(cursoARegistrar.getCicloLectivo())) {
					if (cursoExistente.getCicloLectivo().compararCicloLectivo(cursoARegistrar.getCicloLectivo())) {
						if (cursoExistente.getTurno().equals(cursoARegistrar.getTurno()))
							return false;
					}
				}
			}

		}
		listaDeCurso.add(cursoARegistrar);
		return true;
	}
	
	private Curso buscarCurso(Integer idCursoABuscar) {
		Curso cursoEncontrado=null;
		for (Curso cursoExistente : listaDeCurso) {
			if(cursoExistente.getId() == idCursoABuscar) {
				cursoEncontrado = cursoExistente;
			}
		}
		return cursoEncontrado;
	}

	private Boolean existeCicloLectivo(CicloLectivo cicloLectivoAComporar) {

		for (CicloLectivo cicloExistente : listaDeCiclosLectivos) {
			if (cicloExistente.compararCicloLectivo(cicloLectivoAComporar))
				return true;
		}
		return false;
	}

	public Boolean agregarCorrelativa(Integer idMateria, Integer idCorrelativa) {

		Materia materiaEncontrada = buscarMateria(idMateria);
		Materia materiaCorrelativaEncotrada = buscarMateria(idCorrelativa);

		if (materiaCorrelativaEncotrada != null && materiaEncontrada != null) {
			materiaEncontrada.setCorrelativa(idCorrelativa);
			return true;
		}

		return false;

	}

	public Materia buscarMateria(Integer idMateria) {

		Materia materiaEncontrada = null;

		for (Materia materiaExistente : listaDeMaterias) {
			if (materiaExistente.getId() == idMateria) {
				materiaEncontrada = materiaExistente;
			}
		}
		return materiaEncontrada;
	}

	public Boolean agregarCicloLectivo(CicloLectivo cicloLectivoAAgregar) {
		for (CicloLectivo cicloExistente : listaDeCiclosLectivos) {
			if (cicloExistente.compararCicloLectivo(cicloLectivoAAgregar)) {
				return false;
			}
		}
		listaDeCiclosLectivos.add(cicloLectivoAAgregar);
		return true;
	}
}
