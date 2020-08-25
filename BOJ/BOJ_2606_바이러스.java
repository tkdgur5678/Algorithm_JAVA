

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2606_바이러스 {

	static int N, M, result;
	static int[][] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		result = 0;
		N = sc.nextInt(); // 컴퓨터 수
		M = sc.nextInt(); // 컴퓨터 쌍의 수
		graph = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		bfs(1);
		System.out.println(result);
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;
		q.add(start);
		while (!q.isEmpty()) {
			Integer n = q.poll();
			for (int i = 1; i < N + 1; i++) {
				if (!visited[i] && graph[n][i] == 1) {
					q.add(i);
					visited[i] = true;
					result++;
				}
			}
		}
	}

}
