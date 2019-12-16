package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Tile {
	
	//X,Y pintado
	private int x;
	private int y;
	private int xImagen;
	private int yImagen;
	private int altoImagen;
	private int anchoImagen;
	private String indiceImagen;
	private int velocidad;
	private int anchoTile;
	private int altoTile;
	
	
	//Constructor de Atributos Tile
	public Tile(int x, int y, int anchoTile, int altoTile, int xImagen, int yImagen, String indiceImagen, int velocidad) {
		super();
		this.x = x;
		this.y = y;
		this.anchoTile = anchoTile;
		this.altoTile = altoTile;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
		
		this.indiceImagen = indiceImagen;
	}
		

	
	public Tile(int tipoTile, int x, int y, String indiceImagen, int velocidad) {
		
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		
		
		switch(tipoTile) {
		case 1:
			this.altoTile = 70;
			this.anchoTile = 70;
			this.xImagen = 778;
			this.yImagen = 426;
		break;
		case 12:
			this.altoTile = 70;
			this.anchoTile = 70;
			this.xImagen = 70;
			this.yImagen = 497;
		break;
		case 2:
			this.altoTile = 70;
			this.anchoTile = 70;
			this.xImagen = 70;
			this.yImagen = 710;
		break;
		case 3:
			this.altoTile = 70;
			this.anchoTile = 70;
			this.xImagen = 70;
			this.yImagen = 568;
		break; 
		case 4:
			this.altoTile = 70;
			this.anchoTile = 70;
			this.xImagen = 0;
			this.yImagen = 569;
		break;
		case 5:
			this.altoTile = 70;
			this.anchoTile = 70;
			this.xImagen = 71;
			this.yImagen = 712;
		break;
		case 6:
			this.altoTile = 69;
			this.anchoTile = 70;
			this.xImagen = 0;
			this.yImagen = 641;
			break;
		case 7:
			this.altoTile = 70;
			this.anchoTile = 70;
			this.xImagen = 212;
			this.yImagen = 497;
		break;
		case 8:
			this.altoTile = 70;
			this.anchoTile = 68;
			this.xImagen = 69;
			this.yImagen = 639;
		break;
		case 9:
			this.altoTile = 70;
			this.anchoTile = 70;
			this.xImagen = 781;
			this.yImagen = 425;
		break;
		case 10:
			this.altoTile = 70;
			this.anchoTile = 70;
			this.xImagen = 0;
			this.yImagen = 710;
		break;
		case 11:
			this.altoTile = 70;
			this.anchoTile = 70;
			this.xImagen = 68;
			this.yImagen = 710;
		break;
		
		}
		
		
	}

	public int getAltoImagen() {
		return altoImagen;
	}

	public void setAltoImagen(int altoImagen) {
		this.altoImagen = altoImagen;
	}

	public int getAnchoImagen() {
		return anchoImagen;
	}

	public void setAnchoImagen(int anchoImagen) {
		this.anchoImagen = anchoImagen;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAnchoTile() {
		return anchoTile;
	}

	public void setAnchoTile(int anchoTile) {
		this.anchoTile = anchoTile;
	}

	public int getAltoTile() {
		return altoTile;
	}

	public void setAltoTile(int altoTile) {
		this.altoTile = altoTile;
	}

	public int getxImagen() {
		return xImagen;
	}

	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}

	public int getyImagen() {
		return yImagen;
	}

	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
	}

	public String getIndiceImagen() {
		return indiceImagen;
	}

	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void pintar(GraphicsContext graficos) {
		
		graficos.drawImage(
			Juego.pisos.get(this.indiceImagen), 
			this.xImagen, this.yImagen, 
			this.anchoTile, this.altoTile, 
			this.y-=4, this.x, 
			this.anchoTile, this.altoTile
			//this.x=x-5,
		);
	}
	
}
