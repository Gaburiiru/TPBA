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
	private String nombreDeUniversidad;
	
	public Universidad(String nombreDeUniversidad) {
		super();
		
		this.listaDeAlumno = new ArrayList<>();
		this.listaDeProfesor = new ArrayList<>();
		this.listaDeCurso = new ArrayList<>() ;
		this.listaDeCursoAlumnos = new ArrayList<>();
		this.listaDeCursoProfesor = new ArrayList<>();
		this.listaDeMaterias = new ArrayList<>();
		this.listaDeAulas = new ArrayList<>();
		
		this.nombreDeUniversidad = nombreDeUniversidad;
	}

	public Boolean registrarAlumno(Alumno alumnoNuevo) {
	    //validar que el alumno no exista
	    for (Alumno alumnoExistente : listaDeAlumno) {
	        if (alumnoExistente.getId() == alumnoNuevo.getId()) {
	            //el alumno ya existe, no se puede agregar nuevamente
	            return false;
	        }
	    }
	    //el alumno no existe y lo agregamos a la lista
	    listaDeAlumno.add(alumnoNuevo);
	    return true;
	}
	
	public Boolean registrarProfesor(Profesor profesorNuevo) {
	    //validar que el profesor no exista
	    for (Profesor profesorExistente : listaDeProfesor) {
	        if (profesorExistente.getId() == profesorNuevo.getId()) {
	            //el profesor ya existe, no se puede agregar nuevamente
	            return false;
	        }
	    }
	    //el profesor no existe y lo agregamos a la lista
	    listaDeProfesor.add(profesorNuevo);
	    return true;
	}
}
