import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11724_연결요소의개수 {

	static int[][] graph;
	static int N, M;
	static boolean[] visited;

	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			for (int i = 1; i < N; i++) {
				if(graph[node][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt() + 1;
		M = sc.nextInt();
		graph = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new int[N];
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		int count = 0;
		for (int i = 1; i < N; i++) {
			if(!visited[i]) {
				bfs(i);
				count++;
			}
		}
		System.out.println(count);
	}

}
