import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Materia {
	private Integer id;
	private String nombreMateria;
	private List<Integer> correlativas;
	
	public Materia(Integer id,String nombreMateria) {
		super();
		this.nombreMateria = nombreMateria;
		this.id = id;
		this.correlativas = new ArrayList<>();
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
	
	public void setCorrelativa(Integer IdMateriaCorrelativa) {
		correlativas.add(IdMateriaCorrelativa);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
}
