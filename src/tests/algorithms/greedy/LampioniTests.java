package tests.algorithms.greedy;

import algorithms.greedy.Lampioni;
import structures.LList;
import structures.List;

public class LampioniTests {

	public static void main(String[] args) {
		int raggio = 3;
		LList<Integer> villette = new LList<>();
		villette.append(1);
		villette.append(6);
		villette.append(7);
		villette.append(8);
		villette.append(19);
		villette.append(25);
		int max = 25;

		StringBuilder casette = new StringBuilder(" ".repeat(max));
		for (Integer villetta : villette) {
			casette.replace(villetta, villetta + 1, "k");
		}
		System.out.println(casette);

		StringBuilder lampioncini = new StringBuilder(" ".repeat(max + raggio * 2));
		List<Integer> lamps = Lampioni.minimi(villette, raggio * 2 + 1);
		String zone = "-".repeat(raggio) + "T" + "-".repeat(raggio);
		for (Integer centroLampione : lamps) {
			lampioncini.replace(centroLampione - raggio, centroLampione + raggio + 1, zone);
		}
		System.out.println(lampioncini);
	}

}
