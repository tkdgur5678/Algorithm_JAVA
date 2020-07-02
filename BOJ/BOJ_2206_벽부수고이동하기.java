import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2206_벽부수고이동하기 {
	static char[][] map;
	static int[][][] visited;
	static int N, M;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static boolean isIn(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 1));
		visited[0][0][1] = 1;

		while (!q.isEmpty()) {
			Node n = q.poll();

			if (n.y == N - 1 && n.x == M - 1) {
				return visited[n.y][n.x][n.b];
			}
			for (int d = 0; d < dirs.length; d++) {
				int ny = n.y + dirs[d][0];
				int nx = n.x + dirs[d][1];

				if (isIn(ny, nx)) {
					if (map[ny][nx] == '1' && n.b == 1) {
						visited[ny][nx][n.b - 1] = visited[n.y][n.x][n.b] + 1;
						q.add(new Node(ny, nx, n.b - 1));
					} else if (map[ny][nx] == '0' && visited[ny][nx][n.b] == 0) {
						visited[ny][nx][n.b] = visited[n.y][n.x][n.b] + 1;
						q.add(new Node(ny, nx, n.b));
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}
		visited = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			visited[i] = new int[M][2];
			for (int j = 0; j < M; j++) {
				visited[i][j] = new int[2];
			}
		}

		System.out.println(bfs());
	}

	static class Node {
		int y;
		int x;
		int b;

		public Node(int y, int x, int b) {
			this.y = y;
			this.x = x;
			this.b = b;
		}
	}
}
