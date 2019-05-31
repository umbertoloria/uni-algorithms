package tests.algorithms;

import algorithms.KClustering;
import structures.Edge;
import structures.List;
import structures.UndirectGraph;

public class KClusteringTests {

	private static class XY {

		final int x;
		final int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		double distance(XY o) {
			int xx = x - o.x;
			int yy = y - o.y;
			return Math.abs(Math.sqrt(xx * xx + yy * yy));
		}

		public String toString() {
			return String.format("[%2d %2d]", x, y);
		}

	}

	public static void main(String[] args) {

		XY[] dots = {
				new XY(1, 2),
				new XY(5, 4),
				new XY(-1, 2),
				new XY(-1, 5),
		};

		UndirectGraph<XY, Double> g = new UndirectGraph<>();

		for (XY dot : dots) {
			g.add(dot);
		}

		for (int i = 0; i < dots.length - 1; i++) {
			for (int j = i + 1; j < dots.length; j++) {
				g.link(new Edge<>(dots[i], dots[j], dots[i].distance(dots[j])));
			}
		}

		for (List<XY> xies : KClustering.cluster(g, 3)) {
			System.out.println(xies);
		}

	}

}
