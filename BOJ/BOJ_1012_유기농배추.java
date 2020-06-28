import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1012_유기농배추 {
	static int N, M, K, result;
	static int[][] map, dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;

	static boolean isIn(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<Node>();
		visited[y][x] = true;
		q.add(new Node(y, x));

		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int d = 0; d < dirs.length; d++) {
				int ny = n.y + dirs[d][0];
				int nx = n.x + dirs[d][1];
				if(isIn(ny,nx) && map[ny][nx] == 1 && !visited[ny][nx]) {
					q.add(new Node(ny,nx));
					visited[ny][nx] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			M = sc.nextInt(); // 가로 1~50
			N = sc.nextInt(); // 세로 1~50
			K = sc.nextInt(); // 배추 개수 1~2500
			result = 0;

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				map[i] = new int[M];
			}

			// map에 배추 위치 넣어주가
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
			}

			// bfs 전체 탐색
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (map[y][x] == 1 && !visited[y][x]) {
						bfs(y, x);
						result++;
					}
				}
			}

			System.out.println(result);
		}
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
