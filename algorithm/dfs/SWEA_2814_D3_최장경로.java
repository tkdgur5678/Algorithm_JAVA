import java.util.Scanner;

public class SWEA_2814_D3_최장경로 {

	public static int result = 0;
	public static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			boolean[][] node = new boolean[N + 1][N + 1];
			boolean[] visited = new boolean[N + 1];
			result = 0;
			for (int i = 0; i < M; i++) { // a to b node
				int a = sc.nextInt();
				int b = sc.nextInt();
				node[a][b] = true;
				node[b][a] = true;
			}
			for (int i = 1; i <= N; i++) {
				visited[i] = true;
				dfs(i, 1, visited, node);
				visited[i] = false;
			}
			System.out.println("#" + test_case + " " + (result));
		}
	}

	public static void dfs(int idx, int depth, boolean[] visited, boolean[][] node) {
		if (result < depth) {
			result = depth;
		}
		for (int i = 1; i <= N; i++) {
			if (node[idx][i] && !visited[i]) { // idx정점에서 갈곳이 있으면서 i가 방문하지 않았다면
				visited[i] = true;
				dfs(i, depth + 1, visited, node);
				visited[i] = false;
			}
		}
	}

}
