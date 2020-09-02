import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2660_회장뽑기 {

	static int N;
	static int[][] graph;
	static int[] value;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = new int[N + 1][N + 1];
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == -1 && b == -1) {
				break;
			}
			graph[a][b] = graph[b][a] = 1;
		}
		value = new int[N + 1]; // 친구 수
		int minValue = Integer.MAX_VALUE;
		for (int i = 1; i < N + 1; i++) {
			bfs(i);
			minValue = Math.min(minValue, value[i]);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(minValue).append(" ");
		int count = 0;
		String str = "";
		for (int i = 1; i < N + 1; i++) {
			if (value[i] == minValue) {
				count++;
				str += i + " ";
			}
		}
		sb.append(count).append("\n").append(str);
		System.out.println(sb);
	}

	static void bfs(int start) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		q.add(new Node(start, 0));
		visited[start] = true;
		int max = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 1; i < N + 1; i++) {
				if (graph[node.x][i] == 1 && !visited[i]) {
					q.add(new Node(i, node.depth + 1));
					max = Math.max(max, node.depth + 1);
					visited[i] = true;
				}
			}
		}
		value[start] = max;
	}

	static class Node {
		int x, depth;

		public Node(int x, int depth) {
			this.x = x;
			this.depth = depth;
		}

	}
}
