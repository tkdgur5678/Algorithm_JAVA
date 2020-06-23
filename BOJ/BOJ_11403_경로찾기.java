import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {

	static int N;
	static int[][] graph, answer;

	static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		q.add(start);
		while(!q.isEmpty()) {
			int s = q.poll();
			for (int i = 0; i < N; i++) {
				// s to i
				if(s != i && graph[s][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.add(i);
					if(i == end) {
						answer[start][end] = 1;
						return;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			graph[i] = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 답을위한 그래프 공간
		answer = new int[N][N];
		for (int i = 0; i < N; i++) {
			answer[i] = new int[N];
		}
		// 모든 정점에서 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// dfs나 bfs로 탐색
				bfs(i,j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

}
