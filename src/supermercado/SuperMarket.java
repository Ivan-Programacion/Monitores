package supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuperMarket {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Número de clientes (escribe uan cantidad): ");
		int M = sc.nextInt();
		System.out.print("Número de cajas (escribe uan cantidad): ");
		int N = sc.nextInt();

		// Creación listas clientes y cajas
		List<Caja> listaCajas = new ArrayList<>();
		List<Cliente> listaClientes = new ArrayList<>();
		// Creación cajas
		Caja.numCajasTotales = N;
		for (int i = 1; i <= N; i++)
			listaCajas.add(new Caja(i));
		// Creación clientes
		for (int i = 1; i <= M; i++)
			listaClientes.add(new Cliente(i, listaCajas));
		// Arrancamos hilos
		for (Cliente cliente : listaClientes)
			cliente.start();
		// Hacemos join de todos
		try {
			for (Cliente cliente : listaClientes)
				cliente.join();
		} catch (InterruptedException e) {
			System.err.println("ERROR: desde SuperMarket");
//				e.printStackTrace();
		}
		System.out.println("Supermercado cerrado");
		System.out.println("Ganancias totales: " + Caja.resultado + "€");
		// REALIZAR OPERACIONES
	}

}
