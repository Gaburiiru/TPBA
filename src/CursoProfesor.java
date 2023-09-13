public class CursoProfesor {
	private Integer id;
	private Profesor profesor;
	private Materia materia;
	
	public CursoProfesor(Integer id,Profesor profesor, Nota nota, Materia materia) {
		this.profesor = profesor;
		this.id = id;
		this.materia = materia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Profesor getAlumno() {
		return profesor;
	}

	public void setAlumno(Profesor profesor) {
		this.profesor = profesor;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}