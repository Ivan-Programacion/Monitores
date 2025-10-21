package camino_santiago;

import java.util.Random;

public class Peregrino extends Thread {

	private int numPeregrino;
	private Barca barca;

	public Peregrino(int numPeregrino, Barca barca) {
		this.numPeregrino = numPeregrino;
		this.barca = barca;
	}

	public void run() {
		try {
			tiempoALago();
			while (!barca.isDisponible())
				barca.espera(numPeregrino);
			barca.subir(numPeregrino);
			tiempoASantiago();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	private void tiempoALago() throws InterruptedException {
		Thread.sleep(tiempoAleatorio(0));
		System.out.println("Peregrino " + numPeregrino + " ha llegado al LAGO.");
	}

	private void tiempoASantiago() throws InterruptedException {
		Thread.sleep(tiempoAleatorio(1));
		System.out.println("Peregrino " + numPeregrino + " HA LLEGADO A SANTIAGO!!");
	}

	private int tiempoAleatorio(int opcion) {
		Random tiempo = new Random();
		if (opcion == 0) {
			return tiempo.nextInt(3001) + 1000; // Entre 1000 milésimas y 4000 milésimas
		} else
			return tiempo.nextInt(501) + 500; // Entre 500 milésimas y 1000 milésimas
	}

}
