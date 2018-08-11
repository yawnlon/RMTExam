package wuboyang;

public class P6 {
	int minDistance(String word1, String word2) {
		int l1 = word1.length(), l2 = word2.length();
		int DP[][] = new int[l1 + 1][l2 + 1];
		for (int i = 0; i <= l1; i++) {
			DP[i][0] = i;
		}
		for (int j = 0; j <= l2; j++) {
			DP[0][j] = j;
		}
		for (int i = 0; i < l1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < l2; j++) {
				char c2 = word2.charAt(j);
				if (c1 == c2) {
					DP[i + 1][j + 1] = DP[i][j];
				} else {
					DP[i + 1][j + 1] = Math.min(DP[i + 1][j] + 1, Math.min(DP[i][j + 1] + 1, DP[i][j] + 1));
				}
			}
		}
		return DP[l1][l2];
	}
	private void run() {
		String word1 = "word1";
		String word2 = "word2";
		System.out.println(minDistance(word1, word2));
	}
	
//	public static void main(String args[]) {
//		new P6().run();
//	}
}
