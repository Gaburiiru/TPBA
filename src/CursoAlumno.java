public class CursoAlumno {
	private Alumno alumno;
	private Nota nota;
	private Materia materia;
	
	public CursoAlumno(Alumno alumno, Nota nota, Materia materia) {
		super();
		this.alumno = alumno;
		this.nota = nota;
		this.materia = materia;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}
