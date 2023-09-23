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
	
	public List<Integer> getCorrelativas() {
		return correlativas;
	}


	public void setCorrelativa(List<Integer> correlativas) {
		correlativas.addAll(correlativas);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void agregarCorrelativa(Integer idCorrelativa) {
		correlativas.add(idCorrelativa);
	}
	
	public void sacarCorrelativa(Integer idCorrelatividad) {
		// TODO Auto-generated method stub
		correlativas.remove(idCorrelatividad);
	}
	
}
