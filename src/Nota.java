public class Nota {
	private Integer id;
	private Integer valorNota;
	public Nota(Integer id, Integer valorNota) {
		super();
		this.id = id;
		this.valorNota = valorNota;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getValorNota() {
		return valorNota;
	}
	public void setValorNota(Integer valorNota) {
		this.valorNota = valorNota;
	}
	
	
}
