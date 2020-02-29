package model;

public class Telefone {
	
	private int Id;
	private int DDD;
	private String numero;
	private String tipo;

	public Telefone() {}	
	
	public Telefone(int dDD, String numero, String tipo, int userId) {
		super();
		DDD = dDD;
		this.numero = numero;
		this.tipo = tipo;
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	private int userId;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getDDD() {
		return DDD;
	}
	public void setDDD(int dDD) {
		DDD = dDD;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Telefone [Id=" + Id + ", DDD=" + DDD + ", numero=" + numero + ", tipo=" + tipo + ", userId=" + userId
				+ "]";
	}
	
}
