package wuboyang;

import java.util.*;

public class P3 {

	class QueueItem {
		List<Integer> list;
		int cur;

		public QueueItem(List<Integer> list, int cur) {
			// TODO Auto-generated constructor stub
			this.list = list;
			this.cur = cur;
		}

		public int getCur() {
			if (cur >= 0 && cur < list.size()) {
				return list.get(cur);
			}
			return Integer.MIN_VALUE;
		}

		public boolean hasNext() {
			return cur < list.size() - 1;
		}
	}

	List<Integer> kcombine(List<List<Integer>> klist) {
		List<Integer> result = new ArrayList<>();
		if (klist == null || klist.size() == 0) {
			return result;
		}
		PriorityQueue<QueueItem> queue = new PriorityQueue<>(klist.size(), new Comparator<QueueItem>() {

			@Override
			public int compare(QueueItem o1, QueueItem o2) {
				int v1 = o1.getCur();
				int v2 = o2.getCur();
				if (v1 > v2) {
					return 1;
				} else if (v1 == v2) {
					return 0;
				} else {
					return -1;
				}
			}
		});

		for (List<Integer> list : klist) {
			if (list.size() > 0) {
				queue.add(new QueueItem(list, 0));
			}
		}

		while (!queue.isEmpty()) {
			QueueItem queueItem = queue.poll();
			result.add(queueItem.getCur());
			if (queueItem.hasNext()) {
				queueItem.cur += 1;
				queue.add(queueItem);
			}
		}

		return result;
	}

	private void run() {
		Integer[] a = { 1, 2, 6, 7 };
		Integer[] b = { 1, 3, 6, 8, 9 };
		Integer[] c = { 2, 8, 9 };
		List<List<Integer>> klist = new ArrayList<>();
		klist.add(Arrays.asList(a));
		klist.add(Arrays.asList(b));
		klist.add(Arrays.asList(c));
		List<Integer> r = kcombine(klist);
		for (Integer i : r) {
			System.out.print(i + " ");
		}
	}
	
//	public static void main(String args[]) {
//		new P3().run();
//	}

}
