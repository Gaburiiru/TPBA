public class CursoProfesor {
	private Integer id;
	private Profesor profesor;
	private Curso curso;
	
	public CursoProfesor(Integer id,Profesor profesor, Curso curso) {
		this.profesor = profesor;
		this.id = id;
		this.curso = curso;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}