public class Curso {
	private Integer codCurso;
	private Materia materia;
	private Aula aula;
	private CicloLectivo cicloLectivo;
	private String horario; 
	private Integer dia;
	
	public Curso(Integer codCurso, Materia materia, Aula aula, CicloLectivo cicloLectivo, String horario, Integer dia) {
		super();
		this.codCurso = codCurso;
		this.materia = materia;
		this.aula = aula;
		this.cicloLectivo = cicloLectivo;
		this.horario = horario;
		this.dia = dia;
	}
	public Integer getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(Integer codCurso) {
		this.codCurso = codCurso;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public Aula getAula() {
		return aula;
	}
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}
	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
}
