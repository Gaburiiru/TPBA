public class CicloLectivo {
	private String primerCuatrimestre;
	private String segundoCuatrimestre;
	private String fechaInicio;
	
	public CicloLectivo(String primerCuatrimestre, String segundoCuatrimestre, String fechaInicio) {
		super();
		this.primerCuatrimestre = primerCuatrimestre;
		this.segundoCuatrimestre = segundoCuatrimestre;
		this.fechaInicio = fechaInicio;
	}
	public String getPrimerCuatrimestre() {
		return primerCuatrimestre;
	}
	public void setPrimerCuatrimestre(String primerCuatrimestre) {
		this.primerCuatrimestre = primerCuatrimestre;
	}
	public String getSegundoCuatrimestre() {
		return segundoCuatrimestre;
	}
	public void setSegundoCuatrimestre(String segundoCuatrimestre) {
		this.segundoCuatrimestre = segundoCuatrimestre;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
}
