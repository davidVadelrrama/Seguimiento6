package model;

public class Cartel {
	
	private int ancho;
	private int alto;
	private boolean  enUso;
	private String marca;
	
	
	//constructor
	public Cartel(int ancho, int alto, boolean enUso, String marca) {
		this.ancho = ancho;
		this.alto = alto;
		this.enUso = enUso;
		this.marca = marca;
	}
	
	
	
	
	//getters & setters
	public int getAncho() {
		return ancho;
	}
	
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public boolean isEnUso() {
		return enUso;
	}
	public void setEnUso(boolean enUso) {
		this.enUso = enUso;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}




	@Override
	public String toString() {
		return "W" + "H" + "in use"+ "brand" +"\n"+
				ancho +  alto  + enUso  + marca;
	}
	
	
	
	
	

}
