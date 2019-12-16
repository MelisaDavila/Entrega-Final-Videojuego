package clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends ElementosGenerales{

	private int puntuacion = 0;
	private int salto=0;
	private HashMap<String, Animacion> animaciones;
	public static String animacionActual;
	
	
	
	public JugadorAnimado(int x, int y, int xImagen, int yImagen, int altoImagen, int anchoImagen, int velocidad,
			String indiceImagen, String animacionActualC) {
		super(x, y, xImagen, yImagen, altoImagen, anchoImagen, velocidad, indiceImagen);
		animacionActual=animacionActualC;
		inicializarAnimaciones();
	}



	public  int getX() {
		return x;
	}

	public  void setX(int x) {
		this.x = x;
	}

	public  int getY() {
		return y;
	}

	public  void setY(int y) {
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

	public int getAnchoImagen() {
		return anchoImagen;
	}

	public void setAnchoImagen(int anchoImagen) {
		this.anchoImagen = anchoImagen;
	}

	public int getAltoImagen() {
		return altoImagen;
	}

	public void setAltoImagen(int altoImagen) {
		this.altoImagen = altoImagen;
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

	public HashMap<String, Animacion> getAnimaciones() {
		return animaciones;
	}
	
	public String getAnimacionActual() {
		return animacionActual;
	}


	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	

	//Obtener las coordenas del fragmento de la imagen a pintar
	public void actualizarAnimacionPersonaje(double t) {
		System.out.println("T es ="+t+"AnAC"+animacionActual);
		
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	
	
	public void saltar() {
		
		
	}
	
	public void correr() {
		
		
	}
		
	
	public void pintar(GraphicsContext graficos) {
		graficos.strokeText("Puntuacion "+ puntuacion, 55, 100);
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
		
		if(animacionActual=="salto") {
			
			if(y==440)
				salto=0;
			
						if(salto<=120) {
							y-=7;
							salto+=6 ;
						}else if(salto<=252) {
							y+=7;
							salto+=6;
							if(salto==252) {
								salto=0;
								animacionActual="correr";
							}
						}
			
		}
	
}
	
	
	/*public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen );
	
	}*/
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x+3, this.y+9, 80, 8);
	}
	
	public void inicializarAnimaciones() {
			//coordenadas
			animaciones = new HashMap<String, Animacion>();
			
			Rectangle coordenadasCorrer[]= {
					new Rectangle(315,107, 44,78),
					new Rectangle(358,103, 46,83),
					new Rectangle(406,103, 52,81),
					new Rectangle(461,109, 49,77),
					new Rectangle(511,102, 46,86),
					new Rectangle(560,104, 48,82)
					
			};
			
			Animacion animacionCorrer = new Animacion("correr", coordenadasCorrer, 0.1);
			animaciones.put("correr",animacionCorrer);
			
			//coordenadas
			Rectangle coordenadasSalto[] = {
					new Rectangle(36,307,52,81),
					new Rectangle(84,295,48,88),
					new Rectangle(126,279,56,79),
					new Rectangle(176,292,54,79),
					new Rectangle(176,292,54,79),
					new Rectangle(231,303,50,82),
					new Rectangle(278,308,48,81)
				//	new Rectangle(x, y, tamx, tamy),
					
			};
			Animacion animacionSalto = new Animacion("salto", coordenadasSalto, 0.1);
			animaciones.put("salto",animacionSalto);
			
	}
	
	public void verificarColisionesMoneda(ItemAnimado item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
				if (!item.isCapturado()) { 
					puntuacion++;	
				}
				item.setCapturado(true);
				
		}
	
		
		
	}

	public void verificarColisionesObstaculo(TileObstaculo Obstaculo) {
		if (this.obtenerRectangulo().intersects(Obstaculo.obtenerRectangulo().getBoundsInLocal())) {
				if (!Obstaculo.isCapturado())
					//System.out.println("Estan colicionando");
				    Obstaculo.setCapturado(true);
					System.exit(0);
		}

	}
	public void mover() {
		 
		if(x>100)
			x=100;
		
		if(Juego.arriba) {
			animacionActual="salto";
		}
	}
	public void verificarColisiones(TileObstaculo obstaculos) {
		if (this.obtenerRectangulo().intersects(obstaculos.obtenerRectangulo().getBoundsInLocal())) {
				if (!obstaculos.isCapturado())
					Juego.vidas-=1;
				obstaculos.setCapturado(true);
				try {
					BufferedWriter archivo = new BufferedWriter(new FileWriter("Jugadores.csv",true));
					archivo.write(Juego.puntuacion + "," + Juego.nombreJugador + "\n");
					archivo.flush();
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(Juego.vidas==0)
					System.exit(0);
		}

	}



	public void verificarColisionesObstaculo(Image image) {
		// TODO Auto-generated method stub
		
	}



}
