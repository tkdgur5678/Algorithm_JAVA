import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2644_촌수계산 {
	static int N, A, B, result;
	static int[][] graph;
	static boolean check;

	static void bfs(int a, int b) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		q.add(-1);
		boolean[] visited = new boolean[N];
		visited[a] = true;
		while (q.size()>1) {
			int n = q.poll();
			if(n==-1) {
				result++;
				q.add(-1);
				continue;
			}
			if (n == b) {
				check = true;
				return;
			}
			for (int i = 0; i < N; i++) {
				if (graph[n][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt() + 1;
		result = 0;
		check = false;
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			graph[i] = new int[N];
		}

		A = sc.nextInt();
		B = sc.nextInt();

		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		bfs(A, B);

		if (check) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}

	}
}
