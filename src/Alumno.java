import java.util.List;

public class Alumno {
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer DNI;
	private Integer edad;
	
	public Alumno(Integer id,String nombre, String apellido, Integer dNI, Integer edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = dNI;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDNI() {
		return DNI;
	}

	public void setDNI(Integer dNI) {
		DNI = dNI;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
}
