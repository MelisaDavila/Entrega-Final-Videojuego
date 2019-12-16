package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class ItemAnimado extends ElementosGenerales{
	
	private int ancho;
	private int alto;
	private boolean capturado;
	public static String animacionActual;
	private HashMap<String, Animacion> animacionesobjetos;

		
	public ItemAnimado(int x, int y, int anchoImagen, int altoImagen, String indiceImagen, int velocidad, String animacionActualC, int yImagen, int xImagen) {
		super(x, y, xImagen, yImagen, altoImagen, anchoImagen, velocidad, indiceImagen);
		this.x = x;
		this.y = y;
		animacionActual=animacionActualC;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		inicializarAnimaciones();
	}
	
	public ItemAnimado(int x, int y, int xImagen, int yImagen, int altoImagen, int anchoImagen, int velocidad,
			String indiceImagen, int ancho, int alto, boolean capturado,
		String animacionActual) {
		super(x, y, xImagen, yImagen, altoImagen, anchoImagen, velocidad, indiceImagen);

		
	}

	

	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animacionesobjetos.get(animacionActual).calcularFrame2(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
		//System.out.println("Xim: "+this.xImagen+"/"+"Yim: "+this.yImagen+"/"+"Ancho: "+this.anchoImagen+"/"+"Alto: "+this.altoImagen+"/");
	}
	
	public void inicializarAnimaciones() {
		animacionesobjetos = new HashMap<String, Animacion>();	
		Rectangle coordenadasmoneda[]= {
				new Rectangle(0, 0, 32, 32),
				new Rectangle(32, 0, 32, 32),
				new Rectangle(32*2, 0, 32, 32),
				new Rectangle(32*3, 0, 32, 32),
				new Rectangle(32*4, 0, 32, 32),
				new Rectangle(32*5, 0, 32, 32),
				new Rectangle(32*6, 0, 32, 32),
				new Rectangle(32*7, 0, 32, 32),
				new Rectangle(32*8, 0, 32, 32),
				new Rectangle(32*9, 0, 32, 32),
		};
		
		Animacion animacionmoneda = new Animacion("moneda", coordenadasmoneda, 0.09);
		animacionesobjetos.put("moneda", animacionmoneda);
		
		
};
		
	


	
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

	public String getIndiceImagen() {
		return indiceImagen;
	}

	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int _velocidad) {
		velocidad = _velocidad;
	}

	
	

	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	
	public static String getAnimacionActual() {
		return animacionActual;
	}

	public static void setAnimacionActual(String animacionActual) {
		ItemAnimado.animacionActual = animacionActual;
	}
	
	public HashMap<String, Animacion> getAnimacionesC() {
		return animacionesobjetos;
	}

	public void setAnimacionesC(HashMap<String, Animacion> animacionesC) {
		this.animacionesobjetos = animacionesC;
	}
	
	
	public void pintar(GraphicsContext graficos) {
		if (!capturado)
			graficos.drawImage(
					Juego.imagenes.get(this.indiceImagen), 
					this.xImagen, this.yImagen, 
					this.anchoImagen, this.altoImagen,
					this.x=x-velocidad, this.y,
					this.anchoImagen, this.altoImagen
			);
		//graficos.fillRect(this.x+3, this.y+9, 18, 18);
	}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x+3, this.y+9, 18, 18);
	}
}
