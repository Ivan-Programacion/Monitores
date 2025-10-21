package camino_santiago;

public class Barquero extends Thread {

	private Barca barca;
	private int numTotalPeregrinos;

	public Barquero(Barca barca, int numTotalPeregrinos) {
		this.barca = barca;
		this.numTotalPeregrinos = numTotalPeregrinos;
	}

	public void run() {
		try {
			while (numTotalPeregrinos > 0) {
				barca.esperaBarquero(numTotalPeregrinos);
				if (!barca.isDisponible()) {
					viajeIda();
					numTotalPeregrinos--;
					viajeVuelta();
					barca.esperaBarquero(numTotalPeregrinos);
				}
				System.out.println("Barquero TERMINANDO JORNADA");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	private void viajeIda() throws InterruptedException {
		System.out.println("Barca en marcha");
		System.out.println("Barquero realizando viaje LAGO -> SANTIAGO");
		tiempoIda();
		System.out.println("Barca en SANTIAGO");
		barca.ida();
	}

	private void viajeVuelta() throws InterruptedException {
		System.out.println("Barca en marcha");
		System.out.println("Barquero realizando viaje SANTIAGO -> LAGO");
		tiempoVuelta();
		System.out.println("Barca en LAGO");
		barca.vuelta();
	}

	private void tiempoVuelta() throws InterruptedException {
		Thread.sleep(100);
	}

	private void tiempoIda() throws InterruptedException {
		Thread.sleep(500);
	}
}
