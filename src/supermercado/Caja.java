package supermercado;

public class Caja {

	static int numCajasTotales;
	static int resultado;
	private int numCaja;
	private boolean disponible;

	public Caja(int numCaja) {
		this.numCaja = numCaja;
		disponible = true;
		resultado = 0;
	}

	public synchronized void atender(int cliente) {
		disponible = false;
		System.out.println("Cliente " + cliente + " siendo atendido en Caja " + numCaja);
	}

	public synchronized void terminar(int cliente, int pago) {
		System.out.println("Cliente " + cliente + " ha terminado en Caja " + numCaja + ". Ha pagado " + pago + "€");
		resultado += pago;
		disponible = true;
		notifyAll();
	}

	public synchronized void esperar(int cliente) throws InterruptedException {
		System.out.println("Cliente " + cliente + " en cola de espera");
		wait();
	}

	public int getNumCajasTotales() {
		return numCajasTotales;
	}

	public synchronized boolean isDisponible() {
		return disponible;
	}

}
