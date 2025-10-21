package camino_santiago;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Camino {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Barca barca = new Barca();
		System.out.print("Introduce la cantidad de Peregrinos: ");
		int numPeregrinos = sc.nextInt();
		List<Peregrino> listaPeregrinos = new ArrayList<>();
		for (int i = 1; i <= numPeregrinos; i++)
			listaPeregrinos.add(new Peregrino(i, barca));
		Barquero barquero = new Barquero(barca, listaPeregrinos.size());

		barquero.start();
		for (Peregrino peregrino : listaPeregrinos)
			peregrino.start();

		try {
			barquero.join();
			for (Peregrino peregrino : listaPeregrinos)
				peregrino.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sc.close();
		System.out.println("FIN PROGRAMA");
	}
}
