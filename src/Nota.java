public class Nota {
	private Integer id;
	private Integer valorNota;
	private TipoDeNota tipoDeNota;
	
	public TipoDeNota getTipoDeNota() {
		return tipoDeNota;
	}


	public void setTipoDeNota(TipoDeNota tipoDeNota) {
		this.tipoDeNota = tipoDeNota;
	}


	public Nota(Integer id, Integer valorNota,TipoDeNota tipoDeNota) {
		super();
		this.id = id;
		this.valorNota = valorNota;
		this.tipoDeNota = tipoDeNota;
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
