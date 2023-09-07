public class CursoProfesor {
	private Profesor profesor;
	private Nota nota;
	private Materia materia;
	
	public CursoProfesor(Profesor profesor, Nota nota, Materia materia) {
		this.profesor = profesor;
		this.nota = nota;
		this.materia = materia;
	}

	public Profesor getAlumno() {
		return profesor;
	}

	public void setAlumno(Profesor profesor) {
		this.profesor = profesor;
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