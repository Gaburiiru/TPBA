public class Materia {
	private String nombreMateria;
	private Integer codMateria;
	
	public Materia(String nombreMateria, Integer codMateria) {
		super();
		this.nombreMateria = nombreMateria;
		this.codMateria = codMateria;
	}
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	public Integer getCodMateria() {
		return codMateria;
	}
	public void setCodMateria(Integer codMateria) {
		this.codMateria = codMateria;
	}
}
