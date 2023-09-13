import java.util.List;

public class Alumno {
	private String nombre;
	private String apellido;
	private Integer DNI;
	private Integer edad;
	
	public Alumno(String nombre, String apellido, Integer dNI, Integer edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		DNI = dNI;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
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
	
    public void registrarEnUniversidad(Universidad universidad) {
        if (universidad != null) {
            List<Alumno> listaDeAlumnos = universidad.getListaDeAlumno();
            listaDeAlumnos.add(this);
            universidad.setListaDeAlumno(listaDeAlumnos);
        }
    }
}
