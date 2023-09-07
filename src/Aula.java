public class Aula {
	private Integer nroAula;
	private Integer cantDeAlumnosPermitidos;
	
	public Aula(Integer nroAula, Integer cantDeAlumnosPermitidos) {
		super();
		this.nroAula = nroAula;
		this.cantDeAlumnosPermitidos = cantDeAlumnosPermitidos;
	}
	public Integer getNroAula() {
		return nroAula;
	}
	public void setNroAula(Integer nroAula) {
		this.nroAula = nroAula;
	}
	public Integer getCantDeAlumnosPermitidos() {
		return cantDeAlumnosPermitidos;
	}
	public void setCantDeAlumnosPermitidos(Integer cantDeAlumnosPermitidos) {
		this.cantDeAlumnosPermitidos = cantDeAlumnosPermitidos;
	}
	
	
}
