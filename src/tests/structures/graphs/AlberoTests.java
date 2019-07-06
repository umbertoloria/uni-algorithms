package tests.structures.graphs;

import structures.AlberoRadicato;

public class AlberoTests {

	public static void main(String[] args) {
		AlberoRadicato<String, Integer> tree = new AlberoRadicato<>();
		tree.addRoot("A");
		tree.addChild("A", "B", null);
		tree.addChild("A", "C", null);
		tree.addChild("A", "D", null);
		tree.addChild("D", "E", null);
		tree.addChild("C", "F", null);
		tree.addChild("B", "G", null);
		tree.addChild("E", "HE", null);
		tree.addChild("E", "HO", null);
		tree.show();
		System.out.println("A " + (tree.exists("A") ? "" : "doesn't ") + "exists");
		System.out.println("Archi: " + tree.edges());
	}

}
