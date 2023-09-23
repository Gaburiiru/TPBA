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
			if (profesorExistente.getDNI() == profesorNuevo.getDNI()) {
				// el profesor ya existe, no se puede agregar nuevamente
				return false;
			}
		}
		// el profesor no existe y lo agregamos a la lista
		listaDeProfesor.add(profesorNuevo);
		return true;
	}
	
	
	///metodos de materia
	public Boolean registrarMateria(Materia materiaARegistrar) {
		///si la materia a registrar es nulo no la podemos registrar
		if (materiaARegistrar == null) 
			return false;
		///si ya existe la materia entonces no podemos registrar materia 
		if(existeMateria(materiaARegistrar.getId()))
			return false;
		
		listaDeMaterias.add(materiaARegistrar);
		return true;
	}
	private Materia buscarMateria(Integer idMateria) {

		Materia materiaEncontrada = null;

		for (Materia materiaExistente : listaDeMaterias) {
			if (materiaExistente.getId() == idMateria) {
				materiaEncontrada = materiaExistente;
			}
		}
		return materiaEncontrada;
	}
	
	private Boolean existeMateria(Integer idMateriaAComparar) {
		for (Materia materiaExistente : listaDeMaterias) {
			if (materiaExistente.getId() == idMateriaAComparar) {
				return true;
			}
		}
		return false;
	}
	///metodos para curso
	public Boolean registrarCurso(Curso cursoARegistrar) {
		///si el curso a registrar es null retorna falso
		if (cursoARegistrar == null)
			return false;
		///si ya existe el curso no se puede registrar
		if (existeCurso(cursoARegistrar.getId()))
			return false;
		///si no existe el ciclo lectivo en la lista de ciclo lectivos entonces no podemos registrar el curso
		if (!existeCicloLectivo(cursoARegistrar.getCicloLectivo()))
			return false;
		
		if (!verificarCurso(cursoARegistrar))
			return false;

		listaDeCurso.add(cursoARegistrar);
		return true;
	}

	private Boolean verificarCurso(Curso cursoARegistrar) {
		/// verificar que la comision no este la misma materia, cicloLectivo y el mismo turno
		for (Curso cursoExistente : listaDeCurso) {
			if (cursoExistente.getMateria().getId() == cursoARegistrar.getMateria().getId()) {
				if (cursoExistente.getCicloLectivo().compararCicloLectivo(cursoARegistrar.getCicloLectivo())) {
					if (cursoExistente.getTurno().equals(cursoARegistrar.getTurno()))
						return false;

				}
			}
		}

		return true;
	}

	private Boolean existeCurso(Integer idCurso) {
		for (Curso cursoExistente : listaDeCurso) {
			if (cursoExistente.getId() == idCurso)
				return true;
		}
		return false;
	}

	private Curso buscarCurso(Integer idCursoABuscar) {
		Curso cursoEncontrado = null;
		for (Curso cursoExistente : listaDeCurso) {
			if (cursoExistente.getId() == idCursoABuscar) {
				cursoEncontrado = cursoExistente;
			}
		}
		return cursoEncontrado;
	}
	
	////metodos de ciclo lectivo
	public Boolean agregarCicloLectivo(CicloLectivo cicloLectivoAAgregar) {
		for (CicloLectivo cicloExistente : listaDeCiclosLectivos) {
			if (cicloExistente.compararCicloLectivo(cicloLectivoAAgregar)) {
				return false;
			}
		}
		listaDeCiclosLectivos.add(cicloLectivoAAgregar);
		return true;
	}
	
	private Boolean existeCicloLectivo(CicloLectivo cicloLectivoAComporar) {

		for (CicloLectivo cicloExistente : listaDeCiclosLectivos) {
			if (cicloExistente.compararCicloLectivo(cicloLectivoAComporar))
				return true;
		}
		return false;
	}
	
	///metodos para correlatividad
	public Boolean agregarCorrelativa(Integer idMateria, Integer idCorrelativa) {

		Materia materiaEncontrada = buscarMateria(idMateria);
		Materia materiaCorrelativaEncotrada = buscarMateria(idCorrelativa);

		if (materiaCorrelativaEncotrada != null && materiaEncontrada != null) {
			materiaEncontrada.agregarCorrelativa(idCorrelativa);
			return true;
		}

		return false;
	}
	
	public Boolean eliminarCorrelatividad(Integer idMateria,Integer idCorrelatividad) {
		///verificamos si existe la materia y la materia correlativa si alguna de las dos no existe cagamos
		if(!existeMateria(idMateria) || !existeMateria(idCorrelatividad))
			return false;
		
		Materia materiaEncontrada = buscarMateria(idMateria);
		
		materiaEncontrada.sacarCorrelativa(idCorrelatividad);
		
		return true;
	}
	
	///metodo para obtener las materias que tiene aprobadas 
	
	public List<Materia> obtenerMateriasAprobadasDeUnAlumno(Integer idAlumno){
		List<Materia> listaDeMateriasAprobadas = new ArrayList<>();
		///traer los cursos que cursa el alumno 
		///verificar que las notas de esos cursos sean mayor o igual a 7
		List<CursoAlumno> cursosDelAlumno = buscarCursosDelAlumno(idAlumno); 
		
		for (CursoAlumno cursoAlumno : cursosDelAlumno) {
			if(cursoAlumno.estaAprobado()) {
				listaDeMateriasAprobadas.add(cursoAlumno.getMateria());
			}
		}
		
		return listaDeMateriasAprobadas;
	}

	private List<CursoAlumno> buscarCursosDelAlumno(Integer idAlumno) {
		// TODO Auto-generated method stub
		
		List<CursoAlumno> cursosDelAlumnos = new ArrayList<>();
		
		for (CursoAlumno cursoAlumno : cursosDelAlumnos) {
			if(cursoAlumno.getAlumno().getId() == idAlumno) {
				cursosDelAlumnos.add(cursoAlumno);
			}
		}
		return cursosDelAlumnos;
	}
	
}
