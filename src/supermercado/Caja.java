package supermercado;

public class Caja {

	static int numCajasTotales;
	private static int resultado;
	private int numCaja;
	private int cliente;
	private int dinero;
	private boolean disponible;

	public Caja(int numCaja) {
		this.numCaja = numCaja;
		cliente = 0;
		dinero = 0;
		disponible = true;
		resultado = 0;
	}

	public synchronized void atender(int cliente) {
		disponible = false;
		System.out.println("Cliente " + cliente + " siendo atendido en Caja " + numCaja);
	}

	public synchronized void terminar(int cliente) {
		System.out.println("Cliente " + cliente + " ha terminado en Caja " + numCaja);
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
