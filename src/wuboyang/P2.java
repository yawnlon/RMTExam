package wuboyang;

import java.util.*;

public class P2 {
	class Element {
		private int begin;
		private int length;
	};

	List<Element> getMaxSequence(String input) {
		List<Element> result = new ArrayList<>();
		int length = input.length();
		if (length > 0) {
			char last = input.charAt(0);
			int max = 1;
			int cur = 1;
			for (int i = 1; i < length; i++) {
				char c = input.charAt(i);
				if (i == length - 1 && c == last) {
					cur += 1;
					if (cur > max) {
						max = cur;
					}
					cur = 1;
				} else if (c == last) {
					cur += 1;
				} else {
					if (cur > max) {
						max = cur;
					}
					cur = 1;
				}
				last = c;
			}
			cur = 1;
			for (int i = 1; i < length; i++) {
				char c = input.charAt(i);
				if (i == length - 1 && c == last) {
					cur += 1;
					if (cur == max) {
						Element element = new Element();
						element.length = max;
						element.begin = i - max + 1;
						result.add(element);
					}
					cur = 1;
				} else if (c == last) {
					cur += 1;
				} else {
					if (cur == max) {
						Element element = new Element();
						element.length = max;
						element.begin = i - max;
						result.add(element);
					}
					cur = 1;
				}
				last = c;
			}
		}
		return result;
	}

	public void run() {
		String input = "abbcccdeeeadadadadasdddd";
		List<Element> list = getMaxSequence(input);
		for (Element element : list) {
			System.out.println(element.begin + " " + element.length);
		}
	}

//	public static void main(String args[]) {
//		new P2().run();
//	}

}
