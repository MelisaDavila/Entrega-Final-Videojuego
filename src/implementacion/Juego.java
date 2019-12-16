package implementacion;

import java.util.ArrayList;
import java.util.HashMap;

import clases.ItemAnimado;
import clases.JugadorAnimado;
import clases.Tile;
import clases.TileObstaculo;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Juego extends Application {

	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	private JugadorAnimado jugador;

	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	public static boolean saltar=false;
	public static boolean corriendo=false;
	public static HashMap<String, Image> imagenes;
	public static HashMap<String, Image> pisos;
	public static HashMap<String,Image> obstaculos;
	public static String puntuacion;
	public static int vidas;
	public static boolean accion;
	public static String nombreJugador;

	public ArrayList<Tile> tiles; 
	public ArrayList<ItemAnimado> monedas;
	public ArrayList<TileObstaculo> tunel;

	public int randomx;
	public int randomy;
	public int velocidad=4;
	
	public int terreno[][]= {
			
		
			{0,0,0,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,0,0,0,0,0,0,0,},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};
	
	public int planta [][] = {
		
			{0,0,0,0,0,1,0,0,3,0,0,0,2,0,0,3,0,0,1,0,0,1,0,0,0,0,0,0,0,0,3,0,0,3,0,2,0,2,0,0,0,0,0,1,0,0,0,0,1,0,0,3,0,0,0,0,0,1,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,1,0,0,3,0,0,0,2,0,0,3,0,0,1,0,0,1,0,0,0,0,0,0,0,0,3,0,0,3,0,2,0,2,0,0,0,0,0,1,0,0,0,0,1,0,0,3,0,0,0,0,0,1,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,1,0,0,3,0,0,0,2,0,0,3,0,0,1,0,0,1,0,0,0,0,0,0,0,0,3,0,0,3,0,2,0,2,0,0,0,0,0,1,0,0,0,0,1,0,0,3,0,0,0,0,0,1,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,1,0,0,3,0,0,0,2,0,0,3,0,0,1,0,0,1,0,0,0,0,0,0,0,0,3,0,0,3,0,2,0,2,0,0,0,0,0,1,0,0,0,0,1,0,0,3,0,0,0,0,0,1,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,1,0,0,3,0,0,0,2,0,0,3,0,0,1,0,0,1,0,0,0,0,0,0,0,0,3,0,0,3,0,2,0,2,0,0,0,0,0,1,0,0,0,0,1,0,0,3,0,0,0,0,0,1,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,1,0,0,3,0,0,0,2,0,0,3,0,0,1,0,0,1,0,0,0,0,0,0,0,0,3,0,0,3,0,2,0,2,0,0,0,0,0,1,0,0,0,0,1,0,0,3,0,0,0,0,0,1,0,0,3,0,0,00,0,0,0,0,0,0,0,0,0,},
			{0,0,0,0,0,1,0,0,3,0,0,0,2,0,0,3,0,0,1,0,0,1,0,0,0,0,0,0,0,0,3,0,0,3,0,2,0,2,0,0,0,0,0,1,0,0,0,0,1,0,0,3,0,0,0,0,0,1,0,0,3,0,0,0,2,0,0,3,0,0,1,0,0,1,0,0,0,0,0,0,0,0,3,0,0,3,0,2,0,2,0,0,0,0,0,1,0,0,0,0,1,0,0,3,0,0,0,0,0,1,0,0,3,0,0,0,2,0,0,3,0,0,1,0,0,1,0,0,0,0,0,0,0,0,3,0,0,3,0,2,0,2,0,0,0,0,0,1,0,0,0,0,1,0,0,3,0,0,0,0,0,1,0,0,3,0,0,0,2,0,0,3,0,0,1,0,0,1,0,0,0,0,0,0,0,0,3,0,0,3,0,2,0,2,0,0,0,0,0,1,0,0,0,0,1,0,0,3,0,0,0,0,0,1,0,0,3,0,0,0,2,0,0,3,0,0,1,0,0,1,0,0,0,0,0,0,0,0,3,0,0,3,0,2,0,2,0,0,0,0,0,1,0,0,0,0,1,0,0,3},
			
			
	};
	
	
	
	@Override
	public void start(Stage ventana) throws Exception {
		
		inicializarelementos();
		graficos= canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("MegaRobi");
		gestionareventos();
		ventana.show();
		cicloJuego();
		
	}

	public void inicializarelementos() {
		
		jugador = new JugadorAnimado(100,440,0,0,0,0,0,"MegaRobi","correr");
		root = new Group();
		escena = new Scene(root, 1000,600);
		canvas = new Canvas(1000,600);
		
		imagenes = new HashMap<String, Image>();
		monedas = new ArrayList<ItemAnimado>();
		pisos = new HashMap<String, Image>();
		obstaculos = new HashMap<String, Image>();
		
		
		
		cargarimagenes();
		cargarTiles();
		
	}
	
	public void cargarimagenes() {
		
		imagenes.put("MegaRobi", new Image("Humano.png"));
		pisos.put("Tiles", new Image("TileMap.png"));
		imagenes.put("Fondo", new Image("Fondo2.jpg"));
		imagenes.put("Moneda", new Image("Moneda.png"));
		obstaculos.put("Obstaculo", new Image("Obstaculo.png"));
		
	}
	
	public void pintar() {
		graficos.setFill(Color.WHITE);
		graficos.fillRect(0, 0, 1000, 600);
		graficos.setFill(Color.BLACK);
		graficos.drawImage(imagenes.get("Fondo"), 0, -50);
		jugador.pintar(graficos);
		
		for (int i=0; i<tiles.size(); i++) {
				tiles.get(i).pintar(graficos);
		}
		
		for (int i=0; i<tunel.size(); i++) {
			tunel.get(i).pintar(graficos);
		}
	
		for(int i=0; i<monedas.size(); i++) {
			monedas.get(i).pintar(graficos);
		}
		
		
	}
	
	
	public void cargarTiles() {
		
		tiles = new ArrayList<Tile>();
		for(int i=0; i<terreno.length; i++) {
			for(int j=0; j<terreno[i].length; j++) {
				if (terreno[i][j]!=0) {
					tiles.add(new Tile(terreno[i][j], i*67, j*67, "Tiles",0));
				
				}
			}
		}
		
		tunel = new ArrayList<TileObstaculo>();
		for(int i=0; i<planta.length; i++) {
			for(int j=0; j<planta[i].length; j++) {
				if (planta[i][j]!=0) {
					tunel.add(new TileObstaculo(planta[i][j], i*85, j*70, "Obstaculo",0));
				
				}
			}
		}
		
		for(int i=0; i<100; i++) {
			
			randomx=(int)(Math.random()*18000);
			randomy=(int)(Math.random()*(81)+360);
			monedas.add(new ItemAnimado(randomx,randomy,32,32,"Moneda",velocidad, "moneda",0,0));
			
		}
		
		
	}
	public void gestionareventos() {
		
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
			
				switch (evento.getCode().toString()) {
				case "RIGHT": //derecha
					derecha=true;
					//JugadorAnimado.animacionActual="saltar";
					break;
				case "LEFT": //derecha
					izquierda=true;
				break;
				case "UP":
					arriba=true;
					break;
				case "DOWN":
					abajo=true;
					break;
				case "SPACE":
				     jugador.setVelocidad(3);
					//jugador.setIndiceImagen("goku-furioso");
				     saltar=true;
					break;
					
				}
			}
				
		});
		
	
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			public void handle(KeyEvent evento) {
				switch (evento.getCode().toString()) {
		
			case "RIGHT": 
				derecha=false;
				break;
			case "LEFT": 
				izquierda=false;
			break;
			case "UP":
				arriba=false;
				break;
			case "DOWN":
				abajo=false;
				break;
			case "SPACE":
				//JugadorAnimado.setVelocidad(1000);
				break;
				}
			}
				
		});
		
	}
	
	
	public void cicloJuego() {
		
		long tiempoinicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de preciosos y bellos 60 FPS <3
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoinicial) / 1000000000.0;
				pintar();
				actualizar(t);
				
			}
			
		};
		animationTimer.start(); 
	}
	
	public void actualizar(double t) {
		
		jugador.saltar();
		jugador.correr();
		jugador.mover();
		
		for(int i=0; i<100; i++) {
			monedas.get(i).actualizarAnimacion(t);
		}
		
	//	for(int i=0;i<tunel.size();i++) {
		//	jugador.verificarColisionesObstaculo(tunel.get(i));
		//    tunel.get(i);
	//	}
		
		jugador.actualizarAnimacionPersonaje(t);
		
		for(int i=0; i<monedas.size(); i++) 
			jugador.verificarColisionesMoneda(monedas.get(i));
		
		
	  /* for(int i=0;i<obstaculos.size();i++) {
		  jugador.verificarColisionesObstaculo(obstaculos.get(i));
			
		}*/
	}
}

