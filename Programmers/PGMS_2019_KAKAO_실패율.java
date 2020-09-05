import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Node> list = new ArrayList<>();
		Arrays.sort(stages);

		int num = 1;
		while (num <= N) {
			int total = 0;
			int stay = 0;
			for (int i = 0; i < stages.length; i++) {
				if (stages[i] < num) {
					continue;
				}
				if (stages[i] >= num) {
					total++;
				}
				if (stages[i] == num) {
					stay++;
				}
			}
			double rate;
			if (stay == 0) {
				rate = 0;
			} else {
				rate = (double) stay / total;
			}
			list.add(new Node(num, rate));
			num++;
		}

		Collections.sort(list);
		int[] answer = new int[N];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).num;
		}
        return answer;
    }
    
    static class Node implements Comparable<Node> {
		int num;
		double rate;

		public Node(int num, double rate) {
			this.num = num;
			this.rate = rate;
		}

		@Override
		public int compareTo(Node o) {
			if(this.rate == o.rate) {
				return Integer.compare(this.num, o.num);
			} else {
				return Double.compare(this.rate, o.rate) * -1;
			}
		}
	}
}
