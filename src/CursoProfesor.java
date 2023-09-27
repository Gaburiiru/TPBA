public class CursoProfesor {
	private Integer id;
	private Profesor profesor;
	private Curso cursoAsignado;
	
	public CursoProfesor(Integer id,Profesor profesor, Curso cursoAsignado) {
		this.profesor = profesor;
		this.id = id;
		this.cursoAsignado = cursoAsignado;
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

	public Curso getCursoAsignado() {
		return cursoAsignado;
	}

	public void setCursoAsignado(Curso cursoAsignado) {
		this.cursoAsignado = cursoAsignado;
	}
}