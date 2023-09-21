import java.time.LocalDate;

public class CicloLectivo {
	private Integer id;
	private LocalDate fechaInicioCicloLectivo;
	private LocalDate fechaFinCicloLectivo;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion;
	public CicloLectivo(Integer id, LocalDate fechaInicioCicloLectivo, LocalDate fechaFinCicloLectivo,
			LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
		super();
		this.id = id;
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		this.fechaFinCicloLectivo = fechaFinCicloLectivo;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinInscripcion = fechaFinInscripcion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getFechaInicioCicloLectivo() {
		return fechaInicioCicloLectivo;
	}
	public void setFechaInicioCicloLectivo(LocalDate fechaInicioCicloLectivo) {
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
	}
	public LocalDate getFechaFinCicloLectivo() {
		return fechaFinCicloLectivo;
	}
	public void setFechaFinCicloLectivo(LocalDate fechaFinCicloLectivo) {
		this.fechaFinCicloLectivo = fechaFinCicloLectivo;
	}
	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}
	public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}
	public LocalDate getFechaFinInscripcion() {
		return fechaFinInscripcion;
	}
	public void setFechaFinInscripcion(LocalDate fechaFinInscripcion) {
		this.fechaFinInscripcion = fechaFinInscripcion;
	}

	public Boolean compararCicloLectivo( CicloLectivo cicloLectivoAComparar) {
		///si no son iguales nos fijamos que no se superpongan las fechas 
		
		if(this.fechaInicioCicloLectivo.compareTo(cicloLectivoAComparar.getFechaInicioCicloLectivo()) == 0 &&
				this.fechaFinCicloLectivo.compareTo(cicloLectivoAComparar.getFechaFinCicloLectivo()) == 0) {
			return true;
		}
		return false;
	}
	
}
