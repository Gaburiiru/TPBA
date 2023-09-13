public class Materia {
	private Integer id;
	private String nombreMateria;
	
	public Materia(Integer id,String nombreMateria) {
		super();
		this.nombreMateria = nombreMateria;
		this.id = id;
	}
	
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
