package Objects;


import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Random;

/**
 * Construye la base del nivel que se mostrará en pantalla
 */

public class Level implements Drawable {
	private InvaderLine current;
	private InvaderLine next;
	private int speed, lvl;
	
	public Level(int lvl) {
		current = this.createNewLine();
		next = this.createNewLine();
		speed = 0;
		this.lvl = lvl;
	}

	/**
	 * Crea la clase enemiga a mostrar
	 * @return retornauna hilera de forma aleatoria
	 */
	public InvaderLine createNewLine() {
		Random rand = new Random();
		//La linea de abajo es la original y la que sirve
		//int index = rand.nextInt(6);
		//int index= rand.nextInt(7);
		int index=6;
		int size = 6;
		++speed;
		if(index == 0) {
			System.out.println("Clase Basic");
			return new Basic(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 1) {
			System.out.println("ClaseA");
			return new ClassA(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 2) {
			System.out.println("ClaseB");
			return new ClassB(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 3) {
			System.out.println("ClaseC");
			return new ClassC(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 4) {
			System.out.println("Clase D");
			return new ClassD(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 5) {
			System.out.println("Clase E");
			return new ClassE(280*3/2, -60, speed, size, this.lvl);
		}
		else if(index == 6) {
			System.out.println("Clase BST");
			try {
				return new BST(280 * 3 / 2, -60, speed, size, this.lvl);
			}catch (Exception e){e.printStackTrace();
				System.out.println("Error en el arbol BST");}
		}else {
			return new Basic(280*3/2, -60, speed, size, this.lvl);
		}
		return null;
	}

	public InvaderLine getCurrent() {
		return current;
	}
	
	public void nextLine() {
		current = next;
		next = this.createNewLine();
	}

	public int getSpeed() {
		return speed;
	}


	@Override
	public void draw(Graphics2D g) {
		this.current.draw(g);
	}

	@Override
	public void update(double delta) {
		// Si las siguientes clases no poseen ya el jefe, continue con la siguiente hilera
		if((current.getLineClass() == "ClassA" || current.getLineClass() == "ClassB" || current.getLineClass() == "ClassE") && !current.isHaveBoss()) {
			this.nextLine();
			return;
		} else if(current.getEnemies().size() == 0) {
			this.nextLine();
			return;
		}
		for(int i = 0; i < this.current.getEnemies().size(); i++) {
			if(current.getEnemies().get(i).getPosY() > 600) {
				this.nextLine();
				return;
			}
		}

		this.current.update(delta);
	}
}
