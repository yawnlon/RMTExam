package wuboyang;

import java.util.Arrays;

public class P5 {
	int[] getOptimal(int[] a, int n) {
		int length = a.length;
		if (length < 3) {
			return null;
		}
		int[] result = new int[3];
		Arrays.sort(a);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length - 2; i++) {
			int l = i + 1, r = length - 1;
			while (l < r) {
				int s = a[i] + a[l] + a[r];
				if (s < n) {
					l += 1;
				} else if (s > n) {
					r -= 1;
				}
				if (Math.abs(n - s) <= min) {
					min = Math.abs(n - s);
					result[0] = a[i];
					result[1] = a[l];
					result[2] = a[r];
				}
			}
		}
		return result;
	}
}
