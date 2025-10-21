package supermercado;

import java.util.List;
import java.util.Random;

public class Cliente extends Thread {

	private int cliente;
	private final List<Caja> LISTA_CAJAS;
	private Caja caja;

	public Cliente(int cliente, List<Caja> listaCajas) {
		this.cliente = cliente;
		this.LISTA_CAJAS = listaCajas;
	}

	public void run() {
		System.out.println("Cliente " + cliente + " realizando compra");
		try {
			for (int i = 0; i < LISTA_CAJAS.size(); i++) {
				caja = LISTA_CAJAS.get(i);
				if (caja.isDisponible()) {
					caja.atender(cliente);
					Thread.sleep(tiempoRandom());
					caja.terminar(cliente, pagar());
					i = LISTA_CAJAS.size() - 1;
				} else if (i == LISTA_CAJAS.size() - 1) {
					caja.esperar(cliente);
					i = -1;
				}
			}
		} catch (InterruptedException e) {
			System.err.println("ERROR: sleep en hilo " + cliente);
//					e.printStackTrace();
		}
	}

	private int tiempoRandom() {
		Random numRandom = new Random();
		return numRandom.nextInt(2000) + 1;
	}
	
	private int pagar() {
		Random numRandom = new Random();
		return numRandom.nextInt(250) + 1;
	}
}
