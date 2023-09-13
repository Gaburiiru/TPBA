import java.util.LinkedList;
import java.util.List;

public class CursoAlumno {
	private Integer id;
	private Alumno alumno;
	private List<Nota> listaDeNotas;///lista de notas que acepte 3 notas.
	private Materia materia;
	
	public CursoAlumno(Alumno alumno, Materia materia) {
		super();
		this.alumno = alumno;
		this.listaDeNotas = new LinkedList<>();
		this.materia = materia;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}
