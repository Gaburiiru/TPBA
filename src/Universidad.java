import java.util.List;

public class Universidad {
	private List<Alumno> listaDeAlumno;
	private List<Profesor> listaDeProfesor;
	private List<Curso> listaDeCurso;
	private String nombreDeUniversidad;
	
	public Universidad(List<Alumno> listaDeAlumno, List<Profesor> listaDeProfesor, List<Curso> listaDeCurso,
			String nombreDeUniversidad) {
		super();
		this.listaDeAlumno = listaDeAlumno;
		this.listaDeProfesor = listaDeProfesor;
		this.listaDeCurso = listaDeCurso;
		this.nombreDeUniversidad = nombreDeUniversidad;
	}

	public List<Alumno> getListaDeAlumno() {
		return listaDeAlumno;
	}

	public void setListaDeAlumno(List<Alumno> listaDeAlumno) {
		this.listaDeAlumno = listaDeAlumno;
	}

	public List<Profesor> getListaDeProfesor() {
		return listaDeProfesor;
	}

	public void setListaDeProfesor(List<Profesor> listaDeProfesor) {
		this.listaDeProfesor = listaDeProfesor;
	}

	public List<Curso> getListaDeCurso() {
		return listaDeCurso;
	}

	public void setListaDeCurso(List<Curso> listaDeCurso) {
		this.listaDeCurso = listaDeCurso;
	}

	public String getNombreDeUniversidad() {
		return nombreDeUniversidad;
	}

	public void setNombreDeUniversidad(String nombreDeUniversidad) {
		this.nombreDeUniversidad = nombreDeUniversidad;
	}
}
