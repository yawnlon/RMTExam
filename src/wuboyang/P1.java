package wuboyang;

import java.util.ArrayList;
import java.util.List;

public class P1 {
	class Mapping {
		private int bIndex;
		private int aIndex;
		private int value;

		public Mapping(int b, int a, int v) {
			// TODO Auto-generated constructor stub
			bIndex = b;
			aIndex = a;
			value = v;
		}
	};

	public List<Mapping> genMapping(int[] a, int[] b) {
		int la = a.length;
		int lb = b.length;
		List<Mapping> result = new ArrayList<>();
		int i = 0, j = 0;
		while (i < la && j < lb) {
			if (b[j] < a[i]) {
				result.add(new Mapping(j, i, b[j]));
				a[i] -= b[j];
				j += 1;
			} else if (b[j] > a[i]) {
				result.add(new Mapping(j, i, a[i]));
				b[j] -= a[i];
				i += 1;
			} else {
				result.add(new Mapping(j, i, a[i]));
				i += 1;
				j += 1;
			}
		}
		return result;
	}

	private void run() {
		int[] a = { 100, 100, 100, 100, 100, 100 };
		int[] b = { 20, 20, 80, 200, 180, 40, 60 };
		List<Mapping> r = genMapping(a, b);
		for (Mapping m : r) {
			System.out.println(m.bIndex + " " + m.aIndex + " " + m.value);
		}
	}
	
	public static void main(String args[]) {
		new P1().run();
	}

}
