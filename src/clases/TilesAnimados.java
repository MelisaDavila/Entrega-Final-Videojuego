package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class TilesAnimados {
	
	public static HashMap<String, Animacion> animaciones;
	private int x;
	private int y;
	private int xImagen;
	private int yImagen;
	private int altoImagen;
	private int anchoImagen;
	private int velocidad;
	private String indiceImagen;
	private int puntuacion;
	

		
		public TilesAnimados(String indiceHashMap, int x, int y, String indiceImagen, int velocidad) {
			this.x = x;
			this.y = y;
			this.indiceImagen = indiceImagen;
			this.velocidad = velocidad;
			
		}
		
		public int getPuntuacion() {
			return puntuacion;
		}

		public void setPuntuacion(int puntuacion) {
			this.puntuacion = puntuacion;
		}
		public int getVelocidad() {
			return velocidad;
		}
		public void setVelocidad(int velocidad) {
			this.velocidad = velocidad;
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
		public String getIndiceImagen() {
			return indiceImagen;
		}
		public void setIndiceImagen(String indiceImagen) {
			this.indiceImagen = indiceImagen;
		}
		
		//Obtener las coordenas del fragmento de la imagen a pintar
		public void actualizarAnimacionTile(double t) {
			Object animacionActual = null;
			Rectangle coordenadasActuales = TilesAnimados.animaciones.get(animacionActual).calcularFrame(t);
			this.xImagen = (int)coordenadasActuales.getX();
			this.yImagen = (int)coordenadasActuales.getY();
			this.anchoImagen = (int)coordenadasActuales.getWidth();
			this.altoImagen = (int)coordenadasActuales.getHeight();
		}
		
		public void pintar(GraphicsContext graficos) {
			graficos.drawImage(
					Juego.imagenes.get(this.indiceImagen), 
					this.xImagen, this.yImagen, 
					this.anchoImagen, this.altoImagen,
					this.x=x-velocidad, this.y,
					this.anchoImagen, this.altoImagen
			);
			//graficos.fillRect(this.x, this.y, this.anchoImagen, this.altoImagen);
		}
		
		public Rectangle obtenerRectangulo() {
			return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
		}
		
		public void inicializarAnimaciones() {
			
				
};
		
			
		public void verificarColisiones(ItemAnimado item) {
			if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
					//System.out.println("Estan colisionando");
					if (!item.isCapturado())
						this.puntuacion++;
					item.setCapturado(true);				
			}
		}
}
