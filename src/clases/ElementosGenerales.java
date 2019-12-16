package clases;

public abstract class  ElementosGenerales {

	 protected int x;
	 protected int y;
	 protected int xImagen;
	 protected int yImagen;
	 protected int altoImagen;
	 protected int anchoImagen;
	 protected int velocidad;
	 protected String indiceImagen;
	 
	public ElementosGenerales(int x, int y, int xImagen, int yImagen, int altoImagen, int anchoImagen, int velocidad,
			String indiceImagen) {
		super();
		this.x = x;
		this.y = y;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
		this.altoImagen = altoImagen;
		this.anchoImagen = anchoImagen;
		this.velocidad = velocidad;
		this.indiceImagen = indiceImagen;
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

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getIndiceImagen() {
		return indiceImagen;
	}

	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}

	@Override
	public String toString() {
		return "ElementosGenerales [x=" + x + ", y=" + y + ", xImagen=" + xImagen + ", yImagen=" + yImagen
				+ ", altoImagen=" + altoImagen + ", anchoImagen=" + anchoImagen + ", velocidad=" + velocidad
				+ ", indiceImagen=" + indiceImagen + "]";
	}
	 
	 
}
