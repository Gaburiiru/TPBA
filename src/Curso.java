public class Curso {
	private Integer id;
	private Materia materia;
	private Aula aula;
	private CicloLectivo cicloLectivo;
	private Turno turno;
	private Integer cantidadDeAlumnosInscriptos;
	private DiaDeLaSemana diaDeCursada;
	
	public Curso(Integer id, Materia materia, Aula aula, CicloLectivo cicloLectivo,Turno turno,DiaDeLaSemana diaDeCursada) {
		super();
		this.id = id;
		this.materia = materia;
		this.aula = aula;
		this.cicloLectivo = cicloLectivo;
		this.turno = turno;
		this.diaDeCursada = diaDeCursada;
		this.cantidadDeAlumnosInscriptos = 0;
	}
	
	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getCantidadDeAlumnosInscriptos() {
		return this.cantidadDeAlumnosInscriptos;
	}
	public void setCantidadDeAlumnos(Integer cantDeAlumnos) {
		this.cantidadDeAlumnosInscriptos = cantDeAlumnos;
	}
	public void aumentarCantidadDeAlumnosInscriptos() {
		this.cantidadDeAlumnosInscriptos++;
	}

	public DiaDeLaSemana getDiaDeCursada() {
		return diaDeCursada;
	}

	public void setDiaDeCursada(DiaDeLaSemana diaDeCursada) {
		this.diaDeCursada = diaDeCursada;
	}	
}