public class Aula {
	private Integer id;
	private Integer cantDeAlumnosPermitidos;
	public Aula(Integer id, Integer cantDeAlumnosPermitidos) {
		super();
		this.id = id;
		this.cantDeAlumnosPermitidos = cantDeAlumnosPermitidos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCantDeAlumnosPermitidos() {
		return cantDeAlumnosPermitidos;
	}
	public void setCantDeAlumnosPermitidos(Integer cantDeAlumnosPermitidos) {
		this.cantDeAlumnosPermitidos = cantDeAlumnosPermitidos;
	}
}