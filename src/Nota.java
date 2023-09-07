public class Nota {
	private Integer parcial1;
	private Integer parcial2;
	private Integer recuperatorio1;
	private Integer recuperatorio2;
	
	public Nota(Integer parcial1, Integer parcial2, Integer recuperatorio1, Integer recuperatorio2) {
		super();
		this.parcial1 = parcial1;
		this.parcial2 = parcial2;
		this.recuperatorio1 = recuperatorio1;
		this.recuperatorio2 = recuperatorio2;
	}
	public Integer getParcial1() {
		return parcial1;
	}
	public void setParcial1(Integer parcial1) {
		this.parcial1 = parcial1;
	}
	public Integer getParcial2() {
		return parcial2;
	}
	public void setParcial2(Integer parcial2) {
		this.parcial2 = parcial2;
	}
	public Integer getRecuperatorio1() {
		return recuperatorio1;
	}
	public void setRecuperatorio1(Integer recuperatorio1) {
		this.recuperatorio1 = recuperatorio1;
	}
	public Integer getRecuperatorio2() {
		return recuperatorio2;
	}
	public void setRecuperatorio2(Integer recuperatorio2) {
		this.recuperatorio2 = recuperatorio2;
	}
}
