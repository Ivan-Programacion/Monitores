package camino_santiago;

public class Barca {

	private boolean disponible;
	private int numPeregrino;

	public Barca() {
		disponible = true;
		numPeregrino = 0;
	}

	public synchronized void subir(int numPeregrino) throws InterruptedException {
		disponible = false;
		this.numPeregrino = numPeregrino;
		System.out.println("Peregrino " + numPeregrino + " HA SUBIDO en la barca.");
		notifyAll();
		wait();

	}

	public synchronized void espera(int numPeregrino) throws InterruptedException {
		System.out.println("Peregrino " + numPeregrino + " ESPERANDO a la barca...");
		wait();
	}

	public synchronized void esperaBarquero(int numTotalPeregrinos) throws InterruptedException {
		if (numTotalPeregrinos > 0) {
			System.out.println("Barquero ESPERANDO...");
			notifyAll();
			wait();
		}
	}

	public synchronized void ida() {
		System.out.println("Peregrino " + numPeregrino + " dirección SANTIAGO...");
		numPeregrino = 0;
		notifyAll();
	}

	public synchronized void vuelta() {
		disponible = true;
	}

	public synchronized boolean isDisponible() {
		return disponible;
	}

	public synchronized int getNumPeregrino() {
		return numPeregrino;
	}

}
