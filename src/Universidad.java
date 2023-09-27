import java.nio.file.DirectoryStream.Filter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Universidad {
	private static List<Alumno> listaDeAlumno;
	private List<Profesor> listaDeProfesor;
	private static List<Curso> listaDeCurso;
	private List<CursoAlumno> listaDeCursoAlumnos;
	private List<CursoProfesor> listaDeCursoProfesor;
	private static List<Materia> listaDeMaterias;
	private List<Aula> listaDeAulas;
	private List<CicloLectivo> listaDeCiclosLectivos;
	private String nombreDeUniversidad;
	private Map<Integer, Set<Integer>> asignacionesDeProfesores;

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
		asignacionesDeProfesores = new HashMap<>();
	}

	public String getNombreDeUniversidad() {
		return nombreDeUniversidad;
	}

	public void setNombreDeUniversidad(String nombreDeUniversidad) {
		this.nombreDeUniversidad = nombreDeUniversidad;
	}

	public Boolean registrarAlumno(Alumno alumnoNuevo) {
		// validar que el alumno no exista
		for (Alumno alumnoExistente : listaDeAlumno) {
			if (alumnoExistente.getDNI().equals(alumnoNuevo.getDNI())) {
				// el alumno ya existe, no se puede agregar nuevamente
				return false;
			}
		}
		// el alumno no existe y lo agregamos a la lista
		listaDeAlumno.add(alumnoNuevo);
		return true;
	}

	public static Alumno buscarAlumno(Integer idAlumno) {
		Alumno alumnoEncontrado = null;
		for (Alumno alumnoExistente : listaDeAlumno) {
			if (alumnoExistente.getId().equals(idAlumno)) {
				alumnoEncontrado = alumnoExistente;
			}
		}
		return alumnoEncontrado;
	}

	private static boolean existeAlumno(Integer dniAlumno) {
		for (Alumno alumno : listaDeAlumno) {
			if (alumno.getDNI().equals(dniAlumno))
				return true;
		}
		return false;
	}

	public Boolean registrarProfesor(Profesor profesorNuevo) {
		// validar que el profesor no exista
		for (Profesor profesorExistente : listaDeProfesor) {
			if (profesorExistente.getDNI().equals(profesorNuevo.getDNI())) {
				// el profesor ya existe, no se puede agregar nuevamente
				return false;
			}
		}
		// el profesor no existe y lo agregamos a la lista
		listaDeProfesor.add(profesorNuevo);
		return true;
	}

	private Profesor buscarProfesor(Integer dniProfesor) {
		for (Profesor profesorExistente : listaDeProfesor) {
			if (profesorExistente.getDNI().equals(dniProfesor)) {
				return profesorExistente;
			}
		}
		return null;
	}

	public Boolean asignarProfesorAlaComision(Integer idCurso, Integer dniProfesor) {
		Curso curso = buscarCurso(idCurso);
		Profesor profesor = buscarProfesor(dniProfesor);

		if (curso != null && profesor != null) {
			// Verificar si el profesor ya está asignado a este curso
			if (yaEstaAsignado(idCurso, dniProfesor)) {
				return false; // El profesor ya está asignado a este curso
			}

			Integer cantidadAlumnos = curso.getCantidadDeAlumnosInscriptos();
			Integer profesoresNecesarios = (cantidadAlumnos / 20 + 1);

			if (cursoProfesores(curso) < profesoresNecesarios) {
				// Agregar al profesor al conjunto de profesores asignados al curso
				asignarProfesor(idCurso, dniProfesor);
				return true;
			}
		}
		return false;
	}

	private void asignarProfesor(Integer idCurso, Integer dniProfesor) {
		asignacionesDeProfesores.computeIfAbsent(idCurso, k -> new HashSet<>()).add(dniProfesor);
	}

	private boolean yaEstaAsignado(Integer idCurso, Integer dniProfesor) {
		Set<Integer> profesoresAsignados = asignacionesDeProfesores.get(idCurso);
		return profesoresAsignados != null && profesoresAsignados.contains(dniProfesor);
	}

	private int cursoProfesores(Curso curso) {
		int contador = 0;
		for (CursoProfesor cursoProfesor : listaDeCursoProfesor) {
			if (cursoProfesor.getCursoAsignado().equals(curso)) {
				contador++;
			}
		}
		return contador;
	}

	/// metodos de materia
	public Boolean registrarMateria(Materia materiaARegistrar) {
		/// si la materia a registrar es nulo no la podemos registrar
		if (materiaARegistrar == null) {
			return false;
		}
		/// si ya existe la materia entonces no podemos registrar materia
		if (existeMateria(materiaARegistrar.getId())) {
			return false;
		}
		listaDeMaterias.add(materiaARegistrar);
		return true;
	}

	public static Materia buscarMateria(Integer idMateria) {
		Materia materiaEncontrada = null;

		for (Materia materiaExistente : listaDeMaterias) {
			if (materiaExistente.getId() == idMateria) {
				materiaEncontrada = materiaExistente;
			}
		}
		return materiaEncontrada;
	}

	private static Boolean existeMateria(Integer idMateriaAComparar) {
		for (Materia materiaExistente : listaDeMaterias) {
			if (materiaExistente.getId() == idMateriaAComparar) {
				return true;
			}
		}
		return false;
	}

	/// metodos para curso
	public boolean registrarCurso(Curso cursoARegistrar) {
		// Verificar si el curso a registrar es nulo
		if (cursoARegistrar == null) {
			return false;
		}

		// Verificar si ya existe un curso con el mismo ID
		if (existeCurso(cursoARegistrar.getId())) {
			return false;
		}

		// Verificar si el ciclo lectivo del curso existe en la universidad
		if (!existeCicloLectivo(cursoARegistrar.getCicloLectivo())) {
			return false;
		}

		// Realizar cualquier verificación adicional del curso
		if (!verificarCurso(cursoARegistrar)) {
			return false;
		}

		// Si todas las verificaciones pasan, registrar el curso
		listaDeCurso.add(cursoARegistrar);
		return true;
	}

	private Boolean verificarCurso(Curso cursoARegistrar) {
		/// verificar que la comision no este la misma materia, cicloLectivo y el mismo
		/// turno
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

	public static Curso buscarCurso(Integer idCursoABuscar) {
		Curso cursoEncontrado = null;
		for (Curso cursoExistente : listaDeCurso) {
			if (cursoExistente.getId() == idCursoABuscar) {
				cursoEncontrado = cursoExistente;
			}
		}
		return cursoEncontrado;
	}

	//// metodos de ciclo lectivo
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

	/// metodos para correlatividad
	public Boolean agregarCorrelativa(Integer idMateria, Integer idCorrelativa) {

		Materia materiaEncontrada = buscarMateria(idMateria);
		Materia materiaCorrelativaEncotrada = buscarMateria(idCorrelativa);

		if (materiaCorrelativaEncotrada != null && materiaEncontrada != null) {
			materiaEncontrada.agregarCorrelativa(idCorrelativa);
			return true;
		}

		return false;
	}

	public Boolean eliminarCorrelatividad(Integer idMateria, Integer idCorrelatividad) {
		/// verificamos si existe la materia y la materia correlativa si alguna de las
		/// dos no existe cagamos
		if (!existeMateria(idMateria) || !existeMateria(idCorrelatividad))
			return false;

		Materia materiaEncontrada = buscarMateria(idMateria);

		materiaEncontrada.sacarCorrelativa(idCorrelatividad);

		return true;
	}

	/// metodo para obtener las materias que tiene aprobadas
	public static List<Materia> obtenerMateriasAprobadasDeUnAlumno(Integer dniAlumno) {
		List<Materia> listaDeMateriasAprobadas = new ArrayList<>();
		/// traer los cursos que cursa el alumno
		/// verificar que las notas de esos cursos sean mayor o igual a 7
		List<CursoAlumno> cursosDelAlumno = buscarCursosDelAlumno(dniAlumno);

		for (CursoAlumno cursoAlumno : cursosDelAlumno) {
			if (cursoAlumno.estaAprobado()) {
				listaDeMateriasAprobadas.add(cursoAlumno.getCursoDelAlumno().getMateria());
			}
		}
		return listaDeMateriasAprobadas;
	}

	private static List<CursoAlumno> buscarCursosDelAlumno(Integer dniAlumno) {
		// TODO Auto-generated method stub

		List<CursoAlumno> cursosDelAlumnos = new ArrayList<>();

		for (CursoAlumno cursoAlumno : cursosDelAlumnos) {
			if (cursoAlumno.getAlumno().getDNI() == dniAlumno) {
				cursosDelAlumnos.add(cursoAlumno);
			}
		}
		return cursosDelAlumnos;
	}
	/// asiganar aula a la comision

	public Boolean asignarAulaALaComision(Integer idCurso, Integer idAula) {

		if (!existeCurso(idCurso))
			return false;
		if (!existeAula(idAula))
			return false;

		Curso cursoAAsignarAula = buscarCurso(idCurso);
		Aula aulaAAsignarACurso = buscarAula(idAula);
		cursoAAsignarAula.setAula(aulaAAsignarACurso);

		return true;

	}

	private Aula buscarAula(Integer idAula) {
		for (Aula aulaExistente : listaDeAulas) {
			if (aulaExistente.getId() == idAula)
				return aulaExistente;
		}
		return null;
	}

	public Boolean existeAula(Integer idAula) {
		for (Aula aulaExistente : listaDeAulas) {
			if (aulaExistente.getId() == idAula)
				return true;
		}
		return false;
	}

	public Boolean registrarAula(Aula aulaARegistrar) {
		if (existeAula(aulaARegistrar.getId()))
			return false;
		listaDeAulas.add(aulaARegistrar);
		return true;
	}

	public Boolean inscribirAlumnoACurso(Integer dniAlumno, Integer idCurso) {
		// Verificar que el alumno y la comisión estén dados de alta
		if (!existeCurso(idCurso) || !existeAlumno(dniAlumno)) {
			return false;
		}
		// No se puede inscribir Alumnos si este no tiene aprobadas todas las
		// correlativas. Se aprueba con 4 o más.
		if (!verificarQueLasCorrelativasEstenAprobadas(idCurso, dniAlumno)) {
			return false;
		}
		Curso cursoAInscribir = buscarCurso(idCurso);
		// La inscripción no se puede realizar si esta fuera de fecha Inscripción
		if (!verificarQueNoEsteFueraDeLaFechaDeInscripcion(cursoAInscribir.getCicloLectivo())) {
			return false;
		}
		// No se puede inscribir el alumno si excede la cantidad de alumnos permitidos
		// en el aula
		if (!verificarQueHayaLugarEnElAulaParaInscribirAlumno(cursoAInscribir.getAula(),
				cursoAInscribir.getCantidadDeAlumnosInscriptos())) {
			return false;
		}
		// No se puede inscribir el Alumno si ya está inscripto a otra comisión el mismo
		// día y Turno
		if (!verificarQueElAlumnoNoEsteIscriptoAOtroCursoElMismoDiaYTurno(cursoAInscribir, dniAlumno)) {
			return false;
		}
		// No se puede inscribir a una materia que haya aprobado previamente
		if (!verificarQueNoHayaAprobadoLaMateriaAnteriormente(cursoAInscribir, dniAlumno)) {
			return false;
		}
		// Verificar si el alumno ya está inscrito en el curso
		for (CursoAlumno cursoExistente : listaDeCursoAlumnos) {
			if (cursoExistente.getCursoDelAlumno().getId().equals(idCurso)) {
				System.out.println("Curso repetido");
				return false;
			}
		}
		// Si ha pasado todas las verificaciones, inscribir al alumno
		CursoAlumno cursoAlumno = new CursoAlumno(generarIdAleatorio(), buscarAlumno(dniAlumno), cursoAInscribir);
		listaDeCursoAlumnos.add(cursoAlumno);
		cursoAInscribir.aumentarCantidadDeAlumnosInscriptos();
		System.out.println("Inscripto");
		return true;
	}

	private boolean verificarQueNoHayaAprobadoLaMateriaAnteriormente(Curso cursoAInscribir,Integer dniAlumno) {
		// TODO Auto-generated method stub
		List<Materia> materiasAprobadPorElAlumno = obtenerMateriasAprobadasDeUnAlumno(dniAlumno);
		
		for(Materia materiasAprobada: materiasAprobadPorElAlumno) {
			if(cursoAInscribir.getMateria().equals(materiasAprobada))
				return false;
		}
		return true;
	}

	private boolean verificarQueElAlumnoNoEsteIscriptoAOtroCursoElMismoDiaYTurno(Curso cursoAInscribir,Integer dniAlumno) {
		///buscamos los cursos que estan inscriptos el alumno
		List<CursoAlumno> cursosDelAlumno = buscarCursosDelAlumno(dniAlumno);
		
		for(CursoAlumno cursosDeAlumno: cursosDelAlumno) {
			if(verificarSiSonDelMismoCicloLectivoDiaYTurno(cursosDeAlumno.getCursoDelAlumno(),cursoAInscribir))
				return false;
		}
		
		return true;
	}

	private boolean verificarSiSonDelMismoCicloLectivoDiaYTurno(Curso cursosDelAlumno, Curso cursoAInscribir) {
		
		if(cursosDelAlumno.getCicloLectivo().compararCicloLectivo(cursoAInscribir.getCicloLectivo()))
			if(cursosDelAlumno.getDiaDeCursada().equals(cursoAInscribir.getDiaDeCursada()))
				if(cursosDelAlumno.getTurno().equals(cursoAInscribir.getTurno()))
					return true;
		return false;
	}

	private boolean verificarQueHayaLugarEnElAulaParaInscribirAlumno(Aula aula,Integer cantidadAlumnosInscriptos) {
		if(aula.getCantDeAlumnosPermitidos() > cantidadAlumnosInscriptos)
			return true;
		
		return false;
	}

	private boolean verificarQueNoEsteFueraDeLaFechaDeInscripcion(CicloLectivo cicloLectivo) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate hoy = LocalDate.parse(LocalDate.now().toString(), formatter);
		
		if(cicloLectivo.estaEnFechaDeIncripcion(hoy))
			return true;
		return false;
	}

	public static Boolean verificarQueLasCorrelativasEstenAprobadas(Integer idCurso,Integer dniAlumno) {
		
		List<Materia> materiaCorrelativas = new ArrayList<>();
		List<Materia> materiasCursadas = obtenerMateriasCursadasPorUnAlumno(dniAlumno);
		Curso cursoAInscribir = buscarCurso(idCurso);
		List<Integer> idMateriaCorrelativas =  cursoAInscribir.getMateria().getCorrelativas();
		
		for (Integer idMateriasCorrelativa : idMateriaCorrelativas) {
			Materia materiaEncontrada = buscarMateria(idMateriasCorrelativa);
			if(materiaEncontrada != null)
				materiaCorrelativas.add(materiaEncontrada);
		}
		
		return materiasCursadas.containsAll(materiaCorrelativas);
	}

	private static List<Materia> obtenerMateriasCursadasPorUnAlumno(Integer dniAlumno) {
		List<Materia> listaDeMateriasAprobadas = new ArrayList<>();
		///traer los cursos que cursa el alumno 
		///verificar que las notas de esos cursos sean mayor o igual a 4
		List<CursoAlumno> cursosDelAlumno = buscarCursosDelAlumno(dniAlumno); 
		
		for (CursoAlumno cursoAlumno : cursosDelAlumno) {
			if(cursoAlumno.estaCursado() || cursoAlumno.estaAprobado()) {
				listaDeMateriasAprobadas.add(cursoAlumno.getCursoDelAlumno().getMateria());
			}
		}
		
		return listaDeMateriasAprobadas;
		
	}
	
	//// lista de materias es el plan de estudios 
	public List<Materia> obtenerMateriasQueFaltanCursarDeUnAlumno(Integer dniAlumno) {
		
		if(!existeAlumno(dniAlumno))
			return null;
		
		List<Materia> materiasAprobadasDelAlumno = obtenerMateriasAprobadasDeUnAlumno(dniAlumno);
		List<Materia> materiasQueFaltanCursarDeUnAlumno = listaDeMaterias;
		
		materiasQueFaltanCursarDeUnAlumno.removeAll(materiasAprobadasDelAlumno);
		
		
		return materiasQueFaltanCursarDeUnAlumno;
	}

	// en esta funcion hay que calcular el promedio final en base a todos los cursos
	public Double obtenerPromedio(Integer idAlumno) {
		Alumno alumno = buscarAlumno(idAlumno);
		if (alumno != null) {
			if (!listaDeCursoAlumnos.isEmpty()) {
				Double nota = 0.0;
				Double notaFinal;
				for (CursoAlumno curso : listaDeCursoAlumnos) {

					notaFinal = curso.calcularNotaFinal();
					if (notaFinal != null) {
						nota += notaFinal;
					}
				}
				// Calcular el promedio como el promedio de todas las notas
				Double promedio = nota / listaDeCursoAlumnos.size();
				return promedio;
			}
		}
		return null;
	}

	public static Integer generarIdAleatorio() {
		// Crear una instancia de Random
		Random rand = new Random();
		// Generar un número aleatorio en el rango de 1 a 100000 (incluyendo 1 y 100)
		Integer idAleatorio = rand.nextInt(100000) + 1;
		return idAleatorio;
	}
}
