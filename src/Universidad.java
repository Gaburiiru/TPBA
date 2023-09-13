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
		///validar que el alumno no exista
		
		return listaDeAlumno.add(alumnoNuevo);
	}
}
